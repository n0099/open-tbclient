package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.a;
import com.tb.airbnb.lottie.model.a.d;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements b {
    private final Path.FillType gV;
    private final boolean hv;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a ktX;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d kuf;
    private final String name;

    private i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.hv = z;
        this.gV = fillType;
        this.ktX = aVar;
        this.kuf = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static i v(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            com.tb.airbnb.lottie.model.a.a d = optJSONObject != null ? a.C0578a.d(optJSONObject, eVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Config.OS);
            return new i(optString, jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, d, optJSONObject2 != null ? d.a.g(optJSONObject2, eVar) : null);
        }
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a cMb() {
        return this.ktX;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d cLz() {
        return this.kuf;
    }

    public Path.FillType cx() {
        return this.gV;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=" + (this.ktX == null ? "null" : Integer.toHexString(this.ktX.ca().intValue())) + ", fillEnabled=" + this.hv + ", opacity=" + (this.kuf == null ? "null" : this.kuf.ca()) + '}';
    }
}
