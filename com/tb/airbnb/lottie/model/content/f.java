package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.f;
import com.tb.airbnb.lottie.model.a.m;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements b {
    private final com.tb.airbnb.lottie.model.a.b ktL;
    private final m<PointF, PointF> ktl;
    private final com.tb.airbnb.lottie.model.a.f kts;
    private final String name;

    private f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.ktl = mVar;
        this.kts = fVar;
        this.ktL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static f t(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return new f(jSONObject.optString("nm"), com.tb.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar), f.a.i(jSONObject.optJSONObject("s"), eVar), b.a.e(jSONObject.optJSONObject("r"), eVar));
        }
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b cLV() {
        return this.ktL;
    }

    public com.tb.airbnb.lottie.model.a.f cLD() {
        return this.kts;
    }

    public m<PointF, PointF> cLu() {
        return this.ktl;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{cornerRadius=" + this.ktL.ca() + ", position=" + this.ktl + ", size=" + this.kts + '}';
    }
}
