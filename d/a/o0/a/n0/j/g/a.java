package d.a.o0.a.n0.j.g;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.n0.g;
import d.a.o0.a.p.b.a.l;
import d.a.o0.a.v2.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a implements b, d.a.o0.a.n0.j.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f46764a;

    /* renamed from: b  reason: collision with root package name */
    public l f46765b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d.a.o0.a.n0.j.d.a[] f46766c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.n0.j.f.a f46767d;

    /* renamed from: d.a.o0.a.n0.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0837a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46768e;

        public RunnableC0837a(a aVar) {
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
            this.f46768e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46768e.e();
            }
        }
    }

    public a(@NonNull d.a.o0.a.n0.j.f.a aVar) {
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
        this.f46764a = new g();
        this.f46765b = d.a.o0.a.c1.b.m();
        this.f46766c = new d.a.o0.a.n0.j.d.a[]{new d.a.o0.a.n0.j.d.e(), new d.a.o0.a.n0.j.d.c(), new d.a.o0.a.n0.j.d.b(), new d.a.o0.a.n0.j.d.d()};
        this.f46767d = aVar;
    }

    @Override // d.a.o0.a.n0.j.d.a
    public synchronized ArraySet<String> a() {
        InterceptResult invokeV;
        ArraySet<String> arraySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                d.a.o0.a.e0.d.h("RecoveryPolicy", "renameAllPlatformFiles start");
                arraySet = new ArraySet<>();
                for (d.a.o0.a.n0.j.d.a aVar : this.f46766c) {
                    arraySet.addAll((ArraySet<? extends String>) aVar.a());
                }
                d.a.o0.a.e0.d.h("RecoveryPolicy", "renameAllPlatformFiles end");
            }
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    @Override // d.a.o0.a.n0.j.g.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q.j(new RunnableC0837a(this), "performRecovery");
        }
    }

    public void c(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arraySet) == null) || arraySet == null || arraySet.isEmpty()) {
            return;
        }
        d.a.o0.a.e0.d.h("RecoveryPolicy", "deleteFiles start");
        Iterator<String> it = arraySet.iterator();
        while (it.hasNext()) {
            d.a.o0.t.d.j(it.next());
        }
        d.a.o0.a.e0.d.h("RecoveryPolicy", "deleteFiles end");
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.o0.a.v1.c.a e2 = d.a.o0.a.v1.c.a.e();
            d.a.o0.a.v1.c.c cVar = new d.a.o0.a.v1.c.c(132);
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
        d.a.o0.a.e0.d.h("RecoveryPolicy", "resetAccredit appIds=" + collection);
        this.f46764a.g(new ArrayList(collection));
    }
}
