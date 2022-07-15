package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes6.dex */
public class h17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public String c;
    public String d;
    public w17 e;
    public l17 f;

    public h17() {
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

    public void a(TopicDetail topicDetail) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, topicDetail) == null) || topicDetail == null) {
            return;
        }
        this.a = topicDetail.topic_id.longValue();
        this.b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.c = topicDetail.topic_image;
        this.d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        w17 w17Var = new w17();
        this.e = w17Var;
        w17Var.a = this.a;
        w17Var.f = 2;
        w17Var.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, timeLine) == null) || timeLine == null) {
            return;
        }
        l17 l17Var = new l17();
        this.f = l17Var;
        l17Var.a(this.a, timeLine);
    }
}
