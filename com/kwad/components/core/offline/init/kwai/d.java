package com.kwad.components.core.offline.init.kwai;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class d implements IImageLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static DisplayImageOptionsCompat a(IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, displayImageOptionsCompat)) == null) {
            if (displayImageOptionsCompat == null) {
                return null;
            }
            return new DisplayImageOptionsCompat.Builder().showImageOnLoading(displayImageOptionsCompat.getImageOnLoading()).showImageForEmptyUri(displayImageOptionsCompat.getImageForEmptyUri()).showImageOnFail(displayImageOptionsCompat.getImageOnFail()).cacheInMemory(displayImageOptionsCompat.isCacheInMemory()).cacheOnDisk(displayImageOptionsCompat.isCacheOnDisk()).bitmapConfig(displayImageOptionsCompat.getDecodingOptions().inPreferredConfig).considerExifParams(displayImageOptionsCompat.isConsiderExifParams()).setBlurRadius(displayImageOptionsCompat.getBlurRadius()).setFrameSequence(displayImageOptionsCompat.isFrameSequence()).setCornerRound(displayImageOptionsCompat.getCornerRound()).setCircle(displayImageOptionsCompat.isCircle()).setStrokeColor(displayImageOptionsCompat.getStrokeColor()).setStrokeWidth(displayImageOptionsCompat.getStrokeWidth()).build();
        }
        return (DisplayImageOptionsCompat) invokeL.objValue;
    }

    private ImageLoadingListener a(IImageLoader.ImageLoadingListener imageLoadingListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, imageLoadingListener)) == null) {
            if (imageLoadingListener == null) {
                return null;
            }
            return new ImageLoadingListener(this, imageLoadingListener) { // from class: com.kwad.components.core.offline.init.kwai.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IImageLoader.ImageLoadingListener a;
                public final /* synthetic */ d b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageLoadingListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = imageLoadingListener;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str, inputStream, decodedResult)) == null) {
                        return this.a.onDecode(str, inputStream, decodedResult == null ? null : decodedResult.mBitmap);
                    }
                    return invokeLLL.booleanValue;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2) == null) {
                        this.a.onLoadingCancelled(str, view2);
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, view2, decodedResult) == null) {
                        this.a.onLoadingComplete(str, view2, decodedResult == null ? null : decodedResult.mBitmap);
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str, view2, failReason) == null) {
                        this.a.onLoadingFailed(str, view2, failReason.getType().toString(), failReason.getCause());
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str, view2) == null) {
                        this.a.onLoadingStarted(str, view2);
                    }
                }
            };
        }
        return (ImageLoadingListener) invokeL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) {
            KSImageLoader.loadImage(imageView, str, null);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str, displayImageOptionsCompat) == null) {
            KSImageLoader.loadImage(imageView, str, (AdTemplate) null, a(displayImageOptionsCompat));
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, IImageLoader.ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, imageView, str, displayImageOptionsCompat, imageLoadingListener) == null) {
            KSImageLoader.loadImage(imageView, str, null, a(displayImageOptionsCompat), a(imageLoadingListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, imageView, str, imageLoadingListener) == null) {
            KSImageLoader.loadImage(imageView, str, (AdTemplate) null, a(imageLoadingListener));
        }
    }
}
