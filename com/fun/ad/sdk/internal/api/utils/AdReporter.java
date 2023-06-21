package com.fun.ad.sdk.internal.api.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tieba.t1b;
import com.baidu.tieba.z1b;
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
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.kuaishou.weapon.p0.i1;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.chromium.base.CommandLineInitUtil;
/* loaded from: classes9.dex */
public class AdReporter<A> {
    public static /* synthetic */ Interceptable $ic;
    public static final Reporter a;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final String c;
    public final String d;

    /* renamed from: com.fun.ad.sdk.internal.api.utils.AdReporter$1  reason: invalid class name */
    /* loaded from: classes9.dex */
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
        a = z1b.a();
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

    public final Object[] a(RippedAd rippedAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd)) == null) ? new Object[]{"corp", rippedAd.corporation, "title", rippedAd.title, "pkg", rippedAd.appPkg} : (Object[]) invokeL.objValue;
    }

    public final Object[] a(Object[]... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Object[] objArr2 : objArr) {
                arrayList.addAll(Arrays.asList(objArr2));
            }
            return arrayList.toArray();
        }
        return (Object[]) invokeL.objValue;
    }

    public List<Pair<String, Object>> onReport(A a2, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, a2, str)) == null) {
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public List<Pair<String, String>> onReward(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, a2)) == null) {
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void recordLoadFailed(A a2, Object obj, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{a2, obj, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "ld_err", j, sidSessionMeta, NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void recordLoadFailed(A a2, Object obj, long j, SidSessionMeta sidSessionMeta, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{a2, obj, Long.valueOf(j), sidSessionMeta, str}) == null) {
            a(a2, "ld_err", j, sidSessionMeta, NotificationCompat.CATEGORY_ERROR, obj, "tid", str);
        }
    }

    public void recordLoadFailed(A a2, Object obj, String str, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{a2, obj, str, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "ld_err", j, sidSessionMeta, NotificationCompat.CATEGORY_ERROR, obj, PmsConstant.Statistic.STATISTIC_ERRMSG, str);
        }
    }

    public void recordLoadStart(long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048586, this, j, sidSessionMeta) == null) {
            a(null, "ld_start", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordLoadStart(long j, SidSessionMeta sidSessionMeta, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), sidSessionMeta, str}) == null) {
            a(null, "ld_start", j, sidSessionMeta, "tid", str);
        }
    }

    public void recordLoadSucceed(A a2, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "ld_succeed", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordLoadSucceed(A a2, long j, SidSessionMeta sidSessionMeta, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta, str}) == null) {
            a(a2, "ld_succeed", j, sidSessionMeta, "tid", str);
        }
    }

    public void recordOnClicked(A a2, boolean z, long j, SidSessionMeta sidSessionMeta, RippedAd rippedAd, String str) {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{a2, Boolean.valueOf(z), Long.valueOf(j), sidSessionMeta, rippedAd, str}) == null) {
            Object[] a3 = a(str);
            if (rippedAd != null) {
                a3 = a(a(rippedAd), a3);
            }
            if (FunAdSdk.getClickTarget() != -1) {
                Object[] a4 = a(a3, new Object[]{"clT", Integer.valueOf(FunAdSdk.getClickTarget())});
                FunAdSdk.setClickTarget(-1);
                objArr = a4;
            } else {
                objArr = a3;
            }
            a(a2, z, "onclick", j, sidSessionMeta, objArr);
        }
    }

    public void recordOnClosed(A a2, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "onclosed", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordOnClosed(A a2, long j, SidSessionMeta sidSessionMeta, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta, str}) == null) {
            a(a2, "onclosed", j, sidSessionMeta, "tid", str);
        }
    }

    public void recordOnPaidEvent(A a2, long j, SidSessionMeta sidSessionMeta, double d, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta, Double.valueOf(d), str, Integer.valueOf(i)}) == null) {
            a(a2, "paid", j, sidSessionMeta, "rvn", Double.valueOf(d), "cry", str, "pcs", Integer.valueOf(i));
        }
    }

    public void recordReward(A a2, boolean z, long j, SidSessionMeta sidSessionMeta, int i, RippedAd rippedAd, String str) {
        Object[] objArr;
        int i2;
        Object[] objArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{a2, Boolean.valueOf(z), Long.valueOf(j), sidSessionMeta, Integer.valueOf(i), rippedAd, str}) == null) {
            if (TextUtils.isEmpty(str)) {
                objArr = new Object[4];
                i2 = 0;
            } else {
                objArr = new Object[6];
                objArr[0] = "tid";
                objArr[1] = str;
                i2 = 2;
            }
            int i3 = i2 + 1;
            objArr[i2] = "valid";
            int i4 = i3 + 1;
            objArr[i3] = Boolean.valueOf(z);
            objArr[i4] = NotificationCompat.CATEGORY_ERROR;
            objArr[i4 + 1] = Integer.valueOf(i);
            if (rippedAd != null) {
                objArr = a(objArr, a(rippedAd));
            }
            List<Pair<String, String>> onReward = onReward(a2);
            if (onReward == null || onReward.isEmpty()) {
                objArr2 = objArr;
            } else {
                Pair<String, String> pair = onReward.get(0);
                objArr2 = a(objArr, new Object[]{pair.first, pair.second});
            }
            a(a2, "reward", j, sidSessionMeta, objArr2);
        }
    }

    public void recordShowFailed(A a2, Object obj, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{a2, obj, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "sh_failed", j, sidSessionMeta, NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void recordShowFailed(A a2, Object obj, long j, SidSessionMeta sidSessionMeta, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{a2, obj, Long.valueOf(j), sidSessionMeta, str}) == null) {
            a(a2, "sh_failed", j, sidSessionMeta, NotificationCompat.CATEGORY_ERROR, obj, "tid", str);
        }
    }

    public void recordShowStart(A a2, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{a2, Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, "sh_start", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordShowStart(A a2, boolean z, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{a2, Boolean.valueOf(z), Long.valueOf(j), sidSessionMeta}) == null) {
            a(a2, z, "sh_start", j, sidSessionMeta, new Object[0]);
        }
    }

    public void recordShowSucceed(A a2, boolean z, long j, SidSessionMeta sidSessionMeta, RippedAd rippedAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{a2, Boolean.valueOf(z), Long.valueOf(j), sidSessionMeta, rippedAd, str}) == null) {
            Object[] a3 = a(str);
            if (rippedAd != null) {
                a3 = a(a(rippedAd), a3);
            }
            a(a2, z, "sh_succeed", j, sidSessionMeta, a3);
        }
    }

    public void recordWebViewClick(String str, long j, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{str, Long.valueOf(j), sidSessionMeta}) == null) {
            a(null, "w_jump", j, sidSessionMeta, "j_url", str);
        }
    }

    public final void a(A a2, String str, long j, SidSessionMeta sidSessionMeta, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{a2, str, Long.valueOf(j), sidSessionMeta, objArr}) == null) {
            a.logEvent("ad", new AnonymousClass1(this, j, sidSessionMeta, str, false, objArr, a2));
        }
    }

    public final void a(A a2, boolean z, String str, long j, SidSessionMeta sidSessionMeta, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{a2, Boolean.valueOf(z), str, Long.valueOf(j), sidSessionMeta, objArr}) == null) {
            a.logEvent("ad", new AnonymousClass1(this, j, sidSessionMeta, str, z, objArr, a2));
        }
    }

    public final Object[] a(String str) {
        InterceptResult invokeL;
        Object[] objArr;
        int i;
        boolean z;
        String string;
        boolean z2;
        boolean z3;
        String[] split;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z5 = false;
            if (!TextUtils.isEmpty(str)) {
                objArr = new Object[10];
                objArr[0] = "tid";
                i = 2;
                objArr[1] = str;
            } else {
                objArr = new Object[8];
                i = 0;
            }
            int i2 = i + 1;
            objArr[i] = DI.AB_NAME;
            int i3 = i2 + 1;
            Boolean bool = t1b.a;
            if (Settings.Secure.getInt(FunAdSdk.getAppContext().getContentResolver(), "adb_enabled", 0) != 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[i2] = Boolean.valueOf(z);
            int i4 = i3 + 1;
            objArr[i3] = "rt";
            int i5 = i4 + 1;
            if (t1b.a == null) {
                String str2 = null;
                try {
                    Object invoke = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(null, "ro.secure");
                    if (invoke != null) {
                        str2 = (String) invoke;
                    }
                } catch (Exception unused) {
                }
                if (str2 == null) {
                    z2 = true;
                } else {
                    z2 = !"0".equals(str2);
                }
                if (z2) {
                    String str3 = System.getenv("PATH");
                    if (TextUtils.isEmpty(str3)) {
                        split = new String[]{"/sbin", "/system/bin", "/system/xbin", "/data/local/xbin", "/data/local/bin", "/system/sd/xbin", "/system/bin/failsafe", CommandLineInitUtil.COMMAND_LINE_FILE_PATH};
                    } else if (!t1b.b && str3 == null) {
                        throw new AssertionError();
                    } else {
                        split = str3.split(":");
                    }
                    int length = split.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 < length) {
                            if (new File(split[i6], i1.w).exists()) {
                                z4 = true;
                                break;
                            }
                            i6++;
                        } else {
                            z4 = false;
                            break;
                        }
                    }
                    if (!z4) {
                        z3 = false;
                        t1b.a = Boolean.valueOf(z3);
                    }
                }
                z3 = true;
                t1b.a = Boolean.valueOf(z3);
            }
            objArr[i4] = Boolean.valueOf(t1b.a.booleanValue());
            int i7 = i5 + 1;
            objArr[i5] = "vn";
            int i8 = i7 + 1;
            try {
                z5 = ((ConnectivityManager) FunAdSdk.getAppContext().getSystemService("connectivity")).getNetworkInfo(17).isConnectedOrConnecting();
            } catch (Exception unused2) {
            }
            objArr[i7] = Boolean.valueOf(z5);
            int i9 = i8 + 1;
            objArr[i8] = "ay";
            Context appContext = FunAdSdk.getAppContext();
            ArrayList arrayList = new ArrayList();
            try {
                int i10 = Settings.Secure.getInt(appContext.getApplicationContext().getContentResolver(), "accessibility_enabled");
                TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
                if (i10 == 1 && (string = ApiReplaceUtil.Overload.getString(appContext.getApplicationContext().getContentResolver(), "enabled_accessibility_services")) != null) {
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
