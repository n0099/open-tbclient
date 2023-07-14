package com.kwad.components.core.video;

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
import com.kwad.components.core.video.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.widget.KSRelativeLayout;
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    public InterfaceC0657a JA;
    public final com.kwad.sdk.core.download.kwai.a JB;
    public boolean Jk;
    public boolean Jl;
    public boolean Jm;
    public int Jn;
    public int Jo;
    public KSRelativeLayout Jp;
    public RelativeLayout Jq;
    public boolean Jr;
    public boolean Js;
    public LinearLayout Jt;
    public LinearLayout Ju;
    public ImageView Jv;
    public ViewGroup Jw;
    public ImageView Jx;
    public TextView Jy;
    public TextView Jz;
    public b dw;
    public ImageView jQ;
    public TextView jR;
    public ProgressBar kk;
    public boolean kn;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public Context mContext;

    /* renamed from: com.kwad.components.core.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0657a {
        void a(int i, aa.a aVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void bm();

        void d(long j);

        void onVideoPlayStart();

        void onVideoPlaying();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.Jl = true;
        this.Jm = false;
        this.Js = false;
        this.JB = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Jz.setText(com.kwad.sdk.core.response.a.a.al(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Jz.setText(com.kwad.sdk.core.response.a.a.aJ(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.Jz.setText(com.kwad.sdk.core.response.a.a.aW(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aA(com.kwad.sdk.core.response.a.a.al(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Jz.setText(com.kwad.sdk.core.response.a.a.P(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                a.this.Jz.setText(com.kwad.sdk.core.response.a.a.uU());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.Jz.setText(com.kwad.sdk.core.response.a.a.aW(i));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        init();
    }

    private void aq(int i) {
        InterfaceC0657a interfaceC0657a = this.JA;
        if (interfaceC0657a != null) {
            interfaceC0657a.a(i, this.Jp.getTouchCoords());
        }
    }

    private void init() {
        ImageView imageView;
        int i;
        LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d049d, (ViewGroup) this, true);
        this.Jp = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091423);
        this.Jq = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091288);
        this.jR = (TextView) findViewById(R.id.obfuscated_res_0x7f09128a);
        ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091289);
        this.jQ = imageView2;
        imageView2.setOnClickListener(this);
        this.Jt = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09141c);
        this.Ju = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091417);
        this.kk = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091422);
        this.Jv = (ImageView) findViewById(R.id.obfuscated_res_0x7f09142a);
        String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.Jv;
            i = 8;
        } else {
            this.Jv.setImageDrawable(null);
            KSImageLoader.loadImage(this.Jv, url, this.mAdTemplate);
            imageView = this.Jv;
            i = 0;
        }
        imageView.setVisibility(i);
        this.jR.setText(bc.v(com.kwad.sdk.core.response.a.a.B(this.mAdInfo) * 1000));
        oI();
    }

    private void oJ() {
        ViewGroup viewGroup = this.Jw;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void oN() {
        this.Jq.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z) {
        if (this.Js) {
            return;
        }
        this.kk.setVisibility(z ? 0 : 8);
        this.Jr = z;
    }

    public final void aA(String str) {
        ((TextView) findViewById(R.id.obfuscated_res_0x7f091257)).setText(str);
    }

    public final void az(boolean z) {
        if (this.Js) {
            return;
        }
        if (!z) {
            this.kk.setVisibility(8);
        } else if (this.Jr) {
            this.kk.setVisibility(0);
        }
    }

    public void er() {
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            this.Jx = (ImageView) findViewById(R.id.obfuscated_res_0x7f091408);
            this.Jy = (TextView) findViewById(R.id.obfuscated_res_0x7f09125c);
            this.Jz = (TextView) findViewById(R.id.obfuscated_res_0x7f091257);
            KSImageLoader.loadAppIcon(this.Jx, com.kwad.sdk.core.response.a.d.bU(this.mAdTemplate), this.mAdTemplate, 12);
            this.Jy.setText(com.kwad.sdk.core.response.a.a.bl(this.mAdInfo));
            this.Jz.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
            this.Jw = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091407);
            this.Jx.setOnClickListener(this);
            this.Jy.setOnClickListener(this);
            this.Jz.setOnClickListener(this);
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.b(this.JB);
        } else {
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0912b2);
            this.Jz = textView;
            textView.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
            this.Jz.setOnClickListener(this);
            this.Jw = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091409);
        }
        this.Jw.setOnClickListener(this);
        this.Jw.setVisibility(0);
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void l(int i, int i2) {
        this.Jo = i2;
        this.Jn = i;
    }

    public void oI() {
    }

    public final void oK() {
        this.Jt.setVisibility(0);
    }

    public final void oL() {
        this.Jt.setVisibility(8);
    }

    public final void oM() {
        this.Jq.setVisibility(0);
        this.Jv.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    public void oO() {
        if (!this.aef.isIdle()) {
            if (this.aef.isPaused() || this.aef.vE()) {
                oP();
                this.aef.restart();
            }
        } else if (!ae.isNetworkConnected(this.mContext)) {
            oK();
        } else {
            oL();
            if (!this.Jm && ((!this.Jl || !ae.isWifiConnected(this.mContext)) && (!this.Jl || (!this.kn && !this.Jk)))) {
                oM();
                return;
            }
            oP();
            this.aef.start();
        }
    }

    public final void oP() {
        this.aef.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate));
    }

    public final void oQ() {
        this.aef.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void oR() {
        long currentPosition = this.aef.getCurrentPosition();
        long duration = this.aef.getDuration();
        this.kk.setSecondaryProgress(this.aef.getBufferPercentage());
        this.kk.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        b bVar = this.dw;
        if (bVar != null) {
            bVar.d(currentPosition);
        }
    }

    public final void oS() {
        this.Js = true;
        this.kk.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.jQ) {
            this.Jk = true;
            this.Jl = true;
            oO();
        } else if (view2 == this.Jx) {
            aq(1);
        } else if (view2 == this.Jy) {
            aq(2);
        } else if (view2 == this.Jz) {
            aq(3);
        } else {
            aq(4);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i) {
        com.kwad.sdk.core.e.b.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i == -1) {
            oY();
            setTopBottomVisible(false);
            this.Jt.setVisibility(8);
            this.Ju.setVisibility(0);
            b bVar = this.dw;
            if (bVar instanceof d.a) {
                ((d.a) bVar).onVideoPlayError(this.Jn, this.Jo);
            }
            com.kwad.components.core.j.a.og().b(this.mAdTemplate, this.Jn, this.Jo);
        } else if (i == 4) {
            b bVar2 = this.dw;
            if (bVar2 != null) {
                bVar2.onVideoPlaying();
            }
            this.Jv.setVisibility(8);
        } else if (i == 9) {
            b bVar3 = this.dw;
            if (bVar3 != null) {
                bVar3.bm();
            }
            oY();
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.Jv, com.kwad.sdk.core.response.a.a.K(this.mAdInfo), this.mAdTemplate);
            this.Jv.setVisibility(0);
            er();
        } else if (i == 1) {
            oN();
            this.Jt.setVisibility(8);
            this.Ju.setVisibility(8);
            this.kk.setVisibility(8);
            oJ();
        } else if (i != 2) {
        } else {
            b bVar4 = this.dw;
            if (bVar4 != null) {
                bVar4.onVideoPlayStart();
            }
            setTopBottomVisible(true);
            oX();
        }
    }

    public void release() {
        this.aef.release();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void reset() {
        oY();
        this.kk.setProgress(0);
        this.kk.setSecondaryProgress(0);
        oN();
        this.Jt.setVisibility(8);
        this.Ju.setVisibility(8);
        this.kk.setVisibility(8);
        this.Jv.setVisibility(8);
        this.Jq.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        oJ();
    }

    public void setAdClickListener(InterfaceC0657a interfaceC0657a) {
        this.JA = interfaceC0657a;
    }

    public void setCanControlPlay(boolean z) {
        this.Jm = z;
    }

    public void setDataAutoStart(boolean z) {
        this.Jl = z;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.kn = z;
    }

    public void setVideoPlayCallback(b bVar) {
        this.dw = bVar;
    }
}
