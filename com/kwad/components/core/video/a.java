package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.tieba.R;
import com.kwad.components.core.video.f;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.KSRelativeLayout;
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    public boolean Ti;
    public boolean Tj;
    public boolean Tk;
    public int Tl;
    public int Tm;
    public KSRelativeLayout Tn;
    public RelativeLayout To;
    public boolean Tp;
    public boolean Tq;
    public LinearLayout Tr;
    public LinearLayout Ts;
    public ImageView Tt;
    public ViewGroup Tu;
    public TextView Tv;
    public c Tw;
    public InterfaceC0662a Tx;
    public com.kwad.components.core.video.a.a Ty;
    public final com.kwad.sdk.core.download.a.a Tz;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public Context mContext;
    public ImageView mR;
    public TextView mS;
    public ProgressBar nl;
    public boolean no;
    public ImageView zR;
    public TextView zS;

    /* renamed from: com.kwad.components.core.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0662a {
        void a(int i, ac.a aVar);
    }

    /* loaded from: classes10.dex */
    public interface b extends c {
        void onVideoPlayError(int i, int i2);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void bl();

        void bm();

        void e(long j);

        void onVideoPlayStart();
    }

    public void qU() {
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.Tj = true;
        this.Tk = false;
        this.Tq = false;
        this.Tz = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.Tv.setText(com.kwad.sdk.core.response.b.a.DX());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.Tv.setText(com.kwad.sdk.core.response.b.a.cQ(i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Tv.setText(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Tv.setText(com.kwad.sdk.core.response.b.a.bX(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.Tv.setText(com.kwad.sdk.core.response.b.a.cQ(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.av(com.kwad.sdk.core.response.b.a.aE(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Tv.setText(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        init();
    }

    private void aH(int i) {
        InterfaceC0662a interfaceC0662a = this.Tx;
        if (interfaceC0662a != null) {
            interfaceC0662a.a(i, this.Tn.getTouchCoords());
        }
    }

    private void setTopBottomVisible(boolean z) {
        int i;
        if (this.Tq) {
            return;
        }
        ProgressBar progressBar = this.nl;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        progressBar.setVisibility(i);
        this.Tp = z;
    }

    public final void aN(boolean z) {
        if (this.Tq) {
            return;
        }
        if (z) {
            if (this.Tp) {
                this.nl.setVisibility(0);
                return;
            }
            return;
        }
        this.nl.setVisibility(8);
    }

    public final void av(String str) {
        ((TextView) findViewById(R.id.obfuscated_res_0x7f091303)).setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.mR) {
            this.Ti = true;
            this.Tj = true;
            ra();
        } else if (view2 == this.zR) {
            aH(1);
        } else if (view2 == this.zS) {
            aH(2);
        } else if (view2 == this.Tv) {
            aH(3);
        } else {
            aH(4);
        }
    }

    public void setAdClickListener(InterfaceC0662a interfaceC0662a) {
        this.Tx = interfaceC0662a;
    }

    public void setCanControlPlay(boolean z) {
        this.Tk = z;
    }

    public void setDataAutoStart(boolean z) {
        this.Tj = z;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.no = z;
    }

    public void setVideoPlayCallback(c cVar) {
        this.Tw = cVar;
    }

    private void init() {
        com.kwad.sdk.m.l.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04d4, this);
        this.Tn = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091501);
        this.To = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091343);
        this.mS = (TextView) findViewById(R.id.obfuscated_res_0x7f091345);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091344);
        this.mR = imageView;
        imageView.setOnClickListener(this);
        this.Tr = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914fb);
        this.Ts = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914f4);
        this.nl = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091500);
        this.Tt = (ImageView) findViewById(R.id.obfuscated_res_0x7f09150c);
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.Tt.setImageDrawable(null);
            KSImageLoader.loadImage(this.Tt, url, this.mAdTemplate);
            this.Tt.setVisibility(0);
        } else {
            this.Tt.setVisibility(8);
        }
        this.mS.setText(bl.X(com.kwad.sdk.core.response.b.a.L(this.mAdInfo) * 1000));
        this.Ty = com.kwad.components.core.video.a.c.ay(this.mAdTemplate);
        qU();
    }

    public void ew() {
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.zR = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914e5);
            this.zS = (TextView) findViewById(R.id.obfuscated_res_0x7f091308);
            this.Tv = (TextView) findViewById(R.id.obfuscated_res_0x7f091303);
            KSImageLoader.loadAppIcon(this.zR, com.kwad.sdk.core.response.b.e.dU(this.mAdTemplate), this.mAdTemplate, 12);
            this.zS.setText(com.kwad.sdk.core.response.b.a.cc(this.mAdInfo));
            this.Tv.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.Tu = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914e4);
            this.zR.setOnClickListener(this);
            this.zS.setOnClickListener(this);
            this.Tv.setOnClickListener(this);
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.b(this.Tz);
        } else {
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091370);
            this.Tv = textView;
            textView.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.Tv.setOnClickListener(this);
            this.Tu = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914e6);
        }
        this.Tu.setOnClickListener(this);
        this.Tu.setVisibility(0);
    }

    private void qV() {
        ViewGroup viewGroup = this.Tu;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void qZ() {
        this.To.setVisibility(8);
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final void qW() {
        this.Tr.setVisibility(0);
    }

    public final void qX() {
        this.Tr.setVisibility(8);
    }

    public final void qY() {
        this.To.setVisibility(0);
        this.Tt.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    public final void rb() {
        this.aAB.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate));
    }

    public void rc() {
        this.aAB.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void rd() {
        long currentPosition = this.aAB.getCurrentPosition();
        long duration = this.aAB.getDuration();
        this.nl.setSecondaryProgress(this.aAB.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.nl.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        c cVar = this.Tw;
        if (cVar != null) {
            cVar.e(currentPosition);
        }
    }

    public final void re() {
        this.Tq = true;
        this.nl.setVisibility(8);
    }

    public void release() {
        this.aAB.release();
        com.kwad.components.core.video.a.a aVar = this.Ty;
        if (aVar != null) {
            aVar.onRelease();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i) {
        com.kwad.components.core.video.a.a aVar;
        com.kwad.sdk.core.e.c.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i != -1) {
            if (i != 9) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    if (i == 7 && (aVar = this.Ty) != null) {
                                        aVar.onVideoPlayBufferingPaused();
                                        return;
                                    }
                                    return;
                                }
                                com.kwad.components.core.video.a.a aVar2 = this.Ty;
                                if (aVar2 != null) {
                                    aVar2.onVideoPlayBufferingPlaying();
                                    return;
                                }
                                return;
                            }
                            com.kwad.components.core.video.a.a aVar3 = this.Ty;
                            if (aVar3 != null) {
                                aVar3.onMediaPlayPaused();
                                return;
                            }
                            return;
                        }
                        c cVar = this.Tw;
                        if (cVar != null) {
                            cVar.bl();
                        }
                        this.Tt.setVisibility(8);
                        com.kwad.components.core.video.a.a aVar4 = this.Ty;
                        if (aVar4 != null) {
                            aVar4.onMediaPlaying();
                            return;
                        }
                        return;
                    }
                    c cVar2 = this.Tw;
                    if (cVar2 != null) {
                        cVar2.onVideoPlayStart();
                    }
                    com.kwad.components.core.video.a.a aVar5 = this.Ty;
                    if (aVar5 != null) {
                        aVar5.onMediaPlayStart();
                    }
                    setTopBottomVisible(true);
                    rj();
                    return;
                }
                qZ();
                this.Tr.setVisibility(8);
                this.Ts.setVisibility(8);
                this.nl.setVisibility(8);
                qV();
                return;
            }
            c cVar3 = this.Tw;
            if (cVar3 != null) {
                cVar3.bm();
            }
            rk();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.Tt, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            this.Tt.setVisibility(0);
            ew();
            com.kwad.components.core.video.a.a aVar6 = this.Ty;
            if (aVar6 != null) {
                aVar6.onMediaPlayCompleted();
                return;
            }
            return;
        }
        rk();
        setTopBottomVisible(false);
        this.Tr.setVisibility(8);
        this.Ts.setVisibility(0);
        c cVar4 = this.Tw;
        if (cVar4 instanceof f.a) {
            ((f.a) cVar4).onVideoPlayError(this.Tl, this.Tm);
        }
        c cVar5 = this.Tw;
        if (cVar5 instanceof b) {
            ((b) cVar5).onVideoPlayError(this.Tl, this.Tm);
        }
        com.kwad.components.core.o.a.pX().c(this.mAdTemplate, this.Tl, this.Tm);
        com.kwad.components.core.video.a.a aVar7 = this.Ty;
        if (aVar7 != null) {
            aVar7.onMediaPlayError(this.Tl, this.Tm);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void p(int i, int i2) {
        this.Tm = i2;
        this.Tl = i;
    }

    public void ra() {
        if (this.aAB.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.Ty;
            if (aVar != null) {
                aVar.onStart();
            }
            if (!ag.isNetworkConnected(this.mContext)) {
                qW();
                return;
            }
            qX();
            if (this.Tk) {
                rb();
                this.aAB.start();
            } else if (this.Tj && ag.isWifiConnected(this.mContext)) {
                rb();
                this.aAB.start();
            } else if (this.Tj && (this.no || this.Ti)) {
                rb();
                this.aAB.start();
            } else {
                qY();
            }
        } else if (this.aAB.isPaused() || this.aAB.Fa()) {
            rb();
            this.aAB.restart();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    @UiThread
    public final void reset() {
        rk();
        this.nl.setProgress(0);
        this.nl.setSecondaryProgress(0);
        qZ();
        this.Tr.setVisibility(8);
        this.Ts.setVisibility(8);
        this.nl.setVisibility(8);
        this.Tt.setVisibility(8);
        this.To.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        qV();
    }
}
