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
/* loaded from: classes3.dex */
public class f extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56813b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f56814c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56815d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56816e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f56817f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f56818g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56819h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56820i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.f.1
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
    public KsAppDownloadListener f56821j = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.f.a.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f56816e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f56818g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f56816e.setText(com.kwad.sdk.core.response.a.a.a(f.this.f56817f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f56816e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f56818g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f56816e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    private void b(int i2) {
        com.kwad.sdk.core.download.a.a.a(new a.C2100a(this.f56813b.getContext()).a(this.f56817f).a(i2).a(this.f56819h).a(new a.b() { // from class: com.kwad.sdk.f.a.f.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(f.this.f56817f, 2, ((com.kwad.sdk.f.kwai.a) f.this).a.f56858c.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f56814c, com.kwad.sdk.core.response.a.a.au(this.f56818g), this.f56817f, 12);
        this.f56815d.setText(com.kwad.sdk.core.response.a.a.t(this.f56818g));
        this.f56816e.setText(com.kwad.sdk.core.response.a.a.A(this.f56818g));
        com.kwad.sdk.core.download.a.b bVar = this.f56819h;
        if (bVar != null) {
            bVar.a(this.f56821j);
        }
        this.f56813b.setOnClickListener(this);
        this.f56813b.setVisibility(0);
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f56813b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f56859d;
        this.f56817f = adTemplate;
        this.f56818g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f56819h = bVar.f56860e;
        bVar.f56861f.a(this.f56820i);
        this.f56813b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f56861f.b(this.f56820i);
        com.kwad.sdk.core.download.a.b bVar = this.f56819h;
        if (bVar != null) {
            bVar.b(this.f56821j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56813b = (ViewGroup) a(R.id.ksad_video_complete_app_container);
        this.f56814c = (ImageView) a(R.id.ksad_app_icon);
        this.f56815d = (TextView) a(R.id.ksad_app_name);
        this.f56816e = (TextView) a(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (view == this.f56813b) {
            i2 = 2;
        } else if (view != this.f56816e) {
            return;
        } else {
            i2 = 1;
        }
        b(i2);
        f();
    }
}
