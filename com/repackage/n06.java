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
public final class n06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Set<l06> b;
    public int c;

    public n06(int i) {
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

    public final l06 a(int i, int i2) {
        InterceptResult invokeII;
        l06 l06Var;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            synchronized (this) {
                Iterator<T> it = this.b.iterator();
                while (true) {
                    l06Var = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    l06 l06Var2 = (l06) obj;
                    if (l06Var2.l() < i || l06Var2.j() < i2 || l06Var2.l() - i >= 5 || l06Var2.j() - i2 >= 5) {
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
                l06 l06Var3 = (l06) obj;
                if (l06Var3 != null) {
                    this.b.remove(l06Var3);
                    this.c -= l06Var3.k();
                    l06Var = l06Var3;
                }
            }
            return l06Var;
        }
        return (l06) invokeII.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (l06 l06Var : this.b) {
                    l06Var.e();
                }
                this.b.clear();
                this.c = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean c(l06 l06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l06Var)) == null) {
            if ((l06Var == null ? null : l06Var.g()) == null) {
                return true;
            }
            if (this.b.contains(l06Var)) {
                return false;
            }
            if (l06Var.k() + this.c > this.a) {
                BdLog.v("DrawingCache [Release][+] OOM Pool");
                return false;
            }
            synchronized (this) {
                this.b.add(l06Var);
                l06Var.f();
                this.c += l06Var.k();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
