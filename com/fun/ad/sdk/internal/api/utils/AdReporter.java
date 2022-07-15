package com.fun.ad.sdk.internal.api.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.SidSessionMeta;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.kuaishou.weapon.p0.C0453;
import com.repackage.gi9;
import com.repackage.md9;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class AdReporter<A> {
    public static /* synthetic */ Interceptable $ic;
    public static final Reporter a;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final String c;
    public final String d;

    /* renamed from: com.fun.ad.sdk.internal.api.utils.AdReporter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends HashMap<String, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ SidSessionMeta b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Object[] e;
        public final /* synthetic */ Object f;
        public final /* synthetic */ AdReporter g;

        /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: com.fun.ad.sdk.internal.api.utils.AdReporter */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(AdReporter adReporter, long j, SidSessionMeta sidSessionMeta, String str, boolean z, Object[] objArr, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {adReporter, Long.valueOf(j), sidSessionMeta, str, Boolean.valueOf(z), objArr, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = adReporter;
            this.a = j;
            this.b = sidSessionMeta;
            this.c = str;
            this.d = z;
            this.e = objArr;
            this.f = obj;
            put("lid", Long.valueOf(j));
            put("slid", Long.valueOf(sidSessionMeta.tId));
            put("sid", sidSessionMeta.sid);
            put("sidv", Integer.valueOf(sidSessionMeta.sidVer));
            put("ssp", adReporter.d);
            put("type", adReporter.c);
            put("aid", adReporter.b);
            put("st", str);
            put("dup", Integer.valueOf(z ? 1 : 0));
            if (objArr != null && objArr.length > 0) {
                if (objArr.length % 2 != 0) {
                    throw new IllegalArgumentException("Length of argument 'appends' must be even.");
                }
                int i3 = 0;
                while (true) {
                    Object[] objArr3 = this.e;
                    if (i3 >= objArr3.length) {
                        break;
                    }
                    put(objArr3[i3].toString(), this.e[i3 + 1]);
                    i3 += 2;
                }
            }
            List<Pair<String, Object>> onReport = this.g.onReport(this.f, this.c);
            if (onReport != null) {
                for (Pair<String, Object> pair : onReport) {
                    put(pair.first, pair.second);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1543495945, "Lcom/fun/ad/sdk/internal/api/utils/AdReporter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1543495945, "Lcom/fun/ad/sdk/internal/api/utils/AdReporter;");
                return;
            }
        }
        a = gi9.a();
    }

    public AdReporter(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final void a(A a2, String str, long j, SidSessionMeta sidSessionMeta, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{a2, str, Long.valueOf(j), sidSessionMeta, objArr}) == null) {
            a.logEvent(LaunchStatsUtils.AD, new AnonymousClass1(this, j, sidSessionMeta, str, false, objArr, a2));
        }
    }

    public List<Pair<String, Object>> onReport(A a2, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, a2, str)) == null) {
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public void recordLoadFailed(Object obj, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{obj, Long.valueOf(j), sidSessionMeta}) == null) {
            a(null, "ld_err", j, sidSessionMeta, NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void recordLoadStart(long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048581, this, j, sidSessionMeta) == null) {
            a(null, "ld_start", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordLoadSucceed(A a2, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "ld_succeed", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordOnClicked(A a2, boolean z, long j, SidSessionMeta sidSessionMeta, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{a2, Boolean.valueOf(z), Long.valueOf(j), sidSessionMeta, strArr}) == null) {
            a(a2, z, "onclick", j, sidSessionMeta, a((strArr == null || strArr.length <= 0) ? "" : strArr[0]));
        }
    }

    public void recordOnClosed(A a2, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "onclosed", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordOnPaidEvent(A a2, long j, SidSessionMeta sidSessionMeta, double d, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta, Double.valueOf(d), str}) == null) {
            a(a2, "paid", j, sidSessionMeta, "rvn", Double.valueOf(d), "cry", str);
        }
    }

    public void recordReward(A a2, boolean z, long j, SidSessionMeta sidSessionMeta, int i, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{a2, Boolean.valueOf(z), Long.valueOf(j), sidSessionMeta, Integer.valueOf(i), strArr}) == null) {
            String str = (strArr == null || strArr.length <= 0) ? "" : strArr[0];
            if (TextUtils.isEmpty(str)) {
                a(a2, "reward", j, sidSessionMeta, "valid", Boolean.valueOf(z), NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i));
            } else {
                a(a2, "reward", j, sidSessionMeta, "valid", Boolean.valueOf(z), "tid", str, NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i));
            }
        }
    }

    public void recordShowFailed(A a2, Object obj, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{a2, obj, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "sh_failed", j, sidSessionMeta, NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void recordShowStart(A a2, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "sh_start", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordShowStart(A a2, boolean z, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{a2, Boolean.valueOf(z), Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, z, "sh_start", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordShowSucceed(A a2, boolean z, long j, SidSessionMeta sidSessionMeta, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{a2, Boolean.valueOf(z), Long.valueOf(j), sidSessionMeta, strArr}) == null) {
            a(a2, z, "sh_succeed", j, sidSessionMeta, a((strArr == null || strArr.length <= 0) ? "" : strArr[0]));
        }
    }

    public void recordWebViewClick(String str, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, Long.valueOf(j), sidSessionMeta}) == null) {
            a(null, "w_jump", j, sidSessionMeta, "j_url", str);
        }
    }

    public final void a(A a2, boolean z, String str, long j, SidSessionMeta sidSessionMeta, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{a2, Boolean.valueOf(z), str, Long.valueOf(j), sidSessionMeta, objArr}) == null) {
            a.logEvent(LaunchStatsUtils.AD, new AnonymousClass1(this, j, sidSessionMeta, str, z, objArr, a2));
        }
    }

    public final Object[] a(String str) {
        InterceptResult invokeL;
        Object[] objArr;
        int i;
        String string;
        boolean z;
        String[] split;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z3 = false;
            if (TextUtils.isEmpty(str)) {
                objArr = new Object[8];
                i = 0;
            } else {
                objArr = new Object[10];
                objArr[0] = "tid";
                i = 2;
                objArr[1] = str;
            }
            int i2 = i + 1;
            objArr[i] = "ab";
            int i3 = i2 + 1;
            Boolean bool = md9.a;
            objArr[i2] = Boolean.valueOf(Settings.Secure.getInt(FunAdSdk.getAppContext().getContentResolver(), "adb_enabled", 0) != 0);
            int i4 = i3 + 1;
            objArr[i3] = "rt";
            int i5 = i4 + 1;
            if (md9.a == null) {
                String str2 = null;
                try {
                    Object invoke = Class.forName("android.os.SystemProperties").getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(null, "ro.secure");
                    if (invoke != null) {
                        str2 = (String) invoke;
                    }
                } catch (Exception unused) {
                }
                if (str2 == null ? true : !"0".equals(str2)) {
                    String str3 = System.getenv("PATH");
                    if (TextUtils.isEmpty(str3)) {
                        split = new String[]{"/sbin", "/system/bin", "/system/xbin", "/data/local/xbin", "/data/local/bin", "/system/sd/xbin", "/system/bin/failsafe", "/data/local"};
                    } else if (!md9.b && str3 == null) {
                        throw new AssertionError();
                    } else {
                        split = str3.split(":");
                    }
                    int length = split.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            z2 = false;
                            break;
                        } else if (new File(split[i6], C0453.f723).exists()) {
                            z2 = true;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (!z2) {
                        z = false;
                        md9.a = Boolean.valueOf(z);
                    }
                }
                z = true;
                md9.a = Boolean.valueOf(z);
            }
            objArr[i4] = Boolean.valueOf(md9.a.booleanValue());
            int i7 = i5 + 1;
            objArr[i5] = "vn";
            int i8 = i7 + 1;
            try {
                z3 = ((ConnectivityManager) FunAdSdk.getAppContext().getSystemService("connectivity")).getNetworkInfo(17).isConnectedOrConnecting();
            } catch (Exception unused2) {
            }
            objArr[i7] = Boolean.valueOf(z3);
            int i9 = i8 + 1;
            objArr[i8] = "ay";
            Context appContext = FunAdSdk.getAppContext();
            ArrayList arrayList = new ArrayList();
            try {
                int i10 = Settings.Secure.getInt(appContext.getApplicationContext().getContentResolver(), "accessibility_enabled");
                TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
                if (i10 == 1 && (string = Settings.Secure.getString(appContext.getApplicationContext().getContentResolver(), "enabled_accessibility_services")) != null) {
                    simpleStringSplitter.setString(string);
                    while (simpleStringSplitter.hasNext()) {
                        arrayList.add(simpleStringSplitter.next());
                    }
                }
            } catch (Exception unused3) {
            }
            objArr[i9] = Boolean.valueOf(!arrayList.isEmpty());
            return objArr;
        }
        return (Object[]) invokeL.objValue;
    }
}
