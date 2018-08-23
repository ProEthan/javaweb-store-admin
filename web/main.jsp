<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <link rel="stylesheet" href="css/amazeui.min.css" />
    <link rel="stylesheet" href="css/pageStyle.css">

</head>
<body style="background:#f3f3f3;">

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">商品管理</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 新增</button>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" id="input_search">
                <span class="am-input-group-btn">
                    <button class="am-btn am-btn-default" type="button" id="input_search_btn">搜索</button>
                </span>
            </div>
        </div>
    </div>



</div>

<div class="goods_list">
    <ul class="title_ul">
        <li>序号</li>
        <li>商品图片</li>
        <li>商品名称</li>
        <li>商品价格</li>
        <li>编辑</li>
        <li>删除</li>
    </ul>

    <c:forEach items="${pageBean.getGoodsList()}" var="goods" varStatus="status" >
        <ul class="list_goods_ul">
            <li>${(pageBean.getCurrentPage()-1)*5+status.index+1}</li>
            <li><img src="images/pimages/${goods.image}" alt=""></li>
            <li>${goods.getName()}</li>
            <li>${goods.getPrice()}</li>
            <li><a href="GoodsServlet?id=${goods.getId()}&action=editUI"><img class="img_icon" src="images/edit_icon.png" alt=""></a></li>
            <li><a href="GoodsServlet?id=${goods.getId()}&action=delete"><img class="img_icon" src="images/delete_icon.png" alt=""></a></li>
        </ul>
    </c:forEach>

    <!--分页-->
    <div id="page" class="page_div">aaa</div>
</div>

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:${pageBean.getCurrentPage()},    // 当前页
        totalPage: ${pageBean.getTotalPage()},  // 共多少页
        totalSize: ${pageBean.getTotalCount()}, // 共多少条数据
        callback: function(num) {
            $(window).attr('location','GoodsServlet?action=getPageDate&currentPage='+num);
        }
    });

    $("#add").click(function () {
        $(window).attr('location','/GoodsServlet?action=addUI');
    });

</script>

</body>
</html>