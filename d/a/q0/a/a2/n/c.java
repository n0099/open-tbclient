package d.a.q0.a.a2.n;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46716a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final f<a> f46717e;

        /* renamed from: f  reason: collision with root package name */
        public static final e<a> f46718f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f46719a;

        /* renamed from: b  reason: collision with root package name */
        public int f46720b;

        /* renamed from: c  reason: collision with root package name */
        public int f46721c;

        /* renamed from: d  reason: collision with root package name */
        public int f46722d;

        /* renamed from: d.a.q0.a.a2.n.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C0685a extends f<a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0685a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull a aVar, @NonNull d.a.q0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                    dVar.writeInt(aVar.f46719a);
                    dVar.writeInt(aVar.f46720b);
                    dVar.writeInt(aVar.f46721c);
                    dVar.writeInt(aVar.f46722d);
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends e<a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.a2.n.e
            /* renamed from: c */
            public a b(@NonNull d.a.q0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    a aVar = new a();
                    aVar.f46719a = cVar.readInt();
                    aVar.f46720b = cVar.readInt();
                    aVar.f46721c = cVar.readInt();
                    aVar.f46722d = cVar.readInt();
                    return aVar;
                }
                return (a) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1540526239, "Ld/a/q0/a/a2/n/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1540526239, "Ld/a/q0/a/a2/n/c$a;");
                    return;
                }
            }
            f46717e = new C0685a();
            f46718f = new b();
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

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return b();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
                if (optJSONObject == null) {
                    return b();
                }
                a aVar = new a();
                aVar.f46720b = optJSONObject.optInt("connectSocket", 60000);
                aVar.f46719a = optJSONObject.optInt("request", c());
                aVar.f46720b = optJSONObject.optInt("connectSocket", 60000);
                aVar.f46721c = optJSONObject.optInt("uploadFile");
                aVar.f46722d = optJSONObject.optInt("downloadFile");
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (c.f46716a) {
                    Log.w("SwanAppCommonConfigData", "NetworkConfig createNullObject()");
                }
                a aVar = new a();
                aVar.f46719a = 60000;
                aVar.f46720b = 60000;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? d.a.q0.a.c1.a.Z().u() : invokeV.intValue;
        }

        public static int d(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar)) == null) {
                return aVar != null && aVar.f46719a > 0 ? aVar.f46719a : c();
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1154674370, "Ld/a/q0/a/a2/n/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1154674370, "Ld/a/q0/a/a2/n/c;");
                return;
            }
        }
        f46716a = k.f49133a;
    }
}
