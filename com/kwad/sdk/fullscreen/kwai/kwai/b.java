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
/* loaded from: classes7.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f40533b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40534c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f40535d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40536e;

    /* renamed from: f  reason: collision with root package name */
    public String f40537f;

    /* renamed from: g  reason: collision with root package name */
    public long f40538g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40539h = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.f40538g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f40534c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f40535d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f40534c.setText(e2);
        this.f40534c.setVisibility(0);
        this.f40534c.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f40535d, 18, ((g) this).a.f40745e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f40535d, 40, ((g) this).a.j.getTouchCoords(), ((g) this).a.f40745e);
        ((g) this).a.f40742b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f40747g;
        this.f40535d = adTemplate;
        this.f40538g = com.kwad.sdk.core.response.a.c.d(adTemplate);
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f40535d);
        this.f40537f = e2;
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f40536e = aVar.l;
        aVar.k.a(this.f40539h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f40537f)) {
            return;
        }
        ((g) this).a.k.b(this.f40539h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40534c = (TextView) a(R.id.obfuscated_res_0x7f091064);
        this.f40533b = (ImageView) a(R.id.obfuscated_res_0x7f091138);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40534c) {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f40535d).a(this.f40536e).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    b.this.r();
                }
            }));
        }
    }
}
