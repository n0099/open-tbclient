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
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tieba.R;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class KSImageLoader {
    public static DisplayImageOptionsCompat IMGOPTION_ENTRY;
    public static DisplayImageOptionsCompat IMGOPTION_NORMAL = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();
    public static DisplayImageOptionsCompat IMGOPTION_TREND;
    public static DisplayImageOptionsCompat IMGOPTION_TUBE;

    /* renamed from: com.kwad.sdk.core.imageloader.KSImageLoader$1  reason: invalid class name */
    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static class InnerImageLoadingListener implements ImageLoadingListener {
        @Nullable
        public AdTemplate adTemplate;
        @Nullable
        public ImageLoadingListener loadingListener;

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
        public void onLoadingCancelled(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingCancelled(str, view);
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingComplete(str, view, decodedResult);
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            String str2;
            String str3;
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, view, failReason);
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
                        str3 = RomUtils.UNKNOWN;
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
                d.a(this.adTemplate, str, sb.toString());
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingStarted(str, view);
            }
        }
    }

    public static DisplayImageOptionsCompat IMGOPTION_ENTRY_FS() {
        return IMGOPTION_ENTRY;
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
        } catch (Exception e2) {
            a.b(e2);
        }
        return createBitmap;
    }

    public static void checkInit() {
        if (ImageLoaderProxy.INSTANCE.isInited()) {
            return;
        }
        init(KsAdSDKImpl.get().getContext());
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        IMGOPTION_ENTRY = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.obfuscated_res_0x7f080bcb).showImageForEmptyUri(R.drawable.obfuscated_res_0x7f080bcb).showImageOnFail(R.drawable.obfuscated_res_0x7f080bcb).build();
        IMGOPTION_TUBE = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.obfuscated_res_0x7f080cb3).showImageForEmptyUri(R.drawable.obfuscated_res_0x7f080cb3).showImageOnFail(R.drawable.obfuscated_res_0x7f080cb3).build();
        IMGOPTION_TREND = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.obfuscated_res_0x7f080cb2).showImageForEmptyUri(R.drawable.obfuscated_res_0x7f080cb2).showImageOnFail(R.drawable.obfuscated_res_0x7f080cb2).build();
        ImageLoaderProxy.INSTANCE.init(context, ImageLoadFactory.create());
    }

    public static void loadAppIcon(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080b9a)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080b9a)).showImageOnFail(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080b9a)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadAuthorCircleIcon(ImageView imageView, String str) {
        loadCircleIcon(imageView, str, imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bdf));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(Color.argb(255, 255, 255, 255)).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable, @ColorInt int i) {
        if (imageView == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(1).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithBorder(ImageView imageView, String str, Drawable drawable, Integer num, float f2) {
        if (imageView == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(num.intValue()).setStrokeWidth(f2).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithoutStroke(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setCircle(true).build(), (ImageLoadingListener) null);
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadFeeImage(imageView, str, adTemplate, null);
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).setCornerRound(1).build(), new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadImage(imageView, str, adTemplate, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null) {
            return;
        }
        checkInit();
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, IMGOPTION_NORMAL, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (TextUtils.isEmpty(str) || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadWithRadius(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080b9a)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080b9a)).showImageOnFail(imageView.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080b9a)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i).build(), new InnerImageLoadingListener(adTemplate, null));
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
