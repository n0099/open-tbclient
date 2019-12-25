package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends o<PointF, PointF> {
    private f(List<com.tb.airbnb.lottie.a.a<PointF>> list, PointF pointF) {
        super(list, pointF);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dBq() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.mNB) : new com.tb.airbnb.lottie.a.b.j(this.gD);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static f i(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a dBK = n.a(jSONObject, eVar.dAZ(), eVar, com.tb.airbnb.lottie.model.j.mNP).dBK();
            return new f(dBK.gD, (PointF) dBK.mNB);
        }
    }
}
