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
    public ImageView f33359b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33360c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33361d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33362e;

    /* renamed from: f  reason: collision with root package name */
    public String f33363f;

    /* renamed from: g  reason: collision with root package name */
    public long f33364g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f33365h = new e() { // from class: com.kwad.sdk.fullscreen.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.f33364g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f33360c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f33361d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f33360c.setText(e2);
        this.f33360c.setVisibility(0);
        this.f33360c.setOnClickListener(this);
        m();
    }

    private void m() {
        com.kwad.sdk.core.report.b.c(this.f33361d, 18, ((com.kwad.sdk.reward.d) this).f33839a.f33564d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f33361d, 40, ((com.kwad.sdk.reward.d) this).f33839a.f33568h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f33839a.f33564d);
        ((com.kwad.sdk.reward.d) this).f33839a.f33562b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f33839a.f33566f;
        this.f33361d = adTemplate;
        this.f33364g = com.kwad.sdk.core.response.b.b.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f33361d);
        this.f33363f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        this.f33362e = aVar.j;
        aVar.f33569i.a(this.f33365h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33360c = (TextView) a(R.id.ksad_detail_call_btn);
        this.f33359b = (ImageView) a(R.id.ksad_skip_icon);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f33363f)) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.b(this.f33365h);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33360c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33361d, new a.InterfaceC0363a() { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
                public void a() {
                    b.this.n();
                }
            }, this.f33362e, false);
        }
    }
}
