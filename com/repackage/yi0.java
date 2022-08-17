package com.repackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class yi0 implements gj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final oi0 a;
    public long b;
    public fj0 c;
    public dj0 d;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(158977012, "Lcom/repackage/yi0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(158977012, "Lcom/repackage/yi0$a;");
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

    public yi0(@NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oi0Var};
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
        this.a = oi0Var;
        e();
    }

    @Override // com.repackage.gj0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, oi0Var) == null) {
            switch (a.a[adDownloadAction.ordinal()]) {
                case 1:
                    if (this.a.q.q) {
                        xz0.a().a(dh0.b(), R.string.obfuscated_res_0x7f0f0b62);
                    }
                    qi0 qi0Var = this.a.p.k;
                    if (qi0Var != null && !TextUtils.isEmpty(qi0Var.a)) {
                        qi0 qi0Var2 = this.a.p.k;
                        d(qi0Var2.a, qi0Var2.b);
                    }
                    q();
                    break;
                case 2:
                    r();
                    break;
                case 3:
                    q();
                    break;
                case 4:
                    this.a.i = Math.max(oi0Var.i, oi0Var.j);
                    xi0.f().j(this.a);
                    break;
                case 5:
                    r();
                    break;
                case 6:
                    r();
                    break;
                case 7:
                    r();
                    b(AdDownloadCode.ERROR_OTHERS);
                    return;
            }
            b(AdDownloadCode.SUCCESS);
        }
    }

    public final void b(AdDownloadCode adDownloadCode) {
        fj0 fj0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (fj0Var = this.c) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            fj0Var.a(this.a.c);
        } else {
            fj0Var.b(adDownloadCode);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ai0.b().a(this.a);
        }
    }

    public final void d(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            Context b = dh0.b();
            Object systemService = b.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (systemService instanceof ClipboardManager) {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b.getResources().getString(R.string.obfuscated_res_0x7f0f0bb7), str));
                xz0.a().showToast(b, str2);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            s();
            j();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!qj0.e(this.a.h)) {
                ai0.b().a(this.a);
                this.a.g();
                return false;
            }
            AdAppStateManager.instance().register(this.a);
            oi0 oi0Var = this.a;
            return qj0.d(oi0Var.h, oi0Var.a());
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.b;
            this.b = currentTimeMillis;
            return j > 0 && j < 1000;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.gj0
    public oi0 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (oi0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            switch (a.b[this.a.c.ordinal()]) {
                case 1:
                    p();
                    break;
                case 2:
                    ai0.d(AdDownloadAction.FAIL_RETRY, this.a);
                    p();
                    break;
                case 3:
                    i();
                    break;
                case 4:
                    l();
                    break;
                case 5:
                    if (f()) {
                        ai0.d(AdDownloadAction.INSTALL_START, this.a);
                        break;
                    }
                    break;
                case 6:
                    if (qj0.b(this.a.d)) {
                        ai0.c(this.a);
                        break;
                    } else {
                        this.a.c = AdDownloadStatus.NONE;
                        p();
                        break;
                    }
            }
            if (TextUtils.isEmpty(this.a.f)) {
                return;
            }
            mg0.b(this.a.f);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (nj0.c().e(this)) {
                nj0.c().d();
                return;
            }
            ai0.b().h(this.a);
            r();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ai0.b().i(this.a.e(), this);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ai0.b().l(this.a.e(), this);
            cj0.b(this.a);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ai0.b().j(this.a);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            n(this.c);
        }
    }

    public void n(@Nullable fj0 fj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fj0Var) == null) {
            this.c = fj0Var;
            if (g()) {
                b(AdDownloadCode.ERROR_FAST_CLICK);
            } else if (this.a.f()) {
                b(AdDownloadCode.ERROR_INVALID_DATA);
            } else {
                h();
                b(AdDownloadCode.SUCCESS);
            }
        }
    }

    public void o(fj0 fj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fj0Var) == null) {
            this.c = fj0Var;
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ai0.b().k(this.a);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.d == null && this.a.b()) {
                this.d = cj0.a(this.a);
            }
            dj0 dj0Var = this.d;
            if (dj0Var != null) {
                dj0Var.a();
            }
        }
    }

    public final void r() {
        dj0 dj0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (dj0Var = this.d) == null) {
            return;
        }
        dj0Var.d();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.i(ei0.a().query(this.a.e()));
        }
    }
}
