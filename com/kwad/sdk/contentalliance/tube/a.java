package com.kwad.sdk.contentalliance.tube;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.home.c;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.episode.TubeEpisodeDetailParam;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.home.a.a {

    /* renamed from: c  reason: collision with root package name */
    public long f33499c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f33500d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f33501e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public b f33502f;

    /* renamed from: g  reason: collision with root package name */
    public int f33503g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f33504h;

    public a(SceneImpl sceneImpl, @NonNull TubeEpisodeDetailParam tubeEpisodeDetailParam) {
        b.a aVar = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.a.1
            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i, String str) {
                a.this.a(i, str);
                a.this.f33501e.set(false);
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                if (a.this.f32946a.isEmpty()) {
                    a.this.f33503g = 0;
                    m.e();
                }
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    adTemplate.mIsTubeEpisodeList = true;
                    com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "onSuccess PhotoId=" + d.k(adTemplate.photoInfo) + " 集：" + d.B(adTemplate.photoInfo));
                }
                a.this.f32946a.addAll(adResultData.adTemplateList);
                a.e(a.this);
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                a aVar2 = a.this;
                aVar2.a(false, aVar2.f33503g);
                a.this.f33501e.set(false);
            }
        };
        this.f33504h = aVar;
        this.f33500d = sceneImpl;
        this.f33499c = tubeEpisodeDetailParam.mTotalEpisodeCount;
        this.f33502f = new b(sceneImpl, tubeEpisodeDetailParam.mTubeId, aVar);
    }

    public static /* synthetic */ int e(a aVar) {
        int i = aVar.f33503g;
        aVar.f33503g = i + 1;
        return i;
    }

    private long e() {
        List<AdTemplate> list = this.f32946a;
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        List<AdTemplate> list2 = this.f32946a;
        return d.k(list2.get(list2.size() - 1).photoInfo);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i) {
        if (z2 && this.f32946a.size() >= this.f33499c) {
            f fVar = f.f34259g;
            a(fVar.k, fVar.l);
            return;
        }
        com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "loadData isRefresh=" + z);
        if (this.f33501e.getAndSet(true)) {
            return;
        }
        a(z, z2, i, this.f33503g);
        if (!c.a()) {
            if (z) {
                this.f32946a.clear();
                this.f33503g = 0;
            }
            this.f33502f.a(z2, e());
            return;
        }
        this.f32946a.clear();
        this.f33503g = 0;
        m.e();
        this.f32946a.addAll(c.b());
        c.c();
        a(z, this.f33503g);
        this.f33503g++;
        this.f33501e.set(false);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        this.f33502f.a();
    }
}
