package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.c;
import com.tb.airbnb.lottie.model.a.d;
import com.tb.airbnb.lottie.model.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements b {
    private final Path.FillType hW;
    private final com.tb.airbnb.lottie.model.a.d mOg;
    private final GradientType mOm;
    private final com.tb.airbnb.lottie.model.a.c mOn;
    private final com.tb.airbnb.lottie.model.a.f mOo;
    private final com.tb.airbnb.lottie.model.a.f mOp;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mOq;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mOr;
    private final String name;

    private d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.mOm = gradientType;
        this.hW = fillType;
        this.mOn = cVar;
        this.mOg = dVar;
        this.mOo = fVar;
        this.mOp = fVar2;
        this.name = str;
        this.mOq = bVar;
        this.mOr = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dBN() {
        return this.mOm;
    }

    public Path.FillType cz() {
        return this.hW;
    }

    public com.tb.airbnb.lottie.model.a.c dBO() {
        return this.mOn;
    }

    public com.tb.airbnb.lottie.model.a.d dBF() {
        return this.mOg;
    }

    public com.tb.airbnb.lottie.model.a.f dBP() {
        return this.mOo;
    }

    public com.tb.airbnb.lottie.model.a.f dBQ() {
        return this.mOp;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static d p(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has("k")) {
                int optInt = optJSONObject.optInt("p");
                optJSONObject = optJSONObject.optJSONObject("k");
                try {
                    optJSONObject.put("p", optInt);
                } catch (JSONException e) {
                }
            }
            com.tb.airbnb.lottie.model.a.c f = optJSONObject != null ? c.a.f(optJSONObject, eVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Config.OS);
            com.tb.airbnb.lottie.model.a.d g = optJSONObject2 != null ? d.a.g(optJSONObject2, eVar) : null;
            Path.FillType fillType = jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            GradientType gradientType = jSONObject.optInt("t", 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            com.tb.airbnb.lottie.model.a.f i = optJSONObject3 != null ? f.a.i(optJSONObject3, eVar) : null;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            return new d(optString, gradientType, fillType, f, g, i, optJSONObject4 != null ? f.a.i(optJSONObject4, eVar) : null, null, null);
        }
    }
}
