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
/* loaded from: classes5.dex */
public abstract class bj0 implements jj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final si0 a;
    public long b;
    public ij0 c;
    public gj0 d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-498569940, "Lcom/repackage/bj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-498569940, "Lcom/repackage/bj0$a;");
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

    public bj0(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {si0Var};
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
        this.a = si0Var;
        e();
    }

    @Override // com.repackage.jj0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, si0Var) == null) {
            switch (a.a[adDownloadAction.ordinal()]) {
                case 1:
                    if (this.a.q.q) {
                        yz0.a().b(hh0.b(), R.string.obfuscated_res_0x7f0f0b51);
                    }
                    ui0 ui0Var = this.a.p.k;
                    if (ui0Var != null && !TextUtils.isEmpty(ui0Var.a)) {
                        ui0 ui0Var2 = this.a.p.k;
                        d(ui0Var2.a, ui0Var2.b);
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
                    this.a.i = Math.max(si0Var.i, si0Var.j);
                    aj0.f().j(this.a);
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
        ij0 ij0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (ij0Var = this.c) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            ij0Var.a(this.a.c);
        } else {
            ij0Var.b(adDownloadCode);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ei0.b().a(this.a);
        }
    }

    public final void d(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            Context b = hh0.b();
            Object systemService = b.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (systemService instanceof ClipboardManager) {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b.getResources().getString(R.string.obfuscated_res_0x7f0f0ba5), str));
                yz0.a().a(b, str2);
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
            if (!tj0.e(this.a.h)) {
                ei0.b().a(this.a);
                this.a.f();
                return false;
            }
            AdAppStateManager.instance().register(this.a);
            return tj0.c(this.a.h);
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

    @Override // com.repackage.jj0
    public si0 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (si0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            switch (a.b[this.a.c.ordinal()]) {
                case 1:
                    p();
                    break;
                case 2:
                    ei0.d(AdDownloadAction.FAIL_RETRY, this.a);
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
                        ei0.d(AdDownloadAction.INSTALL_START, this.a);
                        break;
                    }
                    break;
                case 6:
                    if (tj0.b(this.a.d)) {
                        ei0.c(this.a);
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
            qg0.b(this.a.f);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (qj0.c().e(this)) {
                qj0.c().d();
                return;
            }
            ei0.b().f(this.a);
            r();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ei0.b().g(this.a.d(), this);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ei0.b().j(this.a.d(), this);
            fj0.b(this.a);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ei0.b().h(this.a);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            n(this.c);
        }
    }

    public void n(@Nullable ij0 ij0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ij0Var) == null) {
            this.c = ij0Var;
            if (g()) {
                b(AdDownloadCode.ERROR_FAST_CLICK);
            } else if (this.a.e()) {
                b(AdDownloadCode.ERROR_INVALID_DATA);
            } else {
                h();
                b(AdDownloadCode.SUCCESS);
            }
        }
    }

    public void o(ij0 ij0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ij0Var) == null) {
            this.c = ij0Var;
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ei0.b().i(this.a);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.d == null && this.a.a()) {
                this.d = fj0.a(this.a);
            }
            gj0 gj0Var = this.d;
            if (gj0Var != null) {
                gj0Var.a();
            }
        }
    }

    public final void r() {
        gj0 gj0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (gj0Var = this.d) == null) {
            return;
        }
        gj0Var.d();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.h(ii0.a().query(this.a.d()));
        }
    }
}
