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
    public ImageView f56985b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56986c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f56987d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56988e;

    /* renamed from: f  reason: collision with root package name */
    public String f56989f;

    /* renamed from: g  reason: collision with root package name */
    public long f56990g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56991h = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= b.this.f56990g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f56986c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f56987d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f56986c.setText(e2);
        this.f56986c.setVisibility(0);
        this.f56986c.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f56987d, 18, ((g) this).a.f57250e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f56987d, 40, ((g) this).a.f57255j.getTouchCoords(), ((g) this).a.f57250e);
        ((g) this).a.f57247b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f57252g;
        this.f56987d = adTemplate;
        this.f56990g = com.kwad.sdk.core.response.a.c.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f56987d);
        this.f56989f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f56988e = aVar.l;
        aVar.k.a(this.f56991h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f56989f)) {
            return;
        }
        ((g) this).a.k.b(this.f56991h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56986c = (TextView) a(R.id.ksad_detail_call_btn);
        this.f56985b = (ImageView) a(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56986c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2106a(view.getContext()).a(this.f56987d).a(this.f56988e).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    b.this.r();
                }
            }));
        }
    }
}
