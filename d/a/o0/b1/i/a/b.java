package d.a.o0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f51659a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f51660b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f51661c;

    /* renamed from: d  reason: collision with root package name */
    public final int f51662d;

    /* renamed from: e  reason: collision with root package name */
    public final int f51663e;

    /* renamed from: f  reason: collision with root package name */
    public float f51664f;

    /* renamed from: g  reason: collision with root package name */
    public final List<a> f51665g;

    /* renamed from: h  reason: collision with root package name */
    public final int f51666h;

    /* renamed from: i  reason: collision with root package name */
    public a f51667i;
    public final Rect j;
    public final Matrix k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(414031300, "Ld/a/o0/b1/i/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(414031300, "Ld/a/o0/b1/i/a/b;");
        }
    }

    public b(int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51659a = new RectF();
        this.f51660b = new Rect();
        this.f51664f = 1.0f;
        this.f51665g = new ArrayList();
        this.k = new Matrix();
        this.f51663e = i3;
        this.f51662d = i2;
        this.f51661c = new RectF(0.0f, 0.0f, i2, i3);
        this.j = new Rect(0, 0, iArr[0], iArr[1]);
        this.f51666h = i2 / 2;
    }

    public void a(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rect) == null) {
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            int i2 = rect.right;
            int i3 = this.j.right;
            if (i2 > i3) {
                rect.right = i3;
            }
            int i4 = rect.bottom;
            int i5 = this.j.bottom;
            if (i4 > i5) {
                rect.bottom = i5;
            }
        }
    }

    public boolean b(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4)) == null) {
            if (i4 == k()) {
                return j(i2, i3, i4).intersect(this.f51660b);
            }
            return false;
        }
        return invokeIII.booleanValue;
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this.f51666h) : (a) invokeV.objValue;
    }

    public List<a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51665g : (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51666h : invokeV.intValue;
    }

    public Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (Rect) invokeV.objValue;
    }

    public Rect g(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return aVar.e();
        }
        return (Rect) invokeL.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f51663e : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f51662d : invokeV.intValue;
    }

    public Rect j(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i2, i3, i4)) == null) {
            int i5 = this.f51666h;
            int i6 = i5 * i4 * i3;
            int i7 = i5 * i4 * i2;
            return new Rect(i6, i7, (i4 * i5) + i6, (i4 * i5) + i7);
        }
        return (Rect) invokeIII.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = 1;
            while (i2 < Math.round(this.f51664f)) {
                i2 *= 2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f51664f : invokeV.floatValue;
    }

    public Point[] m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            o();
            int k = k();
            Rect rect = this.f51660b;
            int i2 = this.f51666h;
            int i3 = (rect.top / k) / i2;
            int i4 = (rect.left / k) / i2;
            Point point = new Point();
            point.y = i3;
            point.x = i4;
            Point point2 = new Point();
            point2.y = (((rect.bottom / k) / i2) * k) + 1;
            point2.x = (((rect.right / k) / i2) * k) + 1;
            return new Point[]{point, point2};
        }
        return (Point[]) invokeV.objValue;
    }

    public a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f51667i : (a) invokeV.objValue;
    }

    public Rect o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            this.k.mapRect(this.f51659a, this.f51661c);
            u(this.f51660b, this.f51659a);
            return this.f51660b;
        }
        return (Rect) invokeV.objValue;
    }

    public void p(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.k.postTranslate(f2, f3);
        }
    }

    public void q(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.k.postScale(f2, f2);
        }
    }

    public void r(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.k.postScale(f2, f2, f3, f4);
        }
    }

    public void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.f51664f = f2;
        }
    }

    public void t(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, bitmap) == null) || bitmap == null) {
            return;
        }
        a aVar = new a(bitmap);
        this.f51667i = aVar;
        aVar.i(0, 0, this.f51662d, this.f51663e);
    }

    public final void u(Rect rect, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, rect, rectF) == null) {
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }
}
