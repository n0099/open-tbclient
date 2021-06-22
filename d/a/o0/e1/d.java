package d.a.o0.e1;

import GetSugTopic.TopicList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56602a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f56603b;

    public Integer a() {
        return this.f56603b;
    }

    public String b() {
        return this.f56602a;
    }

    public void c(TopicList topicList) {
        if (topicList != null) {
            Long l = topicList.topic_id;
            this.f56602a = topicList.topic_name;
            String str = topicList.topic_pic;
            String str2 = topicList.topic_desc;
            Long l2 = topicList.discuss_num;
            this.f56603b = topicList.tag;
        }
    }

    public void d(String str) {
        this.f56602a = str;
    }
}
