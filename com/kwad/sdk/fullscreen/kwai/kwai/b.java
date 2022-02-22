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
/* loaded from: classes4.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57152b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57153c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f57154d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57155e;

    /* renamed from: f  reason: collision with root package name */
    public String f57156f;

    /* renamed from: g  reason: collision with root package name */
    public long f57157g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57158h = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= b.this.f57157g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f57153c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f57154d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f57153c.setText(e2);
        this.f57153c.setVisibility(0);
        this.f57153c.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f57154d, 18, ((g) this).a.f57417e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f57154d, 40, ((g) this).a.f57422j.getTouchCoords(), ((g) this).a.f57417e);
        ((g) this).a.f57414b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f57419g;
        this.f57154d = adTemplate;
        this.f57157g = com.kwad.sdk.core.response.a.c.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f57154d);
        this.f57156f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57155e = aVar.l;
        aVar.k.a(this.f57158h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f57156f)) {
            return;
        }
        ((g) this).a.k.b(this.f57158h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57153c = (TextView) a(R.id.ksad_detail_call_btn);
        this.f57152b = (ImageView) a(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57153c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2116a(view.getContext()).a(this.f57154d).a(this.f57155e).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    b.this.r();
                }
            }));
        }
    }
}
