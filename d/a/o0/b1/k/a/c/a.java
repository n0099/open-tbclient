package d.a.o0.b1.k.a.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.RelateThread;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicDetail;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f55745a;

    /* renamed from: b  reason: collision with root package name */
    public String f55746b;

    /* renamed from: c  reason: collision with root package name */
    public String f55747c;

    /* renamed from: d  reason: collision with root package name */
    public String f55748d;

    /* renamed from: e  reason: collision with root package name */
    public b f55749e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f55750f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55751g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55752h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55753i = false;

    public boolean a() {
        return this.f55753i;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55752h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f55745a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f55746b = topicDetail2.topic_name;
            this.f55747c = topicDetail2.share_title;
            this.f55748d = topicDetail2.share_pic;
            b bVar = new b();
            this.f55749e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f55752h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f55753i = true;
            this.f55752h = true;
            if (this.f55749e == null) {
                this.f55749e = new b();
            }
            this.f55749e.b(dataRes.pk_module);
        } else {
            this.f55753i = false;
        }
        if (dataRes.time_line != null) {
            this.f55752h = true;
            if (this.f55749e == null) {
                this.f55749e = new b();
            }
            this.f55749e.c(dataRes.time_line);
        }
        this.f55750f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f55752h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f55765e = true;
                                dVar.f55768h = specialTopic.title;
                                z = true;
                            }
                            dVar.f55766f = i2;
                            dVar.f55767g = this.f55745a;
                            dVar.c(threadInfo);
                            this.f55750f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f55752h) {
            d.a.o0.b1.k.b.c.c cVar = new d.a.o0.b1.k.b.c.c();
            cVar.f55812e = R.dimen.tbds78;
            cVar.f55813f = R.color.CAM_X0201;
            this.f55750f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.a.o0.b1.k.b.c.c cVar2 = new d.a.o0.b1.k.b.c.c();
        cVar2.f55812e = R.dimen.tbds16;
        this.f55750f.add(cVar2);
        this.f55751g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.c(topicThread);
                cVar3.f55762g = this.f55745a;
                cVar3.j = this.f55753i;
                this.f55750f.add(cVar3);
            }
        }
    }
}
