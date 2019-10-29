package com.tb.airbnb.lottie.model.a;

import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.a;
import com.tb.airbnb.lottie.model.a.b;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {
    @Nullable
    public final com.tb.airbnb.lottie.model.a.a ktX;
    @Nullable
    public final com.tb.airbnb.lottie.model.a.a ktY;
    @Nullable
    public final b ktZ;
    @Nullable
    public final b kua;

    k(@Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.a aVar2, @Nullable b bVar, @Nullable b bVar2) {
        this.ktX = aVar;
        this.ktY = aVar2;
        this.ktZ = bVar;
        this.kua = bVar2;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static k m(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            if (jSONObject == null || !jSONObject.has(Config.APP_VERSION_CODE)) {
                return new k(null, null, null, null);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.APP_VERSION_CODE);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("fc");
            com.tb.airbnb.lottie.model.a.a d = optJSONObject2 != null ? a.C0578a.d(optJSONObject2, eVar) : null;
            JSONObject optJSONObject3 = optJSONObject.optJSONObject(Config.STAT_SDK_CHANNEL);
            com.tb.airbnb.lottie.model.a.a d2 = optJSONObject3 != null ? a.C0578a.d(optJSONObject3, eVar) : null;
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("sw");
            b e = optJSONObject4 != null ? b.a.e(optJSONObject4, eVar) : null;
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("t");
            return new k(d, d2, e, optJSONObject5 != null ? b.a.e(optJSONObject5, eVar) : null);
        }
    }
}
