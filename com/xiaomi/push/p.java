package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile p f40537a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f821a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f822a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, Map<String, String>> f823a;

    public p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f821a = context;
        this.f822a = new Handler(Looper.getMainLooper());
        this.f823a = new HashMap();
    }

    public static p a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f40537a == null) {
                synchronized (p.class) {
                    if (f40537a == null) {
                        f40537a = new p(context);
                    }
                }
            }
            return f40537a;
        }
        return (p) invokeL.objValue;
    }

    private synchronized String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            synchronized (this) {
                if (this.f823a != null && !TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Map<String, String> map = this.f823a.get(str);
                            return map != null ? map.get(str2) : "";
                        } catch (Throwable unused) {
                            return "";
                        }
                    }
                }
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    private synchronized void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, str3) == null) {
            synchronized (this) {
                if (this.f823a == null) {
                    this.f823a = new HashMap();
                }
                Map<String, String> map = this.f823a.get(str);
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(str2, str3);
                this.f823a.put(str, map);
            }
        }
    }

    public synchronized String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            synchronized (this) {
                String a2 = a(str, str2);
                return !TextUtils.isEmpty(a2) ? a2 : this.f821a.getSharedPreferences(str, 4).getString(str2, str3);
            }
        }
        return (String) invokeLLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m540a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            synchronized (this) {
                b(str, str2, str3);
                this.f822a.post(new q(this, str, str2, str3));
            }
        }
    }
}
