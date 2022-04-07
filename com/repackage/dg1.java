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
public class dg1 implements eg1 {
    public static /* synthetic */ Interceptable $ic;
    public static dg1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public eg1 a;
    public boolean b;

    public dg1() {
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

    public static dg1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (dg1.class) {
                    if (c == null) {
                        c = new dg1();
                    }
                }
            }
            return c;
        }
        return (dg1) invokeV.objValue;
    }

    @Override // com.repackage.eg1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            eg1 eg1Var = this.a;
            if (eg1Var == null) {
                return null;
            }
            try {
                return eg1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #0 {all -> 0x0049, blocks: (B:4:0x0004, B:7:0x0009, B:23:0x0040, B:25:0x0044, B:17:0x0024, B:18:0x0029, B:19:0x002c, B:20:0x0032, B:21:0x0038), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.repackage.eg1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, fg1 fg1Var) {
        eg1 eg1Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fg1Var) != null) {
            return;
        }
        try {
            if (this.b) {
                return;
            }
            this.b = true;
            int ordinal = com.baidu.sso.s.a.a(Build.MANUFACTURER).ordinal();
            if (ordinal == 0) {
                eg1Var = null;
            } else if (ordinal == 1) {
                eg1Var = new hg1();
            } else if (ordinal == 2) {
                eg1Var = new pg1();
            } else if (ordinal == 3) {
                eg1Var = new ng1();
            } else if (ordinal != 4) {
                if (this.a == null) {
                    this.a.a(context, fg1Var);
                    return;
                }
                return;
            } else {
                eg1Var = new jg1();
            }
            this.a = eg1Var;
            if (this.a == null) {
            }
        } catch (Throwable unused) {
        }
    }
}
