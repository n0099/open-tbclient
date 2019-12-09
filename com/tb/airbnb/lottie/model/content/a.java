package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.f;
import com.tb.airbnb.lottie.model.a.m;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements b {
    private final boolean gs;
    private final m<PointF, PointF> ktl;
    private final com.tb.airbnb.lottie.model.a.f kts;
    private final String name;

    private a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.ktl = mVar;
        this.kts = fVar;
        this.gs = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tb.airbnb.lottie.model.content.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0575a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static a o(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return new a(jSONObject.optString("nm"), com.tb.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar), f.a.i(jSONObject.optJSONObject("s"), eVar), jSONObject.optInt("d", 2) == 3);
        }
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> cLu() {
        return this.ktl;
    }

    public com.tb.airbnb.lottie.model.a.f cLD() {
        return this.kts;
    }

    public boolean isReversed() {
        return this.gs;
    }
}
