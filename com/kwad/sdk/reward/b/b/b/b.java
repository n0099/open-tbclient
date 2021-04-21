package com.kwad.sdk.reward.b.b.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f36703b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36704c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f36705d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36706e;

    /* renamed from: f  reason: collision with root package name */
    public long f36707f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36708g = new f() { // from class: com.kwad.sdk.reward.b.b.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.f36707f) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f36703b.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f36705d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f36703b.getLayoutParams();
        ImageView imageView = this.f36704c;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f36703b.setLayoutParams(layoutParams);
        this.f36703b.setText(j);
        this.f36703b.setVisibility(0);
        this.f36703b.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f36705d, 18, ((com.kwad.sdk.reward.d) this).f36842a.f36604d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f36705d, 40, ((com.kwad.sdk.reward.d) this).f36842a.f36608h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36842a.f36604d);
        ((com.kwad.sdk.reward.d) this).f36842a.f36602b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36842a;
        AdTemplate adTemplate = aVar.f36606f;
        this.f36705d = adTemplate;
        this.f36706e = aVar.j;
        this.f36707f = com.kwad.sdk.core.response.b.b.i(adTemplate);
        ((com.kwad.sdk.reward.d) this).f36842a.i.a(this.f36708g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36842a.i.b(this.f36708g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36703b = (TextView) b(R.id.ksad_detail_call_btn);
        this.f36704c = (ImageView) b(R.id.ksad_detail_close_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36703b) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36705d, new a.InterfaceC0396a() { // from class: com.kwad.sdk.reward.b.b.b.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                public void a() {
                    b.this.g();
                }
            }, this.f36706e);
        }
    }
}
