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
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.KSRelativeLayout;
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: classes3.dex */
public class a extends c implements View.OnClickListener {
    public InterfaceC2118a A;
    public final com.kwad.sdk.core.download.a.c B;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56286b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56287c;

    /* renamed from: e  reason: collision with root package name */
    public Context f56288e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f56289f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f56290g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56291h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56292i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f56293j;
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
    /* loaded from: classes3.dex */
    public interface InterfaceC2118a {
        void a(int i2, z.a aVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j2);

        void b_();

        void e();

        void f();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull d dVar) {
        super(context, dVar);
        this.f56293j = true;
        this.a = false;
        this.p = false;
        this.B = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.A(a.this.f56290g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(a.this.f56289f));
            }

            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                a aVar = a.this;
                aVar.a(com.kwad.sdk.core.response.a.a.A(aVar.f56290g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.m(a.this.f56290g));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                a.this.x.setText(com.kwad.sdk.core.response.a.a.a(i2));
            }
        };
        this.f56288e = context;
        this.f56289f = adTemplate;
        this.f56290g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        m();
    }

    private void b(int i2) {
        InterfaceC2118a interfaceC2118a = this.A;
        if (interfaceC2118a != null) {
            interfaceC2118a.a(i2, this.m.getTouchCoords());
        }
    }

    private void m() {
        ImageView imageView;
        int i2;
        LayoutInflater.from(this.f56288e).inflate(R.layout.ksad_feed_video_palyer_controller, (ViewGroup) this, true);
        this.m = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.n = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.f56287c = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.f56286b = imageView2;
        imageView2.setOnClickListener(this);
        this.q = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.r = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.s = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.t = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String a = com.kwad.sdk.core.response.a.a.aa(this.f56290g).a();
        if (TextUtils.isEmpty(a)) {
            imageView = this.t;
            i2 = 8;
        } else {
            this.t.setImageDrawable(null);
            KSImageLoader.loadImage(this.t, a, this.f56289f);
            imageView = this.t;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.f56287c.setText(aw.a(com.kwad.sdk.core.response.a.a.b(this.f56290g) * 1000));
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
        this.f56289f.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void p() {
        this.n.setVisibility(8);
    }

    private void q() {
        this.f56306d.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f56289f));
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
    public void a(int i2) {
        com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i2);
        if (i2 == -1) {
            l();
            setTopBottomVisible(false);
            this.q.setVisibility(8);
            this.r.setVisibility(0);
            com.kwad.sdk.core.report.d.b(this.f56289f, this.k, this.l);
        } else if (i2 == 4) {
            b bVar = this.z;
            if (bVar != null) {
                bVar.e();
            }
            this.t.setVisibility(8);
        } else if (i2 == 9) {
            b bVar2 = this.z;
            if (bVar2 != null) {
                bVar2.f();
            }
            l();
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.t, com.kwad.sdk.core.response.a.a.h(this.f56290g), this.f56289f);
            this.t.setVisibility(0);
            b();
        } else if (i2 == 1) {
            p();
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            n();
        } else if (i2 != 2) {
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
    public void a(int i2, int i3) {
        this.l = i3;
        this.k = i2;
    }

    public void a(String str) {
        ((TextView) findViewById(R.id.ksad_app_download)).setText(str);
    }

    public void a(boolean z) {
        ProgressBar progressBar;
        int i2;
        if (this.p) {
            return;
        }
        if (!z) {
            progressBar = this.s;
            i2 = 8;
        } else if (!this.o) {
            return;
        } else {
            progressBar = this.s;
            i2 = 0;
        }
        progressBar.setVisibility(i2);
    }

    public void b() {
        if (com.kwad.sdk.core.response.a.a.B(this.f56290g)) {
            this.v = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
            this.w = (TextView) findViewById(R.id.ksad_app_name);
            this.x = (TextView) findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.v, com.kwad.sdk.core.response.a.d.o(this.f56289f), this.f56289f, 12);
            this.w.setText(com.kwad.sdk.core.response.a.a.at(this.f56290g));
            this.x.setText(com.kwad.sdk.core.response.a.a.A(this.f56290g));
            this.u = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            this.v.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f56289f);
            this.y = bVar;
            bVar.a(this.B);
        } else {
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
            this.x = textView;
            textView.setText(com.kwad.sdk.core.response.a.a.A(this.f56290g));
            this.x.setOnClickListener(this);
            this.u = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
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
        this.f56289f.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        n();
    }

    public void f() {
        if (!this.f56306d.d()) {
            if (this.f56306d.h() || this.f56306d.f()) {
                q();
                this.f56306d.b();
            }
        } else if (!com.ksad.download.c.b.a(this.f56288e)) {
            c();
        } else {
            d();
            if (!this.a && ((!this.f56293j || !com.ksad.download.c.b.b(this.f56288e)) && (!this.f56293j || (!this.f56292i && !this.f56291h)))) {
                o();
                return;
            }
            q();
            this.f56306d.a();
        }
    }

    public void g() {
        this.f56306d.c();
    }

    public AdTemplate getAdTemplate() {
        return this.f56289f;
    }

    public void h() {
        this.f56306d.k();
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void i() {
        long currentPosition = this.f56306d.getCurrentPosition();
        long duration = this.f56306d.getDuration();
        this.s.setSecondaryProgress(this.f56306d.getBufferPercentage());
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
        if (view == this.f56286b) {
            this.f56291h = true;
            this.f56293j = true;
            f();
        } else if (view == this.v) {
            b(1);
        } else {
            b(view == this.w ? 2 : view == this.x ? 3 : 4);
        }
    }

    public void setAdClickListener(InterfaceC2118a interfaceC2118a) {
        this.A = interfaceC2118a;
    }

    public void setCanControlPlay(boolean z) {
        this.a = z;
    }

    public void setDataAutoStart(boolean z) {
        this.f56293j = z;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.f56292i = z;
    }

    public void setVideoPlayCallback(b bVar) {
        this.z = bVar;
    }
}
