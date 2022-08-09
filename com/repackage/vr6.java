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
/* loaded from: classes7.dex */
public class vr6 extends jo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rp6 h;
    public boolean i;
    public HashMap<Integer, kf6> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public cg6 q;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vr6 vr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var, Integer.valueOf(i)};
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
            this.a = vr6Var;
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
            this.a.b.E3().P();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vr6 vr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var, Integer.valueOf(i)};
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
            this.a = vr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.a == null) {
                return;
            }
            this.a.a.V1();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vr6 vr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var, Integer.valueOf(i)};
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
            this.a = vr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof kf6)) {
                this.a.a.X1();
                kf6 kf6Var = (kf6) customResponsedMessage.getData();
                cg6 cg6Var = kf6Var.b;
                if (cg6Var != null) {
                    this.a.c0(kf6Var.a, cg6Var);
                } else {
                    int i = kf6Var.a;
                    if (i != 1) {
                        this.a.c0(i, null);
                    } else {
                        vr6 vr6Var = this.a;
                        vr6Var.c0(i, vr6Var.q);
                    }
                }
                this.a.f0(kf6Var.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(vr6 vr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var, Integer.valueOf(i)};
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
            this.a = vr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof kf6)) {
                kf6 kf6Var = (kf6) customResponsedMessage.getData();
                this.a.d0(kf6Var.a, kf6Var.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(vr6 vr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var, Integer.valueOf(i)};
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
            this.a = vr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof df6)) {
                df6 df6Var = (df6) customResponsedMessage.getData();
                this.a.e0(df6Var.a, df6Var.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements cg6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        /* loaded from: classes7.dex */
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.a.j0() == null || this.a.a.f == null || this.a.a.a.j0().getVisibility() == 0) {
                    return;
                }
                this.a.a.f.o();
            }
        }

        public f(vr6 vr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr6Var;
        }

        @Override // com.repackage.cg6
        public void V0() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i = true;
                if (this.a.a == null || this.a.f == null || this.a.d == null || this.a.b == null || !this.a.b.isAdded()) {
                    return;
                }
                if (this.a.a != null && this.a.a.l0() != null) {
                    this.a.a.l0().x();
                }
                this.a.b.D4(false);
                rg.a().postDelayed(new a(this), 110L);
                this.a.a.t1(1, true);
                if (oi.z()) {
                    this.a.b.refresh();
                    this.a.b.D4(true);
                } else {
                    this.a.b.U4();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.a.b.U()).param("obj_locate", "1"));
            }
        }

        @Override // com.repackage.cg6
        public void d0() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.i && this.a.b.E3() != null) {
                    if (!this.a.k && !this.a.a0()) {
                        this.a.b.E3().j0();
                    }
                    this.a.i = false;
                }
                if (this.a.h != null && this.a.b.k1() != null && this.a.b.k1().Z() != null && !this.a.b.k1().Z().p() && this.a.b.E3() != null && !this.a.b.E3().a0()) {
                    this.a.h.b();
                }
                if (this.a.a == null || this.a.f == null || this.a.d == null || this.a.h == null) {
                    return;
                }
                this.a.a.l0().n(0, 0, true, true);
                this.a.b.o4();
                this.a.b.D4(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.a.d.u0();
                if (!TbadkCoreApplication.isLogin() || this.a.b.y3().getVisibility() != 0 || ListUtils.isEmpty(this.a.b.P0().getThreadList())) {
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vr6(FrsFragment frsFragment) {
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
        this.h = frsFragment.t3();
        this.j = new HashMap<>();
        this.a.h1(1);
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
            if (this.b.P0() == null || this.b.P0().getUserData() == null || this.b.P0().forumRule == null || this.b.P0().getForum() == null || !this.b.P0().getForum().getIsShowRule()) {
                return false;
            }
            return this.b.P0().getUserData().getIs_manager() == 1 ? this.b.P0().forumRule.has_forum_rule.intValue() != 1 && this.b.P0().forumRule.audit_status.intValue() == 0 && ru4.k().l("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.b.P0().forumRule.has_forum_rule.intValue() == 1 && ru4.k().l("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        zr6 zr6Var = this.c;
        if ((zr6Var instanceof FrsTabViewController) && ((FrsTabViewController) zr6Var).C() != null && (((FrsTabViewController) this.c).C().b instanceof cg6)) {
            FrsTabViewController.p C = ((FrsTabViewController) this.c).C();
            c0(C.a, (cg6) C.b);
            f0(C.a);
            return;
        }
        this.a.p1(this.q);
    }

    public final void c0(int i, cg6 cg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, cg6Var) == null) {
            kf6 kf6Var = this.j.get(Integer.valueOf(i));
            if (kf6Var == null) {
                kf6 kf6Var2 = new kf6();
                kf6Var2.a = i;
                kf6Var2.b = cg6Var;
                this.j.put(Integer.valueOf(i), kf6Var2);
            } else {
                kf6Var.b = cg6Var;
            }
            af6 af6Var = this.a;
            if (af6Var != null) {
                af6Var.p1(cg6Var);
            }
        }
    }

    public final void d0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            kf6 kf6Var = this.j.get(Integer.valueOf(i));
            if (kf6Var == null) {
                kf6 kf6Var2 = new kf6();
                kf6Var2.a = i;
                kf6Var2.c = z;
                this.j.put(Integer.valueOf(i), kf6Var2);
            } else {
                kf6Var.c = z;
            }
            af6 af6Var = this.a;
            if (af6Var != null) {
                af6Var.E1(z);
            }
        }
    }

    public final void e0(int i, boolean z) {
        af6 af6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (af6Var = this.a) == null) {
            return;
        }
        af6Var.t1(i, z);
    }

    public final void f0(int i) {
        kf6 kf6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.a == null || (kf6Var = this.j.get(Integer.valueOf(i))) == null) {
            return;
        }
        this.a.h1(i);
        this.a.p1(kf6Var.b);
        this.a.E1(kf6Var.c);
        if (kf6Var.b == null) {
            this.a.E1(false);
        }
    }
}
