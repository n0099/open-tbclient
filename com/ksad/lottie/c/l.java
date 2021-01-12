package com.ksad.lottie.c;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.IntRange;
import com.kwai.video.player.KsMediaMeta;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class l implements aj<com.ksad.lottie.model.content.c> {

    /* renamed from: a  reason: collision with root package name */
    private int f7974a;

    public l(int i) {
        this.f7974a = i;
    }

    @IntRange(from = 0, to = KsMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    private int a(double d, double[] dArr, double[] dArr2) {
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return (int) (dArr2[dArr2.length - 1] * 255.0d);
            }
            double d2 = dArr[i2 - 1];
            double d3 = dArr[i2];
            if (dArr[i2] >= d) {
                return (int) (com.ksad.lottie.d.e.a(dArr2[i2 - 1], dArr2[i2], (d - d2) / (d3 - d2)) * 255.0d);
            }
            i = i2 + 1;
        }
    }

    private void a(com.ksad.lottie.model.content.c cVar, List<Float> list) {
        int i;
        int i2 = this.f7974a * 4;
        if (list.size() <= i2) {
            return;
        }
        int size = (list.size() - i2) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i3 = 0;
        int i4 = i2;
        while (i4 < list.size()) {
            if (i4 % 2 == 0) {
                dArr[i3] = list.get(i4).floatValue();
                i = i3;
            } else {
                dArr2[i3] = list.get(i4).floatValue();
                i = i3 + 1;
            }
            i4++;
            i3 = i;
        }
        for (int i5 = 0; i5 < cVar.c(); i5++) {
            int i6 = cVar.b()[i5];
            cVar.b()[i5] = Color.argb(a(cVar.a()[i5], dArr, dArr2), Color.red(i6), Color.green(i6), Color.blue(i6));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public com.ksad.lottie.model.content.c b(JsonReader jsonReader, float f) {
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
        if (this.f7974a == -1) {
            this.f7974a = arrayList.size() / 4;
        }
        float[] fArr = new float[this.f7974a];
        int[] iArr = new int[this.f7974a];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7974a * 4; i3++) {
            int i4 = i3 / 4;
            double floatValue = arrayList.get(i3).floatValue();
            switch (i3 % 4) {
                case 0:
                    fArr[i4] = (float) floatValue;
                    break;
                case 1:
                    i2 = (int) (floatValue * 255.0d);
                    break;
                case 2:
                    i = (int) (floatValue * 255.0d);
                    break;
                case 3:
                    iArr[i4] = Color.argb(255, i2, i, (int) (floatValue * 255.0d));
                    break;
            }
        }
        com.ksad.lottie.model.content.c cVar = new com.ksad.lottie.model.content.c(fArr, iArr);
        a(cVar, arrayList);
        return cVar;
    }
}
