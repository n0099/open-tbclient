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
/* loaded from: classes6.dex */
public class c extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f33933a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f33934b;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33936d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f33937e;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33935c = false;

    /* renamed from: f  reason: collision with root package name */
    public Handler f33938f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public boolean f33939g = false;

    private void a(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        if (i2 == 0) {
            this.f33936d.setVisibility(0);
            imageView = this.f33936d;
            adTemplate = this.f33933a.f33987c;
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
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f33933a.f33985a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                    Bitmap bitmap = decodedResult.mBitmap;
                    if (bitmap == null || c.this.l() == null) {
                        return;
                    }
                    Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
                    if (Build.VERSION.SDK_INT >= 17) {
                        c.this.f33937e.setVisibility(0);
                        c.this.f33937e.setImageDrawable(new BitmapDrawable(c.this.l().getResources(), KSImageLoader.blur(c.this.l(), copy, 20)));
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    c cVar = c.this;
                    if (cVar.f33933a.f33985a == null || cVar.f33939g) {
                        return;
                    }
                    c.this.f33933a.f33985a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view) {
                }
            };
        } else {
            this.f33937e.setVisibility(0);
            imageView = this.f33937e;
            adTemplate = this.f33933a.f33987c;
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
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f33933a.f33985a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    c cVar = c.this;
                    if (cVar.f33933a.f33985a == null || !cVar.f33939g) {
                        return;
                    }
                    c.this.f33933a.f33985a.onAdShowError(0, "load image error");
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
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f33933a = cVar;
        this.f33937e = (ImageView) cVar.f33988d.findViewById(R.id.ksad_splash_background);
        this.f33936d = (ImageView) this.f33933a.f33988d.findViewById(R.id.ksad_splash_foreground);
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f33933a.f33987c);
        this.f33934b = g2;
        String str = com.kwad.sdk.core.response.b.a.B(g2).materialUrl;
        this.f33937e.setVisibility(0);
        this.f33933a.f33992h.a(this);
        AdInfo adInfo = this.f33934b;
        int i2 = adInfo.adSplashInfo.imageDisplaySecond;
        int i3 = com.kwad.sdk.core.response.b.a.B(adInfo).source;
        if (l() != null) {
            File a2 = SplashPreloadManager.b().a(this.f33934b.adPreloadInfo.preloadId);
            if (a2 != null && a2.exists() && a2.length() > 0) {
                str = Uri.fromFile(a2).toString();
            }
            a(str, i3);
        }
        com.kwad.sdk.core.i.b bVar = this.f33933a.f33992h;
        if (bVar != null) {
            bVar.a(this);
        }
        this.f33938f.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.kwad.sdk.core.download.a.b.a()) {
                    c.this.f33938f.postDelayed(this, 1000L);
                    return;
                }
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f33933a.f33985a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowEnd();
                }
            }
        }, i2 * 1000);
    }

    @Override // com.kwad.sdk.core.i.c
    public void a_() {
        if (this.f33935c) {
            return;
        }
        this.f33935c = true;
        com.kwad.sdk.core.report.b.a(this.f33933a.f33987c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.i.b bVar = this.f33933a.f33992h;
        if (bVar != null) {
            bVar.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f33939g = true;
        this.f33938f.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.c
    public void e() {
    }
}
