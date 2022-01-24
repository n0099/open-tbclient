package com.kwad.sdk.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57395b;

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f57395b.setVisibility(i());
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, this.f57395b, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.presenter.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.g) this).a.f57252g;
        if (adTemplate.adInfoList.size() > 0) {
            a(com.kwad.sdk.core.response.a.a.h(adTemplate.adInfoList.get(0)));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57395b = (ImageView) a(e());
    }

    public int e() {
        return R.id.ksad_blur_video_cover;
    }

    public int i() {
        return 0;
    }
}
