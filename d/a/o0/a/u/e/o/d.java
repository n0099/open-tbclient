package d.a.o0.a.u.e.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.n2.f.a;
import d.a.o0.a.u.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f48286a;

        /* renamed from: d.a.o0.a.u.e.o.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0943a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f48287a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f48288b;

            public C0943a(a aVar, l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48288b = aVar;
                this.f48287a = lVar;
            }

            @Override // d.a.o0.a.n2.f.a.c
            public void a(float f2, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("direction", f2);
                        jSONObject.put("accuracy", d.a.o0.a.n2.f.a.h(i2));
                        this.f48287a.d(this.f48288b.f48286a, jSONObject);
                    } catch (JSONException e2) {
                        d.a.o0.a.e0.d.b("Api-Compass", "handle compass,json error，" + e2.toString());
                        this.f48287a.f(this.f48288b.f48286a, "Json error");
                    }
                }
            }
        }

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48286a = dVar;
        }

        @Override // d.a.o0.a.u.c.d.b
        public d.a.o0.a.u.h.b a(d.a.o0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                d.a.o0.a.e0.d.g("Api-Compass", " init ");
                l lVar = new l("compassChange", jSONObject, str);
                d.a.o0.a.n2.f.a i2 = d.a.o0.a.n2.f.a.i();
                i2.l(this.f48286a.i());
                i2.o(new C0943a(this, lVar));
                d.a.o0.a.e0.d.g("Api-Compass", "start listen compass");
                i2.p();
                lVar.b(this.f48286a);
                return new d.a.o0.a.u.h.b(0);
            }
            return (d.a.o0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull d.a.o0.a.u.c.b bVar) {
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
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-Compass", "start listen compass");
            }
            return j(str, true, new a(this));
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public d.a.o0.a.u.h.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-Compass", "stop accelerometer");
            }
            d.a.o0.a.e0.d.g("Api-Compass", "stop listen compass");
            d.a.o0.a.n2.f.a.i().q();
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeV.objValue;
    }
}
