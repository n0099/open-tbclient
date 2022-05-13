package com.repackage;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fc8;
import com.repackage.s28;
/* loaded from: classes7.dex */
public class y18 implements s28.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCenterModel a;
    public s28 b;
    public PersonCenterModel.c c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;

    /* loaded from: classes7.dex */
    public class a implements PersonCenterModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y18 a;

        public a(y18 y18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y18Var;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(e28 e28Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e28Var) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.b.f();
                this.a.b.l(e28Var);
                if (e28Var != null && e28Var.q() != null) {
                    rn4.b(e28Var.q().getPersonPrivate());
                }
                n18.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e = n18.d().e();
                if (e > 0) {
                    n18.d().k(System.currentTimeMillis() - e);
                    n18.d().j(0L);
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && i == -1 && !this.a.a.mIsDataLoaded) {
                this.a.b.o();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y18 y18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            fc8 fc8Var;
            SparseArray<fc8.a> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof fc8) || (sparseArray = (fc8Var = (fc8) customResponsedMessage.getData()).a) == null || sparseArray.size() <= 0) {
                return;
            }
            fc8.a aVar = fc8Var.a.get(2);
            fc8.a aVar2 = fc8Var.a.get(3);
            fc8.a aVar3 = fc8Var.a.get(9);
            fc8.a aVar4 = fc8Var.a.get(10);
            if (this.a.a.C() != null) {
                if (aVar2 != null) {
                    this.a.a.C().f(aVar2.a);
                }
                if (aVar != null) {
                    this.a.a.C().d(aVar.a);
                }
                if (aVar3 != null) {
                    this.a.a.C().c(aVar3.a);
                }
                if (aVar4 != null) {
                    this.a.a.C().e(aVar4.a);
                }
            }
            fc8.a aVar5 = fc8Var.a.get(5);
            if (aVar5 != null) {
                this.a.b.p(5, aVar5.a);
            }
            fc8.a aVar6 = fc8Var.a.get(6);
            if (aVar6 != null) {
                this.a.b.p(6, aVar6.a);
            }
            this.a.b.i();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(y18 y18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            PersonRedTipManager.getInstance().setIsPrimary(false);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(y18 y18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || (userPendantData = (UserPendantData) customResponsedMessage.getData()) == null) {
                return;
            }
            if (this.a.a.C() != null) {
                this.a.a.C().v(userPendantData);
                this.a.b.i();
                return;
            }
            this.a.j();
        }
    }

    public y18(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        this.d = new b(this, 2001435);
        this.e = new c(this, 2005016);
        this.f = new d(this, 2016485);
        s28 s28Var = new s28(view2, tbPageContext, bdUniqueId);
        this.b = s28Var;
        s28Var.m(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.a = personCenterModel;
        personCenterModel.H(this.c);
        PersonRedTipManager.getInstance();
        this.d.setTag(bdUniqueId);
        this.e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(this.e);
        this.f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f);
    }

    @Override // com.repackage.s28.e
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a.loadData();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.e();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.g();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b.j(i);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.k();
        }
    }

    public void h(String str) {
        e28 C;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (C = this.a.C()) == null || C.q() == null) {
            return;
        }
        C.q().setPortrait(str);
        this.b.i();
    }

    public void i(String str) {
        e28 C;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (C = this.a.C()) == null || C.q() == null) {
            return;
        }
        C.q().setName_show(str);
        this.b.i();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            n18.d().j(System.currentTimeMillis());
            this.a.loadData();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a.I(z);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.n();
        }
    }
}
