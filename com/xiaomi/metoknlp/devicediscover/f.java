package com.xiaomi.metoknlp.devicediscover;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final double e;
    private final double f;
    private final String g;
    private final String h;
    private final long i;
    private final long j;
    private final String k;
    private final String l;
    private final List m;

    private f(d dVar) {
        String str;
        String str2;
        String str3;
        String str4;
        double d;
        double d2;
        String str5;
        String str6;
        long j;
        long j2;
        String str7;
        String str8;
        List list;
        str = dVar.a;
        this.a = str;
        str2 = dVar.b;
        this.b = str2;
        str3 = dVar.c;
        this.c = str3;
        str4 = dVar.d;
        this.d = str4;
        d = dVar.e;
        this.e = d;
        d2 = dVar.f;
        this.f = d2;
        str5 = dVar.g;
        this.g = str5;
        str6 = dVar.h;
        this.h = str6;
        j = dVar.i;
        this.i = j;
        j2 = dVar.j;
        this.j = j2;
        str7 = dVar.k;
        this.k = str7;
        str8 = dVar.l;
        this.l = str8;
        list = dVar.m;
        this.m = list;
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || obj == null) {
            return;
        }
        if (!(obj instanceof String)) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e) {
            }
        } else if (((String) obj).isEmpty()) {
        } else {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e2) {
            }
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, Config.MODEL, this.a);
        a(jSONObject, "i", this.b);
        a(jSONObject, Config.APP_VERSION_CODE, this.c);
        a(jSONObject, Config.OS, this.d);
        a(jSONObject, "lg", Double.valueOf(this.e));
        a(jSONObject, "lt", Double.valueOf(this.f));
        a(jSONObject, "am", this.g);
        a(jSONObject, AdvanceSetting.ADVANCE_SETTING, this.h);
        a(jSONObject, "ast", Long.valueOf(this.i));
        a(jSONObject, "ad", Long.valueOf(this.j));
        a(jSONObject, "ds", this.k);
        a(jSONObject, "dm", this.l);
        JSONArray jSONArray = new JSONArray();
        for (String str : this.m) {
            jSONArray.put(str);
        }
        a(jSONObject, "devices", jSONArray);
        return jSONObject;
    }
}
