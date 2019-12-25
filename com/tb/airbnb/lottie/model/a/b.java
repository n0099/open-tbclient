package com.tb.airbnb.lottie.model.a;

import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.m;
import com.tb.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends o<Float, Float> {
    private b() {
        super(Float.valueOf(0.0f));
    }

    private b(List<com.tb.airbnb.lottie.a.a<Float>> list, Float f) {
        super(list, f);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<Float, Float> dBq() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.mNB) : new com.tb.airbnb.lottie.a.b.c(this.gD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.model.a.o
    /* renamed from: dBr */
    public Float dBs() {
        return (Float) this.mNB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.model.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0689b implements m.a<Float> {
        static final C0689b mNR = new C0689b();

        private C0689b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: f */
        public Float c(Object obj, float f) {
            return Float.valueOf(com.tb.airbnb.lottie.c.b.bE(obj) * f);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static b dBt() {
            return new b();
        }

        public static b e(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return a(jSONObject, eVar, true);
        }

        public static b a(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar, boolean z) {
            float dAZ = z ? eVar.dAZ() : 1.0f;
            if (jSONObject != null && jSONObject.has(Config.EVENT_HEAT_X)) {
                eVar.G("Lottie doesn't support expressions.");
            }
            n.a dBK = n.a(jSONObject, dAZ, eVar, C0689b.mNR).dBK();
            return new b(dBK.gD, (Float) dBK.mNB);
        }
    }
}
