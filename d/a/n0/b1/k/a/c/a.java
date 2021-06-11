package d.a.n0.b1.k.a.c;

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
    public long f55620a;

    /* renamed from: b  reason: collision with root package name */
    public String f55621b;

    /* renamed from: c  reason: collision with root package name */
    public String f55622c;

    /* renamed from: d  reason: collision with root package name */
    public String f55623d;

    /* renamed from: e  reason: collision with root package name */
    public b f55624e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f55625f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55626g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55627h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55628i = false;

    public boolean a() {
        return this.f55628i;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55627h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f55620a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f55621b = topicDetail2.topic_name;
            this.f55622c = topicDetail2.share_title;
            this.f55623d = topicDetail2.share_pic;
            b bVar = new b();
            this.f55624e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f55627h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.f55628i = true;
            this.f55627h = true;
            if (this.f55624e == null) {
                this.f55624e = new b();
            }
            this.f55624e.b(dataRes.pk_module);
        } else {
            this.f55628i = false;
        }
        if (dataRes.time_line != null) {
            this.f55627h = true;
            if (this.f55624e == null) {
                this.f55624e = new b();
            }
            this.f55624e.c(dataRes.time_line);
        }
        this.f55625f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f55627h = true;
            int i2 = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f55640e = true;
                                dVar.f55643h = specialTopic.title;
                                z = true;
                            }
                            dVar.f55641f = i2;
                            dVar.f55642g = this.f55620a;
                            dVar.c(threadInfo);
                            this.f55625f.add(dVar);
                            i2++;
                        }
                    }
                }
            }
        }
        if (this.f55627h) {
            d.a.n0.b1.k.b.c.c cVar = new d.a.n0.b1.k.b.c.c();
            cVar.f55687e = R.dimen.tbds78;
            cVar.f55688f = R.color.CAM_X0201;
            this.f55625f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.a.n0.b1.k.b.c.c cVar2 = new d.a.n0.b1.k.b.c.c();
        cVar2.f55687e = R.dimen.tbds16;
        this.f55625f.add(cVar2);
        this.f55626g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.c(topicThread);
                cVar3.f55637g = this.f55620a;
                cVar3.j = this.f55628i;
                this.f55625f.add(cVar3);
            }
        }
    }
}
