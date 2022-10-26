package com.facebook.drawee.backends.pipeline.debug;

import android.util.SparseIntArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes7.dex */
public class DebugOverlayImageOriginColor {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseIntArray IMAGE_ORIGIN_COLOR_MAP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(576499399, "Lcom/facebook/drawee/backends/pipeline/debug/DebugOverlayImageOriginColor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(576499399, "Lcom/facebook/drawee/backends/pipeline/debug/DebugOverlayImageOriginColor;");
                return;
            }
        }
        SparseIntArray sparseIntArray = new SparseIntArray(7);
        IMAGE_ORIGIN_COLOR_MAP = sparseIntArray;
        sparseIntArray.append(1, -7829368);
        IMAGE_ORIGIN_COLOR_MAP.append(2, -65536);
        IMAGE_ORIGIN_COLOR_MAP.append(3, -256);
        IMAGE_ORIGIN_COLOR_MAP.append(4, -256);
        IMAGE_ORIGIN_COLOR_MAP.append(5, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        IMAGE_ORIGIN_COLOR_MAP.append(6, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        IMAGE_ORIGIN_COLOR_MAP.append(7, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
    }

    public DebugOverlayImageOriginColor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getImageOriginColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return IMAGE_ORIGIN_COLOR_MAP.get(i, -1);
        }
        return invokeI.intValue;
    }
}
