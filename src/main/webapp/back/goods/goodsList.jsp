<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/backstyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });


            //全选全不选
            $("#all").change(function () {
                //获得全选框是否选中
                var all=$("#all").prop("checked");
                //表格中其他多选框也要和全选框一样效果
                $("input[name='ids']").prop("checked",all);

            });

            //删除多个端口信息
            $("#delGoods").click(function () {
                //声明一个变量存要删除的端口编号
                //var gidString="";
                //获得所有选中端口除了全选框
                var goodsObject= $("input:checked").not($("#all"));
                if(goodsObject.length>0){
                    var result=confirm("确定要删除吗?");
                    /*第一种:用数组传递直接删除*/
                    if(result){
                        //声明一个数组存要删除商品编号
                        var ids=new Array();
                        //遍历多选框的对象集合,i表示遍历集合中当前元素的索引,goods表示遍历集合中当前元素
                        goodsObject.each(function (i,goods) {
                            ids[i]= $(goods).val();
                        });

                        window.location="tGoodsInfo/delManyGoods.action?ids="+ids+"&currpage="+${page1.currPage};
                    alert("删除成功");
                }

                    //第二种删除:提交表单
                    //if(result){
                    //    $("#form1").submit();
                    //    alert("删除成功");
                    //}

                }else{
                    alert("你还没有选中,无法删除");
                }

            });

        });

        //分页
        function fenye(currpage1) {
            window.location="tGoodsInfo/findGoodsByPage.action?currpage="+currpage1;
        }

        //跳转页面
        function fenye2(){
            //获得当前页码
            var curr=document.getElementById("curr").value;
            //获得总页码
            var total=${page1.totalPage};
            //判断下整数的正则
            var r = /^\+?[1-9][0-9]*$/;　　//正整数
            if (!r.test(curr)||parseInt(curr)>parseInt(total)){
                alert("页码输入有误!");
            }else{
                window.location="tGoodsInfo/findGoodsByPage.action?currpage="+curr;
            }
        }

        //根据编号删除单个商品信息
        function delGoods(gid){
            var result=confirm("确定要删除当前这个商品吗?");
            if(result){
                window.location="tGoodsInfo/delGoodsById.action?gid="+gid+"&currpage="+${page1.currPage};
            }
        }
    </script>

</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">数据表</a></li>
        <li><a href="#">基本内容</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click"><a href="back/goods/goodsAdd.jsp"><img src="images/t01.png" align="middle" />添加</a></li>
            <li class="click"><span><img src="images/t02.png" /></span>修改</li>
            <li id="delGoods"><span><img src="images/t03.png" /></span>删除</li>
            <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>


        <ul class="toolbar1">
            <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>

    </div>

    <table class="tablelist" >
        <thead>
        <tr>
            <th><input name="all" id="all" type="checkbox" value="" /></th>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品描述</th>
            <th>商品图片</th>
            <th>单价</th>
            <th>操作</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="g" items="${goodsList}">
            <tr>
                <td><input name="ids" type="checkbox" value="${g.id}" /></td>
                <td>${g.id}</td>
                <td>${g.goodsName}</td>
                <td>${g.goodsDescription}</td>
                <td align="center"><img src="images/${g.goodsPic}" style="width: 120px;height: 90px;" align="middle"/></td>
                <td>${g.goodsPrice}</td>
                <td>
                    <a href="javaScript:void(0)" class="tablelink">编辑</a>
                    <a href="javaScript:void(0)" onclick="delGoods(${g.id})" class="tablelink"> 删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="7">
                <c:if test="${page1.currPage>1}">
                    <input type="button" value="上一页" onclick="fenye(${page1.currPage-1})"/>
                </c:if>
                当前是第${page1.currPage}页
                <c:if test="${page1.currPage<page1.totalPage}" >
                    <input type="button" value="下一页" onclick="fenye(${page1.currPage+1})"/>
                </c:if>
                <input type="text" id="curr"/><input type="button" value="跳转" onclick="fenye2()"/>
                总共${page1.totalPage}页
            </td>
        </tr>
        </tfoot>
    </table>

    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>

</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>



<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
