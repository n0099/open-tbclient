package d.a.q0.k2.d;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.k2.e.f;
import d.a.q0.k2.g.c;
import d.a.q0.x2.b;
/* loaded from: classes8.dex */
public class b implements c.InterfaceC1516c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f59985a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.k2.g.c f59986b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f59987c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f59988d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f59989e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f59990f;

    /* loaded from: classes8.dex */
    public class a implements PersonCenterModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59991a;

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
            this.f59991a = bVar;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f59991a.f59986b.d();
                this.f59991a.f59986b.j(fVar);
                if (fVar != null && fVar.p() != null) {
                    d.a.p0.s.l.f.b(fVar.p().getPersonPrivate());
                }
                d.a.q0.k2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e2 = d.a.q0.k2.a.d().e();
                if (e2 > 0) {
                    d.a.q0.k2.a.d().k(System.currentTimeMillis() - e2);
                    d.a.q0.k2.a.d().j(0L);
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 != -1 || this.f59991a.f59985a.mIsDataLoaded) {
                    this.f59991a.f59986b.l(i2, str);
                } else {
                    this.f59991a.f59986b.n();
                }
            }
        }
    }

    /* renamed from: d.a.q0.k2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1515b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59992a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1515b(b bVar, int i2) {
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
            this.f59992a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.q0.x2.b bVar;
            SparseArray<b.a> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.q0.x2.b) || (sparseArray = (bVar = (d.a.q0.x2.b) customResponsedMessage.getData()).f66913a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f66913a.get(2);
            b.a aVar2 = bVar.f66913a.get(3);
            b.a aVar3 = bVar.f66913a.get(9);
            b.a aVar4 = bVar.f66913a.get(10);
            if (this.f59992a.f59985a.A() != null) {
                if (aVar2 != null) {
                    this.f59992a.f59985a.A().f(aVar2.f66914a);
                }
                if (aVar != null) {
                    this.f59992a.f59985a.A().d(aVar.f66914a);
                }
                if (aVar3 != null) {
                    this.f59992a.f59985a.A().c(aVar3.f66914a);
                }
                if (aVar4 != null) {
                    this.f59992a.f59985a.A().e(aVar4.f66914a);
                }
            }
            b.a aVar5 = bVar.f66913a.get(5);
            if (aVar5 != null) {
                this.f59992a.f59986b.o(5, aVar5.f66914a);
            }
            b.a aVar6 = bVar.f66913a.get(6);
            if (aVar6 != null) {
                this.f59992a.f59986b.o(6, aVar6.f66914a);
            }
            this.f59992a.f59986b.g();
        }
    }

    /* loaded from: classes8.dex */
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
            d.a.q0.x2.a.v().I(false);
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59993a;

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
            this.f59993a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || (userPendantData = (UserPendantData) customResponsedMessage.getData()) == null) {
                return;
            }
            if (this.f59993a.f59985a.A() != null) {
                this.f59993a.f59985a.A().u(userPendantData);
                this.f59993a.f59986b.g();
                return;
            }
            this.f59993a.j();
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
        this.f59987c = new a(this);
        this.f59988d = new C1515b(this, 2001435);
        this.f59989e = new c(this, 2005016);
        this.f59990f = new d(this, 2016485);
        d.a.q0.k2.g.c cVar = new d.a.q0.k2.g.c(view, tbPageContext, bdUniqueId);
        this.f59986b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f59985a = personCenterModel;
        personCenterModel.F(this.f59987c);
        d.a.q0.x2.a.v();
        this.f59988d.setTag(bdUniqueId);
        this.f59989e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f59988d);
        MessageManager.getInstance().registerListener(this.f59989e);
        this.f59990f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f59990f);
    }

    @Override // d.a.q0.k2.g.c.InterfaceC1516c
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f59985a.LoadData();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f59986b.c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59986b.e();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f59986b.h(i2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59986b.i();
        }
    }

    public void h(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (A = this.f59985a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setPortrait(str);
        this.f59986b.g();
    }

    public void i(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (A = this.f59985a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setName_show(str);
        this.f59986b.g();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.k2.a.d().j(System.currentTimeMillis());
            this.f59985a.LoadData();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f59985a.G(z);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f59986b.m();
        }
    }
}
