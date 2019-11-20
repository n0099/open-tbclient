package com.tb.airbnb.lottie.model;

import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import com.tb.airbnb.lottie.model.a.m;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class a implements m.a<Integer> {
    public static final a ksX = new a();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.model.a.m.a
    /* renamed from: a */
    public Integer b(Object obj, float f) {
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.length() == 4) {
            boolean z = true;
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.optDouble(i) > 1.0d) {
                    z = false;
                }
            }
            float f2 = z ? 255.0f : 1.0f;
            return Integer.valueOf(Color.argb((int) (jSONArray.optDouble(3) * f2), (int) (jSONArray.optDouble(0) * f2), (int) (jSONArray.optDouble(1) * f2), (int) (jSONArray.optDouble(2) * f2)));
        }
        return Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK);
    }
}
