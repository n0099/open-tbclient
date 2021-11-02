package com.facebook.fresco.ui.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes11.dex */
public class DimensionsInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mDecodedImageHeight;
    public final int mDecodedImageWidth;
    public final int mEncodedImageHeight;
    public final int mEncodedImageWidth;
    public final String mScaleType;
    public final int mViewportHeight;
    public final int mViewportWidth;

    public DimensionsInfo(int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mViewportWidth = i2;
        this.mViewportHeight = i3;
        this.mEncodedImageWidth = i4;
        this.mEncodedImageHeight = i5;
        this.mDecodedImageWidth = i6;
        this.mDecodedImageHeight = i7;
        this.mScaleType = str;
    }

    public int getDecodedImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDecodedImageHeight : invokeV.intValue;
    }

    public int getDecodedImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDecodedImageWidth : invokeV.intValue;
    }

    public int getEncodedImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEncodedImageHeight : invokeV.intValue;
    }

    public int getEncodedImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEncodedImageWidth : invokeV.intValue;
    }

    public String getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mScaleType : (String) invokeV.objValue;
    }

    public int getViewportHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mViewportHeight : invokeV.intValue;
    }

    public int getViewportWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mViewportWidth : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "DimensionsInfo{mViewportWidth=" + this.mViewportWidth + ", mViewportHeight=" + this.mViewportHeight + ", mEncodedImageWidth=" + this.mEncodedImageWidth + ", mEncodedImageHeight=" + this.mEncodedImageHeight + ", mDecodedImageWidth=" + this.mDecodedImageWidth + ", mDecodedImageHeight=" + this.mDecodedImageHeight + ", mScaleType='" + this.mScaleType + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
