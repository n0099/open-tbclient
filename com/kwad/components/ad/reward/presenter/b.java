package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class b extends a {
    public ImageView px;
    public AdInfo py;

    public b(AdInfo adInfo) {
        this.py = adInfo;
    }

    public static void a(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.b.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        AdTemplate adTemplate = this.nM.mAdTemplate;
        if (adTemplate.adInfoList.size() > 0) {
            String K = com.kwad.sdk.core.response.a.a.K(adTemplate.adInfoList.get(0));
            this.px.setVisibility(gT());
            a(this.px, K);
        }
    }

    public int gS() {
        return R.id.obfuscated_res_0x7f091229;
    }

    public int gT() {
        Context context = getContext();
        if (!com.kwad.components.ad.reward.k.p(this.nM.mAdTemplate) || ag.cB(context)) {
            if (!com.kwad.components.ad.reward.k.o(this.nM.mAdTemplate) || ag.cB(context)) {
                if (!com.kwad.sdk.core.response.a.d.cd(this.nM.mAdTemplate) || ag.cB(context)) {
                    if (com.kwad.sdk.core.response.a.a.aY(this.py) || com.kwad.components.ad.reward.kwai.b.j(this.py) || !com.kwad.sdk.core.response.a.b.cg(this.py)) {
                        return (com.kwad.sdk.core.response.a.a.bD(this.py) && com.kwad.components.ad.reward.kwai.b.gj() && !ag.cB(context)) ? 0 : 8;
                    }
                    return 0;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.px = (ImageView) findViewById(gS());
    }
}
