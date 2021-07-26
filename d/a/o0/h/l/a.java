package d.a.o0.h.l;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.e2.c.f;
import d.a.o0.a.k;
import d.a.o0.a.v2.e1.b;
import d.a.o0.h.m0.c;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50569a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.h.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1106a implements b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50570e;

        public C1106a(d.a.o0.a.y.b.a aVar) {
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
            this.f50570e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f44833d || fVar.j != 1) {
                    a.c(this.f50570e, false, "system deny");
                } else {
                    a.c(this.f50570e, true, "authorize:ok");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355521485, "Ld/a/o0/h/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355521485, "Ld/a/o0/h/l/a;");
                return;
            }
        }
        f50569a = k.f46335a;
    }

    public static void b(JsObject jsObject) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, jsObject) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        e Q = e.Q();
        if (Q == null) {
            c(G, false, "authorize:fail internal error");
        } else {
            Q.T().e("mapp_enable_eval", new C1106a(G));
        }
    }

    public static void c(d.a.o0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            if (f50569a) {
                Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
            }
            d.a.o0.h.d.c.b bVar = new d.a.o0.h.d.c.b();
            bVar.errMsg = str;
            c.a(aVar, z, bVar);
        }
    }
}
