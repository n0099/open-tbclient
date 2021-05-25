package d.a.l0.f.i.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.wallet.router.RouterCallback;
import d.a.l0.f.i.l.g;
import d.a.l0.f.i.r.f;
import d.a.l0.f.i.r.h;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    @Nullable
    public static Map<String, String> a(String str, String str2, String str3, String str4, boolean z) {
        if (z || d.a.l0.f.i.m.a.b() == null) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("ver", h.l());
        treeMap.put("host", d.a.l0.f.i.m.a.b().a());
        treeMap.put(IAdRequestParam.OS, "android");
        int c2 = NetworkUtils.c(false);
        treeMap.put("net", c2 + "");
        treeMap.put("phone", h.e());
        treeMap.put("osV", h.f());
        treeMap.put("slot", str);
        treeMap.put("flow", str2);
        treeMap.put("appid", str3);
        treeMap.put("apid", str4);
        treeMap.put("sdk", d.a.l0.f.i.m.a.b().getSdkVersion());
        treeMap.put("time", "" + System.currentTimeMillis());
        return treeMap;
    }

    public static String b(String str, @Nullable Map<String, String> map) {
        if (map != null) {
            map.put("name", str);
            return f.b("https://mobads-logs.baidu.com/dz.zb?type=mnp&", map);
        }
        return "https://mobads-logs.baidu.com/dz.zb?type=mnp&";
    }

    public static String c(@NonNull Map<String, String> map) {
        return map.get("flow");
    }

    public static void d(String str, g gVar) {
        gVar.d(str);
    }

    public static String e(String str, int i2, int i3) {
        String replaceAll = str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0");
        String replaceAll2 = replaceAll.replaceAll("%25%25cur_time%25%25", "" + i2);
        return replaceAll2.replaceAll("%25%25start_time%25%25", "" + i3).replaceAll("%25%25area%25%25", "hot");
    }

    public static void f(String str, String str2, String str3, g gVar) {
        if (d.a.l0.f.i.m.a.b() == null || h.o()) {
            return;
        }
        String a2 = d.a.l0.f.i.m.a.b().a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizId", 10003);
            jSONObject.put(TbEnum.SystemMessage.KEY_GROUP_ID, 10003);
            jSONObject.put("containerAppName", a2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("distribute_channel", 38);
            jSONObject2.put("CTK", str3);
            jSONObject2.put("logtype", 2);
            jSONObject2.put("media_id", str);
            jSONObject2.put("PVID", str3);
            jSONObject2.put("tuid", str2);
            jSONObject2.put("time", h.j());
            jSONObject2.put("page_type", 1);
            jSONObject2.put("traffic_type", 1);
            jSONObject.put("content", jSONObject2);
            gVar.c(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void g(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            d(e(str, 0, 0), gVar);
        }
    }

    public static void h(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            HashSet hashSet = new HashSet();
            hashSet.add("da_page");
            hashSet.add("da_type");
            String a2 = f.a(f.a(f.c(str, hashSet), "da_page", "NAVIDEO_TAIL_PLAYABLE"), "da_type", TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY);
            d(a2.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), gVar);
        }
        d(adElementInfo.l(), gVar);
    }

    public static void i(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            HashSet hashSet = new HashSet();
            hashSet.add("da_page");
            hashSet.add("da_type");
            String c2 = f.c(str, hashSet);
            if (!TextUtils.isEmpty(adElementInfo.t())) {
                c2 = f.a(c2, "da_page", "NAVIDEO_TAIL_PLAYABLE");
            } else if (!TextUtils.isEmpty(adElementInfo.s())) {
                c2 = f.a(c2, "da_page", "NAVIDEO_TAIL");
            }
            String a2 = f.a(c2, "da_type", TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            d(a2.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), gVar);
        }
    }

    public static void j(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.w()) {
            d(e(str, 0, 0), gVar);
        }
        for (String str2 : adElementInfo.F()) {
            d(e(str2, 0, 0), gVar);
        }
    }

    public static void k(@Nullable Map<String, String> map, String str) {
        l(map, str, new d.a.l0.f.i.o.b(AppRuntime.getAppContext()));
    }

    public static void l(@Nullable Map<String, String> map, String str, g gVar) {
        if (map == null) {
            return;
        }
        TreeMap treeMap = new TreeMap(map);
        if (!TextUtils.isEmpty(str)) {
            treeMap.put(RouterCallback.KEY_ERROR_CODE, str);
            treeMap.put("errMsg", d.a.l0.f.i.r.b.a(str));
        }
        n("error", treeMap, gVar);
    }

    public static void m(String str, Map<String, String> map) {
        n(str, map, new d.a.l0.f.i.o.b(AppRuntime.getAppContext()));
    }

    public static void n(String str, Map<String, String> map, g gVar) {
        if (map == null) {
            return;
        }
        d(b(str, map), gVar);
    }

    public static void o(int i2, int i3, AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.m()) {
            d(e(str, i2, i3), gVar);
        }
    }

    public static void p(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.C()) {
            d(e(str, 0, 0), gVar);
        }
    }

    public static void q(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.D()) {
            d(e(str, 0, 0), gVar);
        }
    }
}
