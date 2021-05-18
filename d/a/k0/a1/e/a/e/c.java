package d.a.k0.a1.e.a.e;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f51408a;

    /* renamed from: b  reason: collision with root package name */
    public String f51409b;

    /* renamed from: c  reason: collision with root package name */
    public int f51410c;

    /* renamed from: d  reason: collision with root package name */
    public int f51411d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51412e;

    public c() {
        this.f51412e = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i2) {
        this.f51408a = recomTopicList.topic_id.longValue();
        this.f51409b = recomTopicList.topic_name;
        this.f51410c = recomTopicList.tag.intValue();
        this.f51411d = i2 + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.f51408a = recomTopicList.topic_id.longValue();
        this.f51409b = recomTopicList.topic_name;
        this.f51410c = recomTopicList.tag.intValue();
        this.f51411d = -1;
    }
}
