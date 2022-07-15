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
/* renamed from: com.kuaishou.weapon.p0.ˊ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0406 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static JSONObject f458 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String f459 = "1";

    /* renamed from: ˑ  reason: contains not printable characters */
    public static final String f460 = "2";

    /* renamed from: י  reason: contains not printable characters */
    public static final String f461 = "3";

    /* renamed from: ـ  reason: contains not printable characters */
    public static final String f462 = "4";

    /* renamed from: ٴ  reason: contains not printable characters */
    public static final String f463 = "5";

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static final String f464 = "6";

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static final String f465 = "7";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public PackageInfo f466;

    /* renamed from: ʼ  reason: contains not printable characters */
    public ApplicationInfo f467;

    /* renamed from: ʽ  reason: contains not printable characters */
    public Context f468;

    /* renamed from: ʾ  reason: contains not printable characters */
    public int f469;

    /* renamed from: ʿ  reason: contains not printable characters */
    public long f470;

    /* renamed from: ˆ  reason: contains not printable characters */
    public long f471;

    /* renamed from: ˈ  reason: contains not printable characters */
    public String f472;

    /* renamed from: ˉ  reason: contains not printable characters */
    public String f473;

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f474;

    /* renamed from: ˋ  reason: contains not printable characters */
    public int f475;

    public C0406(ApplicationInfo applicationInfo, Context context) {
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
        this.f467 = applicationInfo;
        this.f468 = context;
    }

    public C0406(PackageInfo packageInfo, Context context) {
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
        this.f466 = packageInfo;
        this.f468 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m553() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", m561());
                jSONObject.put("2", m566());
                jSONObject.put("3", m567());
                jSONObject.put("4", m568());
                jSONObject.put("5", m564());
                jSONObject.put("6", m563());
                jSONObject.put("7", m565());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m554(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f469 = i;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m555(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f470 = j;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m556(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f474 = str;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m557() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.f466 != null && this.f466.applicationInfo != null) {
                    String charSequence = this.f466.applicationInfo.loadLabel(this.f468.getPackageManager()).toString();
                    return !TextUtils.isEmpty(charSequence) ? charSequence : "";
                } else if (this.f467 != null) {
                    String charSequence2 = this.f467.loadLabel(this.f468.getPackageManager()).toString();
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m558(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f475 = i;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m559(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f471 = j;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m560(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f473 = str;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m561() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f474 : (String) invokeV.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m562(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f472 = str;
        }
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public long m563() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f470 : invokeV.longValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public int m564() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f469 : invokeV.intValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public long m565() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f471 : invokeV.longValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public String m566() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f473 : (String) invokeV.objValue;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public String m567() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f472 : (String) invokeV.objValue;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m568() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f475 : invokeV.intValue;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m569() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f466 == null && this.f467 == null) {
                return;
            }
            try {
                if (this.f466 == null && this.f467 != null) {
                    this.f466 = this.f468.getPackageManager().getPackageInfo(this.f467.packageName, 0);
                }
            } catch (Exception unused) {
            }
            PackageInfo packageInfo = this.f466;
            m560(packageInfo == null ? this.f467.packageName : packageInfo.packageName);
            PackageInfo packageInfo2 = this.f466;
            m554((packageInfo2 == null ? this.f467 : packageInfo2.applicationInfo).flags & 1);
            m556(m557());
            PackageInfo packageInfo3 = this.f466;
            if (packageInfo3 != null) {
                m555(packageInfo3.firstInstallTime);
                m559(this.f466.lastUpdateTime);
                m562(this.f466.versionName);
                m558(this.f466.versionCode);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m570() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f466 == null && this.f467 == null) {
                return;
            }
            try {
                if (this.f466 == null && this.f467 != null) {
                    this.f466 = this.f468.getPackageManager().getPackageInfo(this.f467.packageName, 0);
                }
            } catch (Exception unused) {
            }
            PackageInfo packageInfo = this.f466;
            m560(packageInfo == null ? this.f467.packageName : packageInfo.packageName);
            PackageInfo packageInfo2 = this.f466;
            m554((packageInfo2 == null ? this.f467 : packageInfo2.applicationInfo).flags & 1);
            PackageInfo packageInfo3 = this.f466;
            if (packageInfo3 != null) {
                m555(packageInfo3.firstInstallTime);
                m559(this.f466.lastUpdateTime);
                m562(this.f466.versionName);
                m558(this.f466.versionCode);
            }
        }
    }
}
