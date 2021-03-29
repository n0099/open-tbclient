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
    public TextView f36319b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36320c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f36321d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36322e;

    /* renamed from: f  reason: collision with root package name */
    public long f36323f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36324g = new f() { // from class: com.kwad.sdk.reward.b.b.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.f36323f) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f36319b.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f36321d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f36319b.getLayoutParams();
        ImageView imageView = this.f36320c;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f36319b.setLayoutParams(layoutParams);
        this.f36319b.setText(j);
        this.f36319b.setVisibility(0);
        this.f36319b.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f36321d, 18, ((com.kwad.sdk.reward.d) this).f36458a.f36220d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f36321d, 40, ((com.kwad.sdk.reward.d) this).f36458a.f36224h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36458a.f36220d);
        ((com.kwad.sdk.reward.d) this).f36458a.f36218b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36458a;
        AdTemplate adTemplate = aVar.f36222f;
        this.f36321d = adTemplate;
        this.f36322e = aVar.j;
        this.f36323f = com.kwad.sdk.core.response.b.b.i(adTemplate);
        ((com.kwad.sdk.reward.d) this).f36458a.i.a(this.f36324g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36458a.i.b(this.f36324g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36319b = (TextView) b(R.id.ksad_detail_call_btn);
        this.f36320c = (ImageView) b(R.id.ksad_detail_close_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36319b) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36321d, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.b.b.b.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    b.this.g();
                }
            }, this.f36322e);
        }
    }
}
