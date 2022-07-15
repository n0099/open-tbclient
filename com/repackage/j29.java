package com.repackage;

import android.content.SharedPreferences;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.IRemoteUBCService;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBC;
import com.baidu.ubc.UBCManager;
import com.repackage.l19;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j29 implements UBCManager {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755640416, "Lcom/repackage/j29;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755640416, "Lcom/repackage/j29;");
                return;
            }
        }
        c = d29.m();
    }

    public j29() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
    }

    public final IRemoteUBCService a() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? UBC.getProxy() : (IRemoteUBCService) invokeV.objValue;
    }

    public final Flow b(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Flow ubcBeginFlowWithBizInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i)) == null) {
            Flow flow = null;
            try {
                if (TextUtils.isEmpty(this.a)) {
                    ubcBeginFlowWithBizInfo = a().ubcBeginFlow(str, str2, i);
                } else {
                    ubcBeginFlowWithBizInfo = a().ubcBeginFlowWithBizInfo(str, str2, i, this.a);
                }
                flow = ubcBeginFlowWithBizInfo;
                if (c) {
                    Log.d("UBCServiceManager", "flow id " + str + " beginFlow  process name " + sb1.b() + "flow hashCode " + flow.hashCode() + " handle id " + flow.getHandle());
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return flow == null ? new Flow() : flow;
        }
        return (Flow) invokeLLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? beginFlow(str, "", 0) : (Flow) invokeL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEvent(Flow flow, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, flow, str) == null) {
            flowAddEvent(flow, str, null);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEventWithDate(Flow flow, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{flow, str, str2, Long.valueOf(j)}) == null) {
            if (c) {
                Log.d("UBCServiceManager", " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid());
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (sb1.g()) {
                f19.w().G(flow.getId(), str, flow.getHandle(), str2, j, flow.getOption());
                return;
            }
            try {
                UBC.getProxy().flowAddEventWithTime(flow, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowCancel(Flow flow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, flow) == null) {
            if (c) {
                Log.d("UBCServiceManager", "cancel flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid());
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (d29.i().m() && flow.hasEnd()) {
                if (c) {
                    Log.d("UBCServiceManager", "flow has end, should not end again!!! ubc id=" + flow.getId() + ", flow handle=" + flow.getHandle());
                    return;
                }
                return;
            }
            flow.markEnd();
            if (sb1.g()) {
                f19.w().s(flow.getId(), flow.getHandle());
                return;
            }
            try {
                UBC.getProxy().flowCancel(flow);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowEnd(Flow flow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, flow) == null) {
            if (c) {
                Log.d("UBCServiceManager", "end flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid());
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (d29.i().m() && flow.hasEnd()) {
                if (c) {
                    Log.d("UBCServiceManager", "flow has end, should not end again!!! ubc id=" + flow.getId() + ", flow handle=" + flow.getHandle());
                    return;
                }
                return;
            }
            flow.markEnd();
            if (sb1.g()) {
                JSONArray jSONArray = new JSONArray();
                if (flow.getSlotMaps() != null && (r1 = flow.getSlotMaps().entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : flow.getSlotMaps().entrySet()) {
                        Slot value = entry.getValue();
                        if (value.isBegin() && !value.isEnded()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject jSONObject = entry.getValue().getJSONObject();
                        if (jSONObject != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                f19.w().u(flow.getId(), flow.getHandle(), flow.getOption(), jSONArray);
                return;
            }
            try {
                UBC.getProxy().flowEnd(flow);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowEndSlot(Flow flow, String str) {
        Slot slot;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, flow, str) == null) || flow == null || !flow.getValid() || TextUtils.isEmpty(str) || (slot = flow.getSlotMaps().get(str)) == null || !slot.isBegin() || slot.isEnded()) {
            return;
        }
        slot.setEnd(System.currentTimeMillis());
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValue(Flow flow, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, flow, str) == null) {
            if (c) {
                Log.d("UBCServiceManager", " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid());
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (sb1.g()) {
                f19.w().N(flow.getId(), flow.getHandle(), str);
                return;
            }
            try {
                UBC.getProxy().flowSetValue(flow, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValueWithDuration(Flow flow, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, flow, str) == null) {
            if (c) {
                Log.d("UBCServiceManager", " flow setValueWithDuration, mId:" + flow.getId() + " handle: " + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid());
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (sb1.g()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - flow.getStartTime())) / 1000.0f;
                    if (currentTimeMillis < 0.0f) {
                        currentTimeMillis = 0.0f;
                    }
                    jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis)));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(SpeedStatsUtils.UBC_KEY_OPTION, str);
                    }
                    if (c) {
                        Log.d("UBCServiceManager", " flow setValueWithDuration, mId:" + flow.getId() + ", duration: " + jSONObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                f19.w().N(flow.getId(), flow.getHandle(), jSONObject.toString());
                return;
            }
            try {
                UBC.getProxy().flowSetValueWithDuration(flow, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowStartSlot(Flow flow, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048595, this, flow, str, jSONObject) == null) || flow == null || !flow.getValid() || TextUtils.isEmpty(str)) {
            return;
        }
        Slot slot = flow.getSlotMaps().get(str);
        if (slot == null) {
            flow.getSlotMaps().put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
            return;
        }
        slot.setOption(jSONObject);
    }

    @Override // com.baidu.ubc.UBCManager
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (c) {
                Log.d("UBCServiceManager", "flush");
            }
            f19.w().v();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    @Deprecated
    public String getUploadType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (sb1.g()) {
                return f19.w().x(str);
            }
            try {
                return UBC.getProxy().getUploadType(str);
            } catch (RemoteException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public boolean isUBCDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (c) {
                return PreferenceManager.getDefaultSharedPreferences(d29.b()).getBoolean("KEY_UBC_DEBUG", c);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public boolean isUBCSample() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (c) {
                return PreferenceManager.getDefaultSharedPreferences(d29.b()).getBoolean("KEY_UBC_SAMPLE", false);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            onEvent(str, "", 0);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void registerConfig(y19 y19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, y19Var) == null) {
            registerConfig(y19Var, false, null);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void setDefaultConfig(o19 o19Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, o19Var) == null) && o19Var != null && sb1.g()) {
            l19.a aVar = new l19.a();
            aVar.c(o19Var.f);
            aVar.f(o19Var.a);
            aVar.e(o19Var.b);
            aVar.d(o19Var.d);
            aVar.g(o19Var.c);
            aVar.b(true);
            l19 a = aVar.a();
            if (!o19.a(o19Var.f)) {
                a.D(o19Var.e);
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(a);
            registerConfig(new y19(arrayList));
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void setUBCDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(d29.b()).edit();
            edit.putBoolean("KEY_UBC_DEBUG", z);
            edit.commit();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void setUBCSample(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(d29.b()).edit();
            edit.putBoolean("KEY_UBC_SAMPLE", z);
            edit.commit();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void upload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (c) {
                Log.d("UBCServiceManager", "upload all data");
            }
            f19.w().O();
            f19.w().K();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void uploadFailedData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (c) {
                Log.d("UBCServiceManager", "uploadFailedData and quality data");
            }
            f19.w().E();
            f19.w().L();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void uploadLocalDatas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (sb1.g()) {
                f19.w().W();
                return;
            }
            try {
                UBC.getProxy().uploadLocalDatas();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) ? beginFlow(str, "", i) : (Flow) invokeLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEvent(Flow flow, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, flow, str, str2) == null) {
            if (c) {
                Log.d("UBCServiceManager", " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid());
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (sb1.g()) {
                f19.w().F(flow.getId(), str, flow.getHandle(), str2, flow.getOption());
                return;
            }
            try {
                UBC.getProxy().flowAddEvent(flow, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, str, i) == null) {
            onEvent(str, "", i);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void registerConfig(y19 y19Var, boolean z, u19 u19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{y19Var, Boolean.valueOf(z), u19Var}) == null) {
            f19.w().M(y19Var, z, u19Var);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) ? beginFlow(str, str2, 0) : (Flow) invokeLL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            onEvent(str, str2, 0);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject)) == null) ? beginFlow(str, jSONObject, 0) : (Flow) invokeLL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, jSONObject) == null) {
            onEvent(str, jSONObject, 0);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, map)) == null) ? beginFlow(str, map, 0) : (Flow) invokeLL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, map) == null) {
            onEvent(str, map, 0);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, Map<String, String> map, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, str, map, i)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                if (c) {
                    Log.d("UBCServiceManager", "UBC beginFlow# exception:" + e.getMessage());
                }
            }
            return beginFlow(str, jSONObject.toString(), i);
        }
        return (Flow) invokeLLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, Map<String, String> map, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048605, this, str, map, i) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                if (c) {
                    Log.d("UBCServiceManager", "UBC onEvent# exception:" + e.getMessage());
                }
            }
            onEvent(str, jSONObject.toString(), i);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValue(Flow flow, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, flow, map) == null) && flow != null && flow.getValid()) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                if (c) {
                    Log.d("UBCServiceManager", "UBC beginFlow# exception:" + e.getMessage());
                }
            }
            if (c) {
                Log.d("UBCServiceManager", " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + jSONObject.toString());
            }
            flowSetValue(flow, jSONObject.toString());
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public Flow beginFlow(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, str, str2, i)) == null) {
            if (sb1.g()) {
                if (TextUtils.isEmpty(str)) {
                    if (c) {
                        throw new IllegalArgumentException("UBC beginFlow#flowId must not be null.");
                    }
                    return null;
                }
                if (c) {
                    Log.d("UBCServiceManager", "begin flow id:" + str + " value:" + str2);
                }
                if (TextUtils.isEmpty(this.a)) {
                    return f19.w().o(str, str2, i);
                }
                return f19.w().p(str, str2, i, this.b);
            }
            return b(str, str2, i);
        }
        return (Flow) invokeLLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public void onEvent(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, str, str2, i) == null) {
            if (sb1.g()) {
                if (TextUtils.isEmpty(str)) {
                    if (c) {
                        throw new IllegalArgumentException("UBC onEvent#eventId must not be null.");
                    }
                    return;
                }
                if (c) {
                    Log.d("UBCServiceManager", "on event id:" + str + " value:" + str2);
                }
                if (TextUtils.isEmpty(this.a)) {
                    f19.w().A(str, str2, i);
                    return;
                } else {
                    f19.w().B(str, str2, i, this.b);
                    return;
                }
            }
            try {
                IRemoteUBCService a = a();
                if (TextUtils.isEmpty(this.a)) {
                    a.ubcOnEvent(str, str2, i);
                } else {
                    a.ubcOnEventWithBizInfo(str, str2, i, this.a);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public Flow beginFlow(String str, JSONObject jSONObject, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, str, jSONObject, i)) == null) {
            if (sb1.g()) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (c) {
                    Log.d("UBCServiceManager", "begin flow id:" + str + " value:" + jSONObject);
                }
                if (TextUtils.isEmpty(this.a)) {
                    return f19.w().q(str, jSONObject, i);
                }
                return f19.w().r(str, jSONObject, i, this.b);
            }
            return b(str, jSONObject.toString(), i);
        }
        return (Flow) invokeLLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public void onEvent(String str, JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048607, this, str, jSONObject, i) == null) {
            if (sb1.g()) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (c) {
                    Log.d("UBCServiceManager", "on event id:" + str + " value:" + jSONObject.toString());
                }
                if (TextUtils.isEmpty(this.a)) {
                    f19.w().C(str, jSONObject, i);
                    return;
                } else {
                    f19.w().D(str, jSONObject, i, this.b);
                    return;
                }
            }
            try {
                IRemoteUBCService a = a();
                if (TextUtils.isEmpty(this.a)) {
                    a.ubcOnEvent(str, jSONObject.toString(), i);
                } else {
                    a.ubcOnEventWithBizInfo(str, jSONObject.toString(), i, this.a);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
