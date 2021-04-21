package d.b.j0.a1.e.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f53008a;

    /* renamed from: b  reason: collision with root package name */
    public String f53009b;

    /* renamed from: c  reason: collision with root package name */
    public int f53010c;

    /* renamed from: d  reason: collision with root package name */
    public int f53011d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53012e;

    public c() {
        this.f53012e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i) {
        this.f53008a = recomTopicList.topic_id.longValue();
        this.f53009b = recomTopicList.topic_name;
        this.f53010c = recomTopicList.tag.intValue();
        this.f53011d = i + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.f53008a = recomTopicList.topic_id.longValue();
        this.f53009b = recomTopicList.topic_name;
        this.f53010c = recomTopicList.tag.intValue();
        this.f53011d = -1;
    }
}
