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
public class rj0 {
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
    public uj0 p;
    public sj0 q;
    public tj0 r;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-40503524, "Lcom/repackage/rj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-40503524, "Lcom/repackage/rj0$a;");
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

    public rj0() {
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
        this.p = new uj0();
        this.q = new sj0();
        this.r = new tj0();
    }

    @NonNull
    public static rj0 b(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        tn0 tn0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            rj0 rj0Var = new rj0();
            if (adBaseModel != null && (tn0Var = adBaseModel.l) != null && tn0Var.e) {
                rj0Var.g = tn0Var.c;
                rj0Var.g(tn0Var.d);
                rj0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                rj0Var.f = adOperator == null ? null : adOperator.d;
                rj0Var.p.a = adBaseModel.f.d;
            }
            return rj0Var;
        }
        return (rj0) invokeL.objValue;
    }

    @NonNull
    public static rj0 c(tn0 tn0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, tn0Var, str, str2)) == null) {
            rj0 rj0Var = new rj0();
            if (tn0Var != null && tn0Var.e) {
                rj0Var.g = tn0Var.c;
                rj0Var.g(tn0Var.d);
                rj0Var.d = tn0Var.a;
                rj0Var.p.a = str;
                rj0Var.f = str2;
            }
            return rj0Var;
        }
        return (rj0) invokeLLL.objValue;
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

    public void h(rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rj0Var) == null) {
            if (rj0Var != null && TextUtils.equals(d(), rj0Var.d())) {
                int i = a.a[rj0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !pk0.b(rj0Var.d)) {
                        File file = rj0Var.h;
                        if (file != null && file.exists()) {
                            rj0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            rj0Var.f();
                            return;
                        }
                    }
                } else if (pk0.b(rj0Var.d)) {
                    rj0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!pk0.f(rj0Var.h)) {
                    ej0.b().a(rj0Var);
                    rj0Var.f();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = rj0Var.d;
                }
                this.b = rj0Var.b;
                this.c = rj0Var.c;
                this.i = rj0Var.i;
                this.j = rj0Var.j;
                this.h = rj0Var.h;
                this.d = rj0Var.d;
                this.l = rj0Var.l;
                this.m = rj0Var.m;
                sj0 sj0Var = this.q;
                sj0 sj0Var2 = rj0Var.q;
                sj0Var.j = sj0Var2.j;
                sj0Var.k = sj0Var2.k;
                this.p.h = rj0Var.p.h;
            } else if (pk0.b(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
