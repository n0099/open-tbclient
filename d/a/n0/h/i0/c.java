package d.a.n0.h.i0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.g1.f;
import d.a.n0.a.k;
import d.a.n0.h.f0.e;
import d.a.n0.h.i0.b;
/* loaded from: classes7.dex */
public class c extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f50027h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.a.l0.c f50028e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.h.d.c.a f50029f;

    /* renamed from: g  reason: collision with root package name */
    public String f50030g;

    /* loaded from: classes7.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f50031a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50031a = cVar;
        }

        @Override // d.a.n0.h.i0.b.a
        public void a(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f50031a.hasEventListener("progressupdate")) {
                d.a.n0.h.i0.d.a aVar = new d.a.n0.h.i0.d.a();
                aVar.progress = i2;
                aVar.totalBytesWritten = j;
                aVar.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = aVar;
                if (c.f50027h) {
                    Log.i("LoadSubpackageTask", "progress :" + i2 + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                }
                this.f50031a.dispatchEvent(jSEvent);
            }
        }

        @Override // d.a.n0.h.i0.b.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f50031a.D(false);
                e.j(this.f50031a.f50030g, i2, "");
            }
        }

        @Override // d.a.n0.h.i0.b.a
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c cVar = this.f50031a;
                this.f50031a.D(cVar.E(cVar.f50030g));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f50033f;

        public b(c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50033f = cVar;
            this.f50032e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f50032e) {
                    if (this.f50033f.f50029f != null) {
                        this.f50033f.f50029f.c();
                        if (c.f50027h) {
                            Log.i("LoadSubpackageTask", "success call");
                        }
                    }
                } else if (this.f50033f.f50029f != null) {
                    this.f50033f.f50029f.a();
                    if (c.f50027h) {
                        Log.i("LoadSubpackageTask", "fail call");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1670009871, "Ld/a/n0/h/i0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1670009871, "Ld/a/n0/h/i0/c;");
                return;
            }
        }
        f50027h = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.a.n0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50028e = cVar;
    }

    public final void D(boolean z) {
        d.a.n0.a.l0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (cVar = this.f50028e) == null) {
            return;
        }
        cVar.runOnJSThread(new b(this, z));
    }

    public final boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f50028e == null) {
                return false;
            }
            String str2 = f.V().A() + d.a.n0.h.i0.a.b().c(str, 2);
            String c2 = d.a.n0.h.i0.a.b().c(str, 3);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c2)) {
                return false;
            }
            this.f50028e.b0(str2, c2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void F(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            H();
            G(jsObject);
            if (TextUtils.isEmpty(this.f50030g)) {
                if (f50027h) {
                    Log.i("LoadSubpackageTask", "params error");
                }
                e.j(this.f50030g, 2111, "");
                return;
            }
            d.a.n0.h.i0.b.a(this.f50030g, new a(this));
        }
    }

    public final void G(JsObject jsObject) {
        d.a.n0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) || jsObject == null || (G = d.a.n0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        this.f50029f = d.a.n0.h.d.c.a.e(G);
        try {
            this.f50030g = G.g("name");
        } catch (JSTypeMismatchException e2) {
            if (f50027h) {
                e2.printStackTrace();
            }
            d.a.n0.h.m0.c.e(this.f50028e, e2);
            H();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f50029f = null;
            this.f50030g = null;
        }
    }
}
