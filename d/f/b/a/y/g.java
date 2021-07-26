package d.f.b.a.y;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.y.e;
import d.f.b.a.y.f;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Thread f71214a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f71215b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<I> f71216c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<O> f71217d;

    /* renamed from: e  reason: collision with root package name */
    public final I[] f71218e;

    /* renamed from: f  reason: collision with root package name */
    public final O[] f71219f;

    /* renamed from: g  reason: collision with root package name */
    public int f71220g;

    /* renamed from: h  reason: collision with root package name */
    public int f71221h;

    /* renamed from: i  reason: collision with root package name */
    public I f71222i;
    public E j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes8.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f71223e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71223e = gVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f71223e.s();
            }
        }
    }

    public g(I[] iArr, O[] oArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, oArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71215b = new Object();
        this.f71216c = new LinkedList<>();
        this.f71217d = new LinkedList<>();
        this.f71218e = iArr;
        this.f71220g = iArr.length;
        for (int i4 = 0; i4 < this.f71220g; i4++) {
            this.f71218e[i4] = g();
        }
        this.f71219f = oArr;
        this.f71221h = oArr.length;
        for (int i5 = 0; i5 < this.f71221h; i5++) {
            this.f71219f[i5] = h();
        }
        a aVar = new a(this);
        this.f71214a = aVar;
        aVar.start();
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !this.f71216c.isEmpty() && this.f71221h > 0 : invokeV.booleanValue;
    }

    @Override // d.f.b.a.y.c
    public final void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f71215b) {
                this.k = true;
                this.m = 0;
                if (this.f71222i != null) {
                    p(this.f71222i);
                    this.f71222i = null;
                }
                while (!this.f71216c.isEmpty()) {
                    p(this.f71216c.removeFirst());
                }
                while (!this.f71217d.isEmpty()) {
                    r(this.f71217d.removeFirst());
                }
            }
        }
    }

    public abstract I g();

    public abstract O h();

    public abstract E i(I i2, O o, boolean z);

    public final boolean j() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.f71215b) {
                while (!this.l && !f()) {
                    this.f71215b.wait();
                }
                if (this.l) {
                    return false;
                }
                I removeFirst = this.f71216c.removeFirst();
                O[] oArr = this.f71219f;
                int i2 = this.f71221h - 1;
                this.f71221h = i2;
                O o = oArr[i2];
                boolean z = this.k;
                this.k = false;
                if (removeFirst.j()) {
                    o.e(4);
                } else {
                    if (removeFirst.i()) {
                        o.e(Integer.MIN_VALUE);
                    }
                    E i3 = i(removeFirst, o, z);
                    this.j = i3;
                    if (i3 != null) {
                        synchronized (this.f71215b) {
                        }
                        return false;
                    }
                }
                synchronized (this.f71215b) {
                    if (this.k) {
                        r(o);
                    } else if (o.i()) {
                        this.m++;
                        r(o);
                    } else {
                        o.f71213g = this.m;
                        this.m = 0;
                        this.f71217d.addLast(o);
                    }
                    p(removeFirst);
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.y.c
    /* renamed from: k */
    public final I a() throws Exception {
        InterceptResult invokeV;
        I i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this.f71215b) {
                n();
                d.f.b.a.i0.a.f(this.f71222i == null);
                if (this.f71220g == 0) {
                    i2 = null;
                } else {
                    I[] iArr = this.f71218e;
                    int i3 = this.f71220g - 1;
                    this.f71220g = i3;
                    i2 = iArr[i3];
                }
                this.f71222i = i2;
            }
            return i2;
        }
        return (I) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.y.c
    /* renamed from: l */
    public final O c() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f71215b) {
                n();
                if (this.f71217d.isEmpty()) {
                    return null;
                }
                return this.f71217d.removeFirst();
            }
        }
        return (O) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && f()) {
            this.f71215b.notify();
        }
    }

    public final void n() throws Exception {
        E e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (e2 = this.j) != null) {
            throw e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.y.c
    /* renamed from: o */
    public final void d(I i2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, i2) == null) {
            synchronized (this.f71215b) {
                n();
                d.f.b.a.i0.a.a(i2 == this.f71222i);
                this.f71216c.addLast(i2);
                m();
                this.f71222i = null;
            }
        }
    }

    public final void p(I i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, i2) == null) {
            i2.f();
            I[] iArr = this.f71218e;
            int i3 = this.f71220g;
            this.f71220g = i3 + 1;
            iArr[i3] = i2;
        }
    }

    public void q(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, o) == null) {
            synchronized (this.f71215b) {
                r(o);
                m();
            }
        }
    }

    public final void r(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, o) == null) {
            o.f();
            O[] oArr = this.f71219f;
            int i2 = this.f71221h;
            this.f71221h = i2 + 1;
            oArr[i2] = o;
        }
    }

    @Override // d.f.b.a.y.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f71215b) {
                this.l = true;
                this.f71215b.notify();
            }
            try {
                this.f71214a.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            do {
                try {
                } catch (InterruptedException e2) {
                    throw new IllegalStateException(e2);
                }
            } while (j());
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            d.f.b.a.i0.a.f(this.f71220g == this.f71218e.length);
            for (I i3 : this.f71218e) {
                i3.n(i2);
            }
        }
    }
}
