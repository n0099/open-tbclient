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
    public ImageView f59168b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59169c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f59170d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59171e;

    /* renamed from: f  reason: collision with root package name */
    public String f59172f;

    /* renamed from: g  reason: collision with root package name */
    public long f59173g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59174h = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= b.this.f59173g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f59169c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f59170d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f59169c.setText(e2);
        this.f59169c.setVisibility(0);
        this.f59169c.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f59170d, 18, ((g) this).a.f59453e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f59170d, 40, ((g) this).a.f59458j.getTouchCoords(), ((g) this).a.f59453e);
        ((g) this).a.f59450b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f59455g;
        this.f59170d = adTemplate;
        this.f59173g = com.kwad.sdk.core.response.a.c.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f59170d);
        this.f59172f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f59171e = aVar.l;
        aVar.f59459k.a(this.f59174h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f59172f)) {
            return;
        }
        ((g) this).a.f59459k.b(this.f59174h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59169c = (TextView) a(R.id.ksad_detail_call_btn);
        this.f59168b = (ImageView) a(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f59169c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2083a(view.getContext()).a(this.f59170d).a(this.f59171e).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    b.this.r();
                }
            }));
        }
    }
}
