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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.cache.disc.naming.Md5FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.display.CircleBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class KSImageLoader {
    public static DisplayImageOptions IMGOPTION_ENTRY;
    public static DisplayImageOptions IMGOPTION_NORMAL = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();
    public static DisplayImageOptions IMGOPTION_TREND;
    public static DisplayImageOptions IMGOPTION_TUBE;

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
                    int i2 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failReason.getType().ordinal()];
                    if (i2 == 1) {
                        str3 = RomUtils.UNKNOWN;
                    } else if (i2 == 2) {
                        sb.append("IO_ERROR");
                        sb.append(str2);
                    } else if (i2 == 3) {
                        str3 = "OUT_OF_MEMORY";
                    } else if (i2 == 4) {
                        str3 = "NETWORK_DENIED";
                    } else if (i2 == 5) {
                        str3 = "DECODING_ERROR";
                    }
                    sb.append(str3);
                }
                e.c(this.adTemplate, str, sb.toString());
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

    @RequiresApi(api = 17)
    public static Bitmap blur(Context context, Bitmap bitmap, @IntRange(from = 1, to = 25) int i2) {
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
        create2.setInput(createFromBitmap);
        create2.setRadius(i2);
        create2.forEach(createFromBitmap);
        createFromBitmap.copyTo(bitmap);
        create.destroy();
        return bitmap;
    }

    public static void checkInit() {
        if (ImageLoader.getInstance().isInited()) {
            return;
        }
        init(KsAdSDKImpl.get().getContext());
    }

    public static void clearMemory() {
        ImageLoader.getInstance().clearMemoryCache();
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        IMGOPTION_ENTRY = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.ksad_loading_entry).showImageForEmptyUri(R.drawable.ksad_loading_entry).showImageOnFail(R.drawable.ksad_loading_entry).build();
        IMGOPTION_TUBE = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.ksad_tube_episode_cover_bg).showImageForEmptyUri(R.drawable.ksad_tube_episode_cover_bg).showImageOnFail(R.drawable.ksad_tube_episode_cover_bg).build();
        IMGOPTION_TREND = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.ksad_trend_panel_item_cover_bg).showImageForEmptyUri(R.drawable.ksad_trend_panel_item_cover_bg).showImageOnFail(R.drawable.ksad_trend_panel_item_cover_bg).build();
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context.getApplicationContext());
        builder.threadPriority(3);
        builder.denyCacheImageMultipleSizesInMemory();
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        builder.diskCacheSize(20971520);
        builder.tasksProcessingOrder(QueueProcessingType.LIFO);
        ImageLoader.getInstance().init(builder.build());
    }

    public static void loadAppIcon(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i2) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).showImageOnFail(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new RoundedBitmapDisplayer(ao.a(imageView.getContext(), i2))).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadAuthorCircleIcon(ImageView imageView, String str) {
        loadCircleIcon(imageView, str, imageView.getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null) {
            return;
        }
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new CircleBitmapDisplayer(Integer.valueOf(Color.argb(255, 255, 255, 255)), ao.a(imageView.getContext(), 1.0f))).build());
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable, @ColorInt int i2) {
        if (imageView == null) {
            return;
        }
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new CircleBitmapDisplayer(Integer.valueOf(i2), ao.a(imageView.getContext(), 1.0f))).build());
    }

    public static void loadCircleIconWithoutStroke(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null) {
            return;
        }
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new CircleBitmapDisplayer()).build());
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).displayer(new RoundedBitmapDisplayer(ao.a(imageView.getContext(), 1.0f))).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadImage(imageView, str, adTemplate, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptions displayImageOptions) {
        if (imageView == null) {
            return;
        }
        checkInit();
        if (displayImageOptions == null) {
            displayImageOptions = IMGOPTION_NORMAL;
        }
        ImageLoader.getInstance().displayImage(str, imageView, displayImageOptions, new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        if (displayImageOptions == null) {
            displayImageOptions = IMGOPTION_NORMAL;
        }
        ImageLoader.getInstance().displayImage(str, imageView, displayImageOptions, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, IMGOPTION_NORMAL, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(String str, AdTemplate adTemplate, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        if (TextUtils.isEmpty(str) || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        checkInit();
        ImageLoader.getInstance().loadImage(str, displayImageOptions, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void pause() {
        checkInit();
        ImageLoader.getInstance().pause();
    }

    public static void preloadImage(String str, AdTemplate adTemplate) {
        loadImage(str, adTemplate, IMGOPTION_NORMAL, (ImageLoadingListener) null);
    }

    public static void resume() {
        checkInit();
        ImageLoader.getInstance().resume();
    }
}
