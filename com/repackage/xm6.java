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
import com.repackage.cr4;
/* loaded from: classes7.dex */
public class xm6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public vm6 c;
    public d d;
    public int e;

    /* loaded from: classes7.dex */
    public class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cr4 b;
        public final /* synthetic */ xm6 c;

        public a(xm6 xm6Var, String str, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm6Var, str, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xm6Var;
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

        public b(xm6 xm6Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm6Var, cr4Var};
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

        public c(xm6 xm6Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm6Var, cr4Var};
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

    public xm6(TbPageContext<?> tbPageContext) {
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
        vm6 vm6Var = new vm6();
        this.c = vm6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, vm6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.c0(this);
    }

    public final void b(wm6 wm6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, wm6Var) == null) && wm6Var != null && wm6Var.b == 0) {
            if (!wm6Var.a && wm6Var.d == 2) {
                l(wm6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(wm6Var.a);
            }
        }
    }

    public final void c(wm6 wm6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wm6Var, str) == null) || wm6Var == null) {
            return;
        }
        if (wm6Var.b != 0) {
            if (StringUtils.isNull(wm6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c2b);
                return;
            } else {
                this.a.showToast(wm6Var.c);
                return;
            }
        }
        if (!wm6Var.a) {
            int i = wm6Var.d;
            if (i == 1) {
                k(wm6Var.e, str);
            } else if (i == 3) {
                l(wm6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(wm6Var.a);
        }
    }

    public final void d(wm6 wm6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, wm6Var, i) == null) || wm6Var == null) {
            return;
        }
        if (wm6Var.b != 0) {
            if (StringUtils.isNull(wm6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c2b);
                return;
            } else {
                this.a.showToast(wm6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(wm6Var.a, i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b.U()) {
            return;
        }
        this.b.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            vm6 vm6Var = this.c;
            vm6Var.d = 1;
            vm6Var.c = str;
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
            vm6 vm6Var = this.c;
            vm6Var.c = str;
            vm6Var.b = j;
            vm6Var.d = 3;
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
            vm6 vm6Var = this.c;
            vm6Var.a = i;
            vm6Var.c = str;
            vm6Var.d = 2;
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
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f03fb, new a(this, str2, cr4Var));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03fa, new b(this, cr4Var));
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
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f099e, new c(this, cr4Var));
            cr4Var.create(this.a);
            cr4Var.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void o(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof vm6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof wm6)) {
            vm6 vm6Var = (vm6) mvcNetMessage.getRequestData();
            wm6 wm6Var = (wm6) mvcSocketResponsedMessage.getData();
            if (vm6Var.e != this.e) {
                return;
            }
            int i = vm6Var.d;
            if (i == 1) {
                b(wm6Var);
            } else if (i == 2) {
                d(wm6Var, vm6Var.a);
            } else if (i != 3) {
            } else {
                c(wm6Var, vm6Var.c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void t(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof vm6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof wm6)) {
            vm6 vm6Var = (vm6) mvcNetMessage.getRequestData();
            wm6 wm6Var = (wm6) mvcHttpResponsedMessage.getData();
            if (vm6Var.e != this.e) {
                return;
            }
            int i = vm6Var.d;
            if (i == 1) {
                b(wm6Var);
            } else if (i == 2) {
                d(wm6Var, vm6Var.a);
            } else if (i != 3) {
            } else {
                c(wm6Var, vm6Var.c);
            }
        }
    }
}
