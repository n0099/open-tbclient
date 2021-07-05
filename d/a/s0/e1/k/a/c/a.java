package d.a.s0.e1.k.a.c;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f59011a;

    /* renamed from: b  reason: collision with root package name */
    public String f59012b;

    /* renamed from: c  reason: collision with root package name */
    public String f59013c;

    /* renamed from: d  reason: collision with root package name */
    public String f59014d;

    /* renamed from: e  reason: collision with root package name */
    public b f59015e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f59016f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59017g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59018h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59019i;

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
        this.f59019i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59019i : invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f59018h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f59011a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f59012b = topicDetail2.topic_name;
            this.f59013c = topicDetail2.share_title;
            this.f59014d = topicDetail2.share_pic;
            b bVar = new b();
            this.f59015e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f59018h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f59019i = true;
            this.f59018h = true;
            if (this.f59015e == null) {
                this.f59015e = new b();
            }
            this.f59015e.b(dataRes.pk_module);
        } else {
            this.f59019i = false;
        }
        if (dataRes.time_line != null) {
            this.f59018h = true;
            if (this.f59015e == null) {
                this.f59015e = new b();
            }
            this.f59015e.c(dataRes.time_line);
        }
        this.f59016f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f59018h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f59031e = true;
                                dVar.f59034h = specialTopic.title;
                                z = true;
                            }
                            dVar.f59032f = i2;
                            dVar.f59033g = this.f59011a;
                            dVar.c(threadInfo);
                            this.f59016f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f59018h) {
            d.a.s0.e1.k.b.c.c cVar = new d.a.s0.e1.k.b.c.c();
            cVar.f59078e = R.dimen.tbds78;
            cVar.f59079f = R.color.CAM_X0201;
            this.f59016f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.a.s0.e1.k.b.c.c cVar2 = new d.a.s0.e1.k.b.c.c();
        cVar2.f59078e = R.dimen.tbds16;
        this.f59016f.add(cVar2);
        this.f59017g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.c(topicThread);
                cVar3.f59028g = this.f59011a;
                cVar3.j = this.f59019i;
                this.f59016f.add(cVar3);
            }
        }
    }
}
