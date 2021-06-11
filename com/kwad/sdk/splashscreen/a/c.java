package com.kwad.sdk.splashscreen.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
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
/* loaded from: classes7.dex */
public class c extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f37364a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f37365b;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37367d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f37368e;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37366c = false;

    /* renamed from: f  reason: collision with root package name */
    public Handler f37369f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public boolean f37370g = false;

    private void a(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        if (i2 == 0) {
            this.f37367d.setVisibility(0);
            imageView = this.f37367d;
            adTemplate = this.f37364a.f37415c;
            imageLoadingListener = new ImageLoadingListener() { // from class: com.kwad.sdk.splashscreen.a.c.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f37364a.f37413a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                    Bitmap bitmap = decodedResult.mBitmap;
                    if (bitmap == null || c.this.o() == null) {
                        return;
                    }
                    Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
                    if (Build.VERSION.SDK_INT >= 17) {
                        c.this.f37368e.setVisibility(0);
                        c.this.f37368e.setImageDrawable(new BitmapDrawable(c.this.o().getResources(), KSImageLoader.blur(c.this.o(), copy, 20)));
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    c cVar = c.this;
                    if (cVar.f37364a.f37413a == null || cVar.f37370g) {
                        return;
                    }
                    c.this.f37364a.f37413a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view) {
                }
            };
        } else {
            this.f37368e.setVisibility(0);
            imageView = this.f37368e;
            adTemplate = this.f37364a.f37415c;
            imageLoadingListener = new ImageLoadingListener() { // from class: com.kwad.sdk.splashscreen.a.c.3
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f37364a.f37413a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    c cVar = c.this;
                    if (cVar.f37364a.f37413a == null || !cVar.f37370g) {
                        return;
                    }
                    c.this.f37364a.f37413a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view) {
                }
            };
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, imageLoadingListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f37364a = cVar;
        this.f37368e = (ImageView) cVar.f37416d.findViewById(R.id.ksad_splash_background);
        this.f37367d = (ImageView) this.f37364a.f37416d.findViewById(R.id.ksad_splash_foreground);
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f37364a.f37415c);
        this.f37365b = j;
        String str = com.kwad.sdk.core.response.b.a.D(j).materialUrl;
        this.f37368e.setVisibility(0);
        this.f37364a.f37420h.a(this);
        AdInfo adInfo = this.f37365b;
        int i2 = adInfo.adSplashInfo.imageDisplaySecond;
        int i3 = com.kwad.sdk.core.response.b.a.D(adInfo).source;
        if (o() != null) {
            File a2 = SplashPreloadManager.b().a(this.f37365b.adPreloadInfo.preloadId);
            if (a2 != null && a2.exists() && a2.length() > 0) {
                str = Uri.fromFile(a2).toString();
            }
            a(str, i3);
        }
        com.kwad.sdk.core.i.b bVar = this.f37364a.f37420h;
        if (bVar != null) {
            bVar.a(this);
        }
        this.f37369f.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f37364a.f37413a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowEnd();
                }
            }
        }, i2 * 1000);
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.b bVar = this.f37364a.f37420h;
        if (bVar != null) {
            bVar.b(this);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.f37366c) {
            return;
        }
        this.f37366c = true;
        com.kwad.sdk.core.report.b.a(this.f37364a.f37415c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f37370g = true;
        this.f37369f.removeCallbacksAndMessages(null);
    }
}
