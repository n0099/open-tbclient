package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.c;
import com.tb.airbnb.lottie.model.a.d;
import com.tb.airbnb.lottie.model.a.f;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements b {
    private final List<com.tb.airbnb.lottie.model.a.b> gF;
    private final ShapeStroke.LineCapType ktA;
    private final ShapeStroke.LineJoinType ktB;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ktC;
    private final com.tb.airbnb.lottie.model.a.d kto;
    private final GradientType ktt;
    private final com.tb.airbnb.lottie.model.a.c ktu;
    private final com.tb.airbnb.lottie.model.a.f ktv;
    private final com.tb.airbnb.lottie.model.a.f ktw;
    private final com.tb.airbnb.lottie.model.a.b ktz;
    private final String name;

    private e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.ktt = gradientType;
        this.ktu = cVar;
        this.kto = dVar;
        this.ktv = fVar;
        this.ktw = fVar2;
        this.ktz = bVar;
        this.ktA = lineCapType;
        this.ktB = lineJoinType;
        this.gF = list;
        this.ktC = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cLE() {
        return this.ktt;
    }

    public com.tb.airbnb.lottie.model.a.c cLF() {
        return this.ktu;
    }

    public com.tb.airbnb.lottie.model.a.d cLx() {
        return this.kto;
    }

    public com.tb.airbnb.lottie.model.a.f cLG() {
        return this.ktv;
    }

    public com.tb.airbnb.lottie.model.a.f cLH() {
        return this.ktw;
    }

    public com.tb.airbnb.lottie.model.a.b cLI() {
        return this.ktz;
    }

    public ShapeStroke.LineCapType cLJ() {
        return this.ktA;
    }

    public ShapeStroke.LineJoinType cLK() {
        return this.ktB;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cE() {
        return this.gF;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b cLL() {
        return this.ktC;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static e q(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject(IXAdRequestInfo.GPS);
            if (optJSONObject != null && optJSONObject.has("k")) {
                optJSONObject = optJSONObject.optJSONObject("k");
            }
            com.tb.airbnb.lottie.model.a.c cVar = null;
            if (optJSONObject != null) {
                cVar = c.a.f(optJSONObject, eVar);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Config.OS);
            com.tb.airbnb.lottie.model.a.d dVar = null;
            if (optJSONObject2 != null) {
                dVar = d.a.g(optJSONObject2, eVar);
            }
            GradientType gradientType = jSONObject.optInt("t", 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            com.tb.airbnb.lottie.model.a.f fVar = null;
            if (optJSONObject3 != null) {
                fVar = f.a.i(optJSONObject3, eVar);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            com.tb.airbnb.lottie.model.a.f fVar2 = null;
            if (optJSONObject4 != null) {
                fVar2 = f.a.i(optJSONObject4, eVar);
            }
            com.tb.airbnb.lottie.model.a.b e = b.a.e(jSONObject.optJSONObject("w"), eVar);
            ShapeStroke.LineCapType lineCapType = ShapeStroke.LineCapType.values()[jSONObject.optInt("lc") - 1];
            ShapeStroke.LineJoinType lineJoinType = ShapeStroke.LineJoinType.values()[jSONObject.optInt("lj") - 1];
            com.tb.airbnb.lottie.model.a.b bVar = null;
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                com.tb.airbnb.lottie.model.a.b bVar2 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject5.optString("n");
                    if (optString2.equals(Config.OS)) {
                        bVar2 = b.a.e(optJSONObject5.optJSONObject("v"), eVar);
                    } else if (optString2.equals("d") || optString2.equals(IXAdRequestInfo.GPS)) {
                        arrayList.add(b.a.e(optJSONObject5.optJSONObject("v"), eVar));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                bVar = bVar2;
            }
            return new e(optString, gradientType, cVar, dVar, fVar, fVar2, e, lineCapType, lineJoinType, arrayList, bVar);
        }
    }
}
