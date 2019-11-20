package com.tb.airbnb.lottie.model.a;

import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.m;
import com.tb.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends o<Float, Float> {
    private b() {
        super(Float.valueOf(0.0f));
    }

    private b(List<com.tb.airbnb.lottie.a.a<Float>> list, Float f) {
        super(list, f);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<Float, Float> cLl() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.fg) : new com.tb.airbnb.lottie.a.b.c(this.eR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.model.a.o
    /* renamed from: bZ */
    public Float ca() {
        return (Float) this.fg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.model.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0579b implements m.a<Float> {
        static final C0579b kta = new C0579b();

        private C0579b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: e */
        public Float b(Object obj, float f) {
            return Float.valueOf(com.tb.airbnb.lottie.c.b.l(obj) * f);
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static b cLm() {
            return new b();
        }

        public static b e(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return a(jSONObject, eVar, true);
        }

        public static b a(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar, boolean z) {
            float bb = z ? eVar.bb() : 1.0f;
            if (jSONObject != null && jSONObject.has(Config.EVENT_HEAT_X)) {
                eVar.E("Lottie doesn't support expressions.");
            }
            n.a cLC = n.a(jSONObject, bb, eVar, C0579b.kta).cLC();
            return new b(cLC.eR, (Float) cLC.fg);
        }
    }
}
