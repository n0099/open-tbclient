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

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f42778a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f79a;

    /* renamed from: a  reason: collision with other field name */
    public a f80a;

    /* renamed from: a  reason: collision with other field name */
    public String f81a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, a> f82a;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42779a;

        /* renamed from: a  reason: collision with other field name */
        public Context f83a;

        /* renamed from: a  reason: collision with other field name */
        public String f84a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f85a;

        /* renamed from: b  reason: collision with root package name */
        public String f42780b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f86b;

        /* renamed from: c  reason: collision with root package name */
        public String f42781c;

        /* renamed from: d  reason: collision with root package name */
        public String f42782d;

        /* renamed from: e  reason: collision with root package name */
        public String f42783e;

        /* renamed from: f  reason: collision with root package name */
        public String f42784f;

        /* renamed from: g  reason: collision with root package name */
        public String f42785g;

        /* renamed from: h  reason: collision with root package name */
        public String f42786h;

        public a(Context context) {
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
            this.f85a = true;
            this.f86b = false;
            this.f42779a = 1;
            this.f83a = context;
        }

        public static a a(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = new a(context);
                    aVar.f84a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    aVar.f42780b = jSONObject.getString("appToken");
                    aVar.f42781c = jSONObject.getString("regId");
                    aVar.f42782d = jSONObject.getString("regSec");
                    aVar.f42784f = jSONObject.getString("devId");
                    aVar.f42783e = jSONObject.getString("vName");
                    aVar.f85a = jSONObject.getBoolean("valid");
                    aVar.f86b = jSONObject.getBoolean("paused");
                    aVar.f42779a = jSONObject.getInt("envType");
                    aVar.f42785g = jSONObject.getString("regResource");
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
                Context context = this.f83a;
                return com.xiaomi.push.g.m338a(context, context.getPackageName());
            }
            return (String) invokeV.objValue;
        }

        public static String a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f84a);
                    jSONObject.put("appToken", aVar.f42780b);
                    jSONObject.put("regId", aVar.f42781c);
                    jSONObject.put("regSec", aVar.f42782d);
                    jSONObject.put("devId", aVar.f42784f);
                    jSONObject.put("vName", aVar.f42783e);
                    jSONObject.put("valid", aVar.f85a);
                    jSONObject.put("paused", aVar.f86b);
                    jSONObject.put("envType", aVar.f42779a);
                    jSONObject.put("regResource", aVar.f42785g);
                    return jSONObject.toString();
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m124a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a(this.f83a).edit().clear().commit();
                this.f84a = null;
                this.f42780b = null;
                this.f42781c = null;
                this.f42782d = null;
                this.f42784f = null;
                this.f42783e = null;
                this.f85a = false;
                this.f86b = false;
                this.f42786h = null;
                this.f42779a = 1;
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f42779a = i2;
            }
        }

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                this.f42781c = str;
                this.f42782d = str2;
                this.f42784f = com.xiaomi.push.i.l(this.f83a);
                this.f42783e = a();
                this.f85a = true;
            }
        }

        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f84a = str;
                this.f42780b = str2;
                this.f42785g = str3;
                SharedPreferences.Editor edit = b.a(this.f83a).edit();
                edit.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f84a);
                edit.putString("appToken", str2);
                edit.putString("regResource", str3);
                edit.commit();
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.f86b = z;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m125a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? m126a(this.f84a, this.f42780b) : invokeV.booleanValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m126a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                boolean equals = TextUtils.equals(this.f84a, str);
                boolean equals2 = TextUtils.equals(this.f42780b, str2);
                boolean z = !TextUtils.isEmpty(this.f42781c);
                boolean z2 = !TextUtils.isEmpty(this.f42782d);
                boolean z3 = TextUtils.equals(this.f42784f, com.xiaomi.push.i.l(this.f83a)) || TextUtils.equals(this.f42784f, com.xiaomi.push.i.k(this.f83a));
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
                this.f85a = false;
                b.a(this.f83a).edit().putBoolean("valid", this.f85a).commit();
            }
        }

        public void b(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
                this.f42781c = str;
                this.f42782d = str2;
                this.f42784f = com.xiaomi.push.i.l(this.f83a);
                this.f42783e = a();
                this.f85a = true;
                this.f42786h = str3;
                SharedPreferences.Editor edit = b.a(this.f83a).edit();
                edit.putString("regId", str);
                edit.putString("regSec", str2);
                edit.putString("devId", this.f42784f);
                edit.putString("vName", a());
                edit.putBoolean("valid", true);
                edit.putString("appRegion", str3);
                edit.commit();
            }
        }

        public void c(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) {
                this.f84a = str;
                this.f42780b = str2;
                this.f42785g = str3;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f79a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? context.getSharedPreferences("mipush", 0) : (SharedPreferences) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m111a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f42778a == null) {
                synchronized (b.class) {
                    if (f42778a == null) {
                        f42778a = new b(context);
                    }
                }
            }
            return f42778a;
        }
        return (b) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f80a = new a(this.f79a);
            this.f82a = new HashMap();
            SharedPreferences a2 = a(this.f79a);
            this.f80a.f84a = a2.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, null);
            this.f80a.f42780b = a2.getString("appToken", null);
            this.f80a.f42781c = a2.getString("regId", null);
            this.f80a.f42782d = a2.getString("regSec", null);
            this.f80a.f42784f = a2.getString("devId", null);
            if (!TextUtils.isEmpty(this.f80a.f42784f) && com.xiaomi.push.i.m438a(this.f80a.f42784f)) {
                this.f80a.f42784f = com.xiaomi.push.i.l(this.f79a);
                a2.edit().putString("devId", this.f80a.f42784f).commit();
            }
            this.f80a.f42783e = a2.getString("vName", null);
            this.f80a.f85a = a2.getBoolean("valid", true);
            this.f80a.f86b = a2.getBoolean("paused", false);
            this.f80a.f42779a = a2.getInt("envType", 1);
            this.f80a.f42785g = a2.getString("regResource", null);
            this.f80a.f42786h = a2.getString("appRegion", null);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f80a.f42779a : invokeV.intValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f82a.containsKey(str)) {
                return this.f82a.get(str);
            }
            String str2 = "hybrid_app_info_" + str;
            SharedPreferences a2 = a(this.f79a);
            if (a2.contains(str2)) {
                a a3 = a.a(this.f79a, a2.getString(str2, ""));
                this.f82a.put(str2, a3);
                return a3;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m112a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f80a.f84a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m113a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f80a.m124a();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f80a.a(i2);
            a(this.f79a).edit().putInt("envType", i2).commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m114a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SharedPreferences.Editor edit = a(this.f79a).edit();
            edit.putString("vName", str);
            edit.commit();
            this.f80a.f42783e = str;
        }
    }

    public void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            this.f82a.put(str, aVar);
            String a2 = a.a(aVar);
            a(this.f79a).edit().putString("hybrid_app_info_" + str, a2).commit();
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            this.f80a.a(str, str2, str3);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f80a.a(z);
            a(this.f79a).edit().putBoolean("paused", z).commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m115a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = this.f79a;
            return !TextUtils.equals(com.xiaomi.push.g.m338a(context, context.getPackageName()), this.f80a.f42783e);
        }
        return invokeV.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) ? this.f80a.m126a(str, str2) : invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m116a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, str2, str3)) == null) {
            a a2 = a(str3);
            return a2 != null && TextUtils.equals(str, a2.f84a) && TextUtils.equals(str2, a2.f42780b);
        }
        return invokeLLL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f80a.f42780b : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m117b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f80a.b();
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f82a.remove(str);
            a(this.f79a).edit().remove("hybrid_app_info_" + str).commit();
        }
    }

    public void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, str2, str3) == null) {
            this.f80a.b(str, str2, str3);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m118b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f80a.m125a()) {
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.m70a("Don't send message before initialization succeeded!");
            return false;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m119c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f80a.f42781c : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m120c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f80a.m125a() : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f80a.f42782d : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m121d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (TextUtils.isEmpty(this.f80a.f84a) || TextUtils.isEmpty(this.f80a.f42780b) || TextUtils.isEmpty(this.f80a.f42781c) || TextUtils.isEmpty(this.f80a.f42782d)) ? false : true : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f80a.f42785g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m122e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f80a.f86b : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f80a.f42786h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m123f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? !this.f80a.f85a : invokeV.booleanValue;
    }
}
