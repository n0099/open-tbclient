package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class im6 extends qm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener h;
    public final c9 i;
    public final c9 j;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(im6 im6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im6Var, Integer.valueOf(i)};
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
            this.a = im6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof oh8)) {
                this.a.b((oh8) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(im6 im6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Boolean)) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im6 a;

        public c(im6 im6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im6Var;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                    return;
                }
                this.a.b.refresh();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im6(FrsFragment frsFragment) {
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
        this.h = new a(this, 2001266);
        this.i = new b(this);
        this.j = new c(this);
        frsFragment.registerListener(this.h);
    }

    public final void b(oh8 oh8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oh8Var) == null) || oh8Var == null) {
            return;
        }
        FrsViewData Q0 = this.b.Q0();
        if (this.e == null || this.d == null || this.a == null || Q0 == null || Q0.getForum() == null || oh8Var.g() == null) {
            return;
        }
        boolean z = oh8Var.n() == 1;
        if (oh8Var.g().equals(Q0.getForum().getId())) {
            Q0.getForum().setLike(oh8Var.n());
            if (!StringUtils.isNULL(oh8Var.h())) {
                Q0.getForum().setLevelName(oh8Var.h());
            }
            if (oh8Var.m() >= 0) {
                Q0.getForum().setUser_level(oh8Var.m());
            }
            if (z) {
                this.d.i0(Q0, false);
                TbadkCoreApplication.getInst().addLikeForum(this.b.c());
                return;
            }
            ug8.i().n(this.b.c(), false);
            Q0.getForum().setLike(0);
            this.d.l0();
            TbadkCoreApplication.getInst().delLikeForum(this.b.c());
            return;
        }
        if (oh8Var.n() == 1) {
            Q0.deleteLikeFeedForum(oh8Var.g());
            this.d.U(Q0);
            this.c.d(Q0, this.e.V());
        }
        if (Q0.getForum().getBannerListData() != null) {
            Q0.getForum().getBannerListData().setFeedForumLiked(oh8Var.g(), oh8Var.n());
        }
        this.a.J0();
    }
}
