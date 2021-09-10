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
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f76666a;

    /* renamed from: b  reason: collision with root package name */
    public String f76667b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f76668c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f76669d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Long> f76670e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Integer> f76671f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Boolean> f76672g;

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
        this.f76669d = new HashMap<>();
        this.f76670e = new HashMap<>();
        this.f76671f = new HashMap<>();
        this.f76672g = new HashMap<>();
    }

    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            if (context instanceof Application) {
                if (!TextUtils.isEmpty(str)) {
                    this.f76667b = str;
                    this.f76668c = context.getSharedPreferences(str, 0);
                    this.f76666a = context;
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
            Integer num = this.f76671f.get(str);
            if (num != null) {
                return num.intValue();
            }
            b();
            if (this.f76668c != null) {
                num = Integer.valueOf(this.f76668c.getInt(str, 0));
                if (!num.equals(0)) {
                    this.f76671f.put(str, num);
                }
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f76670e.remove(str);
            this.f76671f.remove(str);
            this.f76672g.remove(str);
            this.f76669d.remove(str);
            b();
            if (this.f76668c != null) {
                SharedPreferences.Editor edit = this.f76668c.edit();
                if (this.f76668c.contains(str)) {
                    edit.remove(str);
                    a(edit);
                }
            }
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.f76669d.put(str, str2);
            b();
            if (this.f76668c != null) {
                SharedPreferences.Editor edit = this.f76668c.edit();
                edit.putString(str, str2);
                a(edit);
            }
        }
    }

    public final long b(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j2)) == null) {
            Long l = this.f76670e.get(str);
            if (l != null) {
                return l.longValue();
            }
            b();
            if (this.f76668c != null) {
                l = Long.valueOf(this.f76668c.getLong(str, j2));
                if (!l.equals(Long.valueOf(j2))) {
                    this.f76670e.put(str, l);
                }
            }
            return l.longValue();
        }
        return invokeLJ.longValue;
    }

    public final void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            this.f76671f.put(str, Integer.valueOf(i2));
            b();
            if (this.f76668c != null) {
                SharedPreferences.Editor edit = this.f76668c.edit();
                edit.putInt(str, i2);
                a(edit);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f76668c == null) {
            Context context = this.f76666a;
            if (context != null) {
                this.f76668c = context.getSharedPreferences(this.f76667b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j2) == null) {
            this.f76670e.put(str, Long.valueOf(j2));
            b();
            if (this.f76668c != null) {
                SharedPreferences.Editor edit = this.f76668c.edit();
                edit.putLong(str, j2);
                a(edit);
            }
        }
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = this.f76669d.get(str);
            if (str2 != null) {
                return str2;
            }
            b();
            if (this.f76668c != null) {
                str2 = this.f76668c.getString(str, null);
                if (!TextUtils.isEmpty(str2) && !str2.equals(null)) {
                    this.f76669d.put(str, str2);
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
            this.f76670e.clear();
            this.f76671f.clear();
            this.f76672g.clear();
            this.f76669d.clear();
            b();
            if (this.f76668c != null) {
                SharedPreferences.Editor edit = this.f76668c.edit();
                edit.clear();
                a(edit);
            }
        }
    }
}
