package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.a.b.h;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements m<PointF, PointF> {
    private final List<com.tb.airbnb.lottie.a.b.h> gD;
    private PointF iG;

    public static m<PointF, PointF> h(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
        if (jSONObject.has("k")) {
            return new e(jSONObject.opt("k"), eVar);
        }
        return new i(b.a.e(jSONObject.optJSONObject(Config.EVENT_HEAT_X), eVar), b.a.e(jSONObject.optJSONObject("y"), eVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this.gD = new ArrayList();
        this.iG = new PointF(0.0f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Object obj, com.tb.airbnb.lottie.e eVar) {
        this.gD = new ArrayList();
        if (bC(obj)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.gD.add(h.a.a(jSONArray.optJSONObject(i), eVar, a.mNT));
            }
            com.tb.airbnb.lottie.a.a.g(this.gD);
            return;
        }
        this.iG = com.tb.airbnb.lottie.c.b.a((JSONArray) obj, eVar.dAZ());
    }

    private boolean bC(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
        }
        return false;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dBq() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.iG) : new com.tb.airbnb.lottie.a.b.i(this.gD);
    }

    public boolean hasAnimation() {
        return !this.gD.isEmpty();
    }

    public String toString() {
        return "initialPoint=" + this.iG;
    }

    /* loaded from: classes2.dex */
    private static class a implements m.a<PointF> {
        private static final m.a<PointF> mNT = new a();

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: d */
        public PointF c(Object obj, float f) {
            return com.tb.airbnb.lottie.c.b.a((JSONArray) obj, f);
        }
    }
}
