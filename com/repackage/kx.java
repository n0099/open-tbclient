package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class kx {
    public static /* synthetic */ Interceptable $ic;
    public static kx b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964035016, "Lcom/repackage/kx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964035016, "Lcom/repackage/kx;");
                return;
            }
        }
        b = new kx();
    }

    public kx() {
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
        this.a = new HashMap();
    }

    public static kx b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : (kx) invokeV.objValue;
    }

    public void a(int i, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, onRequestPermissionsResultCallback) == null) || this.a == null) {
            return;
        }
        synchronized (kx.class) {
            if (this.a.containsKey(Integer.valueOf(i))) {
                this.a.remove(Integer.valueOf(i));
            }
            this.a.put(Integer.valueOf(i), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.a;
            if (map == null || !map.containsKey(Integer.valueOf(i))) {
                return null;
            }
            return this.a.get(Integer.valueOf(i));
        }
        return (ActivityCompat.OnRequestPermissionsResultCallback) invokeI.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            synchronized (kx.class) {
                if (this.a != null && this.a.containsKey(Integer.valueOf(i))) {
                    this.a.remove(Integer.valueOf(i));
                }
            }
        }
    }
}
