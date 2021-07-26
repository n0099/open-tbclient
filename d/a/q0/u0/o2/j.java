package d.a.q0.u0.o2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.u0.q;
import d.a.q0.u0.r0;
import d.a.q0.u0.t;
import d.a.q0.u0.z;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class j extends d.a.q0.u0.e2.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.u0.h2.a f64099h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64100i;
    public HashMap<Integer, z> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public r0 q;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f64101a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f64101a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f64101a.k = false;
                return;
            }
            this.f64101a.k = true;
            this.f64101a.f63349b.K2().L();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f64102a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f64102a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f64102a.f63348a == null) {
                return;
            }
            this.f64102a.f63348a.O1();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f64103a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f64103a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                this.f64103a.f63348a.Q1();
                z zVar = (z) customResponsedMessage.getData();
                r0 r0Var = zVar.f64663b;
                if (r0Var != null) {
                    this.f64103a.c0(zVar.f64662a, r0Var);
                } else {
                    int i2 = zVar.f64662a;
                    if (i2 != 1) {
                        this.f64103a.c0(i2, null);
                    } else {
                        j jVar = this.f64103a;
                        jVar.c0(i2, jVar.q);
                    }
                }
                this.f64103a.f0(zVar.f64662a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f64104a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f64104a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                z zVar = (z) customResponsedMessage.getData();
                this.f64104a.d0(zVar.f64662a, zVar.f64664c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f64105a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f64105a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                t tVar = (t) customResponsedMessage.getData();
                this.f64105a.e0(tVar.f64450a, tVar.f64451b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f64106e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f64107e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64107e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64107e.f64106e.f63348a.g0() == null || this.f64107e.f64106e.f63353f == null || this.f64107e.f64106e.f63348a.g0().getVisibility() == 0) {
                    return;
                }
                this.f64107e.f64106e.f63353f.o();
            }
        }

        public f(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64106e = jVar;
        }

        @Override // d.a.q0.u0.r0
        public void H() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f64106e.f63349b != null && this.f64106e.f63349b.isAdded()) {
                if (this.f64106e.f64100i && this.f64106e.f63349b.K2() != null) {
                    if (!this.f64106e.k && !this.f64106e.a0()) {
                        this.f64106e.f63349b.K2().f0();
                    }
                    this.f64106e.f64100i = false;
                }
                if (this.f64106e.f64099h != null && this.f64106e.f63349b.G0() != null && this.f64106e.f63349b.G0().Y() != null && !this.f64106e.f63349b.G0().Y().o() && this.f64106e.f63349b.K2() != null && !this.f64106e.f63349b.K2().W()) {
                    this.f64106e.f64099h.b();
                }
                if (this.f64106e.f63348a == null || this.f64106e.f63353f == null || this.f64106e.f63351d == null || this.f64106e.f64099h == null) {
                    return;
                }
                this.f64106e.f63348a.i0().n(0, 0, true, true);
                this.f64106e.f63349b.m3();
                this.f64106e.f63349b.y3(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.f64106e.f63351d.r0();
                if (!TbadkCoreApplication.isLogin() || this.f64106e.f63349b.G2().getVisibility() != 0 || ListUtils.isEmpty(this.f64106e.f63349b.l0().getThreadList())) {
                }
            }
        }

        @Override // d.a.q0.u0.r0
        public void o0() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f64106e.f64100i = true;
                if (this.f64106e.f63348a == null || this.f64106e.f63353f == null || this.f64106e.f63351d == null || this.f64106e.f63349b == null || !this.f64106e.f63349b.isAdded()) {
                    return;
                }
                if (this.f64106e.f63348a != null && this.f64106e.f63348a.i0() != null) {
                    this.f64106e.f63348a.i0().w();
                }
                this.f64106e.f63349b.y3(false);
                d.a.d.e.m.e.a().postDelayed(new a(this), 110L);
                this.f64106e.f63348a.n1(1, true);
                if (d.a.d.e.p.j.z()) {
                    this.f64106e.f63349b.refresh();
                    this.f64106e.f63349b.y3(true);
                } else {
                    this.f64106e.f63349b.Q3();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.f64106e.f63349b.A()).param("obj_locate", "1"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64100i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.f64099h = frsFragment.E2();
        this.j = new HashMap<>();
        this.f63348a.c1(1);
        frsFragment.registerListener(this.m);
        frsFragment.registerListener(this.n);
        frsFragment.registerListener(this.o);
        frsFragment.registerListener(this.p);
        frsFragment.registerListener(this.l);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f63349b.l0() == null || this.f63349b.l0().getUserData() == null || this.f63349b.l0().forumRule == null || this.f63349b.l0().getForum() == null || !this.f63349b.l0().getForum().getIsShowRule()) {
                return false;
            }
            return this.f63349b.l0().getUserData().getIs_manager() == 1 ? this.f63349b.l0().forumRule.has_forum_rule.intValue() != 1 && this.f63349b.l0().forumRule.audit_status.intValue() == 0 && d.a.p0.s.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f63349b.l0().forumRule.has_forum_rule.intValue() == 1 && d.a.p0.s.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f63348a == null) {
            return;
        }
        n nVar = this.f63350c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).z() != null && (((FrsTabViewController) this.f63350c).z().f16138b instanceof r0)) {
            FrsTabViewController.o z = ((FrsTabViewController) this.f63350c).z();
            c0(z.f16137a, (r0) z.f16138b);
            f0(z.f16137a);
            return;
        }
        this.f63348a.j1(this.q);
    }

    public final void c0(int i2, r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, r0Var) == null) {
            z zVar = this.j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f64662a = i2;
                zVar2.f64663b = r0Var;
                this.j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f64663b = r0Var;
            }
            q qVar = this.f63348a;
            if (qVar != null) {
                qVar.j1(r0Var);
            }
        }
    }

    public final void d0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            z zVar = this.j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f64662a = i2;
                zVar2.f64664c = z;
                this.j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f64664c = z;
            }
            q qVar = this.f63348a;
            if (qVar != null) {
                qVar.x1(z);
            }
        }
    }

    public final void e0(int i2, boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (qVar = this.f63348a) == null) {
            return;
        }
        qVar.n1(i2, z);
    }

    public final void f0(int i2) {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f63348a == null || (zVar = this.j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f63348a.c1(i2);
        this.f63348a.j1(zVar.f64663b);
        this.f63348a.x1(zVar.f64664c);
        if (zVar.f64663b == null) {
            this.f63348a.x1(false);
        }
    }
}
