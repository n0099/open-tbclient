package d.a.q0.v.d.b.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.e;
import d.a.p0.b1.o0;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.b.b.c;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f64901a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.v.d.b.d.b f64902b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64903c;

    /* renamed from: d  reason: collision with root package name */
    public c f64904d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f64905e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f64906f;

    /* renamed from: d.a.q0.v.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1754a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64907a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1754a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f64907a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f64907a.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64908e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64908e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64908e.i();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64901a = null;
        this.f64903c = false;
        this.f64905e = new C1754a(this, 2000994);
        this.f64906f = new b(this);
        this.f64901a = tbPageContext;
        this.f64902b = new d.a.q0.v.d.b.d.b(tbPageContext);
        MessageManager.getInstance().registerListener(this.f64905e);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64903c) {
            return;
        }
        if (o0.a(1)) {
            e.a().removeCallbacks(this.f64906f);
            e.a().postDelayed(this.f64906f, 1000L);
            return;
        }
        d.a.q0.v.d.b.d.b bVar = this.f64902b;
        if (bVar != null) {
            bVar.r();
        }
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64904d : (c) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64902b.j() : (View) invokeV.objValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f64903c = z;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null || cVar.f64885a == null) {
            return;
        }
        this.f64904d = cVar;
        d.a.q0.v.d.b.d.b bVar = this.f64902b;
        if (bVar != null) {
            bVar.n(cVar);
            StatisticItem statisticItem = new StatisticItem("c12644");
            int i2 = cVar.f64886b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", cVar.f64885a.o1());
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f64902b.o();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f64905e);
            e.a().removeCallbacks(this.f64906f);
            d.a.q0.v.d.b.d.b bVar = this.f64902b;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    public final void i() {
        c cVar;
        b2 b2Var;
        d.a.q0.v.d.b.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.f64904d) == null || (b2Var = cVar.f64885a) == null || b2Var.h1() == null || (bVar = this.f64902b) == null) {
            return;
        }
        bVar.x(this.f64904d.f64885a.h1().hls_url);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.v.d.b.d.b bVar = this.f64902b;
            if (bVar != null) {
                bVar.r();
            }
            e.a().removeCallbacks(this.f64906f);
        }
    }
}
