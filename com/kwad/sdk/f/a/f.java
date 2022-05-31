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
/* loaded from: classes5.dex */
public class f extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {
    public ViewGroup b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public AdTemplate f;
    public AdInfo g;
    @Nullable
    public com.kwad.sdk.core.download.a.b h;
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
            f.this.e.setText(com.kwad.sdk.core.response.a.a.A(f.this.g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            f.this.e.setText(com.kwad.sdk.core.response.a.a.a(f.this.f));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            f.this.e.setText(com.kwad.sdk.core.response.a.a.A(f.this.g));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            f.this.e.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
        }
    };

    private void b(int i) {
        com.kwad.sdk.core.download.a.a.a(new a.C0296a(this.b.getContext()).a(this.f).a(i).a(this.h).a(new a.b() { // from class: com.kwad.sdk.f.a.f.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(f.this.f, 2, ((com.kwad.sdk.f.kwai.a) f.this).a.c.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KSImageLoader.loadAppIcon(this.c, com.kwad.sdk.core.response.a.a.au(this.g), this.f, 12);
        this.d.setText(com.kwad.sdk.core.response.a.a.t(this.g));
        this.e.setText(com.kwad.sdk.core.response.a.a.A(this.g));
        com.kwad.sdk.core.download.a.b bVar = this.h;
        if (bVar != null) {
            bVar.a(this.j);
        }
        this.b.setOnClickListener(this);
        this.b.setVisibility(0);
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.d;
        this.f = adTemplate;
        this.g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.h = bVar.e;
        bVar.f.a(this.i);
        this.b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f.b(this.i);
        com.kwad.sdk.core.download.a.b bVar = this.h;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f091126);
        this.c = (ImageView) a(R.id.obfuscated_res_0x7f091001);
        this.d = (TextView) a(R.id.obfuscated_res_0x7f091003);
        this.e = (TextView) a(R.id.obfuscated_res_0x7f090ffd);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        if (view2 == this.b) {
            i = 2;
        } else if (view2 != this.e) {
            return;
        } else {
            i = 1;
        }
        b(i);
        f();
    }
}
