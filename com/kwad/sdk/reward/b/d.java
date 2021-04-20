package com.kwad.sdk.reward.b;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.reward.d {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f36722b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f36723c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36724d = new f() { // from class: com.kwad.sdk.reward.b.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            d.this.f36722b.d();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            d.this.f36722b.a(i, i2);
            d.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.f36722b.c();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f36747a.f36512g;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36747a;
        this.f36722b = aVar.f36507b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.i;
        this.f36723c = aVar2;
        aVar2.a(this.f36724d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36723c.b(this.f36724d);
    }
}
