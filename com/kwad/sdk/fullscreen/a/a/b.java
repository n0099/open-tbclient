package com.kwad.sdk.fullscreen.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34114b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34115c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34116d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34117e;

    /* renamed from: f  reason: collision with root package name */
    public String f34118f;

    /* renamed from: g  reason: collision with root package name */
    public long f34119g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f34120h = new e() { // from class: com.kwad.sdk.fullscreen.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.f34119g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f34115c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f34116d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f34115c.setText(e2);
        this.f34115c.setVisibility(0);
        this.f34115c.setOnClickListener(this);
        m();
    }

    private void m() {
        com.kwad.sdk.core.report.b.c(this.f34116d, 18, ((com.kwad.sdk.reward.d) this).f34594a.f34319d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f34116d, 40, ((com.kwad.sdk.reward.d) this).f34594a.f34323h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f34594a.f34319d);
        ((com.kwad.sdk.reward.d) this).f34594a.f34317b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f34594a.f34321f;
        this.f34116d = adTemplate;
        this.f34119g = com.kwad.sdk.core.response.b.b.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f34116d);
        this.f34118f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        this.f34117e = aVar.j;
        aVar.f34324i.a(this.f34120h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34115c = (TextView) a(R.id.ksad_detail_call_btn);
        this.f34114b = (ImageView) a(R.id.ksad_skip_icon);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f34118f)) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.f34120h);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34115c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34116d, new a.InterfaceC0376a() { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                public void a() {
                    b.this.n();
                }
            }, this.f34117e, false);
        }
    }
}
