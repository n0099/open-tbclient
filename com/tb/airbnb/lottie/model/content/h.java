package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.a.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private boolean closed;
    private final List<com.tb.airbnb.lottie.model.c> iF;
    private PointF iG;

    private h(PointF pointF, boolean z, List<com.tb.airbnb.lottie.model.c> list) {
        this.iF = new ArrayList();
        this.iG = pointF;
        this.closed = z;
        this.iF.addAll(list);
    }

    public h() {
        this.iF = new ArrayList();
    }

    private void i(float f, float f2) {
        if (this.iG == null) {
            this.iG = new PointF();
        }
        this.iG.set(f, f2);
    }

    public PointF cW() {
        return this.iG;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.tb.airbnb.lottie.model.c> cX() {
        return this.iF;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.iG == null) {
            this.iG = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (!this.iF.isEmpty() && this.iF.size() != hVar.cX().size() && this.iF.size() != hVar2.cX().size()) {
            throw new IllegalStateException("Curves must have the same number of control points. This: " + cX().size() + "\tShape 1: " + hVar.cX().size() + "\tShape 2: " + hVar2.cX().size());
        }
        if (this.iF.isEmpty()) {
            for (int size = hVar.cX().size() - 1; size >= 0; size--) {
                this.iF.add(new com.tb.airbnb.lottie.model.c());
            }
        }
        PointF cW = hVar.cW();
        PointF cW2 = hVar2.cW();
        i(com.tb.airbnb.lottie.c.e.lerp(cW.x, cW2.x, f), com.tb.airbnb.lottie.c.e.lerp(cW.y, cW2.y, f));
        for (int size2 = this.iF.size() - 1; size2 >= 0; size2--) {
            com.tb.airbnb.lottie.model.c cVar = hVar.cX().get(size2);
            com.tb.airbnb.lottie.model.c cVar2 = hVar2.cX().get(size2);
            PointF cd = cVar.cd();
            PointF ce = cVar.ce();
            PointF cf = cVar.cf();
            PointF cd2 = cVar2.cd();
            PointF ce2 = cVar2.ce();
            PointF cf2 = cVar2.cf();
            this.iF.get(size2).f(com.tb.airbnb.lottie.c.e.lerp(cd.x, cd2.x, f), com.tb.airbnb.lottie.c.e.lerp(cd.y, cd2.y, f));
            this.iF.get(size2).g(com.tb.airbnb.lottie.c.e.lerp(ce.x, ce2.x, f), com.tb.airbnb.lottie.c.e.lerp(ce.y, ce2.y, f));
            this.iF.get(size2).h(com.tb.airbnb.lottie.c.e.lerp(cf.x, cf2.x, f), com.tb.airbnb.lottie.c.e.lerp(cf.y, cf2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.iF.size() + "closed=" + this.closed + '}';
    }

    /* loaded from: classes2.dex */
    public static class a implements m.a<h> {
        public static final a mOI = new a();

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: i */
        public h c(Object obj, float f) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = null;
            if (obj instanceof JSONArray) {
                Object opt = ((JSONArray) obj).opt(0);
                if (!(opt instanceof JSONObject) || !((JSONObject) opt).has("v")) {
                    jSONObject = null;
                } else {
                    jSONObject = (JSONObject) opt;
                }
                jSONObject2 = jSONObject;
            } else if ((obj instanceof JSONObject) && ((JSONObject) obj).has("v")) {
                jSONObject2 = (JSONObject) obj;
            }
            if (jSONObject2 == null) {
                return null;
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("v");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("i");
            JSONArray optJSONArray3 = jSONObject2.optJSONArray(Config.OS);
            boolean optBoolean = jSONObject2.optBoolean("c", false);
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray3 == null || optJSONArray.length() != optJSONArray2.length() || optJSONArray.length() != optJSONArray3.length()) {
                throw new IllegalStateException("Unable to process points array or tangents. " + jSONObject2);
            }
            if (optJSONArray.length() == 0) {
                return new h(new PointF(), false, Collections.emptyList());
            }
            int length = optJSONArray.length();
            PointF b = b(0, optJSONArray);
            b.x *= f;
            b.y *= f;
            ArrayList arrayList = new ArrayList(length);
            for (int i = 1; i < length; i++) {
                PointF b2 = b(i, optJSONArray);
                PointF b3 = b(i - 1, optJSONArray);
                PointF b4 = b(i - 1, optJSONArray3);
                PointF b5 = b(i, optJSONArray2);
                PointF b6 = com.tb.airbnb.lottie.c.e.b(b3, b4);
                PointF b7 = com.tb.airbnb.lottie.c.e.b(b2, b5);
                b6.x *= f;
                b6.y *= f;
                b7.x *= f;
                b7.y *= f;
                b2.x *= f;
                b2.y *= f;
                arrayList.add(new com.tb.airbnb.lottie.model.c(b6, b7, b2));
            }
            if (optBoolean) {
                PointF b8 = b(0, optJSONArray);
                PointF b9 = b(length - 1, optJSONArray);
                PointF b10 = b(length - 1, optJSONArray3);
                PointF b11 = b(0, optJSONArray2);
                PointF b12 = com.tb.airbnb.lottie.c.e.b(b9, b10);
                PointF b13 = com.tb.airbnb.lottie.c.e.b(b8, b11);
                if (f != 1.0f) {
                    b12.x *= f;
                    b12.y *= f;
                    b13.x *= f;
                    b13.y *= f;
                    b8.x *= f;
                    b8.y *= f;
                }
                arrayList.add(new com.tb.airbnb.lottie.model.c(b12, b13, b8));
            }
            return new h(b, optBoolean, arrayList);
        }

        private static PointF b(int i, JSONArray jSONArray) {
            if (i >= jSONArray.length()) {
                throw new IllegalArgumentException("Invalid index " + i + ". There are only " + jSONArray.length() + " points.");
            }
            JSONArray optJSONArray = jSONArray.optJSONArray(i);
            Object opt = optJSONArray.opt(0);
            Object opt2 = optJSONArray.opt(1);
            return new PointF(opt instanceof Double ? ((Double) opt).floatValue() : ((Integer) opt).intValue(), opt2 instanceof Double ? ((Double) opt2).floatValue() : ((Integer) opt2).intValue());
        }
    }
}
