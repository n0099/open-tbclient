package d.a.n0.b1.j.a.c;

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
    public long f51931a;

    /* renamed from: b  reason: collision with root package name */
    public String f51932b;

    /* renamed from: c  reason: collision with root package name */
    public String f51933c;

    /* renamed from: d  reason: collision with root package name */
    public String f51934d;

    /* renamed from: e  reason: collision with root package name */
    public b f51935e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f51936f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51937g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51938h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51939i = false;

    public boolean a() {
        return this.f51939i;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f51938h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f51931a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f51932b = topicDetail2.topic_name;
            this.f51933c = topicDetail2.share_title;
            this.f51934d = topicDetail2.share_pic;
            b bVar = new b();
            this.f51935e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f51938h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f51939i = true;
            this.f51938h = true;
            if (this.f51935e == null) {
                this.f51935e = new b();
            }
            this.f51935e.b(dataRes.pk_module);
        } else {
            this.f51939i = false;
        }
        if (dataRes.time_line != null) {
            this.f51938h = true;
            if (this.f51935e == null) {
                this.f51935e = new b();
            }
            this.f51935e.c(dataRes.time_line);
        }
        this.f51936f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f51938h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f51951e = true;
                                dVar.f51954h = specialTopic.title;
                                z = true;
                            }
                            dVar.f51952f = i2;
                            dVar.f51953g = this.f51931a;
                            dVar.h(threadInfo);
                            this.f51936f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f51938h) {
            d.a.n0.b1.j.b.c.c cVar = new d.a.n0.b1.j.b.c.c();
            cVar.f51998e = R.dimen.tbds78;
            cVar.f51999f = R.color.CAM_X0201;
            this.f51936f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.a.n0.b1.j.b.c.c cVar2 = new d.a.n0.b1.j.b.c.c();
        cVar2.f51998e = R.dimen.tbds16;
        this.f51936f.add(cVar2);
        this.f51937g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.h(topicThread);
                cVar3.f51948g = this.f51931a;
                cVar3.j = this.f51939i;
                this.f51936f.add(cVar3);
            }
        }
    }
}
