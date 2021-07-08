package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.i.b;
import com.kwad.sdk.core.imageloader.cache.disc.naming.Md5FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.utils.av;
/* loaded from: classes6.dex */
public class ImageLoadImpl implements IImageLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageLoadImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String parseModel(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, obj)) == null) {
            if (obj instanceof String) {
                return (String) obj;
            }
            throw new IllegalArgumentException("unsupport object except String!");
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void clearMemory(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            ImageLoader.getInstance().clearMemoryCache();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context.getApplicationContext());
            builder.taskExecutor(b.c());
            builder.taskExecutorForCachedImages(b.d());
            builder.denyCacheImageMultipleSizesInMemory();
            builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
            builder.diskCacheSize(20971520);
            builder.tasksProcessingOrder(QueueProcessingType.LIFO);
            ImageLoader.getInstance().init(builder.build());
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ImageLoader.getInstance().isInited() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, ImageView imageView, Object obj, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, imageView, obj, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            ImageLoader.getInstance().displayImage(parseModel(obj), imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(i3).showImageForEmptyUri(i2).showImageOnFail(i2).build());
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, str, imageView, displayImageOptions, imageLoadingListener) == null) {
            ImageLoader.getInstance().displayImage(str, imageView, displayImageOptions, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(Context context, String str, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, displayImageOptions, imageLoadingListener) == null) {
            ImageLoader.getInstance().loadImage(str, displayImageOptions, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, imageView, obj) == null) {
            ImageLoader.getInstance().displayImage(parseModel(obj), imageView);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(KsFragment ksFragment, @NonNull Context context, String str, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, ksFragment, context, str, displayImageOptions, imageLoadingListener) == null) {
            ImageLoader.getInstance().loadImage(str, displayImageOptions, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksFragment, str, imageView, drawable, drawable2) == null) {
            ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(drawable).showImageOnFail(drawable2).build());
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{ksFragment, str, imageView, drawable, drawable2, Float.valueOf(f2)}) == null) {
            ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(drawable).showImageOnFail(drawable2).displayer(new RoundedBitmapDisplayer(av.a(imageView.getContext(), f2))).build());
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ImageLoader.getInstance().pause();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ImageLoader.getInstance().resume();
        }
    }
}
