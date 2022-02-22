package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public class f extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57025b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57026c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57027d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57028e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f57029f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f57030g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57031h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57032i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            try {
                f.this.e();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
                com.kwad.sdk.core.kwai.a.a(th);
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public KsAppDownloadListener f57033j = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.f.a.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f57028e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f57030g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f57028e.setText(com.kwad.sdk.core.response.a.a.a(f.this.f57029f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f57028e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f57030g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f57028e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    private void b(int i2) {
        com.kwad.sdk.core.download.a.a.a(new a.C2116a(this.f57025b.getContext()).a(this.f57029f).a(i2).a(this.f57031h).a(new a.b() { // from class: com.kwad.sdk.f.a.f.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(f.this.f57029f, 2, ((com.kwad.sdk.f.kwai.a) f.this).a.f57070c.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f57026c, com.kwad.sdk.core.response.a.a.au(this.f57030g), this.f57029f, 12);
        this.f57027d.setText(com.kwad.sdk.core.response.a.a.t(this.f57030g));
        this.f57028e.setText(com.kwad.sdk.core.response.a.a.A(this.f57030g));
        com.kwad.sdk.core.download.a.b bVar = this.f57031h;
        if (bVar != null) {
            bVar.a(this.f57033j);
        }
        this.f57025b.setOnClickListener(this);
        this.f57025b.setVisibility(0);
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f57025b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f57071d;
        this.f57029f = adTemplate;
        this.f57030g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f57031h = bVar.f57072e;
        bVar.f57073f.a(this.f57032i);
        this.f57025b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f57073f.b(this.f57032i);
        com.kwad.sdk.core.download.a.b bVar = this.f57031h;
        if (bVar != null) {
            bVar.b(this.f57033j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57025b = (ViewGroup) a(R.id.ksad_video_complete_app_container);
        this.f57026c = (ImageView) a(R.id.ksad_app_icon);
        this.f57027d = (TextView) a(R.id.ksad_app_name);
        this.f57028e = (TextView) a(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (view == this.f57025b) {
            i2 = 2;
        } else if (view != this.f57028e) {
            return;
        } else {
            i2 = 1;
        }
        b(i2);
        f();
    }
}
