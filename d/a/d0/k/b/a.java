package d.a.d0.k.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.util.HttpSigner;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d0.k.a.f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f42052a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.d0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0573a extends d.a.d0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.l.a f42053a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42054b;

        public C0573a(d.a.d0.l.a aVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42053a = aVar;
            this.f42054b = jSONObject;
        }

        @Override // d.a.d0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                d.a.d0.l.a aVar = this.f42053a;
                if (aVar != null) {
                    aVar.a(1, str);
                }
                d.a.d0.k.c.a.e(this.f42054b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            d.a.d0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (aVar = this.f42053a) == null) {
                return;
            }
            aVar.a(0, "");
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends d.a.d0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.l.a f42055a;

        public b(d.a.d0.l.a aVar) {
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
            this.f42055a = aVar;
        }

        @Override // d.a.d0.k.a.a
        public void b(Throwable th, String str) {
            d.a.d0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) || (aVar = this.f42055a) == null) {
                return;
            }
            aVar.a(1, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            d.a.d0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (aVar = this.f42055a) == null) {
                return;
            }
            aVar.a(0, "");
        }
    }

    public static final void a(JSONArray jSONArray, d.a.d0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONArray, aVar) == null) || jSONArray == null) {
            return;
        }
        d.a.d0.k.a.c cVar = new d.a.d0.k.a.c();
        c.a(cVar);
        d.a.d0.k.a.b bVar = new d.a.d0.k.a.b();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        bVar.e("batchData", jSONArray2);
        HttpSigner.b(bVar);
        new f(false).a(d.b(), cVar, bVar, new b(aVar));
    }

    public static final void b(JSONObject jSONObject, d.a.d0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, jSONObject, aVar) == null) || jSONObject == null) {
            return;
        }
        d.a.d0.k.a.c cVar = new d.a.d0.k.a.c();
        c.a(cVar);
        d.a.d0.k.a.b c2 = c.c(jSONObject);
        c.b(cVar, c2.b("bduss"));
        HttpSigner.b(c2);
        new f(false).a(d.e(), cVar, c2, new C0573a(aVar, jSONObject));
    }

    public static final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f42052a = i2;
        }
    }

    public static final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f42052a : invokeV.intValue;
    }
}
