package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ah {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(sg sgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, sgVar) == null) && d() && sgVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", sgVar.h());
                uBCManager.onEvent("3102", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(sg sgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, sgVar) == null) && d() && sgVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", sgVar.h());
                uBCManager.onEvent("3052", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(sg sgVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, sgVar) == null) && d() && sgVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", sgVar.h());
                uBCManager.onEvent("3103", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? ug.isOn() : invokeV.booleanValue;
    }

    public static void e(bh bhVar, sg sgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bhVar, sgVar) == null) {
            if (bhVar instanceof qh) {
                c(sgVar);
            } else if (bhVar instanceof ph) {
                b(sgVar);
            } else if (bhVar instanceof oh) {
                a(sgVar);
            }
        }
    }
}
