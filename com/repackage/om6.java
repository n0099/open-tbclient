package com.repackage;

import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class om6 implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsModelController a;
    public MvcSocketResponsedMessage<oi8, ?> b;
    public MvcSocketMessage<FrsRequestData, oi8> c;
    public MvcNetMessage<FrsRequestData, oi8> d;
    public vi8 e;

    public om6() {
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

    public void a(FrsModelController frsModelController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frsModelController) == null) {
            this.a = frsModelController;
        }
    }

    public void b(vi8 vi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi8Var) == null) {
            this.e = vi8Var;
        }
    }

    public void c(MvcSocketMessage<FrsRequestData, oi8> mvcSocketMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcSocketMessage) == null) {
            this.c = mvcSocketMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, oi8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.d = mvcNetMessage;
        }
    }

    public void e(MvcSocketResponsedMessage<oi8, ?> mvcSocketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcSocketResponsedMessage) == null) {
            this.b = mvcSocketResponsedMessage;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.a;
            if (frsModelController == null) {
                return false;
            }
            frsModelController.D0(this.b, this.c, this.d);
            vi8 vi8Var = this.e;
            if (vi8Var != null) {
                vi8Var.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
