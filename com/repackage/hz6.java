package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.RelateThread;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicDetail;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class hz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public String c;
    public String d;
    public iz6 e;
    public List<jn> f;
    public boolean g;
    public boolean h;
    public boolean i;

    public hz6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.b = topicDetail2.topic_name;
            this.c = topicDetail2.share_title;
            this.d = topicDetail2.share_pic;
            iz6 iz6Var = new iz6();
            this.e = iz6Var;
            iz6Var.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.i = true;
            this.h = true;
            if (this.e == null) {
                this.e = new iz6();
            }
            this.e.b(dataRes.pk_module);
        } else {
            this.i = false;
        }
        if (dataRes.time_line != null) {
            this.h = true;
            if (this.e == null) {
                this.e = new iz6();
            }
            this.e.c(dataRes.time_line);
        }
        this.f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.h = true;
            int i = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            kz6 kz6Var = new kz6();
                            if (!z) {
                                kz6Var.a = true;
                                kz6Var.d = specialTopic.title;
                                z = true;
                            }
                            kz6Var.b = i;
                            kz6Var.c = this.a;
                            kz6Var.e(threadInfo);
                            this.f.add(kz6Var);
                            i++;
                        }
                    }
                }
            }
        }
        if (this.h) {
            yz6 yz6Var = new yz6();
            yz6Var.a = R.dimen.tbds78;
            yz6Var.b = R.color.CAM_X0201;
            this.f.add(yz6Var);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        yz6 yz6Var2 = new yz6();
        yz6Var2.a = R.dimen.tbds16;
        this.f.add(yz6Var2);
        this.g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                jz6 jz6Var = new jz6();
                jz6Var.e(topicThread);
                jz6Var.c = this.a;
                jz6Var.f = this.i;
                this.f.add(jz6Var);
            }
        }
    }
}
