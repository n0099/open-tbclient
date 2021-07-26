package d.a.o0.a.t1.c.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.t1.c.d.e;
import d.a.o0.a.u.c.d;
import d.a.o0.n.h.h;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.t1.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0903a implements d.a.o0.a.h0.j.b<d.a.o0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47873a;

        public C0903a(a aVar) {
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
            this.f47873a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.o0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f47873a.w(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.h0.j.b<d.a.o0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47874a;

        public b(a aVar) {
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
            this.f47874a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.o0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f47874a.w(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.h0.j.b<d.a.o0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47875a;

        public c(a aVar) {
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
            this.f47875a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.o0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f47875a.w(aVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            d.a.o0.a.t1.c.b.b v = v(str);
            if (v.b()) {
                d.a.o0.a.t1.d.a.a(v.toString());
                return v.f47890i;
            }
            return new d.a.o0.a.t1.c.d.c().l(v, new b(this));
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public d.a.o0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            d.a.o0.a.t1.c.b.b v = v(str);
            if (v.b()) {
                d.a.o0.a.t1.d.a.a(v.toString());
                return v.f47890i;
            }
            return new e().l(v, new C0903a(this));
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public d.a.o0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            d.a.o0.a.t1.c.b.b v = v(str);
            if (v.b()) {
                d.a.o0.a.t1.d.a.a(v.toString());
                return v.f47890i;
            }
            return new d.a.o0.a.t1.c.d.d().l(v, new c(this));
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final d.a.o0.a.t1.c.b.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            d.a.o0.a.t1.c.b.b bVar = new d.a.o0.a.t1.c.b.b();
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-Base", str);
            bVar.f47890i = (d.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                bVar.f47890i = new d.a.o0.a.u.h.b(201, "pluginProvider is empty");
                return bVar;
            }
            h g2 = d.a.o0.a.t1.g.b.g(optString);
            if (g2 != null) {
                String str2 = g2.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        bVar.f47890i = new d.a.o0.a.u.h.b(201, "providerRootPath is empty");
                        return bVar;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        bVar.f47890i = new d.a.o0.a.u.h.b(201, "slaveId is empty");
                        return bVar;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        bVar.f47890i = new d.a.o0.a.u.h.b(201, "componentId is empty");
                        return bVar;
                    }
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    String str3 = TextUtils.isEmpty(optString5) ? "release" : optString5;
                    JSONObject optJSONObject = jSONObject.optJSONObject("args");
                    String optString6 = jSONObject.optString("cb");
                    bVar.f47882a = str2;
                    bVar.f47883b = optString;
                    bVar.f47884c = optString2;
                    bVar.f47885d = str3;
                    bVar.f47886e = optString3;
                    bVar.f47887f = optString4;
                    bVar.f47888g = optJSONObject;
                    bVar.f47889h = optString6;
                    return bVar;
                }
            }
            bVar.f47890i = new d.a.o0.a.u.h.b(201, "pluginProvider exchange for truth app key，but empty");
            return bVar;
        }
        return (d.a.o0.a.t1.c.b.b) invokeL.objValue;
    }

    public final void w(d.a.o0.a.t1.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.b();
    }
}
