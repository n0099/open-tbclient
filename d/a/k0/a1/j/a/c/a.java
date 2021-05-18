package d.a.k0.a1.j.a.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
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
    public long f51764a;

    /* renamed from: b  reason: collision with root package name */
    public String f51765b;

    /* renamed from: c  reason: collision with root package name */
    public String f51766c;

    /* renamed from: d  reason: collision with root package name */
    public String f51767d;

    /* renamed from: e  reason: collision with root package name */
    public b f51768e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f51769f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51770g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51771h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51772i = false;

    public boolean a() {
        return this.f51772i;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f51771h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f51764a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f51765b = topicDetail2.topic_name;
            this.f51766c = topicDetail2.share_title;
            this.f51767d = topicDetail2.share_pic;
            b bVar = new b();
            this.f51768e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f51771h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f51772i = true;
            this.f51771h = true;
            if (this.f51768e == null) {
                this.f51768e = new b();
            }
            this.f51768e.b(dataRes.pk_module);
        } else {
            this.f51772i = false;
        }
        if (dataRes.time_line != null) {
            this.f51771h = true;
            if (this.f51768e == null) {
                this.f51768e = new b();
            }
            this.f51768e.c(dataRes.time_line);
        }
        this.f51769f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f51771h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f51784e = true;
                                dVar.f51787h = specialTopic.title;
                                z = true;
                            }
                            dVar.f51785f = i2;
                            dVar.f51786g = this.f51764a;
                            dVar.h(threadInfo);
                            this.f51769f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f51771h) {
            d.a.k0.a1.j.b.c.c cVar = new d.a.k0.a1.j.b.c.c();
            cVar.f51831e = R.dimen.tbds78;
            cVar.f51832f = R.color.CAM_X0201;
            this.f51769f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.a.k0.a1.j.b.c.c cVar2 = new d.a.k0.a1.j.b.c.c();
        cVar2.f51831e = R.dimen.tbds16;
        this.f51769f.add(cVar2);
        this.f51770g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.h(topicThread);
                cVar3.f51781g = this.f51764a;
                cVar3.j = this.f51772i;
                this.f51769f.add(cVar3);
            }
        }
    }
}
