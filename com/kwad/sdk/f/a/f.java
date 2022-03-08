package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class f extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55375b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f55376c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55377d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55378e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f55379f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f55380g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55381h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55382i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.f.1
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
    public KsAppDownloadListener f55383j = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.f.a.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f55378e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f55380g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f55378e.setText(com.kwad.sdk.core.response.a.a.a(f.this.f55379f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f55378e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f55380g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f55378e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    private void b(int i2) {
        com.kwad.sdk.core.download.a.a.a(new a.C2095a(this.f55375b.getContext()).a(this.f55379f).a(i2).a(this.f55381h).a(new a.b() { // from class: com.kwad.sdk.f.a.f.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(f.this.f55379f, 2, ((com.kwad.sdk.f.kwai.a) f.this).a.f55420c.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f55376c, com.kwad.sdk.core.response.a.a.au(this.f55380g), this.f55379f, 12);
        this.f55377d.setText(com.kwad.sdk.core.response.a.a.t(this.f55380g));
        this.f55378e.setText(com.kwad.sdk.core.response.a.a.A(this.f55380g));
        com.kwad.sdk.core.download.a.b bVar = this.f55381h;
        if (bVar != null) {
            bVar.a(this.f55383j);
        }
        this.f55375b.setOnClickListener(this);
        this.f55375b.setVisibility(0);
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f55375b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f55421d;
        this.f55379f = adTemplate;
        this.f55380g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f55381h = bVar.f55422e;
        bVar.f55423f.a(this.f55382i);
        this.f55375b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.b(this.f55382i);
        com.kwad.sdk.core.download.a.b bVar = this.f55381h;
        if (bVar != null) {
            bVar.b(this.f55383j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55375b = (ViewGroup) a(R.id.ksad_video_complete_app_container);
        this.f55376c = (ImageView) a(R.id.ksad_app_icon);
        this.f55377d = (TextView) a(R.id.ksad_app_name);
        this.f55378e = (TextView) a(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (view == this.f55375b) {
            i2 = 2;
        } else if (view != this.f55378e) {
            return;
        } else {
            i2 = 1;
        }
        b(i2);
        f();
    }
}
