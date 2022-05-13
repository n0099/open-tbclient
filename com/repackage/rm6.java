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
import com.repackage.nr4;
/* loaded from: classes7.dex */
public class rm6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public pm6 c;
    public d d;
    public int e;

    /* loaded from: classes7.dex */
    public class a implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nr4 b;
        public final /* synthetic */ rm6 c;

        public a(rm6 rm6Var, String str, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm6Var, str, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rm6Var;
            this.a = str;
            this.b = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;

        public b(rm6 rm6Var, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm6Var, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;

        public c(rm6 rm6Var, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm6Var, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
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

    public rm6(TbPageContext<?> tbPageContext) {
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
        pm6 pm6Var = new pm6();
        this.c = pm6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, pm6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.a0(this);
    }

    public final void b(qm6 qm6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, qm6Var) == null) && qm6Var != null && qm6Var.b == 0) {
            if (!qm6Var.a && qm6Var.d == 2) {
                l(qm6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(qm6Var.a);
            }
        }
    }

    public final void c(qm6 qm6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qm6Var, str) == null) || qm6Var == null) {
            return;
        }
        if (qm6Var.b != 0) {
            if (StringUtils.isNull(qm6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c2d);
                return;
            } else {
                this.a.showToast(qm6Var.c);
                return;
            }
        }
        if (!qm6Var.a) {
            int i = qm6Var.d;
            if (i == 1) {
                k(qm6Var.e, str);
            } else if (i == 3) {
                l(qm6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(qm6Var.a);
        }
    }

    public final void d(qm6 qm6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, qm6Var, i) == null) || qm6Var == null) {
            return;
        }
        if (qm6Var.b != 0) {
            if (StringUtils.isNull(qm6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c2d);
                return;
            } else {
                this.a.showToast(qm6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(qm6Var.a, i);
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
            pm6 pm6Var = this.c;
            pm6Var.d = 1;
            pm6Var.c = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            pm6 pm6Var = this.c;
            pm6Var.c = str;
            pm6Var.b = j;
            pm6Var.d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            pm6 pm6Var = this.c;
            pm6Var.a = i;
            pm6Var.c = str;
            pm6Var.d = 2;
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
            nr4 nr4Var = new nr4(this.a.getPageActivity());
            nr4Var.setCanceledOnTouchOutside(false);
            nr4Var.setCancelable(false);
            nr4Var.setMessage(str);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0400, new a(this, str2, nr4Var));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ff, new b(this, nr4Var));
            nr4Var.create(this.a);
            nr4Var.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            nr4 nr4Var = new nr4(this.a.getPageActivity());
            nr4Var.setCanceledOnTouchOutside(false);
            nr4Var.setCancelable(false);
            nr4Var.setMessage(str);
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0988, new c(this, nr4Var));
            nr4Var.create(this.a);
            nr4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof pm6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof qm6)) {
            pm6 pm6Var = (pm6) mvcNetMessage.getRequestData();
            qm6 qm6Var = (qm6) mvcSocketResponsedMessage.getData();
            if (pm6Var.e != this.e) {
                return;
            }
            int i = pm6Var.d;
            if (i == 1) {
                b(qm6Var);
            } else if (i == 2) {
                d(qm6Var, pm6Var.a);
            } else if (i != 3) {
            } else {
                c(qm6Var, pm6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof pm6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof qm6)) {
            pm6 pm6Var = (pm6) mvcNetMessage.getRequestData();
            qm6 qm6Var = (qm6) mvcHttpResponsedMessage.getData();
            if (pm6Var.e != this.e) {
                return;
            }
            int i = pm6Var.d;
            if (i == 1) {
                b(qm6Var);
            } else if (i == 2) {
                d(qm6Var, pm6Var.a);
            } else if (i != 3) {
            } else {
                c(qm6Var, pm6Var.c);
            }
        }
    }
}
