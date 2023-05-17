package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public volatile SharedPreferences c;
    public HashMap<String, String> d;
    public HashMap<String, Long> e;
    public HashMap<String, Integer> f;
    public HashMap<String, Boolean> g;

    public c() {
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
        this.d = new HashMap<>();
        this.e = new HashMap<>();
        this.f = new HashMap<>();
        this.g = new HashMap<>();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.d.clear();
            b();
            if (this.c != null) {
                SharedPreferences.Editor edit = this.c.edit();
                edit.clear();
                a(edit);
            }
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, editor) != null) || editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    private void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, map) == null) && map.size() > 0) {
            b();
            if (this.c != null) {
                SharedPreferences.Editor edit = this.c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.c == null) {
            Context context = this.a;
            if (context != null) {
                this.c = context.getSharedPreferences(this.b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    private List<String> d(String str) {
        InterceptResult invokeL;
        Object a;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (this.a == null) {
                u.c("BaseSharePreference", " parsLocalIv error mContext is null ");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                a = ag.a(this.a, this.a.getPackageName(), str);
            } catch (Exception e) {
                u.c("BaseSharePreference", " parsLocalIv error e =" + e.getMessage());
                e.printStackTrace();
            }
            if (a == null) {
                return null;
            }
            String str2 = new String(Base64.decode(a.toString(), 2));
            if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
                for (String str3 : split) {
                    arrayList.add(str3.replace(",#@", ""));
                }
                if (arrayList.size() >= 4) {
                    return arrayList;
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                this.c = context.getSharedPreferences(str, 0);
                this.a = context;
                List<String> d = d("local_iv");
                if (d != null && d.size() >= 4) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("com.vivo.push.secure_sub_iv", d.get(1));
                    hashMap.put("com.vivo.push.secure_sub_key", d.get(2));
                    hashMap.put("com.vivo.push.secure_cache_iv", d.get(3));
                    hashMap.put("com.vivo.push.secure_cache_key", d.get(0));
                    a(hashMap);
                    return;
                }
                u.a("BaseSharePreference", " initSecureCode error list is null ");
                return;
            }
            throw new RuntimeException("sharedFileName can't be null");
        }
    }

    public final void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            this.f.put(str, Integer.valueOf(i));
            b();
            if (this.c != null) {
                SharedPreferences.Editor edit = this.c.edit();
                edit.putInt(str, i);
                a(edit);
            }
        }
    }

    public final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            this.e.put(str, Long.valueOf(j));
            b();
            if (this.c != null) {
                SharedPreferences.Editor edit = this.c.edit();
                edit.putLong(str, j);
                a(edit);
            }
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.d.put(str, str2);
            b();
            if (this.c != null) {
                SharedPreferences.Editor edit = this.c.edit();
                edit.putString(str, str2);
                a(edit);
            }
        }
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Boolean bool = this.g.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            b();
            Boolean bool2 = Boolean.TRUE;
            if (this.c != null && (bool2 = Boolean.valueOf(this.c.getBoolean(str, true))) != null && !bool2.equals(Boolean.TRUE)) {
                this.g.put(str, bool2);
            }
            return bool2.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Integer num = this.f.get(str);
            if (num != null) {
                return num.intValue();
            }
            b();
            if (this.c != null) {
                num = Integer.valueOf(this.c.getInt(str, 0));
                if (!num.equals(0)) {
                    this.f.put(str, num);
                }
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.e.remove(str);
            this.f.remove(str);
            this.g.remove(str);
            this.d.remove(str);
            b();
            if (this.c != null) {
                SharedPreferences.Editor edit = this.c.edit();
                if (this.c.contains(str)) {
                    edit.remove(str);
                    a(edit);
                }
            }
        }
    }

    public final long b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j)) == null) {
            Long l = this.e.get(str);
            if (l != null) {
                return l.longValue();
            }
            b();
            if (this.c != null) {
                l = Long.valueOf(this.c.getLong(str, j));
                if (!l.equals(Long.valueOf(j))) {
                    this.e.put(str, l);
                }
            }
            return l.longValue();
        }
        return invokeLJ.longValue;
    }

    public final String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String str3 = this.d.get(str);
            if (str3 != null) {
                return str3;
            }
            b();
            if (this.c != null) {
                str3 = this.c.getString(str, str2);
                if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                    this.d.put(str, str3);
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }
}
