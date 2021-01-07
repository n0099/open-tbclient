package com.qq.e.comm.plugin.rewardvideo;

import android.content.Context;
import android.os.SystemClock;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.plugin.util.q;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static SM f12742a = GDTADManager.getInstance().getSM();

    public static int a() {
        return f12742a.getInteger("rewardVideoCardShowTime", 4);
    }

    public static int a(SM sm) {
        return sm.getInteger("rewardVideoDemoGamePreloadTime", 3);
    }

    public static int a(com.qq.e.comm.plugin.s.a aVar, boolean z) {
        if (z) {
            return q.a(aVar) ? 2 : 0;
        }
        return 1;
    }

    public static int a(String str) {
        return f12742a.getIntegerForPlacement("rewardVideoCloseShowTime", str, 30);
    }

    public static String a(int i, String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("p", String.valueOf(j));
            jSONObject.put("click_area", String.valueOf(i));
            jSONObject.put("vp", String.valueOf(1));
            jSONObject.put("sz", "-999");
            jSONObject.put("tid", "-999");
            str = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return com.qq.e.comm.plugin.ad.g.a(str);
    }

    public static JSONObject a(Context context, com.qq.e.comm.plugin.s.a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject(aVar.E().toString());
        if (com.qq.e.comm.plugin.util.b.a(context, aVar) || !aVar.v()) {
            jSONObject.put("custom_button_txt", aVar.ad());
            jSONObject.put("dpa_custom_button_txt", q.a(aVar) ? aVar.ab().f : "");
        }
        return jSONObject;
    }

    public static void a(Context context, String str, String str2, d dVar) {
        gdtadv.getVresult(117, 1, context, str, str2, dVar);
    }

    public static boolean a(int i, int i2, int i3, int i4) {
        int i5 = i2 >= i3 / 1000 ? (i3 / 1000) - i4 : i2 - i4;
        if (i5 < 0) {
            i5 = 0;
        }
        return i2 >= 0 && i >= i5 * 1000;
    }

    public static boolean a(com.qq.e.comm.plugin.s.a aVar) {
        int integer = f12742a.getInteger("rvfsClickable", 0);
        return integer == 1 || (integer != 0 && com.qq.e.comm.plugin.l.a.a().a(aVar.Z(), String.valueOf(integer), 0) == 1);
    }

    public static int b() {
        int integer = f12742a.getInteger("rewardLoadAdCount", 1);
        if (integer > 2 || integer < 1) {
            return 1;
        }
        return integer;
    }

    public static int b(String str) {
        return f12742a.getIntegerForPlacement("rewardVideoEffectiveTime", str, 30);
    }

    public static long c() {
        return SystemClock.elapsedRealtime() + (f12742a.getInteger("rewardVideoExpireDuration", 1800) * 1000);
    }

    public static boolean c(String str) {
        return f12742a.getIntegerForPlacement("showRewardVideoTips", str, 0) == 1;
    }
}
