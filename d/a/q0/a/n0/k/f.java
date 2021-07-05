package d.a.q0.a.n0.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h;
import d.a.q0.a.h0.m.c;
import d.a.q0.a.h0.m.j;
import d.a.q0.a.k;
import d.a.q0.a.n0.k.d;
import d.a.q0.a.v2.j0;
import d.a.q0.a.v2.q0;
import d.a.q0.n.h.i;
import h.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class f extends j implements d.a.q0.n.k.a.a, d.a.q0.n.j.k.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static int r;
    public static final PMSDownloadType s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f49601g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super i> f49602h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<i> f49603i;
    public d.a.q0.n.o.f j;
    public final d.a.q0.n.i.m.g k;
    public d.a.q0.n.f.c<i> l;
    public final Map<String, d.a.q0.a.n0.k.e> m;
    public final Map<String, d.a.q0.n.l.a> n;
    public final d.a.q0.a.n0.k.d o;
    public final d.a.q0.n.j.c<JSONArray> p;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.n.j.c<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f49604a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49604a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.j.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.f49604a.m.isEmpty()) {
                return;
            }
            for (d.a.q0.a.n0.k.e eVar : this.f49604a.m.values()) {
                if (eVar != null && eVar.r(this.f49604a)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.v2.e1.b<d.a.q0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f49605e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49605e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                if (f.q) {
                    String str = this.f49605e.f49601g;
                    Log.i(str, "onCallback: SoUpdating=" + eVar);
                }
                if (eVar != null) {
                    this.f49605e.o.c(eVar.k(), eVar.o());
                }
                this.f49605e.Y(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.v2.e1.b<d.a.q0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f49606e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49606e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            this.f49606e.o.d(eVar.k(), eVar.m());
        }
    }

    /* loaded from: classes8.dex */
    public class d implements c.InterfaceC0795c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f49607a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f49608b;

        public d(f fVar, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49608b = fVar;
            this.f49607a = iVar;
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f49608b.j.k(this.f49607a);
                if (this.f49608b.f49602h != null) {
                    this.f49608b.f49602h.onNext(this.f49607a);
                    this.f49608b.f49602h.onCompleted();
                }
            }
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void b(PMSDownloadType pMSDownloadType, d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f49608b.j.j(this.f49607a);
                if (this.f49608b.f49602h != null) {
                    this.f49608b.f49602h.onError(new PkgDownloadError(this.f49607a, aVar));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f49609e;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49609e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super i> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f49609e.f49602h = jVar;
            }
        }
    }

    /* renamed from: d.a.q0.a.n0.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0881f extends h.j<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f49610e;

        public C0881f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49610e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(i iVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) && f.q) {
                String str = this.f49610e.f49601g;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + iVar.toString());
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (f.q) {
                    Log.e(this.f49610e.f49601g, "PkgDlSubscriber 包下载完成");
                }
                this.f49610e.d0(null);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (f.q) {
                    String str = this.f49610e.f49601g;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.f49610e.d0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ C0881f(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes8.dex */
    public class g extends d.a.q0.n.f.b<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f49611e;

        public g(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49611e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.c
        /* renamed from: l */
        public String d(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iVar)) == null) {
                String g2 = d.a.q0.a.n0.k.c.f49579d.g(iVar);
                if (f.q) {
                    String str = this.f49611e.f49601g;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + iVar.f53938g + " path=" + g2);
                }
                return g2;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.q0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f49611e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: o */
        public void e(i iVar, d.a.q0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, aVar) == null) {
                super.e(iVar, aVar);
                if (f.q) {
                    String str = this.f49611e.f49601g;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + iVar.f53938g + " err=" + aVar);
                }
                this.f49611e.j.j(iVar);
                d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f53928a);
                aVar2.c("so包下载失败");
                aVar2.e(aVar.toString());
                if (this.f49611e.f49602h != null) {
                    this.f49611e.f49602h.onError(new PkgDownloadError(iVar, aVar2));
                }
                d.a.q0.a.h0.m.c.c().a(iVar, f.s, aVar2);
                d.a.q0.t.d.j(iVar.f53932a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: p */
        public void i(i iVar) {
            d.a.q0.n.l.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
                super.i(iVar);
                if (f.q) {
                    String str = this.f49611e.f49601g;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + iVar);
                }
                String str2 = iVar.p;
                if (TextUtils.isEmpty(str2) && (aVar = (d.a.q0.n.l.a) this.f49611e.n.get(iVar.f53938g)) != null) {
                    str2 = aVar.f54109a;
                }
                d.a.q0.a.n0.k.e Z = this.f49611e.Z(str2);
                if (Z != null) {
                    boolean a2 = j0.a(new File(iVar.f53932a), iVar.m);
                    if (f.q) {
                        String str3 = this.f49611e.f49601g;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + iVar.f53938g + " checkSign=" + a2);
                    }
                    boolean z = true;
                    z = (f.q && !q0.G() && d.a.q0.a.u1.a.a.j() == 1) ? false : false;
                    if (a2 || z) {
                        d.a.q0.n.g.a.h().l(iVar);
                        if (f.q) {
                            String str4 = this.f49611e.f49601g;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + Z + " libName=" + str2);
                        }
                    }
                    Z.q();
                }
                this.f49611e.j.k(iVar);
                if (this.f49611e.f49602h != null) {
                    this.f49611e.f49602h.onNext(iVar);
                    this.f49611e.f49602h.onCompleted();
                }
                d.a.q0.a.h0.m.c.c().b(iVar, f.s);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: q */
        public void a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
                super.a(iVar);
                d.a.q0.n.l.a aVar = (d.a.q0.n.l.a) this.f49611e.n.get(iVar.f53938g);
                d.a.q0.a.n0.k.e Z = this.f49611e.Z(aVar == null ? null : aVar.f54109a);
                if (Z != null) {
                    Z.x(new d.b(iVar.f53933b, iVar.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: r */
        public void c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) {
                super.c(iVar);
                if (f.q) {
                    String str = this.f49611e.f49601g;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + iVar.f53938g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: s */
        public void f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
                super.f(iVar);
                if (f.q) {
                    String str = this.f49611e.f49601g;
                    Log.i(str, "SoDlCallback onDownloading: so=" + iVar.f53938g);
                }
                this.f49611e.e0(iVar);
            }
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1735591309, "Ld/a/q0/a/n0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1735591309, "Ld/a/q0/a/n0/k/f;");
                return;
            }
        }
        q = k.f49133a;
        r = 0;
        s = PMSDownloadType.SO_LIB;
    }

    public f(d.a.q0.n.i.m.g gVar, d.a.q0.a.n0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49601g = "SwanSoUpdater";
        this.m = new HashMap();
        this.n = new HashMap();
        this.p = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f49601g);
        int i4 = r;
        r = i4 + 1;
        sb.append(i4);
        String sb2 = sb.toString();
        this.f49601g = sb2;
        if (q) {
            Log.i(sb2, "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.k = gVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                d.a.q0.a.n0.k.a a2 = d.a.q0.a.n0.k.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    d.a.q0.a.n0.k.e t = d.a.q0.a.n0.k.c.f49579d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.m.put(e2, t);
                    this.n.putAll(d.a.q0.n.l.a.b(e2));
                }
            }
        }
        if (q) {
            String str = this.f49601g;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.m.size());
        }
        if (this.m.isEmpty()) {
            d0(null);
        }
    }

    @Override // d.a.q0.n.f.g
    public void B(d.a.q0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (q) {
                String str = this.f49601g;
                Log.e(str, "onFetchError: " + aVar.toString());
            }
            d0(new Exception("failed by fetch error = " + aVar));
        }
    }

    @Override // d.a.q0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            if (q) {
                Log.e(this.f49601g, "onFetchSuccess:");
            }
        }
    }

    @Override // d.a.q0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            if (q) {
                Log.e(this.f49601g, "onNoPackage:");
            }
            d0(null);
        }
    }

    @Override // d.a.q0.n.f.g
    public void F(d.a.q0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            if (q) {
                String str = this.f49601g;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(fVar == null ? 0 : fVar.l());
                Log.i(str, sb.toString());
            }
            super.F(fVar);
            if (fVar == null) {
                return;
            }
            this.j = fVar;
            if (fVar.i()) {
                return;
            }
            b0();
        }
    }

    public final void Y(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (q) {
                String str = this.f49601g;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.m.size() + " e=" + exc);
            }
            for (d.a.q0.a.n0.k.e eVar : this.m.values()) {
                if (!eVar.n()) {
                    if (q) {
                        String str2 = this.f49601g;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + eVar);
                        return;
                    }
                    return;
                }
            }
            c0(exc);
        }
    }

    public final d.a.q0.a.n0.k.e Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            d.a.q0.a.n0.k.e eVar = this.m.get(str);
            if (eVar == null || !eVar.r(this)) {
                return null;
            }
            return eVar;
        }
        return (d.a.q0.a.n0.k.e) invokeL.objValue;
    }

    public final h.j<i> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f49603i == null) {
                this.f49603i = new C0881f(this, null);
            }
            return this.f49603i;
        }
        return (h.j) invokeV.objValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.j.e()) {
                arrayList.add(h.d.b(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.l(arrayList).z(a0());
        }
    }

    public final void c0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (q) {
                String str = this.f49601g;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            d.a.q0.a.n0.k.d dVar = this.o;
            if (dVar != null) {
                dVar.b(exc);
            }
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (q) {
                String str = this.f49601g;
                Log.i(str, "notifyPmsFinish: updatings=" + this.m.size() + " e=" + exc);
            }
            for (d.a.q0.a.n0.k.e eVar : this.m.values()) {
                if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                    if (q) {
                        String str2 = this.f49601g;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + eVar);
                    }
                    eVar.q();
                }
            }
            Y(exc);
        }
    }

    public final void e0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
            d.a.q0.a.h0.m.c.c().d(iVar, new d(this, iVar));
        }
    }

    public final void f0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) {
            if (q) {
                String str = this.f49601g;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + iVar);
            }
            if (iVar == null) {
                if (q) {
                    Log.i(this.f49601g, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            d.a.q0.n.l.a aVar = this.n.get(iVar.f53938g);
            if (aVar == null) {
                if (q) {
                    String str2 = this.f49601g;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.f53938g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(iVar.p)) {
                iVar.p = aVar.f54109a;
            }
            d.a.q0.a.n0.k.e Z = Z(iVar.p);
            if (Z == null) {
                if (q) {
                    String str3 = this.f49601g;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.p);
                    return;
                }
                return;
            }
            if (iVar.q == null) {
                iVar.q = aVar.f54111c;
            }
            if (!AbiType.currentAbi().compat(iVar.q)) {
                if (q) {
                    Log.i(this.f49601g, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            i l = Z.l();
            i j = Z.j();
            long max = Math.max(j != null ? j.f53940i : 0L, l == null ? 0L : l.f53940i);
            long j2 = iVar.f53940i;
            if (j2 < max) {
                if (q) {
                    Log.i(this.f49601g, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.f53940i)));
                }
            } else if (j2 > max) {
                if (q) {
                    String str4 = this.f49601g;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.f53940i);
                }
                Z.w(this, iVar);
            } else {
                if (j == null || !j.q.compat(iVar.q)) {
                    if (q) {
                        String str5 = this.f49601g;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + iVar.q);
                    }
                    Z.w(this, iVar);
                }
                if (q) {
                    Log.i(this.f49601g, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // d.a.q0.n.k.a.a
    public d.a.q0.n.j.c<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (d.a.q0.n.j.c) invokeV.objValue;
    }

    @Override // d.a.q0.n.k.a.a
    @Nullable
    public d.a.q0.n.i.m.g getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (d.a.q0.n.i.m.g) invokeV.objValue;
    }

    @Override // d.a.q0.n.j.k.c
    public void handle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.q0.n.j.k.a aVar = new d.a.q0.n.j.k.a();
            d.a.q0.n.o.f fVar = new d.a.q0.n.o.f();
            if (q) {
                Log.i(this.f49601g, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((q && !q0.G() && d.a.q0.a.u1.a.a.j() == 1) ? false : false) {
                String i2 = d.a.q0.a.u1.a.a.i();
                if (!TextUtils.isEmpty(i2)) {
                    try {
                        i iVar = (i) d.a.q0.n.o.e.i(new JSONObject(i2), new i());
                        iVar.f53938g = "so_zeus_armeabi";
                        f0(iVar);
                        d.a.q0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_success)).F();
                    } catch (JSONException e2) {
                        d.a.q0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_error)).F();
                        e2.printStackTrace();
                    }
                }
            }
            for (d.a.q0.a.n0.k.e eVar : this.m.values()) {
                if (eVar.r(this)) {
                    f0(eVar.l());
                    i j = eVar.j();
                    if (eVar.p() && j != null) {
                        if (q) {
                            String str = this.f49601g;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        d.a.q0.n.j.k.b.b(j, fVar);
                        if (aVar.f54102d == null) {
                            aVar.f54102d = new ArrayList();
                        }
                        aVar.f54102d.add(j);
                    } else {
                        if (q) {
                            Log.i(this.f49601g, "SoNodeHandler localSo not update, just check for install");
                        }
                        eVar.q();
                    }
                }
            }
            if (q) {
                Log.i(this.f49601g, "SoNodeHandler handle for loop end");
                String str2 = this.f49601g;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + fVar.l());
            }
            if (fVar.l() == 0) {
                if (q) {
                    Log.i(this.f49601g, "SoNodeHandler handle end by no pkg");
                }
                E();
                return;
            }
            if (q) {
                Log.i(this.f49601g, "SoNodeHandler handle end by start dl");
            }
            F(fVar);
            d.a.q0.n.i.i.a.e(aVar, this);
        }
    }

    @Override // d.a.q0.n.j.k.c
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (q) {
                String str = this.f49601g;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                f0((i) d.a.q0.n.o.e.i(jSONObject, new i()));
            }
        }
    }

    @Override // d.a.q0.n.k.a.a
    public d.a.q0.n.f.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (d.a.q0.n.f.g) invokeV.objValue;
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.j.k.c v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.v(str) : (d.a.q0.n.j.k.c) invokeL.objValue;
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.f.c<i> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.l == null) {
                this.l = new g(this, null);
            }
            return this.l;
        }
        return (d.a.q0.n.f.c) invokeV.objValue;
    }
}
