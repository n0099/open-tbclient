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
/* loaded from: classes4.dex */
public class f extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f57990b;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f57992d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57993e;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57991c = false;

    /* renamed from: f  reason: collision with root package name */
    public Handler f57994f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public boolean f57995g = false;

    private void a(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        if (i2 == 0) {
            this.f57992d.setVisibility(0);
            imageView = this.f57992d;
            adTemplate = this.a.f58087d;
            imageLoadingListener = new ImageLoadingListener() { // from class: com.kwad.sdk.splashscreen.a.f.1
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = f.this.a.a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                    Bitmap bitmap = decodedResult.mBitmap;
                    if (bitmap == null || f.this.q() == null || Build.VERSION.SDK_INT < 17) {
                        return;
                    }
                    f.this.f57993e.setVisibility(0);
                    f.this.f57993e.setImageDrawable(new BitmapDrawable(f.this.q().getResources(), KSImageLoader.blur(f.this.q(), bitmap, 20)));
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    f fVar = f.this;
                    if (fVar.a.a == null || fVar.f57995g) {
                        return;
                    }
                    f.this.a.a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view) {
                }
            };
        } else {
            this.f57993e.setVisibility(0);
            imageView = this.f57993e;
            adTemplate = this.a.f58087d;
            imageLoadingListener = new ImageLoadingListener() { // from class: com.kwad.sdk.splashscreen.a.f.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = f.this.a.a;
                    if (splashScreenAdInteractionListener != null) {
                        splashScreenAdInteractionListener.onAdShowStart();
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    f fVar = f.this;
                    if (fVar.a.a == null || !fVar.f57995g) {
                        return;
                    }
                    f.this.a.a.onAdShowError(0, "load image error");
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
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.a = gVar;
        this.f57993e = (ImageView) gVar.f58088e.findViewById(R.id.ksad_splash_background);
        this.f57992d = (ImageView) this.a.f58088e.findViewById(R.id.ksad_splash_foreground);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f58087d);
        this.f57990b = j2;
        String str = com.kwad.sdk.core.response.a.a.I(j2).materialUrl;
        this.f57993e.setVisibility(0);
        this.a.f58092i.a(this);
        AdInfo adInfo = this.f57990b;
        int i2 = adInfo.adSplashInfo.imageDisplaySecond;
        int i3 = com.kwad.sdk.core.response.a.a.I(adInfo).source;
        if (q() != null) {
            File a = SplashPreloadManager.b().a(this.f57990b.adPreloadInfo.preloadId);
            if (a != null && a.exists() && a.length() > 0) {
                str = Uri.fromFile(a).toString();
            }
            a(str, i3);
        }
        com.kwad.sdk.core.j.c cVar = this.a.f58092i;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.j.c cVar = this.a.f58092i;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.f57995g = true;
        this.f57994f.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        if (this.f57991c) {
            return;
        }
        this.f57991c = true;
        com.kwad.sdk.core.report.a.a(this.a.f58087d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
    }
}
