package com.vivo.push;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class PushManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_REQUEST_ID = "1";
    public static final Object SLOCK;
    public static final String TAG = "PushManager";
    public static volatile PushManager sPushClient;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-265234604, "Lcom/vivo/push/PushManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-265234604, "Lcom/vivo/push/PushManager;");
                return;
            }
        }
        SLOCK = new Object();
    }

    public PushManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        p.a().a(context);
        LocalAliasTagsManager.getInstance(context).init();
    }

    private void delLocalTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            checkParam(str);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            delLocalTags(arrayList);
        }
    }

    public static PushManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (sPushClient == null) {
                synchronized (SLOCK) {
                    if (sPushClient == null) {
                        sPushClient = new PushManager(context.getApplicationContext());
                    }
                }
            }
            return sPushClient;
        }
        return (PushManager) invokeL.objValue;
    }

    private void setLocalTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            checkParam(str);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            setLocalTags(arrayList);
        }
    }

    private void stopWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            p.a().j();
        }
    }

    public void bindAlias(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, iPushActionListener) == null) {
            checkParam(str);
            p.a().a(str, iPushActionListener);
        }
    }

    public void checkManifest() throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p.a().b();
        }
    }

    public void checkParam(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && str == null) {
            throw new RuntimeException("PushManager String param should not be " + str);
        }
    }

    public void delLocalAlias() {
        String localAlias;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (localAlias = LocalAliasTagsManager.getInstance(p.a().h()).getLocalAlias()) == null) {
            return;
        }
        LocalAliasTagsManager.getInstance(p.a().h()).delLocalAlias(localAlias);
    }

    public void delLocalTags(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            checkParam(arrayList);
            LocalAliasTagsManager.getInstance(p.a().h()).delLocalTags(arrayList);
        }
    }

    public void delTopic(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            checkParam(str2);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str2);
            p.a().b(str, arrayList);
        }
    }

    public void disableNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p.a().n();
        }
    }

    public void enableNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            p.a().m();
        }
    }

    public String getClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? com.vivo.push.util.y.b(p.a().h()).a("com.vivo.pushservice.client_id", null) : (String) invokeV.objValue;
    }

    public Map<String, String> getDebugInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? p.a().s() : (Map) invokeV.objValue;
    }

    public String getRegId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? p.a().f() : (String) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "2.5.3" : (String) invokeV.objValue;
    }

    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p.a().i();
        }
    }

    public boolean isEnableNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? p.a().p() : invokeV.booleanValue;
    }

    public boolean isEnablePush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? ClientConfigManagerImpl.getInstance(p.a().h()).isEnablePush() : invokeV.booleanValue;
    }

    public boolean isPushProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? com.vivo.push.util.z.a(p.a().h()) : invokeV.booleanValue;
    }

    public void killPush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            p.a().q();
        }
    }

    public boolean reportData(Context context, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            com.vivo.push.util.p.d("PushManager", "report message: " + j2 + ", reportType: " + j3);
            if (j3 <= 0) {
                return false;
            }
            com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(j3);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(j2));
            aaVar.a(hashMap);
            p.a().a(aaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && com.vivo.push.util.p.a()) {
            p.a().a(-1);
        }
    }

    public void setDebugMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            p.a().b(z);
        }
    }

    public void setLocalAlias(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            checkParam(str);
            LocalAliasTagsManager.getInstance(p.a().h()).setLocalAlias(str);
        }
    }

    public void setLocalTags(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) {
            checkParam(arrayList);
            LocalAliasTagsManager.getInstance(p.a().h()).setLocalTags(arrayList);
        }
    }

    public void setMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            p.a().b(i2);
        }
    }

    public void setNotifyStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            p.a().c(i2);
        }
    }

    public void setSystemModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            p.a().a(z);
        }
    }

    public void setTopic(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, str, str2) == null) {
            checkParam(str2);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str2);
            p.a().a(str, arrayList);
        }
    }

    public void showDebugInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            p.a().o();
        }
    }

    public void turnOffPush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            turnOffPush(null);
        }
    }

    public void turnOnPush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            turnOnPush(null);
        }
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, iPushActionListener) == null) {
            checkParam(str);
            p.a().b(str, iPushActionListener);
        }
    }

    public void checkParam(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            boolean z = list != null && list.size() > 0;
            if (z) {
                for (String str : list) {
                    if (str == null) {
                        z = false;
                    }
                }
            }
            if (z) {
                return;
            }
            throw new IllegalArgumentException("PushManager param should not be " + list);
        }
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, iPushActionListener) == null) {
            p.a().b(iPushActionListener);
        }
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, iPushActionListener) == null) {
            p.a().a(iPushActionListener);
        }
    }

    public void reset(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && com.vivo.push.util.p.a()) {
            p.a().a(i2);
        }
    }

    public void delTopic(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            checkParam(arrayList);
            p.a().b("1", arrayList);
        }
    }

    public void setTopic(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, arrayList) == null) {
            checkParam(arrayList);
            p.a().a("1", arrayList);
        }
    }

    public void delTopic(String str, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, arrayList) == null) {
            checkParam(arrayList);
            p.a().b(str, arrayList);
        }
    }

    public void setTopic(String str, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, arrayList) == null) {
            checkParam(arrayList);
            p.a().a(str, arrayList);
        }
    }
}
