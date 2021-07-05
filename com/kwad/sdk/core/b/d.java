package com.kwad.sdk.core.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static i f35914a;
    public transient /* synthetic */ FieldHolder $fh;

    public static i a() {
        InterceptResult invokeV;
        i gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            i iVar = f35914a;
            if (iVar != null) {
                return iVar;
            }
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_CLOSE_AES");
            if (a2 != null && ((Boolean) a2.getValue()).booleanValue()) {
                g gVar2 = new g();
                f35914a = gVar2;
                return gVar2;
            }
            if (com.kwad.sdk.d.f37023a == 1) {
                com.kwad.sdk.plugin.a aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.a.class);
                gVar = (aVar == null || aVar.a() == null) ? new g() : aVar.a();
            } else {
                com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.b.class);
                gVar = (bVar == null || bVar.a() == null) ? new g() : bVar.a();
            }
            f35914a = gVar;
            return f35914a;
        }
        return (i) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a().a(str) : (String) invokeL.objValue;
    }

    public static void a(String str, Map<String, String> map, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, map, jSONObject) == null) {
            a().a(str, map, jSONObject);
        }
    }

    public static void a(@NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, map) == null) {
            a().a(map);
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
            return (a2 == null || !((Boolean) a2.getValue()).booleanValue()) ? a().b(str) : str;
        }
        return (String) invokeL.objValue;
    }
}
