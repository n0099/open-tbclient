package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u59;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class c69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<String, Long> a;

    /* loaded from: classes5.dex */
    public class a extends g69 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.ubs.analytics.a.l a;

        public a(c69 c69Var, com.baidu.ubs.analytics.a.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c69Var, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // com.repackage.g69
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new m59().c(this.a);
            }
        }
    }

    public c69() {
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
        this.a = new LinkedHashMap<>();
    }

    public final void a(String str) {
        u59 u59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
        synchronized (this.a) {
            Long remove = this.a.remove(str);
            if (remove == null) {
                return;
            }
            try {
                lVar.setStartTime(String.valueOf(remove));
                lVar.t(str);
                lVar.z(String.valueOf(System.currentTimeMillis()));
                u59Var = u59.a.a;
                lVar.setPath(u59Var.b());
                lVar.x(d69.f().I());
            } catch (Exception e) {
                m69.a(e.toString());
                e69.b(e.toString());
            }
            f69.c(new a(this, lVar));
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.a) {
            this.a.put(str, Long.valueOf(System.currentTimeMillis()));
            String.valueOf(System.currentTimeMillis());
        }
    }
}
