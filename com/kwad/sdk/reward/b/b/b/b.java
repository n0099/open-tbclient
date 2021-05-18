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
    public TextView f33672b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33673c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33674d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33675e;

    /* renamed from: f  reason: collision with root package name */
    public long f33676f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f33677g = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.f33676f) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f33672b.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f33674d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f33672b.setText(e2);
        this.f33672b.setVisibility(0);
        this.f33672b.setOnClickListener(this);
        m();
    }

    private void m() {
        com.kwad.sdk.core.report.b.c(this.f33674d, 18, ((com.kwad.sdk.reward.d) this).f33839a.f33564d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f33674d, 40, ((com.kwad.sdk.reward.d) this).f33839a.f33568h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f33839a.f33564d);
        ((com.kwad.sdk.reward.d) this).f33839a.f33562b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        AdTemplate adTemplate = aVar.f33566f;
        this.f33674d = adTemplate;
        this.f33675e = aVar.j;
        this.f33676f = com.kwad.sdk.core.response.b.b.d(adTemplate);
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.a(this.f33677g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33672b = (TextView) a(R.id.ksad_detail_call_btn);
        this.f33673c = (ImageView) a(R.id.ksad_detail_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.b(this.f33677g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33672b) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33674d, new a.InterfaceC0363a() { // from class: com.kwad.sdk.reward.b.b.b.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
                public void a() {
                    b.this.n();
                }
            }, this.f33675e, false);
        }
    }
}
