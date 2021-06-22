package com.kwad.sdk.reward.b;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.reward.d {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f37273b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f37274c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f37275d = new f() { // from class: com.kwad.sdk.reward.b.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            d.this.f37273b.d();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            d.this.f37273b.a(i2, i3);
            d.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.f37273b.c();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f37299a.f37054g;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37299a;
        this.f37273b = aVar.f37049b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.f37056i;
        this.f37274c = aVar2;
        aVar2.a(this.f37275d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f37274c.b(this.f37275d);
    }
}
