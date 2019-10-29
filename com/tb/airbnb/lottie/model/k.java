package com.tb.airbnb.lottie.model;

import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.m;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class k {
    private final float gr;
    private final float gs;

    public k(float f, float f2) {
        this.gr = f;
        this.gs = f2;
    }

    public k() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.gr;
    }

    public float getScaleY() {
        return this.gs;
    }

    public String toString() {
        return getScaleX() + Config.EVENT_HEAT_X + getScaleY();
    }

    /* loaded from: classes6.dex */
    public static class a implements m.a<k> {
        public static final a ktQ = new a();

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: j */
        public k b(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            return new k((((float) jSONArray.optDouble(0, 1.0d)) / 100.0f) * f, (((float) jSONArray.optDouble(1, 1.0d)) / 100.0f) * f);
        }
    }
}
