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
    public SceneImpl f32983c;

    /* renamed from: d  reason: collision with root package name */
    public int f32984d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32985e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f32986f;

    /* renamed from: g  reason: collision with root package name */
    public List<TrendInfo> f32987g;

    /* renamed from: h  reason: collision with root package name */
    public int f32988h;
    public TrendInfo i;
    public int j;

    public a(SceneImpl sceneImpl) {
        this.f32983c = sceneImpl;
    }

    private void a(final boolean z, h.a aVar, @NonNull final TrendInfo trendInfo) {
        final i.a aVar2 = new i.a() { // from class: com.kwad.sdk.contentalliance.trends.a.1
            @Override // com.kwad.sdk.core.g.i.a
            @MainThread
            public void a(int i, String str) {
                a.this.a(i, str);
                a.this.f32985e = false;
            }

            @Override // com.kwad.sdk.core.g.i.a
            @MainThread
            public void a(@NonNull List<AdTemplate> list) {
                a aVar3;
                TrendInfo trendInfo2;
                if (z) {
                    a.this.f32984d = 0;
                    a.this.f32561a.clear();
                }
                if (a.this.f32561a.isEmpty()) {
                    m.e();
                }
                a.this.f32561a.addAll(list);
                a aVar4 = a.this;
                aVar4.a(z, aVar4.f32984d);
                a.this.f32985e = false;
                a.e(a.this);
                if (a.this.j + 1 < a.this.f32987g.size()) {
                    aVar3 = a.this;
                    trendInfo2 = (TrendInfo) aVar3.f32987g.get(a.this.j + 1);
                } else {
                    aVar3 = a.this;
                    trendInfo2 = null;
                }
                aVar3.i = trendInfo2;
                a.h(a.this);
            }
        };
        if (trendInfo != null) {
            o.a(aVar, trendInfo, new o.c() { // from class: com.kwad.sdk.contentalliance.trends.a.2
                @Override // com.kwad.sdk.core.g.o.c
                public void a(int i, String str) {
                    aVar2.a(i, str);
                }

                @Override // com.kwad.sdk.core.g.o.c
                public void a(@NonNull List<AdTemplate> list) {
                    String str;
                    int i = 0;
                    while (i < list.size()) {
                        AdTemplate adTemplate = list.get(i);
                        adTemplate.mCurrentTrendTitle = trendInfo.toJson().toString();
                        if (i != 0 || a.this.f32984d <= 0 || a.this.f32984d - 1 >= a.this.f32987g.size()) {
                            str = (i == list.size() + (-1) && a.this.f32984d + 1 < a.this.f32987g.size()) ? "上一个热点" : "上一个热点";
                            i++;
                        } else {
                            str = "下一个热点";
                        }
                        adTemplate.mTrendSlideType = str;
                        i++;
                    }
                    aVar2.a(list);
                }
            });
            return;
        }
        int i = f.f33870c.k;
        aVar2.a(i, f.f33870c.l + "(无视频资源)");
    }

    private int c(TrendInfo trendInfo) {
        if (trendInfo != null && this.f32987g != null) {
            for (int i = 0; i < this.f32987g.size(); i++) {
                if (trendInfo.trendId == this.f32987g.get(i).trendId) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static /* synthetic */ int e(a aVar) {
        int i = aVar.f32984d;
        aVar.f32984d = i + 1;
        return i;
    }

    public static /* synthetic */ int h(a aVar) {
        int i = aVar.f32988h;
        aVar.f32988h = i + 1;
        return i;
    }

    public void a(TrendInfo trendInfo) {
        this.i = trendInfo;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f32986f = str;
        this.f32987g = TrendInfo.asList(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (r8 != null) goto L22;
     */
    @Override // com.kwad.sdk.contentalliance.home.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2, int i) {
        f fVar;
        TrendInfo trendInfo;
        if (this.f32985e) {
            return;
        }
        int i2 = 1;
        this.f32985e = true;
        com.kwad.sdk.core.d.a.a("DataFetcher", "loadData isRefresh=" + z);
        a(z, z2, i, this.f32984d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar2 = new com.kwad.sdk.core.g.a.f(this.f32983c);
        fVar2.f33651b = this.f32983c.getPageScene();
        fVar2.f33652c = 100L;
        aVar.f33784a.add(fVar2);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        if (i == 0) {
            i2 = 3;
        } else if (i != 1 && i != 2 && i != 3) {
            i2 = i != 4 ? 0 : 2;
        }
        cVar.f33638c = i2;
        cVar.f33639d = this.f32988h;
        aVar.f33785b = cVar;
        if (this.f32986f == null || this.f32987g.size() <= 0) {
            if (i2 != 3 || (trendInfo = this.i) == null) {
                if (i2 != 2) {
                    this.f32985e = false;
                    a(z, this.f32984d);
                    fVar = f.f33868a;
                }
                this.f32985e = false;
                a(z, this.f32984d);
                fVar = f.f33874g;
            }
            this.j = c(trendInfo);
            a(z, aVar, this.i);
            return;
        }
        if (this.f32984d < this.f32987g.size()) {
            trendInfo = this.i;
        }
        this.f32985e = false;
        a(z, this.f32984d);
        fVar = f.f33874g;
        a(fVar.k, fVar.l);
    }

    public boolean b(@NonNull TrendInfo trendInfo) {
        if (this.f32985e) {
            return false;
        }
        this.f32985e = true;
        this.f32984d = 0;
        this.j = c(trendInfo);
        a(true, false, 1, this.f32984d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f32983c);
        fVar.f33651b = this.f32983c.getPageScene();
        fVar.f33652c = 100L;
        aVar.f33784a.add(fVar);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.f33638c = 1;
        cVar.f33639d = this.f32988h;
        aVar.f33785b = cVar;
        a(true, aVar, trendInfo);
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
    }
}
