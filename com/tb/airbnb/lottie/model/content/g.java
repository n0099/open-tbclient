package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.l;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements b {
    private final com.tb.airbnb.lottie.model.a.b mOF;
    private final com.tb.airbnb.lottie.model.a.b mOG;
    private final l mOH;
    private final String name;

    g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.mOF = bVar;
        this.mOG = bVar2;
        this.mOH = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dCf() {
        return this.mOF;
    }

    public com.tb.airbnb.lottie.model.a.b dCg() {
        return this.mOG;
    }

    public l dCh() {
        return this.mOH;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g u(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return new g(jSONObject.optString("nm"), b.a.a(jSONObject.optJSONObject("c"), eVar, false), b.a.a(jSONObject.optJSONObject(Config.OS), eVar, false), l.a.n(jSONObject.optJSONObject("tr"), eVar));
        }
    }
}
