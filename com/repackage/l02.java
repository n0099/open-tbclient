package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class l02 implements k02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<k02> a;

    public l02() {
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
        this.a = new CopyOnWriteArrayList();
    }

    @Override // com.repackage.k02
    public void a() {
        List<k02> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (k02 k02Var : this.a) {
            k02Var.a();
        }
    }

    @Override // com.repackage.k02
    public void b() {
        List<k02> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (k02 k02Var : this.a) {
            k02Var.b();
        }
    }

    @Override // com.repackage.k02
    public void c() {
        List<k02> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (k02 k02Var : this.a) {
            k02Var.c();
        }
    }

    public void d(@NonNull k02 k02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k02Var) == null) {
            this.a.add(k02Var);
        }
    }

    public void e(@NonNull k02 k02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, k02Var) == null) {
            this.a.remove(k02Var);
        }
    }
}
