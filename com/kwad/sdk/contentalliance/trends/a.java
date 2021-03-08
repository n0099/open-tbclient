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
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.home.a.a {
    private SceneImpl c;
    private int d;
    private boolean e = false;
    private String f;
    private List<TrendInfo> g;
    private int h;
    private TrendInfo i;
    private int j;

    public a(SceneImpl sceneImpl) {
        this.c = sceneImpl;
    }

    private void a(final boolean z, h.a aVar, @NonNull final TrendInfo trendInfo) {
        final i.a aVar2 = new i.a() { // from class: com.kwad.sdk.contentalliance.trends.a.1
            @Override // com.kwad.sdk.core.g.i.a
            @MainThread
            public void a(int i, String str) {
                a.this.a(i, str);
                a.this.e = false;
            }

            @Override // com.kwad.sdk.core.g.i.a
            @MainThread
            public void a(@NonNull List<AdTemplate> list) {
                if (z) {
                    a.this.d = 0;
                    a.this.f5755a.clear();
                }
                if (a.this.f5755a.isEmpty()) {
                    m.e();
                }
                a.this.f5755a.addAll(list);
                a.this.a(z, a.this.d);
                a.this.e = false;
                a.e(a.this);
                if (a.this.j + 1 < a.this.g.size()) {
                    a.this.i = (TrendInfo) a.this.g.get(a.this.j + 1);
                } else {
                    a.this.i = null;
                }
                a.h(a.this);
            }
        };
        if (trendInfo == null) {
            aVar2.a(f.c.k, f.c.l + "(无视频资源)");
        } else {
            o.a(aVar, trendInfo, new o.c() { // from class: com.kwad.sdk.contentalliance.trends.a.2
                @Override // com.kwad.sdk.core.g.o.c
                public void a(int i, String str) {
                    aVar2.a(i, str);
                }

                @Override // com.kwad.sdk.core.g.o.c
                public void a(@NonNull List<AdTemplate> list) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            aVar2.a(list);
                            return;
                        }
                        AdTemplate adTemplate = list.get(i2);
                        adTemplate.mCurrentTrendTitle = trendInfo.toJson().toString();
                        if (i2 == 0 && a.this.d > 0 && a.this.d - 1 < a.this.g.size()) {
                            adTemplate.mTrendSlideType = "下一个热点";
                        } else if (i2 == list.size() - 1 && a.this.d + 1 < a.this.g.size()) {
                            adTemplate.mTrendSlideType = "上一个热点";
                        }
                        i = i2 + 1;
                    }
                }
            });
        }
    }

    private int c(TrendInfo trendInfo) {
        if (trendInfo != null && this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                if (trendInfo.trendId == this.g.get(i).trendId) {
                    return i;
                }
            }
        }
        return 0;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.d;
        aVar.d = i + 1;
        return i;
    }

    static /* synthetic */ int h(a aVar) {
        int i = aVar.h;
        aVar.h = i + 1;
        return i;
    }

    public void a(TrendInfo trendInfo) {
        this.i = trendInfo;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f = str;
        this.g = TrendInfo.asList(str);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i) {
        int i2 = 1;
        if (this.e) {
            return;
        }
        this.e = true;
        com.kwad.sdk.core.d.a.a("DataFetcher", "loadData isRefresh=" + z);
        a(z, z2, i, this.d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.c);
        fVar.b = this.c.getPageScene();
        fVar.c = 100L;
        aVar.f6152a.add(fVar);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        switch (i) {
            case 0:
                i2 = 3;
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
                i2 = 2;
                break;
            default:
                i2 = 0;
                break;
        }
        cVar.c = i2;
        cVar.d = this.h;
        aVar.b = cVar;
        if (this.f != null && this.g.size() > 0) {
            if (this.d < this.g.size() && this.i != null) {
                this.j = c(this.i);
                a(z, aVar, this.i);
                return;
            }
            this.e = false;
            a(z, this.d);
            a(f.g.k, f.g.l);
        } else if (i2 == 3 && this.i != null) {
            this.j = c(this.i);
            a(z, aVar, this.i);
        } else if (i2 == 2) {
            this.e = false;
            a(z, this.d);
            a(f.g.k, f.g.l);
        } else {
            this.e = false;
            a(z, this.d);
            a(f.f6187a.k, f.f6187a.l);
        }
    }

    public boolean b(@NonNull TrendInfo trendInfo) {
        if (this.e) {
            return false;
        }
        this.e = true;
        this.d = 0;
        this.j = c(trendInfo);
        a(true, false, 1, this.d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.c);
        fVar.b = this.c.getPageScene();
        fVar.c = 100L;
        aVar.f6152a.add(fVar);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.c = 1;
        cVar.d = this.h;
        aVar.b = cVar;
        a(true, aVar, trendInfo);
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
    }
}
