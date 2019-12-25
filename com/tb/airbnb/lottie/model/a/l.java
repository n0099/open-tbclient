package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.a.b.p;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.d;
import com.tb.airbnb.lottie.model.a.g;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e mOc;
    private final m<PointF, PointF> mOd;
    private final g mOe;
    private final b mOf;
    private final d mOg;
    @Nullable
    private final b mOh;
    @Nullable
    private final b mOi;

    private l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.mOc = eVar;
        this.mOd = mVar;
        this.mOe = gVar;
        this.mOf = bVar;
        this.mOg = dVar;
        this.mOh = bVar2;
        this.mOi = bVar3;
    }

    public e dBB() {
        return this.mOc;
    }

    public m<PointF, PointF> dBC() {
        return this.mOd;
    }

    public g dBD() {
        return this.mOe;
    }

    public b dBE() {
        return this.mOf;
    }

    public d dBF() {
        return this.mOg;
    }

    @Nullable
    public b dBG() {
        return this.mOh;
    }

    @Nullable
    public b dBH() {
        return this.mOi;
    }

    public p dBI() {
        return new p(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static l dBJ() {
            return new l(new e(), new e(), g.a.dBy(), b.a.dBt(), d.a.dBv(), b.a.dBt(), b.a.dBt());
        }

        public static l n(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            e eVar2;
            m<PointF, PointF> mVar;
            g gVar;
            b bVar;
            d dVar;
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.APP_VERSION_CODE);
            if (optJSONObject != null) {
                eVar2 = new e(optJSONObject.opt("k"), eVar);
            } else {
                Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
                eVar2 = new e();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("p");
            if (optJSONObject2 != null) {
                mVar = e.h(optJSONObject2, eVar);
            } else {
                QB("position");
                mVar = null;
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            if (optJSONObject3 != null) {
                gVar = g.a.j(optJSONObject3, eVar);
            } else {
                gVar = new g(Collections.emptyList(), new com.tb.airbnb.lottie.model.k());
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("r");
            if (optJSONObject4 == null) {
                optJSONObject4 = jSONObject.optJSONObject("rz");
            }
            if (optJSONObject4 != null) {
                bVar = b.a.a(optJSONObject4, eVar, false);
            } else {
                QB("rotation");
                bVar = null;
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject(Config.OS);
            if (optJSONObject5 != null) {
                dVar = d.a.g(optJSONObject5, eVar);
            } else {
                dVar = new d(Collections.emptyList(), 100);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("so");
            b a = optJSONObject6 != null ? b.a.a(optJSONObject6, eVar, false) : null;
            JSONObject optJSONObject7 = jSONObject.optJSONObject("eo");
            return new l(eVar2, mVar, gVar, bVar, dVar, a, optJSONObject7 != null ? b.a.a(optJSONObject7, eVar, false) : null);
        }

        private static void QB(String str) {
            throw new IllegalArgumentException("Missing transform for " + str);
        }
    }
}
