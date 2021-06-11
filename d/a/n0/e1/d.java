package d.a.n0.e1;

import GetSugTopic.TopicList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56477a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f56478b;

    public Integer a() {
        return this.f56478b;
    }

    public String b() {
        return this.f56477a;
    }

    public void c(TopicList topicList) {
        if (topicList != null) {
            Long l = topicList.topic_id;
            this.f56477a = topicList.topic_name;
            String str = topicList.topic_pic;
            String str2 = topicList.topic_desc;
            Long l2 = topicList.discuss_num;
            this.f56478b = topicList.tag;
        }
    }

    public void d(String str) {
        this.f56477a = str;
    }
}
