package com.tb.airbnb.lottie.model.content;

import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.d;
import com.tb.airbnb.lottie.model.a.h;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d kuf;
    private final MaskMode kuu;
    private final com.tb.airbnb.lottie.model.a.h kuv;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect,
        MaskModeUnknown
    }

    private Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.kuu = maskMode;
        this.kuv = hVar;
        this.kuf = dVar;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static Mask r(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            MaskMode maskMode;
            String optString = jSONObject.optString("mode");
            char c = 65535;
            switch (optString.hashCode()) {
                case 97:
                    if (optString.equals(Config.APP_VERSION_CODE)) {
                        c = 0;
                        break;
                    }
                    break;
                case 105:
                    if (optString.equals("i")) {
                        c = 2;
                        break;
                    }
                    break;
                case 115:
                    if (optString.equals("s")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    maskMode = MaskMode.MaskModeAdd;
                    break;
                case 1:
                    maskMode = MaskMode.MaskModeSubtract;
                    break;
                case 2:
                    maskMode = MaskMode.MaskModeIntersect;
                    break;
                default:
                    maskMode = MaskMode.MaskModeUnknown;
                    break;
            }
            return new Mask(maskMode, h.a.k(jSONObject.optJSONObject("pt"), eVar), d.a.g(jSONObject.optJSONObject(Config.OS), eVar));
        }
    }

    public MaskMode cLO() {
        return this.kuu;
    }

    public com.tb.airbnb.lottie.model.a.h cLP() {
        return this.kuv;
    }

    public com.tb.airbnb.lottie.model.a.d cLz() {
        return this.kuf;
    }
}
