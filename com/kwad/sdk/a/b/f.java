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
    public ViewGroup f32342b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32343c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32344d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32345e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32346f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f32347g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32348h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32349i = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            f.this.e();
        }
    };
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f32345e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f32347g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f32345e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f32346f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f32345e.setText(com.kwad.sdk.core.response.b.a.w(f.this.f32347g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f32345e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f32343c, com.kwad.sdk.core.response.b.a.o(this.f32347g), this.f32346f, 12);
        this.f32344d.setText(com.kwad.sdk.core.response.b.a.q(this.f32347g));
        this.f32345e.setText(com.kwad.sdk.core.response.b.a.w(this.f32347g));
        com.kwad.sdk.core.download.b.b bVar = this.f32348h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f32342b.setOnClickListener(this);
        this.f32342b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f32342b.getContext(), this.f32346f, new a.InterfaceC0382a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f32346f, 2, ((com.kwad.sdk.a.a.a) f.this).f32304a.f32307c.getTouchCoords());
            }
        }, this.f32348h);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f32304a.f32305a.onAdClicked(this.f32342b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f32304a.f32308d;
        this.f32346f = adTemplate;
        this.f32347g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32304a;
        this.f32348h = bVar.f32309e;
        bVar.f32310f.a(this.f32349i);
        this.f32342b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32304a.f32310f.b(this.f32349i);
        com.kwad.sdk.core.download.b.b bVar = this.f32348h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32342b = (ViewGroup) b(R.id.ksad_video_complete_app_container);
        this.f32343c = (ImageView) b(R.id.ksad_app_icon);
        this.f32344d = (TextView) b(R.id.ksad_app_name);
        this.f32345e = (TextView) b(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32342b) {
            f();
            g();
        }
    }
}
