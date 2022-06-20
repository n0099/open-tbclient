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
import com.repackage.nq4;
/* loaded from: classes5.dex */
public class am6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public yl6 c;
    public d d;
    public int e;

    /* loaded from: classes5.dex */
    public class a implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nq4 b;
        public final /* synthetic */ am6 c;

        public a(am6 am6Var, String str, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am6Var, str, nq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = am6Var;
            this.a = str;
            this.b = nq4Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nq4 a;

        public b(am6 am6Var, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am6Var, nq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nq4Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nq4 a;

        public c(am6 am6Var, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am6Var, nq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nq4Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public am6(TbPageContext<?> tbPageContext) {
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
        yl6 yl6Var = new yl6();
        this.c = yl6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, yl6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.b0(this);
    }

    public final void b(zl6 zl6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, zl6Var) == null) && zl6Var != null && zl6Var.b == 0) {
            if (!zl6Var.a && zl6Var.d == 2) {
                l(zl6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(zl6Var.a);
            }
        }
    }

    public final void c(zl6 zl6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zl6Var, str) == null) || zl6Var == null) {
            return;
        }
        if (zl6Var.b != 0) {
            if (StringUtils.isNull(zl6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c37);
                return;
            } else {
                this.a.showToast(zl6Var.c);
                return;
            }
        }
        if (!zl6Var.a) {
            int i = zl6Var.d;
            if (i == 1) {
                k(zl6Var.e, str);
            } else if (i == 3) {
                l(zl6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(zl6Var.a);
        }
    }

    public final void d(zl6 zl6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, zl6Var, i) == null) || zl6Var == null) {
            return;
        }
        if (zl6Var.b != 0) {
            if (StringUtils.isNull(zl6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c37);
                return;
            } else {
                this.a.showToast(zl6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(zl6Var.a, i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b.T()) {
            return;
        }
        this.b.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            yl6 yl6Var = this.c;
            yl6Var.d = 1;
            yl6Var.c = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            yl6 yl6Var = this.c;
            yl6Var.c = str;
            yl6Var.b = j;
            yl6Var.d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            yl6 yl6Var = this.c;
            yl6Var.a = i;
            yl6Var.c = str;
            yl6Var.d = 2;
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
            nq4 nq4Var = new nq4(this.a.getPageActivity());
            nq4Var.setCanceledOnTouchOutside(false);
            nq4Var.setCancelable(false);
            nq4Var.setMessage(str);
            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f03f4, new a(this, str2, nq4Var));
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03f3, new b(this, nq4Var));
            nq4Var.create(this.a);
            nq4Var.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            nq4 nq4Var = new nq4(this.a.getPageActivity());
            nq4Var.setCanceledOnTouchOutside(false);
            nq4Var.setCancelable(false);
            nq4Var.setMessage(str);
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0993, new c(this, nq4Var));
            nq4Var.create(this.a);
            nq4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof yl6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof zl6)) {
            yl6 yl6Var = (yl6) mvcNetMessage.getRequestData();
            zl6 zl6Var = (zl6) mvcSocketResponsedMessage.getData();
            if (yl6Var.e != this.e) {
                return;
            }
            int i = yl6Var.d;
            if (i == 1) {
                b(zl6Var);
            } else if (i == 2) {
                d(zl6Var, yl6Var.a);
            } else if (i != 3) {
            } else {
                c(zl6Var, yl6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof yl6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof zl6)) {
            yl6 yl6Var = (yl6) mvcNetMessage.getRequestData();
            zl6 zl6Var = (zl6) mvcHttpResponsedMessage.getData();
            if (yl6Var.e != this.e) {
                return;
            }
            int i = yl6Var.d;
            if (i == 1) {
                b(zl6Var);
            } else if (i == 2) {
                d(zl6Var, yl6Var.a);
            } else if (i != 3) {
            } else {
                c(zl6Var, yl6Var.c);
            }
        }
    }
}
