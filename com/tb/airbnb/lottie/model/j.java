package com.tb.airbnb.lottie.model;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements m.a<PointF> {
    public static final j ktP = new j();

    private j() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.model.a.m.a
    /* renamed from: c */
    public PointF b(Object obj, float f) {
        if (obj instanceof JSONArray) {
            return com.tb.airbnb.lottie.c.b.a((JSONArray) obj, f);
        }
        if (obj instanceof JSONObject) {
            return com.tb.airbnb.lottie.c.b.a((JSONObject) obj, f);
        }
        throw new IllegalArgumentException("Unable to parse point from " + obj);
    }
}
