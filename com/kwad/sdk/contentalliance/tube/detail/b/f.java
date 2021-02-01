package com.kwad.sdk.contentalliance.tube.detail.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Set;
/* loaded from: classes3.dex */
public class f extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.contentalliance.tube.b f8945b;
    private Set<b.a> c;
    private b.a d = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.f.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
            for (b.a aVar : f.this.c) {
                aVar.a(z);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed isLoadMore" + z + " code=" + i + " msg=" + str);
            for (b.a aVar : f.this.c) {
                aVar.a(z, i, str);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed OK");
            for (b.a aVar : f.this.c) {
                aVar.a(z, adResultData);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            for (b.a aVar : f.this.c) {
                aVar.b(z);
            }
        }
    };
    private com.kwad.sdk.contentalliance.tube.detail.a e = new com.kwad.sdk.contentalliance.tube.detail.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.f.2
        @Override // com.kwad.sdk.contentalliance.tube.detail.a
        public void a(long j) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "onLoadMore to load feed");
            f.this.f8945b.a(true, j);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f8924a.d;
        this.f8945b = new com.kwad.sdk.contentalliance.tube.b(this.f8924a.f, this.f8924a.f8926b.getTubeId(), this.d);
        this.f8924a.g = this.f8945b;
        this.f8945b.a(false, 0L);
        this.f8924a.e.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8924a.e.remove(this.e);
        this.f8945b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }
}
