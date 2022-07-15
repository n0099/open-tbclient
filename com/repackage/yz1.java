package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class yz1 implements xz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xz1> a;

    public yz1() {
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

    @Override // com.repackage.xz1
    public void a() {
        List<xz1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (xz1 xz1Var : this.a) {
            xz1Var.a();
        }
    }

    @Override // com.repackage.xz1
    public void b() {
        List<xz1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (xz1 xz1Var : this.a) {
            xz1Var.b();
        }
    }

    @Override // com.repackage.xz1
    public void c() {
        List<xz1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (xz1 xz1Var : this.a) {
            xz1Var.c();
        }
    }

    public void d(@NonNull xz1 xz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xz1Var) == null) {
            this.a.add(xz1Var);
        }
    }

    public void e(@NonNull xz1 xz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xz1Var) == null) {
            this.a.remove(xz1Var);
        }
    }
}
