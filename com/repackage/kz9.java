package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class kz9 implements xu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<xu9> a;
    public volatile boolean b;

    public kz9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void c(Collection<xu9> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, collection) == null) || collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (xu9 xu9Var : collection) {
            try {
                xu9Var.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        cv9.d(arrayList);
    }

    public void a(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) || xu9Var.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    if (this.a == null) {
                        this.a = new HashSet(4);
                    }
                    this.a.add(xu9Var);
                    return;
                }
            }
        }
        xu9Var.unsubscribe();
    }

    public void b(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xu9Var) == null) || this.b) {
            return;
        }
        synchronized (this) {
            if (!this.b && this.a != null) {
                boolean remove = this.a.remove(xu9Var);
                if (remove) {
                    xu9Var.unsubscribe();
                }
            }
        }
    }

    @Override // com.repackage.xu9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : invokeV.booleanValue;
    }

    @Override // com.repackage.xu9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            Set<xu9> set = this.a;
            this.a = null;
            c(set);
        }
    }
}
