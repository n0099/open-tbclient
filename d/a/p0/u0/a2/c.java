package d.a.p0.u0.a2;

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
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsItemTabFragment f62528e;

    /* renamed from: f  reason: collision with root package name */
    public d f62529f;

    /* renamed from: g  reason: collision with root package name */
    public FrsItemTabNetModel f62530g;

    /* renamed from: h  reason: collision with root package name */
    public int f62531h;

    /* renamed from: i  reason: collision with root package name */
    public String f62532i;

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
        this.f62528e = frsItemTabFragment;
        FrsItemTabRequestData frsItemTabRequestData = new FrsItemTabRequestData();
        frsItemTabRequestData.itemId = i2;
        FrsItemTabNetModel frsItemTabNetModel = new FrsItemTabNetModel(frsItemTabFragment.getPageContext(), frsItemTabRequestData);
        this.f62530g = frsItemTabNetModel;
        frsItemTabNetModel.Z(this);
        this.f62530g.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = this.f62529f;
            return (dVar == null || dVar.f62533e == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.f62531h);
            errorData.setError_msg(this.f62532i);
            if (this.f62531h != 0) {
                this.f62528e.onServerError(errorData);
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
            this.f62531h = mvcSocketResponsedMessage.getError();
            this.f62532i = mvcSocketResponsedMessage.getErrorString();
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
            this.f62529f = dVar;
            dVar.f62535g = f(dVar.f62535g);
            this.f62528e.K0(this.f62529f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f62530g.Q()) {
            return;
        }
        this.f62530g.R();
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
                    d.a.o0.b.f.a.e(b2Var);
                    int[] d0 = b2Var.d0();
                    if (b2Var.getType() == b2.O2 && !b2Var.m2()) {
                        a2 a2Var = new a2();
                        a2Var.w = b2Var;
                        a2Var.position = i2;
                        a2Var.f52563e = true;
                        a2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var);
                        a2 a2Var2 = new a2();
                        a2Var2.w = b2Var;
                        a2Var2.position = i2;
                        if (b2Var.N2() == 1) {
                            a2Var2.f52566h = true;
                            a2Var2.x = d0[0];
                            a2Var2.y = d0[1];
                        } else if (b2Var.N2() >= 2) {
                            a2Var2.f52567i = true;
                        } else {
                            a2Var2.f52564f = true;
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
            d.a.o0.b.f.a.d(arrayList2);
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
            this.f62531h = mvcHttpResponsedMessage.getError();
            this.f62532i = mvcHttpResponsedMessage.getErrorString();
            b();
        }
    }
}
