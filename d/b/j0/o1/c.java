package d.b.j0.o1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f59214a;

    /* renamed from: b  reason: collision with root package name */
    public String f59215b;

    /* renamed from: c  reason: collision with root package name */
    public int f59216c;

    public long a() {
        return this.f59214a;
    }

    public String b() {
        return this.f59215b;
    }

    public int c() {
        return this.f59216c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f59214a = hotTopicList.topic_id.longValue();
            this.f59215b = hotTopicList.topic_name;
            this.f59216c = hotTopicList.tag.intValue();
        }
    }
}
