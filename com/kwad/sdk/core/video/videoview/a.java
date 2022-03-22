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
/* loaded from: classes7.dex */
public class a extends c implements View.OnClickListener {
    public InterfaceC1968a A;
    public final com.kwad.sdk.core.download.a.c B;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f39902b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f39903c;

    /* renamed from: e  reason: collision with root package name */
    public Context f39904e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f39905f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f39906g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39907h;
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
    /* loaded from: classes7.dex */
    public interface InterfaceC1968a {
        void a(int i, z.a aVar);
    }

    /* loaded from: classes7.dex */
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
                a.this.x.setText(com.kwad.sdk.core.response.a.a.A(a.this.f39906g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(a.this.f39905f));
            }

            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                a aVar = a.this;
                aVar.a(com.kwad.sdk.core.response.a.a.A(aVar.f39906g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.m(a.this.f39906g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(i));
            }
        };
        this.f39904e = context;
        this.f39905f = adTemplate;
        this.f39906g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        m();
    }

    private void b(int i) {
        InterfaceC1968a interfaceC1968a = this.A;
        if (interfaceC1968a != null) {
            interfaceC1968a.a(i, this.m.getTouchCoords());
        }
    }

    private void m() {
        ImageView imageView;
        int i;
        LayoutInflater.from(this.f39904e).inflate(R.layout.obfuscated_res_0x7f0d0440, (ViewGroup) this, true);
        this.m = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09117b);
        this.n = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091061);
        this.f39903c = (TextView) findViewById(R.id.obfuscated_res_0x7f091063);
        ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091062);
        this.f39902b = imageView2;
        imageView2.setOnClickListener(this);
        this.q = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091172);
        this.r = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09116b);
        this.s = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f09117a);
        this.t = (ImageView) findViewById(R.id.obfuscated_res_0x7f091182);
        String a = com.kwad.sdk.core.response.a.a.aa(this.f39906g).a();
        if (TextUtils.isEmpty(a)) {
            imageView = this.t;
            i = 8;
        } else {
            this.t.setImageDrawable(null);
            KSImageLoader.loadImage(this.t, a, this.f39905f);
            imageView = this.t;
            i = 0;
        }
        imageView.setVisibility(i);
        this.f39903c.setText(aw.a(com.kwad.sdk.core.response.a.a.b(this.f39906g) * 1000));
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
        this.f39905f.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void p() {
        this.n.setVisibility(8);
    }

    private void q() {
        this.f39918d.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f39905f));
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
            com.kwad.sdk.core.report.d.b(this.f39905f, this.k, this.l);
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
            KSImageLoader.loadImage(this.t, com.kwad.sdk.core.response.a.a.h(this.f39906g), this.f39905f);
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
        ((TextView) findViewById(R.id.obfuscated_res_0x7f091032)).setText(str);
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
        if (com.kwad.sdk.core.response.a.a.B(this.f39906g)) {
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f09115c);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f091038);
            this.x = (TextView) findViewById(R.id.obfuscated_res_0x7f091032);
            KSImageLoader.loadAppIcon(this.v, com.kwad.sdk.core.response.a.d.o(this.f39905f), this.f39905f, 12);
            this.w.setText(com.kwad.sdk.core.response.a.a.at(this.f39906g));
            this.x.setText(com.kwad.sdk.core.response.a.a.A(this.f39906g));
            this.u = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09115b);
            this.v.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f39905f);
            this.y = bVar;
            bVar.a(this.B);
        } else {
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09108c);
            this.x = textView;
            textView.setText(com.kwad.sdk.core.response.a.a.A(this.f39906g));
            this.x.setOnClickListener(this);
            this.u = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09115d);
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
        this.f39905f.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        n();
    }

    public void f() {
        if (!this.f39918d.d()) {
            if (this.f39918d.h() || this.f39918d.f()) {
                q();
                this.f39918d.b();
            }
        } else if (!com.ksad.download.c.b.a(this.f39904e)) {
            c();
        } else {
            d();
            if (!this.a && ((!this.j || !com.ksad.download.c.b.b(this.f39904e)) && (!this.j || (!this.i && !this.f39907h)))) {
                o();
                return;
            }
            q();
            this.f39918d.a();
        }
    }

    public void g() {
        this.f39918d.c();
    }

    public AdTemplate getAdTemplate() {
        return this.f39905f;
    }

    public void h() {
        this.f39918d.k();
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void i() {
        long currentPosition = this.f39918d.getCurrentPosition();
        long duration = this.f39918d.getDuration();
        this.s.setSecondaryProgress(this.f39918d.getBufferPercentage());
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
    public void onClick(View view) {
        if (view == this.f39902b) {
            this.f39907h = true;
            this.j = true;
            f();
        } else if (view == this.v) {
            b(1);
        } else {
            b(view == this.w ? 2 : view == this.x ? 3 : 4);
        }
    }

    public void setAdClickListener(InterfaceC1968a interfaceC1968a) {
        this.A = interfaceC1968a;
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
