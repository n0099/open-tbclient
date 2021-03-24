package d.b.i0.z0.e.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f62967a;

    /* renamed from: b  reason: collision with root package name */
    public String f62968b;

    /* renamed from: c  reason: collision with root package name */
    public int f62969c;

    /* renamed from: d  reason: collision with root package name */
    public int f62970d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62971e;

    public c() {
        this.f62971e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i) {
        this.f62967a = recomTopicList.topic_id.longValue();
        this.f62968b = recomTopicList.topic_name;
        this.f62969c = recomTopicList.tag.intValue();
        this.f62970d = i + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.f62967a = recomTopicList.topic_id.longValue();
        this.f62968b = recomTopicList.topic_name;
        this.f62969c = recomTopicList.tag.intValue();
        this.f62970d = -1;
    }
}
