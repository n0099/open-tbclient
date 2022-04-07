package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bo5;
/* loaded from: classes6.dex */
public class fr5 extends cr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bo5 f;
    public boolean g;
    public yn5 h;
    public AlaInfoData i;
    public CustomMessageListener j;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fr5 fr5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr5Var, Integer.valueOf(i)};
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
            this.a = fr5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bo5.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr5 a;

        public b(fr5 fr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fr5Var;
        }

        @Override // com.repackage.bo5.e
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null) {
                return;
            }
            dq5.c().f("c12909", this.a.d.e, 1, threadData.getId(), threadData.getFid(), threadData.getForum_name(), this.a.i);
        }

        @Override // com.repackage.bo5.e
        public void b(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null) {
                return;
            }
            dq5.c().f("c12910", this.a.d.e, 1, threadData.getId(), threadData.getFid(), threadData.getForum_name(), this.a.i);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr5 a;

        public c(fr5 fr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fr5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fr5(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.j = new a(this, 2000994);
        this.k = new c(this);
    }

    @Override // com.repackage.cr5
    public void b(qq5 qq5Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qq5Var) == null) {
            super.b(qq5Var);
            q();
            bo5 bo5Var = this.f;
            if (bo5Var != null) {
                bo5Var.n(this.h);
            }
            yn5 yn5Var = this.h;
            if (yn5Var == null || (threadData = yn5Var.a) == null) {
                return;
            }
            this.i = threadData.getThreadAlaInfo();
            dq5.c().f("c12908", this.d.e, 1, this.h.a.getId(), this.h.a.getFid(), this.h.a.getForum_name(), this.i);
        }
    }

    @Override // com.repackage.cr5
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f.j() : (View) invokeV.objValue;
    }

    @Override // com.repackage.cr5
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = new bo5(this.c, true);
            MessageManager.getInstance().registerListener(this.j);
            this.f.w(new b(this));
        }
    }

    @Override // com.repackage.cr5
    public boolean f(qq5 qq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qq5Var)) == null) ? (qq5Var == null || 1 != qq5Var.d || ListUtils.isEmpty(qq5Var.c) || qq5Var.c.get(0) == null || qq5Var.c.get(0).getThreadAlaInfo() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.cr5
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.g = z;
        }
    }

    @Override // com.repackage.cr5
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            bo5 bo5Var = this.f;
            if (bo5Var != null) {
                bo5Var.m();
            }
        }
    }

    @Override // com.repackage.cr5
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f.o();
        }
    }

    @Override // com.repackage.cr5
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            pg.a().removeCallbacks(this.k);
            bo5 bo5Var = this.f;
            if (bo5Var != null) {
                bo5Var.p();
            }
        }
    }

    @Override // com.repackage.cr5
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
        }
    }

    @Override // com.repackage.cr5
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
        }
    }

    @Override // com.repackage.cr5
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.g) {
            return;
        }
        if (kd5.a(1)) {
            pg.a().removeCallbacks(this.k);
            pg.a().postDelayed(this.k, 1000L);
            return;
        }
        bo5 bo5Var = this.f;
        if (bo5Var != null) {
            bo5Var.r();
        }
    }

    @Override // com.repackage.cr5
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            bo5 bo5Var = this.f;
            if (bo5Var != null) {
                bo5Var.r();
            }
            pg.a().removeCallbacks(this.k);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            yn5 yn5Var = new yn5();
            this.h = yn5Var;
            yn5Var.a = this.d.c.get(0);
        }
    }

    public final void r() {
        yn5 yn5Var;
        ThreadData threadData;
        bo5 bo5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (yn5Var = this.h) == null || (threadData = yn5Var.a) == null || threadData.getThreadAlaInfo() == null || (bo5Var = this.f) == null) {
            return;
        }
        bo5Var.x(this.h.a.getThreadAlaInfo().hls_url);
    }
}
