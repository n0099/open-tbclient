package com.kwad.components.ad.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class c extends b {
    public ImageView sb;
    public AdInfo sc;

    public int hp() {
        return R.id.obfuscated_res_0x7f091319;
    }

    public c(AdInfo adInfo) {
        this.sc = adInfo;
    }

    public static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.c.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.qn.mAdTemplate;
        if (!ho() && adTemplate.adInfoList.size() > 0) {
            String X = com.kwad.sdk.core.response.b.a.X(adTemplate.adInfoList.get(0));
            this.sb.setVisibility(hq());
            try {
                a(this.sb, X, adTemplate);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    public int hq() {
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qn.mAdTemplate) && !ai.Kx()) {
            return 0;
        }
        if (com.kwad.components.ad.reward.g.E(this.qn.mAdTemplate) && !ai.Kx()) {
            return 0;
        }
        if ((com.kwad.sdk.core.response.b.e.eb(this.qn.mAdTemplate) && !ai.Kx()) || com.kwad.components.ad.reward.g.g(this.sc)) {
            return 0;
        }
        if (com.kwad.sdk.core.response.b.a.cB(this.sc) && com.kwad.components.ad.reward.a.b.gA() && !ai.Kx()) {
            return 0;
        }
        return 8;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sb = (ImageView) findViewById(hp());
    }
}
