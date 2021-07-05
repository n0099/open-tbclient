package d.a.q0.a.h0.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.m.c;
import d.a.q0.a.v2.w0;
import h.d;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class l extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public h.j<? super d.a.q0.n.h.d> f48305g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.q0.n.h.b> f48306h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.n.o.f f48307i;
    public d.a.q0.a.v2.e1.b<Exception> j;
    public d.a.q0.n.f.c<d.a.q0.n.h.d> k;
    public d.a.q0.n.f.c<d.a.q0.n.h.b> l;
    public h.j<d.a.q0.n.h.e> m;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.n.f.b<d.a.q0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f48308e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48308e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.c
        /* renamed from: l */
        public String d(d.a.q0.n.h.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) ? this.f48308e.W() : (String) invokeL.objValue;
        }

        @Override // d.a.q0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f48308e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: o */
        public void e(d.a.q0.n.h.d dVar, d.a.q0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, dVar, aVar) == null) {
                super.e(dVar, aVar);
                d.a.q0.a.e0.d.h("UpdateCoreCallback", "onDownloadError:" + aVar);
                this.f48308e.f48307i.j(dVar);
                d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f53928a);
                aVar2.c("Framework包下载失败");
                aVar2.e(aVar.toString());
                if (this.f48308e.f48305g != null) {
                    this.f48308e.f48305g.onError(new PkgDownloadError(dVar, aVar2));
                }
                d.a.q0.a.h0.m.c.c().a(dVar, this.f48308e.U(), aVar2);
                d.a.q0.t.d.j(dVar.f53932a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: p */
        public void i(d.a.q0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
                super.i(dVar);
                d.a.q0.a.e0.d.h("UpdateCoreCallback", "onFileDownloaded: " + dVar.f53940i);
                d.a.q0.a.q2.a b0 = this.f48308e.b0(dVar);
                if (b0 == null) {
                    this.f48308e.f48307i.k(dVar);
                    if (this.f48308e.f48305g != null) {
                        this.f48308e.f48305g.onNext(dVar);
                        this.f48308e.f48305g.onCompleted();
                    }
                    d.a.q0.n.g.a.h().l(dVar);
                    d.a.q0.a.h0.m.c.c().b(dVar, this.f48308e.U());
                    w0.a();
                    return;
                }
                this.f48308e.f48307i.j(dVar);
                if (this.f48308e.f48305g != null) {
                    this.f48308e.f48305g.onError(new PkgDownloadError(dVar, b0));
                }
                d.a.q0.a.h0.m.c.c().a(dVar, this.f48308e.U(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: q */
        public void c(d.a.q0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                super.c(dVar);
                d.a.q0.a.e0.d.h("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: r */
        public void f(d.a.q0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                super.f(dVar);
                if (l.n) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.f48308e.f0(dVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.q0.n.f.b<d.a.q0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f48309e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48309e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.c
        /* renamed from: l */
        public String d(d.a.q0.n.h.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? this.f48309e.V() : (String) invokeL.objValue;
        }

        @Override // d.a.q0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f48309e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: o */
        public void e(d.a.q0.n.h.b bVar, d.a.q0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, bVar, aVar) == null) {
                super.e(bVar, aVar);
                d.a.q0.a.e0.d.h("UpdateCoreCallback", "onDownloadError:" + aVar);
                this.f48309e.f48307i.j(bVar);
                d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                aVar2.j(14L);
                aVar2.h(aVar.f53928a);
                aVar2.c("Extension下载失败");
                aVar2.e(aVar.toString());
                if (this.f48309e.f48306h != null) {
                    this.f48309e.f48306h.onError(new PkgDownloadError(bVar, aVar2));
                }
                d.a.q0.a.h0.m.c.c().a(bVar, this.f48309e.U(), aVar2);
                d.a.q0.t.d.j(bVar.f53932a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: p */
        public void i(d.a.q0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
                super.i(bVar);
                d.a.q0.a.e0.d.h("UpdateCoreCallback", "onFileDownloaded: " + bVar.f53940i);
                d.a.q0.a.q2.a a0 = this.f48309e.a0(bVar);
                if (a0 == null) {
                    this.f48309e.f48307i.k(bVar);
                    if (this.f48309e.f48306h != null) {
                        this.f48309e.f48306h.onNext(bVar);
                        this.f48309e.f48306h.onCompleted();
                    }
                    d.a.q0.n.g.a.h().l(bVar);
                    d.a.q0.a.h0.m.c.c().b(bVar, this.f48309e.U());
                    return;
                }
                this.f48309e.f48307i.j(bVar);
                if (this.f48309e.f48306h != null) {
                    this.f48309e.f48306h.onError(new PkgDownloadError(bVar, a0));
                }
                d.a.q0.a.h0.m.c.c().a(bVar, this.f48309e.U(), a0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: q */
        public void c(d.a.q0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                super.c(bVar);
                d.a.q0.a.e0.d.h("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: r */
        public void f(d.a.q0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                super.f(bVar);
                if (l.n) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.f48309e.e0(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.InterfaceC0795c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.n.h.d f48310a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f48311b;

        public c(l lVar, d.a.q0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48311b = lVar;
            this.f48310a = dVar;
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f48311b.f48307i.k(this.f48310a);
                if (this.f48311b.f48305g != null) {
                    this.f48311b.f48305g.onNext(this.f48310a);
                    this.f48311b.f48305g.onCompleted();
                }
            }
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void b(PMSDownloadType pMSDownloadType, d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f48311b.f48307i.j(this.f48310a);
                if (this.f48311b.f48305g != null) {
                    this.f48311b.f48305g.onError(new PkgDownloadError(this.f48310a, aVar));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements c.InterfaceC0795c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.n.h.b f48312a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f48313b;

        public d(l lVar, d.a.q0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48313b = lVar;
            this.f48312a = bVar;
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f48313b.f48307i.k(this.f48312a);
                if (this.f48313b.f48306h != null) {
                    this.f48313b.f48306h.onNext(this.f48312a);
                    this.f48313b.f48306h.onCompleted();
                }
            }
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void b(PMSDownloadType pMSDownloadType, d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f48313b.f48307i.j(this.f48312a);
                if (this.f48313b.f48306h != null) {
                    this.f48313b.f48306h.onError(new PkgDownloadError(this.f48312a, aVar));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a<d.a.q0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f48314e;

        public e(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48314e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.q0.n.h.d> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f48314e.f48305g = jVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a<d.a.q0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f48315e;

        public f(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48315e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.q0.n.h.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f48315e.f48306h = jVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends h.j<d.a.q0.n.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f48316e;

        public g(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48316e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.q0.n.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                d.a.q0.a.e0.d.h("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.f53940i);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.e0.d.h("UpdateCoreCallback", "包下载完成");
                this.f48316e.d0();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                d.a.q0.a.e0.d.i("UpdateCoreCallback", "OnError", th);
                this.f48316e.c0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705596287, "Ld/a/q0/a/h0/m/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705596287, "Ld/a/q0/a/h0/m/l;");
                return;
            }
        }
        n = d.a.q0.a.k.f49133a;
    }

    public l(d.a.q0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = bVar;
    }

    @Override // d.a.q0.n.f.g
    public void B(d.a.q0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            d.a.q0.a.e0.d.h("UpdateCoreCallback", "onFetchError: " + aVar.toString());
            if (aVar.f53928a == 1010) {
                d0();
                return;
            }
            c0(new PMSException("UpdateCoreCallback failed by fetch error = " + aVar, aVar));
        }
    }

    @Override // d.a.q0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            if (n) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // d.a.q0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            d.a.q0.a.e0.d.h("UpdateCoreCallback", "onNoPackage:");
            d0();
        }
    }

    @Override // d.a.q0.n.f.g
    public void F(d.a.q0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            if (fVar == null) {
                return;
            }
            this.f48307i = fVar;
            if (fVar.i()) {
                return;
            }
            Y();
        }
    }

    public abstract int T();

    public abstract PMSDownloadType U();

    public abstract String V();

    public abstract String W();

    public final h.j<d.a.q0.n.h.e> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.m == null) {
                this.m = new g(this);
            }
            return this.m;
        }
        return (h.j) invokeV.objValue;
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f48307i.c()) {
                arrayList.add(h.d.b(new e(this)));
            }
            if (this.f48307i.b()) {
                arrayList.add(h.d.b(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.l(arrayList).z(X());
        }
    }

    public void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            d.a.q0.a.e0.d.i("UpdateCoreCallback", "notifyFinalCallback", exc);
            d.a.q0.a.v2.e1.b<Exception> bVar = this.j;
            if (bVar != null) {
                bVar.onCallback(exc);
            }
            this.j = null;
        }
    }

    public abstract d.a.q0.a.q2.a a0(d.a.q0.n.h.b bVar);

    public abstract d.a.q0.a.q2.a b0(d.a.q0.n.h.d dVar);

    public void c0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            d.a.q0.a.e0.d.h("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            d.a.q0.n.n.a.d(T(), 0L);
            d.a.q0.d.d.b.a(0L);
            Z(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.q0.a.e0.d.h("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            d.a.q0.n.n.a.d(T(), currentTimeMillis);
            Z(null);
        }
    }

    public final void e0(d.a.q0.n.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            d.a.q0.a.h0.m.c.c().d(bVar, new d(this, bVar));
        }
    }

    public final void f0(d.a.q0.n.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            d.a.q0.a.h0.m.c.c().d(dVar, new c(this, dVar));
        }
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.f.c<d.a.q0.n.h.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.l == null) {
                this.l = new b(this);
            }
            return this.l;
        }
        return (d.a.q0.n.f.c) invokeV.objValue;
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.f.c<d.a.q0.n.h.d> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.k == null) {
                this.k = new a(this);
            }
            return this.k;
        }
        return (d.a.q0.n.f.c) invokeV.objValue;
    }
}
