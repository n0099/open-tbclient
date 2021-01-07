package com.qq.e.comm.plugin.s;

import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private String f12751a;

    /* renamed from: b  reason: collision with root package name */
    private long f12752b;

    public static g a(JSONObject jSONObject) {
        if (jSONObject != null) {
            g gVar = new g();
            gVar.a(jSONObject.optString("url"));
            gVar.a(jSONObject.optLong("reporttime"));
            return gVar;
        }
        return null;
    }

    public static List<g> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                Object opt = jSONArray.opt(i2);
                if (opt instanceof JSONObject) {
                    g a2 = a((JSONObject) opt);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else {
                    GDTLogger.e("Slot.parseList error !");
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public String a() {
        return this.f12751a;
    }

    public void a(long j) {
        this.f12752b = j;
    }

    public void a(String str) {
        this.f12751a = str;
    }
}
