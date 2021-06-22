package d.a.o0.b1.f.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f55381a;

    /* renamed from: b  reason: collision with root package name */
    public String f55382b;

    /* renamed from: c  reason: collision with root package name */
    public int f55383c;

    /* renamed from: d  reason: collision with root package name */
    public int f55384d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55385e;

    public c() {
        this.f55385e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i2) {
        this.f55381a = recomTopicList.topic_id.longValue();
        this.f55382b = recomTopicList.topic_name;
        this.f55383c = recomTopicList.tag.intValue();
        this.f55384d = i2 + 1;
    }
}
