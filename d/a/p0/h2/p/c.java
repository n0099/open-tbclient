package d.a.p0.h2.p;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1445c f57873a;

    /* renamed from: b  reason: collision with root package name */
    public int f57874b;

    /* renamed from: c  reason: collision with root package name */
    public int f57875c;

    /* renamed from: d  reason: collision with root package name */
    public float f57876d;

    /* renamed from: e  reason: collision with root package name */
    public float f57877e;

    /* renamed from: f  reason: collision with root package name */
    public float f57878f;

    /* renamed from: g  reason: collision with root package name */
    public int f57879g;

    /* renamed from: h  reason: collision with root package name */
    public int f57880h;

    /* renamed from: i  reason: collision with root package name */
    public b f57881i;
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

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f57882a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f57883b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f57884c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57885d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f57886e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57887f;

        /* renamed from: g  reason: collision with root package name */
        public int f57888g;

        /* renamed from: h  reason: collision with root package name */
        public int f57889h;

        /* renamed from: i  reason: collision with root package name */
        public int f57890i;
        public int j;
        public InterfaceC1445c k;

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
            this.f57882a = 10;
            this.f57883b = bitmap;
            this.f57884c = false;
            this.f57885d = false;
            this.f57886e = false;
            this.f57887f = false;
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
                this.f57890i = i2;
                this.j = i3;
                return this;
            }
            return (b) invokeII.objValue;
        }

        public b n(InterfaceC1445c interfaceC1445c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1445c)) == null) {
                this.k = interfaceC1445c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                this.f57888g = i2;
                this.f57889h = i3;
                this.f57883b = c.a(this.f57883b, i2, i3);
                this.f57885d = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b p(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.f57882a = i2;
                this.f57884c = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b q(int i2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.f57886e = z;
                this.f57887f = z2;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    /* renamed from: d.a.p0.h2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1445c {
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
            float f2 = this.f57877e;
            if (f2 > this.k) {
                return;
            }
            canvas.drawBitmap(this.u, this.f57876d, f2, paint);
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
            this.f57876d = (float) (this.f57876d + (Math.sin(this.l) * 10.0d));
            if (this.s) {
                this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
            }
            float f2 = this.f57876d;
            int i2 = this.j;
            int i3 = this.o;
            if (f2 > i2 - i3) {
                this.f57876d = i2 - i3;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57877e += this.f57878f;
        }
    }

    public final void f() {
        float nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.n) {
                this.u = this.f57881i.f57883b;
            } else {
                InterfaceC1445c interfaceC1445c = this.f57873a;
                if (interfaceC1445c != null) {
                    nextInt = interfaceC1445c.a();
                } else {
                    nextInt = (this.t.nextInt(10) + 1) * 0.1f;
                }
                int i2 = this.p;
                this.u = a(this.f57881i.f57883b, (int) (i2 > 0 ? Math.max(i2, this.f57881i.f57883b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f57881i.f57883b.getHeight(), this.q) : 0.0f));
            }
            this.u.getWidth();
            this.u.getHeight();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m) {
                this.f57878f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f57874b;
            } else {
                this.f57878f = this.f57874b;
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.r) {
                this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f57875c) / 50.0d);
            } else {
                this.l = this.f57875c / 50.0f;
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
        this.f57881i = bVar;
        this.j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f57879g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f57880h = nextInt;
        this.f57876d = this.f57879g;
        this.f57877e = nextInt;
        this.m = bVar.f57884c;
        this.n = bVar.f57885d;
        this.f57873a = bVar.k;
        this.p = bVar.f57890i;
        this.q = bVar.j;
        this.o = bVar.f57888g;
        int unused = bVar.f57889h;
        this.r = bVar.f57886e;
        this.s = bVar.f57887f;
        this.f57874b = bVar.f57882a;
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
        this.f57881i = bVar;
        this.u = bVar.f57883b;
        this.o = bVar.f57888g;
        int unused = bVar.f57889h;
        this.p = bVar.f57890i;
        this.f57873a = bVar.k;
        this.q = bVar.j;
        this.f57874b = bVar.f57882a;
        this.n = bVar.f57885d;
        this.r = bVar.f57886e;
        this.s = bVar.f57887f;
        this.m = bVar.f57884c;
    }
}
