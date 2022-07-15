package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.so1;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes7.dex */
public class z24 extends so1 implements th1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<so1.a> a;

    public z24() {
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
        this.a = new ArrayList<>();
    }

    @Nullable
    public static z24 c() {
        InterceptResult invokeV;
        dw3 dw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            qz1 V = ul2.U().V();
            if (V == null || (dw3Var = (dw3) V.n(dw3.class)) == null) {
                return null;
            }
            return dw3Var.u3();
        }
        return (z24) invokeV.objValue;
    }

    @Override // com.repackage.so1
    public synchronized void a(so1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (!this.a.contains(aVar)) {
                    this.a.add(aVar);
                }
            }
        }
    }

    @Override // com.repackage.so1
    public synchronized void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this) {
                Iterator<so1.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().b(i);
                }
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Iterator<so1.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.a.clear();
            }
        }
    }

    @Override // com.repackage.th1
    public so1 getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c() : (so1) invokeV.objValue;
    }
}
