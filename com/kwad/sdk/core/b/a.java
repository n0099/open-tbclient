package com.kwad.sdk.core.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.m;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return "";
            }
            return context.getPackageName() + com.kwai.sodler.lib.c.b.b(context);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b.i
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return new String(c.a().a(b.a(m.a(0).getBytes("UTF-8"), b.a(str.getBytes()))), "UTF-8");
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.b.i
    public void a(String str, Map<String, String> map, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, jSONObject) == null) {
            f.a(str, map, jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.b.i
    public void a(@NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            map.put("Ks-PkgId", a());
            map.put("Ks-Encoding", "2");
        }
    }

    @Override // com.kwad.sdk.core.b.i
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return new String(b.b(b.a(m.a(0), c.b().a(str.getBytes()))), "UTF-8");
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }
}
