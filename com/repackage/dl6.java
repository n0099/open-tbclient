package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final String b;
    public LikeModel c;
    public gl6 d;

    /* loaded from: classes5.dex */
    public class a extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl6 a;

        public a(dl6 dl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl6Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof ag8) || this.a.c.getErrorCode() != 0) {
                    if (AntiHelper.m(this.a.c.getErrorCode(), this.a.c.getErrorString())) {
                        AntiHelper.u(this.a.a.getPageActivity(), this.a.c.getErrorString());
                    } else {
                        this.a.a.showToast(this.a.c.getErrorString());
                    }
                } else if (this.a.d != null) {
                    this.a.d.a();
                }
            }
        }
    }

    public dl6(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.b = str;
    }

    public void d() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (likeModel = this.c) == null) {
            return;
        }
        likeModel.L();
    }

    public final void e(of8 of8Var, int i, gl6 gl6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, of8Var, i, gl6Var) == null) || this.a == null || of8Var == null) {
            return;
        }
        this.d = gl6Var;
        if (this.c == null) {
            f();
        }
        if (this.c.N()) {
            TbPageContext<?> tbPageContext = this.a;
            tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0037));
            return;
        }
        this.c.P(of8Var.c, of8Var.a);
        k(i + 1);
    }

    public final void f() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.c = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
    }

    public void g(of8 of8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, of8Var) == null) || this.a == null || of8Var == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(of8Var.c, null)));
        j();
    }

    public void h(of8 of8Var, int i, gl6 gl6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, of8Var, i, gl6Var) == null) || of8Var == null || of8Var.e) {
            return;
        }
        e(of8Var, i, gl6Var);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            el6.a(3, -1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            el6.a(2, -1);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            el6.a(1, i);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            el6.b(this.b, i);
        }
    }
}
