package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static h a;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile WeakReference<SharedPreferences> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2036590862, "Lcom/tencent/open/utils/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2036590862, "Lcom/tencent/open/utils/h;");
        }
    }

    public h() {
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
        this.b = null;
    }

    public static synchronized h a() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
                hVar = a;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    public String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.b == null || this.b.get() == null) {
                this.b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
            }
            try {
                String host = new URL(str).getHost();
                if (host == null) {
                    SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                    return str;
                }
                String string = this.b.get().getString(host, null);
                if (string != null && !host.equals(string)) {
                    String replace = str.replace(host, string);
                    SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                    return replace;
                }
                SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
                return str;
            } catch (Exception e) {
                SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }
}
