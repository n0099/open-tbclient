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
/* loaded from: classes7.dex */
public class f extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f41246b;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f41248d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f41249e;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41247c = false;

    /* renamed from: f  reason: collision with root package name */
    public Handler f41250f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public boolean f41251g = false;

    private void a(String str, int i) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        if (i == 0) {
            this.f41248d.setVisibility(0);
            imageView = this.f41248d;
            adTemplate = this.a.f41330d;
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
                    f.this.f41249e.setVisibility(0);
                    f.this.f41249e.setImageDrawable(new BitmapDrawable(f.this.q().getResources(), KSImageLoader.blur(f.this.q(), bitmap, 20)));
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    f fVar = f.this;
                    if (fVar.a.a == null || fVar.f41251g) {
                        return;
                    }
                    f.this.a.a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view) {
                }
            };
        } else {
            this.f41249e.setVisibility(0);
            imageView = this.f41249e;
            adTemplate = this.a.f41330d;
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
                    if (fVar.a.a == null || !fVar.f41251g) {
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
        this.f41249e = (ImageView) gVar.f41331e.findViewById(R.id.obfuscated_res_0x7f091141);
        this.f41248d = (ImageView) this.a.f41331e.findViewById(R.id.obfuscated_res_0x7f091143);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.a.f41330d);
        this.f41246b = j;
        String str = com.kwad.sdk.core.response.a.a.I(j).materialUrl;
        this.f41249e.setVisibility(0);
        this.a.i.a(this);
        AdInfo adInfo = this.f41246b;
        int i = adInfo.adSplashInfo.imageDisplaySecond;
        int i2 = com.kwad.sdk.core.response.a.a.I(adInfo).source;
        if (q() != null) {
            File a = SplashPreloadManager.b().a(this.f41246b.adPreloadInfo.preloadId);
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
        this.f41251g = true;
        this.f41250f.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        if (this.f41247c) {
            return;
        }
        this.f41247c = true;
        com.kwad.sdk.core.report.a.a(this.a.f41330d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
    }
}
