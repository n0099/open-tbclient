package d.a.q0.e1.k.a.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
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
    public long f56300a;

    /* renamed from: b  reason: collision with root package name */
    public String f56301b;

    /* renamed from: c  reason: collision with root package name */
    public String f56302c;

    /* renamed from: d  reason: collision with root package name */
    public String f56303d;

    /* renamed from: e  reason: collision with root package name */
    public b f56304e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f56305f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56306g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56307h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56308i;

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
        this.f56308i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56308i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f56307h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f56300a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f56301b = topicDetail2.topic_name;
            this.f56302c = topicDetail2.share_title;
            this.f56303d = topicDetail2.share_pic;
            b bVar = new b();
            this.f56304e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f56307h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f56308i = true;
            this.f56307h = true;
            if (this.f56304e == null) {
                this.f56304e = new b();
            }
            this.f56304e.b(dataRes.pk_module);
        } else {
            this.f56308i = false;
        }
        if (dataRes.time_line != null) {
            this.f56307h = true;
            if (this.f56304e == null) {
                this.f56304e = new b();
            }
            this.f56304e.c(dataRes.time_line);
        }
        this.f56305f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f56307h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f56320e = true;
                                dVar.f56323h = specialTopic.title;
                                z = true;
                            }
                            dVar.f56321f = i2;
                            dVar.f56322g = this.f56300a;
                            dVar.c(threadInfo);
                            this.f56305f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f56307h) {
            d.a.q0.e1.k.b.c.c cVar = new d.a.q0.e1.k.b.c.c();
            cVar.f56367e = R.dimen.tbds78;
            cVar.f56368f = R.color.CAM_X0201;
            this.f56305f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.a.q0.e1.k.b.c.c cVar2 = new d.a.q0.e1.k.b.c.c();
        cVar2.f56367e = R.dimen.tbds16;
        this.f56305f.add(cVar2);
        this.f56306g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.c(topicThread);
                cVar3.f56317g = this.f56300a;
                cVar3.j = this.f56308i;
                this.f56305f.add(cVar3);
            }
        }
    }
}
