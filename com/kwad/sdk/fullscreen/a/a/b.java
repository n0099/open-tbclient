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
    public ImageView f33288b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33289c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33290d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33291e;

    /* renamed from: f  reason: collision with root package name */
    public String f33292f;

    /* renamed from: g  reason: collision with root package name */
    public long f33293g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f33294h = new e() { // from class: com.kwad.sdk.fullscreen.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.f33293g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f33289c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f33290d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f33289c.setText(e2);
        this.f33289c.setVisibility(0);
        this.f33289c.setOnClickListener(this);
        m();
    }

    private void m() {
        com.kwad.sdk.core.report.b.c(this.f33290d, 18, ((com.kwad.sdk.reward.d) this).f33768a.f33493d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f33290d, 40, ((com.kwad.sdk.reward.d) this).f33768a.f33497h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f33768a.f33493d);
        ((com.kwad.sdk.reward.d) this).f33768a.f33491b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f33768a.f33495f;
        this.f33290d = adTemplate;
        this.f33293g = com.kwad.sdk.core.response.b.b.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f33290d);
        this.f33292f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33768a;
        this.f33291e = aVar.j;
        aVar.f33498i.a(this.f33294h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33289c = (TextView) a(R.id.ksad_detail_call_btn);
        this.f33288b = (ImageView) a(R.id.ksad_skip_icon);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f33292f)) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f33768a.f33498i.b(this.f33294h);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33289c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33290d, new a.InterfaceC0364a() { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                public void a() {
                    b.this.n();
                }
            }, this.f33291e, false);
        }
    }
}
