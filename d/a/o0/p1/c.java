package d.a.o0.p1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f61875a;

    /* renamed from: b  reason: collision with root package name */
    public String f61876b;

    /* renamed from: c  reason: collision with root package name */
    public int f61877c;

    public long a() {
        return this.f61875a;
    }

    public String b() {
        return this.f61876b;
    }

    public int c() {
        return this.f61877c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f61875a = hotTopicList.topic_id.longValue();
            this.f61876b = hotTopicList.topic_name;
            this.f61877c = hotTopicList.tag.intValue();
        }
    }
}
