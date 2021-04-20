package d.b.i0.o1;

import tbclient.HotForum.HotTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f58793a;

    /* renamed from: b  reason: collision with root package name */
    public String f58794b;

    /* renamed from: c  reason: collision with root package name */
    public int f58795c;

    public long a() {
        return this.f58793a;
    }

    public String b() {
        return this.f58794b;
    }

    public int c() {
        return this.f58795c;
    }

    public void d(HotTopicList hotTopicList) {
        if (hotTopicList != null) {
            this.f58793a = hotTopicList.topic_id.longValue();
            this.f58794b = hotTopicList.topic_name;
            this.f58795c = hotTopicList.tag.intValue();
        }
    }
}
