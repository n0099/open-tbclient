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
/* loaded from: classes5.dex */
public class f extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f32244b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32245c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32246d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32247e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32248f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f32249g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32250h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32251i = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f32247e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f32249g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f32247e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f32248f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f32247e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f32249g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f32247e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f32245c, com.kwad.sdk.core.response.b.a.o(this.f32249g), this.f32248f, 12);
        this.f32246d.setText(com.kwad.sdk.core.response.b.a.q(this.f32249g));
        this.f32247e.setText(com.kwad.sdk.core.response.b.a.w(this.f32249g));
        com.kwad.sdk.core.download.b.b bVar = this.f32250h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f32244b.setOnClickListener(this);
        this.f32244b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f32244b.getContext(), this.f32248f, new a.InterfaceC0379a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f32248f, 2, ((com.kwad.sdk.a.a.a) f.this).f32206a.f32209c.getTouchCoords());
            }
        }, this.f32250h);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f32206a.f32207a.onAdClicked(this.f32244b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f32206a.f32210d;
        this.f32248f = adTemplate;
        this.f32249g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32206a;
        this.f32250h = bVar.f32211e;
        bVar.f32212f.a(this.f32251i);
        this.f32244b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.b(this.f32251i);
        com.kwad.sdk.core.download.b.b bVar = this.f32250h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32244b = (ViewGroup) b(R.id.ksad_video_complete_app_container);
        this.f32245c = (ImageView) b(R.id.ksad_app_icon);
        this.f32246d = (TextView) b(R.id.ksad_app_name);
        this.f32247e = (TextView) b(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32244b) {
            f();
            g();
        }
    }
}
