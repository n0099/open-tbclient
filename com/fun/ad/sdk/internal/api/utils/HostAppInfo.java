package com.fun.ad.sdk.internal.api.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.BuildConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.i0;
import com.fun.openid.sdk.FunOpenIDSdk;
import com.fun.openid.sdk.OnGetOaidListener;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.repackage.ie9;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HostAppInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT = "content";
    public static final String KEY = "key";
    public static final String OCCUR_T = "occur_t";
    public static final String RETRY_I = "retry_i";
    public static volatile long a;
    public static volatile HostAppInfo b;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
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

    public HostAppInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HostAppInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (HostAppInfo.class) {
                    if (b == null) {
                        b = new HostAppInfo();
                        Context appContext = FunAdSdk.getAppContext();
                        b.s = FunAdSdk.getFunAdConfig().userId;
                        b.r = FunAdSdk.getFunAdConfig().appId;
                        b.q = appContext.getResources().getConfiguration().locale.getLanguage();
                        b.o = FunOpenIDSdk.getAndroidId(appContext);
                        b.a(appContext);
                        HostAppInfo hostAppInfo = b;
                        hostAppInfo.getClass();
                        i0.b bVar = new i0.b(hostAppInfo) { // from class: com.fun.ad.sdk.internal.api.utils.HostAppInfo.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ HostAppInfo a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {hostAppInfo};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = hostAppInfo;
                            }

                            @Override // com.fun.i0.b
                            public void onActiveNetworkInfo(@Nullable NetworkInfo networkInfo) {
                                HostAppInfo hostAppInfo2;
                                String str;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, networkInfo) == null) {
                                    if (networkInfo == null) {
                                        this.a.g = "unknow";
                                        return;
                                    }
                                    if (networkInfo.isConnectedOrConnecting()) {
                                        String subtypeName = networkInfo.getSubtypeName();
                                        if (!TextUtils.isEmpty(subtypeName)) {
                                            this.a.g = subtypeName;
                                            return;
                                        } else {
                                            hostAppInfo2 = this.a;
                                            str = networkInfo.getTypeName();
                                        }
                                    } else {
                                        hostAppInfo2 = this.a;
                                        str = "unknow";
                                    }
                                    hostAppInfo2.g = str;
                                }
                            }
                        };
                        HashSet<i0.b> hashSet = i0.b;
                        synchronized (hashSet) {
                            hashSet.add(bVar);
                        }
                        bVar.onActiveNetworkInfo(i0.a);
                        String imei = FunOpenIDSdk.getImei(appContext);
                        if (!TextUtils.isEmpty(imei)) {
                            b.t = FunOpenIDSdk.getMD5(imei);
                        }
                        String imeiNew = FunOpenIDSdk.getImeiNew(appContext);
                        if (!TextUtils.isEmpty(imeiNew)) {
                            b.u = FunOpenIDSdk.getMD5(imeiNew);
                        }
                        FunOpenIDSdk.getOaid(appContext, new OnGetOaidListener() { // from class: com.fun.ad.sdk.internal.api.utils.HostAppInfo.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // com.fun.openid.sdk.OnGetOaidListener
                            public void onGetOaid(String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                    HostAppInfo.b.p = str;
                                    LogPrinter.d("Got oaid:%s", str);
                                }
                            }
                        });
                        if (FunAdSdk.isLogEnabled()) {
                            LogPrinter.d(b.toString(), new Object[0]);
                        }
                    }
                }
            }
            return b;
        }
        return (HostAppInfo) invokeV.objValue;
    }

    public static JSONObject buildReportJson(String str, JSONObject jSONObject, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, jSONObject, Long.valueOf(j)})) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                fillHostAppInfo(jSONObject2);
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

    public static HostAppInfo fillHostAppInfo(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            HostAppInfo a2 = a();
            jSONObject.put("app", a2.c);
            jSONObject.put("appv", a2.e);
            jSONObject.put("appvn", a2.d);
            jSONObject.put("net", a2.g);
            jSONObject.put("manu", a2.h);
            jSONObject.put("model", a2.i);
            jSONObject.put("sysv", a2.j);
            jSONObject.put("h", a2.k);
            jSONObject.put("w", a2.l);
            jSONObject.put("locale", a2.q);
            jSONObject.put("opcode", a2.m);
            jSONObject.put("tk", a2.n);
            jSONObject.put("sdkvn", getSdkVersion());
            jSONObject.put("sdkv", BuildConfig.VERSION_CODE);
            jSONObject.put("anid", a2.o);
            jSONObject.put("lic", a2.r);
            jSONObject.put("plat", "a");
            jSONObject.put("oaid", a2.p);
            jSONObject.put(DpStatConstants.KEY_USER_ID, a2.s);
            jSONObject.put("iid", a2.t);
            jSONObject.put("iidn", a2.u);
            jSONObject.put("cfgv", a);
            return a2;
        }
        return (HostAppInfo) invokeL.objValue;
    }

    public static void fillReqParams(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) {
            HostAppInfo fillHostAppInfo = fillHostAppInfo(jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            String mD5String = MD5Utils.getMD5String(fillHostAppInfo.n + fillHostAppInfo.c + fillHostAppInfo.d + fillHostAppInfo.q + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49");
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
            jSONObject.put("vc", mD5String);
        }
    }

    public static int getAppVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a().f : invokeV.intValue;
    }

    public static String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? BuildConfig.VERSION_NAME : (String) invokeV.objValue;
    }

    public static int getSdkVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? BuildConfig.VERSION_CODE : invokeV.intValue;
    }

    public static void updateCfgv(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65544, null, j) == null) {
            a = j;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "HostAppInfo{packageName='" + this.c + "', versionName='" + this.d + "', versionCode='" + this.e + "', networkTypeName='" + this.g + "', manufacturer='" + this.h + "', model='" + this.i + "', osVersion='" + this.j + "', h='" + this.k + "', w='" + this.l + "', opcode='" + this.m + "', token='" + this.n + "', anid='" + this.o + "', oaid='" + this.p + "', locale='" + this.q + "', lic='" + this.r + "', userId='" + this.s + "', imei='" + this.t + "', imeiNew='" + this.u + "', cfgv='" + a + "'}";
        }
        return (String) invokeV.objValue;
    }

    public final void a(Context context) {
        DisplayMetrics displayMetrics;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PackageManager packageManager = context.getPackageManager();
            this.c = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                this.c = packageInfo.packageName;
                this.d = packageInfo.versionName;
                int i = packageInfo.versionCode;
                this.f = i;
                this.e = String.valueOf(i);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    this.m = networkOperator;
                }
            }
            this.h = Build.MANUFACTURER;
            this.i = Build.MODEL;
            this.j = String.valueOf(Build.VERSION.SDK_INT);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                displayMetrics = context.getResources().getDisplayMetrics();
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                displayMetrics = displayMetrics2;
            }
            this.k = String.valueOf(displayMetrics.heightPixels);
            this.l = String.valueOf(displayMetrics.widthPixels);
            if (TextUtils.isEmpty(ie9.a)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FunAdSdk.getAppContext());
                String string = defaultSharedPreferences.getString("u_tok", "");
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(string.getBytes(Charset.forName("UTF-8")));
                        substring = Base64.encodeToString(messageDigest.digest(), 2);
                    } catch (Throwable unused2) {
                        if (string.length() >= 24) {
                            substring = string.substring(0, 24);
                        }
                    }
                    string = substring;
                    defaultSharedPreferences.edit().putString("u_tok", string).apply();
                }
                ie9.a = string;
            }
            this.n = ie9.a;
        }
    }
}
