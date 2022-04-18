package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.FrsProfessionPermissionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
/* loaded from: classes7.dex */
public class qn6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public on6 c;
    public d d;
    public int e;

    /* loaded from: classes7.dex */
    public class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cr4 b;
        public final /* synthetic */ qn6 c;

        public a(qn6 qn6Var, String str, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn6Var, str, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qn6Var;
            this.a = str;
            this.b = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;

        public b(qn6 qn6Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn6Var, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;

        public c(qn6 qn6Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn6Var, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public qn6(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        on6 on6Var = new on6();
        this.c = on6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, on6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.a0(this);
    }

    public final void b(pn6 pn6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pn6Var) == null) && pn6Var != null && pn6Var.b == 0) {
            if (!pn6Var.a && pn6Var.d == 2) {
                l(pn6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(pn6Var.a);
            }
        }
    }

    public final void c(pn6 pn6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pn6Var, str) == null) || pn6Var == null) {
            return;
        }
        if (pn6Var.b != 0) {
            if (StringUtils.isNull(pn6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c17);
                return;
            } else {
                this.a.showToast(pn6Var.c);
                return;
            }
        }
        if (!pn6Var.a) {
            int i = pn6Var.d;
            if (i == 1) {
                k(pn6Var.e, str);
            } else if (i == 3) {
                l(pn6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(pn6Var.a);
        }
    }

    public final void d(pn6 pn6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, pn6Var, i) == null) || pn6Var == null) {
            return;
        }
        if (pn6Var.b != 0) {
            if (StringUtils.isNull(pn6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c17);
                return;
            } else {
                this.a.showToast(pn6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(pn6Var.a, i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b.S()) {
            return;
        }
        this.b.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            on6 on6Var = this.c;
            on6Var.d = 1;
            on6Var.c = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            on6 on6Var = this.c;
            on6Var.c = str;
            on6Var.b = j;
            on6Var.d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            on6 on6Var = this.c;
            on6Var.a = i;
            on6Var.c = str;
            on6Var.d = 2;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.d = dVar;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e = i;
            this.c.e = i;
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            cr4 cr4Var = new cr4(this.a.getPageActivity());
            cr4Var.setCanceledOnTouchOutside(false);
            cr4Var.setCancelable(false);
            cr4Var.setMessage(str);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f03fa, new a(this, str2, cr4Var));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03f9, new b(this, cr4Var));
            cr4Var.create(this.a);
            cr4Var.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            cr4 cr4Var = new cr4(this.a.getPageActivity());
            cr4Var.setCanceledOnTouchOutside(false);
            cr4Var.setCancelable(false);
            cr4Var.setMessage(str);
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new c(this, cr4Var));
            cr4Var.create(this.a);
            cr4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof on6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof pn6)) {
            on6 on6Var = (on6) mvcNetMessage.getRequestData();
            pn6 pn6Var = (pn6) mvcSocketResponsedMessage.getData();
            if (on6Var.e != this.e) {
                return;
            }
            int i = on6Var.d;
            if (i == 1) {
                b(pn6Var);
            } else if (i == 2) {
                d(pn6Var, on6Var.a);
            } else if (i != 3) {
            } else {
                c(pn6Var, on6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof on6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof pn6)) {
            on6 on6Var = (on6) mvcNetMessage.getRequestData();
            pn6 pn6Var = (pn6) mvcHttpResponsedMessage.getData();
            if (on6Var.e != this.e) {
                return;
            }
            int i = on6Var.d;
            if (i == 1) {
                b(pn6Var);
            } else if (i == 2) {
                d(pn6Var, on6Var.a);
            } else if (i != 3) {
            } else {
                c(pn6Var, on6Var.c);
            }
        }
    }
}
