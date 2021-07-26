package d.a.q0.t.a.k.a;

import android.graphics.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.advert.sdk.widget.scalablevideoview.PivotPoint;
import com.baidu.tieba.advert.sdk.widget.scalablevideoview.ScalableType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f62933a;

    /* renamed from: b  reason: collision with root package name */
    public b f62934b;

    /* renamed from: d.a.q0.t.a.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1644a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62935a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f62936b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1569769571, "Ld/a/q0/t/a/k/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1569769571, "Ld/a/q0/t/a/k/a/a$a;");
                    return;
                }
            }
            int[] iArr = new int[PivotPoint.values().length];
            f62936b = iArr;
            try {
                iArr[PivotPoint.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f62936b[PivotPoint.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f62936b[PivotPoint.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f62936b[PivotPoint.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f62936b[PivotPoint.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f62936b[PivotPoint.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f62936b[PivotPoint.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f62936b[PivotPoint.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f62936b[PivotPoint.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[ScalableType.values().length];
            f62935a = iArr2;
            try {
                iArr2[ScalableType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f62935a[ScalableType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f62935a[ScalableType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f62935a[ScalableType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f62935a[ScalableType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f62935a[ScalableType.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f62935a[ScalableType.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f62935a[ScalableType.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f62935a[ScalableType.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f62935a[ScalableType.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f62935a[ScalableType.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f62935a[ScalableType.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f62935a[ScalableType.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f62935a[ScalableType.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f62935a[ScalableType.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f62935a[ScalableType.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f62935a[ScalableType.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f62935a[ScalableType.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f62935a[ScalableType.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f62935a[ScalableType.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f62935a[ScalableType.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f62935a[ScalableType.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f62935a[ScalableType.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f62935a[ScalableType.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f62935a[ScalableType.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f62935a[ScalableType.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    public a(b bVar, b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62933a = bVar;
        this.f62934b = bVar2;
    }

    public final Matrix a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f62934b.a() <= this.f62933a.b() && this.f62934b.a() <= this.f62933a.a()) {
                return l(PivotPoint.CENTER);
            }
            return c();
        }
        return (Matrix) invokeV.objValue;
    }

    public final Matrix b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f62934b.a() <= this.f62933a.b() && this.f62934b.a() <= this.f62933a.a()) {
                return l(PivotPoint.RIGHT_BOTTOM);
            }
            return d();
        }
        return (Matrix) invokeV.objValue;
    }

    public final Matrix c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? h(PivotPoint.CENTER) : (Matrix) invokeV.objValue;
    }

    public final Matrix d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h(PivotPoint.RIGHT_BOTTOM) : (Matrix) invokeV.objValue;
    }

    public final Matrix e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(PivotPoint.LEFT_TOP) : (Matrix) invokeV.objValue;
    }

    public final Matrix f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? j(1.0f, 1.0f, PivotPoint.LEFT_TOP) : (Matrix) invokeV.objValue;
    }

    public final Matrix g(PivotPoint pivotPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pivotPoint)) == null) {
            float b2 = this.f62933a.b() / this.f62934b.b();
            float a2 = this.f62933a.a() / this.f62934b.a();
            float max = Math.max(b2, a2);
            return j(max / b2, max / a2, pivotPoint);
        }
        return (Matrix) invokeL.objValue;
    }

    public final Matrix h(PivotPoint pivotPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pivotPoint)) == null) {
            float b2 = this.f62933a.b() / this.f62934b.b();
            float a2 = this.f62933a.a() / this.f62934b.a();
            float min = Math.min(b2, a2);
            return j(min / b2, min / a2, pivotPoint);
        }
        return (Matrix) invokeL.objValue;
    }

    public final Matrix i(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            Matrix matrix = new Matrix();
            matrix.setScale(f2, f3, f4, f5);
            return matrix;
        }
        return (Matrix) invokeCommon.objValue;
    }

    public final Matrix j(float f2, float f3, PivotPoint pivotPoint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), pivotPoint})) == null) {
            switch (C1644a.f62936b[pivotPoint.ordinal()]) {
                case 1:
                    return i(f2, f3, 0.0f, 0.0f);
                case 2:
                    return i(f2, f3, 0.0f, this.f62933a.a() / 2.0f);
                case 3:
                    return i(f2, f3, 0.0f, this.f62933a.a());
                case 4:
                    return i(f2, f3, this.f62933a.b() / 2.0f, 0.0f);
                case 5:
                    return i(f2, f3, this.f62933a.b() / 2.0f, this.f62933a.a() / 2.0f);
                case 6:
                    return i(f2, f3, this.f62933a.b() / 2.0f, this.f62933a.a());
                case 7:
                    return i(f2, f3, this.f62933a.b(), 0.0f);
                case 8:
                    return i(f2, f3, this.f62933a.b(), this.f62933a.a() / 2.0f);
                case 9:
                    return i(f2, f3, this.f62933a.b(), this.f62933a.a());
                default:
                    throw new IllegalArgumentException("Illegal PivotPoint");
            }
        }
        return (Matrix) invokeCommon.objValue;
    }

    public final Matrix k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? j(this.f62934b.b() / this.f62933a.b(), this.f62934b.a() / this.f62933a.a(), PivotPoint.LEFT_TOP) : (Matrix) invokeV.objValue;
    }

    public final Matrix l(PivotPoint pivotPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, pivotPoint)) == null) ? j(this.f62934b.b() / this.f62933a.b(), this.f62934b.a() / this.f62933a.a(), pivotPoint) : (Matrix) invokeL.objValue;
    }

    public Matrix m(ScalableType scalableType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, scalableType)) == null) {
            switch (C1644a.f62935a[scalableType.ordinal()]) {
                case 1:
                    return k();
                case 2:
                    return f();
                case 3:
                    return c();
                case 4:
                    return e();
                case 5:
                    return d();
                case 6:
                    return l(PivotPoint.LEFT_TOP);
                case 7:
                    return l(PivotPoint.LEFT_CENTER);
                case 8:
                    return l(PivotPoint.LEFT_BOTTOM);
                case 9:
                    return l(PivotPoint.CENTER_TOP);
                case 10:
                    return l(PivotPoint.CENTER);
                case 11:
                    return l(PivotPoint.CENTER_BOTTOM);
                case 12:
                    return l(PivotPoint.RIGHT_TOP);
                case 13:
                    return l(PivotPoint.RIGHT_CENTER);
                case 14:
                    return l(PivotPoint.RIGHT_BOTTOM);
                case 15:
                    return g(PivotPoint.LEFT_TOP);
                case 16:
                    return g(PivotPoint.LEFT_CENTER);
                case 17:
                    return g(PivotPoint.LEFT_BOTTOM);
                case 18:
                    return g(PivotPoint.CENTER_TOP);
                case 19:
                    return g(PivotPoint.CENTER);
                case 20:
                    return g(PivotPoint.CENTER_BOTTOM);
                case 21:
                    return g(PivotPoint.RIGHT_TOP);
                case 22:
                    return g(PivotPoint.RIGHT_CENTER);
                case 23:
                    return g(PivotPoint.RIGHT_BOTTOM);
                case 24:
                    return n();
                case 25:
                    return a();
                case 26:
                    return b();
                default:
                    return null;
            }
        }
        return (Matrix) invokeL.objValue;
    }

    public final Matrix n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f62934b.a() <= this.f62933a.b() && this.f62934b.a() <= this.f62933a.a()) {
                return l(PivotPoint.LEFT_TOP);
            }
            return e();
        }
        return (Matrix) invokeV.objValue;
    }
}
