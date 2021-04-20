package d.b.i0.a1.e.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f52587a;

    /* renamed from: b  reason: collision with root package name */
    public String f52588b;

    /* renamed from: c  reason: collision with root package name */
    public int f52589c;

    /* renamed from: d  reason: collision with root package name */
    public int f52590d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52591e;

    public c() {
        this.f52591e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i) {
        this.f52587a = recomTopicList.topic_id.longValue();
        this.f52588b = recomTopicList.topic_name;
        this.f52589c = recomTopicList.tag.intValue();
        this.f52590d = i + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.f52587a = recomTopicList.topic_id.longValue();
        this.f52588b = recomTopicList.topic_name;
        this.f52589c = recomTopicList.tag.intValue();
        this.f52590d = -1;
    }
}
