package com.kwad.sdk.reward.b;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.reward.d {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f36817b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f36818c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36819d = new f() { // from class: com.kwad.sdk.reward.b.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            d.this.f36817b.d();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            d.this.f36817b.a(i, i2);
            d.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.f36817b.c();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f36842a.f36607g;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36842a;
        this.f36817b = aVar.f36602b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.i;
        this.f36818c = aVar2;
        aVar2.a(this.f36819d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36818c.b(this.f36819d);
    }
}
