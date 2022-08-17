package com.repackage;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
/* loaded from: classes5.dex */
public class bj0 extends yi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<hj0<?>> e;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadStatus.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj0(@NonNull oi0 oi0Var) {
        super(oi0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oi0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((oi0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
    }

    @Override // com.repackage.yi0, com.repackage.gj0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, oi0Var) == null) {
            super.a(adDownloadAction, oi0Var);
            u();
        }
    }

    public void t(hj0<?> hj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hj0Var) == null) {
            this.e = new WeakReference<>(hj0Var);
            u();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e == null) {
            return;
        }
        Resources resources = dh0.b().getResources();
        String string = resources.getString(R.string.obfuscated_res_0x7f0f0ba4);
        switch (a.a[this.a.c.ordinal()]) {
            case 1:
                string = TextUtils.isEmpty(this.a.p.d) ? resources.getString(R.string.obfuscated_res_0x7f0f0ba4) : this.a.p.d;
                break;
            case 2:
                string = new DecimalFormat("#.#%").format(this.a.i);
                break;
            case 3:
                string = resources.getString(R.string.obfuscated_res_0x7f0f0b96);
                break;
            case 4:
                string = resources.getString(R.string.obfuscated_res_0x7f0f0b99);
                break;
            case 5:
                string = resources.getString(R.string.obfuscated_res_0x7f0f0b9d);
                break;
            case 6:
                string = resources.getString(R.string.obfuscated_res_0x7f0f0b98);
                break;
        }
        hj0<?> hj0Var = this.e.get();
        if (hj0Var == null) {
            return;
        }
        hj0Var.update(string, this.a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj0(@NonNull oi0 oi0Var, @NonNull hj0<?> hj0Var) {
        super(oi0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oi0Var, hj0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((oi0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = null;
        t(hj0Var);
    }
}
