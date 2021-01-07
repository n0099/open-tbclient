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
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.splashscreen.c f11024a;

    /* renamed from: b  reason: collision with root package name */
    private AdInfo f11025b;
    private ImageView d;
    private ImageView e;
    private boolean c = false;
    private Handler f = new Handler(Looper.getMainLooper());
    private boolean g = false;

    private void a(String str, int i) {
        if (i == 0) {
            this.d.setVisibility(0);
            KSImageLoader.loadImage(this.d, str, this.f11024a.c, new ImageLoadingListener() { // from class: com.kwad.sdk.splashscreen.a.c.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    if (c.this.f11024a.f11047a != null) {
                        c.this.f11024a.f11047a.onAdShowStart();
                    }
                    Bitmap bitmap = decodedResult.mBitmap;
                    if (bitmap == null || c.this.o() == null) {
                        return;
                    }
                    Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
                    if (Build.VERSION.SDK_INT >= 17) {
                        c.this.e.setVisibility(0);
                        c.this.e.setImageDrawable(new BitmapDrawable(c.this.o().getResources(), KSImageLoader.blur(c.this.o(), copy, 20)));
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingFailed(String str2, View view, FailReason failReason) {
                    if (c.this.f11024a.f11047a == null || c.this.g) {
                        return;
                    }
                    c.this.f11024a.f11047a.onAdShowError(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingStarted(String str2, View view) {
                }
            });
            return;
        }
        this.e.setVisibility(0);
        KSImageLoader.loadImage(this.e, str, this.f11024a.c, new ImageLoadingListener() { // from class: com.kwad.sdk.splashscreen.a.c.3
            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                return false;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingCancelled(String str2, View view) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                if (c.this.f11024a.f11047a != null) {
                    c.this.f11024a.f11047a.onAdShowStart();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str2, View view, FailReason failReason) {
                if (c.this.f11024a.f11047a == null || !c.this.g) {
                    return;
                }
                c.this.f11024a.f11047a.onAdShowError(0, "load image error");
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str2, View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f11024a = (com.kwad.sdk.splashscreen.c) n();
        this.e = (ImageView) this.f11024a.d.findViewById(R.id.ksad_splash_background);
        this.d = (ImageView) this.f11024a.d.findViewById(R.id.ksad_splash_foreground);
        this.f11025b = com.kwad.sdk.core.response.b.c.j(this.f11024a.c);
        String str = com.kwad.sdk.core.response.b.a.D(this.f11025b).materialUrl;
        this.e.setVisibility(0);
        this.f11024a.h.a(this);
        int i = this.f11025b.adSplashInfo.imageDisplaySecond;
        int i2 = com.kwad.sdk.core.response.b.a.D(this.f11025b).source;
        if (o() != null) {
            File a2 = SplashPreloadManager.b().a(this.f11025b.adPreloadInfo.preloadId);
            if (a2 == null || !a2.exists() || a2.length() <= 0) {
                a(str, i2);
            } else {
                a(Uri.fromFile(a2).toString(), i2);
            }
        }
        if (this.f11024a.h != null) {
            this.f11024a.h.a(this);
        }
        this.f.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f11024a.f11047a != null) {
                    c.this.f11024a.f11047a.onAdShowEnd();
                }
            }
        }, i * 1000);
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f11024a.h != null) {
            this.f11024a.h.b(this);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        if (this.c) {
            return;
        }
        this.c = true;
        com.kwad.sdk.core.report.b.a(this.f11024a.c, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.g = true;
        this.f.removeCallbacksAndMessages(null);
    }
}
