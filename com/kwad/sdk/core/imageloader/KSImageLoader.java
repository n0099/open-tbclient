package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class KSImageLoader {
    public static DisplayImageOptionsCompat IMGOPTION_NORMAL = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();
    public static OnRenderResultListener<AdTemplate> mDefaultListener;

    /* renamed from: com.kwad.sdk.core.imageloader.KSImageLoader$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.IO_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class InnerImageLoadingListener implements ImageLoadingListener {
        @Nullable
        public AdTemplate adTemplate;
        @Nullable
        public ImageLoadingListener loadingListener;
        public final OnRenderResultListener<AdTemplate> mRenderResultListener = KSImageLoader.mDefaultListener;

        public InnerImageLoadingListener(@Nullable AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
            this.adTemplate = adTemplate;
            this.loadingListener = imageLoadingListener;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                return imageLoadingListener.onDecode(str, inputStream, decodedResult);
            }
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view2) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingCancelled(str, view2);
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingComplete(str, view2, decodedResult);
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view2, FailReason failReason) {
            String str2;
            String str3;
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, view2, failReason);
            }
            if (this.adTemplate != null) {
                StringBuilder sb = new StringBuilder("ImageLoader:");
                if (failReason != null) {
                    Throwable cause = failReason.getCause();
                    if (cause == null || cause.getStackTrace().length <= 0) {
                        str2 = "";
                    } else {
                        str2 = cause.getMessage() + " @ " + cause.getStackTrace()[0].getFileName() + cause.getStackTrace()[0].getClassName() + cause.getStackTrace()[0].getLineNumber();
                    }
                    int i = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failReason.getType().ordinal()];
                    if (i == 1) {
                        str3 = "UNKNOWN";
                    } else if (i == 2) {
                        sb.append("IO_ERROR");
                        sb.append(str2);
                    } else if (i == 3) {
                        str3 = "OUT_OF_MEMORY";
                    } else if (i == 4) {
                        str3 = "NETWORK_DENIED";
                    } else if (i == 5) {
                        str3 = "DECODING_ERROR";
                    }
                    sb.append(str3);
                }
                OnRenderResultListener<AdTemplate> onRenderResultListener = this.mRenderResultListener;
                if (onRenderResultListener != null) {
                    onRenderResultListener.onRenderResult(false, this.adTemplate, str, sb.toString());
                }
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view2) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingStarted(str, view2);
            }
        }
    }

    @RequiresApi(api = 17)
    public static Bitmap blur(Context context, Bitmap bitmap, @IntRange(from = 1, to = 25) int i) {
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        Bitmap copy = config == config2 ? bitmap : bitmap.copy(config2, true);
        if (copy == null) {
            copy = bitmap.copy(bitmap.getConfig(), true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(copy.getWidth(), copy.getHeight(), copy.getConfig());
        try {
            RenderScript create = RenderScript.create(context);
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createBitmap);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
            create2.setInput(createFromBitmap);
            create2.setRadius(i);
            create2.forEach(createFromBitmap);
            createFromBitmap.copyTo(createBitmap);
            create.destroy();
        } catch (Exception unused) {
        }
        return createBitmap;
    }

    public static void checkInit() {
        if (ImageLoaderProxy.INSTANCE.isInited()) {
            return;
        }
        init(getSDKContext(), mDefaultListener, null);
    }

    public static Context getSDKContext() {
        d dVar = (d) ServiceProvider.get(d.class);
        if (dVar != null) {
            return dVar.getContext();
        }
        return null;
    }

    public static void init(Context context, OnRenderResultListener<AdTemplate> onRenderResultListener, Executor executor) {
        if (context == null) {
            return;
        }
        mDefaultListener = onRenderResultListener;
        ImageLoaderProxy.INSTANCE.init(context);
    }

    public static void loadAppIcon(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e1d)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e1d)).showImageOnFail(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e1d)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(Color.argb(255, 255, 255, 255)).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable, @ColorInt int i) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(1).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithBorder(ImageView imageView, String str, Drawable drawable, Integer num, float f) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(num.intValue()).setStrokeWidth(f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithoutStroke(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setCircle(true).build(), (ImageLoadingListener) null);
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadFeeImage(imageView, str, adTemplate, null);
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).setCornerRound(1).build(), new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadImage(imageView, str, adTemplate, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        checkInit();
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        checkInit();
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, IMGOPTION_NORMAL, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadWithRadius(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e1d)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e1d)).showImageOnFail(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e1d)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void pause() {
        checkInit();
        ImageLoaderProxy.INSTANCE.pause();
    }

    public static void preloadImage(String str, AdTemplate adTemplate) {
        loadImage(str, adTemplate, IMGOPTION_NORMAL, (ImageLoadingListener) null);
    }

    public static void resume() {
        checkInit();
        ImageLoaderProxy.INSTANCE.resume();
    }
}
