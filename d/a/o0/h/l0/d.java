package d.a.o0.h.l0;

import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g1.f;
import d.a.o0.a.v2.e0;
import d.a.o0.a.v2.q0;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f50578a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50579e;

        public a(d dVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50579e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e0.a(this.f50579e);
            }
        }
    }

    public d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50578a = b.d(d.a.o0.a.y.b.a.G(jsObject));
        d.a.o0.h.l0.a.a().f(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r1.equals("checkForUpdate") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && this.f50578a != null && JSEvent.isValid(cVar)) {
            char c2 = 0;
            d.a.o0.a.e0.d.g("UpdateManagerApi", String.format("dispatchEvent : eventType = %s; hasUpdate = %s", cVar.type, Boolean.valueOf(cVar.hasUpdate)));
            String str = cVar.type;
            int hashCode = str.hashCode();
            if (hashCode == -1330233754) {
                if (str.equals("updateFailed")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != -1317168438) {
                if (hashCode == -585906598 && str.equals("updateReady")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                this.f50578a.a(cVar);
            } else if (c2 == 1) {
                this.f50578a.c();
            } else if (c2 != 2) {
            } else {
                this.f50578a.b();
            }
        }
    }

    @JavascriptInterface
    public boolean applyUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SwanAppActivity activity = f.V().getActivity();
            if (activity == null) {
                d.a.o0.a.e0.d.b("UpdateManagerApi", "applyUpdate activity is null");
                return false;
            } else if (activity.isDestroyed() || activity.getIntent() == null) {
                return false;
            } else {
                q0.b0(new a(this, activity));
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
