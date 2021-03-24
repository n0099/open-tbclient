package d.b.h0.r.u.d;

import android.graphics.Path;
import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class a {
    public static Path a(RectF rectF, float[] fArr) {
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        return path;
    }

    public static float[] b(float f2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f2);
        return fArr;
    }
}
