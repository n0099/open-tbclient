package com.fun.ad.sdk.internal.api.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.j1b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.BuildConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.j0;
import com.fun.openid.sdk.FunOpenIDSdk;
import com.fun.openid.sdk.OnGetOaidListener;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class HostAppInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT = "content";
    public static final String KEY = "key";
    public static final String OCCUR_T = "occur_t";
    public static final String RETRY_I = "retry_i";
    public static volatile long a;
    public static volatile HostAppInfo b;
    public static final Object c;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public String e;
    public String f;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(166778178, "Lcom/fun/ad/sdk/internal/api/utils/HostAppInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(166778178, "Lcom/fun/ad/sdk/internal/api/utils/HostAppInfo;");
                return;
            }
        }
        c = new Object();
    }

    public HostAppInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = String.valueOf(-1);
        this.g = -1;
    }

    public static HostAppInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                LogPrinter.e("HostAppInfo should be initialized in async thread", new Object[0]);
                if (FunAdSdk.isLogEnabled()) {
                    throw new RuntimeException("HostAppInfo should be initialized in async thread");
                }
            }
            if (b == null) {
                synchronized (HostAppInfo.class) {
                    if (b == null) {
                        b = new HostAppInfo();
                        Context appContext = FunAdSdk.getAppContext();
                        b.t = FunAdSdk.getFunAdConfig().userId;
                        b.s = FunAdSdk.getFunAdConfig().appId;
                        b.r = appContext.getResources().getConfiguration().locale.getLanguage();
                        b.p = FunOpenIDSdk.getAndroidId(appContext);
                        b.a(appContext);
                        b.b();
                        String imei = FunOpenIDSdk.getImei(appContext);
                        if (!TextUtils.isEmpty(imei)) {
                            b.u = FunOpenIDSdk.getMD5(imei);
                        }
                        String imeiNew = FunOpenIDSdk.getImeiNew(appContext);
                        if (!TextUtils.isEmpty(imeiNew)) {
                            b.v = FunOpenIDSdk.getMD5(imeiNew);
                        }
                        FunOpenIDSdk.getOaid(appContext, new OnGetOaidListener() { // from class: com.baidu.tieba.i1b
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.fun.openid.sdk.OnGetOaidListener
                            public final void onGetOaid(String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                    HostAppInfo.a(str);
                                }
                            }
                        });
                        if (FunAdSdk.isLogEnabled()) {
                            LogPrinter.d(b.toString(), new Object[0]);
                        }
                        Object obj = c;
                        synchronized (obj) {
                            new Thread(new Runnable(appContext) { // from class: com.fun.ad.sdk.internal.api.utils.HostAppInfo.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Context a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {appContext};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = appContext;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        try {
                                            HostAppInfo.b.x = AdvertisingIdClient.getAdvertisingIdInfo(this.a).getId();
                                        } catch (Exception e) {
                                            HostAppInfo.b.x = null;
                                            LogPrinter.e(e);
                                        }
                                        String str = HostAppInfo.KEY;
                                        Object obj2 = HostAppInfo.c;
                                        synchronized (obj2) {
                                            obj2.notify();
                                        }
                                    }
                                }
                            }).start();
                            try {
                                obj.wait(2000L);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
            return b;
        }
        return (HostAppInfo) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(NetworkInfo networkInfo) {
        String str;
        if (networkInfo == null) {
            this.h = "unknown";
            return;
        }
        if (networkInfo.isConnectedOrConnecting()) {
            String subtypeName = networkInfo.getSubtypeName();
            if (!TextUtils.isEmpty(subtypeName)) {
                this.h = subtypeName;
                return;
            }
            str = networkInfo.getTypeName();
        } else {
            str = DownloadStatisticConstants.UBC_VALUE_UNKNOW;
        }
        this.h = str;
    }

    public static /* synthetic */ void a(String str) {
        b.q = str;
        LogPrinter.d("Got oaid:%s", str);
    }

    public static JSONObject buildBaseJson(String str, JSONObject jSONObject, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, jSONObject, Long.valueOf(j)})) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", str);
                jSONObject2.put("content", jSONObject);
                jSONObject2.put(OCCUR_T, j);
                jSONObject2.put(RETRY_I, 0);
            } catch (JSONException unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject buildReportJson(String str, JSONObject jSONObject, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, jSONObject, Long.valueOf(j)})) == null) {
            JSONObject buildBaseJson = buildBaseJson(str, jSONObject, j);
            try {
                fillHostAppInfo(buildBaseJson);
            } catch (JSONException unused) {
            }
            return buildBaseJson;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static HostAppInfo fillHostAppInfo(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            HostAppInfo a2 = a();
            jSONObject.put("app", a2.d);
            jSONObject.put("appv", a2.f);
            jSONObject.put("appvn", a2.e);
            jSONObject.put("net", a2.h);
            jSONObject.put("manu", a2.i);
            jSONObject.put("model", a2.j);
            jSONObject.put("sysv", a2.k);
            jSONObject.put("h", a2.l);
            jSONObject.put("w", a2.m);
            jSONObject.put("locale", a2.r);
            jSONObject.put("opcode", a2.n);
            jSONObject.put("tk", a2.o);
            jSONObject.put("sdkvn", getSdkVersion());
            jSONObject.put("sdkv", BuildConfig.VERSION_CODE);
            jSONObject.put("anid", a2.p);
            jSONObject.put("lic", a2.s);
            jSONObject.put("plat", "a");
            jSONObject.put("oaid", a2.q);
            jSONObject.put(DpStatConstants.KEY_USER_ID, a2.t);
            jSONObject.put("iid", a2.u);
            jSONObject.put("iidn", a2.v);
            jSONObject.put("cfgv", a);
            jSONObject.put("brand", a2.w);
            jSONObject.put(Config.GAID, a2.x);
            return a2;
        }
        return (HostAppInfo) invokeL.objValue;
    }

    public static void fillReqParams(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, jSONObject) == null) {
            HostAppInfo fillHostAppInfo = fillHostAppInfo(jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            String mD5String = MD5Utils.getMD5String(fillHostAppInfo.o + fillHostAppInfo.d + fillHostAppInfo.e + fillHostAppInfo.r + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("vc", mD5String);
        }
    }

    public static int getAppVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (b == null) {
                Context appContext = FunAdSdk.getAppContext();
                try {
                    PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                    if (packageInfo != null) {
                        return packageInfo.versionCode;
                    }
                    return -1;
                } catch (PackageManager.NameNotFoundException unused) {
                    return -1;
                }
            }
            return b.g;
        }
        return invokeV.intValue;
    }

    public static String getGaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? b != null ? b.x : "" : (String) invokeV.objValue;
    }

    public static String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? BuildConfig.VERSION_NAME : (String) invokeV.objValue;
    }

    public static int getSdkVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? BuildConfig.VERSION_CODE : invokeV.intValue;
    }

    public static void updateCfgv(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, null, j) == null) {
            a = j;
        }
    }

    public final void a(Context context) {
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PackageManager packageManager = context.getPackageManager();
            this.d = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                this.d = packageInfo.packageName;
                this.e = packageInfo.versionName;
                int i = packageInfo.versionCode;
                this.g = i;
                this.f = String.valueOf(i);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    this.n = networkOperator;
                }
            }
            this.i = Build.MANUFACTURER;
            this.j = Build.MODEL;
            this.w = Build.BRAND;
            this.k = String.valueOf(Build.VERSION.SDK_INT);
            WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (windowManager == null) {
                displayMetrics = context.getResources().getDisplayMetrics();
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                displayMetrics = displayMetrics2;
            }
            this.l = String.valueOf(displayMetrics.heightPixels);
            this.m = String.valueOf(displayMetrics.widthPixels);
            this.o = j1b.c();
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "HostAppInfo{packageName='" + this.d + "', versionName='" + this.e + "', versionCode='" + this.f + "', networkTypeName='" + this.h + "', manufacturer='" + this.i + "', model='" + this.j + "', osVersion='" + this.k + "', h='" + this.l + "', w='" + this.m + "', opcode='" + this.n + "', token='" + this.o + "', anid='" + this.p + "', oaid='" + this.q + "', locale='" + this.r + "', lic='" + this.s + "', userId='" + this.t + "', imei='" + this.u + "', imeiNew='" + this.v + "', cfgv='" + a + "', brand='" + this.w + "', gaid='" + this.x + "'}";
        }
        return (String) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j0.b bVar = new j0.b() { // from class: com.baidu.tieba.h1b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.fun.j0.b
                public final void a(NetworkInfo networkInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, networkInfo) == null) {
                        HostAppInfo.this.a(networkInfo);
                    }
                }
            };
            HashSet<j0.b> hashSet = j0.b;
            synchronized (hashSet) {
                hashSet.add(bVar);
            }
            bVar.a(j0.a);
        }
    }
}
