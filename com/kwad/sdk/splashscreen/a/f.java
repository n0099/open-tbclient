package com.kwad.sdk.splashscreen.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;
    public AdInfo b;
    public ImageView d;
    public ImageView e;
    public boolean c = false;
    public Handler f = new Handler(Looper.getMainLooper());
    public boolean g = false;

    private void a(String str, int i) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        if (i == 0) {
            this.d.setVisibility(0);
            imageView = this.d;
            adTemplate = this.a.d;
            imageLoadingListener = new ImageLoadingListener() { // from class: com.kwad.sdk.splashscreen.a.f.1
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingCancelled(String str2, View view2) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = f.this.a.a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                    Bitmap bitmap = decodedResult.mBitmap;
                    if (bitmap == null || f.this.q() == null || Build.VERSION.SDK_INT < 17) {
                        return;
                    }
                    f.this.e.setVisibility(0);
                    f.this.e.setImageDrawable(new BitmapDrawable(f.this.q().getResources(), KSImageLoader.blur(f.this.q(), bitmap, 20)));
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view2, FailReason failReason) {
                    f fVar = f.this;
                    if (fVar.a.a == null || fVar.g) {
                        return;
                    }
                    f.this.a.a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view2) {
                }
            };
        } else {
            this.e.setVisibility(0);
            imageView = this.e;
            adTemplate = this.a.d;
            imageLoadingListener = new ImageLoadingListener() { // from class: com.kwad.sdk.splashscreen.a.f.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingCancelled(String str2, View view2) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = f.this.a.a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view2, FailReason failReason) {
                    f fVar = f.this;
                    if (fVar.a.a == null || !fVar.g) {
                        return;
                    }
                    f.this.a.a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view2) {
                }
            };
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, imageLoadingListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.a = gVar;
        this.e = (ImageView) gVar.e.findViewById(R.id.obfuscated_res_0x7f0910fc);
        this.d = (ImageView) this.a.e.findViewById(R.id.obfuscated_res_0x7f0910fe);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.a.d);
        this.b = j;
        String str = com.kwad.sdk.core.response.a.a.I(j).materialUrl;
        this.e.setVisibility(0);
        this.a.i.a(this);
        AdInfo adInfo = this.b;
        int i = adInfo.adSplashInfo.imageDisplaySecond;
        int i2 = com.kwad.sdk.core.response.a.a.I(adInfo).source;
        if (q() != null) {
            File a = SplashPreloadManager.b().a(this.b.adPreloadInfo.preloadId);
            if (a != null && a.exists() && a.length() > 0) {
                str = Uri.fromFile(a).toString();
            }
            a(str, i2);
        }
        com.kwad.sdk.core.j.c cVar = this.a.i;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.j.c cVar = this.a.i;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.g = true;
        this.f.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        if (this.c) {
            return;
        }
        this.c = true;
        com.kwad.sdk.core.report.a.a(this.a.d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
    }
}
