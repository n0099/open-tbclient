package com.repackage;

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
/* loaded from: classes6.dex */
public class g04 extends EventTargetImpl implements cc0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public d04 b;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755731866, "Lcom/repackage/g04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755731866, "Lcom/repackage/g04;");
                return;
            }
        }
        d = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g04(JSRuntime jSRuntime) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = new d04();
        h04.a().b().s(this);
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.repackage.cc0
    public void onError(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (d) {
                Log.d("GameRecorderApi", "onError:" + i);
            }
            y("error", new c04("internal error"));
        }
    }

    @Override // com.repackage.cc0
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            y("pause", this.b);
            j73 j73Var = new j73();
            j73Var.b = "pause";
            a73.h(j73Var);
        }
    }

    @Override // com.repackage.cc0
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            y("resume", this.b);
            j73 j73Var = new j73();
            j73Var.b = "resume";
            a73.h(j73Var);
        }
    }

    @Override // com.repackage.cc0
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = this.a;
            y("start", i == -1 ? this.b : new e04(i));
            j73 j73Var = new j73();
            j73Var.b = "start";
            a73.h(j73Var);
        }
    }

    @Override // com.repackage.cc0
    public void x(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            if (d) {
                Log.d("GameRecorderApi", "schemeVideoPath:" + this.c);
            }
            y(IntentConfig.STOP, new f04(this.c));
            j73 j73Var = new j73();
            j73Var.b = IntentConfig.STOP;
            j73Var.a("dura", String.valueOf(i / 1000.0f));
            a73.h(j73Var);
        }
    }

    public final void y(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, obj) == null) {
            if (d) {
                Log.i("GameRecorderApi", "dispatchEvent:" + str);
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }
}
