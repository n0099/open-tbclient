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
/* loaded from: classes5.dex */
public class ei0 {
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
    public hi0 p;
    public fi0 q;
    public gi0 r;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-413606008, "Lcom/repackage/ei0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-413606008, "Lcom/repackage/ei0$a;");
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

    public ei0() {
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
        this.p = new hi0();
        this.q = new fi0();
        this.r = new gi0();
    }

    @NonNull
    public static ei0 b(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        gm0 gm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            ei0 ei0Var = new ei0();
            if (adBaseModel != null && (gm0Var = adBaseModel.l) != null && gm0Var.e) {
                ei0Var.g = gm0Var.c;
                ei0Var.g(gm0Var.d);
                ei0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                ei0Var.f = adOperator == null ? null : adOperator.d;
                ei0Var.p.a = adBaseModel.f.d;
            }
            return ei0Var;
        }
        return (ei0) invokeL.objValue;
    }

    @NonNull
    public static ei0 c(gm0 gm0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, gm0Var, str, str2)) == null) {
            ei0 ei0Var = new ei0();
            if (gm0Var != null && gm0Var.e) {
                ei0Var.g = gm0Var.c;
                ei0Var.g(gm0Var.d);
                ei0Var.d = gm0Var.a;
                ei0Var.p.a = str;
                ei0Var.f = str2;
            }
            return ei0Var;
        }
        return (ei0) invokeLLL.objValue;
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

    public void h(ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ei0Var) == null) {
            if (ei0Var != null && TextUtils.equals(d(), ei0Var.d())) {
                int i = a.a[ei0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !cj0.b(ei0Var.d)) {
                        File file = ei0Var.h;
                        if (file != null && file.exists()) {
                            ei0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            ei0Var.f();
                            return;
                        }
                    }
                } else if (cj0.b(ei0Var.d)) {
                    ei0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!cj0.e(ei0Var.h)) {
                    rh0.b().a(ei0Var);
                    ei0Var.f();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = ei0Var.d;
                }
                this.b = ei0Var.b;
                this.c = ei0Var.c;
                this.i = ei0Var.i;
                this.j = ei0Var.j;
                this.h = ei0Var.h;
                this.d = ei0Var.d;
                this.l = ei0Var.l;
                this.m = ei0Var.m;
                fi0 fi0Var = this.q;
                fi0 fi0Var2 = ei0Var.q;
                fi0Var.j = fi0Var2.j;
                fi0Var.k = fi0Var2.k;
                this.p.h = ei0Var.p.h;
            } else if (cj0.b(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
