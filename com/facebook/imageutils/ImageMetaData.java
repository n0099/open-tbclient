package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ImageMetaData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final ColorSpace mColorSpace;
    @Nullable
    public final Pair<Integer, Integer> mDimensions;

    public ImageMetaData(int i2, int i3, @Nullable ColorSpace colorSpace) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), colorSpace};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDimensions = (i2 == -1 || i3 == -1) ? null : new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        this.mColorSpace = colorSpace;
    }

    @Nullable
    public ColorSpace getColorSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mColorSpace : (ColorSpace) invokeV.objValue;
    }

    @Nullable
    public Pair<Integer, Integer> getDimensions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDimensions : (Pair) invokeV.objValue;
    }
}
