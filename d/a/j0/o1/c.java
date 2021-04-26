package d.a.j0.o1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f57243a;

    /* renamed from: b  reason: collision with root package name */
    public String f57244b;

    /* renamed from: c  reason: collision with root package name */
    public int f57245c;

    public long a() {
        return this.f57243a;
    }

    public String b() {
        return this.f57244b;
    }

    public int c() {
        return this.f57245c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f57243a = hotTopicList.topic_id.longValue();
            this.f57244b = hotTopicList.topic_name;
            this.f57245c = hotTopicList.tag.intValue();
        }
    }
}
