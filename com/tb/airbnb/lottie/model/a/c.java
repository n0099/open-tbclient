package com.tb.airbnb.lottie.model.a;

import android.graphics.Color;
import android.support.annotation.IntRange;
import android.util.Log;
import com.tb.airbnb.lottie.model.a.m;
import com.tb.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public class c extends o<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> {
    private c(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.c>> list, com.tb.airbnb.lottie.model.content.c cVar) {
        super(list, cVar);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> cLl() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.fg) : new com.tb.airbnb.lottie.a.b.d(this.eR);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static c f(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a cLC = n.a(jSONObject, 1.0f, eVar, new b(jSONObject.optInt("p", jSONObject.optJSONArray("k").length() / 4))).cLC();
            return new c(cLC.eR, (com.tb.airbnb.lottie.model.content.c) cLC.fg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements m.a<com.tb.airbnb.lottie.model.content.c> {
        private final int fW;

        private b(int i) {
            this.fW = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.tb.airbnb.lottie.model.a.m.a
        /* renamed from: k */
        public com.tb.airbnb.lottie.model.content.c b(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            float[] fArr = new float[this.fW];
            int[] iArr = new int[this.fW];
            com.tb.airbnb.lottie.model.content.c cVar = new com.tb.airbnb.lottie.model.content.c(fArr, iArr);
            if (jSONArray.length() != this.fW * 4) {
                Log.w("LOTTIE", "Unexpected gradient length: " + jSONArray.length() + ". Expected " + (this.fW * 4) + ". This may affect the appearance of the gradient. Make sure to save your After Effects file before exporting an animation with gradients.");
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.fW * 4; i3++) {
                int i4 = i3 / 4;
                double optDouble = jSONArray.optDouble(i3);
                switch (i3 % 4) {
                    case 0:
                        fArr[i4] = (float) optDouble;
                        break;
                    case 1:
                        i2 = (int) (optDouble * 255.0d);
                        break;
                    case 2:
                        i = (int) (optDouble * 255.0d);
                        break;
                    case 3:
                        iArr[i4] = Color.argb(255, i2, i, (int) (optDouble * 255.0d));
                        break;
                }
            }
            a(cVar, jSONArray);
            return cVar;
        }

        private void a(com.tb.airbnb.lottie.model.content.c cVar, JSONArray jSONArray) {
            int i = this.fW * 4;
            if (jSONArray.length() > i) {
                int length = (jSONArray.length() - i) / 2;
                double[] dArr = new double[length];
                double[] dArr2 = new double[length];
                int i2 = 0;
                for (int i3 = i; i3 < jSONArray.length(); i3++) {
                    if (i3 % 2 == 0) {
                        dArr[i2] = jSONArray.optDouble(i3);
                    } else {
                        dArr2[i2] = jSONArray.optDouble(i3);
                        i2++;
                    }
                }
                for (int i4 = 0; i4 < cVar.getSize(); i4++) {
                    int i5 = cVar.getColors()[i4];
                    cVar.getColors()[i4] = Color.argb(a(cVar.cv()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
                }
            }
        }

        @IntRange(from = 0, to = IjkMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
        private int a(double d, double[] dArr, double[] dArr2) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 < dArr.length) {
                    double d2 = dArr[i2 - 1];
                    double d3 = dArr[i2];
                    if (dArr[i2] < d) {
                        i = i2 + 1;
                    } else {
                        return (int) (com.tb.airbnb.lottie.c.e.b(dArr2[i2 - 1], dArr2[i2], (d - d2) / (d3 - d2)) * 255.0d);
                    }
                } else {
                    return (int) (dArr2[dArr2.length - 1] * 255.0d);
                }
            }
        }
    }
}
