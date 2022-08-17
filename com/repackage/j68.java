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
public class j68 extends d68 implements tm7, a68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public f68 f;
    public d88 g;
    public PersonPolymericModel h;
    public e68 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<w28> n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j68(BaseFragment baseFragment, f68 f68Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, f68Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = f68Var;
        this.e = bdUniqueId;
        this.k = f68Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, PersonPostModel.FROM_PERSON_POLYMERIC);
        d88 d88Var = new d88(baseFragment, f68Var, bdUniqueId, z, this.c);
        this.g = d88Var;
        d88Var.W(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new w28());
        this.n.add(new w28());
    }

    @Override // com.repackage.tm7
    public void a() {
        f68 f68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f68Var = this.f) == null) {
            return;
        }
        f68Var.a();
    }

    @Override // com.repackage.tm7
    public void b() {
        f68 f68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (f68Var = this.f) == null) {
            return;
        }
        f68Var.b();
    }

    @Override // com.repackage.a68
    public d88 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (d88) invokeV.objValue;
    }

    @Override // com.repackage.a68
    public void e() {
        d88 d88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (d88Var = this.g) == null) {
            return;
        }
        d88Var.M();
    }

    @Override // com.repackage.a68
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public void i(ow8 ow8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ow8Var) == null) {
            this.g.X(ow8Var);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.m == i) {
            return;
        }
        d88 d88Var = this.g;
        if (d88Var != null) {
            d88Var.T(i);
        }
        this.m = i;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            d88 d88Var = this.g;
            if (d88Var != null) {
                d88Var.U();
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z && this.d) {
            a();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && TbadkCoreApplication.isLogin() && !this.a && this.c == TbadkCoreApplication.getCurrentAccountId()) {
            this.a = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(og.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.j.finish();
        }
    }

    public void n(k68 k68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, k68Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (k68Var == null) {
                this.i.w(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c3d), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (k68Var.e() != null && ((k68Var.e().getHide_stat() == 1 && k68Var.e().getBlock_stat() == 1) || (k68Var.e().getHide_stat() == 1 && k68Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            k68Var.b();
            z = (k68Var.f() == null || k68Var.f().size() < 20) ? false : false;
            if (k68Var.j() != null) {
                k68Var.j().getSex();
            }
            this.d = false;
            if (this.a && k68Var.j() != null) {
                k68Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                c55.d().i(k68Var.j());
            }
            w28 w28Var = this.n.get(0);
            w28Var.a(k68Var.f());
            w28Var.b(z);
            this.g.Z(k68Var, z, h(k68Var));
        }
    }

    @Override // com.repackage.tm7
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.N();
            }
        }
    }
}
