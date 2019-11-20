package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.l;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.tb.airbnb.lottie.model.a.b ktM;
    private final com.tb.airbnb.lottie.model.a.b ktN;
    private final l ktO;
    private final String name;

    g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.ktM = bVar;
        this.ktN = bVar2;
        this.ktO = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b cLW() {
        return this.ktM;
    }

    public com.tb.airbnb.lottie.model.a.b cLX() {
        return this.ktN;
    }

    public l cLY() {
        return this.ktO;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g u(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            return new g(jSONObject.optString("nm"), b.a.a(jSONObject.optJSONObject("c"), eVar, false), b.a.a(jSONObject.optJSONObject(Config.OS), eVar, false), l.a.n(jSONObject.optJSONObject("tr"), eVar));
        }
    }
}
