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
import com.repackage.sh2;
/* loaded from: classes6.dex */
public final class mg2 extends cd2<sh2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final sh2.a h;

    /* loaded from: classes6.dex */
    public class a implements sh2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mg2 a;

        public a(mg2 mg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mg2Var;
        }

        @Override // com.repackage.sh2.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onStateChange", Integer.valueOf(i));
        }

        @Override // com.repackage.sh2.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onInfo", Integer.valueOf(i));
        }

        @Override // com.repackage.sh2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                yp1.e().l(str, false);
            }
        }

        @Override // com.repackage.sh2.a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onNetStatus", str);
        }

        @Override // com.repackage.sh2.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPlayed", null);
                }
                yp1.e().l(str, true);
                yp1.e().k(str);
            }
        }

        @Override // com.repackage.sh2.a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onVideoSizeChanged", null);
        }

        @Override // com.repackage.sh2.a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onEnded", null);
        }

        @Override // com.repackage.sh2.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onError", Integer.valueOf(i));
        }

        @Override // com.repackage.sh2.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onPrepared", null);
        }

        @Override // com.repackage.sh2.a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                if (mg2.i) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                yp1.e().q(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755500327, "Lcom/repackage/mg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755500327, "Lcom/repackage/mg2;");
                return;
            }
        }
        i = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg2(@NonNull sh2 sh2Var) {
        super(sh2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sh2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ed2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        sh2Var.h0(aVar);
        this.a.a(new pg2());
        this.a.a(new qg2());
        this.a.a(new rg2());
        this.a.a(new ug2());
        this.a.a(new tg2());
        this.a.a(new sg2());
        this.a.a(new vg2());
        this.a.a(new wg2());
        this.a.a(new xg2());
        this.a.a(new yg2());
        this.a.a(new ah2());
        this.a.a(new bh2());
        this.a.a(new ch2());
        this.a.a(new dh2());
        this.a.a(new fh2());
        this.a.a(new gh2());
        this.a.a(new hh2());
        this.a.a(new jh2());
        this.a.a(new kh2());
        this.a.a(new eh2());
        this.a.a(new zg2());
        this.a.a(new ih2());
    }
}
