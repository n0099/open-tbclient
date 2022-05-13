package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabHttpResponseMessage;
import com.baidu.tieba.frs.itemtab.FrsItemTabNetModel;
import com.baidu.tieba.frs.itemtab.FrsItemTabRequestData;
import com.baidu.tieba.frs.itemtab.FrsItemTabSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class vk6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public wk6 b;
    public FrsItemTabNetModel c;
    public int d;
    public String e;

    public vk6(FrsItemTabFragment frsItemTabFragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsItemTabFragment == null) {
            return;
        }
        this.a = frsItemTabFragment;
        FrsItemTabRequestData frsItemTabRequestData = new FrsItemTabRequestData();
        frsItemTabRequestData.itemId = i;
        FrsItemTabNetModel frsItemTabNetModel = new FrsItemTabNetModel(frsItemTabFragment.getPageContext(), frsItemTabRequestData);
        this.c = frsItemTabNetModel;
        frsItemTabNetModel.a0(this);
        this.c.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wk6 wk6Var = this.b;
            return (wk6Var == null || wk6Var.a == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.d);
            errorData.setError_msg(this.e);
            if (this.d != 0) {
                this.a.onServerError(errorData);
            }
        }
    }

    public final boolean c(wk6 wk6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wk6Var)) == null) {
            if (wk6Var == null) {
                return false;
            }
            this.b = wk6Var;
            wk6Var.c = e(wk6Var.c);
            this.a.F0(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.c.S()) {
            return;
        }
        this.c.loadData();
        gr6.a();
    }

    public final ArrayList<ro> e(ArrayList<ro> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<ro> arrayList2 = new ArrayList<>();
            Iterator<ro> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ro next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        br4 br4Var = new br4();
                        br4Var.s = threadData;
                        br4Var.position = i;
                        br4Var.a = true;
                        br4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(br4Var);
                        br4 br4Var2 = new br4();
                        br4Var2.s = threadData;
                        br4Var2.position = i;
                        if (threadData.picCount() == 1) {
                            br4Var2.d = true;
                            br4Var2.t = imageWidthAndHeight[0];
                            br4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            br4Var2.e = true;
                        } else {
                            br4Var2.b = true;
                        }
                        br4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(br4Var2);
                        br4 br4Var3 = new br4();
                        br4Var3.g = true;
                        br4Var3.s = threadData;
                        br4Var3.position = i;
                        br4Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(br4Var3);
                        i++;
                    }
                    threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                } else {
                    if (next instanceof BaseCardInfo) {
                        ((BaseCardInfo) next).position = i;
                    }
                    arrayList2.add(next);
                    i++;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        wk6 wk6Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof FrsItemTabSocketResponseMessage)) {
            wk6Var = ((FrsItemTabSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (wk6Var == null || !c(wk6Var)) {
            this.d = mvcSocketResponsedMessage.getError();
            this.e = mvcSocketResponsedMessage.getErrorString();
            b();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        wk6 wk6Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof FrsItemTabHttpResponseMessage)) {
            wk6Var = (wk6) ((FrsItemTabHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (wk6Var == null || !c(wk6Var)) {
            this.d = mvcHttpResponsedMessage.getError();
            this.e = mvcHttpResponsedMessage.getErrorString();
            b();
        }
    }
}
