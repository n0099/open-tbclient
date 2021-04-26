package com.kwad.sdk.reward.b.b.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f34427b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34428c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34429d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34430e;

    /* renamed from: f  reason: collision with root package name */
    public long f34431f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34432g = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.f34431f) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f34427b.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f34429d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f34427b.setText(e2);
        this.f34427b.setVisibility(0);
        this.f34427b.setOnClickListener(this);
        m();
    }

    private void m() {
        com.kwad.sdk.core.report.b.c(this.f34429d, 18, ((com.kwad.sdk.reward.d) this).f34594a.f34319d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f34429d, 40, ((com.kwad.sdk.reward.d) this).f34594a.f34323h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f34594a.f34319d);
        ((com.kwad.sdk.reward.d) this).f34594a.f34317b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        AdTemplate adTemplate = aVar.f34321f;
        this.f34429d = adTemplate;
        this.f34430e = aVar.j;
        this.f34431f = com.kwad.sdk.core.response.b.b.d(adTemplate);
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.a(this.f34432g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34427b = (TextView) a(R.id.ksad_detail_call_btn);
        this.f34428c = (ImageView) a(R.id.ksad_detail_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.f34432g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34427b) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34429d, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.b.b.b.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                public void a() {
                    b.this.n();
                }
            }, this.f34430e, false);
        }
    }
}
