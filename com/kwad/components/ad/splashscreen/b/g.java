package com.kwad.components.ad.splashscreen.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class g extends e implements com.kwad.sdk.core.h.b {
    public AdInfo mAdInfo;
    public ImageView yH;
    public ImageView yI;
    public boolean yG = false;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean yJ = false;

    private void a(final ImageView imageView) {
        this.yF.mRootContainer.setClipChildren(false);
        imageView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.g.3
            @Override // java.lang.Runnable
            public final void run() {
                float width = imageView.getWidth() / 1080.0f;
                float f = width * 2340.0f;
                float height = imageView.getHeight();
                float f2 = (f - height) / 2.0f;
                float f3 = f - (((width * 880.0f) * 1152.0f) / 880.0f);
                float f4 = (f3 * 0.5589225f) - f2;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((f4 - ((0.44107744f * f3) - f2)) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void k(String str, int i) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        if (i == 0) {
            this.yH.setVisibility(0);
            imageView = this.yH;
            adTemplate = this.yF.mAdTemplate;
            imageLoadingListener = new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.b.g.1
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view2) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                    g.this.yF.jE();
                    Bitmap bitmap = decodedResult.mBitmap;
                    if (bitmap == null || g.this.getContext() == null || Build.VERSION.SDK_INT < 17) {
                        return;
                    }
                    g.this.yI.setVisibility(0);
                    g.this.yI.setImageDrawable(new BitmapDrawable(g.this.getContext().getResources(), KSImageLoader.blur(g.this.getContext(), bitmap, 20)));
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view2, FailReason failReason) {
                    if (g.this.yJ) {
                        return;
                    }
                    g.this.yF.e(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view2) {
                }
            };
        } else {
            this.yI.setVisibility(0);
            if (com.kwad.components.ad.splashscreen.a.b.jS()) {
                a(this.yI);
            }
            imageView = this.yI;
            adTemplate = this.yF.mAdTemplate;
            imageLoadingListener = new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.b.g.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view2) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                    g.this.yF.jE();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view2, FailReason failReason) {
                    if (g.this.yJ) {
                        g.this.yF.e(0, "load image error");
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view2) {
                }
            };
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aR() {
        if (this.yG) {
            return;
        }
        this.yG = true;
        com.kwad.components.ad.splashscreen.local.c.V(getContext());
        com.kwad.components.core.m.c.ox().a(this.yF.mAdTemplate, null, null);
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aS() {
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.yI = (ImageView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091408);
        this.yH = (ImageView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f09140b);
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
        this.mAdInfo = bQ;
        String str = com.kwad.sdk.core.response.a.a.at(bQ).materialUrl;
        this.yI.setVisibility(0);
        this.yF.yd.a(this);
        int i = com.kwad.sdk.core.response.a.a.at(this.mAdInfo).source;
        if (getContext() != null) {
            SplashPreloadManager.qD();
            File aZ = SplashPreloadManager.aZ(this.mAdInfo.adPreloadInfo.preloadId);
            if (aZ != null && aZ.exists() && aZ.length() > 0) {
                str = Uri.fromFile(aZ).toString();
            }
            k(str, i);
        }
        com.kwad.sdk.core.h.a aVar = this.yF.yd;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.yJ = true;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.h.a aVar = this.yF.yd;
        if (aVar != null) {
            aVar.b(this);
        }
    }
}
