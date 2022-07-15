package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerHttpResponseMessage;
import com.baidu.tieba.downloadmanager.net.DownloadManagerNetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q36 extends l36 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadManagerNetModel b;
    public r36 c;
    public s36 d;
    public o36 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q36(BaseFragment baseFragment, int i) {
        super(baseFragment, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragment) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new r36(1, i);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.c);
        this.b = downloadManagerNetModel;
        downloadManagerNetModel.c0(this);
        this.b.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // com.repackage.l36
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.c();
            this.b.loadData();
        }
    }

    @Override // com.repackage.l36
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.b();
            this.b.loadData();
        }
    }

    @Override // com.repackage.l36
    public void d(o36 o36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o36Var) == null) {
            this.e = o36Var;
        }
    }

    public final void e(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || i == 0) {
            return;
        }
        this.e.a(i, str);
    }

    public final boolean f(s36 s36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, s36Var)) == null) {
            if (s36Var == null) {
                return false;
            }
            if (this.c.a() != 1) {
                this.d.a(s36Var);
            } else {
                this.d = s36Var;
            }
            o36 o36Var = this.e;
            s36 s36Var2 = this.d;
            o36Var.b(s36Var2.a, s36Var2.b, s36Var2.c.intValue());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void o(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        s36 s36Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            s36Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (s36Var == null || !f(s36Var)) {
            e(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void t(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        s36 s36Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            s36Var = (s36) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (s36Var == null || !f(s36Var)) {
            e(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
