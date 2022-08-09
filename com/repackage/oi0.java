package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class oi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public AdDownloadStatus c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public File h;
    public float i;
    public float j;
    public Uri k;
    public long l;
    public long m;
    public int n;
    public String o;
    public si0 p;
    public pi0 q;
    public ri0 r;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-127314498, "Lcom/repackage/oi0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-127314498, "Lcom/repackage/oi0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public oi0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = -1;
        this.c = AdDownloadStatus.NONE;
        this.i = 0.0f;
        this.j = 0.0f;
        this.n = -1;
        this.p = new si0();
        this.q = new pi0();
        this.r = new ri0();
    }

    @NonNull
    public static oi0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        um0 um0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            oi0 oi0Var = new oi0();
            if (adBaseModel != null && (um0Var = adBaseModel.l) != null && um0Var.e) {
                oi0Var.g = um0Var.c;
                oi0Var.h(um0Var.d);
                oi0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                oi0Var.f = adOperator == null ? null : adOperator.d;
                oi0Var.p.a = adBaseModel.f.d;
            }
            return oi0Var;
        }
        return (oi0) invokeL.objValue;
    }

    @NonNull
    public static oi0 d(um0 um0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, um0Var, str, str2)) == null) {
            oi0 oi0Var = new oi0();
            if (um0Var != null && um0Var.e) {
                oi0Var.g = um0Var.c;
                oi0Var.h(um0Var.d);
                oi0Var.d = um0Var.a;
                oi0Var.p.a = str;
                oi0Var.f = str2;
            }
            return oi0Var;
        }
        return (oi0) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!f() && this.q.r) {
                return !TextUtils.isEmpty(TextUtils.isEmpty(this.p.c) ? ci0.a(this.d) : this.p.c) || (this.q.t && !TextUtils.isEmpty(this.d));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q.g != 1 : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.g) : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = AdDownloadStatus.NONE;
            this.i = 0.0f;
            this.j = 0.0f;
            this.h = null;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str == null) {
            return;
        }
        this.a = str;
    }

    public void i(oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oi0Var) == null) {
            if (oi0Var != null && TextUtils.equals(e(), oi0Var.e())) {
                int i = a.a[oi0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !qj0.b(oi0Var.d)) {
                        File file = oi0Var.h;
                        if (file != null && file.exists()) {
                            oi0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            oi0Var.g();
                            return;
                        }
                    }
                } else if (qj0.b(oi0Var.d)) {
                    oi0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!qj0.e(oi0Var.h)) {
                    ai0.b().a(oi0Var);
                    oi0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = oi0Var.d;
                }
                this.b = oi0Var.b;
                this.c = oi0Var.c;
                this.i = oi0Var.i;
                this.j = oi0Var.j;
                this.h = oi0Var.h;
                this.d = oi0Var.d;
                this.l = oi0Var.l;
                this.m = oi0Var.m;
                pi0 pi0Var = this.q;
                pi0 pi0Var2 = oi0Var.q;
                pi0Var.k = pi0Var2.k;
                pi0Var.l = pi0Var2.l;
                this.p.h = oi0Var.p.h;
                this.k = oi0Var.k;
            } else if (qj0.b(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
