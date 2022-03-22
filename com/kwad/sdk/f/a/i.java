package com.kwad.sdk.f.a;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class i extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f40445b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f40446c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40447d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            i.this.f40445b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.a.a.a(new a.C1956a(this.f40445b.getContext()).a(this.f40446c).a(((com.kwad.sdk.f.kwai.a) this).a.f40470e).a(new a.b() { // from class: com.kwad.sdk.f.a.i.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(i.this.f40446c, 2, ((com.kwad.sdk.f.kwai.a) i.this).a.f40468c.getTouchCoords());
            }
        }));
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f40445b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f40446c = bVar.f40469d;
        bVar.f40471f.a(this.f40447d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f40445b.setOnClickListener(null);
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.b(this.f40447d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40445b = (DetailVideoView) a(R.id.obfuscated_res_0x7f091177);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40445b) {
            e();
            f();
        }
    }
}
