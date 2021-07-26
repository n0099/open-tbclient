package d.a.o0.a.o;

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
    public String f47000a;

    /* renamed from: b  reason: collision with root package name */
    public String f47001b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.f.i.p.b f47002c;

    /* renamed from: d  reason: collision with root package name */
    public c f47003d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.f.i.l.f f47004e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.o0.a.o.a> f47005f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.a.o.a f47006g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.a.o.a f47007h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f47008i;
    public d.a.o0.f.i.p.a j;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f47009a;

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
            this.f47009a = fVar;
        }

        @Override // d.a.o0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f47009a.f47003d.b();
                    this.f47009a.f47006g.a(0);
                    for (d.a.o0.a.o.a aVar : this.f47009a.f47005f) {
                        aVar.a(0);
                        if (this.f47009a.f47005f.contains(aVar)) {
                            this.f47009a.f47005f.remove(aVar);
                        }
                    }
                    return;
                }
                this.f47009a.f47006g.a(1001);
                for (d.a.o0.a.o.a aVar2 : this.f47009a.f47005f) {
                    aVar2.a(1001);
                    if (this.f47009a.f47005f.contains(aVar2)) {
                        this.f47009a.f47005f.remove(aVar2);
                    }
                }
            }
        }

        @Override // d.a.o0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.f47009a.f47007h.a(0);
                } else {
                    this.f47009a.f47007h.a(1001);
                }
            }
        }

        @Override // d.a.o0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f47009a.f47003d.a(e.a(z));
            }
        }

        @Override // d.a.o0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // d.a.o0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f47009a.f47003d.c(e.b(str));
                d.a.o0.f.i.q.b.k(this.f47009a.f47008i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, d.a.o0.a.o.a aVar) {
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
        this.f47000a = "";
        this.f47008i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f47000a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f47001b = optString;
            this.f47008i = d.a.o0.f.i.q.b.a("video", "app", optString, this.f47000a, false);
            this.f47004e = new g();
            d.a.o0.f.i.p.b bVar = new d.a.o0.f.i.p.b(d.a.o0.a.g1.f.V().getActivity(), this.f47001b, this.f47000a, false, this.j, this.f47004e);
            this.f47002c = bVar;
            bVar.k0(this.f47008i);
            this.f47005f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // d.a.o0.a.o.b
    public synchronized void a(JSONObject jSONObject, d.a.o0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f47002c != null) {
                    this.f47007h = aVar;
                    this.f47002c.l0();
                }
            }
        }
    }

    @Override // d.a.o0.a.o.b
    public synchronized void b(JSONObject jSONObject, d.a.o0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f47003d = cVar;
                if (this.f47002c != null) {
                    this.f47006g = aVar;
                    if (aVar != null && !this.f47005f.contains(aVar)) {
                        this.f47005f.add(aVar);
                    }
                    this.f47002c.e0();
                }
            }
        }
    }
}
