package d.a.p0.d1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f52312a;

    /* renamed from: b  reason: collision with root package name */
    public final C1187a f52313b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f52314c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f52315d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f52316e;

    /* renamed from: f  reason: collision with root package name */
    public int f52317f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f52318g;

    /* renamed from: d.a.p0.d1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1187a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f52319a;

        /* renamed from: b  reason: collision with root package name */
        public int f52320b;

        /* renamed from: c  reason: collision with root package name */
        public int f52321c;

        public C1187a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52320b : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52319a : invokeV.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52321c : invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof C1187a) {
                    C1187a c1187a = (C1187a) obj;
                    if (this.f52319a == c1187a.b() && this.f52320b == c1187a.a() && this.f52321c == c1187a.c()) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ((((119 + this.f52319a) * 17) + this.f52320b) * 17) + (this.f52321c * 100) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Position{row=" + this.f52319a + ", column=" + this.f52320b + ", sampleScale=" + this.f52321c + '}';
            }
            return (String) invokeV.objValue;
        }

        public C1187a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f52319a = i2;
            this.f52320b = i3;
            this.f52321c = i4;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1223172358, "Ld/a/p0/d1/i/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1223172358, "Ld/a/p0/d1/i/a/a;");
        }
    }

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52313b = new C1187a();
        this.f52314c = new Rect();
        this.f52315d = new Rect();
        this.f52316e = new Rect();
        this.f52312a = Bitmap.createBitmap(i2, i2, TbConfig.BitmapConfig);
        this.f52317f = i2;
        this.f52318g = new Canvas();
    }

    public void a() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bitmap = this.f52312a) == null || bitmap.isRecycled() || !this.f52312a.isMutable()) {
            return;
        }
        this.f52318g.setBitmap(this.f52312a);
        this.f52318g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52312a : (Bitmap) invokeV.objValue;
    }

    public Rect c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52315d : (Rect) invokeV.objValue;
    }

    public C1187a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52313b : (C1187a) invokeV.objValue;
    }

    public Rect e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f52317f;
            C1187a c1187a = this.f52313b;
            int i3 = c1187a.f52321c;
            int i4 = c1187a.f52320b * i2 * i3;
            int i5 = c1187a.f52319a * i2 * i3;
            this.f52316e.set(i4, i5, (i2 * i3) + i4, (i2 * i3) + i5);
            return this.f52316e;
        }
        return (Rect) invokeV.objValue;
    }

    public Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f52314c : (Rect) invokeV.objValue;
    }

    public boolean g(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rect)) == null) {
            if (rect == null) {
                return false;
            }
            int i2 = rect.right - rect.left;
            int i3 = this.f52317f;
            return i2 == i3 && rect.bottom - rect.top == i3;
        }
        return invokeL.booleanValue;
    }

    public void h(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bitmap) == null) {
            this.f52312a = bitmap;
        }
    }

    public void i(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            this.f52315d.set(i2, i3, i4, i5);
        }
    }

    public void j(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048585, this, i2, i3, i4) == null) {
            C1187a c1187a = this.f52313b;
            c1187a.f52319a = i2;
            c1187a.f52320b = i3;
            c1187a.f52321c = i4;
        }
    }

    public void k(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i2, i3, i4, i5) == null) {
            this.f52314c.set(i2, i3, i4, i5);
        }
    }

    public a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f52313b = new C1187a();
        this.f52314c = new Rect();
        this.f52315d = new Rect();
        this.f52316e = new Rect();
        if (bitmap != null) {
            this.f52312a = bitmap;
            this.f52314c.set(0, 0, bitmap.getWidth(), this.f52312a.getHeight());
        }
        this.f52318g = new Canvas();
    }
}
