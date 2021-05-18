package d.a.k0.o1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f57950a;

    /* renamed from: b  reason: collision with root package name */
    public String f57951b;

    /* renamed from: c  reason: collision with root package name */
    public int f57952c;

    public long a() {
        return this.f57950a;
    }

    public String b() {
        return this.f57951b;
    }

    public int c() {
        return this.f57952c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f57950a = hotTopicList.topic_id.longValue();
            this.f57951b = hotTopicList.topic_name;
            this.f57952c = hotTopicList.tag.intValue();
        }
    }
}
