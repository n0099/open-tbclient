package d.a.p0.e1.k.a.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.RelateThread;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicDetail;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f55756a;

    /* renamed from: b  reason: collision with root package name */
    public String f55757b;

    /* renamed from: c  reason: collision with root package name */
    public String f55758c;

    /* renamed from: d  reason: collision with root package name */
    public String f55759d;

    /* renamed from: e  reason: collision with root package name */
    public b f55760e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f55761f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55762g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55763h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55764i;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55764i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55764i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f55763h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f55756a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f55757b = topicDetail2.topic_name;
            this.f55758c = topicDetail2.share_title;
            this.f55759d = topicDetail2.share_pic;
            b bVar = new b();
            this.f55760e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f55763h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f55764i = true;
            this.f55763h = true;
            if (this.f55760e == null) {
                this.f55760e = new b();
            }
            this.f55760e.b(dataRes.pk_module);
        } else {
            this.f55764i = false;
        }
        if (dataRes.time_line != null) {
            this.f55763h = true;
            if (this.f55760e == null) {
                this.f55760e = new b();
            }
            this.f55760e.c(dataRes.time_line);
        }
        this.f55761f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f55763h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f55776e = true;
                                dVar.f55779h = specialTopic.title;
                                z = true;
                            }
                            dVar.f55777f = i2;
                            dVar.f55778g = this.f55756a;
                            dVar.c(threadInfo);
                            this.f55761f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f55763h) {
            d.a.p0.e1.k.b.c.c cVar = new d.a.p0.e1.k.b.c.c();
            cVar.f55823e = R.dimen.tbds78;
            cVar.f55824f = R.color.CAM_X0201;
            this.f55761f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.a.p0.e1.k.b.c.c cVar2 = new d.a.p0.e1.k.b.c.c();
        cVar2.f55823e = R.dimen.tbds16;
        this.f55761f.add(cVar2);
        this.f55762g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.c(topicThread);
                cVar3.f55773g = this.f55756a;
                cVar3.j = this.f55764i;
                this.f55761f.add(cVar3);
            }
        }
    }
}
