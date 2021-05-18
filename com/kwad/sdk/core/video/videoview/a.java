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
import com.kwad.sdk.utils.aj;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class a extends c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Context f32746b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32747c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f32748d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32749e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32750f;

    /* renamed from: g  reason: collision with root package name */
    public int f32751g;

    /* renamed from: h  reason: collision with root package name */
    public int f32752h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f32753i;
    public ImageView j;
    public TextView k;
    public boolean l;
    public LinearLayout m;
    public LinearLayout n;
    public ProgressBar o;
    public ImageView p;
    public ViewGroup q;
    public InterfaceC0370a r;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0370a {
        void a();

        void a(long j);

        void b();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull d dVar) {
        super(context, dVar);
        this.f32746b = context;
        this.f32747c = adTemplate;
        this.f32748d = com.kwad.sdk.core.response.b.c.g(adTemplate);
        k();
    }

    private void k() {
        ImageView imageView;
        int i2;
        LayoutInflater.from(this.f32746b).inflate(R.layout.ksad_feed_video_palyer_controller, (ViewGroup) this, true);
        this.f32753i = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.k = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.j = imageView2;
        imageView2.setOnClickListener(this);
        this.m = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.n = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.o = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.p = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String a2 = com.kwad.sdk.core.response.b.a.Q(this.f32748d).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.p;
            i2 = 8;
        } else {
            this.p.setImageDrawable(null);
            KSImageLoader.loadImage(this.p, a2, this.f32747c);
            imageView = this.p;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.k.setText(aj.a(com.kwad.sdk.core.response.b.a.b(this.f32748d) * 1000));
    }

    private void l() {
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void m() {
        this.f32753i.setVisibility(0);
        this.p.setVisibility(0);
        this.f32747c.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void n() {
        this.f32753i.setVisibility(8);
    }

    private void o() {
        this.f32770a.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.b(com.kwad.sdk.core.response.b.a.i(this.f32748d), System.currentTimeMillis()));
    }

    private void setTopBottomVisible(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
        this.l = z;
    }

    public void a() {
        LinearLayout linearLayout;
        if (com.kwad.sdk.core.response.b.a.v(this.f32748d)) {
            linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.n(this.f32748d), this.f32747c, 12);
            ((TextView) findViewById(R.id.ksad_app_name)).setText(com.kwad.sdk.core.response.b.a.o(this.f32748d));
            ((TextView) findViewById(R.id.ksad_app_download)).setText(com.kwad.sdk.core.response.b.a.u(this.f32748d));
        } else {
            linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            ((TextView) findViewById(R.id.ksad_h5_open)).setText(com.kwad.sdk.core.response.b.a.u(this.f32748d));
        }
        this.q = linearLayout;
        this.q.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2) {
        com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i2);
        if (i2 == -1) {
            j();
            setTopBottomVisible(false);
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            AdTemplate adTemplate = this.f32747c;
            int i3 = this.f32751g;
            e.a(adTemplate, i3, i3);
        } else if (i2 == 4) {
            this.p.setVisibility(8);
        } else if (i2 == 9) {
            InterfaceC0370a interfaceC0370a = this.r;
            if (interfaceC0370a != null) {
                interfaceC0370a.b();
            }
            j();
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.p, com.kwad.sdk.core.response.b.a.f(this.f32748d), this.f32747c);
            this.p.setVisibility(0);
            a();
        } else if (i2 == 1) {
            n();
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            l();
        } else if (i2 != 2) {
        } else {
            InterfaceC0370a interfaceC0370a2 = this.r;
            if (interfaceC0370a2 != null) {
                interfaceC0370a2.a();
            }
            setTopBottomVisible(true);
            i();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2, int i3) {
        this.f32752h = i3;
        this.f32751g = i2;
    }

    public void a(String str) {
        ((TextView) findViewById(R.id.ksad_app_download)).setText(str);
    }

    public void a(boolean z) {
        ProgressBar progressBar;
        int i2;
        if (!z) {
            progressBar = this.o;
            i2 = 8;
        } else if (!this.l) {
            return;
        } else {
            progressBar = this.o;
            i2 = 0;
        }
        progressBar.setVisibility(i2);
    }

    public void b() {
        this.m.setVisibility(0);
    }

    public void c() {
        this.m.setVisibility(8);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void d() {
        j();
        this.o.setProgress(0);
        this.o.setSecondaryProgress(0);
        n();
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.f32753i.setVisibility(8);
        this.f32747c.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        l();
    }

    public void e() {
        if (!this.f32770a.d()) {
            if (this.f32770a.h() || this.f32770a.f()) {
                o();
                this.f32770a.b();
            }
        } else if (!com.ksad.download.d.b.a(this.f32746b)) {
            b();
        } else {
            c();
            if (!com.ksad.download.d.b.b(this.f32746b) && !this.f32750f && !this.f32749e) {
                m();
                return;
            }
            o();
            this.f32770a.a();
        }
    }

    public void f() {
        this.f32770a.c();
    }

    public void g() {
        this.f32770a.k();
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void h() {
        long currentPosition = this.f32770a.getCurrentPosition();
        long duration = this.f32770a.getDuration();
        this.o.setSecondaryProgress(this.f32770a.getBufferPercentage());
        this.o.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        InterfaceC0370a interfaceC0370a = this.r;
        if (interfaceC0370a != null) {
            interfaceC0370a.a(currentPosition);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
            this.f32749e = true;
            e();
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        this.f32750f = z;
    }

    public void setVideoPlayCallback(InterfaceC0370a interfaceC0370a) {
        this.r = interfaceC0370a;
    }
}
