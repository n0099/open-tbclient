package com.tb.airbnb.lottie.model.a;

import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.m;
import com.tb.airbnb.lottie.model.a.n;
import com.tb.airbnb.lottie.model.d;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j extends o<com.tb.airbnb.lottie.model.d, com.tb.airbnb.lottie.model.d> {
    j(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.d>> list, com.tb.airbnb.lottie.model.d dVar) {
        super(list, dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.model.a.m
    /* renamed from: cLt */
    public com.tb.airbnb.lottie.a.b.o cLn() {
        return new com.tb.airbnb.lottie.a.b.o(this.fu);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static j l(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            if (jSONObject != null && jSONObject.has(Config.EVENT_HEAT_X)) {
                eVar.E("Lottie doesn't support expressions.");
            }
            n.a cLE = n.a(jSONObject, 1.0f, eVar, b.ktW).cLE();
            return new j(cLE.fu, (com.tb.airbnb.lottie.model.d) cLE.fI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements m.a<com.tb.airbnb.lottie.model.d> {
        private static final b ktW = new b();

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: l */
        public com.tb.airbnb.lottie.model.d b(Object obj, float f) {
            return d.a.cu((JSONObject) obj);
        }
    }
}
