package com.kwad.sdk.contentalliance.trends;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.g.i;
import com.kwad.sdk.core.g.o;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.home.a.a {

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f33585c;

    /* renamed from: d  reason: collision with root package name */
    public int f33586d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33587e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f33588f;

    /* renamed from: g  reason: collision with root package name */
    public List<TrendInfo> f33589g;

    /* renamed from: h  reason: collision with root package name */
    public int f33590h;

    /* renamed from: i  reason: collision with root package name */
    public TrendInfo f33591i;
    public int j;

    public a(SceneImpl sceneImpl) {
        this.f33585c = sceneImpl;
    }

    private void a(final boolean z, h.a aVar, @NonNull final TrendInfo trendInfo) {
        final i.a aVar2 = new i.a() { // from class: com.kwad.sdk.contentalliance.trends.a.1
            @Override // com.kwad.sdk.core.g.i.a
            @MainThread
            public void a(int i2, String str) {
                a.this.a(i2, str);
                a.this.f33587e = false;
            }

            @Override // com.kwad.sdk.core.g.i.a
            @MainThread
            public void a(@NonNull List<AdTemplate> list) {
                a aVar3;
                TrendInfo trendInfo2;
                if (z) {
                    a.this.f33586d = 0;
                    a.this.f33143a.clear();
                }
                if (a.this.f33143a.isEmpty()) {
                    m.e();
                }
                a.this.f33143a.addAll(list);
                a aVar4 = a.this;
                aVar4.a(z, aVar4.f33586d);
                a.this.f33587e = false;
                a.e(a.this);
                if (a.this.j + 1 < a.this.f33589g.size()) {
                    aVar3 = a.this;
                    trendInfo2 = (TrendInfo) aVar3.f33589g.get(a.this.j + 1);
                } else {
                    aVar3 = a.this;
                    trendInfo2 = null;
                }
                aVar3.f33591i = trendInfo2;
                a.h(a.this);
            }
        };
        if (trendInfo != null) {
            o.a(aVar, trendInfo, new o.c() { // from class: com.kwad.sdk.contentalliance.trends.a.2
                @Override // com.kwad.sdk.core.g.o.c
                public void a(int i2, String str) {
                    aVar2.a(i2, str);
                }

                @Override // com.kwad.sdk.core.g.o.c
                public void a(@NonNull List<AdTemplate> list) {
                    String str;
                    int i2 = 0;
                    while (i2 < list.size()) {
                        AdTemplate adTemplate = list.get(i2);
                        adTemplate.mCurrentTrendTitle = trendInfo.toJson().toString();
                        if (i2 != 0 || a.this.f33586d <= 0 || a.this.f33586d - 1 >= a.this.f33589g.size()) {
                            str = (i2 == list.size() + (-1) && a.this.f33586d + 1 < a.this.f33589g.size()) ? "上一个热点" : "上一个热点";
                            i2++;
                        } else {
                            str = "下一个热点";
                        }
                        adTemplate.mTrendSlideType = str;
                        i2++;
                    }
                    aVar2.a(list);
                }
            });
            return;
        }
        int i2 = f.f34499c.k;
        aVar2.a(i2, f.f34499c.l + "(无视频资源)");
    }

    private int c(TrendInfo trendInfo) {
        if (trendInfo != null && this.f33589g != null) {
            for (int i2 = 0; i2 < this.f33589g.size(); i2++) {
                if (trendInfo.trendId == this.f33589g.get(i2).trendId) {
                    return i2;
                }
            }
        }
        return 0;
    }

    public static /* synthetic */ int e(a aVar) {
        int i2 = aVar.f33586d;
        aVar.f33586d = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int h(a aVar) {
        int i2 = aVar.f33590h;
        aVar.f33590h = i2 + 1;
        return i2;
    }

    public void a(TrendInfo trendInfo) {
        this.f33591i = trendInfo;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f33588f = str;
        this.f33589g = TrendInfo.asList(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (r8 != null) goto L22;
     */
    @Override // com.kwad.sdk.contentalliance.home.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2, int i2) {
        f fVar;
        TrendInfo trendInfo;
        if (this.f33587e) {
            return;
        }
        int i3 = 1;
        this.f33587e = true;
        com.kwad.sdk.core.d.a.a("DataFetcher", "loadData isRefresh=" + z);
        a(z, z2, i2, this.f33586d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar2 = new com.kwad.sdk.core.g.a.f(this.f33585c);
        fVar2.f34278b = this.f33585c.getPageScene();
        fVar2.f34279c = 100L;
        aVar.f34412a.add(fVar2);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        if (i2 == 0) {
            i3 = 3;
        } else if (i2 != 1 && i2 != 2 && i2 != 3) {
            i3 = i2 != 4 ? 0 : 2;
        }
        cVar.f34264c = i3;
        cVar.f34265d = this.f33590h;
        aVar.f34413b = cVar;
        if (this.f33588f == null || this.f33589g.size() <= 0) {
            if (i3 != 3 || (trendInfo = this.f33591i) == null) {
                if (i3 != 2) {
                    this.f33587e = false;
                    a(z, this.f33586d);
                    fVar = f.f34497a;
                }
                this.f33587e = false;
                a(z, this.f33586d);
                fVar = f.f34503g;
            }
            this.j = c(trendInfo);
            a(z, aVar, this.f33591i);
            return;
        }
        if (this.f33586d < this.f33589g.size()) {
            trendInfo = this.f33591i;
        }
        this.f33587e = false;
        a(z, this.f33586d);
        fVar = f.f34503g;
        a(fVar.k, fVar.l);
    }

    public boolean b(@NonNull TrendInfo trendInfo) {
        if (this.f33587e) {
            return false;
        }
        this.f33587e = true;
        this.f33586d = 0;
        this.j = c(trendInfo);
        a(true, false, 1, this.f33586d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f33585c);
        fVar.f34278b = this.f33585c.getPageScene();
        fVar.f34279c = 100L;
        aVar.f34412a.add(fVar);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.f34264c = 1;
        cVar.f34265d = this.f33590h;
        aVar.f34413b = cVar;
        a(true, aVar, trendInfo);
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
    }
}
