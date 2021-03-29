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
    public ViewGroup f31702b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31703c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31704d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31705e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f31706f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f31707g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31708h;
    public com.kwad.sdk.contentalliance.detail.video.e i = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f31705e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f31707g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f31705e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f31706f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f31705e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f31707g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f31705e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f31703c, com.kwad.sdk.core.response.b.a.o(this.f31707g), this.f31706f, 12);
        this.f31704d.setText(com.kwad.sdk.core.response.b.a.q(this.f31707g));
        this.f31705e.setText(com.kwad.sdk.core.response.b.a.w(this.f31707g));
        com.kwad.sdk.core.download.b.b bVar = this.f31708h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f31702b.setOnClickListener(this);
        this.f31702b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f31702b.getContext(), this.f31706f, new a.InterfaceC0379a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f31706f, 2, ((com.kwad.sdk.a.a.a) f.this).f31665a.f31668c.getTouchCoords());
            }
        }, this.f31708h);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f31665a.f31666a.onAdClicked(this.f31702b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31665a.f31669d;
        this.f31706f = adTemplate;
        this.f31707g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31665a;
        this.f31708h = bVar.f31670e;
        bVar.f31671f.a(this.i);
        this.f31702b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31665a.f31671f.b(this.i);
        com.kwad.sdk.core.download.b.b bVar = this.f31708h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31702b = (ViewGroup) b(R.id.ksad_video_complete_app_container);
        this.f31703c = (ImageView) b(R.id.ksad_app_icon);
        this.f31704d = (TextView) b(R.id.ksad_app_name);
        this.f31705e = (TextView) b(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31702b) {
            f();
            g();
        }
    }
}
