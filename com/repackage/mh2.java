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
import com.repackage.ti2;
/* loaded from: classes6.dex */
public final class mh2 extends de2<ti2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ti2.a h;

    /* loaded from: classes6.dex */
    public class a implements ti2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2 a;

        public a(mh2 mh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh2Var;
        }

        @Override // com.repackage.ti2.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onStateChange", Integer.valueOf(i));
        }

        @Override // com.repackage.ti2.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onInfo", Integer.valueOf(i));
        }

        @Override // com.repackage.ti2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                zq1.e().l(str, false);
            }
        }

        @Override // com.repackage.ti2.a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onNetStatus", str);
        }

        @Override // com.repackage.ti2.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPlayed", null);
                }
                zq1.e().l(str, true);
            }
        }

        @Override // com.repackage.ti2.a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onVideoSizeChanged", null);
        }

        @Override // com.repackage.ti2.a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onEnded", null);
        }

        @Override // com.repackage.ti2.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onError", Integer.valueOf(i));
        }

        @Override // com.repackage.ti2.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onPrepared", null);
        }

        @Override // com.repackage.ti2.a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                zq1.e().q(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755499366, "Lcom/repackage/mh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755499366, "Lcom/repackage/mh2;");
                return;
            }
        }
        i = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mh2(@NonNull ti2 ti2Var) {
        super(ti2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ti2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((fe2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        ti2Var.h0(aVar);
        zq1.e().b(ti2Var);
        this.a.a(new qh2());
        this.a.a(new rh2());
        this.a.a(new sh2());
        this.a.a(new vh2());
        this.a.a(new uh2());
        this.a.a(new th2());
        this.a.a(new wh2());
        this.a.a(new xh2());
        this.a.a(new yh2());
        this.a.a(new zh2());
        this.a.a(new bi2());
        this.a.a(new ci2());
        this.a.a(new di2());
        this.a.a(new ei2());
        this.a.a(new gi2());
        this.a.a(new hi2());
        this.a.a(new ki2());
        this.a.a(new li2());
        this.a.a(new fi2());
        this.a.a(new ai2());
        this.a.a(new ji2());
    }

    @Override // com.repackage.de2, com.baidu.webkit.sdk.plugin.ZeusPlugin
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
            if (command != null && TextUtils.equals(command.what, ci2.b)) {
                if (i) {
                    Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                }
                return false;
            }
            int a2 = ((ti2) this.c).a();
            if (i && a2 != 1) {
                String str = command == null ? "" : command.what;
                Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((ti2) this.c).a() + " command=> " + str);
            }
            return a2 == 2;
        }
        return invokeL.booleanValue;
    }
}
