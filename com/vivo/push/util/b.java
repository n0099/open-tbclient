package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f43938b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f43939c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f43940d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f43941e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f43942f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f43943g;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43940d = new HashMap<>();
        this.f43941e = new HashMap<>();
        this.f43942f = new HashMap<>();
        this.f43943g = new HashMap<>();
    }

    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.f43938b = str;
                this.f43939c = context.getSharedPreferences(str, 0);
                this.a = context;
                HashMap hashMap = new HashMap();
                hashMap.put("com.vivo.push.secure_sub_iv", "34,32,33,37,33,34,32,33,33,33,34,41,35,35,32,32");
                hashMap.put("com.vivo.push.secure_sub_key", "33,34,35,36,37,38,39,40,41,32,38,37,33,35,34,33");
                hashMap.put("com.vivo.push.secure_cache_iv", "34,32,33,37,33,34,32,33,33,33,34,41,35,32,32,32");
                hashMap.put("com.vivo.push.secure_cache_key", "33,34,35,36,37,38,39,40,41,32,38,37,36,35,34,33");
                a(hashMap);
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
    }

    public final String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            String str3 = this.f43940d.get(str);
            if (str3 != null) {
                return str3;
            }
            b();
            if (this.f43939c != null) {
                str3 = this.f43939c.getString(str, str2);
                if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                    this.f43940d.put(str, str3);
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final long b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            Long l = this.f43941e.get(str);
            if (l != null) {
                return l.longValue();
            }
            b();
            if (this.f43939c != null) {
                l = Long.valueOf(this.f43939c.getLong(str, j));
                if (!l.equals(Long.valueOf(j))) {
                    this.f43941e.put(str, l);
                }
            }
            return l.longValue();
        }
        return invokeLJ.longValue;
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.f43940d.put(str, str2);
            b();
            if (this.f43939c != null) {
                SharedPreferences.Editor edit = this.f43939c.edit();
                edit.putString(str, str2);
                a(edit);
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f43941e.remove(str);
            this.f43942f.remove(str);
            this.f43943g.remove(str);
            this.f43940d.remove(str);
            b();
            if (this.f43939c != null) {
                SharedPreferences.Editor edit = this.f43939c.edit();
                if (this.f43939c.contains(str)) {
                    edit.remove(str);
                    a(edit);
                }
            }
        }
    }

    private void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, map) == null) || map.size() <= 0) {
            return;
        }
        b();
        if (this.f43939c != null) {
            SharedPreferences.Editor edit = this.f43939c.edit();
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                this.f43940d.put(str, str2);
                edit.putString(str, str2);
            }
            a(edit);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f43939c == null) {
            Context context = this.a;
            if (context != null) {
                this.f43939c = context.getSharedPreferences(this.f43938b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            this.f43942f.put(str, Integer.valueOf(i));
            b();
            if (this.f43939c != null) {
                SharedPreferences.Editor edit = this.f43939c.edit();
                edit.putInt(str, i);
                a(edit);
            }
        }
    }

    public final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) {
            this.f43941e.put(str, Long.valueOf(j));
            b();
            if (this.f43939c != null) {
                SharedPreferences.Editor edit = this.f43939c.edit();
                edit.putLong(str, j);
                a(edit);
            }
        }
    }

    public final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Integer num = this.f43942f.get(str);
            if (num != null) {
                return num.intValue();
            }
            b();
            if (this.f43939c != null) {
                num = Integer.valueOf(this.f43939c.getInt(str, 0));
                if (!num.equals(0)) {
                    this.f43942f.put(str, num);
                }
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public static void a(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, editor) == null) || editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f43941e.clear();
            this.f43942f.clear();
            this.f43943g.clear();
            this.f43940d.clear();
            b();
            if (this.f43939c != null) {
                SharedPreferences.Editor edit = this.f43939c.edit();
                edit.clear();
                a(edit);
            }
        }
    }
}
