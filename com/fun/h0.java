package com.fun;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.SidSessionMeta;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.repackage.bl9;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SidSessionMeta a;
    public final String b;
    public final Reporter c;

    /* loaded from: classes4.dex */
    public class a extends HashMap<String, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object[] a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h0 c;

        public a(h0 h0Var, Object[] objArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {h0Var, objArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h0Var;
            this.a = objArr;
            this.b = str;
            if (objArr != null && objArr.length > 0) {
                if (objArr.length % 2 != 0) {
                    throw new IllegalArgumentException("Length of argument 'appends' must be even.");
                }
                int i3 = 0;
                while (true) {
                    Object[] objArr3 = this.a;
                    if (i3 >= objArr3.length) {
                        break;
                    }
                    put(objArr3[i3].toString(), this.a[i3 + 1]);
                    i3 += 2;
                }
            }
            put("slid", Long.valueOf(this.c.a.tId));
            put("st", this.b);
            put("sid", this.c.a.sid);
            put("sidv", Integer.valueOf(this.c.a.sidVer));
            put("type", this.c.b);
        }
    }

    public h0(SidSessionMeta sidSessionMeta, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sidSessionMeta, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = bl9.a();
        this.a = sidSessionMeta;
        this.b = str;
    }

    public void b(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, objArr) == null) {
            this.c.logEvent("ad_ldr", new a(this, objArr, str));
        }
    }
}
