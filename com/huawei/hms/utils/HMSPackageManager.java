package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class HMSPackageManager {
    public static /* synthetic */ Interceptable $ic;
    public static HMSPackageManager l;
    public static final Object m;
    public static final Object n;
    public static final Object o;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final PackageManagerHelper b;
    public String c;
    public String d;
    public int e;
    public String f;
    public String g;
    public String h;
    public int i;
    public int j;
    public long k;

    public String getInnerServiceAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "com.huawei.hms.core.internal" : (String) invokeV.objValue;
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HMSPackageManager a;

        public a(HMSPackageManager hMSPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hMSPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hMSPackageManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
                for (ResolveInfo resolveInfo : this.a.a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128)) {
                    if ("com.huawei.hwid".equals(resolveInfo.serviceInfo.applicationInfo.packageName)) {
                        this.a.c();
                    }
                }
                HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements Comparable<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public Long f;

        public b(String str, String str2, String str3, String str4, String str5, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, str5, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = Long.valueOf(j);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                if (TextUtils.equals(this.e, bVar.e)) {
                    return this.f.compareTo(bVar.f);
                }
                return this.e.compareTo(bVar.e);
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-888548461, "Lcom/huawei/hms/utils/HMSPackageManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-888548461, "Lcom/huawei/hms/utils/HMSPackageManager;");
                return;
            }
        }
        m = new Object();
        n = new Object();
        o = new Object();
    }

    public String getHMSPackageNameForMultiService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
            refreshForMultiService();
            String str = this.f;
            if (str != null) {
                if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                    HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                    j();
                }
                String str2 = this.f;
                if (str2 != null) {
                    return str2;
                }
                return "com.huawei.hwid";
            }
            return "com.huawei.hwid";
        }
        return (String) invokeV.objValue;
    }

    public HMSPackageManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = new PackageManagerHelper(context);
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return "SPOOFED";
            }
            if (i == 2) {
                return "SUCCESS";
            }
            if (i == 3) {
                return "UNCHECKED";
            }
            HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i);
            return "";
        }
        return (String) invokeI.objValue;
    }

    public static HMSPackageManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (m) {
                if (l == null) {
                    if (context.getApplicationContext() != null) {
                        l = new HMSPackageManager(context.getApplicationContext());
                    } else {
                        l = new HMSPackageManager(context);
                    }
                    l.j();
                    l.a();
                }
            }
            return l;
        }
        return (HMSPackageManager) invokeL.objValue;
    }

    public boolean isApkNeedUpdate(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            int hmsVersionCode = getHmsVersionCode();
            HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i);
            if (hmsVersionCode < i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isApkUpdateNecessary(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            int hmsVersionCode = getHmsVersionCode();
            HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i);
            if (k() && hmsVersionCode < i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean hmsVerHigherThan(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (this.e >= i || !k()) {
                return true;
            }
            int packageVersionCode = this.b.getPackageVersionCode(getHMSPackageName());
            this.e = packageVersionCode;
            if (packageVersionCode >= i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final String a(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, str)) == null) {
            if (!bundle.containsKey(str)) {
                HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
                return null;
            }
            return bundle.getString(str);
        }
        return (String) invokeLL.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int indexOf = str.indexOf("priority=");
            if (indexOf == -1) {
                HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
                return null;
            }
            int indexOf2 = str.indexOf(",", indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.length();
            }
            return str.substring(indexOf, indexOf2);
        }
        return (String) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new Thread(new a(this), "Thread-asyncOnceCheckMDMState").start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (n) {
                this.f = null;
                this.g = null;
                this.h = null;
                this.i = 0;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (n) {
                this.c = null;
                this.d = null;
                this.e = 0;
            }
        }
    }

    public String getHMSFingerprint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String str = this.d;
            if (str == null) {
                return "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int getHmsMultiServiceVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
        }
        return invokeV.intValue;
    }

    public int getHmsVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b.getPackageVersionCode(getHMSPackageName());
        }
        return invokeV.intValue;
    }

    public String getServiceAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!TextUtils.isEmpty(this.h)) {
                return this.h;
            }
            return "com.huawei.hms.core.aidlservice";
        }
        return (String) invokeV.objValue;
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
                i();
            }
        }
    }

    public void refreshForMultiService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) {
                j();
            }
        }
    }

    public void resetMultiServiceState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            d();
        }
    }

    public final boolean a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                List<X509Certificate> b2 = com.huawei.hms.device.a.b(str3);
                if (b2.size() == 0) {
                    HMSLog.e("HMSPackageManager", "certChain is empty");
                    return false;
                } else if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.a), b2)) {
                    HMSLog.e("HMSPackageManager", "failed to verify cert chain");
                    return false;
                } else {
                    X509Certificate x509Certificate = b2.get(b2.size() - 1);
                    if (!com.huawei.hms.device.a.a(x509Certificate, "Huawei CBG HMS")) {
                        HMSLog.e("HMSPackageManager", "CN is invalid");
                        return false;
                    } else if (!com.huawei.hms.device.a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                        HMSLog.e("HMSPackageManager", "OU is invalid");
                        return false;
                    } else if (com.huawei.hms.device.a.a(x509Certificate, str, str2)) {
                        return true;
                    } else {
                        HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
                        return false;
                    }
                }
            }
            HMSLog.e("HMSPackageManager", "args is invalid");
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String a2 = a(str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            a2.substring(9);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String hmsPath = ReadApkFileUtil.getHmsPath(this.a);
            if (hmsPath == null) {
                HMSLog.i("HMSPackageManager", "hmsPath is null!");
                return false;
            } else if (!ReadApkFileUtil.isCertFound(hmsPath)) {
                HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
                return false;
            } else if (!ReadApkFileUtil.checkSignature()) {
                HMSLog.i("HMSPackageManager", "checkSignature fail!");
                return false;
            } else if (!ReadApkFileUtil.verifyApkHash(hmsPath)) {
                HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public String getHMSPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
            refresh();
            String str = this.c;
            if (str != null) {
                if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                    HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                    i();
                }
                String str2 = this.c;
                if (str2 != null) {
                    return str2;
                }
            }
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates("com.huawei.hwid")) || "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(this.b.getPackageSignature("com.huawei.hwid"))) {
            }
            return "com.huawei.hwid";
        }
        return (String) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            synchronized (n) {
                Pair<String, String> f = f();
                if (f == null) {
                    HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                    e();
                    return;
                }
                this.c = (String) f.first;
                this.d = (String) f.second;
                this.e = this.b.getPackageVersionCode(getHMSPackageName());
                HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.c + " version: " + this.e);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (n) {
                Pair<String, String> g = g();
                if (g == null) {
                    HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                    d();
                    return;
                }
                this.f = (String) g.first;
                this.g = (String) g.second;
                this.i = this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
                HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f + " version: " + this.i);
            }
        }
    }

    public final int c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (o) {
                HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");
                long packageFirstInstallTime = this.b.getPackageFirstInstallTime("com.huawei.hwid");
                int i = 1;
                if (this.j != 3 && this.k == packageFirstInstallTime) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + a(this.j));
                    return this.j;
                }
                if (b()) {
                    i = 2;
                }
                this.j = i;
                this.k = this.b.getPackageFirstInstallTime("com.huawei.hwid");
                HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof state: " + a(this.j));
                return this.j;
            }
        }
        return invokeV.intValue;
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (m) {
                refresh();
                PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.c);
                if (packageStates == PackageManagerHelper.PackageStates.NOT_INSTALLED) {
                    e();
                    return PackageManagerHelper.PackageStates.NOT_INSTALLED;
                }
                boolean z2 = false;
                if ("com.huawei.hwid".equals(this.c) && c() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return PackageManagerHelper.PackageStates.SPOOF;
                }
                if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !this.d.equals(this.b.getPackageSignature(this.c))) {
                    z2 = true;
                }
                if (z2) {
                    return PackageManagerHelper.PackageStates.NOT_INSTALLED;
                }
                return packageStates;
            }
        }
        return (PackageManagerHelper.PackageStates) invokeV.objValue;
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            synchronized (m) {
                refreshForMultiService();
                PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.f);
                if (packageStates == PackageManagerHelper.PackageStates.NOT_INSTALLED) {
                    d();
                    return PackageManagerHelper.PackageStates.NOT_INSTALLED;
                }
                boolean z2 = false;
                if ("com.huawei.hwid".equals(this.f) && c() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return PackageManagerHelper.PackageStates.SPOOF;
                }
                if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !this.g.equals(this.b.getPackageSignature(this.f))) {
                    z2 = true;
                }
                if (z2) {
                    return PackageManagerHelper.PackageStates.NOT_INSTALLED;
                }
                return packageStates;
            }
        }
        return (PackageManagerHelper.PackageStates) invokeV.objValue;
    }

    public final Pair<String, String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (queryIntentServices.size() == 0) {
                return null;
            }
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                String str = serviceInfo.applicationInfo.packageName;
                Bundle bundle = serviceInfo.metaData;
                if (bundle == null) {
                    HMSLog.e("HMSPackageManager", "skip package " + str + " for metadata is null");
                } else if (!bundle.containsKey("hms_app_signer")) {
                    HMSLog.e("HMSPackageManager", "skip package " + str + " for no signer");
                } else if (!bundle.containsKey("hms_app_cert_chain")) {
                    HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
                } else {
                    String packageSignature = this.b.getPackageSignature(str);
                    if (!a(str + "&" + packageSignature, bundle.getString("hms_app_signer"), bundle.getString("hms_app_cert_chain"))) {
                        HMSLog.e("HMSPackageManager", "checkSigner failed");
                    } else {
                        return new Pair<>(str, packageSignature);
                    }
                }
            }
            return null;
        }
        return (Pair) invokeV.objValue;
    }

    public final ArrayList<b> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ArrayList<b> arrayList = new ArrayList<>();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                    long packageFirstInstallTime = this.b.getPackageFirstInstallTime(str);
                    Bundle bundle = resolveInfo.serviceInfo.metaData;
                    if (bundle == null) {
                        HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
                    } else {
                        String a2 = a(bundle, "hms_app_checker_config");
                        String a3 = a(a2);
                        if (TextUtils.isEmpty(a3)) {
                            HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + a2);
                        } else {
                            String a4 = a(bundle, "hms_app_signer_v2");
                            if (TextUtils.isEmpty(a4)) {
                                HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                            } else {
                                String a5 = a(bundle, "hms_app_cert_chain");
                                if (TextUtils.isEmpty(a5)) {
                                    HMSLog.i("HMSPackageManager", "get certChain fail.");
                                } else {
                                    HMSLog.i("HMSPackageManager", "add: " + str + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + a2 + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + packageFirstInstallTime);
                                    arrayList.add(new b(str, a2, a4, a5, a3, packageFirstInstallTime));
                                }
                            }
                        }
                    }
                }
                Collections.sort(arrayList);
                return arrayList;
            }
            HMSLog.e("HMSPackageManager", "resolveInfoList is null or empty");
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final Pair<String, String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Pair<String, String> f = f();
            if (f != null) {
                HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) f.first));
                this.h = "com.huawei.hms.core.aidlservice";
                return f;
            }
            ArrayList<b> h = h();
            if (h == null) {
                HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
                return null;
            }
            Iterator<b> it = h.iterator();
            while (it.hasNext()) {
                b next = it.next();
                String str = next.a;
                String str2 = next.b;
                String str3 = next.c;
                String str4 = next.d;
                String packageSignature = this.b.getPackageSignature(str);
                if (a(str + "&" + packageSignature + "&" + str2, str3, str4)) {
                    HMSLog.i("HMSPackageManager", "result: " + str + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + next.f);
                    this.h = PackageConstants.GENERAL_SERVICES_ACTION;
                    b(str2);
                    return new Pair<>(str, packageSignature);
                }
            }
            return null;
        }
        return (Pair) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null) {
                HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
                return true;
            }
            try {
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
            } catch (RuntimeException e) {
                HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e);
            }
            if (!TextUtils.isEmpty(this.h) && (this.h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.h.equals("com.huawei.hms.core.internal"))) {
                HMSLog.i("HMSPackageManager", "action = " + this.h + " exist");
                return false;
            }
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
            if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
                HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
