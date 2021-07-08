package d.a.n0.a.o;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f46496a;

    /* renamed from: b  reason: collision with root package name */
    public String f46497b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.f.i.p.b f46498c;

    /* renamed from: d  reason: collision with root package name */
    public c f46499d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.f.i.l.f f46500e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.a.o.a> f46501f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.a.o.a f46502g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.a.o.a f46503h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f46504i;
    public d.a.n0.f.i.p.a j;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f46505a;

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
            this.f46505a = fVar;
        }

        @Override // d.a.n0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f46505a.f46499d.b();
                    this.f46505a.f46502g.a(0);
                    for (d.a.n0.a.o.a aVar : this.f46505a.f46501f) {
                        aVar.a(0);
                        if (this.f46505a.f46501f.contains(aVar)) {
                            this.f46505a.f46501f.remove(aVar);
                        }
                    }
                    return;
                }
                this.f46505a.f46502g.a(1001);
                for (d.a.n0.a.o.a aVar2 : this.f46505a.f46501f) {
                    aVar2.a(1001);
                    if (this.f46505a.f46501f.contains(aVar2)) {
                        this.f46505a.f46501f.remove(aVar2);
                    }
                }
            }
        }

        @Override // d.a.n0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.f46505a.f46503h.a(0);
                } else {
                    this.f46505a.f46503h.a(1001);
                }
            }
        }

        @Override // d.a.n0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f46505a.f46499d.a(e.a(z));
            }
        }

        @Override // d.a.n0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // d.a.n0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f46505a.f46499d.c(e.b(str));
                d.a.n0.f.i.q.b.k(this.f46505a.f46504i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, d.a.n0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46496a = "";
        this.f46504i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f46496a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f46497b = optString;
            this.f46504i = d.a.n0.f.i.q.b.a("video", "app", optString, this.f46496a, false);
            this.f46500e = new g();
            d.a.n0.f.i.p.b bVar = new d.a.n0.f.i.p.b(d.a.n0.a.g1.f.V().getActivity(), this.f46497b, this.f46496a, false, this.j, this.f46500e);
            this.f46498c = bVar;
            bVar.k0(this.f46504i);
            this.f46501f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // d.a.n0.a.o.b
    public synchronized void a(JSONObject jSONObject, d.a.n0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f46498c != null) {
                    this.f46503h = aVar;
                    this.f46498c.l0();
                }
            }
        }
    }

    @Override // d.a.n0.a.o.b
    public synchronized void b(JSONObject jSONObject, d.a.n0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f46499d = cVar;
                if (this.f46498c != null) {
                    this.f46502g = aVar;
                    if (aVar != null && !this.f46501f.contains(aVar)) {
                        this.f46501f.add(aVar);
                    }
                    this.f46498c.e0();
                }
            }
        }
    }
}
