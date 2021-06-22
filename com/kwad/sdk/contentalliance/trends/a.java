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
    public SceneImpl f33683c;

    /* renamed from: d  reason: collision with root package name */
    public int f33684d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33685e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f33686f;

    /* renamed from: g  reason: collision with root package name */
    public List<TrendInfo> f33687g;

    /* renamed from: h  reason: collision with root package name */
    public int f33688h;

    /* renamed from: i  reason: collision with root package name */
    public TrendInfo f33689i;
    public int j;

    public a(SceneImpl sceneImpl) {
        this.f33683c = sceneImpl;
    }

    private void a(final boolean z, h.a aVar, @NonNull final TrendInfo trendInfo) {
        final i.a aVar2 = new i.a() { // from class: com.kwad.sdk.contentalliance.trends.a.1
            @Override // com.kwad.sdk.core.g.i.a
            @MainThread
            public void a(int i2, String str) {
                a.this.a(i2, str);
                a.this.f33685e = false;
            }

            @Override // com.kwad.sdk.core.g.i.a
            @MainThread
            public void a(@NonNull List<AdTemplate> list) {
                a aVar3;
                TrendInfo trendInfo2;
                if (z) {
                    a.this.f33684d = 0;
                    a.this.f33241a.clear();
                }
                if (a.this.f33241a.isEmpty()) {
                    m.e();
                }
                a.this.f33241a.addAll(list);
                a aVar4 = a.this;
                aVar4.a(z, aVar4.f33684d);
                a.this.f33685e = false;
                a.e(a.this);
                if (a.this.j + 1 < a.this.f33687g.size()) {
                    aVar3 = a.this;
                    trendInfo2 = (TrendInfo) aVar3.f33687g.get(a.this.j + 1);
                } else {
                    aVar3 = a.this;
                    trendInfo2 = null;
                }
                aVar3.f33689i = trendInfo2;
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
                        if (i2 != 0 || a.this.f33684d <= 0 || a.this.f33684d - 1 >= a.this.f33687g.size()) {
                            str = (i2 == list.size() + (-1) && a.this.f33684d + 1 < a.this.f33687g.size()) ? "上一个热点" : "上一个热点";
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
        int i2 = f.f34597c.k;
        aVar2.a(i2, f.f34597c.l + "(无视频资源)");
    }

    private int c(TrendInfo trendInfo) {
        if (trendInfo != null && this.f33687g != null) {
            for (int i2 = 0; i2 < this.f33687g.size(); i2++) {
                if (trendInfo.trendId == this.f33687g.get(i2).trendId) {
                    return i2;
                }
            }
        }
        return 0;
    }

    public static /* synthetic */ int e(a aVar) {
        int i2 = aVar.f33684d;
        aVar.f33684d = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int h(a aVar) {
        int i2 = aVar.f33688h;
        aVar.f33688h = i2 + 1;
        return i2;
    }

    public void a(TrendInfo trendInfo) {
        this.f33689i = trendInfo;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f33686f = str;
        this.f33687g = TrendInfo.asList(str);
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
        if (this.f33685e) {
            return;
        }
        int i3 = 1;
        this.f33685e = true;
        com.kwad.sdk.core.d.a.a("DataFetcher", "loadData isRefresh=" + z);
        a(z, z2, i2, this.f33684d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar2 = new com.kwad.sdk.core.g.a.f(this.f33683c);
        fVar2.f34376b = this.f33683c.getPageScene();
        fVar2.f34377c = 100L;
        aVar.f34510a.add(fVar2);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        if (i2 == 0) {
            i3 = 3;
        } else if (i2 != 1 && i2 != 2 && i2 != 3) {
            i3 = i2 != 4 ? 0 : 2;
        }
        cVar.f34362c = i3;
        cVar.f34363d = this.f33688h;
        aVar.f34511b = cVar;
        if (this.f33686f == null || this.f33687g.size() <= 0) {
            if (i3 != 3 || (trendInfo = this.f33689i) == null) {
                if (i3 != 2) {
                    this.f33685e = false;
                    a(z, this.f33684d);
                    fVar = f.f34595a;
                }
                this.f33685e = false;
                a(z, this.f33684d);
                fVar = f.f34601g;
            }
            this.j = c(trendInfo);
            a(z, aVar, this.f33689i);
            return;
        }
        if (this.f33684d < this.f33687g.size()) {
            trendInfo = this.f33689i;
        }
        this.f33685e = false;
        a(z, this.f33684d);
        fVar = f.f34601g;
        a(fVar.k, fVar.l);
    }

    public boolean b(@NonNull TrendInfo trendInfo) {
        if (this.f33685e) {
            return false;
        }
        this.f33685e = true;
        this.f33684d = 0;
        this.j = c(trendInfo);
        a(true, false, 1, this.f33684d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f33683c);
        fVar.f34376b = this.f33683c.getPageScene();
        fVar.f34377c = 100L;
        aVar.f34510a.add(fVar);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.f34362c = 1;
        cVar.f34363d = this.f33688h;
        aVar.f34511b = cVar;
        a(true, aVar, trendInfo);
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
    }
}
