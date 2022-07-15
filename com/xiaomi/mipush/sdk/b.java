package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f788a;

    /* renamed from: a  reason: collision with other field name */
    public a f789a;

    /* renamed from: a  reason: collision with other field name */
    public String f790a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, a> f791a;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Context f792a;

        /* renamed from: a  reason: collision with other field name */
        public String f793a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f794a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f795b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        public a(Context context) {
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
            this.f794a = true;
            this.f795b = false;
            this.a = 1;
            this.f792a = context;
        }

        public static a a(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = new a(context);
                    aVar.f793a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    aVar.b = jSONObject.getString("appToken");
                    aVar.c = jSONObject.getString("regId");
                    aVar.d = jSONObject.getString("regSec");
                    aVar.f = jSONObject.getString("devId");
                    aVar.e = jSONObject.getString("vName");
                    aVar.f794a = jSONObject.getBoolean("valid");
                    aVar.f795b = jSONObject.getBoolean("paused");
                    aVar.a = jSONObject.getInt("envType");
                    aVar.g = jSONObject.getString("regResource");
                    return aVar;
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                    return null;
                }
            }
            return (a) invokeLL.objValue;
        }

        private String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                Context context = this.f792a;
                return com.xiaomi.push.h.m1322a(context, context.getPackageName());
            }
            return (String) invokeV.objValue;
        }

        public static String a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f793a);
                    jSONObject.put("appToken", aVar.b);
                    jSONObject.put("regId", aVar.c);
                    jSONObject.put("regSec", aVar.d);
                    jSONObject.put("devId", aVar.f);
                    jSONObject.put("vName", aVar.e);
                    jSONObject.put("valid", aVar.f794a);
                    jSONObject.put("paused", aVar.f795b);
                    jSONObject.put("envType", aVar.a);
                    jSONObject.put("regResource", aVar.g);
                    return jSONObject.toString();
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m1082a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a(this.f792a).edit().clear().commit();
                this.f793a = null;
                this.b = null;
                this.c = null;
                this.d = null;
                this.f = null;
                this.e = null;
                this.f794a = false;
                this.f795b = false;
                this.h = null;
                this.a = 1;
            }
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a = i;
            }
        }

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                this.c = str;
                this.d = str2;
                this.f = com.xiaomi.push.j.j(this.f792a);
                this.e = a();
                this.f794a = true;
            }
        }

        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f793a = str;
                this.b = str2;
                this.g = str3;
                SharedPreferences.Editor edit = b.a(this.f792a).edit();
                edit.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f793a);
                edit.putString("appToken", str2);
                edit.putString("regResource", str3);
                edit.commit();
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.f795b = z;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m1083a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? m1084a(this.f793a, this.b) : invokeV.booleanValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m1084a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                boolean equals = TextUtils.equals(this.f793a, str);
                boolean equals2 = TextUtils.equals(this.b, str2);
                boolean z = !TextUtils.isEmpty(this.c);
                boolean z2 = !TextUtils.isEmpty(this.d);
                boolean z3 = TextUtils.equals(this.f, com.xiaomi.push.j.j(this.f792a)) || TextUtils.equals(this.f, com.xiaomi.push.j.i(this.f792a));
                boolean z4 = equals && equals2 && z && z2 && z3;
                if (!z4) {
                    com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
                }
                return z4;
            }
            return invokeLL.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f794a = false;
                b.a(this.f792a).edit().putBoolean("valid", this.f794a).commit();
            }
        }

        public void b(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
                this.c = str;
                this.d = str2;
                this.f = com.xiaomi.push.j.j(this.f792a);
                this.e = a();
                this.f794a = true;
                this.h = str3;
                SharedPreferences.Editor edit = b.a(this.f792a).edit();
                edit.putString("regId", str);
                edit.putString("regSec", str2);
                edit.putString("devId", this.f);
                edit.putString("vName", a());
                edit.putBoolean("valid", true);
                edit.putString("appRegion", str3);
                edit.commit();
            }
        }

        public void c(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) {
                this.f793a = str;
                this.b = str2;
                this.g = str3;
            }
        }
    }

    public b(Context context) {
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
        this.f788a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? context.getSharedPreferences("mipush", 0) : (SharedPreferences) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m1069a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new b(context);
                    }
                }
            }
            return a;
        }
        return (b) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f789a = new a(this.f788a);
            this.f791a = new HashMap();
            SharedPreferences a2 = a(this.f788a);
            this.f789a.f793a = a2.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, null);
            this.f789a.b = a2.getString("appToken", null);
            this.f789a.c = a2.getString("regId", null);
            this.f789a.d = a2.getString("regSec", null);
            this.f789a.f = a2.getString("devId", null);
            if (!TextUtils.isEmpty(this.f789a.f) && com.xiaomi.push.j.a(this.f789a.f)) {
                this.f789a.f = com.xiaomi.push.j.j(this.f788a);
                a2.edit().putString("devId", this.f789a.f).commit();
            }
            this.f789a.e = a2.getString("vName", null);
            this.f789a.f794a = a2.getBoolean("valid", true);
            this.f789a.f795b = a2.getBoolean("paused", false);
            this.f789a.a = a2.getInt("envType", 1);
            this.f789a.g = a2.getString("regResource", null);
            this.f789a.h = a2.getString("appRegion", null);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f789a.a : invokeV.intValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f791a.containsKey(str)) {
                return this.f791a.get(str);
            }
            String str2 = "hybrid_app_info_" + str;
            SharedPreferences a2 = a(this.f788a);
            if (a2.contains(str2)) {
                a a3 = a.a(this.f788a, a2.getString(str2, ""));
                this.f791a.put(str2, a3);
                return a3;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1070a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f789a.f793a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1071a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f789a.m1082a();
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f789a.a(i);
            a(this.f788a).edit().putInt("envType", i).commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1072a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SharedPreferences.Editor edit = a(this.f788a).edit();
            edit.putString("vName", str);
            edit.commit();
            this.f789a.e = str;
        }
    }

    public void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            this.f791a.put(str, aVar);
            String a2 = a.a(aVar);
            a(this.f788a).edit().putString("hybrid_app_info_" + str, a2).commit();
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            this.f789a.a(str, str2, str3);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f789a.a(z);
            a(this.f788a).edit().putBoolean("paused", z).commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1073a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = this.f788a;
            return !TextUtils.equals(com.xiaomi.push.h.m1322a(context, context.getPackageName()), this.f789a.e);
        }
        return invokeV.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) ? this.f789a.m1084a(str, str2) : invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1074a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, str2, str3)) == null) {
            a a2 = a(str3);
            return a2 != null && TextUtils.equals(str, a2.f793a) && TextUtils.equals(str2, a2.b);
        }
        return invokeLLL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f789a.b : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m1075b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f789a.b();
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f791a.remove(str);
            a(this.f788a).edit().remove("hybrid_app_info_" + str).commit();
        }
    }

    public void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, str2, str3) == null) {
            this.f789a.b(str, str2, str3);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1076b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f789a.m1083a()) {
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.m1027a("Don't send message before initialization succeeded!");
            return false;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m1077c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f789a.c : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1078c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f789a.m1083a() : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f789a.d : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m1079d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (TextUtils.isEmpty(this.f789a.f793a) || TextUtils.isEmpty(this.f789a.b) || TextUtils.isEmpty(this.f789a.c) || TextUtils.isEmpty(this.f789a.d)) ? false : true : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f789a.g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m1080e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f789a.f795b : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f789a.h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m1081f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? !this.f789a.f794a : invokeV.booleanValue;
    }
}
