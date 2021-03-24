package d.b.u.b.h;

import android.opengl.Matrix;
import android.util.Log;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
import d.b.u.b.f.c;
import d.b.u.b.f.d;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f64723a = "b";

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64724a;

        static {
            int[] iArr = new int[ScaleType.values().length];
            f64724a = iArr;
            try {
                iArr[ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64724a[ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64724a[ScaleType.CENTER_CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f64724a[ScaleType.EQUAL_SCALE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(float[] fArr, MirrorType mirrorType) {
        if (fArr == null) {
            Log.e(f64723a, "mirrorDraw2DMVP mvpMatrix == NULLLLLLL!!!");
        }
        if (mirrorType == MirrorType.HORIZONTALLY) {
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        } else if (mirrorType == MirrorType.VERTICALLY) {
            Matrix.rotateM(fArr, 0, 180.0f, 1.0f, 0.0f, 0.0f);
            fArr[6] = 0.0f;
            fArr[9] = 0.0f;
        }
    }

    public static void b(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }

    public static void c(float[] fArr, float f2) {
        if (fArr == null) {
            Log.e(f64723a, "rotateDraw2DMVP mvpMatrix == NULLLLLLL!!!");
        }
        Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        if (r0 > r3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
        if (r0 > r3) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
        r3 = r3 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
        r6 = r0 / r3;
        r3 = 1.0f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(float[] fArr, d dVar, c cVar, ScaleType scaleType, float f2) {
        float f3;
        if (fArr == null) {
            Log.e(f64723a, "scaleDraw2DMVP mvpMatrix == NULLLLLLL!!!");
        } else if (dVar != null && dVar.f() > 0 && dVar.c() > 0) {
            if (cVar != null && cVar.d() > 0 && cVar.c() > 0) {
                float f4 = (dVar.f() * 1.0f) / dVar.c();
                float d2 = (cVar.d() * 1.0f) / cVar.c();
                int i = a.f64724a[scaleType.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                f3 = f2;
                            }
                        }
                    }
                    Matrix.scaleM(fArr, 0, f2, f3, 1.0f);
                    return;
                }
                f3 = 1.0f;
                f2 = 1.0f;
                Matrix.scaleM(fArr, 0, f2, f3, 1.0f);
                return;
            }
            Log.e(f64723a, "scaleDraw2DMVP draw target error!!!");
        } else {
            Log.e(f64723a, "scaleDraw2DMVP source texture error!!!");
        }
    }

    public static void e(float[] fArr, float f2, float f3) {
        Matrix.translateM(fArr, 0, f2, f3, 1.0f);
    }
}
