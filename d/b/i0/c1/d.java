package d.b.i0.c1;

import GetSugTopic.TopicList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f52293a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f52294b;

    public Integer a() {
        return this.f52294b;
    }

    public String b() {
        return this.f52293a;
    }

    public void c(TopicList topicList) {
        if (topicList != null) {
            Long l = topicList.topic_id;
            this.f52293a = topicList.topic_name;
            String str = topicList.topic_pic;
            String str2 = topicList.topic_desc;
            Long l2 = topicList.discuss_num;
            this.f52294b = topicList.tag;
        }
    }

    public void d(String str) {
        this.f52293a = str;
    }
}
