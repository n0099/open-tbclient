package d.a.q0.h.d0;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class f extends EventTargetImpl implements d.a.z.c.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f53211h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f53212e;

    /* renamed from: f  reason: collision with root package name */
    public c f53213f;

    /* renamed from: g  reason: collision with root package name */
    public String f53214g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2030799398, "Ld/a/q0/h/d0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2030799398, "Ld/a/q0/h/d0/f;");
                return;
            }
        }
        f53211h = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(JSRuntime jSRuntime) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime};
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
        this.f53212e = -1;
        this.f53213f = new c();
        g.a().b().s(this);
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f53214g = str;
        }
    }

    @Override // d.a.z.c.c
    public void onError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (f53211h) {
                Log.d("GameRecorderApi", "onError:" + i2);
            }
            y("error", new b("internal error"));
        }
    }

    @Override // d.a.z.c.c
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            y("pause", this.f53213f);
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49120b = "pause";
            d.a.q0.a.j2.k.h(eVar);
        }
    }

    @Override // d.a.z.c.c
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            y("resume", this.f53213f);
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49120b = "resume";
            d.a.q0.a.j2.k.h(eVar);
        }
    }

    @Override // d.a.z.c.c
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = this.f53212e;
            y("start", i2 == -1 ? this.f53213f : new d(i2));
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49120b = "start";
            d.a.q0.a.j2.k.h(eVar);
        }
    }

    @Override // d.a.z.c.c
    public void x(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            if (f53211h) {
                Log.d("GameRecorderApi", "schemeVideoPath:" + this.f53214g);
            }
            y(IntentConfig.STOP, new e(this.f53214g));
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49120b = IntentConfig.STOP;
            eVar.a("dura", String.valueOf(i2 / 1000.0f));
            d.a.q0.a.j2.k.h(eVar);
        }
    }

    public final void y(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, obj) == null) {
            if (f53211h) {
                Log.i("GameRecorderApi", "dispatchEvent:" + str);
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f53212e = i2;
        }
    }
}
