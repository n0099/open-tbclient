package d.a.s0.u0.a2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ErrorData;
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
import d.a.c.k.e.n;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsItemTabFragment f65747e;

    /* renamed from: f  reason: collision with root package name */
    public d f65748f;

    /* renamed from: g  reason: collision with root package name */
    public FrsItemTabNetModel f65749g;

    /* renamed from: h  reason: collision with root package name */
    public int f65750h;

    /* renamed from: i  reason: collision with root package name */
    public String f65751i;

    public c(FrsItemTabFragment frsItemTabFragment, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsItemTabFragment == null) {
            return;
        }
        this.f65747e = frsItemTabFragment;
        FrsItemTabRequestData frsItemTabRequestData = new FrsItemTabRequestData();
        frsItemTabRequestData.itemId = i2;
        FrsItemTabNetModel frsItemTabNetModel = new FrsItemTabNetModel(frsItemTabFragment.getPageContext(), frsItemTabRequestData);
        this.f65749g = frsItemTabNetModel;
        frsItemTabNetModel.Z(this);
        this.f65749g.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = this.f65748f;
            return (dVar == null || dVar.f65752e == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.f65750h);
            errorData.setError_msg(this.f65751i);
            if (this.f65750h != 0) {
                this.f65747e.onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void c(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof FrsItemTabSocketResponseMessage)) {
            dVar = ((FrsItemTabSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (dVar == null || !d(dVar)) {
            this.f65750h = mvcSocketResponsedMessage.getError();
            this.f65751i = mvcSocketResponsedMessage.getErrorString();
            b();
        }
    }

    public final boolean d(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            this.f65748f = dVar;
            dVar.f65754g = f(dVar.f65754g);
            this.f65747e.J0(this.f65748f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f65749g.Q()) {
            return;
        }
        this.f65749g.R();
    }

    public final ArrayList<n> f(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, arrayList)) == null) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof b2) {
                    b2 b2Var = (b2) next;
                    d.a.r0.b.f.a.e(b2Var);
                    int[] d0 = b2Var.d0();
                    if (b2Var.getType() == b2.O2 && !b2Var.m2()) {
                        a2 a2Var = new a2();
                        a2Var.w = b2Var;
                        a2Var.position = i2;
                        a2Var.f55850e = true;
                        a2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var);
                        a2 a2Var2 = new a2();
                        a2Var2.w = b2Var;
                        a2Var2.position = i2;
                        if (b2Var.N2() == 1) {
                            a2Var2.f55853h = true;
                            a2Var2.x = d0[0];
                            a2Var2.y = d0[1];
                        } else if (b2Var.N2() >= 2) {
                            a2Var2.f55854i = true;
                        } else {
                            a2Var2.f55851f = true;
                        }
                        a2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var2);
                        a2 a2Var3 = new a2();
                        a2Var3.k = true;
                        a2Var3.w = b2Var;
                        a2Var3.position = i2;
                        a2Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var3);
                        i2++;
                    }
                    b2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                } else {
                    if (next instanceof BaseCardInfo) {
                        ((BaseCardInfo) next).position = i2;
                    }
                    arrayList2.add(next);
                    i2++;
                }
            }
            d.a.r0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof FrsItemTabHttpResponseMessage)) {
            dVar = (d) ((FrsItemTabHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (dVar == null || !d(dVar)) {
            this.f65750h = mvcHttpResponsedMessage.getError();
            this.f65751i = mvcHttpResponsedMessage.getErrorString();
            b();
        }
    }
}
