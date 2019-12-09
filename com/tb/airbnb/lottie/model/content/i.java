package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.a;
import com.tb.airbnb.lottie.model.a.d;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements b {
    private final boolean gV;
    private final Path.FillType gw;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a ktg;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d kto;
    private final String name;

    private i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.gV = z;
        this.gw = fillType;
        this.ktg = aVar;
        this.kto = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static i v(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            com.tb.airbnb.lottie.model.a.a d = optJSONObject != null ? a.C0573a.d(optJSONObject, eVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Config.OS);
            return new i(optString, jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, d, optJSONObject2 != null ? d.a.g(optJSONObject2, eVar) : null);
        }
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a cLZ() {
        return this.ktg;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d cLx() {
        return this.kto;
    }

    public Path.FillType cx() {
        return this.gw;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=" + (this.ktg == null ? "null" : Integer.toHexString(this.ktg.ca().intValue())) + ", fillEnabled=" + this.gV + ", opacity=" + (this.kto == null ? "null" : this.kto.ca()) + '}';
    }
}
