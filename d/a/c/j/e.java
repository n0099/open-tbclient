package d.a.c.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.util.Base64Encoder;
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class e {
    public static final boolean q = a.f42956a;
    public static e r;
    public static HashMap<String, Integer> s;

    /* renamed from: a  reason: collision with root package name */
    public String f42959a;

    /* renamed from: b  reason: collision with root package name */
    public String f42960b;

    /* renamed from: c  reason: collision with root package name */
    public String f42961c;

    /* renamed from: d  reason: collision with root package name */
    public String f42962d;

    /* renamed from: e  reason: collision with root package name */
    public String f42963e;

    /* renamed from: f  reason: collision with root package name */
    public String f42964f;

    /* renamed from: g  reason: collision with root package name */
    public String f42965g;

    /* renamed from: h  reason: collision with root package name */
    public String f42966h;

    /* renamed from: i  reason: collision with root package name */
    public String f42967i;
    public String j;
    public String k;
    public SharedPreferences l;
    public String m;
    public Context n;
    public String o;
    public boolean p = false;

    static {
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
        this.n = context;
    }

    public static synchronized e p() {
        e eVar;
        synchronized (e.class) {
            if (r == null) {
                r = new e(AppRuntime.getAppContext());
            }
            eVar = r;
        }
        return eVar;
    }

    public final String a(String str) {
        return g(str, "cfrom", "tieba");
    }

    public final String b(String str) {
        String str2;
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

    public final String c(String str) {
        return g(str, "from", s());
    }

    public final String d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2.replace("_", "-");
        }
        return str + "_" + str2.replace("_", "-");
    }

    public final String e(String str, boolean z) {
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

    public final String f(String str) {
        return g(str, "pkgname", this.n.getPackageName());
    }

    public String g(String str, String str2, String str3) {
        return UrlUtil.addParam(str, str2, str3);
    }

    public final String h(String str, String str2) {
        return g(str, "service", str2);
    }

    public final void i(String str) {
        String string = this.l.getString("tntrace", "");
        if (!TextUtils.isEmpty(string)) {
            str = string + "_" + str;
        }
        SharedPreferences.Editor edit = this.l.edit();
        edit.putString("tntrace", str);
        edit.apply();
    }

    public final String j(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "NUL";
        }
        return TextUtils.isEmpty(str) ? str2 : str.replace("_", "-");
    }

    public final String k(Context context) {
        return CommonParam.getCUID(context);
    }

    public final String l(Context context) {
        if (q) {
            Log.d(TitanDownloadService.TAG, "load tn from R.raw.tnconfig, tn = ");
        }
        return TextUtils.isEmpty("") ? "757b" : "";
    }

    public final String m() {
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

    public final String n() {
        String str = this.f42965g + "_" + this.f42967i + "_" + Build.VERSION.SDK_INT + "_" + this.f42966h;
        if (q) {
            Log.d(TitanDownloadService.TAG, "device info : " + str);
        }
        return str;
    }

    public final String o(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final String q() {
        if (this.f42964f == null) {
            this.f42964f = r(this.n);
        }
        return this.f42964f;
    }

    public final String r(Context context) {
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

    public String s() {
        if (this.f42963e == null) {
            this.f42963e = t(this.n);
        }
        return this.f42963e;
    }

    public final String t(Context context) {
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

    public String toString() {
        return "BaiduIdentityManager [mUid=" + this.f42959a + ", mEnUid=" + this.f42960b + ", mUa=" + this.f42961c + ", mEnUa=" + this.f42962d + ", mTn=" + s() + ", mLastTn=" + q() + ", mModel=" + this.f42965g + ", mManufacturer=" + this.f42966h + ", mOSVersion=" + this.f42967i + ", mDeviceInfo=" + this.j + ", mEnDeviceInfo=" + this.k + ", mSettings=" + this.l + ", mVersionName=" + this.m + ", mCtv=" + this.o + ", mProcessedUa=" + PreferencesUtil.RIGHT_MOUNT;
    }

    public final String u(Context context) {
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        String str = String.valueOf(displayWidth) + "_" + DeviceUtil.ScreenInfo.getDisplayHeight(context) + "_android_" + this.m + "_" + DeviceUtil.ScreenInfo.getDensityDpi(context);
        if (q) {
            Log.d(TitanDownloadService.TAG, "ua = " + str);
        }
        return str;
    }

    public final String v(Context context) {
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

    public final String w(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "0.8";
        }
    }

    public final void x() {
        this.l = this.n.getSharedPreferences("identity", 0);
        String v = v(this.n);
        this.f42959a = v;
        if (!TextUtils.isEmpty(v)) {
            this.f42960b = new String(Base64Encoder.B64Encode(this.f42959a.getBytes()));
        }
        String str = Build.MODEL;
        this.f42965g = str;
        if (TextUtils.isEmpty(str)) {
            this.f42965g = "NUL";
        } else {
            this.f42965g = this.f42965g.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f42966h = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f42966h = "NUL";
        } else {
            this.f42966h = this.f42966h.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f42967i = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f42967i = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        } else {
            this.f42967i = this.f42967i.replace("_", "-");
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

    public final synchronized void y() {
        this.f42961c = u(this.n);
        this.f42962d = new String(Base64Encoder.B64Encode(this.f42961c.getBytes()));
    }

    public String z(String str) {
        try {
            if (!this.p) {
                x();
            }
            String o = o(this.j);
            String o2 = o(this.f42960b);
            return g(a(e(f(g(g(c(g(str, "uid", o2)), "ua", o(this.f42961c)), "ut", o)), false)), SocialConstants.PARAM_TYPE_ID, "0");
        } catch (Throwable unused) {
            return b(str);
        }
    }
}
