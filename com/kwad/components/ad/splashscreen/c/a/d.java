package com.kwad.components.ad.splashscreen.c.a;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.splashscreen.c.e implements com.kwad.sdk.core.h.c {
    public CloseCountDownView EA;
    public ImageView EE;
    public TextView EF;
    public TextView EG;
    public ViewGroup EJ;
    public ImageView EK;
    public KsLogoView EL;
    public TextView EM;
    public TextView EN;

    private void lv() {
        if (!com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate))) {
            return;
        }
        com.kwad.components.ad.splashscreen.f.a aVar = new com.kwad.components.ad.splashscreen.f.a(getContext(), this.Df.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.a.d.1
            {
                super(r3);
            }

            @Override // com.kwad.components.ad.splashscreen.f.a
            public final void k(int i, String str) {
                d.this.V(str);
            }
        };
        com.kwad.components.core.e.d.c cVar = this.Df.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(aVar);
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.EA.aM();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        this.EA.aN();
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Df.Cr.a(this);
        com.kwad.sdk.core.report.a.b(this.Df.mAdTemplate, 87, (JSONObject) null);
        lv();
        lw();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.EA.bf();
        this.Df.Cr.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        this.EM.setText(str);
    }

    private void y(AdInfo adInfo) {
        h hVar = this.Df;
        com.kwad.components.core.e.d.c cVar = hVar.mApkDownloadHelper;
        if (cVar == null) {
            return;
        }
        String a = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, adInfo, cVar.nM(), 0);
        if (!TextUtils.isEmpty(a)) {
            this.EM.setText(a);
        } else {
            this.EM.setText(com.kwad.sdk.core.response.b.a.aE(adInfo));
        }
    }

    public static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.c.a.d.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }
        });
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0914c1);
        if (viewStub != null) {
            this.EJ = (ViewGroup) viewStub.inflate();
        } else {
            this.EJ = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914bd);
        }
        this.EK = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914bb);
        this.EE = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912e9);
        this.EF = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e6);
        this.EG = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e5);
        this.EL = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912eb);
        this.EM = (TextView) findViewById(R.id.obfuscated_res_0x7f0912dd);
        this.EN = (TextView) findViewById(R.id.obfuscated_res_0x7f0912dc);
        this.EA = (CloseCountDownView) findViewById(R.id.obfuscated_res_0x7f0912e8);
    }

    private void lw() {
        this.EJ.setVisibility(0);
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        a(this.EK, com.kwad.sdk.core.response.b.a.aU(dP).materialUrl, this.Df.mAdTemplate);
        this.EE.setImageResource(R.drawable.obfuscated_res_0x7f080e6a);
        KSImageLoader.loadAppIcon(this.EE, com.kwad.sdk.core.response.b.a.cf(dP), this.Df.mAdTemplate, 24);
        this.EF.setText(com.kwad.sdk.core.response.b.a.cc(dP));
        this.EG.setText(com.kwad.sdk.core.response.b.a.au(dP));
        this.EL.aD(this.Df.mAdTemplate);
        if (!com.kwad.sdk.core.response.b.a.aF(dP)) {
            this.EM.setText("点击查看");
            this.EN.setVisibility(0);
            this.EN.setText("跳转详情页/第三方应用");
        } else {
            y(dP);
        }
        this.EA.a(dP);
    }
}
