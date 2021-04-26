package d.a.h0.a.j1.q;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.h0.a.i2.l;
import d.a.h0.a.k;
import d.a.h0.a.z1.b;
import d.a.h0.a.z1.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43004a;

    /* renamed from: b  reason: collision with root package name */
    public static List<Pair<String, Pair<String, String>>> f43005b;

    static {
        boolean z = k.f43101a;
        f43004a = z;
        if (z) {
            ArrayList arrayList = new ArrayList();
            f43005b = arrayList;
            arrayList.add(new Pair("总时长", new Pair("na_pms_start_req", "na_end_update_db")));
            f43005b.add(new Pair<>("PMS信息获取时长", new Pair("na_pms_start_req", "na_pms_end_req")));
            f43005b.add(new Pair<>("包下载时长", new Pair("na_pms_start_download", "na_pms_end_download")));
            f43005b.add(new Pair<>("Icon下载时长", new Pair("na_pms_start_icon", "na_pms_end_icon")));
            f43005b.add(new Pair<>("签名校验时长", new Pair("na_pms_start_check_sign", "na_pms_end_check_sign")));
            f43005b.add(new Pair<>("包解压时长", new Pair("na_package_start_unzip", "na_package_end_unzip")));
            f43005b.add(new Pair<>("包解密时长", new Pair("na_package_start_decrypt", "na_package_end_decrypt")));
            f43005b.add(new Pair<>("更新数据库时长", new Pair("na_start_update_db", "na_end_update_db")));
        }
    }

    public static void a(String str, String str2, List<UbcFlowEvent> list, String str3) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        d.a.h0.a.z1.a e2 = h.e("770");
        for (UbcFlowEvent ubcFlowEvent : list) {
            if (ubcFlowEvent != null) {
                b.e(e2, ubcFlowEvent.f11915a, ubcFlowEvent.j(), ubcFlowEvent.g());
            }
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("from", "swan");
            jSONObject.put("type", str2);
            jSONObject2.put("appid", str);
            jSONObject2.put("mobile", l.a());
            jSONObject2.put("net", SwanAppNetworkUtils.f().type);
            if (TextUtils.isEmpty(str3)) {
                str3 = "0";
            }
            jSONObject2.put("scene", str3);
            jSONObject.put("ext", jSONObject2.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        b.f(e2, jSONObject.toString());
        b.c(e2);
        b(str, list, f43005b);
    }

    @SuppressLint({"SwanDebugLog"})
    public static void b(String str, List<UbcFlowEvent> list, List<Pair<String, Pair<String, String>>> list2) {
        if (!f43004a || list == null || list2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("小程序PMS下载耗时Log：");
        sb.append("\n");
        sb.append("小程序ID：");
        sb.append(str);
        sb.append("\n");
        sb.append("小程序ID：");
        sb.append(str);
        for (UbcFlowEvent ubcFlowEvent : list) {
            if (ubcFlowEvent != null) {
                sb.append("\n");
                sb.append(ubcFlowEvent.g());
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                sb.append(ubcFlowEvent.f11915a);
                hashMap.put(ubcFlowEvent.f11915a, Long.valueOf(ubcFlowEvent.g()));
            }
        }
        sb.append("\n");
        sb.append("耗时计算开始：>>>>>>>>>>>>");
        for (Pair<String, Pair<String, String>> pair : list2) {
            if (pair != null) {
                String str2 = (String) pair.first;
                Object obj = pair.second;
                String str3 = (String) ((Pair) obj).first;
                String str4 = (String) ((Pair) obj).second;
                if (hashMap.get(str3) != null && hashMap.get(str4) != null) {
                    long longValue = ((Long) hashMap.get(str3)).longValue();
                    String format = String.format(Locale.CHINA, "%-13d", Long.valueOf(((Long) hashMap.get(str4)).longValue() - longValue));
                    sb.append("\n");
                    sb.append("耗时：");
                    sb.append(format);
                    sb.append(" >>> ");
                    sb.append(str2);
                    sb.append("，计算方式：");
                    sb.append(str4);
                    sb.append(" - ");
                    sb.append(str3);
                }
            }
        }
        Log.i("SwanAppPMS", sb.toString());
    }
}
