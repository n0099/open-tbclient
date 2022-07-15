package com.repackage;

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
/* loaded from: classes6.dex */
public class nm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public om5 a;
    public om5 b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-152100610, "Lcom/repackage/nm5$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-152100610, "Lcom/repackage/nm5$a;");
                    return;
                }
            }
            int[] iArr = new int[PivotPoint.values().length];
            b = iArr;
            try {
                iArr[PivotPoint.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PivotPoint.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[PivotPoint.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[PivotPoint.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[PivotPoint.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[PivotPoint.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[PivotPoint.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[PivotPoint.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[PivotPoint.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[ScalableType.values().length];
            a = iArr2;
            try {
                iArr2[ScalableType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ScalableType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ScalableType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[ScalableType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[ScalableType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[ScalableType.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[ScalableType.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[ScalableType.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[ScalableType.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[ScalableType.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[ScalableType.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[ScalableType.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[ScalableType.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[ScalableType.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[ScalableType.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[ScalableType.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[ScalableType.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[ScalableType.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                a[ScalableType.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                a[ScalableType.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                a[ScalableType.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                a[ScalableType.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                a[ScalableType.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                a[ScalableType.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                a[ScalableType.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                a[ScalableType.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    public nm5(om5 om5Var, om5 om5Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {om5Var, om5Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = om5Var;
        this.b = om5Var2;
    }

    public final Matrix a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b.a() <= this.a.b() && this.b.a() <= this.a.a()) {
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
            if (this.b.a() <= this.a.b() && this.b.a() <= this.a.a()) {
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
            float b = this.a.b() / this.b.b();
            float a2 = this.a.a() / this.b.a();
            float max = Math.max(b, a2);
            return j(max / b, max / a2, pivotPoint);
        }
        return (Matrix) invokeL.objValue;
    }

    public final Matrix h(PivotPoint pivotPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pivotPoint)) == null) {
            float b = this.a.b() / this.b.b();
            float a2 = this.a.a() / this.b.a();
            float min = Math.min(b, a2);
            return j(min / b, min / a2, pivotPoint);
        }
        return (Matrix) invokeL.objValue;
    }

    public final Matrix i(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            Matrix matrix = new Matrix();
            matrix.setScale(f, f2, f3, f4);
            return matrix;
        }
        return (Matrix) invokeCommon.objValue;
    }

    public final Matrix j(float f, float f2, PivotPoint pivotPoint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), pivotPoint})) == null) {
            switch (a.b[pivotPoint.ordinal()]) {
                case 1:
                    return i(f, f2, 0.0f, 0.0f);
                case 2:
                    return i(f, f2, 0.0f, this.a.a() / 2.0f);
                case 3:
                    return i(f, f2, 0.0f, this.a.a());
                case 4:
                    return i(f, f2, this.a.b() / 2.0f, 0.0f);
                case 5:
                    return i(f, f2, this.a.b() / 2.0f, this.a.a() / 2.0f);
                case 6:
                    return i(f, f2, this.a.b() / 2.0f, this.a.a());
                case 7:
                    return i(f, f2, this.a.b(), 0.0f);
                case 8:
                    return i(f, f2, this.a.b(), this.a.a() / 2.0f);
                case 9:
                    return i(f, f2, this.a.b(), this.a.a());
                default:
                    throw new IllegalArgumentException("Illegal PivotPoint");
            }
        }
        return (Matrix) invokeCommon.objValue;
    }

    public final Matrix k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? j(this.b.b() / this.a.b(), this.b.a() / this.a.a(), PivotPoint.LEFT_TOP) : (Matrix) invokeV.objValue;
    }

    public final Matrix l(PivotPoint pivotPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, pivotPoint)) == null) ? j(this.b.b() / this.a.b(), this.b.a() / this.a.a(), pivotPoint) : (Matrix) invokeL.objValue;
    }

    public Matrix m(ScalableType scalableType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, scalableType)) == null) {
            switch (a.a[scalableType.ordinal()]) {
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
            if (this.b.a() <= this.a.b() && this.b.a() <= this.a.a()) {
                return l(PivotPoint.LEFT_TOP);
            }
            return e();
        }
        return (Matrix) invokeV.objValue;
    }
}
