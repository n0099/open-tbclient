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
/* loaded from: classes7.dex */
public class a extends c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Context f34865b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34866c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f34867d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34868e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34869f;

    /* renamed from: g  reason: collision with root package name */
    public int f34870g;

    /* renamed from: h  reason: collision with root package name */
    public int f34871h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f34872i;
    public ImageView j;
    public TextView k;
    public boolean l;
    public LinearLayout m;
    public LinearLayout n;
    public ProgressBar o;
    public ImageView p;
    public ViewGroup q;
    public InterfaceC0395a r;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0395a {
        void a();

        void a(long j);

        void b();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull d dVar) {
        super(context, dVar);
        this.f34865b = context;
        this.f34866c = adTemplate;
        this.f34867d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        j();
    }

    private void j() {
        ImageView imageView;
        int i2;
        LayoutInflater.from(this.f34865b).inflate(R.layout.ksad_feed_video_palyer_controller, (ViewGroup) this, true);
        this.f34872i = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.k = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.j = imageView2;
        imageView2.setOnClickListener(this);
        this.m = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.n = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.o = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.p = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String a2 = com.kwad.sdk.core.response.b.a.U(this.f34867d).a();
        if (TextUtils.isEmpty(a2)) {
            imageView = this.p;
            i2 = 8;
        } else {
            this.p.setImageDrawable(null);
            KSImageLoader.loadImage(this.p, a2, this.f34866c);
            imageView = this.p;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        this.k.setText(ai.a(com.kwad.sdk.core.response.b.a.b(this.f34867d) * 1000));
    }

    private void k() {
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void l() {
        LinearLayout linearLayout;
        if (com.kwad.sdk.core.response.b.a.y(this.f34867d)) {
            linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f34867d), this.f34866c, 12);
            ((TextView) findViewById(R.id.ksad_app_name)).setText(com.kwad.sdk.core.response.b.a.q(this.f34867d));
            ((TextView) findViewById(R.id.ksad_app_download)).setText(com.kwad.sdk.core.response.b.a.w(this.f34867d));
        } else {
            linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            ((TextView) findViewById(R.id.ksad_h5_open)).setText(com.kwad.sdk.core.response.b.a.w(this.f34867d));
        }
        this.q = linearLayout;
        this.q.setVisibility(0);
    }

    private void m() {
        this.f34872i.setVisibility(0);
        this.p.setVisibility(0);
        this.f34866c.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void n() {
        this.f34872i.setVisibility(8);
    }

    private void o() {
        this.f34889a.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f34867d), System.currentTimeMillis()));
    }

    private void setTopBottomVisible(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
        this.l = z;
    }

    public void a() {
        this.m.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2) {
        com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i2);
        if (i2 == -1) {
            i();
            setTopBottomVisible(false);
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            AdTemplate adTemplate = this.f34866c;
            int i3 = this.f34870g;
            e.b(adTemplate, i3, i3);
        } else if (i2 == 4) {
            this.p.setVisibility(8);
        } else if (i2 == 9) {
            InterfaceC0395a interfaceC0395a = this.r;
            if (interfaceC0395a != null) {
                interfaceC0395a.b();
            }
            i();
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.p, com.kwad.sdk.core.response.b.a.f(this.f34867d), this.f34866c);
            this.p.setVisibility(0);
            l();
        } else if (i2 == 1) {
            n();
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            k();
        } else if (i2 != 2) {
        } else {
            InterfaceC0395a interfaceC0395a2 = this.r;
            if (interfaceC0395a2 != null) {
                interfaceC0395a2.a();
            }
            setTopBottomVisible(true);
            h();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i2, int i3) {
        this.f34871h = i3;
        this.f34870g = i2;
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
        this.f34872i.setVisibility(8);
        this.f34866c.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        k();
    }

    public void d() {
        if (!this.f34889a.d()) {
            if (this.f34889a.h() || this.f34889a.f()) {
                o();
                this.f34889a.b();
            }
        } else if (!com.ksad.download.d.b.a(this.f34865b)) {
            a();
        } else {
            b();
            if (!com.ksad.download.d.b.b(this.f34865b) && !this.f34869f && !this.f34868e) {
                m();
                return;
            }
            o();
            this.f34889a.a();
        }
    }

    public void e() {
        this.f34889a.c();
    }

    public void f() {
        this.f34889a.k();
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void g() {
        long currentPosition = this.f34889a.getCurrentPosition();
        long duration = this.f34889a.getDuration();
        this.o.setSecondaryProgress(this.f34889a.getBufferPercentage());
        this.o.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        InterfaceC0395a interfaceC0395a = this.r;
        if (interfaceC0395a != null) {
            interfaceC0395a.a(currentPosition);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
            this.f34868e = true;
            d();
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        this.f34869f = z;
    }

    public void setVideoPlayCallback(InterfaceC0395a interfaceC0395a) {
        this.r = interfaceC0395a;
    }
}
