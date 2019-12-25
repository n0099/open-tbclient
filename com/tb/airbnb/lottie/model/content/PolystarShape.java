package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.l;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PolystarShape implements b {
    private final Type mNd;
    private final com.tb.airbnb.lottie.model.a.b mOA;
    private final com.tb.airbnb.lottie.model.a.b mOB;
    private final com.tb.airbnb.lottie.model.a.b mOC;
    private final com.tb.airbnb.lottie.model.a.b mOD;
    private final m<PointF, PointF> mOd;
    private final com.tb.airbnb.lottie.model.a.b mOf;
    private final com.tb.airbnb.lottie.model.a.b mOz;
    private final String name;

    /* loaded from: classes2.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        Type(int i) {
            this.value = i;
        }

        static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    private PolystarShape(String str, Type type, com.tb.airbnb.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.b bVar2, com.tb.airbnb.lottie.model.a.b bVar3, com.tb.airbnb.lottie.model.a.b bVar4, com.tb.airbnb.lottie.model.a.b bVar5, com.tb.airbnb.lottie.model.a.b bVar6) {
        this.name = str;
        this.mNd = type;
        this.mOz = bVar;
        this.mOd = mVar;
        this.mOf = bVar2;
        this.mOA = bVar3;
        this.mOB = bVar4;
        this.mOC = bVar5;
        this.mOD = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dBY() {
        return this.mNd;
    }

    public com.tb.airbnb.lottie.model.a.b dBZ() {
        return this.mOz;
    }

    public m<PointF, PointF> dBC() {
        return this.mOd;
    }

    public com.tb.airbnb.lottie.model.a.b dBE() {
        return this.mOf;
    }

    public com.tb.airbnb.lottie.model.a.b dCa() {
        return this.mOA;
    }

    public com.tb.airbnb.lottie.model.a.b dCb() {
        return this.mOB;
    }

    public com.tb.airbnb.lottie.model.a.b dCc() {
        return this.mOC;
    }

    public com.tb.airbnb.lottie.model.a.b dCd() {
        return this.mOD;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new l(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static PolystarShape s(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            com.tb.airbnb.lottie.model.a.b bVar;
            com.tb.airbnb.lottie.model.a.b bVar2;
            String optString = jSONObject.optString("nm");
            Type forValue = Type.forValue(jSONObject.optInt("sy"));
            com.tb.airbnb.lottie.model.a.b a = b.a.a(jSONObject.optJSONObject("pt"), eVar, false);
            m<PointF, PointF> h = com.tb.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar);
            com.tb.airbnb.lottie.model.a.b a2 = b.a.a(jSONObject.optJSONObject("r"), eVar, false);
            com.tb.airbnb.lottie.model.a.b e = b.a.e(jSONObject.optJSONObject("or"), eVar);
            com.tb.airbnb.lottie.model.a.b a3 = b.a.a(jSONObject.optJSONObject("os"), eVar, false);
            if (forValue == Type.Star) {
                bVar2 = b.a.e(jSONObject.optJSONObject("ir"), eVar);
                bVar = b.a.a(jSONObject.optJSONObject("is"), eVar, false);
            } else {
                bVar = null;
                bVar2 = null;
            }
            return new PolystarShape(optString, forValue, a, h, a2, bVar2, e, bVar, a3);
        }
    }
}
