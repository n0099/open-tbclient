package com.bytedance.tea.crash.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiContext;
import com.bytedance.tea.crash.g.i;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.l;
import com.bytedance.tea.crash.h;
import com.kwai.video.player.KsMediaMeta;
import com.xiaomi.mipush.sdk.Constants;
import com.yy.videoplayer.decoder.VideoConstant;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f7629a = {"version_code", "manifest_version_code", "aid", "update_version_code"};

    /* renamed from: b  reason: collision with root package name */
    private Context f7630b;
    private JSONObject c = new JSONObject();

    public b(Context context) {
        this.f7630b = context;
    }

    public static b ia(Context context) {
        b bVar = new b(context);
        JSONObject a2 = bVar.a();
        bVar.a(a2);
        bVar.c(a2);
        bVar.d(a2);
        bVar.e(a2);
        bVar.f(a2);
        bVar.g(a2);
        bVar.b(a2);
        return bVar;
    }

    @SuppressLint({"MissingPermission"})
    private void a(JSONObject jSONObject) {
        int i;
        try {
            PackageInfo packageInfo = this.f7630b.getPackageManager().getPackageInfo(this.f7630b.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", this.f7630b.getString(i));
            }
            jSONObject.put(SapiContext.KEY_SDK_VERSION, 22130);
            jSONObject.put(HttpConstants.SDK_VERSION_NAME, "2.2.1-alpha.30");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", c());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", b());
        } catch (Exception e) {
        }
    }

    private String b() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            if (TextUtils.isEmpty(sb.toString())) {
                return "unknown";
            }
            return sb.toString();
        } catch (Exception e) {
            j.b(e);
            return "unknown";
        }
    }

    private void b(JSONObject jSONObject) {
        Map<String, Object> b2;
        Object obj;
        com.bytedance.tea.crash.e.a erl = h.erl();
        if (erl != null && jSONObject != null && (b2 = erl.b()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : b2.keySet()) {
                    if (!TextUtils.isEmpty(str) && (obj = b2.get(str)) != null) {
                        jSONObject2.put(str, obj);
                    }
                }
                jSONObject.put("custom", jSONObject2);
            } catch (Exception e) {
                j.b(e);
            }
        }
    }

    private String c() {
        String str = Build.VERSION.RELEASE;
        return str.contains(".") ? str : str + ".0";
    }

    private void c(JSONObject jSONObject) {
        String str;
        try {
            DisplayMetrics displayMetrics = this.f7630b.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            switch (i) {
                case 120:
                    str = "ldpi";
                    break;
                case 240:
                    str = "hdpi";
                    break;
                case VideoConstant.THUMBNAIL_WIDTH /* 320 */:
                    str = "xhdpi";
                    break;
                default:
                    str = "mdpi";
                    break;
            }
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + Config.EVENT_HEAT_X + displayMetrics.widthPixels);
        } catch (Exception e) {
        }
    }

    private void d(JSONObject jSONObject) {
        try {
            String language = this.f7630b.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            int i = rawOffset >= -12 ? rawOffset : -12;
            jSONObject.put("timezone", i <= 12 ? i : 12);
        } catch (Exception e) {
        }
    }

    private void e(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.tea.crash.g.c.c()) {
                sb.append("MIUI-");
            } else if (com.bytedance.tea.crash.g.c.d()) {
                sb.append("FLYME-");
            } else {
                String a2 = com.bytedance.tea.crash.g.c.a();
                if (com.bytedance.tea.crash.g.c.a(a2)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put(Config.ROM, sb.toString());
            }
            jSONObject.put("rom_version", l.a());
        } catch (Throwable th) {
        }
    }

    private void f(JSONObject jSONObject) {
        try {
            jSONObject.put("access", i.a(this.f7630b));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void g(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f7630b.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    jSONObject.put("mcc_mnc", networkOperator);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject a(@Nullable Map<String, Object> map) {
        String[] strArr;
        if (map == null) {
            return this.c;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.c.has(entry.getKey())) {
                this.c.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : f7629a) {
            if (map.containsKey(str)) {
                try {
                    this.c.put(str, Integer.parseInt((String) map.get(str)));
                } catch (Exception e) {
                    this.c.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            this.c.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
        }
        if (map.containsKey("iid")) {
            this.c.put("udid", map.get("iid"));
            this.c.remove("iid");
        }
        return this.c;
    }

    public JSONObject a(String str) {
        try {
            this.c.put("device_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.c;
    }

    public JSONObject b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.c.put("user_id", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.c;
    }

    public JSONObject a() {
        return this.c;
    }
}
