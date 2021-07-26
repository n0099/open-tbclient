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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static h f39234a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile WeakReference<SharedPreferences> f39235b;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39235b = null;
    }

    public static synchronized h a() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (h.class) {
                if (f39234a == null) {
                    f39234a = new h();
                }
                hVar = f39234a;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    public String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.f39235b == null || this.f39235b.get() == null) {
                this.f39235b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
            }
            try {
                String host = new URL(str).getHost();
                if (host == null) {
                    SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                    return str;
                }
                String string = this.f39235b.get().getString(host, null);
                if (string != null && !host.equals(string)) {
                    String replace = str.replace(host, string);
                    SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                    return replace;
                }
                SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
                return str;
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e2.getMessage());
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }
}
