package d.a.n0.a.l0.k;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.p.d.m0;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes7.dex */
public class b implements V8Engine.V8EngineConsole {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.a.l0.a f45945a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45946b;

    public b(d.a.n0.a.l0.a aVar) {
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
        this.f45946b = true;
        this.f45945a = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f45946b) {
                Log.d("V8Console", this.f45945a.m0() + str);
            }
            d.a.n0.a.c1.b.h().e(2, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d.a.n0.a.c1.b.h().e(4, str);
            Log.e("V8Console", this.f45945a.m0() + str);
            m0 g0 = d.a.n0.a.c1.a.g0();
            g0.e("V8Console", this.f45945a.m0() + str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (this.f45946b) {
                Log.i("V8Console", this.f45945a.m0() + str);
            }
            d.a.n0.a.c1.b.h().e(3, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.f45946b) {
                Log.v("V8Console", this.f45945a.m0() + str);
            }
            d.a.n0.a.c1.b.h().e(1, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f45946b) {
                Log.d("V8Console", this.f45945a.m0() + str);
            }
            d.a.n0.a.c1.b.h().e(6, str);
        }
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            d.a.n0.a.c1.b.h().e(5, str);
            Log.w("V8Console", this.f45945a.m0() + str);
            m0 g0 = d.a.n0.a.c1.a.g0();
            g0.w("V8Console", this.f45945a.m0() + str);
        }
    }
}
