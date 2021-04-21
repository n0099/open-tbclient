package d.b.j0.a1.j.a.c;

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
    public long f53344a;

    /* renamed from: b  reason: collision with root package name */
    public String f53345b;

    /* renamed from: c  reason: collision with root package name */
    public String f53346c;

    /* renamed from: d  reason: collision with root package name */
    public String f53347d;

    /* renamed from: e  reason: collision with root package name */
    public b f53348e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f53349f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53350g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53351h;
    public boolean i = false;

    public boolean a() {
        return this.i;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f53351h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.f53344a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.f53345b = topicDetail2.topic_name;
            this.f53346c = topicDetail2.share_title;
            this.f53347d = topicDetail2.share_pic;
            b bVar = new b();
            this.f53348e = bVar;
            bVar.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.f53351h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.i = true;
            this.f53351h = true;
            if (this.f53348e == null) {
                this.f53348e = new b();
            }
            this.f53348e.b(dataRes.pk_module);
        } else {
            this.i = false;
        }
        if (dataRes.time_line != null) {
            this.f53351h = true;
            if (this.f53348e == null) {
                this.f53348e = new b();
            }
            this.f53348e.c(dataRes.time_line);
        }
        this.f53349f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.f53351h = true;
            int i = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            d dVar = new d();
                            if (!z) {
                                dVar.f53362e = true;
                                dVar.f53365h = specialTopic.title;
                                z = true;
                            }
                            dVar.f53363f = i;
                            dVar.f53364g = this.f53344a;
                            dVar.g(threadInfo);
                            this.f53349f.add(dVar);
                            i++;
                        }
                    }
                }
            }
        }
        if (this.f53351h) {
            d.b.j0.a1.j.b.c.c cVar = new d.b.j0.a1.j.b.c.c();
            cVar.f53407e = R.dimen.tbds78;
            cVar.f53408f = R.color.CAM_X0201;
            this.f53349f.add(cVar);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread == null || ListUtils.isEmpty(relateThread.thread_list)) {
            return;
        }
        d.b.j0.a1.j.b.c.c cVar2 = new d.b.j0.a1.j.b.c.c();
        cVar2.f53407e = R.dimen.tbds16;
        this.f53349f.add(cVar2);
        this.f53350g = dataRes.relate_thread.has_more.intValue() == 1;
        for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
            if (topicThread != null) {
                c cVar3 = new c();
                cVar3.g(topicThread);
                cVar3.f53360g = this.f53344a;
                cVar3.j = this.i;
                this.f53349f.add(cVar3);
            }
        }
    }
}
