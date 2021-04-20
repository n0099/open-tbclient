package d.b.i0.d1;

import GetSugTopic.TopicList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f53689a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f53690b;

    public Integer a() {
        return this.f53690b;
    }

    public String b() {
        return this.f53689a;
    }

    public void c(TopicList topicList) {
        if (topicList != null) {
            Long l = topicList.topic_id;
            this.f53689a = topicList.topic_name;
            String str = topicList.topic_pic;
            String str2 = topicList.topic_desc;
            Long l2 = topicList.discuss_num;
            this.f53690b = topicList.tag;
        }
    }

    public void d(String str) {
        this.f53689a = str;
    }
}
