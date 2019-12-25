package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.a;
import com.tb.airbnb.lottie.model.a.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i implements b {
    private final Path.FillType hW;
    private final boolean iH;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a mNY;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d mOg;
    private final String name;

    private i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.iH = z;
        this.hW = fillType;
        this.mNY = aVar;
        this.mOg = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static i v(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            com.tb.airbnb.lottie.model.a.a d = optJSONObject != null ? a.C0688a.d(optJSONObject, eVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Config.OS);
            return new i(optString, jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, d, optJSONObject2 != null ? d.a.g(optJSONObject2, eVar) : null);
        }
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dCi() {
        return this.mNY;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dBF() {
        return this.mOg;
    }

    public Path.FillType cz() {
        return this.hW;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=" + (this.mNY == null ? "null" : Integer.toHexString(this.mNY.dBs().intValue())) + ", fillEnabled=" + this.iH + ", opacity=" + (this.mOg == null ? "null" : this.mOg.dBs()) + '}';
    }
}
