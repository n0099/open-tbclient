package d.a.q0.a.o;

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
/* loaded from: classes8.dex */
public class f implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49798a;

    /* renamed from: b  reason: collision with root package name */
    public String f49799b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.f.i.p.b f49800c;

    /* renamed from: d  reason: collision with root package name */
    public c f49801d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.f.i.l.f f49802e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.q0.a.o.a> f49803f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.a.o.a f49804g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.a.o.a f49805h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f49806i;
    public d.a.q0.f.i.p.a j;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f49807a;

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
            this.f49807a = fVar;
        }

        @Override // d.a.q0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f49807a.f49801d.b();
                    this.f49807a.f49804g.a(0);
                    for (d.a.q0.a.o.a aVar : this.f49807a.f49803f) {
                        aVar.a(0);
                        if (this.f49807a.f49803f.contains(aVar)) {
                            this.f49807a.f49803f.remove(aVar);
                        }
                    }
                    return;
                }
                this.f49807a.f49804g.a(1001);
                for (d.a.q0.a.o.a aVar2 : this.f49807a.f49803f) {
                    aVar2.a(1001);
                    if (this.f49807a.f49803f.contains(aVar2)) {
                        this.f49807a.f49803f.remove(aVar2);
                    }
                }
            }
        }

        @Override // d.a.q0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.f49807a.f49805h.a(0);
                } else {
                    this.f49807a.f49805h.a(1001);
                }
            }
        }

        @Override // d.a.q0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f49807a.f49801d.a(e.a(z));
            }
        }

        @Override // d.a.q0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // d.a.q0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f49807a.f49801d.c(e.b(str));
                d.a.q0.f.i.q.b.k(this.f49807a.f49806i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, d.a.q0.a.o.a aVar) {
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
        this.f49798a = "";
        this.f49806i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f49798a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f49799b = optString;
            this.f49806i = d.a.q0.f.i.q.b.a("video", "app", optString, this.f49798a, false);
            this.f49802e = new g();
            d.a.q0.f.i.p.b bVar = new d.a.q0.f.i.p.b(d.a.q0.a.g1.f.V().getActivity(), this.f49799b, this.f49798a, false, this.j, this.f49802e);
            this.f49800c = bVar;
            bVar.k0(this.f49806i);
            this.f49803f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // d.a.q0.a.o.b
    public synchronized void a(JSONObject jSONObject, d.a.q0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f49800c != null) {
                    this.f49805h = aVar;
                    this.f49800c.l0();
                }
            }
        }
    }

    @Override // d.a.q0.a.o.b
    public synchronized void b(JSONObject jSONObject, d.a.q0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f49801d = cVar;
                if (this.f49800c != null) {
                    this.f49804g = aVar;
                    if (aVar != null && !this.f49803f.contains(aVar)) {
                        this.f49803f.add(aVar);
                    }
                    this.f49800c.e0();
                }
            }
        }
    }
}
