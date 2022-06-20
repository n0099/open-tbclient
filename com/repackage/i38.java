package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class i38 extends c38 implements hk7, z28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public e38 f;
    public c58 g;
    public PersonPolymericModel h;
    public d38 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<zz7> n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i38(BaseFragment baseFragment, e38 e38Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, e38Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
        this.m = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.j = baseFragmentActivity;
        this.b = baseFragmentActivity.getPageContext();
        this.c = j;
        this.f = e38Var;
        this.e = bdUniqueId;
        this.k = e38Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, PersonPostModel.FROM_PERSON_POLYMERIC);
        c58 c58Var = new c58(baseFragment, e38Var, bdUniqueId, z, this.c);
        this.g = c58Var;
        c58Var.W(this);
        h();
        this.h = this.f.r();
        this.i = this.f.m();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new zz7());
        this.n.add(new zz7());
    }

    @Override // com.repackage.hk7
    public void a() {
        e38 e38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (e38Var = this.f) == null) {
            return;
        }
        e38Var.a();
    }

    @Override // com.repackage.hk7
    public void b() {
        e38 e38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (e38Var = this.f) == null) {
            return;
        }
        e38Var.b();
    }

    @Override // com.repackage.z28
    public c58 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (c58) invokeV.objValue;
    }

    @Override // com.repackage.z28
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.repackage.z28
    public void f() {
        c58 c58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (c58Var = this.g) == null) {
            return;
        }
        c58Var.M();
    }

    @Override // com.repackage.z28
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.hk7
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.N();
            }
        }
    }

    public void k(bt8 bt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bt8Var) == null) {
            this.g.X(bt8Var);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.m == i) {
            return;
        }
        c58 c58Var = this.g;
        if (c58Var != null) {
            c58Var.T(i);
        }
        this.m = i;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            c58 c58Var = this.g;
            if (c58Var != null) {
                c58Var.U();
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z && this.d) {
            a();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && TbadkCoreApplication.isLogin() && !this.a && this.c == TbadkCoreApplication.getCurrentAccountId()) {
            this.a = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(ng.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.j.finish();
        }
    }

    public void p(j38 j38Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, j38Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (j38Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c37), true);
                this.i.n();
                this.i.t(8);
                return;
            }
            this.i.p();
            if (j38Var.e() != null && ((j38Var.e().getHide_stat() == 1 && j38Var.e().getBlock_stat() == 1) || (j38Var.e().getHide_stat() == 1 && j38Var.e().getBlock_stat() == 2))) {
                this.i.v(this.a);
                this.i.t(8);
                return;
            }
            this.i.t(0);
            j38Var.b();
            z = (j38Var.f() == null || j38Var.f().size() < 20) ? false : false;
            if (j38Var.j() != null) {
                j38Var.j().getSex();
            }
            this.d = false;
            if (this.a && j38Var.j() != null) {
                j38Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                d35.d().i(j38Var.j());
            }
            zz7 zz7Var = this.n.get(0);
            zz7Var.a(j38Var.f());
            zz7Var.b(z);
            this.g.Z(j38Var, z, j(j38Var));
        }
    }
}
