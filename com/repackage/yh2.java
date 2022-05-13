package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.repackage.fj2;
/* loaded from: classes7.dex */
public final class yh2 extends pe2<fj2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final fj2.a h;

    /* loaded from: classes7.dex */
    public class a implements fj2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh2 a;

        public a(yh2 yh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh2Var;
        }

        @Override // com.repackage.fj2.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onStateChange", Integer.valueOf(i));
        }

        @Override // com.repackage.fj2.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onInfo", Integer.valueOf(i));
        }

        @Override // com.repackage.fj2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                lr1.e().l(str, false);
            }
        }

        @Override // com.repackage.fj2.a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onNetStatus", str);
        }

        @Override // com.repackage.fj2.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPlayed", null);
                }
                lr1.e().l(str, true);
            }
        }

        @Override // com.repackage.fj2.a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onVideoSizeChanged", null);
        }

        @Override // com.repackage.fj2.a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onEnded", null);
        }

        @Override // com.repackage.fj2.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onError", Integer.valueOf(i));
        }

        @Override // com.repackage.fj2.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onPrepared", null);
        }

        @Override // com.repackage.fj2.a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                lr1.e().q(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755141874, "Lcom/repackage/yh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755141874, "Lcom/repackage/yh2;");
                return;
            }
        }
        i = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yh2(@NonNull fj2 fj2Var) {
        super(fj2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fj2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((re2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        fj2Var.h0(aVar);
        lr1.e().b(fj2Var);
        this.a.a(new ci2());
        this.a.a(new di2());
        this.a.a(new ei2());
        this.a.a(new hi2());
        this.a.a(new gi2());
        this.a.a(new fi2());
        this.a.a(new ii2());
        this.a.a(new ji2());
        this.a.a(new ki2());
        this.a.a(new li2());
        this.a.a(new ni2());
        this.a.a(new oi2());
        this.a.a(new pi2());
        this.a.a(new qi2());
        this.a.a(new si2());
        this.a.a(new ti2());
        this.a.a(new wi2());
        this.a.a(new xi2());
        this.a.a(new ri2());
        this.a.a(new mi2());
        this.a.a(new vi2());
    }

    @Override // com.repackage.pe2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (w(command)) {
                if (i) {
                    Log.d("LiveInlineController", "reject command => " + command.what);
                    return;
                }
                return;
            }
            super.sendCommand(command);
        }
    }

    public final boolean w(ZeusPlugin.Command command) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command)) == null) {
            if (command != null && TextUtils.equals(command.what, oi2.b)) {
                if (i) {
                    Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                }
                return false;
            }
            int a2 = ((fj2) this.c).a();
            if (i && a2 != 1) {
                String str = command == null ? "" : command.what;
                Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((fj2) this.c).a() + " command=> " + str);
            }
            return a2 == 2;
        }
        return invokeL.booleanValue;
    }
}
