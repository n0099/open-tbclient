package com.kwad.sdk.core.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class ImageViewAware extends ViewAware {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewAware(ImageView imageView) {
        super(imageView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewAware(ImageView imageView, boolean z) {
        super(imageView, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int getImageViewFieldValue(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, str)) == null) {
            try {
                Field declaredField = ImageView.class.getDeclaredField(str);
                declaredField.setAccessible(true);
                int intValue = ((Integer) declaredField.get(obj)).intValue();
                if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                    return 0;
                }
                return intValue;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        InterceptResult invokeV;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int height = super.getHeight();
            return (height > 0 || (imageView = (ImageView) this.viewRef.get()) == null) ? height : getImageViewFieldValue(imageView, "mMaxHeight");
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImageView imageView = (ImageView) this.viewRef.get();
            return imageView != null ? ViewScaleType.fromImageView(imageView) : super.getScaleType();
        }
        return (ViewScaleType) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        InterceptResult invokeV;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int width = super.getWidth();
            return (width > 0 || (imageView = (ImageView) this.viewRef.get()) == null) ? width : getImageViewFieldValue(imageView, "mMaxWidth");
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ImageView getWrappedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (ImageView) super.getWrappedView() : (ImageView) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware
    public void setImageBitmapInto(Bitmap bitmap, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bitmap, view) == null) {
            ((ImageView) view).setImageBitmap(bitmap);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware
    public void setImageDrawableInto(Drawable drawable, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, drawable, view) == null) {
            ((ImageView) view).setImageDrawable(drawable);
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).start();
            }
        }
    }
}
