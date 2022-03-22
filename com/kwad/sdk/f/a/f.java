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
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40429b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f40430c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40431d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40432e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f40433f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f40434g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40435h;
    public com.kwad.sdk.contentalliance.detail.video.d i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.f.1
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
    public KsAppDownloadListener j = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.f.a.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            f.this.f40432e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f40434g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.f40432e.setText(com.kwad.sdk.core.response.a.a.a(f.this.f40433f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.f40432e.setText(com.kwad.sdk.core.response.a.a.A(f.this.f40434g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.f40432e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
        }
    };

    private void b(int i) {
        com.kwad.sdk.core.download.a.a.a(new a.C1956a(this.f40429b.getContext()).a(this.f40433f).a(i).a(this.f40435h).a(new a.b() { // from class: com.kwad.sdk.f.a.f.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(f.this.f40433f, 2, ((com.kwad.sdk.f.kwai.a) f.this).a.f40468c.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.f40430c, com.kwad.sdk.core.response.a.a.au(this.f40434g), this.f40433f, 12);
        this.f40431d.setText(com.kwad.sdk.core.response.a.a.t(this.f40434g));
        this.f40432e.setText(com.kwad.sdk.core.response.a.a.A(this.f40434g));
        com.kwad.sdk.core.download.a.b bVar = this.f40435h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.f40429b.setOnClickListener(this);
        this.f40429b.setVisibility(0);
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f40429b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f40469d;
        this.f40433f = adTemplate;
        this.f40434g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f40435h = bVar.f40470e;
        bVar.f40471f.a(this.i);
        this.f40429b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.b(this.i);
        com.kwad.sdk.core.download.a.b bVar = this.f40435h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40429b = (ViewGroup) a(R.id.obfuscated_res_0x7f09115b);
        this.f40430c = (ImageView) a(R.id.obfuscated_res_0x7f091036);
        this.f40431d = (TextView) a(R.id.obfuscated_res_0x7f091038);
        this.f40432e = (TextView) a(R.id.obfuscated_res_0x7f091032);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view == this.f40429b) {
            i = 2;
        } else if (view != this.f40432e) {
            return;
        } else {
            i = 1;
        }
        b(i);
        f();
    }
}
