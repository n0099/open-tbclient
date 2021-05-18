package d.a.k0.v3.u.n.c;

import android.graphics.PointF;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class a {
    public static float a(float f2, float f3, float f4, float f5) {
        return (float) Math.sqrt(Math.pow(f2 - f4, 2.0d) + Math.pow(f3 - f5, 2.0d));
    }

    public static PointF b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return null;
        }
        PointF pointF = new PointF();
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
        return pointF;
    }

    public static float c(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }

    public static float d(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public static boolean e(float[] fArr, float f2, float f3) {
        if (fArr != null && fArr.length == 8) {
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            float f7 = fArr[3];
            float f8 = fArr[4];
            float f9 = fArr[5];
            float f10 = fArr[6];
            float f11 = fArr[7];
            float a2 = a(f4, f5, f6, f7);
            float f12 = f(f4, f5, f6, f7, f2, f3);
            float a3 = a(f6, f7, f10, f11);
            float f13 = f(f6, f7, f10, f11, f2, f3);
            float f14 = f(f10, f11, f8, f9, f2, f3);
            float f15 = f(f8, f9, f4, f5, f2, f3);
            if (a2 > 0.0f && a3 > 0.0f && f12 <= a3 && f14 <= a3 && f13 <= a2 && f15 <= a2) {
                return true;
            }
        }
        return false;
    }

    public static float f(float f2, float f3, float f4, float f5, float f6, float f7) {
        float a2 = a(f2, f3, f4, f5);
        float a3 = a(f2, f3, f6, f7);
        float a4 = a(f4, f5, f6, f7);
        if (a2 == 0.0f) {
            return a3;
        }
        if (a3 == 0.0f || a4 == 0.0f) {
            return 0.0f;
        }
        float f8 = ((a2 + a3) + a4) / 2.0f;
        return (((float) Math.sqrt((((f8 - a2) * f8) * (f8 - a3)) * (f8 - a4))) * 2.0f) / a2;
    }
}
