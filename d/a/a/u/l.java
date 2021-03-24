package d.a.a.u;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.IntRange;
import com.kwai.video.player.KsMediaMeta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l implements j0<d.a.a.s.j.c> {

    /* renamed from: a  reason: collision with root package name */
    public int f41430a;

    public l(int i) {
        this.f41430a = i;
    }

    public final void b(d.a.a.s.j.c cVar, List<Float> list) {
        int i = this.f41430a * 4;
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
            int i4 = cVar.a()[i3];
            cVar.a()[i3] = Color.argb(c(cVar.b()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    @IntRange(from = 0, to = KsMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    public final int c(double d2, double[] dArr, double[] dArr2) {
        double d3;
        int i = 1;
        while (true) {
            if (i < dArr.length) {
                int i2 = i - 1;
                double d4 = dArr[i2];
                double d5 = dArr[i];
                if (dArr[i] >= d2) {
                    d3 = d.a.a.v.e.i(dArr2[i2], dArr2[i], (d2 - d4) / (d5 - d4));
                    break;
                }
                i++;
            } else {
                d3 = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (d3 * 255.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.u.j0
    /* renamed from: d */
    public d.a.a.s.j.c a(JsonReader jsonReader, float f2) throws IOException {
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
        if (this.f41430a == -1) {
            this.f41430a = arrayList.size() / 4;
        }
        int i = this.f41430a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f41430a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                Double.isNaN(floatValue);
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                Double.isNaN(floatValue);
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                Double.isNaN(floatValue);
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        d.a.a.s.j.c cVar = new d.a.a.s.j.c(fArr, iArr);
        b(cVar, arrayList);
        return cVar;
    }
}
