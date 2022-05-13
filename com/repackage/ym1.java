package com.repackage;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public final class ym1 extends xl2<ym1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        public static final String a = xl2.r("SwanFileFetcher.Params", "file_url");
        public static final String b = xl2.r("SwanFileFetcher.Params", "file_save_path");
        public static final String c = xl2.r("SwanFileFetcher.Params", "file_head_map");
        public static final String d = xl2.r("SwanFileFetcher.Params", "image_save_gallery");
        public static final String e = xl2.r("SwanFileFetcher.Params", "file_cancel_tag");
    }

    public ym1() {
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

    public ym1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? z(a.e, str) : (ym1) invokeL.objValue;
    }

    public ym1 F(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Bundle bundle = new Bundle();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            return u(a.c, bundle);
        }
        return (ym1) invokeL.objValue;
    }

    public ym1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? z(a.b, str) : (ym1) invokeL.objValue;
    }

    public ym1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? z(a.a, str) : (ym1) invokeL.objValue;
    }

    public ym1 I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? t(a.d, z) : (ym1) invokeZ.objValue;
    }

    public ym1 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (ym1) invokeV.objValue;
    }

    @Override // com.repackage.qf3
    public /* bridge */ /* synthetic */ qf3 a() {
        J();
        return this;
    }
}
