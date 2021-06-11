package d.a.n0.b1.f.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f55256a;

    /* renamed from: b  reason: collision with root package name */
    public String f55257b;

    /* renamed from: c  reason: collision with root package name */
    public int f55258c;

    /* renamed from: d  reason: collision with root package name */
    public int f55259d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55260e;

    public c() {
        this.f55260e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i2) {
        this.f55256a = recomTopicList.topic_id.longValue();
        this.f55257b = recomTopicList.topic_name;
        this.f55258c = recomTopicList.tag.intValue();
        this.f55259d = i2 + 1;
    }
}
