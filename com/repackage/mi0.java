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
public abstract class mi0 implements ti0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ei0 a;
    public long b;
    public si0 c;
    public qi0 d;
    public vi0 e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-184572800, "Lcom/repackage/mi0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-184572800, "Lcom/repackage/mi0$a;");
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

    public mi0(@NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ei0Var};
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
        this.a = ei0Var;
        d();
    }

    @Override // com.repackage.ti0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, ei0Var) == null) {
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
                    this.a.i = Math.max(ei0Var.i, ei0Var.j);
                    li0.f().j(this.a);
                    vi0 vi0Var = this.e;
                    if (vi0Var != null) {
                        vi0Var.f(ei0Var, this.a.i);
                        break;
                    }
                    break;
                case 5:
                    r();
                    vi0 vi0Var2 = this.e;
                    if (vi0Var2 != null) {
                        vi0Var2.h(ei0Var);
                        break;
                    }
                    break;
                case 6:
                    r();
                    break;
                case 7:
                    r();
                    b(AdDownloadCode.ERROR_OTHERS);
                    vi0 vi0Var3 = this.e;
                    if (vi0Var3 != null) {
                        vi0Var3.b(ei0Var, AdDownloadCode.ERROR_OTHERS);
                        return;
                    }
                    return;
            }
            b(AdDownloadCode.SUCCESS);
        }
    }

    public final void b(AdDownloadCode adDownloadCode) {
        si0 si0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (si0Var = this.c) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            si0Var.a(this.a.c);
        } else {
            si0Var.b(adDownloadCode);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            rh0.b().a(this.a);
            vi0 vi0Var = this.e;
            if (vi0Var != null) {
                vi0Var.d(this.a);
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
            if (!cj0.e(this.a.h)) {
                rh0.b().a(this.a);
                this.a.f();
            }
            AdAppStateManager.instance().register(this.a);
            cj0.c(this.a.h);
            vi0 vi0Var = this.e;
            if (vi0Var != null) {
                vi0Var.g(this.a);
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
                    rh0.d(AdDownloadAction.INSTALL_START, this.a);
                    break;
                case 6:
                    if (cj0.b(this.a.d)) {
                        rh0.c(this.a);
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
            gg0.b(this.a.f);
        }
    }

    @Override // com.repackage.ti0
    public ei0 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (ei0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            rh0.b().f(this.a);
            r();
            vi0 vi0Var = this.e;
            if (vi0Var != null) {
                vi0Var.a(this.a);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            rh0.b().g(this.a.d(), this);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            rh0.b().j(this.a.d(), this);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            rh0.b().h(this.a);
            vi0 vi0Var = this.e;
            if (vi0Var != null) {
                vi0Var.e(this.a);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(null);
        }
    }

    public void m(@Nullable si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, si0Var) == null) {
            this.c = si0Var;
            if (f()) {
                b(AdDownloadCode.ERROR_FAST_CLICK);
                vi0 vi0Var = this.e;
                if (vi0Var != null) {
                    vi0Var.b(this.a, AdDownloadCode.ERROR_FAST_CLICK);
                }
            } else if (this.a.e()) {
                b(AdDownloadCode.ERROR_INVALID_DATA);
                vi0 vi0Var2 = this.e;
                if (vi0Var2 != null) {
                    vi0Var2.b(this.a, AdDownloadCode.ERROR_INVALID_DATA);
                }
            } else {
                g();
                b(AdDownloadCode.SUCCESS);
            }
        }
    }

    public void n(vi0 vi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vi0Var) == null) {
            this.e = vi0Var;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            rh0.b().i(this.a);
            vi0 vi0Var = this.e;
            if (vi0Var != null) {
                vi0Var.c(this.a);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.d == null && this.a.a()) {
                this.d = new qi0(this.a);
            }
            qi0 qi0Var = this.d;
            if (qi0Var != null) {
                qi0Var.a();
            }
        }
    }

    public final void r() {
        qi0 qi0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (qi0Var = this.d) == null) {
            return;
        }
        qi0Var.c();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.h(uh0.a().query(this.a.d()));
        }
    }
}
