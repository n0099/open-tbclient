package com.kwad.sdk.fullscreen.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35672b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35673c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35674d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35675e;

    /* renamed from: f  reason: collision with root package name */
    public String f35676f;

    /* renamed from: g  reason: collision with root package name */
    public long f35677g;

    /* renamed from: h  reason: collision with root package name */
    public e f35678h = new f() { // from class: com.kwad.sdk.fullscreen.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.f35677g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f35673c.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f35674d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f35673c.getLayoutParams();
        ImageView imageView = this.f35672b;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f35673c.setLayoutParams(layoutParams);
        this.f35673c.setText(j);
        this.f35673c.setVisibility(0);
        this.f35673c.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f35674d, 18, ((com.kwad.sdk.reward.d) this).f37201a.f36953d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f35674d, 40, ((com.kwad.sdk.reward.d) this).f37201a.f36957h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f37201a.f36953d);
        ((com.kwad.sdk.reward.d) this).f37201a.f36951b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f37201a.f36955f;
        this.f35674d = adTemplate;
        this.f35677g = com.kwad.sdk.core.response.b.b.i(adTemplate);
        String j = com.kwad.sdk.core.response.b.b.j(this.f35674d);
        this.f35676f = j;
        if (TextUtils.isEmpty(j)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37201a;
        this.f35675e = aVar.j;
        aVar.f36958i.a(this.f35678h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (TextUtils.isEmpty(this.f35676f)) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f37201a.f36958i.b(this.f35678h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35673c = (TextView) b(R.id.ksad_detail_call_btn);
        this.f35672b = (ImageView) b(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35673c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35674d, new a.InterfaceC0379a() { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    b.this.g();
                }
            }, this.f35675e);
        }
    }
}
