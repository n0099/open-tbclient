package com.kwad.sdk.contentalliance.tube.detail.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Set;
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.b f33591b;

    /* renamed from: c  reason: collision with root package name */
    public Set<b.a> f33592c;

    /* renamed from: d  reason: collision with root package name */
    public b.a f33593d = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.f.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
            for (b.a aVar : f.this.f33592c) {
                aVar.a(z);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed isLoadMore" + z + " code=" + i + " msg=" + str);
            for (b.a aVar : f.this.f33592c) {
                aVar.a(z, i, str);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed OK");
            for (b.a aVar : f.this.f33592c) {
                aVar.a(z, adResultData);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            for (b.a aVar : f.this.f33592c) {
                aVar.b(z);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.detail.a f33594e = new com.kwad.sdk.contentalliance.tube.detail.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.f.2
        @Override // com.kwad.sdk.contentalliance.tube.detail.a
        public void a(long j) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "onLoadMore to load feed");
            f.this.f33591b.a(true, j);
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33542a;
        this.f33592c = bVar.f33546d;
        com.kwad.sdk.contentalliance.tube.b bVar2 = new com.kwad.sdk.contentalliance.tube.b(bVar.f33548f, bVar.f33544b.getTubeId(), this.f33593d);
        this.f33591b = bVar2;
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33542a.f33549g = bVar2;
        bVar2.a(false, 0L);
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33542a.f33547e.add(this.f33594e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33542a.f33547e.remove(this.f33594e);
        this.f33591b.a();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }
}
