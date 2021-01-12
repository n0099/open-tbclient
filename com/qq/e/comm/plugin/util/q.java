package com.qq.e.comm.plugin.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.swan.games.utils.so.SoUtils;
import com.qq.e.comm.managers.GDTADManager;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q {
    public static com.qq.e.comm.plugin.ad.k a(JSONObject jSONObject) {
        com.qq.e.comm.plugin.ad.k kVar = new com.qq.e.comm.plugin.ad.k();
        kVar.f11897b = jSONObject.optString("float_card_title");
        kVar.f11896a = jSONObject.optString("float_card_img");
        if (TextUtils.isEmpty(kVar.f11897b) || TextUtils.isEmpty(kVar.f11896a)) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("float_card_tags");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            kVar.c = new String[optJSONArray.length()];
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                kVar.c[i] = optJSONArray.optString(i);
            }
        }
        kVar.d = jSONObject.optString("float_card_discount");
        kVar.e = jSONObject.optString("float_card_price");
        kVar.f = jSONObject.optString("float_card_button_txt");
        ai.a("DpaUtil", "parseDpaData : " + kVar.toString());
        return kVar;
    }

    public static boolean a(com.qq.e.comm.plugin.s.a aVar) {
        return (aVar == null || aVar.ab() == null || TextUtils.isEmpty(aVar.ab().f11897b) || TextUtils.isEmpty(aVar.ab().f11896a)) ? false : true;
    }

    public static int b(com.qq.e.comm.plugin.s.a aVar) {
        int i;
        int parseColor = Color.parseColor("#3171F4");
        if (aVar == null) {
            return parseColor;
        }
        String string = GDTADManager.getInstance().getSM().getString("mdpa_card_btn_color");
        ai.a("DpaUtil", "getDPAButtonColor , control server : " + string);
        if (TextUtils.isEmpty(string)) {
            string = "[{\"25\":\"#E22318\"},{\"1101073593\":\"#FF552E\"},{\"100783983\":\"#62AB00\"},{\"1106744181\":\"#3171F4\"},{\"1101072624\":\"#FA2A83\"}]";
        }
        String optString = aVar.a_() != 25 ? aVar.E().optString("productid") : SoUtils.SO_EVENT_ID_NEW_SO;
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            i = parseColor;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    String optString2 = jSONArray.getJSONObject(i2).optString(optString);
                    if (!TextUtils.isEmpty(optString2)) {
                        i = Color.parseColor(optString2);
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return i;
                }
            }
            return i;
        } catch (Exception e2) {
            e = e2;
            i = parseColor;
        }
    }
}
