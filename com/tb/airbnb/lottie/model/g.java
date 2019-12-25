package com.tb.airbnb.lottie.model;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    private final char hy;
    private final String hz;
    private final List<com.tb.airbnb.lottie.model.content.j> shapes;
    private final int size;
    private final String style;
    private final double width;

    public static int a(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    g(List<com.tb.airbnb.lottie.model.content.j> list, char c, int i, double d, String str, String str2) {
        this.shapes = list;
        this.hy = c;
        this.size = i;
        this.width = d;
        this.style = str;
        this.hz = str2;
    }

    public List<com.tb.airbnb.lottie.model.content.j> ci() {
        return this.shapes;
    }

    public double getWidth() {
        return this.width;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static g c(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            JSONArray optJSONArray;
            int i = 0;
            char charAt = jSONObject.optString("ch").charAt(0);
            int optInt = jSONObject.optInt(TiebaInitialize.LogFields.SIZE);
            double optDouble = jSONObject.optDouble("w");
            String optString = jSONObject.optString("style");
            String optString2 = jSONObject.optString("fFamily");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            List emptyList = Collections.emptyList();
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("shapes")) != null) {
                ArrayList arrayList = new ArrayList(optJSONArray.length());
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    arrayList.add((com.tb.airbnb.lottie.model.content.j) com.tb.airbnb.lottie.model.content.j.w(optJSONArray.optJSONObject(i2), eVar));
                    i = i2 + 1;
                }
                emptyList = arrayList;
            }
            return new g(emptyList, charAt, optInt, optDouble, optString, optString2);
        }
    }

    public int hashCode() {
        return a(this.hy, this.hz, this.style);
    }
}
