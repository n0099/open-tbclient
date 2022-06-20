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
/* loaded from: classes6.dex */
public abstract class qi0 implements xi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ii0 a;
    public long b;
    public wi0 c;
    public ui0 d;
    public zi0 e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-70056196, "Lcom/repackage/qi0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-70056196, "Lcom/repackage/qi0$a;");
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

    public qi0(@NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ii0Var};
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
        this.a = ii0Var;
        d();
    }

    @Override // com.repackage.xi0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, ii0Var) == null) {
            switch (a.a[adDownloadAction.ordinal()]) {
                case 1:
                    p();
                    break;
                case 2:
                    q();
                    break;
                case 3:
                    p();
                    break;
                case 4:
                    this.a.i = Math.max(ii0Var.i, ii0Var.j);
                    pi0.f().j(this.a);
                    zi0 zi0Var = this.e;
                    if (zi0Var != null) {
                        zi0Var.f(ii0Var, this.a.i);
                        break;
                    }
                    break;
                case 5:
                    q();
                    zi0 zi0Var2 = this.e;
                    if (zi0Var2 != null) {
                        zi0Var2.h(ii0Var);
                        break;
                    }
                    break;
                case 6:
                    q();
                    break;
                case 7:
                    q();
                    b(AdDownloadCode.ERROR_OTHERS);
                    zi0 zi0Var3 = this.e;
                    if (zi0Var3 != null) {
                        zi0Var3.b(ii0Var, AdDownloadCode.ERROR_OTHERS);
                        return;
                    }
                    return;
            }
            b(AdDownloadCode.SUCCESS);
        }
    }

    public final void b(AdDownloadCode adDownloadCode) {
        wi0 wi0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (wi0Var = this.c) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            wi0Var.a(this.a.c);
        } else {
            wi0Var.b(adDownloadCode);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vh0.b().a(this.a);
            zi0 zi0Var = this.e;
            if (zi0Var != null) {
                zi0Var.d(this.a);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            r();
            i();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!gj0.e(this.a.h)) {
                vh0.b().a(this.a);
                this.a.f();
            }
            AdAppStateManager.instance().register(this.a);
            gj0.c(this.a.h);
            zi0 zi0Var = this.e;
            if (zi0Var != null) {
                zi0Var.g(this.a);
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
                    vh0.d(AdDownloadAction.INSTALL_START, this.a);
                    break;
                case 6:
                    if (gj0.b(this.a.d)) {
                        vh0.c(this.a);
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
            kg0.b(this.a.f);
        }
    }

    @Override // com.repackage.xi0
    public ii0 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (ii0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            vh0.b().f(this.a);
            q();
            zi0 zi0Var = this.e;
            if (zi0Var != null) {
                zi0Var.a(this.a);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            vh0.b().g(this.a.d(), this);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            vh0.b().j(this.a.d(), this);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            vh0.b().h(this.a);
            zi0 zi0Var = this.e;
            if (zi0Var != null) {
                zi0Var.e(this.a);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(null);
        }
    }

    public void m(@Nullable wi0 wi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wi0Var) == null) {
            this.c = wi0Var;
            if (f()) {
                b(AdDownloadCode.ERROR_FAST_CLICK);
                zi0 zi0Var = this.e;
                if (zi0Var != null) {
                    zi0Var.b(this.a, AdDownloadCode.ERROR_FAST_CLICK);
                }
            } else if (this.a.e()) {
                b(AdDownloadCode.ERROR_INVALID_DATA);
                zi0 zi0Var2 = this.e;
                if (zi0Var2 != null) {
                    zi0Var2.b(this.a, AdDownloadCode.ERROR_INVALID_DATA);
                }
            } else {
                g();
                b(AdDownloadCode.SUCCESS);
            }
        }
    }

    public void n(zi0 zi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zi0Var) == null) {
            this.e = zi0Var;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            vh0.b().i(this.a);
            zi0 zi0Var = this.e;
            if (zi0Var != null) {
                zi0Var.c(this.a);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.d == null && this.a.a()) {
                this.d = new ui0(this.a);
            }
            ui0 ui0Var = this.d;
            if (ui0Var != null) {
                ui0Var.a();
            }
        }
    }

    public final void q() {
        ui0 ui0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (ui0Var = this.d) == null) {
            return;
        }
        ui0Var.c();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.h(yh0.a().query(this.a.d()));
        }
    }
}
