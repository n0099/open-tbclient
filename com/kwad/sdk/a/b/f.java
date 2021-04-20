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
    public ViewGroup f31991b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31992c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31993d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31994e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f31995f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f31996g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31997h;
    public com.kwad.sdk.contentalliance.detail.video.e i = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f31994e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f31996g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f31994e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f31995f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f31994e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f31996g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f31994e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f31992c, com.kwad.sdk.core.response.b.a.o(this.f31996g), this.f31995f, 12);
        this.f31993d.setText(com.kwad.sdk.core.response.b.a.q(this.f31996g));
        this.f31994e.setText(com.kwad.sdk.core.response.b.a.w(this.f31996g));
        com.kwad.sdk.core.download.b.b bVar = this.f31997h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f31991b.setOnClickListener(this);
        this.f31991b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f31991b.getContext(), this.f31995f, new a.InterfaceC0393a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f31995f, 2, ((com.kwad.sdk.a.a.a) f.this).f31954a.f31957c.getTouchCoords());
            }
        }, this.f31997h);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f31954a.f31955a.onAdClicked(this.f31991b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31954a.f31958d;
        this.f31995f = adTemplate;
        this.f31996g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31954a;
        this.f31997h = bVar.f31959e;
        bVar.f31960f.a(this.i);
        this.f31991b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.b(this.i);
        com.kwad.sdk.core.download.b.b bVar = this.f31997h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31991b = (ViewGroup) b(R.id.ksad_video_complete_app_container);
        this.f31992c = (ImageView) b(R.id.ksad_app_icon);
        this.f31993d = (TextView) b(R.id.ksad_app_name);
        this.f31994e = (TextView) b(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31991b) {
            f();
            g();
        }
    }
}
