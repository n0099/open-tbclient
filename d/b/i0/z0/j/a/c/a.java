package d.b.i0.z0.j.a.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.RelateThread;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicDetail;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f63304a;

    /* renamed from: b  reason: collision with root package name */
    public String f63305b;

    /* renamed from: c  reason: collision with root package name */
    public String f63306c;

    /* renamed from: d  reason: collision with root package name */
    public String f63307d;

    /* renamed from: e  reason: collision with root package name */
    public b f63308e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f63309f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63310g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63311h;
    public boolean i = false;

    public boolean a() {
        return this.i;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f63311h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f63304a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f63305b = topicDetail2.topic_name;
            this.f63306c = topicDetail2.share_title;
            this.f63307d = topicDetail2.share_pic;
            b bVar = new b();
            this.f63308e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f63311h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.i = true;
            this.f63311h = true;
            if (this.f63308e == null) {
                this.f63308e = new b();
            }
            this.f63308e.b(dataRes.pk_module);
        } else {
            this.i = false;
        }
        if (dataRes.time_line != null) {
            this.f63311h = true;
            if (this.f63308e == null) {
                this.f63308e = new b();
            }
            this.f63308e.c(dataRes.time_line);
        }
        this.f63309f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f63311h = true;
            int i = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f63322e = true;
                                dVar.f63325h = specialTopic.title;
                                z = true;
                            }
                            dVar.f63323f = i;
                            dVar.f63324g = this.f63304a;
                            dVar.g(threadInfo);
                            this.f63309f.add(dVar);
                            i++;
                        }
                    }
                }
            }
        }
        if (this.f63311h) {
            d.b.i0.z0.j.b.c.c cVar = new d.b.i0.z0.j.b.c.c();
            cVar.f63367e = R.dimen.tbds78;
            cVar.f63368f = R.color.CAM_X0201;
            this.f63309f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.b.i0.z0.j.b.c.c cVar2 = new d.b.i0.z0.j.b.c.c();
        cVar2.f63367e = R.dimen.tbds16;
        this.f63309f.add(cVar2);
        this.f63310g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f63320g = this.f63304a;
                cVar3.j = this.i;
                this.f63309f.add(cVar3);
            }
        }
    }
}
