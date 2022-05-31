package com.repackage;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
/* loaded from: classes6.dex */
public final class py5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Set<ny5> b;
    public int c;

    public py5(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = new LinkedHashSet();
    }

    public final ny5 a(int i, int i2) {
        InterceptResult invokeII;
        ny5 ny5Var;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            synchronized (this) {
                Iterator<T> it = this.b.iterator();
                while (true) {
                    ny5Var = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    ny5 ny5Var2 = (ny5) obj;
                    if (ny5Var2.l() < i || ny5Var2.j() < i2 || ny5Var2.l() - i >= 5 || ny5Var2.j() - i2 >= 5) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                ny5 ny5Var3 = (ny5) obj;
                if (ny5Var3 != null) {
                    this.b.remove(ny5Var3);
                    this.c -= ny5Var3.k();
                    ny5Var = ny5Var3;
                }
            }
            return ny5Var;
        }
        return (ny5) invokeII.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (ny5 ny5Var : this.b) {
                    ny5Var.e();
                }
                this.b.clear();
                this.c = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean c(ny5 ny5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ny5Var)) == null) {
            if ((ny5Var == null ? null : ny5Var.g()) == null) {
                return true;
            }
            if (this.b.contains(ny5Var)) {
                return false;
            }
            if (ny5Var.k() + this.c > this.a) {
                BdLog.v("DrawingCache [Release][+] OOM Pool");
                return false;
            }
            synchronized (this) {
                this.b.add(ny5Var);
                ny5Var.f();
                this.c += ny5Var.k();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
