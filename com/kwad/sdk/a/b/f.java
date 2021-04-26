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
    public ViewGroup f32494b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32495c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32496d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32497e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32498f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f32499g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32500h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f32501i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f32497e.setText(com.kwad.sdk.core.response.b.a.u(f.this.f32499g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f32497e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f32498f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f32497e.setText(com.kwad.sdk.core.response.b.a.u(f.this.f32499g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f32497e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f32495c, com.kwad.sdk.core.response.b.a.n(this.f32499g), this.f32498f, 12);
        this.f32496d.setText(com.kwad.sdk.core.response.b.a.o(this.f32499g));
        this.f32497e.setText(com.kwad.sdk.core.response.b.a.u(this.f32499g));
        com.kwad.sdk.core.download.b.b bVar = this.f32500h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f32494b.setOnClickListener(this);
        this.f32494b.setVisibility(0);
    }

    private void m() {
        com.kwad.sdk.core.download.b.a.a(this.f32494b.getContext(), this.f32498f, new a.InterfaceC0376a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f32498f, 2, ((com.kwad.sdk.a.a.a) f.this).f32456a.f32459c.getTouchCoords());
            }
        }, this.f32500h, false);
    }

    private void n() {
        ((com.kwad.sdk.a.a.a) this).f32456a.f32457a.onAdClicked(this.f32494b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f32456a.f32460d;
        this.f32498f = adTemplate;
        this.f32499g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32456a;
        this.f32500h = bVar.f32461e;
        bVar.f32462f.a(this.f32501i);
        this.f32494b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f32494b = (ViewGroup) a(R.id.ksad_video_complete_app_container);
        this.f32495c = (ImageView) a(R.id.ksad_app_icon);
        this.f32496d = (TextView) a(R.id.ksad_app_name);
        this.f32497e = (TextView) a(R.id.ksad_app_download);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f32456a.f32462f.b(this.f32501i);
        com.kwad.sdk.core.download.b.b bVar = this.f32500h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32494b) {
            m();
            n();
        }
    }
}
