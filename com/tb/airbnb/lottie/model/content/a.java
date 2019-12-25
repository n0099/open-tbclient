package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.f;
import com.tb.airbnb.lottie.model.a.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements b {
    private final boolean hS;
    private final m<PointF, PointF> mOd;
    private final com.tb.airbnb.lottie.model.a.f mOl;
    private final String name;

    private a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.mOd = mVar;
        this.mOl = fVar;
        this.hS = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tb.airbnb.lottie.model.content.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0690a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static a o(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return new a(jSONObject.optString("nm"), com.tb.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar), f.a.i(jSONObject.optJSONObject("s"), eVar), jSONObject.optInt("d", 2) == 3);
        }
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> dBC() {
        return this.mOd;
    }

    public com.tb.airbnb.lottie.model.a.f dBM() {
        return this.mOl;
    }

    public boolean isReversed() {
        return this.hS;
    }
}
