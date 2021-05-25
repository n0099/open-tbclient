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
    public TextView f33601b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33602c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33603d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33604e;

    /* renamed from: f  reason: collision with root package name */
    public long f33605f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f33606g = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.f33605f) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f33601b.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f33603d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f33601b.setText(e2);
        this.f33601b.setVisibility(0);
        this.f33601b.setOnClickListener(this);
        m();
    }

    private void m() {
        com.kwad.sdk.core.report.b.c(this.f33603d, 18, ((com.kwad.sdk.reward.d) this).f33768a.f33493d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f33603d, 40, ((com.kwad.sdk.reward.d) this).f33768a.f33497h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f33768a.f33493d);
        ((com.kwad.sdk.reward.d) this).f33768a.f33491b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33768a;
        AdTemplate adTemplate = aVar.f33495f;
        this.f33603d = adTemplate;
        this.f33604e = aVar.j;
        this.f33605f = com.kwad.sdk.core.response.b.b.d(adTemplate);
        ((com.kwad.sdk.reward.d) this).f33768a.f33498i.a(this.f33606g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33601b = (TextView) a(R.id.ksad_detail_call_btn);
        this.f33602c = (ImageView) a(R.id.ksad_detail_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33768a.f33498i.b(this.f33606g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33601b) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33603d, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.b.b.b.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                public void a() {
                    b.this.n();
                }
            }, this.f33604e, false);
        }
    }
}
