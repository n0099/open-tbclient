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
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PushClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_REQUEST_ID = "1";
    public static final Object SLOCK;
    public static volatile PushClient sPushClient;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-121776150, "Lcom/vivo/push/PushClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-121776150, "Lcom/vivo/push/PushClient;");
                return;
            }
        }
        SLOCK = new Object();
    }

    public PushClient(Context context) {
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
    }

    private void checkParam(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, str) == null) && str == null) {
            throw new IllegalArgumentException("PushManager String param should not be " + str);
        }
    }

    public static PushClient getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (sPushClient == null) {
                synchronized (SLOCK) {
                    if (sPushClient == null) {
                        sPushClient = new PushClient(context.getApplicationContext());
                    }
                }
            }
            return sPushClient;
        }
        return (PushClient) invokeL.objValue;
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

    public void delTopic(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, iPushActionListener) == null) {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            p.a().b(arrayList, iPushActionListener);
        }
    }

    public String getAlias() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? p.a().l() : (String) invokeV.objValue;
    }

    public String getRegId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? p.a().f() : (String) invokeV.objValue;
    }

    public List<String> getTopics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? p.a().c() : (List) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "2.5.3" : (String) invokeV.objValue;
    }

    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            p.a().i();
        }
    }

    public boolean isSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? p.a().d() : invokeV.booleanValue;
    }

    public void setSystemModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            p.a().a(z);
        }
    }

    public void setTopic(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, iPushActionListener) == null) {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            p.a().a(arrayList, iPushActionListener);
        }
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iPushActionListener) == null) {
            p.a().b(iPushActionListener);
        }
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iPushActionListener) == null) {
            p.a().a(iPushActionListener);
        }
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, iPushActionListener) == null) {
            checkParam(str);
            p.a().b(str, iPushActionListener);
        }
    }
}
