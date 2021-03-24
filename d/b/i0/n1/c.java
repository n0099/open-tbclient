package d.b.i0.n1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f57093a;

    /* renamed from: b  reason: collision with root package name */
    public String f57094b;

    /* renamed from: c  reason: collision with root package name */
    public int f57095c;

    public long a() {
        return this.f57093a;
    }

    public String b() {
        return this.f57094b;
    }

    public int c() {
        return this.f57095c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f57093a = hotTopicList.topic_id.longValue();
            this.f57094b = hotTopicList.topic_name;
            this.f57095c = hotTopicList.tag.intValue();
        }
    }
}
