package d.a.q0.a.n0.j.g;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.n0.g;
import d.a.q0.a.p.b.a.l;
import d.a.q0.a.v2.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class a implements b, d.a.q0.a.n0.j.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f49562a;

    /* renamed from: b  reason: collision with root package name */
    public l f49563b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d.a.q0.a.n0.j.d.a[] f49564c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.n0.j.f.a f49565d;

    /* renamed from: d.a.q0.a.n0.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0879a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49566e;

        public RunnableC0879a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49566e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49566e.e();
            }
        }
    }

    public a(@NonNull d.a.q0.a.n0.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49562a = new g();
        this.f49563b = d.a.q0.a.c1.b.m();
        this.f49564c = new d.a.q0.a.n0.j.d.a[]{new d.a.q0.a.n0.j.d.e(), new d.a.q0.a.n0.j.d.c(), new d.a.q0.a.n0.j.d.b(), new d.a.q0.a.n0.j.d.d()};
        this.f49565d = aVar;
    }

    @Override // d.a.q0.a.n0.j.d.a
    public synchronized ArraySet<String> a() {
        InterceptResult invokeV;
        ArraySet<String> arraySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                d.a.q0.a.e0.d.h("RecoveryPolicy", "renameAllPlatformFiles start");
                arraySet = new ArraySet<>();
                for (d.a.q0.a.n0.j.d.a aVar : this.f49564c) {
                    arraySet.addAll((ArraySet<? extends String>) aVar.a());
                }
                d.a.q0.a.e0.d.h("RecoveryPolicy", "renameAllPlatformFiles end");
            }
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    @Override // d.a.q0.a.n0.j.g.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q.j(new RunnableC0879a(this), "performRecovery");
        }
    }

    public void c(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arraySet) == null) || arraySet == null || arraySet.isEmpty()) {
            return;
        }
        d.a.q0.a.e0.d.h("RecoveryPolicy", "deleteFiles start");
        Iterator<String> it = arraySet.iterator();
        while (it.hasNext()) {
            d.a.q0.t.d.j(it.next());
        }
        d.a.q0.a.e0.d.h("RecoveryPolicy", "deleteFiles end");
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            d.a.q0.a.v1.c.c cVar = new d.a.q0.a.v1.c.c(132);
            cVar.d();
            e2.h(cVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void f(Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, collection) == null) || collection == null || collection.isEmpty()) {
            return;
        }
        d.a.q0.a.e0.d.h("RecoveryPolicy", "resetAccredit appIds=" + collection);
        this.f49562a.g(new ArrayList(collection));
    }
}
