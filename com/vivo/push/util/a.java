package com.vivo.push.util;

import android.app.Application;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f63115b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f63116c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f63117d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f63118e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f63119f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f63120g;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63117d = new HashMap<>();
        this.f63118e = new HashMap<>();
        this.f63119f = new HashMap<>();
        this.f63120g = new HashMap<>();
    }

    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            if (context instanceof Application) {
                if (!TextUtils.isEmpty(str)) {
                    this.f63115b = str;
                    this.f63116c = context.getSharedPreferences(str, 0);
                    this.a = context;
                    return;
                }
                throw new RuntimeException("sharedFileName can't be null");
            }
            throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
        }
    }

    public final int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Integer num = this.f63119f.get(str);
            if (num != null) {
                return num.intValue();
            }
            b();
            if (this.f63116c != null) {
                num = Integer.valueOf(this.f63116c.getInt(str, 0));
                if (!num.equals(0)) {
                    this.f63119f.put(str, num);
                }
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f63118e.remove(str);
            this.f63119f.remove(str);
            this.f63120g.remove(str);
            this.f63117d.remove(str);
            b();
            if (this.f63116c != null) {
                SharedPreferences.Editor edit = this.f63116c.edit();
                if (this.f63116c.contains(str)) {
                    edit.remove(str);
                    a(edit);
                }
            }
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.f63117d.put(str, str2);
            b();
            if (this.f63116c != null) {
                SharedPreferences.Editor edit = this.f63116c.edit();
                edit.putString(str, str2);
                a(edit);
            }
        }
    }

    public final long b(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j2)) == null) {
            Long l = this.f63118e.get(str);
            if (l != null) {
                return l.longValue();
            }
            b();
            if (this.f63116c != null) {
                l = Long.valueOf(this.f63116c.getLong(str, j2));
                if (!l.equals(Long.valueOf(j2))) {
                    this.f63118e.put(str, l);
                }
            }
            return l.longValue();
        }
        return invokeLJ.longValue;
    }

    public final void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            this.f63119f.put(str, Integer.valueOf(i2));
            b();
            if (this.f63116c != null) {
                SharedPreferences.Editor edit = this.f63116c.edit();
                edit.putInt(str, i2);
                a(edit);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f63116c == null) {
            Context context = this.a;
            if (context != null) {
                this.f63116c = context.getSharedPreferences(this.f63115b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j2) == null) {
            this.f63118e.put(str, Long.valueOf(j2));
            b();
            if (this.f63116c != null) {
                SharedPreferences.Editor edit = this.f63116c.edit();
                edit.putLong(str, j2);
                a(edit);
            }
        }
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = this.f63117d.get(str);
            if (str2 != null) {
                return str2;
            }
            b();
            if (this.f63116c != null) {
                str2 = this.f63116c.getString(str, null);
                if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                    this.f63117d.put(str, str2);
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
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
            this.f63118e.clear();
            this.f63119f.clear();
            this.f63120g.clear();
            this.f63117d.clear();
            b();
            if (this.f63116c != null) {
                SharedPreferences.Editor edit = this.f63116c.edit();
                edit.clear();
                a(edit);
            }
        }
    }
}
