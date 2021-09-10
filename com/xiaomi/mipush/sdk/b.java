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
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f77296a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f83a;

    /* renamed from: a  reason: collision with other field name */
    public a f84a;

    /* renamed from: a  reason: collision with other field name */
    public String f85a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, a> f86a;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77297a;

        /* renamed from: a  reason: collision with other field name */
        public Context f87a;

        /* renamed from: a  reason: collision with other field name */
        public String f88a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f89a;

        /* renamed from: b  reason: collision with root package name */
        public String f77298b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f90b;

        /* renamed from: c  reason: collision with root package name */
        public String f77299c;

        /* renamed from: d  reason: collision with root package name */
        public String f77300d;

        /* renamed from: e  reason: collision with root package name */
        public String f77301e;

        /* renamed from: f  reason: collision with root package name */
        public String f77302f;

        /* renamed from: g  reason: collision with root package name */
        public String f77303g;

        /* renamed from: h  reason: collision with root package name */
        public String f77304h;

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
            this.f89a = true;
            this.f90b = false;
            this.f77297a = 1;
            this.f87a = context;
        }

        public static a a(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = new a(context);
                    aVar.f88a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    aVar.f77298b = jSONObject.getString("appToken");
                    aVar.f77299c = jSONObject.getString("regId");
                    aVar.f77300d = jSONObject.getString("regSec");
                    aVar.f77302f = jSONObject.getString("devId");
                    aVar.f77301e = jSONObject.getString("vName");
                    aVar.f89a = jSONObject.getBoolean("valid");
                    aVar.f90b = jSONObject.getBoolean("paused");
                    aVar.f77297a = jSONObject.getInt("envType");
                    aVar.f77303g = jSONObject.getString("regResource");
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
                Context context = this.f87a;
                return com.xiaomi.push.g.m341a(context, context.getPackageName());
            }
            return (String) invokeV.objValue;
        }

        public static String a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f88a);
                    jSONObject.put("appToken", aVar.f77298b);
                    jSONObject.put("regId", aVar.f77299c);
                    jSONObject.put("regSec", aVar.f77300d);
                    jSONObject.put("devId", aVar.f77302f);
                    jSONObject.put("vName", aVar.f77301e);
                    jSONObject.put("valid", aVar.f89a);
                    jSONObject.put("paused", aVar.f90b);
                    jSONObject.put("envType", aVar.f77297a);
                    jSONObject.put("regResource", aVar.f77303g);
                    return jSONObject.toString();
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m127a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a(this.f87a).edit().clear().commit();
                this.f88a = null;
                this.f77298b = null;
                this.f77299c = null;
                this.f77300d = null;
                this.f77302f = null;
                this.f77301e = null;
                this.f89a = false;
                this.f90b = false;
                this.f77304h = null;
                this.f77297a = 1;
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f77297a = i2;
            }
        }

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                this.f77299c = str;
                this.f77300d = str2;
                this.f77302f = com.xiaomi.push.i.l(this.f87a);
                this.f77301e = a();
                this.f89a = true;
            }
        }

        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f88a = str;
                this.f77298b = str2;
                this.f77303g = str3;
                SharedPreferences.Editor edit = b.a(this.f87a).edit();
                edit.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f88a);
                edit.putString("appToken", str2);
                edit.putString("regResource", str3);
                edit.commit();
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.f90b = z;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m128a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? m129a(this.f88a, this.f77298b) : invokeV.booleanValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m129a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                boolean equals = TextUtils.equals(this.f88a, str);
                boolean equals2 = TextUtils.equals(this.f77298b, str2);
                boolean z = !TextUtils.isEmpty(this.f77299c);
                boolean z2 = !TextUtils.isEmpty(this.f77300d);
                boolean z3 = TextUtils.equals(this.f77302f, com.xiaomi.push.i.l(this.f87a)) || TextUtils.equals(this.f77302f, com.xiaomi.push.i.k(this.f87a));
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
                this.f89a = false;
                b.a(this.f87a).edit().putBoolean("valid", this.f89a).commit();
            }
        }

        public void b(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
                this.f77299c = str;
                this.f77300d = str2;
                this.f77302f = com.xiaomi.push.i.l(this.f87a);
                this.f77301e = a();
                this.f89a = true;
                this.f77304h = str3;
                SharedPreferences.Editor edit = b.a(this.f87a).edit();
                edit.putString("regId", str);
                edit.putString("regSec", str2);
                edit.putString("devId", this.f77302f);
                edit.putString("vName", a());
                edit.putBoolean("valid", true);
                edit.putString("appRegion", str3);
                edit.commit();
            }
        }

        public void c(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) {
                this.f88a = str;
                this.f77298b = str2;
                this.f77303g = str3;
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
        this.f83a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? context.getSharedPreferences("mipush", 0) : (SharedPreferences) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m114a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f77296a == null) {
                synchronized (b.class) {
                    if (f77296a == null) {
                        f77296a = new b(context);
                    }
                }
            }
            return f77296a;
        }
        return (b) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f84a = new a(this.f83a);
            this.f86a = new HashMap();
            SharedPreferences a2 = a(this.f83a);
            this.f84a.f88a = a2.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, null);
            this.f84a.f77298b = a2.getString("appToken", null);
            this.f84a.f77299c = a2.getString("regId", null);
            this.f84a.f77300d = a2.getString("regSec", null);
            this.f84a.f77302f = a2.getString("devId", null);
            if (!TextUtils.isEmpty(this.f84a.f77302f) && com.xiaomi.push.i.m441a(this.f84a.f77302f)) {
                this.f84a.f77302f = com.xiaomi.push.i.l(this.f83a);
                a2.edit().putString("devId", this.f84a.f77302f).commit();
            }
            this.f84a.f77301e = a2.getString("vName", null);
            this.f84a.f89a = a2.getBoolean("valid", true);
            this.f84a.f90b = a2.getBoolean("paused", false);
            this.f84a.f77297a = a2.getInt("envType", 1);
            this.f84a.f77303g = a2.getString("regResource", null);
            this.f84a.f77304h = a2.getString("appRegion", null);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f84a.f77297a : invokeV.intValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f86a.containsKey(str)) {
                return this.f86a.get(str);
            }
            String str2 = "hybrid_app_info_" + str;
            SharedPreferences a2 = a(this.f83a);
            if (a2.contains(str2)) {
                a a3 = a.a(this.f83a, a2.getString(str2, ""));
                this.f86a.put(str2, a3);
                return a3;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m115a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f84a.f88a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m116a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f84a.m127a();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f84a.a(i2);
            a(this.f83a).edit().putInt("envType", i2).commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m117a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SharedPreferences.Editor edit = a(this.f83a).edit();
            edit.putString("vName", str);
            edit.commit();
            this.f84a.f77301e = str;
        }
    }

    public void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            this.f86a.put(str, aVar);
            String a2 = a.a(aVar);
            a(this.f83a).edit().putString("hybrid_app_info_" + str, a2).commit();
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            this.f84a.a(str, str2, str3);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f84a.a(z);
            a(this.f83a).edit().putBoolean("paused", z).commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m118a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = this.f83a;
            return !TextUtils.equals(com.xiaomi.push.g.m341a(context, context.getPackageName()), this.f84a.f77301e);
        }
        return invokeV.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) ? this.f84a.m129a(str, str2) : invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m119a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, str2, str3)) == null) {
            a a2 = a(str3);
            return a2 != null && TextUtils.equals(str, a2.f88a) && TextUtils.equals(str2, a2.f77298b);
        }
        return invokeLLL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f84a.f77298b : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m120b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f84a.b();
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f86a.remove(str);
            a(this.f83a).edit().remove("hybrid_app_info_" + str).commit();
        }
    }

    public void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, str2, str3) == null) {
            this.f84a.b(str, str2, str3);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m121b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f84a.m128a()) {
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("Don't send message before initialization succeeded!");
            return false;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m122c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f84a.f77299c : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m123c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f84a.m128a() : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f84a.f77300d : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m124d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (TextUtils.isEmpty(this.f84a.f88a) || TextUtils.isEmpty(this.f84a.f77298b) || TextUtils.isEmpty(this.f84a.f77299c) || TextUtils.isEmpty(this.f84a.f77300d)) ? false : true : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f84a.f77303g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m125e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f84a.f90b : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f84a.f77304h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m126f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? !this.f84a.f89a : invokeV.booleanValue;
    }
}
