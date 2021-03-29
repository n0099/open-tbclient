package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.kwai.video.player.KsMediaMeta;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f65107a = {"ab_version", "device_brand", KsMediaMeta.KSM_KEY_LANGUAGE, "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", Constants.KEY_DEVICE_ID, "openudid", "clientudid", "aid"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f65108b = {"ab_version", "device_brand", KsMediaMeta.KSM_KEY_LANGUAGE, "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", DpStatConstants.KEY_APP_NAME, "version_name", "device_type", "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", Constants.KEY_DEVICE_ID, "openudid", "clientudid", "aid"};

    public static String a(Context context, JSONObject jSONObject, String str, boolean z, d dVar) {
        HashMap<String, String> a2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap hashMap = new HashMap(f65107a.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = f65107a;
            if (i >= strArr.length) {
                break;
            }
            String optString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(f65108b[i], optString);
            }
            i++;
        }
        if (dVar != null) {
            try {
                a2 = dVar.a(context);
            } catch (Exception e2) {
                r0.b(e2);
            }
        } else {
            a2 = null;
        }
        if (s0.h(context) && a2 != null) {
            hashMap.putAll(a2);
        }
        try {
            HashMap<String, String> a3 = a.i() == null ? null : a.i().a();
            if (a3 != null) {
                hashMap.putAll(a3);
            }
        } catch (Exception e3) {
            r0.b(e3);
        }
        if (a.f64942f.size() > 0) {
            hashMap.putAll(a.f64942f);
        }
        if (z) {
            hashMap.put("ssmix", "a");
        }
        String b2 = o0.b(context);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("ac", b2);
        }
        String str2 = (String) a.j("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) a.j("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("channel", str2);
        }
        String optString2 = jSONObject.optString("os_version", null);
        if (optString2 != null && optString2.length() > 10) {
            optString2 = optString2.substring(0, 10);
        }
        hashMap.put("os_version", optString2);
        hashMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
        hashMap.put("device_platform", "android");
        int intValue = ((Integer) a.j("version_code", -1)).intValue();
        if (intValue != -1) {
            hashMap.put("version_code", String.valueOf(intValue));
        }
        int intValue2 = ((Integer) a.j("manifest_version_code", -1)).intValue();
        if (intValue2 != -1) {
            hashMap.put("manifest_version_code", String.valueOf(intValue2));
        }
        int intValue3 = ((Integer) a.j("update_version_code", -1)).intValue();
        if (intValue3 != -1) {
            hashMap.put("update_version_code", String.valueOf(intValue3));
        }
        String b3 = x0.b(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(b3)) {
            hashMap.put("oaid", b3);
        }
        String optString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(optString3)) {
            hashMap.put("cdid", optString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) >= 0 ? Typography.amp : '?');
        return s0.d(sb.toString(), hashMap, "UTF-8");
    }

    public static String[] b(Context context, JSONObject jSONObject) {
        String[] strArr = new String[x.b().f().length];
        String str = a.h() ? "/service/2/app_log/?tt_data=a" : "/service/2/app_log/?";
        for (int i = 0; i < x.b().f().length; i++) {
            strArr[i] = a(context, jSONObject, x.b().f()[i] + str, true, a.k());
            strArr[i] = x.e(strArr[i], x.f65098d);
        }
        return strArr;
    }
}
