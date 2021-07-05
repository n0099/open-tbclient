package d.a.s0.m2.d;

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
import d.a.s0.m2.j.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class k extends e implements d.a.s0.w1.a, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f63456f;

    /* renamed from: g  reason: collision with root package name */
    public long f63457g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63458h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f63459i;
    public g j;
    public p k;
    public PersonPolymericModel l;
    public f m;
    public BaseFragmentActivity n;
    public View o;
    public PersonPostModel p;
    public int q;
    public List<d.a.s0.j2.i.e> r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, gVar, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63458h = true;
        this.q = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.n = baseFragmentActivity;
        this.f63456f = baseFragmentActivity.getPageContext();
        this.f63457g = j;
        this.j = gVar;
        this.f63459i = bdUniqueId;
        this.o = gVar.f63420i;
        this.p = new PersonPostModel(this.f63456f, bdUniqueId, null, this.f63406e, PersonPostModel.FROM_PERSON_POLYMERIC);
        p pVar = new p(baseFragment, gVar, bdUniqueId, z, this.f63457g);
        this.k = pVar;
        pVar.W(this);
        f();
        this.l = this.j.q();
        this.m = this.j.l();
        ArrayList arrayList = new ArrayList(2);
        this.r = arrayList;
        arrayList.add(new d.a.s0.j2.i.e());
        this.r.add(new d.a.s0.j2.i.e());
    }

    @Override // d.a.s0.m2.d.b
    public p a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (p) invokeV.objValue;
    }

    @Override // d.a.s0.m2.d.b
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    @Override // d.a.s0.m2.d.b
    public void d() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pVar = this.k) == null) {
            return;
        }
        pVar.M();
    }

    @Override // d.a.s0.m2.d.b
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // d.a.s0.w1.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.l;
            if (personPolymericModel != null) {
                personPolymericModel.K();
            }
        }
    }

    @Override // d.a.s0.w1.a
    public void h() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.h();
    }

    public void j(d.a.s0.z3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.k.X(fVar);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.q == i2) {
            return;
        }
        p pVar = this.k;
        if (pVar != null) {
            pVar.T(i2);
        }
        this.q = i2;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f63459i);
            p pVar = this.k;
            if (pVar != null) {
                pVar.U();
            }
        }
    }

    @Override // d.a.s0.w1.a
    public void loadData() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.loadData();
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z && this.f63458h) {
            loadData();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && TbadkCoreApplication.isLogin() && !this.f63406e && this.f63457g == TbadkCoreApplication.getCurrentAccountId()) {
            this.f63406e = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f63456f.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.n.finish();
        }
    }

    public void o(d.a.s0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.k.N();
            this.n.hideLoadingView(this.o);
            boolean z = true;
            if (aVar == null) {
                this.m.x(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                this.m.m();
                this.m.s(8);
                return;
            }
            this.m.o();
            if (aVar.e() != null && ((aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 1) || (aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 2))) {
                this.m.u(this.f63406e);
                this.m.s(8);
                return;
            }
            this.m.s(0);
            aVar.b();
            z = (aVar.f() == null || aVar.f().size() < 20) ? false : false;
            if (aVar.j() != null) {
                aVar.j().getSex();
            }
            this.f63458h = false;
            if (this.f63406e && aVar.j() != null) {
                aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                d.a.r0.z.b.a().e(aVar.j());
            }
            d.a.s0.j2.i.e eVar = this.r.get(0);
            eVar.a(aVar.f());
            eVar.b(z);
            this.k.Z(aVar, z, i(aVar));
        }
    }
}
