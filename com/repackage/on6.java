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
import com.repackage.dr4;
/* loaded from: classes6.dex */
public class on6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public mn6 c;
    public d d;
    public int e;

    /* loaded from: classes6.dex */
    public class a implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ dr4 b;
        public final /* synthetic */ on6 c;

        public a(on6 on6Var, String str, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on6Var, str, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = on6Var;
            this.a = str;
            this.b = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;

        public b(on6 on6Var, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on6Var, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;

        public c(on6 on6Var, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on6Var, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public on6(TbPageContext<?> tbPageContext) {
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
        mn6 mn6Var = new mn6();
        this.c = mn6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, mn6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.a0(this);
    }

    public final void b(nn6 nn6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nn6Var) == null) && nn6Var != null && nn6Var.b == 0) {
            if (!nn6Var.a && nn6Var.d == 2) {
                l(nn6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(nn6Var.a);
            }
        }
    }

    public final void c(nn6 nn6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nn6Var, str) == null) || nn6Var == null) {
            return;
        }
        if (nn6Var.b != 0) {
            if (StringUtils.isNull(nn6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c18);
                return;
            } else {
                this.a.showToast(nn6Var.c);
                return;
            }
        }
        if (!nn6Var.a) {
            int i = nn6Var.d;
            if (i == 1) {
                k(nn6Var.e, str);
            } else if (i == 3) {
                l(nn6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(nn6Var.a);
        }
    }

    public final void d(nn6 nn6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, nn6Var, i) == null) || nn6Var == null) {
            return;
        }
        if (nn6Var.b != 0) {
            if (StringUtils.isNull(nn6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c18);
                return;
            } else {
                this.a.showToast(nn6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(nn6Var.a, i);
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
            mn6 mn6Var = this.c;
            mn6Var.d = 1;
            mn6Var.c = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            mn6 mn6Var = this.c;
            mn6Var.c = str;
            mn6Var.b = j;
            mn6Var.d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            mn6 mn6Var = this.c;
            mn6Var.a = i;
            mn6Var.c = str;
            mn6Var.d = 2;
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
            dr4 dr4Var = new dr4(this.a.getPageActivity());
            dr4Var.setCanceledOnTouchOutside(false);
            dr4Var.setCancelable(false);
            dr4Var.setMessage(str);
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f03fa, new a(this, str2, dr4Var));
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03f9, new b(this, dr4Var));
            dr4Var.create(this.a);
            dr4Var.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            dr4 dr4Var = new dr4(this.a.getPageActivity());
            dr4Var.setCanceledOnTouchOutside(false);
            dr4Var.setCancelable(false);
            dr4Var.setMessage(str);
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new c(this, dr4Var));
            dr4Var.create(this.a);
            dr4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof mn6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof nn6)) {
            mn6 mn6Var = (mn6) mvcNetMessage.getRequestData();
            nn6 nn6Var = (nn6) mvcSocketResponsedMessage.getData();
            if (mn6Var.e != this.e) {
                return;
            }
            int i = mn6Var.d;
            if (i == 1) {
                b(nn6Var);
            } else if (i == 2) {
                d(nn6Var, mn6Var.a);
            } else if (i != 3) {
            } else {
                c(nn6Var, mn6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof mn6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof nn6)) {
            mn6 mn6Var = (mn6) mvcNetMessage.getRequestData();
            nn6 nn6Var = (nn6) mvcHttpResponsedMessage.getData();
            if (mn6Var.e != this.e) {
                return;
            }
            int i = mn6Var.d;
            if (i == 1) {
                b(nn6Var);
            } else if (i == 2) {
                d(nn6Var, mn6Var.a);
            } else if (i != 3) {
            } else {
                c(nn6Var, mn6Var.c);
            }
        }
    }
}
