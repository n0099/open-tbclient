package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tb.airbnb.lottie.model.a.l;
import com.tb.airbnb.lottie.model.content.MergePaths;
import com.tb.airbnb.lottie.model.content.PolystarShape;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import com.tb.airbnb.lottie.model.content.a;
import com.tb.airbnb.lottie.model.content.d;
import com.tb.airbnb.lottie.model.content.e;
import com.tb.airbnb.lottie.model.content.f;
import com.tb.airbnb.lottie.model.content.g;
import com.tb.airbnb.lottie.model.content.i;
import com.tb.airbnb.lottie.model.content.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements b {
    private final List<b> items;
    private final String name;

    @Nullable
    public static b w(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
        String optString = jSONObject.optString(Config.EXCEPTION_CRASH_CHANNEL);
        char c = 65535;
        switch (optString.hashCode()) {
            case 3239:
                if (optString.equals("el")) {
                    c = 7;
                    break;
                }
                break;
            case 3270:
                if (optString.equals("fl")) {
                    c = 3;
                    break;
                }
                break;
            case 3295:
                if (optString.equals("gf")) {
                    c = 4;
                    break;
                }
                break;
            case 3307:
                if (optString.equals("gr")) {
                    c = 0;
                    break;
                }
                break;
            case 3308:
                if (optString.equals("gs")) {
                    c = 2;
                    break;
                }
                break;
            case 3488:
                if (optString.equals("mm")) {
                    c = 11;
                    break;
                }
                break;
            case 3633:
                if (optString.equals("rc")) {
                    c = '\b';
                    break;
                }
                break;
            case 3646:
                if (optString.equals("rp")) {
                    c = '\f';
                    break;
                }
                break;
            case 3669:
                if (optString.equals(IXAdRequestInfo.SCREEN_HEIGHT)) {
                    c = 6;
                    break;
                }
                break;
            case 3679:
                if (optString.equals("sr")) {
                    c = '\n';
                    break;
                }
                break;
            case 3681:
                if (optString.equals("st")) {
                    c = 1;
                    break;
                }
                break;
            case 3705:
                if (optString.equals(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                    c = '\t';
                    break;
                }
                break;
            case 3710:
                if (optString.equals("tr")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a.x(jSONObject, eVar);
            case 1:
                return ShapeStroke.a.A(jSONObject, eVar);
            case 2:
                return e.a.q(jSONObject, eVar);
            case 3:
                return i.a.v(jSONObject, eVar);
            case 4:
                return d.a.p(jSONObject, eVar);
            case 5:
                return l.a.n(jSONObject, eVar);
            case 6:
                return k.a.z(jSONObject, eVar);
            case 7:
                return a.C0575a.o(jSONObject, eVar);
            case '\b':
                return f.a.t(jSONObject, eVar);
            case '\t':
                return ShapeTrimPath.a.B(jSONObject, eVar);
            case '\n':
                return PolystarShape.a.s(jSONObject, eVar);
            case 11:
                return MergePaths.a.cx(jSONObject);
            case '\f':
                return g.a.u(jSONObject, eVar);
            default:
                Log.w("LOTTIE", "Unknown shape type " + optString);
                return null;
        }
    }

    public j(String str, List<b> list) {
        this.name = str;
        this.items = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static j x(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AdvanceSetting.NETWORK_TYPE);
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                b w = j.w(optJSONArray.optJSONObject(i), eVar);
                if (w != null) {
                    arrayList.add(w);
                }
            }
            return new j(optString, arrayList);
        }
    }

    public String getName() {
        return this.name;
    }

    public List<b> getItems() {
        return this.items;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.c(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.items.toArray()) + '}';
    }
}
