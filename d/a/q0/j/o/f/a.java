package d.a.q0.j.o.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.h1.b;
import d.a.q0.a.k;
import d.a.q0.j.k.f.d;
import d.a.q0.j.o.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.j.k.a<d.a.q0.a.h1.c.a> implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f53842a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.h1.c.a f53843b;

    /* renamed from: d.a.q0.j.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1190a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f53844a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53845b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f53846c;

        public C1190a(a aVar, b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53846c = aVar;
            this.f53844a = bVar;
            this.f53845b = str;
        }

        @Override // d.a.q0.j.k.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.e0.d.l("map", "location permission fail");
                this.f53844a.b(this.f53845b, 1003, "location permission fail");
            }
        }

        @Override // d.a.q0.j.k.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.e0.d.l("map", "location permission success");
                this.f53846c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1963490701, "Ld/a/q0/j/o/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1963490701, "Ld/a/q0/j/o/f/a;");
                return;
            }
        }
        boolean z = k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // d.a.q0.j.o.a.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        b bVar;
        d.a.q0.a.h1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (bVar = this.f53842a) == null || (aVar = this.f53843b) == null) {
            return;
        }
        bVar.c(aVar.D, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, d.a.q0.a.h1.c.a aVar, b bVar, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar, bVar, eVar)) == null) {
            d.a.q0.a.e0.d.g("map", "ChooseLocationAction start");
            if (!aVar.isValid()) {
                d.a.q0.a.e0.d.b("map", "model is invalid");
                return false;
            }
            String str = aVar.D;
            if (TextUtils.isEmpty(str)) {
                d.a.q0.a.e0.d.b("map", "cb is empty");
                return false;
            }
            this.f53842a = bVar;
            this.f53843b = aVar;
            d.b(context, new C1190a(this, bVar, str));
            d.a.q0.a.e0.d.g("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.j.k.a
    /* renamed from: f */
    public boolean b(Context context, d.a.q0.a.h1.c.a aVar, b bVar, e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, aVar, bVar, eVar, jSONObject)) == null) ? e(context, aVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.q0.j.o.a O2 = d.a.q0.j.o.a.O2(null);
            O2.T2(this);
            O2.V2();
        }
    }

    @Override // d.a.q0.j.o.a.b
    public void onCancel() {
        d.a.q0.a.h1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.q0.a.e0.d.g("map", "choose location cancel");
            b bVar = this.f53842a;
            if (bVar == null || (aVar = this.f53843b) == null) {
                return;
            }
            bVar.b(aVar.D, 1002, "choose location canceled");
        }
    }

    @Override // d.a.q0.j.o.a.b
    public void onError() {
        d.a.q0.a.h1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.q0.a.e0.d.g("map", "choose location fail");
            b bVar = this.f53842a;
            if (bVar == null || (aVar = this.f53843b) == null) {
                return;
            }
            bVar.b(aVar.D, 1007, "choose location failed");
        }
    }
}
