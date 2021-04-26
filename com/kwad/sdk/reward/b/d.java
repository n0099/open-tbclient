package com.kwad.sdk.reward.b;

import android.app.Activity;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.reward.d {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f34556b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f34557c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34558d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            d.this.f34556b.a(i2, i3);
            d.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            d.this.f34556b.c();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            d.this.f34556b.d();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f34594a.f34322g;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        this.f34556b = aVar.f34317b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.f34324i;
        this.f34557c = aVar2;
        aVar2.a(this.f34558d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34557c.b(this.f34558d);
    }
}
