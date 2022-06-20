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
/* loaded from: classes6.dex */
public class ii0 {
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
    public li0 p;
    public ji0 q;
    public ki0 r;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-299089404, "Lcom/repackage/ii0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-299089404, "Lcom/repackage/ii0$a;");
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

    public ii0() {
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
        this.p = new li0();
        this.q = new ji0();
        this.r = new ki0();
    }

    @NonNull
    public static ii0 b(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        km0 km0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            ii0 ii0Var = new ii0();
            if (adBaseModel != null && (km0Var = adBaseModel.l) != null && km0Var.e) {
                ii0Var.g = km0Var.c;
                ii0Var.g(km0Var.d);
                ii0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                ii0Var.f = adOperator == null ? null : adOperator.d;
                ii0Var.p.a = adBaseModel.f.d;
            }
            return ii0Var;
        }
        return (ii0) invokeL.objValue;
    }

    @NonNull
    public static ii0 c(km0 km0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, km0Var, str, str2)) == null) {
            ii0 ii0Var = new ii0();
            if (km0Var != null && km0Var.e) {
                ii0Var.g = km0Var.c;
                ii0Var.g(km0Var.d);
                ii0Var.d = km0Var.a;
                ii0Var.p.a = str;
                ii0Var.f = str2;
            }
            return ii0Var;
        }
        return (ii0) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q.f != 1 : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.g) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = AdDownloadStatus.NONE;
            this.i = 0.0f;
            this.j = 0.0f;
            this.h = null;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.a = str;
    }

    public void h(ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ii0Var) == null) {
            if (ii0Var != null && TextUtils.equals(d(), ii0Var.d())) {
                int i = a.a[ii0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !gj0.b(ii0Var.d)) {
                        File file = ii0Var.h;
                        if (file != null && file.exists()) {
                            ii0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            ii0Var.f();
                            return;
                        }
                    }
                } else if (gj0.b(ii0Var.d)) {
                    ii0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!gj0.e(ii0Var.h)) {
                    vh0.b().a(ii0Var);
                    ii0Var.f();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = ii0Var.d;
                }
                this.b = ii0Var.b;
                this.c = ii0Var.c;
                this.i = ii0Var.i;
                this.j = ii0Var.j;
                this.h = ii0Var.h;
                this.d = ii0Var.d;
                this.l = ii0Var.l;
                this.m = ii0Var.m;
                ji0 ji0Var = this.q;
                ji0 ji0Var2 = ii0Var.q;
                ji0Var.j = ji0Var2.j;
                ji0Var.k = ji0Var2.k;
                this.p.h = ii0Var.p.h;
            } else if (gj0.b(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
