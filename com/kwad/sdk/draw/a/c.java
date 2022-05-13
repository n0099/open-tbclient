package com.kwad.sdk.draw.a;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.draw.kwai.a implements View.OnClickListener {
    public ViewGroup b;
    public TextView c;
    public TextView d;
    public TextView e;
    public DrawDownloadProgressBar f;
    public AdTemplate g;
    public AdInfo h;
    @Nullable
    public com.kwad.sdk.core.download.a.b i;
    public ValueAnimator j;
    public int k;
    public int l;
    public int m;
    public KsLogoView n;
    public com.kwad.sdk.contentalliance.detail.video.d o = new e() { // from class: com.kwad.sdk.draw.a.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            int i = (j2 > (c.this.m * 1000) ? 1 : (j2 == (c.this.m * 1000) ? 0 : -1));
            c cVar = c.this;
            if (i >= 0) {
                ((com.kwad.sdk.draw.kwai.a) cVar).a.f.a();
                return;
            }
            int i2 = (j2 > (cVar.l * 1000) ? 1 : (j2 == (cVar.l * 1000) ? 0 : -1));
            c cVar2 = c.this;
            if (i2 >= 0) {
                cVar2.h();
            } else if (j2 >= cVar2.k * 1000) {
                c.this.f();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
        }
    };
    public KsAppDownloadListener p = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.draw.a.c.2
        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i) {
            super.a(i);
            c.this.e.setText(com.kwad.sdk.core.response.a.a.a());
            c.this.f.a(com.kwad.sdk.core.response.a.a.a(), i);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            c.this.e.setText(com.kwad.sdk.core.response.a.a.A(c.this.h));
            c.this.f.a(com.kwad.sdk.core.response.a.a.A(c.this.h), c.this.f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            c.this.e.setText(com.kwad.sdk.core.response.a.a.a(c.this.g));
            c.this.f.a(com.kwad.sdk.core.response.a.a.a(c.this.g), c.this.f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            c.this.e.setText(com.kwad.sdk.core.response.a.a.A(c.this.h));
            c.this.f.a(com.kwad.sdk.core.response.a.a.A(c.this.h), c.this.f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            c.this.e.setText(com.kwad.sdk.core.response.a.a.m(c.this.h));
            c.this.f.a(com.kwad.sdk.core.response.a.a.m(c.this.h), c.this.f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            TextView textView = c.this.e;
            textView.setText(i + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = c.this.f;
            drawDownloadProgressBar.a(i + "%", i);
        }
    };

    private void a(boolean z, int i) {
        com.kwad.sdk.core.download.a.a.a(new a.C0295a(this.b.getContext()).a(this.g).a(this.i).a(i).a(z).a(new a.b() { // from class: com.kwad.sdk.draw.a.c.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(c.this.g, 1, ((com.kwad.sdk.draw.kwai.a) c.this).a.b.getTouchCoords());
                if (((com.kwad.sdk.draw.kwai.a) c.this).a.a != null) {
                    ((com.kwad.sdk.draw.kwai.a) c.this).a.a.onAdClicked();
                }
            }
        }));
    }

    private void e() {
        this.k = com.kwad.sdk.core.response.a.a.X(this.h);
        this.l = com.kwad.sdk.core.response.a.a.Y(this.h);
        this.m = com.kwad.sdk.core.response.a.a.Z(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.e.getVisibility() == 0 || this.f.getVisibility() == 0) {
            return;
        }
        this.e.setOnClickListener(this);
        this.e.setVisibility(0);
        TextView textView = this.e;
        ValueAnimator a = az.a(textView, 0, com.kwad.sdk.a.kwai.a.a(textView.getContext(), 44.0f));
        this.j = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.j.setDuration(300L);
        this.j.start();
    }

    private void g() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.j.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f.getVisibility() == 0) {
            return;
        }
        this.f.setOnClickListener(this);
        this.f.setVisibility(0);
        this.e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.c;
        this.g = adTemplate;
        this.h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.i = ((com.kwad.sdk.draw.kwai.a) this).a.d;
        e();
        this.n.a(this.g);
        this.e.setText(com.kwad.sdk.core.response.a.a.A(this.h));
        this.e.setVisibility(8);
        this.f.a(com.kwad.sdk.core.response.a.a.A(this.h), this.f.getMax());
        this.f.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(this.h)) {
            this.c.setText(com.kwad.sdk.core.response.a.a.t(this.h));
            this.c.setVisibility(0);
            com.kwad.sdk.core.download.a.b bVar = this.i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.c.setVisibility(8);
        }
        this.d.setText(com.kwad.sdk.core.response.a.a.s(this.h));
        ((com.kwad.sdk.draw.kwai.a) this).a.e.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        KsAppDownloadListener ksAppDownloadListener;
        super.c();
        g();
        com.kwad.sdk.core.download.a.b bVar = this.i;
        if (bVar != null && (ksAppDownloadListener = this.p) != null) {
            bVar.b(ksAppDownloadListener);
        }
        ((com.kwad.sdk.draw.kwai.a) this).a.e.b(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f09102c);
        this.c = (TextView) a(R.id.obfuscated_res_0x7f091030);
        this.d = (TextView) a(R.id.obfuscated_res_0x7f09102e);
        this.n = (KsLogoView) a(R.id.obfuscated_res_0x7f09102f);
        this.e = (TextView) a(R.id.obfuscated_res_0x7f09102d);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.obfuscated_res_0x7f09102b);
        this.f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.b) {
            h();
            a(false, 2);
            return;
        }
        if (view2 == this.e) {
            h();
        } else if (view2 != this.f) {
            return;
        }
        a(true, 1);
    }
}
