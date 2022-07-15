package com.repackage;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class o92 implements p92, g92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u82 a;
    public wh1 b;
    public volatile g92[] c;
    public n92 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o92 a;

        public a(o92 o92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o92Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    public o92(@NonNull n92 n92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n92Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new u82();
        this.b = pj2.m();
        this.c = new g92[]{new k92(), new i92(), new h92(), new j92()};
        this.d = n92Var;
    }

    @Override // com.repackage.g92
    public synchronized ArraySet<String> a() {
        InterceptResult invokeV;
        ArraySet<String> arraySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                hx1.k("RecoveryPolicy", "renameAllPlatformFiles start");
                arraySet = new ArraySet<>();
                for (g92 g92Var : this.c) {
                    arraySet.addAll((ArraySet<? extends String>) g92Var.a());
                }
                hx1.k("RecoveryPolicy", "renameAllPlatformFiles end");
            }
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    @Override // com.repackage.p92
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            bd3.k(new a(this), "performRecovery");
        }
    }

    public void c(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arraySet) == null) || arraySet == null || arraySet.isEmpty()) {
            return;
        }
        hx1.k("RecoveryPolicy", "deleteFiles start");
        Iterator<String> it = arraySet.iterator();
        while (it.hasNext()) {
            jg4.k(it.next());
        }
        hx1.k("RecoveryPolicy", "deleteFiles end");
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            xw2 e = xw2.e();
            zw2 zw2Var = new zw2(132);
            zw2Var.d();
            e.h(zw2Var);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void f(Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, collection) == null) || collection == null || collection.isEmpty()) {
            return;
        }
        hx1.k("RecoveryPolicy", "resetAccredit appIds=" + collection);
        this.a.g(new ArrayList(collection));
    }
}
