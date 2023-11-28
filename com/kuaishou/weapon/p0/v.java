package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class v {
    public static /* synthetic */ Interceptable $ic = null;
    public static JSONObject h = null;
    public static final String i = "1";
    public static final String j = "2";
    public static final String k = "3";
    public static final String l = "4";
    public static final String m = "5";
    public static final String n = "6";
    public static final String o = "7";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public long c;
    public String d;
    public String e;
    public String f;
    public int g;
    public PackageInfo p;
    public ApplicationInfo q;
    public Context r;

    public v(ApplicationInfo applicationInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {applicationInfo, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = applicationInfo;
        this.r = context;
    }

    public v(PackageInfo packageInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageInfo, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = packageInfo;
        this.r = context;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.a = i2;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.g = i2;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.d = str;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.b = j2;
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.c = j2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f = str;
        }
    }

    public void h() {
        String str;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.p == null && this.q == null) {
                return;
            }
            try {
                if (this.p == null && this.q != null) {
                    this.p = this.r.getPackageManager().getPackageInfo(this.q.packageName, 0);
                }
            } catch (Exception unused) {
            }
            PackageInfo packageInfo = this.p;
            if (packageInfo == null) {
                str = this.q.packageName;
            } else {
                str = packageInfo.packageName;
            }
            a(str);
            PackageInfo packageInfo2 = this.p;
            if (packageInfo2 == null) {
                applicationInfo = this.q;
            } else {
                applicationInfo = packageInfo2.applicationInfo;
            }
            a(applicationInfo.flags & 1);
            b(j());
            PackageInfo packageInfo3 = this.p;
            if (packageInfo3 != null) {
                a(packageInfo3.firstInstallTime);
                b(this.p.lastUpdateTime);
                c(this.p.versionName);
                b(this.p.versionCode);
            }
        }
    }

    public void i() {
        String str;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.p == null && this.q == null) {
                return;
            }
            try {
                if (this.p == null && this.q != null) {
                    this.p = this.r.getPackageManager().getPackageInfo(this.q.packageName, 0);
                }
            } catch (Exception unused) {
            }
            PackageInfo packageInfo = this.p;
            if (packageInfo == null) {
                str = this.q.packageName;
            } else {
                str = packageInfo.packageName;
            }
            a(str);
            PackageInfo packageInfo2 = this.p;
            if (packageInfo2 == null) {
                applicationInfo = this.q;
            } else {
                applicationInfo = packageInfo2.applicationInfo;
            }
            a(applicationInfo.flags & 1);
            PackageInfo packageInfo3 = this.p;
            if (packageInfo3 != null) {
                a(packageInfo3.firstInstallTime);
                b(this.p.lastUpdateTime);
                c(this.p.versionName);
                b(this.p.versionCode);
            }
        }
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                if (this.p != null && this.p.applicationInfo != null) {
                    String charSequence = this.p.applicationInfo.loadLabel(this.r.getPackageManager()).toString();
                    if (!TextUtils.isEmpty(charSequence)) {
                        return charSequence;
                    }
                    return "";
                } else if (this.q != null) {
                    String charSequence2 = this.q.loadLabel(this.r.getPackageManager()).toString();
                    if (!TextUtils.isEmpty(charSequence2)) {
                        return charSequence2;
                    }
                    return "";
                } else {
                    return "";
                }
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", c());
                jSONObject.put("2", b());
                jSONObject.put("3", e());
                jSONObject.put("4", g());
                jSONObject.put("5", a());
                jSONObject.put("6", d());
                jSONObject.put("7", f());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
