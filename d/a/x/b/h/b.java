package d.a.x.b.h;

import android.opengl.Matrix;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.x.b.f.c;
import d.a.x.b.f.d;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69005a = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69006a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-607002548, "Ld/a/x/b/h/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-607002548, "Ld/a/x/b/h/b$a;");
                    return;
                }
            }
            int[] iArr = new int[ScaleType.values().length];
            f69006a = iArr;
            try {
                iArr[ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69006a[ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f69006a[ScaleType.CENTER_CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f69006a[ScaleType.EQUAL_SCALE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(8306921, "Ld/a/x/b/h/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(8306921, "Ld/a/x/b/h/b;");
        }
    }

    public static void a(float[] fArr, MirrorType mirrorType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fArr, mirrorType) == null) {
            if (fArr == null) {
                Log.e(f69005a, "mirrorDraw2DMVP mvpMatrix == NULLLLLLL!!!");
            }
            if (mirrorType == MirrorType.HORIZONTALLY) {
                Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            } else if (mirrorType == MirrorType.VERTICALLY) {
                Matrix.rotateM(fArr, 0, 180.0f, 1.0f, 0.0f, 0.0f);
                fArr[6] = 0.0f;
                fArr[9] = 0.0f;
            }
        }
    }

    public static void b(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fArr) == null) {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public static void c(float[] fArr, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65539, null, fArr, f2) == null) {
            if (fArr == null) {
                Log.e(f69005a, "rotateDraw2DMVP mvpMatrix == NULLLLLLL!!!");
            }
            Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        if (r0 > r5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        if (r0 > r5) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
        r5 = r5 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
        r8 = r0 / r5;
        r5 = 1.0f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(float[] fArr, d dVar, c cVar, ScaleType scaleType, float f2) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fArr, dVar, cVar, scaleType, Float.valueOf(f2)}) == null) {
            if (fArr == null) {
                Log.e(f69005a, "scaleDraw2DMVP mvpMatrix == NULLLLLLL!!!");
            } else if (dVar != null && dVar.h() > 0 && dVar.e() > 0) {
                if (cVar != null && cVar.f() > 0 && cVar.e() > 0) {
                    float h2 = (dVar.h() * 1.0f) / dVar.e();
                    float f4 = (cVar.f() * 1.0f) / cVar.e();
                    int i2 = a.f69006a[scaleType.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4) {
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
                Log.e(f69005a, "scaleDraw2DMVP draw target error!!!");
            } else {
                Log.e(f69005a, "scaleDraw2DMVP source texture error!!!");
            }
        }
    }

    public static void e(float[] fArr, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{fArr, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            Matrix.translateM(fArr, 0, f2, f3, 1.0f);
        }
    }
}
