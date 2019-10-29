package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.h;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements b {
    private final int index;
    private final com.tb.airbnb.lottie.model.a.h kuH;
    private final String name;

    private k(String str, int i, com.tb.airbnb.lottie.model.a.h hVar) {
        this.name = str;
        this.index = i;
        this.kuH = hVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.h cMc() {
        return this.kuH;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + ", hasAnimation=" + this.kuH.hasAnimation() + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static k z(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return new k(jSONObject.optString("nm"), jSONObject.optInt("ind"), h.a.k(jSONObject.optJSONObject("ks"), eVar));
        }
    }
}
