package d.a.n0.a.n1.q.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
/* loaded from: classes7.dex */
public class c implements d.a.n0.a.v2.e1.b<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46394e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.n1.q.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UbcFlowEvent f46395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UbcFlowEvent f46396b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f46397c;

        public a(c cVar, UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, ubcFlowEvent, ubcFlowEvent2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46397c = cVar;
            this.f46395a = ubcFlowEvent;
            this.f46396b = ubcFlowEvent2;
        }

        @Override // d.a.n0.a.n1.q.d.a
        public boolean a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (dVar == null) {
                    return false;
                }
                return this.f46397c.b(dVar, this.f46395a, this.f46396b);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(592162935, "Ld/a/n0/a/n1/q/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(592162935, "Ld/a/n0/a/n1/q/d/c;");
                return;
            }
        }
        f46394e = k.f45831a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b.f().g();
        if (f46394e) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    public final boolean b(@NonNull d dVar, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dVar, ubcFlowEvent, ubcFlowEvent2)) == null) {
            long b2 = dVar.b();
            return b2 >= ubcFlowEvent.g() && b2 <= ubcFlowEvent2.g();
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.v2.e1.b
    /* renamed from: c */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            if (f46394e) {
                Log.i("MaUpdateReporter", "report: flow=" + hybridUbcFlow);
            }
            if (hybridUbcFlow == null) {
                return;
            }
            UbcFlowEvent f2 = hybridUbcFlow.f("naStart");
            UbcFlowEvent f3 = hybridUbcFlow.f("na_first_meaningful_paint");
            if (f2 != null && f3 != null) {
                b.f().h(new a(this, f2, f3));
                b.f().a(hybridUbcFlow);
                if (f46394e) {
                    Log.d("MaUpdateReporter", "na_start ts - " + f2.g());
                    Log.d("MaUpdateReporter", "fmp_end ts - " + f3.g());
                    return;
                }
                return;
            }
            if (f46394e) {
                if (f2 == null) {
                    Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
                } else {
                    Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                }
            }
            b.f().c();
        }
    }
}
