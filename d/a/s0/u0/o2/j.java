package d.a.s0.u0.o2;

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
import d.a.s0.u0.q;
import d.a.s0.u0.r0;
import d.a.s0.u0.t;
import d.a.s0.u0.z;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class j extends d.a.s0.u0.e2.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.u0.h2.a f66673h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66674i;
    public HashMap<Integer, z> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public r0 q;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f66675a;

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
            this.f66675a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f66675a.k = false;
                return;
            }
            this.f66675a.k = true;
            this.f66675a.f65925b.E2().L();
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f66676a;

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
            this.f66676a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f66676a.f65924a == null) {
                return;
            }
            this.f66676a.f65924a.N1();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f66677a;

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
            this.f66677a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                this.f66677a.f65924a.P1();
                z zVar = (z) customResponsedMessage.getData();
                r0 r0Var = zVar.f67235b;
                if (r0Var != null) {
                    this.f66677a.c0(zVar.f67234a, r0Var);
                } else {
                    int i2 = zVar.f67234a;
                    if (i2 != 1) {
                        this.f66677a.c0(i2, null);
                    } else {
                        j jVar = this.f66677a;
                        jVar.c0(i2, jVar.q);
                    }
                }
                this.f66677a.f0(zVar.f67234a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f66678a;

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
            this.f66678a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                z zVar = (z) customResponsedMessage.getData();
                this.f66678a.d0(zVar.f67234a, zVar.f67236c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f66679a;

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
            this.f66679a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                t tVar = (t) customResponsedMessage.getData();
                this.f66679a.e0(tVar.f67022a, tVar.f67023b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f66680e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f66681e;

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
                this.f66681e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66681e.f66680e.f65924a.f0() == null || this.f66681e.f66680e.f65929f == null || this.f66681e.f66680e.f65924a.f0().getVisibility() == 0) {
                    return;
                }
                this.f66681e.f66680e.f65929f.o();
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
            this.f66680e = jVar;
        }

        @Override // d.a.s0.u0.r0
        public void H() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f66680e.f65925b != null && this.f66680e.f65925b.isAdded()) {
                if (this.f66680e.f66674i && this.f66680e.f65925b.E2() != null) {
                    if (!this.f66680e.k && !this.f66680e.a0()) {
                        this.f66680e.f65925b.E2().e0();
                    }
                    this.f66680e.f66674i = false;
                }
                if (this.f66680e.f66673h != null && this.f66680e.f65925b.B0() != null && this.f66680e.f65925b.B0().X() != null && !this.f66680e.f65925b.B0().X().o() && this.f66680e.f65925b.E2() != null && !this.f66680e.f65925b.E2().V()) {
                    this.f66680e.f66673h.b();
                }
                if (this.f66680e.f65924a == null || this.f66680e.f65929f == null || this.f66680e.f65927d == null || this.f66680e.f66673h == null) {
                    return;
                }
                this.f66680e.f65924a.h0().n(0, 0, true, true);
                this.f66680e.f65925b.g3();
                this.f66680e.f65925b.s3(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.f66680e.f65927d.t0();
                if (!TbadkCoreApplication.isLogin() || this.f66680e.f65925b.A2().getVisibility() != 0 || ListUtils.isEmpty(this.f66680e.f65925b.i0().getThreadList())) {
                }
            }
        }

        @Override // d.a.s0.u0.r0
        public void l0() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f66680e.f66674i = true;
                if (this.f66680e.f65924a == null || this.f66680e.f65929f == null || this.f66680e.f65927d == null || this.f66680e.f65925b == null || !this.f66680e.f65925b.isAdded()) {
                    return;
                }
                if (this.f66680e.f65924a != null && this.f66680e.f65924a.h0() != null) {
                    this.f66680e.f65924a.h0().w();
                }
                this.f66680e.f65925b.s3(false);
                d.a.c.e.m.e.a().postDelayed(new a(this), 110L);
                this.f66680e.f65924a.m1(1, true);
                if (d.a.c.e.p.j.z()) {
                    this.f66680e.f65925b.refresh();
                    this.f66680e.f65925b.s3(true);
                } else {
                    this.f66680e.f65925b.K3();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.f66680e.f65925b.A()).param("obj_locate", "1"));
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
        this.f66674i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.f66673h = frsFragment.y2();
        this.j = new HashMap<>();
        this.f65924a.b1(1);
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
            if (this.f65925b.i0() == null || this.f65925b.i0().getUserData() == null || this.f65925b.i0().forumRule == null || this.f65925b.i0().getForum() == null || !this.f65925b.i0().getForum().getIsShowRule()) {
                return false;
            }
            return this.f65925b.i0().getUserData().getIs_manager() == 1 ? this.f65925b.i0().forumRule.has_forum_rule.intValue() != 1 && this.f65925b.i0().forumRule.audit_status.intValue() == 0 && d.a.r0.r.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f65925b.i0().forumRule.has_forum_rule.intValue() == 1 && d.a.r0.r.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f65924a == null) {
            return;
        }
        n nVar = this.f65926c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).z() != null && (((FrsTabViewController) this.f65926c).z().f16044b instanceof r0)) {
            FrsTabViewController.o z = ((FrsTabViewController) this.f65926c).z();
            c0(z.f16043a, (r0) z.f16044b);
            f0(z.f16043a);
            return;
        }
        this.f65924a.i1(this.q);
    }

    public final void c0(int i2, r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, r0Var) == null) {
            z zVar = this.j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f67234a = i2;
                zVar2.f67235b = r0Var;
                this.j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f67235b = r0Var;
            }
            q qVar = this.f65924a;
            if (qVar != null) {
                qVar.i1(r0Var);
            }
        }
    }

    public final void d0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            z zVar = this.j.get(Integer.valueOf(i2));
            if (zVar == null) {
                z zVar2 = new z();
                zVar2.f67234a = i2;
                zVar2.f67236c = z;
                this.j.put(Integer.valueOf(i2), zVar2);
            } else {
                zVar.f67236c = z;
            }
            q qVar = this.f65924a;
            if (qVar != null) {
                qVar.w1(z);
            }
        }
    }

    public final void e0(int i2, boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (qVar = this.f65924a) == null) {
            return;
        }
        qVar.m1(i2, z);
    }

    public final void f0(int i2) {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f65924a == null || (zVar = this.j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f65924a.b1(i2);
        this.f65924a.i1(zVar.f67235b);
        this.f65924a.w1(zVar.f67236c);
        if (zVar.f67235b == null) {
            this.f65924a.w1(false);
        }
    }
}
