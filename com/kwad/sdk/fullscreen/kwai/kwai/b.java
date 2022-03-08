package com.kwad.sdk.fullscreen.kwai.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f55502b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55503c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f55504d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55505e;

    /* renamed from: f  reason: collision with root package name */
    public String f55506f;

    /* renamed from: g  reason: collision with root package name */
    public long f55507g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55508h = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= b.this.f55507g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f55503c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f55504d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f55503c.setText(e2);
        this.f55503c.setVisibility(0);
        this.f55503c.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f55504d, 18, ((g) this).a.f55767e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f55504d, 40, ((g) this).a.f55772j.getTouchCoords(), ((g) this).a.f55767e);
        ((g) this).a.f55764b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f55769g;
        this.f55504d = adTemplate;
        this.f55507g = com.kwad.sdk.core.response.a.c.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f55504d);
        this.f55506f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f55505e = aVar.l;
        aVar.k.a(this.f55508h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f55506f)) {
            return;
        }
        ((g) this).a.k.b(this.f55508h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55503c = (TextView) a(R.id.ksad_detail_call_btn);
        this.f55502b = (ImageView) a(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55503c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2095a(view.getContext()).a(this.f55504d).a(this.f55505e).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    b.this.r();
                }
            }));
        }
    }
}
