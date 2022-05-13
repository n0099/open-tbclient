package com.repackage;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class og1 implements pg1 {
    public static /* synthetic */ Interceptable $ic;
    public static og1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public pg1 a;
    public boolean b;

    public og1() {
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

    public static og1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (og1.class) {
                    if (c == null) {
                        c = new og1();
                    }
                }
            }
            return c;
        }
        return (og1) invokeV.objValue;
    }

    @Override // com.repackage.pg1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            pg1 pg1Var = this.a;
            if (pg1Var == null) {
                return null;
            }
            try {
                return pg1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #0 {all -> 0x0049, blocks: (B:4:0x0004, B:7:0x0009, B:23:0x0040, B:25:0x0044, B:17:0x0024, B:18:0x0029, B:19:0x002c, B:20:0x0032, B:21:0x0038), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.repackage.pg1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, qg1 qg1Var) {
        pg1 pg1Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qg1Var) != null) {
            return;
        }
        try {
            if (this.b) {
                return;
            }
            this.b = true;
            int ordinal = com.baidu.sso.s.a.a(Build.MANUFACTURER).ordinal();
            if (ordinal == 0) {
                pg1Var = null;
            } else if (ordinal == 1) {
                pg1Var = new sg1();
            } else if (ordinal == 2) {
                pg1Var = new ah1();
            } else if (ordinal == 3) {
                pg1Var = new yg1();
            } else if (ordinal != 4) {
                if (this.a == null) {
                    this.a.a(context, qg1Var);
                    return;
                }
                return;
            } else {
                pg1Var = new ug1();
            }
            this.a = pg1Var;
            if (this.a == null) {
            }
        } catch (Throwable unused) {
        }
    }
}
