package com.tb.airbnb.lottie.model.a;

import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.m;
import com.tb.airbnb.lottie.model.a.n;
import com.tb.airbnb.lottie.model.d;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends o<com.tb.airbnb.lottie.model.d, com.tb.airbnb.lottie.model.d> {
    j(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.d>> list, com.tb.airbnb.lottie.model.d dVar) {
        super(list, dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.model.a.m
    /* renamed from: dBz */
    public com.tb.airbnb.lottie.a.b.o dBq() {
        return new com.tb.airbnb.lottie.a.b.o(this.gD);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static j l(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            if (jSONObject != null && jSONObject.has(Config.EVENT_HEAT_X)) {
                eVar.G("Lottie doesn't support expressions.");
            }
            n.a dBK = n.a(jSONObject, 1.0f, eVar, b.mNX).dBK();
            return new j(dBK.gD, (com.tb.airbnb.lottie.model.d) dBK.mNB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements m.a<com.tb.airbnb.lottie.model.d> {
        private static final b mNX = new b();

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: h */
        public com.tb.airbnb.lottie.model.d c(Object obj, float f) {
            return d.a.dC((JSONObject) obj);
        }
    }
}
