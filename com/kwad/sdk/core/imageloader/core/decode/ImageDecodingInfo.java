package com.kwad.sdk.core.imageloader.core.decode;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
/* loaded from: classes7.dex */
public class ImageDecodingInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean considerExifParams;
    public final BitmapFactory.Options decodingOptions;
    public final ImageDownloader downloader;
    public final Object extraForDownloader;
    public final String imageKey;
    public final ImageScaleType imageScaleType;
    public final String imageUri;
    public final ImageLoadingListener listener;
    public final String originalImageUri;
    public final ImageSize targetSize;
    public final ViewScaleType viewScaleType;

    public ImageDecodingInfo(String str, String str2, String str3, ImageSize imageSize, ViewScaleType viewScaleType, ImageDownloader imageDownloader, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, imageSize, viewScaleType, imageDownloader, displayImageOptions, imageLoadingListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.imageKey = str;
        this.imageUri = str2;
        this.originalImageUri = str3;
        this.targetSize = imageSize;
        this.imageScaleType = displayImageOptions.getImageScaleType();
        this.viewScaleType = viewScaleType;
        this.downloader = imageDownloader;
        this.extraForDownloader = displayImageOptions.getExtraForDownloader();
        this.considerExifParams = displayImageOptions.isConsiderExifParams();
        this.decodingOptions = new BitmapFactory.Options();
        this.listener = imageLoadingListener;
        copyOptions(displayImageOptions.getDecodingOptions(), this.decodingOptions);
    }

    private void copyOptions(BitmapFactory.Options options, BitmapFactory.Options options2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, options, options2) == null) {
            options2.inDensity = options.inDensity;
            options2.inDither = options.inDither;
            options2.inInputShareable = options.inInputShareable;
            options2.inJustDecodeBounds = options.inJustDecodeBounds;
            options2.inPreferredConfig = options.inPreferredConfig;
            options2.inPurgeable = options.inPurgeable;
            options2.inSampleSize = options.inSampleSize;
            options2.inScaled = options.inScaled;
            options2.inScreenDensity = options.inScreenDensity;
            options2.inTargetDensity = options.inTargetDensity;
            options2.inTempStorage = options.inTempStorage;
            if (Build.VERSION.SDK_INT >= 10) {
                copyOptions10(options, options2);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                copyOptions11(options, options2);
            }
        }
    }

    @TargetApi(10)
    private void copyOptions10(BitmapFactory.Options options, BitmapFactory.Options options2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, options, options2) == null) {
            options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
        }
    }

    @TargetApi(11)
    private void copyOptions11(BitmapFactory.Options options, BitmapFactory.Options options2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, options, options2) == null) {
            options2.inBitmap = options.inBitmap;
            options2.inMutable = options.inMutable;
        }
    }

    public BitmapFactory.Options getDecodingOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.decodingOptions : (BitmapFactory.Options) invokeV.objValue;
    }

    public ImageDownloader getDownloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.downloader : (ImageDownloader) invokeV.objValue;
    }

    public Object getExtraForDownloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.extraForDownloader : invokeV.objValue;
    }

    public String getImageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.imageKey : (String) invokeV.objValue;
    }

    public ImageScaleType getImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.imageScaleType : (ImageScaleType) invokeV.objValue;
    }

    public String getImageUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.imageUri : (String) invokeV.objValue;
    }

    public ImageLoadingListener getLoadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.listener : (ImageLoadingListener) invokeV.objValue;
    }

    public String getOriginalImageUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.originalImageUri : (String) invokeV.objValue;
    }

    public ImageSize getTargetSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.targetSize : (ImageSize) invokeV.objValue;
    }

    public ViewScaleType getViewScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.viewScaleType : (ViewScaleType) invokeV.objValue;
    }

    public boolean shouldConsiderExifParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.considerExifParams : invokeV.booleanValue;
    }
}
