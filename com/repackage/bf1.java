package com.repackage;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bf1 implements cf1 {
    public static /* synthetic */ Interceptable $ic;
    public static bf1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public cf1 a;
    public boolean b;

    public bf1() {
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
        this.a = null;
        this.b = false;
    }

    public static bf1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (bf1.class) {
                    if (c == null) {
                        c = new bf1();
                    }
                }
            }
            return c;
        }
        return (bf1) invokeV.objValue;
    }

    @Override // com.repackage.cf1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            cf1 cf1Var = this.a;
            if (cf1Var == null) {
                return null;
            }
            try {
                return cf1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #0 {all -> 0x0049, blocks: (B:4:0x0004, B:7:0x0009, B:23:0x0040, B:25:0x0044, B:17:0x0024, B:18:0x0029, B:19:0x002c, B:20:0x0032, B:21:0x0038), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.repackage.cf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, df1 df1Var) {
        cf1 cf1Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, df1Var) != null) {
            return;
        }
        try {
            if (this.b) {
                return;
            }
            this.b = true;
            int ordinal = com.baidu.sso.s.a.a(Build.MANUFACTURER).ordinal();
            if (ordinal == 0) {
                cf1Var = null;
            } else if (ordinal == 1) {
                cf1Var = new ff1();
            } else if (ordinal == 2) {
                cf1Var = new nf1();
            } else if (ordinal == 3) {
                cf1Var = new lf1();
            } else if (ordinal != 4) {
                if (this.a == null) {
                    this.a.a(context, df1Var);
                    return;
                }
                return;
            } else {
                cf1Var = new hf1();
            }
            this.a = cf1Var;
            if (this.a == null) {
            }
        } catch (Throwable unused) {
        }
    }
}
