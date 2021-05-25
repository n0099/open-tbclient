package d.a.n0.p1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f58059a;

    /* renamed from: b  reason: collision with root package name */
    public String f58060b;

    /* renamed from: c  reason: collision with root package name */
    public int f58061c;

    public long a() {
        return this.f58059a;
    }

    public String b() {
        return this.f58060b;
    }

    public int c() {
        return this.f58061c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f58059a = hotTopicList.topic_id.longValue();
            this.f58060b = hotTopicList.topic_name;
            this.f58061c = hotTopicList.tag.intValue();
        }
    }
}
