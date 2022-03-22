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
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f802a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f803a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, Map<String, String>> f804a;

    public p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f802a = context;
        this.f803a = new Handler(Looper.getMainLooper());
        this.f804a = new HashMap();
    }

    public static p a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (p.class) {
                    if (a == null) {
                        a = new p(context);
                    }
                }
            }
            return a;
        }
        return (p) invokeL.objValue;
    }

    private synchronized String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            synchronized (this) {
                if (this.f804a != null && !TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Map<String, String> map = this.f804a.get(str);
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
                if (this.f804a == null) {
                    this.f804a = new HashMap();
                }
                Map<String, String> map = this.f804a.get(str);
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(str2, str3);
                this.f804a.put(str, map);
            }
        }
    }

    public synchronized String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            synchronized (this) {
                String a2 = a(str, str2);
                return !TextUtils.isEmpty(a2) ? a2 : this.f802a.getSharedPreferences(str, 4).getString(str2, str3);
            }
        }
        return (String) invokeLLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m582a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            synchronized (this) {
                b(str, str2, str3);
                this.f803a.post(new q(this, str, str2, str3));
            }
        }
    }
}
