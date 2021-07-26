package d.a.o0.a.u.e.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.n2.a.a;
import d.a.o0.a.u.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.u.e.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0941a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48280a;

        /* renamed from: d.a.o0.a.u.e.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0942a implements a.InterfaceC0845a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48281a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l f48282b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C0941a f48283c;

            public C0942a(C0941a c0941a, String str, l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0941a, str, lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48283c = c0941a;
                this.f48281a = str;
                this.f48282b = lVar;
            }

            @Override // d.a.o0.a.n2.a.a.InterfaceC0845a
            public void a(double[] dArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                    if (dArr != null && dArr.length == 3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("x", dArr[0]);
                            jSONObject.put("y", dArr[1]);
                            jSONObject.put("z", dArr[2]);
                            this.f48282b.d(this.f48283c.f48280a, jSONObject);
                            return;
                        } catch (JSONException e2) {
                            d.a.o0.a.e0.d.b("Api-Accelerometer", "handle compass,json error，" + e2.toString());
                            this.f48282b.f(this.f48283c.f48280a, "Json error");
                            return;
                        }
                    }
                    d.a.o0.a.e0.d.b("Api-Accelerometer", "illegal accelerometers");
                    this.f48283c.f48280a.d(this.f48281a, new d.a.o0.a.u.h.b(1001));
                }
            }
        }

        public C0941a(a aVar) {
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
            this.f48280a = aVar;
        }

        @Override // d.a.o0.a.u.c.d.b
        public d.a.o0.a.u.h.b a(d.a.o0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                d.a.o0.a.e0.d.g("Api-Accelerometer", " init ");
                l lVar = new l("accelerometerChange", jSONObject, str);
                d.a.o0.a.n2.a.a a2 = d.a.o0.a.n2.a.a.a();
                a2.b(this.f48280a.i(), b.a(jSONObject.optString("interval")));
                a2.e(new C0942a(this, str, lVar));
                a2.f();
                lVar.b(this.f48280a);
                return new d.a.o0.a.u.h.b(0);
            }
            return (d.a.o0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static ArrayMap<String, Integer> f48284a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-704360489, "Ld/a/o0/a/u/e/o/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-704360489, "Ld/a/o0/a/u/e/o/a$b;");
                    return;
                }
            }
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            f48284a = arrayMap;
            arrayMap.put(IMTrackDatabase.UiEnum.TABLE_NAME, 60);
            f48284a.put("game", 20);
            f48284a.put("normal", 200);
        }

        public static int a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                Integer num = f48284a.get(str);
                if (num != null) {
                    return num.intValue();
                }
                return 200;
            }
            return invokeL.intValue;
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
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-Accelerometer", "start listen accelerometer");
            }
            return j(str, true, new C0941a(this));
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public d.a.o0.a.u.h.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-Accelerometer", "stop accelerometer");
            }
            d.a.o0.a.e0.d.g("Api-Accelerometer", "stop listen accelerometer");
            d.a.o0.a.n2.a.a.a().g();
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeV.objValue;
    }
}
