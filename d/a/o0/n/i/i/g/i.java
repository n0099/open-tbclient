package d.a.o0.n.i.i.g;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class i implements b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f51190f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.o0.n.i.i.b> f51191a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.n.f.d f51192b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.o0.n.h.e> f51193c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.o0.n.h.e> f51194d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.o0.n.h.e> f51195e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(890929136, "Ld/a/o0/n/i/i/g/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(890929136, "Ld/a/o0/n/i/i/g/i;");
                return;
            }
        }
        f51190f = d.a.o0.n.c.f51112a;
    }

    public i(d.a.o0.n.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51193c = new ArrayList();
        this.f51194d = new ArrayList();
        this.f51195e = new ArrayList();
        this.f51192b = dVar;
        this.f51191a = new ArrayList();
        d.b().e(this);
    }

    @Override // d.a.o0.n.i.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // d.a.o0.n.i.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar.j()) {
            return;
        }
        Iterator<d.a.o0.n.i.i.b> it = this.f51191a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.o0.n.i.i.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f51191a.remove(next);
                if (h2 == 2) {
                    this.f51195e.add(next.a().f51182e.f51181b);
                } else if (h2 == 3) {
                    this.f51194d.add(next.a().f51182e.f51181b);
                } else if (h2 != 10) {
                    if (d.a.o0.n.c.f51112a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f51193c.add(next.a().f51182e.f51181b);
                }
            }
        }
        d();
    }

    public void c(d.a.o0.n.i.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f51191a.add(bVar);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f51191a.isEmpty()) {
                this.f51192b.b();
                d.b().g(this);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d()) {
            return;
        }
        if (f51190f) {
            Log.i("PMSTaskGroup", d.a.o0.n.c.b().v() + " startDownload: total=" + this.f51191a.size());
        }
        for (d.a.o0.n.i.i.b bVar : this.f51191a) {
            if (f51190f) {
                Log.i("PMSTaskGroup", d.a.o0.n.c.b().v() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
