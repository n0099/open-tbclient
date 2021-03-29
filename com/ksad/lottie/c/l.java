package com.ksad.lottie.c;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.IntRange;
import com.kwai.video.player.KsMediaMeta;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class l implements aj<com.ksad.lottie.model.content.c> {

    /* renamed from: a  reason: collision with root package name */
    public int f31340a;

    public l(int i) {
        this.f31340a = i;
    }

    @IntRange(from = 0, to = KsMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    private int a(double d2, double[] dArr, double[] dArr2) {
        double d3;
        int i = 1;
        while (true) {
            if (i >= dArr.length) {
                d3 = dArr2[dArr2.length - 1];
                break;
            }
            int i2 = i - 1;
            double d4 = dArr[i2];
            double d5 = dArr[i];
            if (dArr[i] >= d2) {
                d3 = com.ksad.lottie.d.e.a(dArr2[i2], dArr2[i], (d2 - d4) / (d5 - d4));
                break;
            }
            i++;
        }
        return (int) (d3 * 255.0d);
    }

    private void a(com.ksad.lottie.model.content.c cVar, List<Float> list) {
        int i = this.f31340a * 4;
        if (list.size() <= i) {
            return;
        }
        int size = (list.size() - i) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                dArr[i2] = list.get(i).floatValue();
            } else {
                dArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        for (int i3 = 0; i3 < cVar.c(); i3++) {
            int i4 = cVar.b()[i3];
            cVar.b()[i3] = Color.argb(a(cVar.a()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public com.ksad.lottie.model.content.c b(JsonReader jsonReader, float f2) {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.f31340a == -1) {
            this.f31340a = arrayList.size() / 4;
        }
        int i = this.f31340a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f31340a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        com.ksad.lottie.model.content.c cVar = new com.ksad.lottie.model.content.c(fArr, iArr);
        a(cVar, arrayList);
        return cVar;
    }
}
