package com.tb.airbnb.lottie.model.a;

import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.m;
import com.tb.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends o<Integer, Integer> {
    private d() {
        super(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<com.tb.airbnb.lottie.a.a<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<Integer, Integer> dBq() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.mNB) : new com.tb.airbnb.lottie.a.b.e(this.gD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.model.a.o
    /* renamed from: dBu */
    public Integer dBs() {
        return (Integer) this.mNB;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static d dBv() {
            return new d();
        }

        public static d g(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            if (jSONObject != null && jSONObject.has(Config.EVENT_HEAT_X)) {
                eVar.G("Lottie doesn't support expressions.");
            }
            n.a dBK = n.a(jSONObject, 1.0f, eVar, b.mNS).dBK();
            return new d(dBK.gD, (Integer) dBK.mNB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements m.a<Integer> {
        private static final b mNS = new b();

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: b */
        public Integer c(Object obj, float f) {
            return Integer.valueOf(Math.round(com.tb.airbnb.lottie.c.b.bE(obj) * f));
        }
    }
}
