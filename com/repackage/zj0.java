package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class zj0 implements gk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final rj0 a;
    public long b;
    public fk0 c;
    public dk0 d;
    public ik0 e;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(188529684, "Lcom/repackage/zj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(188529684, "Lcom/repackage/zj0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            b = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[AdDownloadStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[AdDownloadStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[AdDownloadStatus.COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[AdDownloadStatus.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[AdDownloadAction.values().length];
            a = iArr2;
            try {
                iArr2[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdDownloadAction.PROGRESS_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public zj0(@NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rj0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0L;
        this.c = null;
        this.a = rj0Var;
        d();
    }

    @Override // com.repackage.gk0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, rj0Var) == null) {
            switch (a.a[adDownloadAction.ordinal()]) {
                case 1:
                    q();
                    break;
                case 2:
                    r();
                    break;
                case 3:
                    q();
                    break;
                case 4:
                    this.a.i = Math.max(rj0Var.i, rj0Var.j);
                    yj0.f().j(this.a);
                    ik0 ik0Var = this.e;
                    if (ik0Var != null) {
                        ik0Var.f(rj0Var, this.a.i);
                        break;
                    }
                    break;
                case 5:
                    r();
                    ik0 ik0Var2 = this.e;
                    if (ik0Var2 != null) {
                        ik0Var2.h(rj0Var);
                        break;
                    }
                    break;
                case 6:
                    r();
                    break;
                case 7:
                    r();
                    b(AdDownloadCode.ERROR_OTHERS);
                    ik0 ik0Var3 = this.e;
                    if (ik0Var3 != null) {
                        ik0Var3.b(rj0Var, AdDownloadCode.ERROR_OTHERS);
                        return;
                    }
                    return;
            }
            b(AdDownloadCode.SUCCESS);
        }
    }

    public final void b(AdDownloadCode adDownloadCode) {
        fk0 fk0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (fk0Var = this.c) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            fk0Var.a(this.a.c);
        } else {
            fk0Var.b(adDownloadCode);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ej0.b().a(this.a);
            ik0 ik0Var = this.e;
            if (ik0Var != null) {
                ik0Var.d(this.a);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            s();
            i();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!pk0.e(this.a.h)) {
                ej0.b().a(this.a);
                this.a.f();
            }
            AdAppStateManager.instance().register(this.a);
            pk0.c(this.a.h);
            ik0 ik0Var = this.e;
            if (ik0Var != null) {
                ik0Var.g(this.a);
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.b;
            this.b = currentTimeMillis;
            return j > 0 && j < 1000;
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            switch (a.b[this.a.c.ordinal()]) {
                case 1:
                case 2:
                    o();
                    break;
                case 3:
                    h();
                    break;
                case 4:
                    k();
                    break;
                case 5:
                    e();
                    ej0.d(AdDownloadAction.INSTALL_START, this.a);
                    break;
                case 6:
                    if (pk0.b(this.a.d)) {
                        ej0.c(this.a);
                        break;
                    } else {
                        this.a.c = AdDownloadStatus.NONE;
                        o();
                        break;
                    }
            }
            if (TextUtils.isEmpty(this.a.f)) {
                return;
            }
            th0.b(this.a.f);
        }
    }

    @Override // com.repackage.gk0
    public rj0 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (rj0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ej0.b().f(this.a);
            r();
            ik0 ik0Var = this.e;
            if (ik0Var != null) {
                ik0Var.a(this.a);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ej0.b().g(this.a.d(), this);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ej0.b().j(this.a.d(), this);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ej0.b().h(this.a);
            ik0 ik0Var = this.e;
            if (ik0Var != null) {
                ik0Var.e(this.a);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(null);
        }
    }

    public void m(@Nullable fk0 fk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fk0Var) == null) {
            this.c = fk0Var;
            if (f()) {
                b(AdDownloadCode.ERROR_FAST_CLICK);
                ik0 ik0Var = this.e;
                if (ik0Var != null) {
                    ik0Var.b(this.a, AdDownloadCode.ERROR_FAST_CLICK);
                }
            } else if (this.a.e()) {
                b(AdDownloadCode.ERROR_INVALID_DATA);
                ik0 ik0Var2 = this.e;
                if (ik0Var2 != null) {
                    ik0Var2.b(this.a, AdDownloadCode.ERROR_INVALID_DATA);
                }
            } else {
                g();
                b(AdDownloadCode.SUCCESS);
            }
        }
    }

    public void n(ik0 ik0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ik0Var) == null) {
            this.e = ik0Var;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ej0.b().i(this.a);
            ik0 ik0Var = this.e;
            if (ik0Var != null) {
                ik0Var.c(this.a);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.d == null && this.a.a()) {
                this.d = new dk0(this.a);
            }
            dk0 dk0Var = this.d;
            if (dk0Var != null) {
                dk0Var.a();
            }
        }
    }

    public final void r() {
        dk0 dk0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (dk0Var = this.d) == null) {
            return;
        }
        dk0Var.c();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.h(hj0.a().query(this.a.d()));
        }
    }
}
