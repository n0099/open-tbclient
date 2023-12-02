package com.kwad.components.ad.splashscreen.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bn;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class h extends e {
    public ImageView Dh;
    public ImageView Di;
    public boolean Dj = false;
    public boolean Dk = false;
    public Runnable Dl = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.5
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.ae(h.this.Df.mAdTemplate);
            h.this.la();
        }
    };
    public AdInfo mAdInfo;

    /* renamed from: com.kwad.components.ad.splashscreen.c.h$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements ImageLoadingListener {
        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view2) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view2) {
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view2, final DecodedResult decodedResult) {
            h.this.lb();
            h.this.Di.setVisibility(0);
            GlobalThreadPools.Et().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap stackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    h.this.Di.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.this.Di.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view2, FailReason failReason) {
            h.this.la();
        }
    }

    private void kZ() {
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.ac(this.Df.mAdTemplate);
            bn.runOnUiThreadDelay(this.Dl, com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CQ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb() {
        if (this.Dk) {
            return;
        }
        this.Dk = true;
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.ad(this.Df.mAdTemplate);
            bn.c(this.Dl);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        lb();
    }

    private void a(final ImageView imageView) {
        ((FrameLayout) this.Df.mRootContainer.findViewById(R.id.obfuscated_res_0x7f092363)).setClipChildren(false);
        imageView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.4
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

    private void a(final ImageView imageView, final AdInfo adInfo) {
        ((FrameLayout) this.Df.mRootContainer.findViewById(R.id.obfuscated_res_0x7f092363)).setClipChildren(false);
        final AdInfo.CutRuleInfo ci = com.kwad.sdk.core.response.b.a.ci(adInfo);
        imageView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.h.3
            @Override // java.lang.Runnable
            public final void run() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d = com.kwad.sdk.core.response.b.a.aU(adInfo).width;
                AdInfo.CutRuleInfo cutRuleInfo = ci;
                double d2 = cutRuleInfo.picHeight;
                double d3 = cutRuleInfo.viewTopMargin;
                double d4 = cutRuleInfo.safeAreaHeight;
                if (d2 > 0.0d && d4 > 0.0d) {
                    double d5 = width / d;
                    double d6 = d3 / (d2 - d4);
                    double d7 = d3 * d5;
                    double d8 = (d2 * d5) - height;
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    marginLayoutParams.topMargin = (int) (((d8 / 2.0d) - (d7 - (d7 - (d6 * d8)))) * 2.0d);
                    imageView.setLayoutParams(marginLayoutParams);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        if (this.Dj) {
            return;
        }
        this.Dj = true;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        findViewById(R.id.obfuscated_res_0x7f0914b9).setVisibility(0);
        KSCornerImageView kSCornerImageView = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f0914b8);
        kSCornerImageView.setRadius(com.kwad.sdk.d.a.a.a(getContext(), 12.0f));
        KSImageLoader.loadImage(kSCornerImageView, com.kwad.sdk.core.response.b.a.cf(dP), this.Df.mAdTemplate);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f0914ba)).setText(com.kwad.sdk.core.response.b.a.cc(dP));
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0914b7);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.au(dP))) {
            textView.setVisibility(8);
        } else {
            textView.setText(com.kwad.sdk.core.response.b.a.au(dP));
        }
        this.Dh.setVisibility(8);
        this.Di.setVisibility(8);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Di = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914b4);
        this.Dh = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914c3);
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        this.mAdInfo = dP;
        String str = com.kwad.sdk.core.response.b.a.aU(dP).materialUrl;
        this.Di.setVisibility(0);
        int i = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).source;
        kZ();
        if (getContext() != null) {
            SplashPreloadManager.kw();
            File T2 = SplashPreloadManager.T(this.mAdInfo.adPreloadInfo.preloadId);
            if (T2 != null && T2.exists() && T2.length() > 0) {
                str = Uri.fromFile(T2).toString();
            }
            m(str, i);
        }
    }

    private void m(String str, int i) {
        if (i == 0) {
            this.Dh.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Dh.setVisibility(0);
            KSImageLoader.loadImage(this.Dh, str, this.Df.mAdTemplate, new AnonymousClass1());
            return;
        }
        this.Di.setVisibility(0);
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CO)) {
            a(this.Di, this.mAdInfo);
        } else {
            a(this.Di);
        }
        KSImageLoader.loadImage(this.Di, str, this.Df.mAdTemplate, new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.c.h.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                return false;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingCancelled(String str2, View view2) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingStarted(String str2, View view2) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                h.this.lb();
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str2, View view2, FailReason failReason) {
                h.this.la();
            }
        });
    }
}
