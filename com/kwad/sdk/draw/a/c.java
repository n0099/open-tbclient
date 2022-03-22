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
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.draw.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40333b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40334c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40335d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40336e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f40337f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f40338g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f40339h;
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
                ((com.kwad.sdk.draw.kwai.a) cVar).a.f40363f.a();
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
            c.this.f40336e.setText(com.kwad.sdk.core.response.a.a.a());
            c.this.f40337f.a(com.kwad.sdk.core.response.a.a.a(), i);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            c.this.f40336e.setText(com.kwad.sdk.core.response.a.a.A(c.this.f40339h));
            c.this.f40337f.a(com.kwad.sdk.core.response.a.a.A(c.this.f40339h), c.this.f40337f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            c.this.f40336e.setText(com.kwad.sdk.core.response.a.a.a(c.this.f40338g));
            c.this.f40337f.a(com.kwad.sdk.core.response.a.a.a(c.this.f40338g), c.this.f40337f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            c.this.f40336e.setText(com.kwad.sdk.core.response.a.a.A(c.this.f40339h));
            c.this.f40337f.a(com.kwad.sdk.core.response.a.a.A(c.this.f40339h), c.this.f40337f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            c.this.f40336e.setText(com.kwad.sdk.core.response.a.a.m(c.this.f40339h));
            c.this.f40337f.a(com.kwad.sdk.core.response.a.a.m(c.this.f40339h), c.this.f40337f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            TextView textView = c.this.f40336e;
            textView.setText(i + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = c.this.f40337f;
            drawDownloadProgressBar.a(i + "%", i);
        }
    };

    private void a(boolean z, int i) {
        com.kwad.sdk.core.download.a.a.a(new a.C1956a(this.f40333b.getContext()).a(this.f40338g).a(this.i).a(i).a(z).a(new a.b() { // from class: com.kwad.sdk.draw.a.c.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(c.this.f40338g, 1, ((com.kwad.sdk.draw.kwai.a) c.this).a.f40359b.getTouchCoords());
                if (((com.kwad.sdk.draw.kwai.a) c.this).a.a != null) {
                    ((com.kwad.sdk.draw.kwai.a) c.this).a.a.onAdClicked();
                }
            }
        }));
    }

    private void e() {
        this.k = com.kwad.sdk.core.response.a.a.X(this.f40339h);
        this.l = com.kwad.sdk.core.response.a.a.Y(this.f40339h);
        this.m = com.kwad.sdk.core.response.a.a.Z(this.f40339h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f40336e.getVisibility() == 0 || this.f40337f.getVisibility() == 0) {
            return;
        }
        this.f40336e.setOnClickListener(this);
        this.f40336e.setVisibility(0);
        TextView textView = this.f40336e;
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
        if (this.f40337f.getVisibility() == 0) {
            return;
        }
        this.f40337f.setOnClickListener(this);
        this.f40337f.setVisibility(0);
        this.f40336e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f40360c;
        this.f40338g = adTemplate;
        this.f40339h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.i = ((com.kwad.sdk.draw.kwai.a) this).a.f40361d;
        e();
        this.n.a(this.f40338g);
        this.f40336e.setText(com.kwad.sdk.core.response.a.a.A(this.f40339h));
        this.f40336e.setVisibility(8);
        this.f40337f.a(com.kwad.sdk.core.response.a.a.A(this.f40339h), this.f40337f.getMax());
        this.f40337f.setVisibility(8);
        this.f40333b.setVisibility(0);
        this.f40333b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(this.f40339h)) {
            this.f40334c.setText(com.kwad.sdk.core.response.a.a.t(this.f40339h));
            this.f40334c.setVisibility(0);
            com.kwad.sdk.core.download.a.b bVar = this.i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f40334c.setVisibility(8);
        }
        this.f40335d.setText(com.kwad.sdk.core.response.a.a.s(this.f40339h));
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.a(this.o);
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
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.b(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40333b = (ViewGroup) a(R.id.obfuscated_res_0x7f091023);
        this.f40334c = (TextView) a(R.id.obfuscated_res_0x7f091027);
        this.f40335d = (TextView) a(R.id.obfuscated_res_0x7f091025);
        this.n = (KsLogoView) a(R.id.obfuscated_res_0x7f091026);
        this.f40336e = (TextView) a(R.id.obfuscated_res_0x7f091024);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.obfuscated_res_0x7f091022);
        this.f40337f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40333b) {
            h();
            a(false, 2);
            return;
        }
        if (view == this.f40336e) {
            h();
        } else if (view != this.f40337f) {
            return;
        }
        a(true, 1);
    }
}
