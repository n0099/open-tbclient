package d.a.n0.b1.e.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f51573a;

    /* renamed from: b  reason: collision with root package name */
    public String f51574b;

    /* renamed from: c  reason: collision with root package name */
    public int f51575c;

    /* renamed from: d  reason: collision with root package name */
    public int f51576d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51577e;

    public c() {
        this.f51577e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i2) {
        this.f51573a = recomTopicList.topic_id.longValue();
        this.f51574b = recomTopicList.topic_name;
        this.f51575c = recomTopicList.tag.intValue();
        this.f51576d = i2 + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.f51573a = recomTopicList.topic_id.longValue();
        this.f51574b = recomTopicList.topic_name;
        this.f51575c = recomTopicList.tag.intValue();
        this.f51576d = -1;
    }
}
