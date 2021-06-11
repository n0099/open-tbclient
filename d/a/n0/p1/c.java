package d.a.n0.p1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f61750a;

    /* renamed from: b  reason: collision with root package name */
    public String f61751b;

    /* renamed from: c  reason: collision with root package name */
    public int f61752c;

    public long a() {
        return this.f61750a;
    }

    public String b() {
        return this.f61751b;
    }

    public int c() {
        return this.f61752c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f61750a = hotTopicList.topic_id.longValue();
            this.f61751b = hotTopicList.topic_name;
            this.f61752c = hotTopicList.tag.intValue();
        }
    }
}
