package com.kuaishou.tachikoma.api;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Value;
import com.tachikoma.core.utility.V8Proxy;
import com.tachikoma.core.yoga.layout.YogaLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class TKProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TKProxy() {
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

    public static V8Array createV8Array(V8Value v8Value, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, v8Value, strArr)) == null) ? V8Proxy.createV8Array(v8Value, strArr) : (V8Array) invokeLL.objValue;
    }

    @Nullable
    public static Object getAssociateObject(List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) ? V8Proxy.getAssociateJsObject(list) : invokeL.objValue;
    }

    public static TKContext getTKContext(List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) ? new TKContext(V8Proxy.getTKContext(list)) : (TKContext) invokeL.objValue;
    }

    public static void release(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8Value) == null) {
            V8Proxy.release(v8Value);
        }
    }

    public static boolean setYogaLayoutHeight(Object obj, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65541, null, obj, f)) == null) {
            if (obj instanceof YogaLayout) {
                YogaLayout yogaLayout = (YogaLayout) obj;
                if (yogaLayout.getYogaNode() != null) {
                    yogaLayout.getYogaNode().setHeight(f);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeLF.booleanValue;
    }

    public static boolean setYogaLayoutHeightAuto(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
            if (obj instanceof YogaLayout) {
                YogaLayout yogaLayout = (YogaLayout) obj;
                if (yogaLayout.getYogaNode() != null) {
                    yogaLayout.getYogaNode().setHeightAuto();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean setYogaLayoutWidth(Object obj, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65543, null, obj, f)) == null) {
            if (obj instanceof YogaLayout) {
                YogaLayout yogaLayout = (YogaLayout) obj;
                if (yogaLayout.getYogaNode() != null) {
                    yogaLayout.getYogaNode().setWidth(f);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeLF.booleanValue;
    }

    public static boolean setYogaLayoutWidthAuto(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            if (obj instanceof YogaLayout) {
                YogaLayout yogaLayout = (YogaLayout) obj;
                if (yogaLayout.getYogaNode() != null) {
                    yogaLayout.getYogaNode().setWidthAuto();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
