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
    public ViewGroup f31701b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31702c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31703d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31704e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f31705f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f31706g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31707h;
    public com.kwad.sdk.contentalliance.detail.video.e i = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f31704e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f31706g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f31704e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f31705f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f31704e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f31706g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f31704e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f31702c, com.kwad.sdk.core.response.b.a.o(this.f31706g), this.f31705f, 12);
        this.f31703d.setText(com.kwad.sdk.core.response.b.a.q(this.f31706g));
        this.f31704e.setText(com.kwad.sdk.core.response.b.a.w(this.f31706g));
        com.kwad.sdk.core.download.b.b bVar = this.f31707h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f31701b.setOnClickListener(this);
        this.f31701b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f31701b.getContext(), this.f31705f, new a.InterfaceC0378a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f31705f, 2, ((com.kwad.sdk.a.a.a) f.this).f31664a.f31667c.getTouchCoords());
            }
        }, this.f31707h);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f31664a.f31665a.onAdClicked(this.f31701b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31664a.f31668d;
        this.f31705f = adTemplate;
        this.f31706g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31664a;
        this.f31707h = bVar.f31669e;
        bVar.f31670f.a(this.i);
        this.f31701b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31664a.f31670f.b(this.i);
        com.kwad.sdk.core.download.b.b bVar = this.f31707h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31701b = (ViewGroup) b(R.id.ksad_video_complete_app_container);
        this.f31702c = (ImageView) b(R.id.ksad_app_icon);
        this.f31703d = (TextView) b(R.id.ksad_app_name);
        this.f31704e = (TextView) b(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31701b) {
            f();
            g();
        }
    }
}
