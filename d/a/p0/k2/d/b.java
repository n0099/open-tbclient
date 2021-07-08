package d.a.p0.k2.d;

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
import d.a.o0.t.n;
import d.a.p0.k2.e.f;
import d.a.p0.k2.g.c;
import d.a.p0.x2.b;
/* loaded from: classes8.dex */
public class b implements c.InterfaceC1511c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f59371a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.k2.g.c f59372b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f59373c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f59374d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f59375e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f59376f;

    /* loaded from: classes8.dex */
    public class a implements PersonCenterModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59377a;

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
            this.f59377a = bVar;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f59377a.f59372b.d();
                this.f59377a.f59372b.j(fVar);
                if (fVar != null && fVar.p() != null) {
                    d.a.o0.r.l.f.b(fVar.p().getPersonPrivate());
                }
                d.a.p0.k2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e2 = d.a.p0.k2.a.d().e();
                if (e2 > 0) {
                    d.a.p0.k2.a.d().k(System.currentTimeMillis() - e2);
                    d.a.p0.k2.a.d().j(0L);
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 != -1 || this.f59377a.f59371a.mIsDataLoaded) {
                    this.f59377a.f59372b.l(i2, str);
                } else {
                    this.f59377a.f59372b.n();
                }
            }
        }
    }

    /* renamed from: d.a.p0.k2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1510b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59378a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1510b(b bVar, int i2) {
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
            this.f59378a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.p0.x2.b bVar;
            SparseArray<b.a> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.p0.x2.b) || (sparseArray = (bVar = (d.a.p0.x2.b) customResponsedMessage.getData()).f66237a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f66237a.get(2);
            b.a aVar2 = bVar.f66237a.get(3);
            b.a aVar3 = bVar.f66237a.get(9);
            b.a aVar4 = bVar.f66237a.get(10);
            if (this.f59378a.f59371a.A() != null) {
                if (aVar2 != null) {
                    this.f59378a.f59371a.A().f(aVar2.f66238a);
                }
                if (aVar != null) {
                    this.f59378a.f59371a.A().d(aVar.f66238a);
                }
                if (aVar3 != null) {
                    this.f59378a.f59371a.A().c(aVar3.f66238a);
                }
                if (aVar4 != null) {
                    this.f59378a.f59371a.A().e(aVar4.f66238a);
                }
            }
            b.a aVar5 = bVar.f66237a.get(5);
            if (aVar5 != null) {
                this.f59378a.f59372b.o(5, aVar5.f66238a);
            }
            b.a aVar6 = bVar.f66237a.get(6);
            if (aVar6 != null) {
                this.f59378a.f59372b.o(6, aVar6.f66238a);
            }
            this.f59378a.f59372b.g();
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
            d.a.p0.x2.a.v().I(false);
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59379a;

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
            this.f59379a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof n) || (nVar = (n) customResponsedMessage.getData()) == null) {
                return;
            }
            if (this.f59379a.f59371a.A() != null) {
                this.f59379a.f59371a.A().u(nVar);
                this.f59379a.f59372b.g();
                return;
            }
            this.f59379a.j();
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
        this.f59373c = new a(this);
        this.f59374d = new C1510b(this, 2001435);
        this.f59375e = new c(this, 2005016);
        this.f59376f = new d(this, 2016485);
        d.a.p0.k2.g.c cVar = new d.a.p0.k2.g.c(view, tbPageContext, bdUniqueId);
        this.f59372b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f59371a = personCenterModel;
        personCenterModel.F(this.f59373c);
        d.a.p0.x2.a.v();
        this.f59374d.setTag(bdUniqueId);
        this.f59375e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f59374d);
        MessageManager.getInstance().registerListener(this.f59375e);
        this.f59376f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f59376f);
    }

    @Override // d.a.p0.k2.g.c.InterfaceC1511c
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f59371a.LoadData();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f59372b.c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59372b.e();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f59372b.h(i2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59372b.i();
        }
    }

    public void h(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (A = this.f59371a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setPortrait(str);
        this.f59372b.g();
    }

    public void i(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (A = this.f59371a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setName_show(str);
        this.f59372b.g();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.p0.k2.a.d().j(System.currentTimeMillis());
            this.f59371a.LoadData();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f59371a.G(z);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f59372b.m();
        }
    }
}
