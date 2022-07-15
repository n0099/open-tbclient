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
public class si0 {
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
    public wi0 p;
    public ti0 q;
    public vi0 r;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-12797894, "Lcom/repackage/si0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-12797894, "Lcom/repackage/si0$a;");
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

    public si0() {
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
        this.p = new wi0();
        this.q = new ti0();
        this.r = new vi0();
    }

    @NonNull
    public static si0 b(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        xm0 xm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            si0 si0Var = new si0();
            if (adBaseModel != null && (xm0Var = adBaseModel.l) != null && xm0Var.e) {
                si0Var.g = xm0Var.c;
                si0Var.g(xm0Var.d);
                si0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                si0Var.f = adOperator == null ? null : adOperator.d;
                si0Var.p.a = adBaseModel.f.d;
            }
            return si0Var;
        }
        return (si0) invokeL.objValue;
    }

    @NonNull
    public static si0 c(xm0 xm0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, xm0Var, str, str2)) == null) {
            si0 si0Var = new si0();
            if (xm0Var != null && xm0Var.e) {
                si0Var.g = xm0Var.c;
                si0Var.g(xm0Var.d);
                si0Var.d = xm0Var.a;
                si0Var.p.a = str;
                si0Var.f = str2;
            }
            return si0Var;
        }
        return (si0) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q.g != 1 : invokeV.booleanValue;
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

    public void h(si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, si0Var) == null) {
            if (si0Var != null && TextUtils.equals(d(), si0Var.d())) {
                int i = a.a[si0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !tj0.b(si0Var.d)) {
                        File file = si0Var.h;
                        if (file != null && file.exists()) {
                            si0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            si0Var.f();
                            return;
                        }
                    }
                } else if (tj0.b(si0Var.d)) {
                    si0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!tj0.e(si0Var.h)) {
                    ei0.b().a(si0Var);
                    si0Var.f();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = si0Var.d;
                }
                this.b = si0Var.b;
                this.c = si0Var.c;
                this.i = si0Var.i;
                this.j = si0Var.j;
                this.h = si0Var.h;
                this.d = si0Var.d;
                this.l = si0Var.l;
                this.m = si0Var.m;
                ti0 ti0Var = this.q;
                ti0 ti0Var2 = si0Var.q;
                ti0Var.k = ti0Var2.k;
                ti0Var.l = ti0Var2.l;
                this.p.h = si0Var.p.h;
                this.k = si0Var.k;
            } else if (tj0.b(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
