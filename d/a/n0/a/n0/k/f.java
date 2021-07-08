package d.a.n0.a.n0.k;

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
import d.a.n0.a.h;
import d.a.n0.a.h0.m.c;
import d.a.n0.a.h0.m.j;
import d.a.n0.a.k;
import d.a.n0.a.n0.k.d;
import d.a.n0.a.v2.j0;
import d.a.n0.a.v2.q0;
import d.a.n0.n.h.i;
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
/* loaded from: classes7.dex */
public final class f extends j implements d.a.n0.n.k.a.a, d.a.n0.n.j.k.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static int r;
    public static final PMSDownloadType s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f46299g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super i> f46300h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<i> f46301i;
    public d.a.n0.n.o.f j;
    public final d.a.n0.n.i.m.g k;
    public d.a.n0.n.f.c<i> l;
    public final Map<String, d.a.n0.a.n0.k.e> m;
    public final Map<String, d.a.n0.n.l.a> n;
    public final d.a.n0.a.n0.k.d o;
    public final d.a.n0.n.j.c<JSONArray> p;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.n.j.c<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f46302a;

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
            this.f46302a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.j.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.f46302a.m.isEmpty()) {
                return;
            }
            for (d.a.n0.a.n0.k.e eVar : this.f46302a.m.values()) {
                if (eVar != null && eVar.r(this.f46302a)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.v2.e1.b<d.a.n0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46303e;

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
            this.f46303e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                if (f.q) {
                    String str = this.f46303e.f46299g;
                    Log.i(str, "onCallback: SoUpdating=" + eVar);
                }
                if (eVar != null) {
                    this.f46303e.o.c(eVar.k(), eVar.o());
                }
                this.f46303e.Y(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.n0.a.v2.e1.b<d.a.n0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46304e;

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
            this.f46304e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            this.f46304e.o.d(eVar.k(), eVar.m());
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.InterfaceC0744c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f46305a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f46306b;

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
            this.f46306b = fVar;
            this.f46305a = iVar;
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f46306b.j.k(this.f46305a);
                if (this.f46306b.f46300h != null) {
                    this.f46306b.f46300h.onNext(this.f46305a);
                    this.f46306b.f46300h.onCompleted();
                }
            }
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void b(PMSDownloadType pMSDownloadType, d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f46306b.j.j(this.f46305a);
                if (this.f46306b.f46300h != null) {
                    this.f46306b.f46300h.onError(new PkgDownloadError(this.f46305a, aVar));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46307e;

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
            this.f46307e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super i> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f46307e.f46300h = jVar;
            }
        }
    }

    /* renamed from: d.a.n0.a.n0.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0830f extends h.j<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46308e;

        public C0830f(f fVar) {
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
            this.f46308e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(i iVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) && f.q) {
                String str = this.f46308e.f46299g;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + iVar.toString());
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (f.q) {
                    Log.e(this.f46308e.f46299g, "PkgDlSubscriber 包下载完成");
                }
                this.f46308e.d0(null);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (f.q) {
                    String str = this.f46308e.f46299g;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.f46308e.d0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ C0830f(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes7.dex */
    public class g extends d.a.n0.n.f.b<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46309e;

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
            this.f46309e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.c
        /* renamed from: l */
        public String d(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iVar)) == null) {
                String g2 = d.a.n0.a.n0.k.c.f46277d.g(iVar);
                if (f.q) {
                    String str = this.f46309e.f46299g;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + iVar.f50636g + " path=" + g2);
                }
                return g2;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.n0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f46309e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: o */
        public void e(i iVar, d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, aVar) == null) {
                super.e(iVar, aVar);
                if (f.q) {
                    String str = this.f46309e.f46299g;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + iVar.f50636g + " err=" + aVar);
                }
                this.f46309e.j.j(iVar);
                d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f50626a);
                aVar2.c("so包下载失败");
                aVar2.e(aVar.toString());
                if (this.f46309e.f46300h != null) {
                    this.f46309e.f46300h.onError(new PkgDownloadError(iVar, aVar2));
                }
                d.a.n0.a.h0.m.c.c().a(iVar, f.s, aVar2);
                d.a.n0.t.d.j(iVar.f50630a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: p */
        public void i(i iVar) {
            d.a.n0.n.l.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
                super.i(iVar);
                if (f.q) {
                    String str = this.f46309e.f46299g;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + iVar);
                }
                String str2 = iVar.p;
                if (TextUtils.isEmpty(str2) && (aVar = (d.a.n0.n.l.a) this.f46309e.n.get(iVar.f50636g)) != null) {
                    str2 = aVar.f50807a;
                }
                d.a.n0.a.n0.k.e Z = this.f46309e.Z(str2);
                if (Z != null) {
                    boolean a2 = j0.a(new File(iVar.f50630a), iVar.m);
                    if (f.q) {
                        String str3 = this.f46309e.f46299g;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + iVar.f50636g + " checkSign=" + a2);
                    }
                    boolean z = true;
                    z = (f.q && !q0.G() && d.a.n0.a.u1.a.a.j() == 1) ? false : false;
                    if (a2 || z) {
                        d.a.n0.n.g.a.h().l(iVar);
                        if (f.q) {
                            String str4 = this.f46309e.f46299g;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + Z + " libName=" + str2);
                        }
                    }
                    Z.q();
                }
                this.f46309e.j.k(iVar);
                if (this.f46309e.f46300h != null) {
                    this.f46309e.f46300h.onNext(iVar);
                    this.f46309e.f46300h.onCompleted();
                }
                d.a.n0.a.h0.m.c.c().b(iVar, f.s);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: q */
        public void a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
                super.a(iVar);
                d.a.n0.n.l.a aVar = (d.a.n0.n.l.a) this.f46309e.n.get(iVar.f50636g);
                d.a.n0.a.n0.k.e Z = this.f46309e.Z(aVar == null ? null : aVar.f50807a);
                if (Z != null) {
                    Z.x(new d.b(iVar.f50631b, iVar.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: r */
        public void c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) {
                super.c(iVar);
                if (f.q) {
                    String str = this.f46309e.f46299g;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + iVar.f50636g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: s */
        public void f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
                super.f(iVar);
                if (f.q) {
                    String str = this.f46309e.f46299g;
                    Log.i(str, "SoDlCallback onDownloading: so=" + iVar.f50636g);
                }
                this.f46309e.e0(iVar);
            }
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1348343152, "Ld/a/n0/a/n0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1348343152, "Ld/a/n0/a/n0/k/f;");
                return;
            }
        }
        q = k.f45831a;
        r = 0;
        s = PMSDownloadType.SO_LIB;
    }

    public f(d.a.n0.n.i.m.g gVar, d.a.n0.a.n0.k.d dVar) {
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
        this.f46299g = "SwanSoUpdater";
        this.m = new HashMap();
        this.n = new HashMap();
        this.p = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f46299g);
        int i4 = r;
        r = i4 + 1;
        sb.append(i4);
        String sb2 = sb.toString();
        this.f46299g = sb2;
        if (q) {
            Log.i(sb2, "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.k = gVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                d.a.n0.a.n0.k.a a2 = d.a.n0.a.n0.k.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    d.a.n0.a.n0.k.e t = d.a.n0.a.n0.k.c.f46277d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.m.put(e2, t);
                    this.n.putAll(d.a.n0.n.l.a.b(e2));
                }
            }
        }
        if (q) {
            String str = this.f46299g;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.m.size());
        }
        if (this.m.isEmpty()) {
            d0(null);
        }
    }

    @Override // d.a.n0.n.f.g
    public void B(d.a.n0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (q) {
                String str = this.f46299g;
                Log.e(str, "onFetchError: " + aVar.toString());
            }
            d0(new Exception("failed by fetch error = " + aVar));
        }
    }

    @Override // d.a.n0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            if (q) {
                Log.e(this.f46299g, "onFetchSuccess:");
            }
        }
    }

    @Override // d.a.n0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            if (q) {
                Log.e(this.f46299g, "onNoPackage:");
            }
            d0(null);
        }
    }

    @Override // d.a.n0.n.f.g
    public void F(d.a.n0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            if (q) {
                String str = this.f46299g;
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
                String str = this.f46299g;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.m.size() + " e=" + exc);
            }
            for (d.a.n0.a.n0.k.e eVar : this.m.values()) {
                if (!eVar.n()) {
                    if (q) {
                        String str2 = this.f46299g;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + eVar);
                        return;
                    }
                    return;
                }
            }
            c0(exc);
        }
    }

    public final d.a.n0.a.n0.k.e Z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            d.a.n0.a.n0.k.e eVar = this.m.get(str);
            if (eVar == null || !eVar.r(this)) {
                return null;
            }
            return eVar;
        }
        return (d.a.n0.a.n0.k.e) invokeL.objValue;
    }

    public final h.j<i> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f46301i == null) {
                this.f46301i = new C0830f(this, null);
            }
            return this.f46301i;
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
                String str = this.f46299g;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            d.a.n0.a.n0.k.d dVar = this.o;
            if (dVar != null) {
                dVar.b(exc);
            }
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (q) {
                String str = this.f46299g;
                Log.i(str, "notifyPmsFinish: updatings=" + this.m.size() + " e=" + exc);
            }
            for (d.a.n0.a.n0.k.e eVar : this.m.values()) {
                if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                    if (q) {
                        String str2 = this.f46299g;
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
            d.a.n0.a.h0.m.c.c().d(iVar, new d(this, iVar));
        }
    }

    public final void f0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) {
            if (q) {
                String str = this.f46299g;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + iVar);
            }
            if (iVar == null) {
                if (q) {
                    Log.i(this.f46299g, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            d.a.n0.n.l.a aVar = this.n.get(iVar.f50636g);
            if (aVar == null) {
                if (q) {
                    String str2 = this.f46299g;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.f50636g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(iVar.p)) {
                iVar.p = aVar.f50807a;
            }
            d.a.n0.a.n0.k.e Z = Z(iVar.p);
            if (Z == null) {
                if (q) {
                    String str3 = this.f46299g;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.p);
                    return;
                }
                return;
            }
            if (iVar.q == null) {
                iVar.q = aVar.f50809c;
            }
            if (!AbiType.currentAbi().compat(iVar.q)) {
                if (q) {
                    Log.i(this.f46299g, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            i l = Z.l();
            i j = Z.j();
            long max = Math.max(j != null ? j.f50638i : 0L, l == null ? 0L : l.f50638i);
            long j2 = iVar.f50638i;
            if (j2 < max) {
                if (q) {
                    Log.i(this.f46299g, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.f50638i)));
                }
            } else if (j2 > max) {
                if (q) {
                    String str4 = this.f46299g;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.f50638i);
                }
                Z.w(this, iVar);
            } else {
                if (j == null || !j.q.compat(iVar.q)) {
                    if (q) {
                        String str5 = this.f46299g;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + iVar.q);
                    }
                    Z.w(this, iVar);
                }
                if (q) {
                    Log.i(this.f46299g, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // d.a.n0.n.k.a.a
    public d.a.n0.n.j.c<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (d.a.n0.n.j.c) invokeV.objValue;
    }

    @Override // d.a.n0.n.k.a.a
    @Nullable
    public d.a.n0.n.i.m.g getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (d.a.n0.n.i.m.g) invokeV.objValue;
    }

    @Override // d.a.n0.n.j.k.c
    public void handle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.n0.n.j.k.a aVar = new d.a.n0.n.j.k.a();
            d.a.n0.n.o.f fVar = new d.a.n0.n.o.f();
            if (q) {
                Log.i(this.f46299g, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((q && !q0.G() && d.a.n0.a.u1.a.a.j() == 1) ? false : false) {
                String i2 = d.a.n0.a.u1.a.a.i();
                if (!TextUtils.isEmpty(i2)) {
                    try {
                        i iVar = (i) d.a.n0.n.o.e.i(new JSONObject(i2), new i());
                        iVar.f50636g = "so_zeus_armeabi";
                        f0(iVar);
                        d.a.n0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_success)).F();
                    } catch (JSONException e2) {
                        d.a.n0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_error)).F();
                        e2.printStackTrace();
                    }
                }
            }
            for (d.a.n0.a.n0.k.e eVar : this.m.values()) {
                if (eVar.r(this)) {
                    f0(eVar.l());
                    i j = eVar.j();
                    if (eVar.p() && j != null) {
                        if (q) {
                            String str = this.f46299g;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        d.a.n0.n.j.k.b.b(j, fVar);
                        if (aVar.f50800d == null) {
                            aVar.f50800d = new ArrayList();
                        }
                        aVar.f50800d.add(j);
                    } else {
                        if (q) {
                            Log.i(this.f46299g, "SoNodeHandler localSo not update, just check for install");
                        }
                        eVar.q();
                    }
                }
            }
            if (q) {
                Log.i(this.f46299g, "SoNodeHandler handle for loop end");
                String str2 = this.f46299g;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + fVar.l());
            }
            if (fVar.l() == 0) {
                if (q) {
                    Log.i(this.f46299g, "SoNodeHandler handle end by no pkg");
                }
                E();
                return;
            }
            if (q) {
                Log.i(this.f46299g, "SoNodeHandler handle end by start dl");
            }
            F(fVar);
            d.a.n0.n.i.i.a.e(aVar, this);
        }
    }

    @Override // d.a.n0.n.j.k.c
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (q) {
                String str = this.f46299g;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                f0((i) d.a.n0.n.o.e.i(jSONObject, new i()));
            }
        }
    }

    @Override // d.a.n0.n.k.a.a
    public d.a.n0.n.f.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (d.a.n0.n.f.g) invokeV.objValue;
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.j.k.c v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.v(str) : (d.a.n0.n.j.k.c) invokeL.objValue;
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.f.c<i> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.l == null) {
                this.l = new g(this, null);
            }
            return this.l;
        }
        return (d.a.n0.n.f.c) invokeV.objValue;
    }
}
