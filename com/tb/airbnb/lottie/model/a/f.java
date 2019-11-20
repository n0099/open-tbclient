package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends o<PointF, PointF> {
    private f(List<com.tb.airbnb.lottie.a.a<PointF>> list, PointF pointF) {
        super(list, pointF);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> cLl() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.fg) : new com.tb.airbnb.lottie.a.b.j(this.eR);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static f i(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a cLC = n.a(jSONObject, eVar.bb(), eVar, com.tb.airbnb.lottie.model.j.ksY).cLC();
            return new f(cLC.eR, (PointF) cLC.fg);
        }
    }
}
