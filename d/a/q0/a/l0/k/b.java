package d.a.q0.a.l0.k;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.p.d.m0;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes8.dex */
public class b implements V8Engine.V8EngineConsole {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.l0.a f49247a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49248b;

    public b(d.a.q0.a.l0.a aVar) {
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
        this.f49248b = true;
        this.f49247a = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f49248b) {
                Log.d("V8Console", this.f49247a.m0() + str);
            }
            d.a.q0.a.c1.b.h().e(2, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d.a.q0.a.c1.b.h().e(4, str);
            Log.e("V8Console", this.f49247a.m0() + str);
            m0 g0 = d.a.q0.a.c1.a.g0();
            g0.e("V8Console", this.f49247a.m0() + str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (this.f49248b) {
                Log.i("V8Console", this.f49247a.m0() + str);
            }
            d.a.q0.a.c1.b.h().e(3, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.f49248b) {
                Log.v("V8Console", this.f49247a.m0() + str);
            }
            d.a.q0.a.c1.b.h().e(1, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f49248b) {
                Log.d("V8Console", this.f49247a.m0() + str);
            }
            d.a.q0.a.c1.b.h().e(6, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            d.a.q0.a.c1.b.h().e(5, str);
            Log.w("V8Console", this.f49247a.m0() + str);
            m0 g0 = d.a.q0.a.c1.a.g0();
            g0.w("V8Console", this.f49247a.m0() + str);
        }
    }
}
