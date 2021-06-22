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
    public long f33822c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f33823d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f33824e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public b f33825f;

    /* renamed from: g  reason: collision with root package name */
    public int f33826g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f33827h;

    public a(SceneImpl sceneImpl, @NonNull TubeEpisodeDetailParam tubeEpisodeDetailParam) {
        b.a aVar = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.a.1
            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i2, String str) {
                a.this.a(i2, str);
                a.this.f33824e.set(false);
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                if (a.this.f33241a.isEmpty()) {
                    a.this.f33826g = 0;
                    m.e();
                }
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    adTemplate.mIsTubeEpisodeList = true;
                    com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "onSuccess PhotoId=" + d.k(adTemplate.photoInfo) + " 集：" + d.B(adTemplate.photoInfo));
                }
                a.this.f33241a.addAll(adResultData.adTemplateList);
                a.e(a.this);
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                a aVar2 = a.this;
                aVar2.a(false, aVar2.f33826g);
                a.this.f33824e.set(false);
            }
        };
        this.f33827h = aVar;
        this.f33823d = sceneImpl;
        this.f33822c = tubeEpisodeDetailParam.mTotalEpisodeCount;
        this.f33825f = new b(sceneImpl, tubeEpisodeDetailParam.mTubeId, aVar);
    }

    public static /* synthetic */ int e(a aVar) {
        int i2 = aVar.f33826g;
        aVar.f33826g = i2 + 1;
        return i2;
    }

    private long e() {
        List<AdTemplate> list = this.f33241a;
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        List<AdTemplate> list2 = this.f33241a;
        return d.k(list2.get(list2.size() - 1).photoInfo);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i2) {
        if (z2 && this.f33241a.size() >= this.f33822c) {
            f fVar = f.f34601g;
            a(fVar.k, fVar.l);
            return;
        }
        com.kwad.sdk.core.d.a.a("DataFetcherTubeImpl", "loadData isRefresh=" + z);
        if (this.f33824e.getAndSet(true)) {
            return;
        }
        a(z, z2, i2, this.f33826g);
        if (!c.a()) {
            if (z) {
                this.f33241a.clear();
                this.f33826g = 0;
            }
            this.f33825f.a(z2, e());
            return;
        }
        this.f33241a.clear();
        this.f33826g = 0;
        m.e();
        this.f33241a.addAll(c.b());
        c.c();
        a(z, this.f33826g);
        this.f33826g++;
        this.f33824e.set(false);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        this.f33825f.a();
    }
}
