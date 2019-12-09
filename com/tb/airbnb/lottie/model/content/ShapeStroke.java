package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.a.a.p;
import com.tb.airbnb.lottie.model.a.a;
import com.tb.airbnb.lottie.model.a.b;
import com.tb.airbnb.lottie.model.a.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final List<com.tb.airbnb.lottie.model.a.b> gF;
    private final LineCapType ktA;
    private final LineJoinType ktB;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ktN;
    private final com.tb.airbnb.lottie.model.a.a ktg;
    private final com.tb.airbnb.lottie.model.a.d kto;
    private final com.tb.airbnb.lottie.model.a.b ktz;
    private final String name;

    /* loaded from: classes6.dex */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            switch (this) {
                case Butt:
                    return Paint.Cap.BUTT;
                case Round:
                    return Paint.Cap.ROUND;
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            switch (this) {
                case Bevel:
                    return Paint.Join.BEVEL;
                case Miter:
                    return Paint.Join.MITER;
                case Round:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    private ShapeStroke(String str, @Nullable com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.a aVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType) {
        this.name = str;
        this.ktN = bVar;
        this.gF = list;
        this.ktg = aVar;
        this.kto = dVar;
        this.ktz = bVar2;
        this.ktA = lineCapType;
        this.ktB = lineJoinType;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ShapeStroke A(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            com.tb.airbnb.lottie.model.a.a d = a.C0573a.d(jSONObject.optJSONObject("c"), eVar);
            com.tb.airbnb.lottie.model.a.b e = b.a.e(jSONObject.optJSONObject("w"), eVar);
            com.tb.airbnb.lottie.model.a.d g = d.a.g(jSONObject.optJSONObject(Config.OS), eVar);
            LineCapType lineCapType = LineCapType.values()[jSONObject.optInt("lc") - 1];
            LineJoinType lineJoinType = LineJoinType.values()[jSONObject.optInt("lj") - 1];
            com.tb.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                com.tb.airbnb.lottie.model.a.b bVar2 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject.optString("n");
                    if (optString2.equals(Config.OS)) {
                        bVar2 = b.a.e(optJSONObject.optJSONObject("v"), eVar);
                    } else if (optString2.equals("d") || optString2.equals("g")) {
                        arrayList.add(b.a.e(optJSONObject.optJSONObject("v"), eVar));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                bVar = bVar2;
            }
            return new ShapeStroke(optString, bVar, arrayList, d, g, e, lineCapType, lineJoinType);
        }
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a cLZ() {
        return this.ktg;
    }

    public com.tb.airbnb.lottie.model.a.d cLx() {
        return this.kto;
    }

    public com.tb.airbnb.lottie.model.a.b cLI() {
        return this.ktz;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cE() {
        return this.gF;
    }

    public com.tb.airbnb.lottie.model.a.b cLL() {
        return this.ktN;
    }

    public LineCapType cLJ() {
        return this.ktA;
    }

    public LineJoinType cLK() {
        return this.ktB;
    }
}
