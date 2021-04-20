package d.b.i0.a1.j.a.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
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
    public long f52923a;

    /* renamed from: b  reason: collision with root package name */
    public String f52924b;

    /* renamed from: c  reason: collision with root package name */
    public String f52925c;

    /* renamed from: d  reason: collision with root package name */
    public String f52926d;

    /* renamed from: e  reason: collision with root package name */
    public b f52927e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f52928f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52929g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52930h;
    public boolean i = false;

    public boolean a() {
        return this.i;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f52930h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f52923a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f52924b = topicDetail2.topic_name;
            this.f52925c = topicDetail2.share_title;
            this.f52926d = topicDetail2.share_pic;
            b bVar = new b();
            this.f52927e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f52930h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.i = true;
            this.f52930h = true;
            if (this.f52927e == null) {
                this.f52927e = new b();
            }
            this.f52927e.b(dataRes.pk_module);
        } else {
            this.i = false;
        }
        if (dataRes.time_line != null) {
            this.f52930h = true;
            if (this.f52927e == null) {
                this.f52927e = new b();
            }
            this.f52927e.c(dataRes.time_line);
        }
        this.f52928f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f52930h = true;
            int i = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f52941e = true;
                                dVar.f52944h = specialTopic.title;
                                z = true;
                            }
                            dVar.f52942f = i;
                            dVar.f52943g = this.f52923a;
                            dVar.g(threadInfo);
                            this.f52928f.add(dVar);
                            i++;
                        }
                    }
                }
            }
        }
        if (this.f52930h) {
            d.b.i0.a1.j.b.c.c cVar = new d.b.i0.a1.j.b.c.c();
            cVar.f52986e = R.dimen.tbds78;
            cVar.f52987f = R.color.CAM_X0201;
            this.f52928f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.b.i0.a1.j.b.c.c cVar2 = new d.b.i0.a1.j.b.c.c();
        cVar2.f52986e = R.dimen.tbds16;
        this.f52928f.add(cVar2);
        this.f52929g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f52939g = this.f52923a;
                cVar3.j = this.i;
                this.f52928f.add(cVar3);
            }
        }
    }
}
