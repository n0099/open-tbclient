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
    public com.kwad.sdk.splashscreen.c f34759a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f34760b;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f34762d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f34763e;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34761c = false;

    /* renamed from: f  reason: collision with root package name */
    public Handler f34764f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public boolean f34765g = false;

    private void a(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        if (i2 == 0) {
            this.f34762d.setVisibility(0);
            imageView = this.f34762d;
            adTemplate = this.f34759a.f34813c;
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
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f34759a.f34811a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                    Bitmap bitmap = decodedResult.mBitmap;
                    if (bitmap == null || c.this.l() == null) {
                        return;
                    }
                    Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
                    if (Build.VERSION.SDK_INT >= 17) {
                        c.this.f34763e.setVisibility(0);
                        c.this.f34763e.setImageDrawable(new BitmapDrawable(c.this.l().getResources(), KSImageLoader.blur(c.this.l(), copy, 20)));
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    c cVar = c.this;
                    if (cVar.f34759a.f34811a == null || cVar.f34765g) {
                        return;
                    }
                    c.this.f34759a.f34811a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view) {
                }
            };
        } else {
            this.f34763e.setVisibility(0);
            imageView = this.f34763e;
            adTemplate = this.f34759a.f34813c;
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
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f34759a.f34811a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    c cVar = c.this;
                    if (cVar.f34759a.f34811a == null || !cVar.f34765g) {
                        return;
                    }
                    c.this.f34759a.f34811a.onAdShowError(0, "load image error");
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
        this.f34759a = cVar;
        this.f34763e = (ImageView) cVar.f34814d.findViewById(R.id.ksad_splash_background);
        this.f34762d = (ImageView) this.f34759a.f34814d.findViewById(R.id.ksad_splash_foreground);
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f34759a.f34813c);
        this.f34760b = g2;
        String str = com.kwad.sdk.core.response.b.a.B(g2).materialUrl;
        this.f34763e.setVisibility(0);
        this.f34759a.f34818h.a(this);
        AdInfo adInfo = this.f34760b;
        int i2 = adInfo.adSplashInfo.imageDisplaySecond;
        int i3 = com.kwad.sdk.core.response.b.a.B(adInfo).source;
        if (l() != null) {
            File a2 = SplashPreloadManager.b().a(this.f34760b.adPreloadInfo.preloadId);
            if (a2 != null && a2.exists() && a2.length() > 0) {
                str = Uri.fromFile(a2).toString();
            }
            a(str, i3);
        }
        com.kwad.sdk.core.i.b bVar = this.f34759a.f34818h;
        if (bVar != null) {
            bVar.a(this);
        }
        this.f34764f.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.kwad.sdk.core.download.a.b.a()) {
                    c.this.f34764f.postDelayed(this, 1000L);
                    return;
                }
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.f34759a.f34811a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowEnd();
                }
            }
        }, i2 * 1000);
    }

    @Override // com.kwad.sdk.core.i.c
    public void a_() {
        if (this.f34761c) {
            return;
        }
        this.f34761c = true;
        com.kwad.sdk.core.report.b.a(this.f34759a.f34813c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.i.b bVar = this.f34759a.f34818h;
        if (bVar != null) {
            bVar.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f34765g = true;
        this.f34764f.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.c
    public void e() {
    }
}
