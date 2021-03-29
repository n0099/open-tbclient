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
    public long f33115c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f33116d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f33117e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public b f33118f;

    /* renamed from: g  reason: collision with root package name */
    public int f33119g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f33120h;

    public a(SceneImpl sceneImpl, @NonNull TubeEpisodeDetailParam tubeEpisodeDetailParam) {
        b.a aVar = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.a.1
            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i, String str) {
                a.this.a(i, str);
                a.this.f33117e.set(false);
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                if (a.this.f32562a.isEmpty()) {
                    a.this.f33119g = 0;
                    m.e();
                }
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    adTemplate.mIsTubeEpisodeList = true;
                    com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "onSuccess PhotoId=" + d.k(adTemplate.photoInfo) + " 集：" + d.B(adTemplate.photoInfo));
                }
                a.this.f32562a.addAll(adResultData.adTemplateList);
                a.e(a.this);
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                a aVar2 = a.this;
                aVar2.a(false, aVar2.f33119g);
                a.this.f33117e.set(false);
            }
        };
        this.f33120h = aVar;
        this.f33116d = sceneImpl;
        this.f33115c = tubeEpisodeDetailParam.mTotalEpisodeCount;
        this.f33118f = new b(sceneImpl, tubeEpisodeDetailParam.mTubeId, aVar);
    }

    public static /* synthetic */ int e(a aVar) {
        int i = aVar.f33119g;
        aVar.f33119g = i + 1;
        return i;
    }

    private long e() {
        List<AdTemplate> list = this.f32562a;
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        List<AdTemplate> list2 = this.f32562a;
        return d.k(list2.get(list2.size() - 1).photoInfo);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i) {
        if (z2 && this.f32562a.size() >= this.f33115c) {
            f fVar = f.f33875g;
            a(fVar.k, fVar.l);
            return;
        }
        com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "loadData isRefresh=" + z);
        if (this.f33117e.getAndSet(true)) {
            return;
        }
        a(z, z2, i, this.f33119g);
        if (!c.a()) {
            if (z) {
                this.f32562a.clear();
                this.f33119g = 0;
            }
            this.f33118f.a(z2, e());
            return;
        }
        this.f32562a.clear();
        this.f33119g = 0;
        m.e();
        this.f32562a.addAll(c.b());
        c.c();
        a(z, this.f33119g);
        this.f33119g++;
        this.f33117e.set(false);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        this.f33118f.a();
    }
}
