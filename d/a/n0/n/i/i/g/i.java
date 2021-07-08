package d.a.n0.n.i.i.g;

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
    public static final boolean f50686f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.n0.n.i.i.b> f50687a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.n.f.d f50688b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.n0.n.h.e> f50689c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.n0.n.h.e> f50690d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.n0.n.h.e> f50691e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1184332143, "Ld/a/n0/n/i/i/g/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1184332143, "Ld/a/n0/n/i/i/g/i;");
                return;
            }
        }
        f50686f = d.a.n0.n.c.f50608a;
    }

    public i(d.a.n0.n.f.d dVar) {
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
        this.f50689c = new ArrayList();
        this.f50690d = new ArrayList();
        this.f50691e = new ArrayList();
        this.f50688b = dVar;
        this.f50687a = new ArrayList();
        d.b().e(this);
    }

    @Override // d.a.n0.n.i.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // d.a.n0.n.i.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar.j()) {
            return;
        }
        Iterator<d.a.n0.n.i.i.b> it = this.f50687a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.n0.n.i.i.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f50687a.remove(next);
                if (h2 == 2) {
                    this.f50691e.add(next.a().f50678e.f50677b);
                } else if (h2 == 3) {
                    this.f50690d.add(next.a().f50678e.f50677b);
                } else if (h2 != 10) {
                    if (d.a.n0.n.c.f50608a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f50689c.add(next.a().f50678e.f50677b);
                }
            }
        }
        d();
    }

    public void c(d.a.n0.n.i.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f50687a.add(bVar);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f50687a.isEmpty()) {
                this.f50688b.b();
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
        if (f50686f) {
            Log.i("PMSTaskGroup", d.a.n0.n.c.b().v() + " startDownload: total=" + this.f50687a.size());
        }
        for (d.a.n0.n.i.i.b bVar : this.f50687a) {
            if (f50686f) {
                Log.i("PMSTaskGroup", d.a.n0.n.c.b().v() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
