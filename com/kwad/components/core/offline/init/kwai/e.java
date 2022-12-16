package com.kwad.components.core.offline.init.kwai;

import android.graphics.Bitmap;
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
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class e implements IImageLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    private ImageLoadingListener a(IImageLoader.ImageLoadingListener imageLoadingListener, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, ImageView imageView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, imageLoadingListener, displayImageOptionsCompat, imageView)) == null) {
            if (imageLoadingListener == null) {
                return null;
            }
            return new ImageLoadingListener(this, imageLoadingListener, displayImageOptionsCompat, imageView) { // from class: com.kwad.components.core.offline.init.kwai.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IImageLoader.ImageLoadingListener EM;
                public final /* synthetic */ IImageLoader.DisplayImageOptionsCompat EN;
                public final /* synthetic */ e EO;
                public final /* synthetic */ ImageView yL;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageLoadingListener, displayImageOptionsCompat, imageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.EO = this;
                    this.EM = imageLoadingListener;
                    this.EN = displayImageOptionsCompat;
                    this.yL = imageView;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    InterceptResult invokeLLL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL2 = interceptable2.invokeLLL(1048576, this, str, inputStream, decodedResult)) == null) {
                        return this.EM.onDecode(str, inputStream, decodedResult == null ? null : decodedResult.mBitmap);
                    }
                    return invokeLLL2.booleanValue;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2) == null) {
                        this.EM.onLoadingCancelled(str, view2);
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                    Bitmap bitmap;
                    Bitmap bitmap2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, view2, decodedResult) == null) {
                        IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat2 = this.EN;
                        if (displayImageOptionsCompat2 == null || displayImageOptionsCompat2.getBlurRadius() <= 0 || decodedResult == null || (bitmap2 = decodedResult.mBitmap) == null) {
                            bitmap = null;
                        } else {
                            bitmap = BlurUtils.stackBlur(bitmap2, this.EN.getBlurRadius(), false);
                            this.yL.setImageBitmap(bitmap);
                        }
                        this.EM.onLoadingComplete(str, view2, decodedResult != null ? bitmap == null ? decodedResult.mBitmap : bitmap : null);
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str, view2, failReason) == null) {
                        this.EM.onLoadingFailed(str, view2, failReason.getType().toString(), failReason.getCause());
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str, view2) == null) {
                        this.EM.onLoadingStarted(str, view2);
                    }
                }
            };
        }
        return (ImageLoadingListener) invokeLLL.objValue;
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
            KSImageLoader.loadImage(imageView, str, null, a(displayImageOptionsCompat), a(imageLoadingListener, displayImageOptionsCompat, imageView));
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, imageView, str, imageLoadingListener) == null) {
            KSImageLoader.loadImage(imageView, str, (AdTemplate) null, a(imageLoadingListener, null, imageView));
        }
    }
}
