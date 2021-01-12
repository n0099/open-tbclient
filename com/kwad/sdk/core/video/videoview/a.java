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
/* loaded from: classes4.dex */
public class a extends c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private Context f9459b;
    @NonNull
    private AdTemplate c;
    private AdInfo d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private RelativeLayout i;
    private ImageView j;
    private TextView k;
    private boolean l;
    private LinearLayout m;
    private LinearLayout n;
    private ProgressBar o;
    private ImageView p;
    private ViewGroup q;
    private InterfaceC1101a r;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1101a {
        void a();

        void a(long j);

        void b();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull d dVar) {
        super(context, dVar);
        this.f9459b = context;
        this.c = adTemplate;
        this.d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        j();
    }

    private void j() {
        LayoutInflater.from(this.f9459b).inflate(R.layout.ksad_feed_video_palyer_controller, (ViewGroup) this, true);
        this.i = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.k = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        this.j = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.j.setOnClickListener(this);
        this.m = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.n = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.o = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.p = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String a2 = com.kwad.sdk.core.response.b.a.U(this.d).a();
        if (TextUtils.isEmpty(a2)) {
            this.p.setVisibility(8);
        } else {
            this.p.setImageDrawable(null);
            KSImageLoader.loadImage(this.p, a2, this.c);
            this.p.setVisibility(0);
        }
        this.k.setText(ai.a(com.kwad.sdk.core.response.b.a.b(this.d) * 1000));
    }

    private void k() {
        if (this.q != null) {
            this.q.setVisibility(8);
        }
    }

    private void l() {
        if (com.kwad.sdk.core.response.b.a.y(this.d)) {
            KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.d), this.c, 12);
            ((TextView) findViewById(R.id.ksad_app_name)).setText(com.kwad.sdk.core.response.b.a.q(this.d));
            ((TextView) findViewById(R.id.ksad_app_download)).setText(com.kwad.sdk.core.response.b.a.w(this.d));
            this.q = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
        } else {
            ((TextView) findViewById(R.id.ksad_h5_open)).setText(com.kwad.sdk.core.response.b.a.w(this.d));
            this.q = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
        }
        this.q.setVisibility(0);
    }

    private void m() {
        this.i.setVisibility(0);
        this.p.setVisibility(0);
        this.c.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    private void n() {
        this.i.setVisibility(8);
    }

    private void o() {
        this.f9469a.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.d), System.currentTimeMillis()));
    }

    private void setTopBottomVisible(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
        this.l = z;
    }

    protected void a() {
        this.m.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i) {
        com.kwad.sdk.core.d.a.a("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        switch (i) {
            case -1:
                i();
                setTopBottomVisible(false);
                this.m.setVisibility(8);
                this.n.setVisibility(0);
                e.b(this.c, this.g, this.g);
                return;
            case 0:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return;
            case 1:
                n();
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                k();
                return;
            case 2:
                if (this.r != null) {
                    this.r.a();
                }
                setTopBottomVisible(true);
                h();
                return;
            case 4:
                this.p.setVisibility(8);
                return;
            case 9:
                if (this.r != null) {
                    this.r.b();
                }
                i();
                setTopBottomVisible(false);
                KSImageLoader.loadImage(this.p, com.kwad.sdk.core.response.b.a.f(this.d), this.c);
                this.p.setVisibility(0);
                l();
                return;
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public void a(int i, int i2) {
        this.h = i2;
        this.g = i;
    }

    public void a(boolean z) {
        if (!z) {
            this.o.setVisibility(8);
        } else if (this.l) {
            this.o.setVisibility(0);
        }
    }

    protected void b() {
        this.m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        this.c.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (!this.f9469a.d()) {
            if (this.f9469a.h() || this.f9469a.f()) {
                o();
                this.f9469a.b();
            }
        } else if (!com.ksad.download.d.b.a(this.f9459b)) {
            a();
        } else {
            b();
            if (com.ksad.download.d.b.b(this.f9459b)) {
                o();
                this.f9469a.a();
            } else if (!this.f && !this.e) {
                m();
            } else {
                o();
                this.f9469a.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f9469a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        this.f9469a.k();
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    protected void g() {
        long currentPosition = this.f9469a.getCurrentPosition();
        long duration = this.f9469a.getDuration();
        this.o.setSecondaryProgress(this.f9469a.getBufferPercentage());
        this.o.setProgress((int) ((100.0f * ((float) currentPosition)) / ((float) duration)));
        if (this.r != null) {
            this.r.a(currentPosition);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
            this.e = true;
            d();
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        this.f = z;
    }

    public void setVideoPlayCallback(InterfaceC1101a interfaceC1101a) {
        this.r = interfaceC1101a;
    }
}
