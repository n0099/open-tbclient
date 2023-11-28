package com.kwad.components.ad.splashscreen.c;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class n extends e {
    public AdMatrixInfo.SplashSlideInfo DI;
    public TextView DJ;
    public ImageView DK;
    public com.kwad.components.ad.splashscreen.widget.c DL;
    public KsSplashSlidePathView DM;
    public com.kwad.components.core.e.d.c DN;
    public double DO;
    public com.kwad.components.ad.splashscreen.f.a Ds;
    public TextView hz;
    public AdInfo mAdInfo;
    public long mStartTime;

    private void ll() {
        com.kwad.components.ad.splashscreen.f.a aVar = this.Ds;
        if (aVar == null) {
            com.kwad.components.ad.splashscreen.f.a aVar2 = new com.kwad.components.ad.splashscreen.f.a(getContext(), this.Df.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.n.4
                {
                    super(r3);
                }

                @Override // com.kwad.components.ad.splashscreen.f.a
                public final void k(int i, String str) {
                    n.this.DJ.setText(str);
                }
            };
            this.Ds = aVar2;
            this.DN.b(aVar2);
            return;
        }
        aVar.setAdTemplate(this.Df.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm() {
        if (this.DI != null) {
            com.kwad.sdk.core.report.a.d(this.Df.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.j().cK(this.DI.style).cC(190));
            com.kwad.components.core.webview.tachikoma.d.a.sO().aR(190);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.Df == null) {
            return;
        }
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.n.2
            @Override // java.lang.Runnable
            public final void run() {
                n.this.Df.CH = SystemClock.elapsedRealtime() - n.this.mStartTime;
            }
        });
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        this.DN = this.Df.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            ll();
        }
    }

    private void initView() {
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.DI = splashSlideInfo;
        this.DO = splashSlideInfo.convertDistance;
        int i = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.c cVar = new com.kwad.components.ad.splashscreen.widget.c(getContext(), i);
        this.DL = cVar;
        this.DK.setImageDrawable(cVar);
        this.DK.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.n.3
            @Override // java.lang.Runnable
            public final void run() {
                n.this.lm();
                if (n.this.DL != null) {
                    n.this.DL.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.DI.title)) {
            this.hz.setText(this.DI.title);
        } else if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.hz.setText("向右滑动");
                }
            } else {
                this.hz.setText("向左滑动");
            }
        } else {
            this.hz.setText("向上滑动");
        }
        if (!TextUtils.isEmpty(this.DI.subtitle)) {
            this.DJ.setText(this.DI.subtitle);
        } else if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.DJ.setText(com.kwad.components.ad.splashscreen.d.a(this.Df.mAdTemplate, this.mAdInfo, this.DN.nM(), 0));
        } else {
            this.DJ.setText("跳转详情页或者第三方应用");
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0914ac)).inflate();
        this.hz = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ce);
        this.DJ = (TextView) findViewById(R.id.obfuscated_res_0x7f0914cd);
        this.DK = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914cc);
        KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0914cb)).inflate();
        this.DM = ksSplashSlidePathView;
        ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.c.n.1
            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void a(float f, float f2, float f3, float f4) {
                n nVar;
                com.kwad.components.ad.splashscreen.h hVar;
                final float b = com.kwad.sdk.d.a.a.b(n.this.getContext(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                if (b >= n.this.DO && (hVar = (nVar = n.this).Df) != null) {
                    hVar.a(1, nVar.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.c.n.1.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.report.j jVar) {
                            jVar.cK(n.this.DI.style);
                            jVar.cL((int) b);
                        }
                    });
                }
            }

            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void ln() {
                n nVar;
                com.kwad.components.ad.splashscreen.h hVar;
                if (com.kwad.components.ad.splashscreen.h.n(n.this.mAdInfo) && (hVar = (nVar = n.this).Df) != null) {
                    hVar.c(1, nVar.getContext(), 53, 2);
                }
            }
        });
    }
}
