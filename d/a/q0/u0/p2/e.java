package d.a.q0.u0.p2;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e.j;
import d.a.p0.s.q.b2;
import d.a.q0.a0.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends d.a.d.k.e.a<d.a.q0.u0.h1.g, CardViewHolder<d.a.q0.u0.p2.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public d.a.q0.u0.p2.b B;
    public d.a.q0.n1.o.l.g C;
    public int D;
    public b0<d.a.q0.u0.h1.g> E;
    public TbPageContext m;
    public BdUniqueId n;
    public d.a.q0.u0.p2.a o;
    public boolean p;
    public List<d.a.q0.u0.p2.a> q;
    public Handler r;
    public d.a.q0.u0.h1.a s;
    public c t;
    public boolean u;
    public String v;
    public boolean w;
    public d.a.q0.u0.p2.j.a x;
    public String y;
    public d.a.q0.n1.o.l.f z;

    /* loaded from: classes8.dex */
    public class a extends b0<d.a.q0.u0.h1.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f64244b;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64244b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.u0.h1.g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, gVar) == null) || view == null || gVar == null) {
                return;
            }
            String str = gVar.f63492f;
            if (str == null) {
                str = null;
            }
            b2 b2Var = new b2();
            b2Var.y3(str);
            b2Var.h4(str);
            b2Var.o3(d.a.d.e.m.b.f(gVar.f63491e, 0L));
            b2Var.k3(gVar.A);
            b2Var.g4(40);
            if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof d.a.q0.u0.p2.a)) {
                d.a.q0.u0.p2.a aVar = (d.a.q0.u0.p2.a) view.getTag();
                if (this.f64244b.o != null && this.f64244b.o != aVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                    this.f64244b.o.D0();
                }
                if (this.f64244b.o != aVar) {
                    this.f64244b.o = aVar;
                }
                if (this.f64244b.o != null) {
                    this.f64244b.o.r0(this.f64244b.w);
                }
            }
            if (view.getId() == R.id.title) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", gVar.f63491e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                if (this.f64244b.o == null || this.f64244b.o.a0()) {
                    return;
                }
                StatisticItem d2 = d.a.q0.g3.a.d(b2Var, "a023", "common_click", 1, gVar.I, false, null, null);
                if ("14".equals(this.f64244b.v)) {
                    d2.param("page_source", "newcategory");
                }
                d.a.q0.g3.c.g().c(this.f64244b.n, d2);
            } else if (view.getId() == R.id.agree_view_container) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", gVar.f63491e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view.getId() != R.id.thread_info_commont_container && view.getId() != R.id.card_root_view) {
                if (view.getId() != R.id.user_icon && view.getId() != R.id.user_name) {
                    if (view.getId() == R.id.attention) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", gVar.f63491e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view.getId() == R.id.mobile_network_play) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", gVar.f63491e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem4);
                        return;
                    } else {
                        return;
                    }
                }
                StatisticItem statisticItem5 = new StatisticItem("c12412");
                statisticItem5.param("fid", gVar.f63491e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
                StatisticItem d3 = d.a.q0.g3.a.d(b2Var, "a023", "common_click", 2, gVar.I, false, null, null);
                if ("14".equals(this.f64244b.v)) {
                    d3.param("page_source", "newcategory");
                }
                d.a.q0.g3.c.g().c(this.f64244b.n, d3);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", gVar.f63491e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
                StatisticItem d4 = d.a.q0.g3.a.d(b2Var, "a023", "common_click", 5, gVar.I, false, null, null);
                if ("14".equals(this.f64244b.v)) {
                    d4.param("page_source", "newcategory");
                }
                d.a.q0.g3.c.g().c(this.f64244b.n, d4);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f64245e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64245e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f64245e.p) {
                this.f64245e.p = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, d.a.q0.u0.h1.a aVar, c cVar, boolean z, String str, String str2, d.a.q0.n1.o.l.f fVar, BdUniqueId bdUniqueId, d.a.q0.u0.p2.b bVar, d.a.q0.n1.o.l.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), d.a.q0.u0.h1.g.K);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {tbPageContext, aVar, cVar, Boolean.valueOf(z), str, str2, fVar, bdUniqueId, bVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new ArrayList();
        this.r = new Handler();
        this.w = true;
        this.D = 1;
        this.E = new a(this);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        this.s = aVar;
        this.u = z;
        this.t = cVar;
        this.v = str;
        this.x = new d.a.q0.u0.p2.j.a();
        this.y = str2;
        this.z = fVar;
        this.B = bVar;
        this.C = gVar;
    }

    public void A0() {
        d.a.q0.u0.p2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.D0();
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.q0.u0.p2.a aVar = this.o;
            if (aVar != null) {
                return aVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.q0.u0.p2.a aVar = this.o;
            if (aVar != null) {
                return aVar.c0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o0(Configuration configuration) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) || (i2 = configuration.orientation) == this.D) {
            return;
        }
        this.D = i2;
        d.a.q0.u0.p2.a aVar = this.o;
        if (aVar != null) {
            this.p = true;
            aVar.g0(configuration);
            if (configuration.orientation == 1) {
                this.r.postDelayed(new b(this), 500L);
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.q0.u0.p2.j.a aVar = this.x;
            if (aVar != null) {
                aVar.d();
            }
            for (d.a.q0.u0.p2.a aVar2 : this.q) {
                if (aVar2 != null) {
                    aVar2.onDestroy();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: p0 */
    public CardViewHolder<d.a.q0.u0.p2.a> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            d.a.q0.u0.p2.a aVar = new d.a.q0.u0.p2.a(this.m, this.u, this.v, this.y, this.B);
            aVar.n(this.E);
            aVar.t0(this.C);
            this.q.add(aVar);
            return new CardViewHolder<>(aVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: r0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.u0.h1.g gVar, CardViewHolder<d.a.q0.u0.p2.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, cardViewHolder})) == null) {
            if (gVar == null || cardViewHolder == null) {
                return null;
            }
            if (gVar.d() != null) {
                gVar.d().keyFromHomePage = this.v;
            }
            if (!this.A) {
                if (!this.p) {
                    cardViewHolder.b().f0(gVar, i2, this.s);
                    j trigger = gVar.getTrigger();
                    if (trigger != null) {
                        trigger.a();
                    }
                    cardViewHolder.b().I = i2;
                    cardViewHolder.b().setOnVideoContainerForegroundClickListener(this.t);
                } else {
                    cardViewHolder.b().d0(gVar, i2, this.s);
                }
            }
            if (cardViewHolder.b() instanceof d.a.q0.n1.o.l.h) {
                cardViewHolder.b().setCurrentPlayCallBack(this.z);
            }
            String c2 = d.a.q0.g3.a.c(gVar.f63492f, "", "", gVar.A);
            b2 b2Var = new b2();
            b2Var.y3(gVar.f63492f);
            b2Var.h4(gVar.f63492f);
            b2Var.k3(gVar.A);
            b2Var.o3(d.a.d.e.m.b.f(gVar.f63491e, 0L));
            b2Var.g4(40);
            d.a.q0.g3.c.g().d(this.n, c2, d.a.q0.g3.a.f(b2Var, "a023", "common_exp", i2 + 1, false, null, null));
            return cardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public boolean t0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            d.a.q0.u0.p2.a aVar = this.o;
            if (aVar == null) {
                return false;
            }
            return aVar.i0(i2);
        }
        return invokeI.booleanValue;
    }

    public void u0() {
        d.a.q0.u0.p2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.j0();
    }

    public void w0() {
        d.a.q0.u0.p2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.o0();
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.A = z;
        }
    }

    public void z0() {
        d.a.q0.u0.p2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.C0();
    }
}
