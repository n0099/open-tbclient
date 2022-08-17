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
import com.repackage.f48;
import com.repackage.vd8;
/* loaded from: classes6.dex */
public class l38 implements f48.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCenterModel a;
    public f48 b;
    public boolean c;
    public PersonCenterModel.d d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes6.dex */
    public class a implements PersonCenterModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l38 a;

        /* renamed from: com.repackage.l38$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0519a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0519a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.c) {
                    this.a.a.b.p();
                }
            }
        }

        public a(l38 l38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l38Var;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void a(r38 r38Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r38Var) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.b.f();
                this.a.b.l(r38Var);
                if (r38Var != null && r38Var.r() != null) {
                    xn4.b(r38Var.r().getPersonPrivate());
                }
                a38.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e = a38.d().e();
                if (e > 0) {
                    a38.d().k(System.currentTimeMillis() - e);
                    a38.d().j(0L);
                }
                if (this.a.c) {
                    rg.a().postDelayed(new RunnableC0519a(this), 500L);
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && i == -1 && !this.a.a.mIsDataLoaded) {
                this.a.b.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l38 l38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l38Var, Integer.valueOf(i)};
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
            this.a = l38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            vd8 vd8Var;
            SparseArray<vd8.a> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof vd8) || (sparseArray = (vd8Var = (vd8) customResponsedMessage.getData()).a) == null || sparseArray.size() <= 0) {
                return;
            }
            vd8.a aVar = vd8Var.a.get(2);
            vd8.a aVar2 = vd8Var.a.get(3);
            vd8.a aVar3 = vd8Var.a.get(9);
            vd8.a aVar4 = vd8Var.a.get(10);
            if (this.a.a.D() != null) {
                if (aVar2 != null) {
                    this.a.a.D().f(aVar2.a);
                }
                if (aVar != null) {
                    this.a.a.D().d(aVar.a);
                }
                if (aVar3 != null) {
                    this.a.a.D().c(aVar3.a);
                }
                if (aVar4 != null) {
                    this.a.a.D().e(aVar4.a);
                }
            }
            vd8.a aVar5 = vd8Var.a.get(5);
            if (aVar5 != null) {
                this.a.b.o(5, aVar5.a);
            }
            vd8.a aVar6 = vd8Var.a.get(6);
            if (aVar6 != null) {
                this.a.b.o(6, aVar6.a);
            }
            this.a.b.i();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l38 l38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l38Var, Integer.valueOf(i)};
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

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l38 l38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l38Var, Integer.valueOf(i)};
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
            this.a = l38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || (userPendantData = (UserPendantData) customResponsedMessage.getData()) == null) {
                return;
            }
            if (this.a.a.D() != null) {
                this.a.a.D().w(userPendantData);
                this.a.b.i();
                return;
            }
            this.a.j();
        }
    }

    public l38(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.c = false;
        this.d = new a(this);
        this.e = new b(this, 2001435);
        this.f = new c(this, 2005016);
        this.g = new d(this, 2016485);
        f48 f48Var = new f48(view2, tbPageContext, bdUniqueId);
        this.b = f48Var;
        f48Var.m(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.a = personCenterModel;
        personCenterModel.J(this.d);
        PersonRedTipManager.getInstance();
        this.e.setTag(bdUniqueId);
        this.f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e);
        MessageManager.getInstance().registerListener(this.f);
        this.g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g);
    }

    @Override // com.repackage.f48.c
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a.loadData();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.e();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.g();
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b.j(i);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.k();
        }
    }

    public void i(String str) {
        r38 D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (D = this.a.D()) == null || D.r() == null) {
            return;
        }
        D.r().setName_show(str);
        this.b.i();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a38.d().j(System.currentTimeMillis());
            this.a.loadData();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
            this.a.K(z);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
