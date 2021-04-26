package d.a.j0.a1.e.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f50711a;

    /* renamed from: b  reason: collision with root package name */
    public String f50712b;

    /* renamed from: c  reason: collision with root package name */
    public int f50713c;

    /* renamed from: d  reason: collision with root package name */
    public int f50714d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50715e;

    public c() {
        this.f50715e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i2) {
        this.f50711a = recomTopicList.topic_id.longValue();
        this.f50712b = recomTopicList.topic_name;
        this.f50713c = recomTopicList.tag.intValue();
        this.f50714d = i2 + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.f50711a = recomTopicList.topic_id.longValue();
        this.f50712b = recomTopicList.topic_name;
        this.f50713c = recomTopicList.tag.intValue();
        this.f50714d = -1;
    }
}
