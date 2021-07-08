package com.kwad.sdk.core.b;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static i f34170a;
    public transient /* synthetic */ FieldHolder $fh;

    public static i a() {
        InterceptResult invokeV;
        i gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            i iVar = f34170a;
            if (iVar != null) {
                return iVar;
            }
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_CLOSE_AES");
            if (a2 != null && ((Boolean) a2.getValue()).booleanValue()) {
                g gVar2 = new g();
                f34170a = gVar2;
                return gVar2;
            }
            if (com.kwad.sdk.d.f35393a == 1) {
                com.kwad.sdk.plugin.a aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.a.class);
                gVar = (aVar == null || aVar.b() == null) ? new g() : aVar.b();
            } else {
                com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
                gVar = (bVar == null || bVar.b() == null) ? new g() : bVar.b();
            }
            f34170a = gVar;
            return f34170a;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
            return (a2 == null || !((Boolean) a2.getValue()).booleanValue()) ? a().b(str) : str;
        }
        return (String) invokeL.objValue;
    }
}
