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
/* loaded from: classes9.dex */
public class w {
    public static /* synthetic */ Interceptable $ic = null;
    public static JSONObject k = null;
    public static final String l = "1";
    public static final String m = "2";
    public static final String n = "3";
    public static final String o = "4";
    public static final String p = "5";
    public static final String q = "6";
    public static final String r = "7";
    public transient /* synthetic */ FieldHolder $fh;
    public PackageInfo a;
    public ApplicationInfo b;
    public Context c;
    public int d;
    public long e;
    public long f;
    public String g;
    public String h;
    public String i;
    public int j;

    public w(ApplicationInfo applicationInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {applicationInfo, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = applicationInfo;
        this.c = context;
    }

    public w(PackageInfo packageInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageInfo, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = packageInfo;
        this.c = context;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", c());
                jSONObject.put("2", g());
                jSONObject.put("3", h());
                jSONObject.put("4", i());
                jSONObject.put("5", e());
                jSONObject.put("6", d());
                jSONObject.put("7", f());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.d = i;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.e = j;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.i = str;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.a != null && this.a.applicationInfo != null) {
                    String charSequence = this.a.applicationInfo.loadLabel(this.c.getPackageManager()).toString();
                    return !TextUtils.isEmpty(charSequence) ? charSequence : "";
                } else if (this.b != null) {
                    String charSequence2 = this.b.loadLabel(this.c.getPackageManager()).toString();
                    return !TextUtils.isEmpty(charSequence2) ? charSequence2 : "";
                } else {
                    return "";
                }
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.j = i;
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f = j;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.h = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.g = str;
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : invokeV.longValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : invokeV.intValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f : invokeV.longValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : invokeV.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.a == null && this.b == null) {
                return;
            }
            try {
                if (this.a == null && this.b != null) {
                    this.a = this.c.getPackageManager().getPackageInfo(this.b.packageName, 0);
                }
            } catch (Exception unused) {
            }
            PackageInfo packageInfo = this.a;
            b(packageInfo == null ? this.b.packageName : packageInfo.packageName);
            PackageInfo packageInfo2 = this.a;
            a((packageInfo2 == null ? this.b : packageInfo2.applicationInfo).flags & 1);
            a(b());
            PackageInfo packageInfo3 = this.a;
            if (packageInfo3 != null) {
                a(packageInfo3.firstInstallTime);
                b(this.a.lastUpdateTime);
                c(this.a.versionName);
                b(this.a.versionCode);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.a == null && this.b == null) {
                return;
            }
            try {
                if (this.a == null && this.b != null) {
                    this.a = this.c.getPackageManager().getPackageInfo(this.b.packageName, 0);
                }
            } catch (Exception unused) {
            }
            PackageInfo packageInfo = this.a;
            b(packageInfo == null ? this.b.packageName : packageInfo.packageName);
            PackageInfo packageInfo2 = this.a;
            a((packageInfo2 == null ? this.b : packageInfo2.applicationInfo).flags & 1);
            PackageInfo packageInfo3 = this.a;
            if (packageInfo3 != null) {
                a(packageInfo3.firstInstallTime);
                b(this.a.lastUpdateTime);
                c(this.a.versionName);
                b(this.a.versionCode);
            }
        }
    }
}
