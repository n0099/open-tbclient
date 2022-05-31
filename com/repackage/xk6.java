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
import com.repackage.dq4;
/* loaded from: classes7.dex */
public class xk6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public vk6 c;
    public d d;
    public int e;

    /* loaded from: classes7.dex */
    public class a implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ dq4 b;
        public final /* synthetic */ xk6 c;

        public a(xk6 xk6Var, String str, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk6Var, str, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xk6Var;
            this.a = str;
            this.b = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;

        public b(xk6 xk6Var, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk6Var, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;

        public c(xk6 xk6Var, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk6Var, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
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

    public xk6(TbPageContext<?> tbPageContext) {
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
        vk6 vk6Var = new vk6();
        this.c = vk6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, vk6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.a0(this);
    }

    public final void b(wk6 wk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, wk6Var) == null) && wk6Var != null && wk6Var.b == 0) {
            if (!wk6Var.a && wk6Var.d == 2) {
                l(wk6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(wk6Var.a);
            }
        }
    }

    public final void c(wk6 wk6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wk6Var, str) == null) || wk6Var == null) {
            return;
        }
        if (wk6Var.b != 0) {
            if (StringUtils.isNull(wk6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c33);
                return;
            } else {
                this.a.showToast(wk6Var.c);
                return;
            }
        }
        if (!wk6Var.a) {
            int i = wk6Var.d;
            if (i == 1) {
                k(wk6Var.e, str);
            } else if (i == 3) {
                l(wk6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(wk6Var.a);
        }
    }

    public final void d(wk6 wk6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, wk6Var, i) == null) || wk6Var == null) {
            return;
        }
        if (wk6Var.b != 0) {
            if (StringUtils.isNull(wk6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c33);
                return;
            } else {
                this.a.showToast(wk6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(wk6Var.a, i);
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
            vk6 vk6Var = this.c;
            vk6Var.d = 1;
            vk6Var.c = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            vk6 vk6Var = this.c;
            vk6Var.c = str;
            vk6Var.b = j;
            vk6Var.d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            vk6 vk6Var = this.c;
            vk6Var.a = i;
            vk6Var.c = str;
            vk6Var.d = 2;
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
            dq4 dq4Var = new dq4(this.a.getPageActivity());
            dq4Var.setCanceledOnTouchOutside(false);
            dq4Var.setCancelable(false);
            dq4Var.setMessage(str);
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0403, new a(this, str2, dq4Var));
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0402, new b(this, dq4Var));
            dq4Var.create(this.a);
            dq4Var.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            dq4 dq4Var = new dq4(this.a.getPageActivity());
            dq4Var.setCanceledOnTouchOutside(false);
            dq4Var.setCancelable(false);
            dq4Var.setMessage(str);
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f098e, new c(this, dq4Var));
            dq4Var.create(this.a);
            dq4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof vk6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof wk6)) {
            vk6 vk6Var = (vk6) mvcNetMessage.getRequestData();
            wk6 wk6Var = (wk6) mvcSocketResponsedMessage.getData();
            if (vk6Var.e != this.e) {
                return;
            }
            int i = vk6Var.d;
            if (i == 1) {
                b(wk6Var);
            } else if (i == 2) {
                d(wk6Var, vk6Var.a);
            } else if (i != 3) {
            } else {
                c(wk6Var, vk6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof vk6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof wk6)) {
            vk6 vk6Var = (vk6) mvcNetMessage.getRequestData();
            wk6 wk6Var = (wk6) mvcHttpResponsedMessage.getData();
            if (vk6Var.e != this.e) {
                return;
            }
            int i = vk6Var.d;
            if (i == 1) {
                b(wk6Var);
            } else if (i == 2) {
                d(wk6Var, vk6Var.a);
            } else if (i != 3) {
            } else {
                c(wk6Var, vk6Var.c);
            }
        }
    }
}
