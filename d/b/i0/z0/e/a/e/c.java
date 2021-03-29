package d.b.i0.z0.e.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f62968a;

    /* renamed from: b  reason: collision with root package name */
    public String f62969b;

    /* renamed from: c  reason: collision with root package name */
    public int f62970c;

    /* renamed from: d  reason: collision with root package name */
    public int f62971d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62972e;

    public c() {
        this.f62972e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i) {
        this.f62968a = recomTopicList.topic_id.longValue();
        this.f62969b = recomTopicList.topic_name;
        this.f62970c = recomTopicList.tag.intValue();
        this.f62971d = i + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.f62968a = recomTopicList.topic_id.longValue();
        this.f62969b = recomTopicList.topic_name;
        this.f62970c = recomTopicList.tag.intValue();
        this.f62971d = -1;
    }
}
