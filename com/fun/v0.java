package com.fun;

import androidx.core.app.NotificationCompat;
import b.g.h;
import b.g.i0;
import b.g.j;
import b.g.l;
import b.g.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.HashMap;
/* loaded from: classes11.dex */
public abstract class v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final i0 f62930a;

    /* renamed from: b  reason: collision with root package name */
    public final String f62931b;

    /* renamed from: c  reason: collision with root package name */
    public final int f62932c;

    /* renamed from: d  reason: collision with root package name */
    public final String f62933d;

    /* loaded from: classes11.dex */
    public class a extends HashMap<String, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object[] f62934a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62935b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v0 f62936c;

        public a(v0 v0Var, Object[] objArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {v0Var, objArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62936c = v0Var;
            this.f62934a = objArr;
            this.f62935b = str;
            if (objArr != null && objArr.length > 0) {
                if (objArr.length % 2 != 0) {
                    throw new IllegalArgumentException("Length of argument 'appends' must be even.");
                }
                int i4 = 0;
                while (true) {
                    Object[] objArr3 = this.f62934a;
                    if (i4 >= objArr3.length) {
                        break;
                    }
                    put(objArr3[i4].toString(), this.f62934a[i4 + 1]);
                    i4 += 2;
                }
            }
            put("st", this.f62935b);
            put("sid", this.f62936c.f62931b);
            put("sidv", Integer.valueOf(this.f62936c.f62932c));
            put("ldr_i", Integer.valueOf(v.b(this.f62936c.f62931b)));
            put("type", this.f62936c.f62933d);
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends v0 {
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

    /* loaded from: classes11.dex */
    public static class c extends v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar) {
            super(lVar.f31186a, lVar.f31189d, "p");
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

    /* loaded from: classes11.dex */
    public static class d extends v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f62937e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j jVar) {
            super(jVar.f31168a, jVar.f31170c, "s");
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

        @Override // com.fun.v0
        public void c(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, objArr) == null) {
                Object[] objArr2 = new Object[objArr.length + 2];
                objArr2[0] = "lid";
                objArr2[1] = Long.valueOf(this.f62937e);
                System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
                super.c(str, objArr2);
            }
        }

        @Override // com.fun.v0
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public void f(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                c("ldr_ld_err", "layer", Integer.valueOf(i2), NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i3));
            }
        }

        public void g(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                c("ldr_sld_st", "layer", Integer.valueOf(i2), "stype", str, "sst", Integer.valueOf(i3));
            }
        }

        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.f62937e = System.currentTimeMillis();
                b();
                c("ldr_ld_start", "irpt", Integer.valueOf(z ? 1 : 0));
            }
        }
    }

    public v0(String str, int i2, String str2) {
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
        this.f62930a = i0.a();
        this.f62931b = str;
        this.f62933d = str2;
        this.f62932c = i2;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.f62931b;
            Object obj = v.f31247a;
            int i2 = v.f31248b.getInt("key_sid_c_pre_" + str, 0);
            String str2 = this.f62931b;
            v.d("key_sid_c_pre_" + str2, i2 + 1);
        }
    }

    public void c(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, objArr) == null) {
            this.f62930a.c("ad_ldr", new a(this, objArr, str));
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
}
