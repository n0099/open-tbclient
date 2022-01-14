package com.kwad.sdk.fullscreen.kwai.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
/* loaded from: classes3.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56940b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56941c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f56942d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56943e;

    /* renamed from: f  reason: collision with root package name */
    public String f56944f;

    /* renamed from: g  reason: collision with root package name */
    public long f56945g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56946h = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= b.this.f56945g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f56941c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f56942d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f56941c.setText(e2);
        this.f56941c.setVisibility(0);
        this.f56941c.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f56942d, 18, ((g) this).a.f57205e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f56942d, 40, ((g) this).a.f57210j.getTouchCoords(), ((g) this).a.f57205e);
        ((g) this).a.f57202b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f57207g;
        this.f56942d = adTemplate;
        this.f56945g = com.kwad.sdk.core.response.a.c.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f56942d);
        this.f56944f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f56943e = aVar.l;
        aVar.k.a(this.f56946h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f56944f)) {
            return;
        }
        ((g) this).a.k.b(this.f56946h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56941c = (TextView) a(R.id.ksad_detail_call_btn);
        this.f56940b = (ImageView) a(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56941c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2100a(view.getContext()).a(this.f56942d).a(this.f56943e).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    b.this.r();
                }
            }));
        }
    }
}
