package com.qq.e.comm.plugin.s;

import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
class d {
    public static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                Object opt = jSONArray.opt(i2);
                if (opt instanceof String) {
                    arrayList.add((String) opt);
                } else {
                    GDTLogger.e("parseStringList error ! type wrong !");
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public static List<Integer> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                Object opt = jSONArray.opt(i2);
                if (opt instanceof Integer) {
                    arrayList.add((Integer) opt);
                } else {
                    GDTLogger.e("parseIntegerList error ! type wrong !");
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }
}
