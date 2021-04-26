package d.a.j0.a1.j.a.c;

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
    public long f51065a;

    /* renamed from: b  reason: collision with root package name */
    public String f51066b;

    /* renamed from: c  reason: collision with root package name */
    public String f51067c;

    /* renamed from: d  reason: collision with root package name */
    public String f51068d;

    /* renamed from: e  reason: collision with root package name */
    public b f51069e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f51070f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51071g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51072h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51073i = false;

    public boolean a() {
        return this.f51073i;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f51072h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f51065a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f51066b = topicDetail2.topic_name;
            this.f51067c = topicDetail2.share_title;
            this.f51068d = topicDetail2.share_pic;
            b bVar = new b();
            this.f51069e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f51072h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f51073i = true;
            this.f51072h = true;
            if (this.f51069e == null) {
                this.f51069e = new b();
            }
            this.f51069e.b(dataRes.pk_module);
        } else {
            this.f51073i = false;
        }
        if (dataRes.time_line != null) {
            this.f51072h = true;
            if (this.f51069e == null) {
                this.f51069e = new b();
            }
            this.f51069e.c(dataRes.time_line);
        }
        this.f51070f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f51072h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f51085e = true;
                                dVar.f51088h = specialTopic.title;
                                z = true;
                            }
                            dVar.f51086f = i2;
                            dVar.f51087g = this.f51065a;
                            dVar.h(threadInfo);
                            this.f51070f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f51072h) {
            d.a.j0.a1.j.b.c.c cVar = new d.a.j0.a1.j.b.c.c();
            cVar.f51132e = R.dimen.tbds78;
            cVar.f51133f = R.color.CAM_X0201;
            this.f51070f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.a.j0.a1.j.b.c.c cVar2 = new d.a.j0.a1.j.b.c.c();
        cVar2.f51132e = R.dimen.tbds16;
        this.f51070f.add(cVar2);
        this.f51071g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.h(topicThread);
                cVar3.f51082g = this.f51065a;
                cVar3.j = this.f51073i;
                this.f51070f.add(cVar3);
            }
        }
    }
}
