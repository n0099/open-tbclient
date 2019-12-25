package com.tb.airbnb.lottie.model.content;

import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.a.a.q;
import com.tb.airbnb.lottie.model.a.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShapeTrimPath implements b {
    private final Type mNr;
    private final com.tb.airbnb.lottie.model.a.b mOG;
    private final com.tb.airbnb.lottie.model.a.b mOK;
    private final com.tb.airbnb.lottie.model.a.b mOL;
    private final String name;

    /* loaded from: classes2.dex */
    public enum Type {
        Simultaneously,
        Individually;

        static Type forId(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    throw new IllegalArgumentException("Unknown trim path type " + i);
            }
        }
    }

    private ShapeTrimPath(String str, Type type, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, com.tb.airbnb.lottie.model.a.b bVar3) {
        this.name = str;
        this.mNr = type;
        this.mOK = bVar;
        this.mOL = bVar2;
        this.mOG = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dBh() {
        return this.mNr;
    }

    public com.tb.airbnb.lottie.model.a.b dCk() {
        return this.mOL;
    }

    public com.tb.airbnb.lottie.model.a.b dCl() {
        return this.mOK;
    }

    public com.tb.airbnb.lottie.model.a.b dCg() {
        return this.mOG;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.mOK + ", end: " + this.mOL + ", offset: " + this.mOG + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ShapeTrimPath B(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return new ShapeTrimPath(jSONObject.optString("nm"), Type.forId(jSONObject.optInt("m", 1)), b.a.a(jSONObject.optJSONObject("s"), eVar, false), b.a.a(jSONObject.optJSONObject("e"), eVar, false), b.a.a(jSONObject.optJSONObject(Config.OS), eVar, false));
        }
    }
}
