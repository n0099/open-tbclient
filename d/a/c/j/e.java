package d.a.c.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static e r;
    public static HashMap<String, Integer> s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44768a;

    /* renamed from: b  reason: collision with root package name */
    public String f44769b;

    /* renamed from: c  reason: collision with root package name */
    public String f44770c;

    /* renamed from: d  reason: collision with root package name */
    public String f44771d;

    /* renamed from: e  reason: collision with root package name */
    public String f44772e;

    /* renamed from: f  reason: collision with root package name */
    public String f44773f;

    /* renamed from: g  reason: collision with root package name */
    public String f44774g;

    /* renamed from: h  reason: collision with root package name */
    public String f44775h;

    /* renamed from: i  reason: collision with root package name */
    public String f44776i;
    public String j;
    public String k;
    public SharedPreferences l;
    public String m;
    public Context n;
    public String o;
    public boolean p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1754036628, "Ld/a/c/j/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1754036628, "Ld/a/c/j/e;");
                return;
            }
        }
        q = a.f44765a;
        HashMap<String, Integer> hashMap = new HashMap<>();
        s = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        s.put("3GNET", 21);
        s.put("3GWAP", 22);
        s.put("CMNET", 31);
        s.put("UNINET", 32);
        s.put("CTNET", 33);
        s.put("CMWAP", 41);
        s.put("UNIWAP", 42);
        s.put("CTWAP", 43);
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = false;
        this.n = context;
    }

    public static synchronized e p() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (e.class) {
                if (r == null) {
                    r = new e(AppRuntime.getAppContext());
                }
                eVar = r;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? g(str, "cfrom", "tieba") : (String) invokeL.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String g2 = g(g(h(str, "bdbox"), "uid", new String(Base64Encoder.B64Encode("0".getBytes()))), "from", "757b");
            String d2 = d(d(d(null, "uid"), "ua"), "ut");
            String g3 = g(g(g(g(g(g2, "ua", o(new String(Base64Encoder.B64Encode("320_480_android_0.8_1".getBytes())))), "ut", o(new String(Base64Encoder.B64Encode((j(Build.MODEL, null) + "_" + j(Build.VERSION.RELEASE, XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT) + "_" + Build.VERSION.SDK_INT + "_" + j(Build.MANUFACTURER, null)).getBytes())))), "osname", BaseWebViewActivity.SHOUBAI_SCHEME), "osbranch", "a0"), "pkgname", this.n.getPackageName());
            int B64GetVersion = Base64Encoder.B64GetVersion();
            if (B64GetVersion != 0) {
                str2 = B64GetVersion + "";
            } else {
                str2 = "1";
            }
            if (!TextUtils.isEmpty(d2) && !TextUtils.equals(str2, "1")) {
                g3 = g(g3, "cen", d2);
            }
            g(str, "network", NetworkParam.NET_TYPE_ID_DISCONNECT);
            g(g3, "cfrom", "757b");
            g(g3, SocialConstants.PARAM_TYPE_ID, "0");
            return g3;
        }
        return (String) invokeL.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(str, "from", s()) : (String) invokeL.objValue;
    }

    public final String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2.replace("_", "-");
            }
            return str + "_" + str2.replace("_", "-");
        }
        return (String) invokeLL.objValue;
    }

    public final String e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            if (z) {
                String m = m();
                if (TextUtils.equals(m, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                    return g(str, "network", PreferenceManager.getDefaultSharedPreferences(this.n.getApplicationContext()).getString(NetworkParam.LAST_NETWORK_TYPE, NetworkParam.NET_TYPE_ID_DISCONNECT));
                }
                if (TextUtils.isEmpty(m)) {
                    return str;
                }
                if (!TextUtils.equals(m, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.n.getApplicationContext()).edit();
                    edit.putString(NetworkParam.LAST_NETWORK_TYPE, m);
                    edit.apply();
                }
                return g(str, "network", m);
            }
            return g(str, "network", m());
        }
        return (String) invokeLZ.objValue;
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? g(str, "pkgname", this.n.getPackageName()) : (String) invokeL.objValue;
    }

    public String g(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) ? UrlUtil.addParam(str, str2, str3) : (String) invokeLLL.objValue;
    }

    public final String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) ? g(str, "service", str2) : (String) invokeLL.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            String string = this.l.getString("tntrace", "");
            if (!TextUtils.isEmpty(string)) {
                str = string + "_" + str;
            }
            SharedPreferences.Editor edit = this.l.edit();
            edit.putString("tntrace", str);
            edit.apply();
        }
    }

    public final String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "NUL";
            }
            return TextUtils.isEmpty(str) ? str2 : str.replace("_", "-");
        }
        return (String) invokeLL.objValue;
    }

    public final String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? CommonParam.getCUID(context) : (String) invokeL.objValue;
    }

    public final String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            if (q) {
                Log.d(TitanDownloadService.TAG, "load tn from R.raw.tnconfig, tn = ");
            }
            return TextUtils.isEmpty("") ? "757b" : "";
        }
        return (String) invokeL.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (q) {
                SystemClock.uptimeMillis();
            }
            ConnectManager connectManager = new ConnectManager(this.n);
            String netType = connectManager.getNetType();
            int subType = connectManager.getSubType();
            if (!TextUtils.isEmpty(netType)) {
                Integer num = s.get(netType.toUpperCase());
                if (num == null) {
                    num = 5;
                }
                return num + "_" + subType;
            }
            return ((Object) 5) + "_" + subType;
        }
        return (String) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String str = this.f44774g + "_" + this.f44776i + "_" + Build.VERSION.SDK_INT + "_" + this.f44775h;
            if (q) {
                Log.d(TitanDownloadService.TAG, "device info : " + str);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f44773f == null) {
                this.f44773f = r(this.n);
            }
            return this.f44773f;
        }
        return (String) invokeV.objValue;
    }

    public final String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, context)) == null) {
            String string = this.l.getString("lasttn", "");
            String l = l(context);
            if (!(!TextUtils.equals(string, l)) && !TextUtils.isEmpty(string)) {
                if (q) {
                    Log.d(TitanDownloadService.TAG, "load tn from local, lastTn = " + string);
                    return string;
                }
                return string;
            }
            SharedPreferences.Editor edit = this.l.edit();
            edit.putString("lasttn", l);
            edit.apply();
            i(l);
            if (q) {
                Log.d(TitanDownloadService.TAG, "load tn from apk, lastTn = " + l);
            }
            return l;
        }
        return (String) invokeL.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f44772e == null) {
                this.f44772e = t(this.n);
            }
            return this.f44772e;
        }
        return (String) invokeV.objValue;
    }

    public final String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) {
            String string = this.l.getString("tnconfig", "");
            if (TextUtils.isEmpty(string)) {
                String q2 = TextUtils.isEmpty("") ? q() : "";
                SharedPreferences.Editor edit = this.l.edit();
                edit.putString("tnconfig", q2);
                edit.apply();
                string = q2;
            } else if (q) {
                Log.d(TitanDownloadService.TAG, "load tn from local, tn = " + string);
            }
            return TextUtils.isEmpty(string) ? "757b" : string;
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "BaiduIdentityManager [mUid=" + this.f44768a + ", mEnUid=" + this.f44769b + ", mUa=" + this.f44770c + ", mEnUa=" + this.f44771d + ", mTn=" + s() + ", mLastTn=" + q() + ", mModel=" + this.f44774g + ", mManufacturer=" + this.f44775h + ", mOSVersion=" + this.f44776i + ", mDeviceInfo=" + this.j + ", mEnDeviceInfo=" + this.k + ", mSettings=" + this.l + ", mVersionName=" + this.m + ", mCtv=" + this.o + ", mProcessedUa=" + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public final String u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) {
            int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
            String str = String.valueOf(displayWidth) + "_" + DeviceUtil.ScreenInfo.getDisplayHeight(context) + "_android_" + this.m + "_" + DeviceUtil.ScreenInfo.getDensityDpi(context);
            if (q) {
                Log.d(TitanDownloadService.TAG, "ua = " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) {
            String string = this.l.getString("uid_v3", "");
            if (TextUtils.isEmpty(string)) {
                string = k(context);
                if (q) {
                    Log.d(TitanDownloadService.TAG, "new generated uid " + string);
                }
                SharedPreferences.Editor edit = this.l.edit();
                edit.putString("uid_v3", string);
                edit.apply();
            } else if (q) {
                Log.d(TitanDownloadService.TAG, "load uid from local " + string);
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "0.8";
            }
        }
        return (String) invokeL.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.l = this.n.getSharedPreferences("identity", 0);
            String v = v(this.n);
            this.f44768a = v;
            if (!TextUtils.isEmpty(v)) {
                this.f44769b = new String(Base64Encoder.B64Encode(this.f44768a.getBytes()));
            }
            String str = Build.MODEL;
            this.f44774g = str;
            if (TextUtils.isEmpty(str)) {
                this.f44774g = "NUL";
            } else {
                this.f44774g = this.f44774g.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f44775h = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f44775h = "NUL";
            } else {
                this.f44775h = this.f44775h.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f44776i = str3;
            if (TextUtils.isEmpty(str3)) {
                this.f44776i = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
            } else {
                this.f44776i = this.f44776i.replace("_", "-");
            }
            this.j = n();
            this.k = new String(Base64Encoder.B64Encode(this.j.getBytes()));
            this.m = w(this.n);
            y();
            int B64GetVersion = Base64Encoder.B64GetVersion();
            if (B64GetVersion == 0) {
                this.o = "1";
            } else {
                this.o = B64GetVersion + "";
            }
            this.p = true;
        }
    }

    public final synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this) {
                this.f44770c = u(this.n);
                this.f44771d = new String(Base64Encoder.B64Encode(this.f44770c.getBytes()));
            }
        }
    }

    public String z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            try {
                if (!this.p) {
                    x();
                }
                return g(a(e(f(g(g(c(g(str, "uid", o(this.f44769b))), "ua", o(this.f44770c)), "ut", o(this.j))), false)), SocialConstants.PARAM_TYPE_ID, "0");
            } catch (Throwable unused) {
                return b(str);
            }
        }
        return (String) invokeL.objValue;
    }
}
