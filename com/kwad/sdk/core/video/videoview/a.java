package com.kwad.sdk.core.video.videoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.KSRelativeLayout;
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: classes5.dex */
public class a extends c implements View.OnClickListener {
    public InterfaceC0308a A;
    public final com.kwad.sdk.core.download.a.c B;
    public boolean a;
    public ImageView b;
    public TextView c;
    public Context e;
    @NonNull
    public AdTemplate f;
    public AdInfo g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public KSRelativeLayout m;
    public RelativeLayout n;
    public boolean o;
    public boolean p;
    public LinearLayout q;
    public LinearLayout r;
    public ProgressBar s;
    public ImageView t;
    public ViewGroup u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public com.kwad.sdk.core.download.a.b y;
    public b z;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0308a {
        void a(int i, z.a aVar);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(long j);

        void b_();

        void e();

        void f();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull d dVar) {
        super(context, dVar);
        this.j = true;
        this.a = false;
        this.p = false;
        this.B = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.A(a.this.g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(a.this.f));
            }

            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                a aVar = a.this;
                aVar.a(com.kwad.sdk.core.response.a.a.A(aVar.g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.m(a.this.g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(i));
            }
        };
        this.e = context;
        this.f = adTemplate;
        this.g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        m();
    }

    private void b(int i) {
        InterfaceC0308a interfaceC0308a = this.A;
        if (interfaceC0308a != null) {
            interfaceC0308a.a(i, this.m.getTouchCoords());
        }
    }

    private void m() {
        ImageView imageView;
        int i;
        LayoutInflater.from(this.e).inflate(R.layout.obfuscated_res_0x7f0d0425, (ViewGroup) this, true);
        this.m = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091146);
        this.n = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09102c);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09102e);
        ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f09102d);
        this.b = imageView2;
        imageView2.setOnClickListener(this);
        this.q = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09113d);
        this.r = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091136);
        this.s = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091145);
        this.t = (ImageView) findViewById(R.id.obfuscated_res_0x7f09114d);
        String a = com.kwad.sdk.core.response.a.a.aa(this.g).a();
        if (TextUtils.isEmpty(a)) {
            imageView = this.t;
            i = 8;
        } else {
            this.t.setImageDrawable(null);
            KSImageLoader.loadImage(this.t, a, this.f);
            imageView = this.t;
            i = 0;
        }
        imageView.setVisibility(i);
        this.c.setText(aw.a(com.kwad.sdk.core.response.a.a.b(this.g) * 1000));
        a();
    }

    private void n() {
        ViewGroup viewGroup = this.u;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void o() {
        this.n.setVisibility(0);
        this.t.setVisibility(0);
        this.f.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void p() {
        this.n.setVisibility(8);
    }

    private void q() {
        this.d.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f));
    }

    private void setTopBottomVisible(boolean z) {
        if (this.p) {
            return;
        }
        this.s.setVisibility(z ? 0 : 8);
        this.o = z;
    }

    public void a() {
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i) {
        com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i == -1) {
            l();
            setTopBottomVisible(false);
            this.q.setVisibility(8);
            this.r.setVisibility(0);
            com.kwad.sdk.core.report.d.b(this.f, this.k, this.l);
        } else if (i == 4) {
            b bVar = this.z;
            if (bVar != null) {
                bVar.e();
            }
            this.t.setVisibility(8);
        } else if (i == 9) {
            b bVar2 = this.z;
            if (bVar2 != null) {
                bVar2.f();
            }
            l();
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.t, com.kwad.sdk.core.response.a.a.h(this.g), this.f);
            this.t.setVisibility(0);
            b();
        } else if (i == 1) {
            p();
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            n();
        } else if (i != 2) {
        } else {
            b bVar3 = this.z;
            if (bVar3 != null) {
                bVar3.b_();
            }
            setTopBottomVisible(true);
            k();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i, int i2) {
        this.l = i2;
        this.k = i;
    }

    public void a(String str) {
        ((TextView) findViewById(R.id.obfuscated_res_0x7f090ffd)).setText(str);
    }

    public void a(boolean z) {
        ProgressBar progressBar;
        int i;
        if (this.p) {
            return;
        }
        if (!z) {
            progressBar = this.s;
            i = 8;
        } else if (!this.o) {
            return;
        } else {
            progressBar = this.s;
            i = 0;
        }
        progressBar.setVisibility(i);
    }

    public void b() {
        if (com.kwad.sdk.core.response.a.a.B(this.g)) {
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f091127);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f091003);
            this.x = (TextView) findViewById(R.id.obfuscated_res_0x7f090ffd);
            KSImageLoader.loadAppIcon(this.v, com.kwad.sdk.core.response.a.d.o(this.f), this.f, 12);
            this.w.setText(com.kwad.sdk.core.response.a.a.at(this.g));
            this.x.setText(com.kwad.sdk.core.response.a.a.A(this.g));
            this.u = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091126);
            this.v.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f);
            this.y = bVar;
            bVar.a(this.B);
        } else {
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091057);
            this.x = textView;
            textView.setText(com.kwad.sdk.core.response.a.a.A(this.g));
            this.x.setOnClickListener(this);
            this.u = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091128);
        }
        this.u.setOnClickListener(this);
        this.u.setVisibility(0);
    }

    public void c() {
        this.q.setVisibility(0);
    }

    public void d() {
        this.q.setVisibility(8);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void e() {
        l();
        this.s.setProgress(0);
        this.s.setSecondaryProgress(0);
        p();
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.n.setVisibility(8);
        this.f.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        n();
    }

    public void f() {
        if (!this.d.d()) {
            if (this.d.h() || this.d.f()) {
                q();
                this.d.b();
            }
        } else if (!com.ksad.download.c.b.a(this.e)) {
            c();
        } else {
            d();
            if (!this.a && ((!this.j || !com.ksad.download.c.b.b(this.e)) && (!this.j || (!this.i && !this.h)))) {
                o();
                return;
            }
            q();
            this.d.a();
        }
    }

    public void g() {
        this.d.c();
    }

    public AdTemplate getAdTemplate() {
        return this.f;
    }

    public void h() {
        this.d.k();
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void i() {
        long currentPosition = this.d.getCurrentPosition();
        long duration = this.d.getDuration();
        this.s.setSecondaryProgress(this.d.getBufferPercentage());
        this.s.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        b bVar = this.z;
        if (bVar != null) {
            bVar.a(currentPosition);
        }
    }

    public void j() {
        this.p = true;
        this.s.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.b) {
            this.h = true;
            this.j = true;
            f();
        } else if (view2 == this.v) {
            b(1);
        } else {
            b(view2 == this.w ? 2 : view2 == this.x ? 3 : 4);
        }
    }

    public void setAdClickListener(InterfaceC0308a interfaceC0308a) {
        this.A = interfaceC0308a;
    }

    public void setCanControlPlay(boolean z) {
        this.a = z;
    }

    public void setDataAutoStart(boolean z) {
        this.j = z;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.i = z;
    }

    public void setVideoPlayCallback(b bVar) {
        this.z = bVar;
    }
}
