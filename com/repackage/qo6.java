package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.repackage.ur4;
/* loaded from: classes7.dex */
public class qo6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public oo6 c;
    public d d;
    public int e;

    /* loaded from: classes7.dex */
    public class a implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ur4 b;
        public final /* synthetic */ qo6 c;

        public a(qo6 qo6Var, String str, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo6Var, str, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qo6Var;
            this.a = str;
            this.b = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;

        public b(qo6 qo6Var, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo6Var, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;

        public c(qo6 qo6Var, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo6Var, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
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

    public qo6(TbPageContext<?> tbPageContext) {
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
        oo6 oo6Var = new oo6();
        this.c = oo6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, oo6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.b0(this);
    }

    public final void b(po6 po6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, po6Var) == null) && po6Var != null && po6Var.b == 0) {
            if (!po6Var.a && po6Var.d == 2) {
                l(po6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(po6Var.a);
            }
        }
    }

    public final void c(po6 po6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, po6Var, str) == null) || po6Var == null) {
            return;
        }
        if (po6Var.b != 0) {
            if (StringUtils.isNull(po6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c3d);
                return;
            } else {
                this.a.showToast(po6Var.c);
                return;
            }
        }
        if (!po6Var.a) {
            int i = po6Var.d;
            if (i == 1) {
                k(po6Var.e, str);
            } else if (i == 3) {
                l(po6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(po6Var.a);
        }
    }

    public final void d(po6 po6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, po6Var, i) == null) || po6Var == null) {
            return;
        }
        if (po6Var.b != 0) {
            if (StringUtils.isNull(po6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c3d);
                return;
            } else {
                this.a.showToast(po6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(po6Var.a, i);
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
            oo6 oo6Var = this.c;
            oo6Var.d = 1;
            oo6Var.c = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            if (UbsABTestHelper.isNotRequestProPermission()) {
                this.d.b(true);
                return;
            }
            oo6 oo6Var = this.c;
            oo6Var.c = str;
            oo6Var.b = j;
            oo6Var.d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            if (UbsABTestHelper.isNotRequestProPermission()) {
                this.d.a(true, i);
                return;
            }
            oo6 oo6Var = this.c;
            oo6Var.a = i;
            oo6Var.c = str;
            oo6Var.d = 2;
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
            ur4 ur4Var = new ur4(this.a.getPageActivity());
            ur4Var.setCanceledOnTouchOutside(false);
            ur4Var.setCancelable(false);
            ur4Var.setMessage(str);
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0405, new a(this, str2, ur4Var));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0404, new b(this, ur4Var));
            ur4Var.create(this.a);
            ur4Var.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ur4 ur4Var = new ur4(this.a.getPageActivity());
            ur4Var.setCanceledOnTouchOutside(false);
            ur4Var.setCancelable(false);
            ur4Var.setMessage(str);
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09a1, new c(this, ur4Var));
            ur4Var.create(this.a);
            ur4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof oo6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof po6)) {
            oo6 oo6Var = (oo6) mvcNetMessage.getRequestData();
            po6 po6Var = (po6) mvcSocketResponsedMessage.getData();
            if (oo6Var.e != this.e) {
                return;
            }
            int i = oo6Var.d;
            if (i == 1) {
                b(po6Var);
            } else if (i == 2) {
                d(po6Var, oo6Var.a);
            } else if (i != 3) {
            } else {
                c(po6Var, oo6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof oo6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof po6)) {
            oo6 oo6Var = (oo6) mvcNetMessage.getRequestData();
            po6 po6Var = (po6) mvcHttpResponsedMessage.getData();
            if (oo6Var.e != this.e) {
                return;
            }
            int i = oo6Var.d;
            if (i == 1) {
                b(po6Var);
            } else if (i == 2) {
                d(po6Var, oo6Var.a);
            } else if (i != 3) {
            } else {
                c(po6Var, oo6Var.c);
            }
        }
    }
}
