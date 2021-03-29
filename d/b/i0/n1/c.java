package d.b.i0.n1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f57094a;

    /* renamed from: b  reason: collision with root package name */
    public String f57095b;

    /* renamed from: c  reason: collision with root package name */
    public int f57096c;

    public long a() {
        return this.f57094a;
    }

    public String b() {
        return this.f57095b;
    }

    public int c() {
        return this.f57096c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f57094a = hotTopicList.topic_id.longValue();
            this.f57095b = hotTopicList.topic_name;
            this.f57096c = hotTopicList.tag.intValue();
        }
    }
}
