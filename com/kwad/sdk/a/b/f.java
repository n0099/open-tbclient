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
    public ViewGroup f31668b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31669c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31670d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31671e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f31672f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f31673g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31674h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31675i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f31671e.setText(com.kwad.sdk.core.response.b.a.u(f.this.f31673g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f31671e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f31672f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f31671e.setText(com.kwad.sdk.core.response.b.a.u(f.this.f31673g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f31671e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f31669c, com.kwad.sdk.core.response.b.a.n(this.f31673g), this.f31672f, 12);
        this.f31670d.setText(com.kwad.sdk.core.response.b.a.o(this.f31673g));
        this.f31671e.setText(com.kwad.sdk.core.response.b.a.u(this.f31673g));
        com.kwad.sdk.core.download.b.b bVar = this.f31674h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f31668b.setOnClickListener(this);
        this.f31668b.setVisibility(0);
    }

    private void m() {
        com.kwad.sdk.core.download.b.a.a(this.f31668b.getContext(), this.f31672f, new a.InterfaceC0364a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f31672f, 2, ((com.kwad.sdk.a.a.a) f.this).f31630a.f31633c.getTouchCoords());
            }
        }, this.f31674h, false);
    }

    private void n() {
        ((com.kwad.sdk.a.a.a) this).f31630a.f31631a.onAdClicked(this.f31668b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31630a.f31634d;
        this.f31672f = adTemplate;
        this.f31673g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31630a;
        this.f31674h = bVar.f31635e;
        bVar.f31636f.a(this.f31675i);
        this.f31668b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31668b = (ViewGroup) a(R.id.ksad_video_complete_app_container);
        this.f31669c = (ImageView) a(R.id.ksad_app_icon);
        this.f31670d = (TextView) a(R.id.ksad_app_name);
        this.f31671e = (TextView) a(R.id.ksad_app_download);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.b(this.f31675i);
        com.kwad.sdk.core.download.b.b bVar = this.f31674h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31668b) {
            m();
            n();
        }
    }
}
