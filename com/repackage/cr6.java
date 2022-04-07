package com.repackage;

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
import java.util.HashMap;
/* loaded from: classes5.dex */
public class cr6 extends hn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yo6 h;
    public boolean i;
    public HashMap<Integer, yd6> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public qe6 q;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cr6 cr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr6Var, Integer.valueOf(i)};
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
            this.a = cr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.k = false;
                return;
            }
            this.a.k = true;
            this.a.b.I2().M();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(cr6 cr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr6Var, Integer.valueOf(i)};
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
            this.a = cr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.a == null) {
                return;
            }
            this.a.a.T1();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(cr6 cr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr6Var, Integer.valueOf(i)};
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
            this.a = cr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yd6)) {
                this.a.a.V1();
                yd6 yd6Var = (yd6) customResponsedMessage.getData();
                qe6 qe6Var = yd6Var.b;
                if (qe6Var != null) {
                    this.a.c0(yd6Var.a, qe6Var);
                } else {
                    int i = yd6Var.a;
                    if (i != 1) {
                        this.a.c0(i, null);
                    } else {
                        cr6 cr6Var = this.a;
                        cr6Var.c0(i, cr6Var.q);
                    }
                }
                this.a.f0(yd6Var.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(cr6 cr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr6Var, Integer.valueOf(i)};
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
            this.a = cr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yd6)) {
                yd6 yd6Var = (yd6) customResponsedMessage.getData();
                this.a.d0(yd6Var.a, yd6Var.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(cr6 cr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr6Var, Integer.valueOf(i)};
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
            this.a = cr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof rd6)) {
                rd6 rd6Var = (rd6) customResponsedMessage.getData();
                this.a.e0(rd6Var.a, rd6Var.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements qe6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr6 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.a.i0() == null || this.a.a.f == null || this.a.a.a.i0().getVisibility() == 0) {
                    return;
                }
                this.a.a.f.o();
            }
        }

        public f(cr6 cr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr6Var;
        }

        @Override // com.repackage.qe6
        public void D() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.i && this.a.b.I2() != null) {
                    if (!this.a.k && !this.a.a0()) {
                        this.a.b.I2().g0();
                    }
                    this.a.i = false;
                }
                if (this.a.h != null && this.a.b.w0() != null && this.a.b.w0().Y() != null && !this.a.b.w0().Y().o() && this.a.b.I2() != null && !this.a.b.I2().X()) {
                    this.a.h.b();
                }
                if (this.a.a == null || this.a.f == null || this.a.d == null || this.a.h == null) {
                    return;
                }
                this.a.a.k0().n(0, 0, true, true);
                this.a.b.r3();
                this.a.b.D3(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.a.d.r0();
                if (!TbadkCoreApplication.isLogin() || this.a.b.E2().getVisibility() != 0 || ListUtils.isEmpty(this.a.b.g0().getThreadList())) {
                }
            }
        }

        @Override // com.repackage.qe6
        public void k0() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.i = true;
                if (this.a.a == null || this.a.f == null || this.a.d == null || this.a.b == null || !this.a.b.isAdded()) {
                    return;
                }
                if (this.a.a != null && this.a.a.k0() != null) {
                    this.a.a.k0().x();
                }
                this.a.b.D3(false);
                pg.a().postDelayed(new a(this), 110L);
                this.a.a.r1(1, true);
                if (mi.z()) {
                    this.a.b.refresh();
                    this.a.b.D3(true);
                } else {
                    this.a.b.V3();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.a.b.z()).param("obj_locate", "1"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr6(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.h = frsFragment.C2();
        this.j = new HashMap<>();
        this.a.g1(1);
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
            if (this.b.g0() == null || this.b.g0().getUserData() == null || this.b.g0().forumRule == null || this.b.g0().getForum() == null || !this.b.g0().getForum().getIsShowRule()) {
                return false;
            }
            return this.b.g0().getUserData().getIs_manager() == 1 ? this.b.g0().forumRule.has_forum_rule.intValue() != 1 && this.b.g0().forumRule.audit_status.intValue() == 0 && wt4.k().l("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.b.g0().forumRule.has_forum_rule.intValue() == 1 && wt4.k().l("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        gr6 gr6Var = this.c;
        if ((gr6Var instanceof FrsTabViewController) && ((FrsTabViewController) gr6Var).A() != null && (((FrsTabViewController) this.c).A().b instanceof qe6)) {
            FrsTabViewController.o A = ((FrsTabViewController) this.c).A();
            c0(A.a, (qe6) A.b);
            f0(A.a);
            return;
        }
        this.a.n1(this.q);
    }

    public final void c0(int i, qe6 qe6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, qe6Var) == null) {
            yd6 yd6Var = this.j.get(Integer.valueOf(i));
            if (yd6Var == null) {
                yd6 yd6Var2 = new yd6();
                yd6Var2.a = i;
                yd6Var2.b = qe6Var;
                this.j.put(Integer.valueOf(i), yd6Var2);
            } else {
                yd6Var.b = qe6Var;
            }
            od6 od6Var = this.a;
            if (od6Var != null) {
                od6Var.n1(qe6Var);
            }
        }
    }

    public final void d0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            yd6 yd6Var = this.j.get(Integer.valueOf(i));
            if (yd6Var == null) {
                yd6 yd6Var2 = new yd6();
                yd6Var2.a = i;
                yd6Var2.c = z;
                this.j.put(Integer.valueOf(i), yd6Var2);
            } else {
                yd6Var.c = z;
            }
            od6 od6Var = this.a;
            if (od6Var != null) {
                od6Var.C1(z);
            }
        }
    }

    public final void e0(int i, boolean z) {
        od6 od6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (od6Var = this.a) == null) {
            return;
        }
        od6Var.r1(i, z);
    }

    public final void f0(int i) {
        yd6 yd6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.a == null || (yd6Var = this.j.get(Integer.valueOf(i))) == null) {
            return;
        }
        this.a.g1(i);
        this.a.n1(yd6Var.b);
        this.a.C1(yd6Var.c);
        if (yd6Var.b == null) {
            this.a.C1(false);
        }
    }
}
