package com.kwad.sdk.contentalliance.tube.detail.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Set;
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.b f33917b;

    /* renamed from: c  reason: collision with root package name */
    public Set<b.a> f33918c;

    /* renamed from: d  reason: collision with root package name */
    public b.a f33919d = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.f.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
            for (b.a aVar : f.this.f33918c) {
                aVar.a(z);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i2, String str) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed isLoadMore" + z + " code=" + i2 + " msg=" + str);
            for (b.a aVar : f.this.f33918c) {
                aVar.a(z, i2, str);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed OK");
            for (b.a aVar : f.this.f33918c) {
                aVar.a(z, adResultData);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            for (b.a aVar : f.this.f33918c) {
                aVar.b(z);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.detail.a f33920e = new com.kwad.sdk.contentalliance.tube.detail.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.f.2
        @Override // com.kwad.sdk.contentalliance.tube.detail.a
        public void a(long j) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "onLoadMore to load feed");
            f.this.f33917b.a(true, j);
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a;
        this.f33918c = bVar.f33870d;
        com.kwad.sdk.contentalliance.tube.b bVar2 = new com.kwad.sdk.contentalliance.tube.b(bVar.f33872f, bVar.f33868b.getTubeId(), this.f33919d);
        this.f33917b = bVar2;
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a.f33873g = bVar2;
        bVar2.a(false, 0L);
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a.f33871e.add(this.f33920e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a.f33871e.remove(this.f33920e);
        this.f33917b.a();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }
}
