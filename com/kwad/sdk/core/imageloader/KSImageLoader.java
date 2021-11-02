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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.display.CircleBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.av;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class KSImageLoader {
    public static /* synthetic */ Interceptable $ic;
    public static DisplayImageOptions IMGOPTION_ENTRY;
    public static DisplayImageOptions IMGOPTION_NORMAL;
    public static DisplayImageOptions IMGOPTION_TREND;
    public static DisplayImageOptions IMGOPTION_TUBE;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.imageloader.KSImageLoader$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-272938882, "Lcom/kwad/sdk/core/imageloader/KSImageLoader$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-272938882, "Lcom/kwad/sdk/core/imageloader/KSImageLoader$1;");
                    return;
                }
            }
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

    /* loaded from: classes2.dex */
    public static class InnerImageLoadingListener implements ImageLoadingListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public AdTemplate adTemplate;
        public ImageLoadingListener loadingListener;

        public InnerImageLoadingListener(@Nullable AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adTemplate, imageLoadingListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.adTemplate = adTemplate;
            this.loadingListener = imageLoadingListener;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, inputStream, decodedResult)) == null) {
                ImageLoadingListener imageLoadingListener = this.loadingListener;
                if (imageLoadingListener != null) {
                    return imageLoadingListener.onDecode(str, inputStream, decodedResult);
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
            ImageLoadingListener imageLoadingListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view) == null) || (imageLoadingListener = this.loadingListener) == null) {
                return;
            }
            imageLoadingListener.onLoadingCancelled(str, view);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, view, decodedResult) == null) || (imageLoadingListener = this.loadingListener) == null) {
                return;
            }
            imageLoadingListener.onLoadingComplete(str, view, decodedResult);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, view, failReason) == null) {
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
                    d.a(this.adTemplate, str, sb.toString());
                }
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ImageLoadingListener imageLoadingListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, view) == null) || (imageLoadingListener = this.loadingListener) == null) {
                return;
            }
            imageLoadingListener.onLoadingStarted(str, view);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-728774805, "Lcom/kwad/sdk/core/imageloader/KSImageLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-728774805, "Lcom/kwad/sdk/core/imageloader/KSImageLoader;");
                return;
            }
        }
        IMGOPTION_NORMAL = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();
    }

    public KSImageLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static DisplayImageOptions IMGOPTION_ENTRY_FS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? IMGOPTION_ENTRY : (DisplayImageOptions) invokeV.objValue;
    }

    @RequiresApi(api = 17)
    public static Bitmap blur(Context context, Bitmap bitmap, @IntRange(from = 1, to = 25) int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, bitmap, i2)) == null) {
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
        return (Bitmap) invokeLLI.objValue;
    }

    public static void checkInit() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || ImageLoaderProxy.INSTANCE.isInited()) {
            return;
        }
        init(KsAdSDKImpl.get().getContext());
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) || context == null) {
            return;
        }
        IMGOPTION_ENTRY = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.ksad_loading_entry).showImageForEmptyUri(R.drawable.ksad_loading_entry).showImageOnFail(R.drawable.ksad_loading_entry).build();
        IMGOPTION_TUBE = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.ksad_tube_episode_cover_bg).showImageForEmptyUri(R.drawable.ksad_tube_episode_cover_bg).showImageOnFail(R.drawable.ksad_tube_episode_cover_bg).build();
        IMGOPTION_TREND = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.ksad_trend_panel_item_cover_bg).showImageForEmptyUri(R.drawable.ksad_trend_panel_item_cover_bg).showImageOnFail(R.drawable.ksad_trend_panel_item_cover_bg).build();
        ImageLoaderProxy.INSTANCE.init(context);
    }

    public static void loadAppIcon(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(AdIconUtil.BAIDU_LOGO_ID, null, imageView, str, adTemplate, i2) == null) || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).showImageOnFail(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new RoundedBitmapDisplayer(av.a(imageView.getContext(), i2))).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadAuthorCircleIcon(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, imageView, str) == null) {
            loadCircleIcon(imageView, str, imageView.getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon));
        }
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, imageView, str, drawable) == null) || imageView == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new CircleBitmapDisplayer(Integer.valueOf(Color.argb(255, 255, 255, 255)), av.a(imageView.getContext(), 1.0f))).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65545, null, imageView, str, drawable, i2) == null) || imageView == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new CircleBitmapDisplayer(Integer.valueOf(i2), av.a(imageView.getContext(), 1.0f))).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithBorder(ImageView imageView, String str, Drawable drawable, Integer num, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{imageView, str, drawable, num, Float.valueOf(f2)}) == null) || imageView == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new CircleBitmapDisplayer(num, f2)).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithoutStroke(ImageView imageView, String str, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, imageView, str, drawable) == null) || imageView == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptions.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new CircleBitmapDisplayer()).build(), (ImageLoadingListener) null);
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, imageView, str, adTemplate) == null) || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).displayer(new RoundedBitmapDisplayer(av.a(imageView.getContext(), 1.0f))).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, imageView, str, adTemplate) == null) {
            loadImage(imageView, str, adTemplate, IMGOPTION_NORMAL);
        }
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptions displayImageOptions) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65550, null, imageView, str, adTemplate, displayImageOptions) == null) || imageView == null) {
            return;
        }
        checkInit();
        if (displayImageOptions == null) {
            displayImageOptions = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, displayImageOptions, new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65551, null, imageView, str, adTemplate, displayImageOptions, imageLoadingListener) == null) || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        if (displayImageOptions == null) {
            displayImageOptions = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, displayImageOptions, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65552, null, imageView, str, adTemplate, imageLoadingListener) == null) || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, IMGOPTION_NORMAL, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(String str, AdTemplate adTemplate, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65553, null, str, adTemplate, displayImageOptions, imageLoadingListener) == null) || TextUtils.isEmpty(str) || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        checkInit();
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, displayImageOptions, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            checkInit();
            ImageLoaderProxy.INSTANCE.pause();
        }
    }

    public static void preloadImage(String str, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, adTemplate) == null) {
            loadImage(str, adTemplate, IMGOPTION_NORMAL, (ImageLoadingListener) null);
        }
    }

    public static void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            checkInit();
            ImageLoaderProxy.INSTANCE.resume();
        }
    }
}
