package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f32086b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32087c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32088d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32089e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32090f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f32091g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32092h;
    public com.kwad.sdk.contentalliance.detail.video.e i = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f32089e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f32091g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f32089e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f32090f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f32089e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f32091g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f32089e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f32087c, com.kwad.sdk.core.response.b.a.o(this.f32091g), this.f32090f, 12);
        this.f32088d.setText(com.kwad.sdk.core.response.b.a.q(this.f32091g));
        this.f32089e.setText(com.kwad.sdk.core.response.b.a.w(this.f32091g));
        com.kwad.sdk.core.download.b.b bVar = this.f32092h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f32086b.setOnClickListener(this);
        this.f32086b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f32086b.getContext(), this.f32090f, new a.InterfaceC0396a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f32090f, 2, ((com.kwad.sdk.a.a.a) f.this).f32049a.f32052c.getTouchCoords());
            }
        }, this.f32092h);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f32049a.f32050a.onAdClicked(this.f32086b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f32049a.f32053d;
        this.f32090f = adTemplate;
        this.f32091g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32049a;
        this.f32092h = bVar.f32054e;
        bVar.f32055f.a(this.i);
        this.f32086b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32049a.f32055f.b(this.i);
        com.kwad.sdk.core.download.b.b bVar = this.f32092h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32086b = (ViewGroup) b(R.id.ksad_video_complete_app_container);
        this.f32087c = (ImageView) b(R.id.ksad_app_icon);
        this.f32088d = (TextView) b(R.id.ksad_app_name);
        this.f32089e = (TextView) b(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32086b) {
            f();
            g();
        }
    }
}
