package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class ImageLoaderProxy implements IImageLoader {
    public static final /* synthetic */ ImageLoaderProxy[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ImageLoaderProxy INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public IImageLoader mDelegate;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(927419749, "Lcom/kwad/sdk/core/imageloader/ImageLoaderProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(927419749, "Lcom/kwad/sdk/core/imageloader/ImageLoaderProxy;");
                return;
            }
        }
        ImageLoaderProxy imageLoaderProxy = new ImageLoaderProxy("INSTANCE", 0);
        INSTANCE = imageLoaderProxy;
        $VALUES = new ImageLoaderProxy[]{imageLoaderProxy};
    }

    public ImageLoaderProxy(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDelegate = null;
    }

    public static ImageLoaderProxy valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ImageLoaderProxy) Enum.valueOf(ImageLoaderProxy.class, str) : (ImageLoaderProxy) invokeL.objValue;
    }

    public static ImageLoaderProxy[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ImageLoaderProxy[]) $VALUES.clone() : (ImageLoaderProxy[]) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void clearMemory(Context context) {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.clearMemory(context);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
        }
    }

    public void init(Context context, IImageLoader iImageLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, iImageLoader) == null) {
            iImageLoader.init(context);
            this.mDelegate = iImageLoader;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            IImageLoader iImageLoader = this.mDelegate;
            if (iImageLoader != null) {
                return iImageLoader.isInited();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, ImageView imageView, Object obj, int i2, int i3) {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, imageView, obj, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.load(context, imageView, obj, i2, i3);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048581, this, context, str, imageView, displayImageOptionsCompat, imageLoadingListener) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.load(context, str, imageView, displayImageOptionsCompat, imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, context, str, displayImageOptionsCompat, imageLoadingListener) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.load(context, str, displayImageOptionsCompat, imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(ImageView imageView, Object obj) {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, imageView, obj) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.load(imageView, obj);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(KsFragment ksFragment, @NonNull Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksFragment, context, str, displayImageOptionsCompat, imageLoadingListener) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.load(ksFragment, context, str, displayImageOptionsCompat, imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2) {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048585, this, ksFragment, str, imageView, drawable, drawable2) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.load(ksFragment, str, imageView, drawable, drawable2);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, float f2) {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{ksFragment, str, imageView, drawable, drawable2, Float.valueOf(f2)}) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.load(ksFragment, str, imageView, drawable, drawable2, f2);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void pause() {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.pause();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void resume() {
        IImageLoader iImageLoader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iImageLoader = this.mDelegate) == null) {
            return;
        }
        iImageLoader.resume();
    }
}
