package com.facebook.imagepipeline.producers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
/* loaded from: classes4.dex */
public final class ThumbnailSizeChecker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.3333334f;
    public static final int ROTATED_90_DEGREES_CLOCKWISE = 90;
    public static final int ROTATED_90_DEGREES_COUNTER_CLOCKWISE = 270;
    public transient /* synthetic */ FieldHolder $fh;

    public ThumbnailSizeChecker() {
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

    public static int getAcceptableSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? (int) (i * 1.3333334f) : invokeI.intValue;
    }

    public static boolean isImageBigEnough(int i, int i2, ResizeOptions resizeOptions) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i, i2, resizeOptions)) == null) ? resizeOptions == null ? ((float) getAcceptableSize(i)) >= 2048.0f && getAcceptableSize(i2) >= 2048 : getAcceptableSize(i) >= resizeOptions.width && getAcceptableSize(i2) >= resizeOptions.height : invokeIIL.booleanValue;
    }

    public static boolean isImageBigEnough(EncodedImage encodedImage, ResizeOptions resizeOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, encodedImage, resizeOptions)) == null) {
            if (encodedImage == null) {
                return false;
            }
            int rotationAngle = encodedImage.getRotationAngle();
            if (rotationAngle != 90 && rotationAngle != 270) {
                return isImageBigEnough(encodedImage.getWidth(), encodedImage.getHeight(), resizeOptions);
            }
            return isImageBigEnough(encodedImage.getHeight(), encodedImage.getWidth(), resizeOptions);
        }
        return invokeLL.booleanValue;
    }
}
