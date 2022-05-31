package com.kwad.sdk.reward.presenter;

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
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.reward.g {
    public ImageView b;

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.setVisibility(i());
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, this.b, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.presenter.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.g) this).a.g;
        if (adTemplate.adInfoList.size() > 0) {
            a(com.kwad.sdk.core.response.a.a.h(adTemplate.adInfoList.get(0)));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ImageView) a(e());
    }

    public int e() {
        return R.id.obfuscated_res_0x7f091011;
    }

    public int i() {
        return 0;
    }
}
