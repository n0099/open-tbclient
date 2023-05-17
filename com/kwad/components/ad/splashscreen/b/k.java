package com.kwad.components.ad.splashscreen.b;

import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class k extends e {
    public TextView eQ;
    public AdInfo mAdInfo;
    public AdBaseFrameLayout mRootContainer;
    public com.kwad.components.ad.splashscreen.d.a yM;
    public AdMatrixInfo.SplashSlideInfo zd;
    public TextView ze;
    public ImageView zf;
    public com.kwad.components.ad.splashscreen.widget.c zg;
    public KsSplashSlidePathView zh;
    public com.kwad.components.core.c.a.c zi;
    public double zj;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initView() {
        TextView textView;
        String str;
        TextView textView2;
        String str2;
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.zd = splashSlideInfo;
        this.zj = splashSlideInfo.convertDistance;
        int i = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.c cVar = new com.kwad.components.ad.splashscreen.widget.c(getContext(), i);
        this.zg = cVar;
        this.zf.setImageDrawable(cVar);
        this.zf.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.k.2
            @Override // java.lang.Runnable
            public final void run() {
                k.this.ks();
                if (k.this.zg != null) {
                    k.this.zg.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.zd.title)) {
            textView = this.eQ;
            str = this.zd.title;
        } else if (i == 0) {
            textView = this.eQ;
            str = "向上滑动";
        } else if (i != 1) {
            if (i == 2) {
                textView = this.eQ;
                str = "向右滑动";
            }
            if (TextUtils.isEmpty(this.zd.subtitle)) {
                textView2 = this.ze;
                str2 = this.zd.subtitle;
            } else if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                this.ze.setText(com.kwad.components.ad.splashscreen.e.a(this.yF.mAdTemplate, this.mAdInfo, this.zi.mI()));
                if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
                    com.kwad.components.ad.splashscreen.d.c.a(findViewById(R.id.obfuscated_res_0x7f0913b3), -1, 60, -1, -1);
                    return;
                }
                return;
            } else {
                textView2 = this.ze;
                str2 = "跳转详情页或者第三方应用";
            }
            textView2.setText(str2);
            if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
            }
        } else {
            textView = this.eQ;
            str = "向左滑动";
        }
        textView.setText(str);
        if (TextUtils.isEmpty(this.zd.subtitle)) {
        }
        textView2.setText(str2);
        if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
        }
    }

    private void kr() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.yM;
        if (aVar != null) {
            aVar.setAdTemplate(this.yF.mAdTemplate);
            return;
        }
        com.kwad.components.ad.splashscreen.d.a aVar2 = new com.kwad.components.ad.splashscreen.d.a(getContext(), this.yF.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.k.3
            @Override // com.kwad.components.ad.splashscreen.d.a
            public final void Z(String str) {
                k.this.ze.setText(str);
            }
        };
        this.yM = aVar2;
        this.zi.b(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks() {
        if (this.zd != null) {
            u.b bVar = new u.b();
            bVar.aV(this.zd.style);
            com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, 190, bVar, (JSONObject) null);
            com.kwad.components.ad.splashscreen.local.b.U(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar == null) {
            return;
        }
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(hVar.mAdTemplate);
        this.zi = this.yF.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            kr();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0913a1)).inflate();
        this.eQ = (TextView) findViewById(R.id.obfuscated_res_0x7f0913b4);
        this.ze = (TextView) findViewById(R.id.obfuscated_res_0x7f0913b3);
        this.zf = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913b2);
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913af);
        KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0913b1)).inflate();
        this.zh = ksSplashSlidePathView;
        ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.b.k.1
            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void a(float f, float f2, float f3, float f4) {
                k kVar;
                com.kwad.components.ad.splashscreen.h hVar;
                final float b = com.kwad.sdk.b.kwai.a.b(k.this.getContext(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                if (b < k.this.zj || (hVar = (kVar = k.this).yF) == null) {
                    return;
                }
                hVar.a(kVar.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.k.1.1
                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.f fVar) {
                        fVar.aQ(k.this.zd.style);
                        fVar.aR((int) b);
                    }
                });
            }

            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void kt() {
                k kVar;
                com.kwad.components.ad.splashscreen.h hVar;
                if (!m.n(k.this.mAdInfo) || (hVar = (kVar = k.this).yF) == null) {
                    return;
                }
                hVar.c(kVar.getContext(), 53, 2);
            }
        });
    }
}
