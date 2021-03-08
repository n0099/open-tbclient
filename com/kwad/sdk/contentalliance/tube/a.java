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
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.home.a.a {
    private long c;
    private SceneImpl d;
    private b f;
    private int g;
    private AtomicBoolean e = new AtomicBoolean(false);
    private b.a h = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.a.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
            a.this.a(i, str);
            a.this.e.set(false);
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            if (a.this.f5755a.isEmpty()) {
                a.this.g = 0;
                m.e();
            }
            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                adTemplate.mIsTubeEpisodeList = true;
                com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "onSuccess PhotoId=" + d.k(adTemplate.photoInfo) + " 集：" + d.B(adTemplate.photoInfo));
            }
            a.this.f5755a.addAll(adResultData.adTemplateList);
            a.e(a.this);
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            a.this.a(false, a.this.g);
            a.this.e.set(false);
        }
    };

    public a(SceneImpl sceneImpl, @NonNull TubeEpisodeDetailParam tubeEpisodeDetailParam) {
        this.d = sceneImpl;
        this.c = tubeEpisodeDetailParam.mTotalEpisodeCount;
        this.f = new b(sceneImpl, tubeEpisodeDetailParam.mTubeId, this.h);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.g;
        aVar.g = i + 1;
        return i;
    }

    private long e() {
        if (this.f5755a == null || this.f5755a.isEmpty()) {
            return 0L;
        }
        return d.k(this.f5755a.get(this.f5755a.size() - 1).photoInfo);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i) {
        if (z2 && this.f5755a.size() >= this.c) {
            a(f.g.k, f.g.l);
            return;
        }
        com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "loadData isRefresh=" + z);
        if (this.e.getAndSet(true)) {
            return;
        }
        a(z, z2, i, this.g);
        if (!c.a()) {
            if (z) {
                this.f5755a.clear();
                this.g = 0;
            }
            this.f.a(z2, e());
            return;
        }
        this.f5755a.clear();
        this.g = 0;
        m.e();
        this.f5755a.addAll(c.b());
        c.c();
        a(z, this.g);
        this.g++;
        this.e.set(false);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        this.f.a();
    }
}
