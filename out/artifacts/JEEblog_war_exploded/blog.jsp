<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 06/05/2019
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href='blog.css' rel='stylesheet' type='text/css'>
<head>
    <title>Blog</title>
</head>
<section id="postIndex" class="widthWrapper">
    <article>
        <div class="post">
            <div class="postImg">
                <img src="http://sitechop.com/images/demos/speed-website.png" />
            </div>
            <h2>Speeding Up Your Website 101</h2>
            <p>It seems like only a select few, besides big companies and corporations, care about web page speed and performance. Browsing the web, it's common to see load times of 5 seconds and pages that weigh 4, 5, sometimes 10 megabytes! Even if that's not you, is your website optimized to its full potential? This post is not about stripping your page, its about optimizing everything so that your website loads as fast as possible.</p>
            <div class="wrapper">
                <div class="commentBoxfloat">
                    <form id="cmnt">
                        <fieldset>
                            <div class="form_grp">
                                <label>comment</label>
                                <textarea id="userCmnt" placeholder="Write your comment here. You can Edit and Delete options. Just Hover in Your comment, you see the both buttons"></textarea>
                            </div>
                            <div class="form_grp">
                                <button type="button" id="submit">Submit</button>
                            </div>
                        </fieldset>
                    </form>
                </div>

                <div id="cmntContr"></div>


            </div>
        </div>
    </article>
</section>
</html>
