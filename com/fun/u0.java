package com.fun;

import androidx.core.app.NotificationCompat;
import c.g.h;
import c.g.i0;
import c.g.j;
import c.g.l;
import c.g.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.kuaishou.weapon.un.j0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i0 a;

    /* renamed from: b  reason: collision with root package name */
    public final String f55780b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55781c;

    /* renamed from: d  reason: collision with root package name */
    public final String f55782d;

    /* loaded from: classes2.dex */
    public class a extends HashMap<String, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55783b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ u0 f55784c;

        public a(u0 u0Var, Object[] objArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {u0Var, objArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55784c = u0Var;
            this.a = objArr;
            this.f55783b = str;
            if (objArr != null && objArr.length > 0) {
                if (objArr.length % 2 != 0) {
                    throw new IllegalArgumentException("Length of argument 'appends' must be even.");
                }
                int i4 = 0;
                while (true) {
                    Object[] objArr3 = this.a;
                    if (i4 >= objArr3.length) {
                        break;
                    }
                    put(objArr3[i4].toString(), this.a[i4 + 1]);
                    i4 += 2;
                }
            }
            put("st", this.f55783b);
            put("sid", this.f55784c.f55780b);
            put("sidv", Integer.valueOf(this.f55784c.f55781c));
            put("ldr_i", Integer.valueOf(v.b(this.f55784c.f55780b)));
            put("type", this.f55784c.f55782d);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends u0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Ssp.Pid pid) {
            super(str, h.a(str, pid), "n");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, pid};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends u0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar) {
            super(lVar.a, lVar.f28887d, "p");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends u0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f55785e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j jVar) {
            super(jVar.a, jVar.f28872c, "s");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.fun.u0
        public void c(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, objArr) == null) {
                Object[] objArr2 = new Object[objArr.length + 2];
                objArr2[0] = "lid";
                objArr2[1] = Long.valueOf(this.f55785e);
                System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
                super.c(str, objArr2);
            }
        }

        @Override // com.fun.u0
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                c("ldr_ld_err", "layer", Integer.valueOf(i2), NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i3));
            }
        }

        public void h(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                c("ldr_sld_st", "layer", Integer.valueOf(i2), "stype", str, "sst", Integer.valueOf(i3));
            }
        }

        public void i(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.f55785e = System.currentTimeMillis();
                b();
                c("ldr_ld_start", "irpt", Integer.valueOf(z ? 1 : 0));
            }
        }
    }

    public u0(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i0.a();
        this.f55780b = str;
        this.f55782d = str2;
        this.f55781c = i2;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.f55780b;
            Object obj = v.a;
            int i2 = v.f28935b.getInt("key_sid_c_pre_" + str, 0);
            String str2 = this.f55780b;
            v.d("key_sid_c_pre_" + str2, i2 + 1);
        }
    }

    public void c(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, objArr) == null) {
            this.a.c("ad_ldr", new a(this, objArr, str));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b();
            c("ldr_ld_start", new Object[0]);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c("ldr_sh_start", new Object[0]);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c("ldr_sh_start", j0.f56676b, Boolean.TRUE);
        }
    }
}
