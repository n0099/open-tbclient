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
/* loaded from: classes8.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f827a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f828a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, Map<String, String>> f829a;

    public r(Context context) {
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
        this.f827a = context;
        this.f828a = new Handler(Looper.getMainLooper());
        this.f829a = new HashMap();
    }

    public static r a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (r.class) {
                    if (a == null) {
                        a = new r(context);
                    }
                }
            }
            return a;
        }
        return (r) invokeL.objValue;
    }

    private synchronized String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            synchronized (this) {
                if (this.f829a != null && !TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Map<String, String> map = this.f829a.get(str);
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
                if (this.f829a == null) {
                    this.f829a = new HashMap();
                }
                Map<String, String> map = this.f829a.get(str);
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(str2, str3);
                this.f829a.put(str, map);
            }
        }
    }

    public synchronized String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            synchronized (this) {
                String a2 = a(str, str2);
                return !TextUtils.isEmpty(a2) ? a2 : this.f827a.getSharedPreferences(str, 4).getString(str2, str3);
            }
        }
        return (String) invokeLLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m570a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            synchronized (this) {
                b(str, str2, str3);
                this.f828a.post(new s(this, str, str2, str3));
            }
        }
    }
}
