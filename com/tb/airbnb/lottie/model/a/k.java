package com.tb.airbnb.lottie.model.a;

import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.a;
import com.tb.airbnb.lottie.model.a.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    @Nullable
    public final com.tb.airbnb.lottie.model.a.a mNY;
    @Nullable
    public final com.tb.airbnb.lottie.model.a.a mNZ;
    @Nullable
    public final b mOa;
    @Nullable
    public final b mOb;

    k(@Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.a aVar2, @Nullable b bVar, @Nullable b bVar2) {
        this.mNY = aVar;
        this.mNZ = aVar2;
        this.mOa = bVar;
        this.mOb = bVar2;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static k m(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            if (jSONObject == null || !jSONObject.has(Config.APP_VERSION_CODE)) {
                return new k(null, null, null, null);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.APP_VERSION_CODE);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("fc");
            com.tb.airbnb.lottie.model.a.a d = optJSONObject2 != null ? a.C0688a.d(optJSONObject2, eVar) : null;
            JSONObject optJSONObject3 = optJSONObject.optJSONObject(Config.STAT_SDK_CHANNEL);
            com.tb.airbnb.lottie.model.a.a d2 = optJSONObject3 != null ? a.C0688a.d(optJSONObject3, eVar) : null;
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("sw");
            b e = optJSONObject4 != null ? b.a.e(optJSONObject4, eVar) : null;
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("t");
            return new k(d, d2, e, optJSONObject5 != null ? b.a.e(optJSONObject5, eVar) : null);
        }
    }
}
