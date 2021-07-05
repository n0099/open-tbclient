package d.a.s0.k2.d;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.t.n;
import d.a.s0.k2.e.f;
import d.a.s0.k2.g.c;
import d.a.s0.x2.b;
/* loaded from: classes9.dex */
public class b implements c.InterfaceC1555c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f62608a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.k2.g.c f62609b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f62610c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f62611d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62612e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f62613f;

    /* loaded from: classes9.dex */
    public class a implements PersonCenterModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62614a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62614a = bVar;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f62614a.f62609b.d();
                this.f62614a.f62609b.j(fVar);
                if (fVar != null && fVar.p() != null) {
                    d.a.r0.r.l.f.b(fVar.p().getPersonPrivate());
                }
                d.a.s0.k2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e2 = d.a.s0.k2.a.d().e();
                if (e2 > 0) {
                    d.a.s0.k2.a.d().k(System.currentTimeMillis() - e2);
                    d.a.s0.k2.a.d().j(0L);
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 != -1 || this.f62614a.f62608a.mIsDataLoaded) {
                    this.f62614a.f62609b.l(i2, str);
                } else {
                    this.f62614a.f62609b.n();
                }
            }
        }
    }

    /* renamed from: d.a.s0.k2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1554b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62615a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1554b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62615a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.s0.x2.b bVar;
            SparseArray<b.a> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.s0.x2.b) || (sparseArray = (bVar = (d.a.s0.x2.b) customResponsedMessage.getData()).f69449a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f69449a.get(2);
            b.a aVar2 = bVar.f69449a.get(3);
            b.a aVar3 = bVar.f69449a.get(9);
            b.a aVar4 = bVar.f69449a.get(10);
            if (this.f62615a.f62608a.A() != null) {
                if (aVar2 != null) {
                    this.f62615a.f62608a.A().f(aVar2.f69450a);
                }
                if (aVar != null) {
                    this.f62615a.f62608a.A().d(aVar.f69450a);
                }
                if (aVar3 != null) {
                    this.f62615a.f62608a.A().c(aVar3.f69450a);
                }
                if (aVar4 != null) {
                    this.f62615a.f62608a.A().e(aVar4.f69450a);
                }
            }
            b.a aVar5 = bVar.f69449a.get(5);
            if (aVar5 != null) {
                this.f62615a.f62609b.o(5, aVar5.f69450a);
            }
            b.a aVar6 = bVar.f69449a.get(6);
            if (aVar6 != null) {
                this.f62615a.f62609b.o(6, aVar6.f69450a);
            }
            this.f62615a.f62609b.g();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            d.a.s0.x2.a.v().I(false);
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62616a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62616a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof n) || (nVar = (n) customResponsedMessage.getData()) == null) {
                return;
            }
            if (this.f62616a.f62608a.A() != null) {
                this.f62616a.f62608a.A().u(nVar);
                this.f62616a.f62609b.g();
                return;
            }
            this.f62616a.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62610c = new a(this);
        this.f62611d = new C1554b(this, 2001435);
        this.f62612e = new c(this, 2005016);
        this.f62613f = new d(this, 2016485);
        d.a.s0.k2.g.c cVar = new d.a.s0.k2.g.c(view, tbPageContext, bdUniqueId);
        this.f62609b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f62608a = personCenterModel;
        personCenterModel.F(this.f62610c);
        d.a.s0.x2.a.v();
        this.f62611d.setTag(bdUniqueId);
        this.f62612e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62611d);
        MessageManager.getInstance().registerListener(this.f62612e);
        this.f62613f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62613f);
    }

    @Override // d.a.s0.k2.g.c.InterfaceC1555c
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f62608a.LoadData();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62609b.c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62609b.e();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f62609b.h(i2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f62609b.i();
        }
    }

    public void h(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (A = this.f62608a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setPortrait(str);
        this.f62609b.g();
    }

    public void i(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (A = this.f62608a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setName_show(str);
        this.f62609b.g();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.s0.k2.a.d().j(System.currentTimeMillis());
            this.f62608a.LoadData();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f62608a.G(z);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f62609b.m();
        }
    }
}
