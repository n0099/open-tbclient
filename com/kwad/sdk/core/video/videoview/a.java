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
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class a extends c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Context f34128b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34129c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f34130d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34131e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34132f;

    /* renamed from: g  reason: collision with root package name */
    public int f34133g;

    /* renamed from: h  reason: collision with root package name */
    public int f34134h;
    public RelativeLayout i;
    public ImageView j;
    public TextView k;
    public boolean l;
    public LinearLayout m;
    public LinearLayout n;
    public ProgressBar o;
    public ImageView p;
    public ViewGroup q;
    public InterfaceC0391a r;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0391a {
        void a();

        void a(long j);

        void b();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull d dVar) {
        super(context, dVar);
        this.f34128b = context;
        this.f34129c = adTemplate;
        this.f34130d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        j();
    }

    private void j() {
        ImageView imageView;
        int i;
        LayoutInflater.from(this.f34128b).inflate(R.layout.ksad_feed_video_palyer_controller, (ViewGroup) this, true);
        this.i = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.k = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.j = imageView2;
        imageView2.setOnClickListener(this);
        this.m = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.n = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.o = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.p = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String a2 = com.kwad.sdk.core.response.b.a.U(this.f34130d).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.p;
            i = 8;
        } else {
            this.p.setImageDrawable(null);
            KSImageLoader.loadImage(this.p, a2, this.f34129c);
            imageView = this.p;
            i = 0;
        }
        imageView.setVisibility(i);
        this.k.setText(ai.a(com.kwad.sdk.core.response.b.a.b(this.f34130d) * 1000));
    }

    private void k() {
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void l() {
        LinearLayout linearLayout;
        if (com.kwad.sdk.core.response.b.a.y(this.f34130d)) {
            linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f34130d), this.f34129c, 12);
            ((TextView) findViewById(R.id.ksad_app_name)).setText(com.kwad.sdk.core.response.b.a.q(this.f34130d));
            ((TextView) findViewById(R.id.ksad_app_download)).setText(com.kwad.sdk.core.response.b.a.w(this.f34130d));
        } else {
            linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            ((TextView) findViewById(R.id.ksad_h5_open)).setText(com.kwad.sdk.core.response.b.a.w(this.f34130d));
        }
        this.q = linearLayout;
        this.q.setVisibility(0);
    }

    private void m() {
        this.i.setVisibility(0);
        this.p.setVisibility(0);
        this.f34129c.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void n() {
        this.i.setVisibility(8);
    }

    private void o() {
        this.f34150a.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f34130d), System.currentTimeMillis()));
    }

    private void setTopBottomVisible(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
        this.l = z;
    }

    public void a() {
        this.m.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i) {
        com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i == -1) {
            i();
            setTopBottomVisible(false);
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            AdTemplate adTemplate = this.f34129c;
            int i2 = this.f34133g;
            e.b(adTemplate, i2, i2);
        } else if (i == 4) {
            this.p.setVisibility(8);
        } else if (i == 9) {
            InterfaceC0391a interfaceC0391a = this.r;
            if (interfaceC0391a != null) {
                interfaceC0391a.b();
            }
            i();
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.p, com.kwad.sdk.core.response.b.a.f(this.f34130d), this.f34129c);
            this.p.setVisibility(0);
            l();
        } else if (i == 1) {
            n();
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            k();
        } else if (i != 2) {
        } else {
            InterfaceC0391a interfaceC0391a2 = this.r;
            if (interfaceC0391a2 != null) {
                interfaceC0391a2.a();
            }
            setTopBottomVisible(true);
            h();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i, int i2) {
        this.f34134h = i2;
        this.f34133g = i;
    }

    public void a(boolean z) {
        ProgressBar progressBar;
        int i;
        if (!z) {
            progressBar = this.o;
            i = 8;
        } else if (!this.l) {
            return;
        } else {
            progressBar = this.o;
            i = 0;
        }
        progressBar.setVisibility(i);
    }

    public void b() {
        this.m.setVisibility(8);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void c() {
        i();
        this.o.setProgress(0);
        this.o.setSecondaryProgress(0);
        n();
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.i.setVisibility(8);
        this.f34129c.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        k();
    }

    public void d() {
        if (!this.f34150a.d()) {
            if (this.f34150a.h() || this.f34150a.f()) {
                o();
                this.f34150a.b();
            }
        } else if (!com.ksad.download.d.b.a(this.f34128b)) {
            a();
        } else {
            b();
            if (!com.ksad.download.d.b.b(this.f34128b) && !this.f34132f && !this.f34131e) {
                m();
                return;
            }
            o();
            this.f34150a.a();
        }
    }

    public void e() {
        this.f34150a.c();
    }

    public void f() {
        this.f34150a.k();
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void g() {
        long currentPosition = this.f34150a.getCurrentPosition();
        long duration = this.f34150a.getDuration();
        this.o.setSecondaryProgress(this.f34150a.getBufferPercentage());
        this.o.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        InterfaceC0391a interfaceC0391a = this.r;
        if (interfaceC0391a != null) {
            interfaceC0391a.a(currentPosition);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
            this.f34131e = true;
            d();
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        this.f34132f = z;
    }

    public void setVideoPlayCallback(InterfaceC0391a interfaceC0391a) {
        this.r = interfaceC0391a;
    }
}
