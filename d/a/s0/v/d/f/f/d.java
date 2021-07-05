package d.a.s0.v.d.f.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.z0.o0;
import d.a.s0.v.d.b.d.b;
/* loaded from: classes9.dex */
public class d extends d.a.s0.v.d.f.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.v.d.b.d.b f67784f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67785g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.v.d.b.b.c f67786h;

    /* renamed from: i  reason: collision with root package name */
    public AlaInfoData f67787i;
    public CustomMessageListener j;
    public Runnable k;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f67788a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f67788a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f67788a.m();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f67789a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67789a = dVar;
        }

        @Override // d.a.s0.v.d.b.d.b.f
        public void a(b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || b2Var == null) {
                return;
            }
            d.a.s0.v.d.d.a.c().f("c12909", this.f67789a.f67777d.f67732e, 1, b2Var.c0(), this.f67789a.f67787i);
        }

        @Override // d.a.s0.v.d.b.d.b.f
        public void b(b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null) {
                return;
            }
            d.a.s0.v.d.d.a.c().f("c12910", this.f67789a.f67777d.f67732e, 1, b2Var.c0(), this.f67789a.f67787i);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67790e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67790e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67790e.r();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67785g = false;
        this.j = new a(this, 2000994);
        this.k = new c(this);
    }

    @Override // d.a.s0.v.d.f.f.a
    public void b(d.a.s0.v.d.f.c.a aVar) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            q();
            d.a.s0.v.d.b.d.b bVar = this.f67784f;
            if (bVar != null) {
                bVar.n(this.f67786h);
            }
            d.a.s0.v.d.b.b.c cVar = this.f67786h;
            if (cVar == null || (b2Var = cVar.f67458a) == null) {
                return;
            }
            this.f67787i = b2Var.g1();
            d.a.s0.v.d.d.a.c().f("c12908", this.f67777d.f67732e, 1, this.f67786h.f67458a.c0(), this.f67787i);
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67784f.j() : (View) invokeV.objValue;
    }

    @Override // d.a.s0.v.d.f.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67784f = new d.a.s0.v.d.b.d.b(this.f67776c, true);
            MessageManager.getInstance().registerListener(this.j);
            this.f67784f.w(new b(this));
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public boolean f(d.a.s0.v.d.f.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 1 != aVar.f67731d || ListUtils.isEmpty(aVar.f67730c) || aVar.f67730c.get(0) == null || aVar.f67730c.get(0).g1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // d.a.s0.v.d.f.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f67785g = z;
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            d.a.s0.v.d.b.d.b bVar = this.f67784f;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f67784f.o();
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            d.a.c.e.m.e.a().removeCallbacks(this.k);
            d.a.s0.v.d.b.d.b bVar = this.f67784f;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f67785g) {
            return;
        }
        if (o0.a(1)) {
            d.a.c.e.m.e.a().removeCallbacks(this.k);
            d.a.c.e.m.e.a().postDelayed(this.k, 1000L);
            return;
        }
        d.a.s0.v.d.b.d.b bVar = this.f67784f;
        if (bVar != null) {
            bVar.r();
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.s0.v.d.b.d.b bVar = this.f67784f;
            if (bVar != null) {
                bVar.r();
            }
            d.a.c.e.m.e.a().removeCallbacks(this.k);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.s0.v.d.b.b.c cVar = new d.a.s0.v.d.b.b.c();
            this.f67786h = cVar;
            cVar.f67458a = this.f67777d.f67730c.get(0);
        }
    }

    public final void r() {
        d.a.s0.v.d.b.b.c cVar;
        b2 b2Var;
        d.a.s0.v.d.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.f67786h) == null || (b2Var = cVar.f67458a) == null || b2Var.g1() == null || (bVar = this.f67784f) == null) {
            return;
        }
        bVar.x(this.f67786h.f67458a.g1().hls_url);
    }
}
