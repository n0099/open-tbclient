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
/* loaded from: classes5.dex */
public class f extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f8452b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private AdTemplate f;
    private AdInfo g;
    @Nullable
    private com.kwad.sdk.core.download.b.b h;
    private com.kwad.sdk.contentalliance.detail.video.e i = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.f.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            f.this.e();
        }
    };
    private KsAppDownloadListener j = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.a.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.e.setText(com.kwad.sdk.core.response.b.a.w(f.this.g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.e.setText(com.kwad.sdk.core.response.b.a.a(f.this.f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.e.setText(com.kwad.sdk.core.response.b.a.w(f.this.g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.c, com.kwad.sdk.core.response.b.a.o(this.g), this.f, 12);
        this.d.setText(com.kwad.sdk.core.response.b.a.q(this.g));
        this.e.setText(com.kwad.sdk.core.response.b.a.w(this.g));
        if (this.h != null) {
            this.h.a(this.j);
        }
        this.f8452b.setOnClickListener(this);
        this.f8452b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f8452b.getContext(), this.f, new a.InterfaceC1105a() { // from class: com.kwad.sdk.a.b.f.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1105a
            public void a() {
                com.kwad.sdk.core.report.b.a(f.this.f, 2, f.this.f8436a.c.getTouchCoords());
            }
        }, this.h);
    }

    private void g() {
        this.f8436a.f8437a.onAdClicked(this.f8452b, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f = this.f8436a.d;
        this.g = com.kwad.sdk.core.response.b.c.j(this.f);
        this.h = this.f8436a.e;
        this.f8436a.f.a(this.i);
        this.f8452b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8436a.f.b(this.i);
        if (this.h != null) {
            this.h.b(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8452b = (ViewGroup) b(R.id.ksad_video_complete_app_container);
        this.c = (ImageView) b(R.id.ksad_app_icon);
        this.d = (TextView) b(R.id.ksad_app_name);
        this.e = (TextView) b(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f8452b) {
            f();
            g();
        }
    }
}
