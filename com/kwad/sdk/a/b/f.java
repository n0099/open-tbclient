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
    public ViewGroup f31739b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31740c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31741d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31742e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f31743f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f31744g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31745h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31746i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f31742e.setText(com.kwad.sdk.core.response.b.a.u(f.this.f31744g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f31742e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f31743f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f31742e.setText(com.kwad.sdk.core.response.b.a.u(f.this.f31744g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f31742e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f31740c, com.kwad.sdk.core.response.b.a.n(this.f31744g), this.f31743f, 12);
        this.f31741d.setText(com.kwad.sdk.core.response.b.a.o(this.f31744g));
        this.f31742e.setText(com.kwad.sdk.core.response.b.a.u(this.f31744g));
        com.kwad.sdk.core.download.b.b bVar = this.f31745h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f31739b.setOnClickListener(this);
        this.f31739b.setVisibility(0);
    }

    private void m() {
        com.kwad.sdk.core.download.b.a.a(this.f31739b.getContext(), this.f31743f, new a.InterfaceC0363a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f31743f, 2, ((com.kwad.sdk.a.a.a) f.this).f31701a.f31704c.getTouchCoords());
            }
        }, this.f31745h, false);
    }

    private void n() {
        ((com.kwad.sdk.a.a.a) this).f31701a.f31702a.onAdClicked(this.f31739b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31701a.f31705d;
        this.f31743f = adTemplate;
        this.f31744g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31701a;
        this.f31745h = bVar.f31706e;
        bVar.f31707f.a(this.f31746i);
        this.f31739b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31739b = (ViewGroup) a(R.id.ksad_video_complete_app_container);
        this.f31740c = (ImageView) a(R.id.ksad_app_icon);
        this.f31741d = (TextView) a(R.id.ksad_app_name);
        this.f31742e = (TextView) a(R.id.ksad_app_download);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.b(this.f31746i);
        com.kwad.sdk.core.download.b.b bVar = this.f31745h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31739b) {
            m();
            n();
        }
    }
}
