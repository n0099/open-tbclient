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
    public ViewGroup f59036b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59037c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59038d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59039e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59040f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f59041g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59042h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59043i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.f.1
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
    public KsAppDownloadListener f59044j = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.f.a.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f59039e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f59041g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f59039e.setText(com.kwad.sdk.core.response.a.a.a(f.this.f59040f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f59039e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f59041g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f59039e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
        }
    };

    private void b(int i2) {
        com.kwad.sdk.core.download.a.a.a(new a.C2083a(this.f59036b.getContext()).a(this.f59040f).a(i2).a(this.f59042h).a(new a.b() { // from class: com.kwad.sdk.f.a.f.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(f.this.f59040f, 2, ((com.kwad.sdk.f.kwai.a) f.this).a.f59083c.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f59037c, com.kwad.sdk.core.response.a.a.au(this.f59041g), this.f59040f, 12);
        this.f59038d.setText(com.kwad.sdk.core.response.a.a.t(this.f59041g));
        this.f59039e.setText(com.kwad.sdk.core.response.a.a.A(this.f59041g));
        com.kwad.sdk.core.download.a.b bVar = this.f59042h;
        if (bVar != null) {
            bVar.a(this.f59044j);
        }
        this.f59036b.setOnClickListener(this);
        this.f59036b.setVisibility(0);
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f59036b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f59084d;
        this.f59040f = adTemplate;
        this.f59041g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f59042h = bVar.f59085e;
        bVar.f59086f.a(this.f59043i);
        this.f59036b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.b(this.f59043i);
        com.kwad.sdk.core.download.a.b bVar = this.f59042h;
        if (bVar != null) {
            bVar.b(this.f59044j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59036b = (ViewGroup) a(R.id.ksad_video_complete_app_container);
        this.f59037c = (ImageView) a(R.id.ksad_app_icon);
        this.f59038d = (TextView) a(R.id.ksad_app_name);
        this.f59039e = (TextView) a(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (view == this.f59036b) {
            i2 = 2;
        } else if (view != this.f59039e) {
            return;
        } else {
            i2 = 1;
        }
        b(i2);
        f();
    }
}
