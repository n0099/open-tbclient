package d.b.g0.e.a.p;

import android.text.TextUtils;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.tbadk.core.util.TbEnum;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.e.a.m.e;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static void a(String str, e eVar) {
        eVar.d(str);
    }

    public static String b(String str, int i, int i2) {
        String replaceAll = str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0");
        String replaceAll2 = replaceAll.replaceAll("%25%25cur_time%25%25", "" + i);
        return replaceAll2.replaceAll("%25%25start_time%25%25", "" + i2).replaceAll("%25%25area%25%25", "hot");
    }

    public static void c(String str, String str2, String str3, e eVar) {
        if (k0.D()) {
            return;
        }
        String g2 = d.b.g0.a.w0.a.k().g();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizId", 10003);
            jSONObject.put(TbEnum.SystemMessage.KEY_GROUP_ID, 10003);
            jSONObject.put("containerAppName", g2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("distribute_channel", 38);
            jSONObject2.put("CTK", str3);
            jSONObject2.put("logtype", 2);
            jSONObject2.put("media_id", str);
            jSONObject2.put("PVID", str3);
            jSONObject2.put("tuid", str2);
            jSONObject2.put("time", d.b.g0.e.a.q.e.b());
            jSONObject2.put("page_type", 1);
            jSONObject2.put("traffic_type", 1);
            jSONObject.put("content", jSONObject2);
            eVar.c(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void d(AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            a(b(str, 0, 0), eVar);
        }
    }

    public static void e(AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            HashSet hashSet = new HashSet();
            hashSet.add("da_page");
            hashSet.add("da_type");
            String a2 = i0.a(i0.a(i0.g(str, hashSet), "da_page", "NAVIDEO_TAIL_PLAYABLE"), "da_type", TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY);
            a(a2.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), eVar);
        }
        a(adElementInfo.l(), eVar);
    }

    public static void f(AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            HashSet hashSet = new HashSet();
            hashSet.add("da_page");
            hashSet.add("da_type");
            String g2 = i0.g(str, hashSet);
            if (!TextUtils.isEmpty(adElementInfo.t())) {
                g2 = i0.a(g2, "da_page", "NAVIDEO_TAIL_PLAYABLE");
            } else if (!TextUtils.isEmpty(adElementInfo.s())) {
                g2 = i0.a(g2, "da_page", "NAVIDEO_TAIL");
            }
            String a2 = i0.a(g2, "da_type", TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            a(a2.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), eVar);
        }
    }

    public static void g(AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.w()) {
            a(b(str, 0, 0), eVar);
        }
        for (String str2 : adElementInfo.F()) {
            a(b(str2, 0, 0), eVar);
        }
    }

    public static void h(int i, int i2, AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.m()) {
            a(b(str, i, i2), eVar);
        }
    }

    public static void i(AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.C()) {
            a(b(str, 0, 0), eVar);
        }
    }

    public static void j(AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.D()) {
            a(b(str, 0, 0), eVar);
        }
    }
}
