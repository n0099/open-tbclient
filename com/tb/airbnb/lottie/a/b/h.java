package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.a.a;
import com.tb.airbnb.lottie.model.a.m;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends com.tb.airbnb.lottie.a.a<PointF> {
    @Nullable
    private Path path;

    private h(com.tb.airbnb.lottie.e eVar, @Nullable PointF pointF, @Nullable PointF pointF2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        super(eVar, pointF, pointF2, interpolator, f, f2);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static h a(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar, m.a<PointF> aVar) {
            PointF pointF;
            PointF pointF2;
            com.tb.airbnb.lottie.a.a a = a.C0685a.a(jSONObject, eVar, eVar.dAZ(), aVar);
            JSONArray optJSONArray = jSONObject.optJSONArray(Config.FEED_LIST_PART);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("to");
            if (optJSONArray == null || optJSONArray2 == null) {
                pointF = null;
                pointF2 = null;
            } else {
                PointF a2 = com.tb.airbnb.lottie.c.b.a(optJSONArray2, eVar.dAZ());
                pointF = com.tb.airbnb.lottie.c.b.a(optJSONArray, eVar.dAZ());
                pointF2 = a2;
            }
            h hVar = new h(eVar, (PointF) a.kn, (PointF) a.ko, a.kp, a.ed, a.kq);
            boolean z = (a.ko == 0 || a.kn == 0 || !((PointF) a.kn).equals(((PointF) a.ko).x, ((PointF) a.ko).y)) ? false : true;
            if (hVar.ko != 0 && !z) {
                hVar.path = com.tb.airbnb.lottie.c.f.a((PointF) a.kn, (PointF) a.ko, pointF2, pointF);
            }
            return hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path bF() {
        return this.path;
    }
}
