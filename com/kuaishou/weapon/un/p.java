package com.kuaishou.weapon.un;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f55238b;

    /* renamed from: c  reason: collision with root package name */
    public String f55239c;

    /* renamed from: d  reason: collision with root package name */
    public String f55240d;

    /* renamed from: e  reason: collision with root package name */
    public String f55241e;

    /* renamed from: f  reason: collision with root package name */
    public Context f55242f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f55243g;

    /* renamed from: h  reason: collision with root package name */
    public String f55244h;

    /* renamed from: i  reason: collision with root package name */
    public String f55245i;

    /* renamed from: j  reason: collision with root package name */
    public String f55246j;
    public String k;
    public ActivityInfo[] l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public List<r> r;
    public PackageInfo s;
    public long t;
    public int u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;

    public p() {
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
        this.y = -1;
    }

    public p(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.y = -1;
        this.a = i2;
        this.f55240d = str;
        this.f55241e = str2;
    }

    public p(PackageInfo packageInfo, int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageInfo, Integer.valueOf(i2), str, str2, str3, str4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.y = -1;
        this.s = packageInfo;
        this.a = i2;
        this.f55239c = str;
        this.f55240d = str2;
        this.f55245i = str3;
        this.f55246j = str4;
    }

    public p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.y = -1;
        this.f55240d = str;
        this.f55241e = str2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && p.class == obj.getClass()) {
                String str = this.f55239c;
                String str2 = ((p) obj).f55239c;
                if (str == null) {
                    if (str2 != null) {
                        return false;
                    }
                } else if (!str.equals(str2)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.f55239c;
            return (str == null ? 0 : str.hashCode()) + 31;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return "WeaponApkInfo [key=" + this.a + ", apkInitStatus=" + this.f55238b + ", apkPackageName=" + this.f55239c + ", apkVersionName=" + this.f55240d + ", apkPkgPath=" + this.f55241e + ", apkHostContext=" + this.f55242f + ", classLoader=" + this.f55243g + ", apkLibPath=" + this.f55244h + ", apkDownloadURL=" + this.f55245i + ", apkMD5=" + this.f55246j + ", apkSignMD5=" + this.k + ", activities=" + Arrays.toString(this.l) + ", dataDir=" + this.m + ", apkDexPath=" + this.n + ", apkClassName=" + this.o + ", apkParseSuc=" + this.p + ", apkApplicationTheme=" + this.q + ", apkIntentFilters=" + this.r + ", apkCloudPkgInfo=" + this.s + ", apkStartTime=" + this.t + ", duration=" + this.u + ", network=" + this.v + ", apkIsOnce=" + this.w + ", apkRunStatus=" + this.x + PreferencesUtil.RIGHT_MOUNT;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
