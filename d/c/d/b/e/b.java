package d.c.d.b.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.kwai.video.player.KsMediaMeta;
import d.c.d.b.l;
import d.c.d.b.m;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f66661c = {"version_code", "manifest_version_code", "aid", "update_version_code"};

    /* renamed from: a  reason: collision with root package name */
    public Context f66662a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f66663b = new JSONObject();

    public b(Context context) {
        this.f66662a = context;
    }

    public static b a(Context context) {
        b bVar = new b(context);
        JSONObject b2 = bVar.b();
        bVar.e(b2);
        bVar.j(b2);
        bVar.k(b2);
        bVar.l(b2);
        bVar.m(b2);
        bVar.n(b2);
        bVar.h(b2);
        return bVar;
    }

    public JSONObject b() {
        return this.f66663b;
    }

    public JSONObject c(String str) {
        try {
            this.f66663b.put(Constants.KEY_DEVICE_ID, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.f66663b;
    }

    public JSONObject d(@Nullable Map<String, Object> map) {
        String[] strArr;
        if (map == null) {
            return this.f66663b;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.f66663b.has(entry.getKey())) {
                this.f66663b.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : f66661c) {
            if (map.containsKey(str)) {
                try {
                    this.f66663b.put(str, Integer.parseInt((String) map.get(str)));
                } catch (Exception unused) {
                    this.f66663b.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            this.f66663b.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
        }
        if (map.containsKey("iid")) {
            this.f66663b.put("udid", map.get("iid"));
            this.f66663b.remove("iid");
        }
        return this.f66663b;
    }

    @SuppressLint({"MissingPermission"})
    public final void e(JSONObject jSONObject) {
        int i;
        try {
            PackageInfo packageInfo = this.f66662a.getPackageManager().getPackageInfo(this.f66662a.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", this.f66662a.getString(i));
            }
            jSONObject.put("sdk_version", 22130);
            jSONObject.put("sdk_version_name", "2.2.1-alpha.30");
            jSONObject.put(IAdRequestParam.OS, "Android");
            jSONObject.put("os_version", i());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, f());
        } catch (Exception unused) {
        }
    }

    public final String f() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e2) {
            l.k.c(e2);
            return "unknown";
        }
    }

    public JSONObject g(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f66663b.put("user_id", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.f66663b;
    }

    public final void h(JSONObject jSONObject) {
        Map<String, Object> c2;
        Object obj;
        d.c.d.b.h.b a2 = m.a();
        if (a2 == null || jSONObject == null || (c2 = a2.c()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : c2.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = c2.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Exception e2) {
            l.k.c(e2);
        }
    }

    public final String i() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    public final void j(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = this.f66662a.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    public final void k(JSONObject jSONObject) {
        try {
            String language = this.f66662a.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused) {
        }
    }

    public final void l(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (l.d.e()) {
                sb.append("MIUI-");
            } else if (l.d.f()) {
                sb.append("FLYME-");
            } else {
                String a2 = l.d.a();
                if (l.d.b(a2)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put(Config.ROM, sb.toString());
            }
            jSONObject.put("rom_version", l.m.a());
        } catch (Throwable unused) {
        }
    }

    public final void m(JSONObject jSONObject) {
        try {
            jSONObject.put("access", l.j.a(this.f66662a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void n(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f66662a.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
