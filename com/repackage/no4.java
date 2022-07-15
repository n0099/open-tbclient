package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes6.dex */
public class no4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;

    public no4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.intValue;
    }

    public void c(ForumBookInfo forumBookInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumBookInfo) == null) || forumBookInfo == null) {
            return;
        }
        this.a = forumBookInfo.book_id;
        this.b = forumBookInfo.book_type.intValue();
        String str = forumBookInfo.book_title;
        String str2 = forumBookInfo.book_cover;
        String str3 = forumBookInfo.author;
        String str4 = forumBookInfo.forum_pic;
        String str5 = forumBookInfo.show_chapter_id;
        String str6 = forumBookInfo.show_chapter_no;
        String str7 = forumBookInfo.show_chapter_title;
        forumBookInfo.history_page_id.longValue();
        forumBookInfo.history_paragraph_id.longValue();
        forumBookInfo.history_word_id.longValue();
        forumBookInfo.history_percent.longValue();
        forumBookInfo.show_page_id.longValue();
        forumBookInfo.show_paragraph_id.longValue();
    }
}
