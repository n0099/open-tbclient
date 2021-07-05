package d.a.s0.h2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1490c f61117a;

    /* renamed from: b  reason: collision with root package name */
    public int f61118b;

    /* renamed from: c  reason: collision with root package name */
    public int f61119c;

    /* renamed from: d  reason: collision with root package name */
    public float f61120d;

    /* renamed from: e  reason: collision with root package name */
    public float f61121e;

    /* renamed from: f  reason: collision with root package name */
    public float f61122f;

    /* renamed from: g  reason: collision with root package name */
    public int f61123g;

    /* renamed from: h  reason: collision with root package name */
    public int f61124h;

    /* renamed from: i  reason: collision with root package name */
    public b f61125i;
    public int j;
    public int k;
    public float l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public Random t;
    public Bitmap u;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f61126a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f61127b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f61128c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f61129d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f61130e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f61131f;

        /* renamed from: g  reason: collision with root package name */
        public int f61132g;

        /* renamed from: h  reason: collision with root package name */
        public int f61133h;

        /* renamed from: i  reason: collision with root package name */
        public int f61134i;
        public int j;
        public InterfaceC1490c k;

        public b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61126a = 10;
            this.f61127b = bitmap;
            this.f61128c = false;
            this.f61129d = false;
            this.f61130e = false;
            this.f61131f = false;
        }

        public c l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this, null) : (c) invokeV.objValue;
        }

        public b m(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                this.f61134i = i2;
                this.j = i3;
                return this;
            }
            return (b) invokeII.objValue;
        }

        public b n(InterfaceC1490c interfaceC1490c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1490c)) == null) {
                this.k = interfaceC1490c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                this.f61132g = i2;
                this.f61133h = i3;
                this.f61127b = c.a(this.f61127b, i2, i3);
                this.f61129d = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b p(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.f61126a = i2;
                this.f61128c = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b q(int i2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.f61130e = z;
                this.f61131f = z2;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    /* renamed from: d.a.s0.h2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1490c {
        float a();
    }

    public /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bitmap, i2, i3)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, i3 / height);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public void b(Canvas canvas, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, paint) == null) {
            c();
            float f2 = this.f61121e;
            if (f2 > this.k) {
                return;
            }
            canvas.drawBitmap(this.u, this.f61120d, f2, paint);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d();
            e();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61120d = (float) (this.f61120d + (Math.sin(this.l) * 10.0d));
            if (this.s) {
                this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
            }
            float f2 = this.f61120d;
            int i2 = this.j;
            int i3 = this.o;
            if (f2 > i2 - i3) {
                this.f61120d = i2 - i3;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f61121e += this.f61122f;
        }
    }

    public final void f() {
        float nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.n) {
                this.u = this.f61125i.f61127b;
            } else {
                InterfaceC1490c interfaceC1490c = this.f61117a;
                if (interfaceC1490c != null) {
                    nextInt = interfaceC1490c.a();
                } else {
                    nextInt = (this.t.nextInt(10) + 1) * 0.1f;
                }
                int i2 = this.p;
                this.u = a(this.f61125i.f61127b, (int) (i2 > 0 ? Math.max(i2, this.f61125i.f61127b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f61125i.f61127b.getHeight(), this.q) : 0.0f));
            }
            this.u.getWidth();
            this.u.getHeight();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m) {
                this.f61122f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f61118b;
            } else {
                this.f61122f = this.f61118b;
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.r) {
                this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f61119c) / 50.0d);
            } else {
                this.l = this.f61119c / 50.0f;
            }
            float f2 = this.l;
            if (f2 > 1.5707964f) {
                this.l = 1.5707964f;
            } else if (f2 < -1.5707964f) {
                this.l = -1.5707964f;
            }
        }
    }

    public c(b bVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61125i = bVar;
        this.j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f61123g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f61124h = nextInt;
        this.f61120d = this.f61123g;
        this.f61121e = nextInt;
        this.m = bVar.f61128c;
        this.n = bVar.f61129d;
        this.f61117a = bVar.k;
        this.p = bVar.f61134i;
        this.q = bVar.j;
        this.o = bVar.f61132g;
        int unused = bVar.f61133h;
        this.r = bVar.f61130e;
        this.s = bVar.f61131f;
        this.f61118b = bVar.f61126a;
        g();
        f();
        h();
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61125i = bVar;
        this.u = bVar.f61127b;
        this.o = bVar.f61132g;
        int unused = bVar.f61133h;
        this.p = bVar.f61134i;
        this.f61117a = bVar.k;
        this.q = bVar.j;
        this.f61118b = bVar.f61126a;
        this.n = bVar.f61129d;
        this.r = bVar.f61130e;
        this.s = bVar.f61131f;
        this.m = bVar.f61128c;
    }
}
