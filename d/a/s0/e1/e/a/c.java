package d.a.s0.e1.e.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.j.c0;
import d.a.j.l0;
import d.a.j.t0;
import d.a.j.v0.a;
import d.a.s0.a0.b0;
import d.a.s0.a0.e0.l;
import d.a.s0.n2.o;
/* loaded from: classes9.dex */
public class c extends d.a.c.k.e.a<l, AutoVideoCardViewHolder<l>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public t0 p;
    public int q;
    public b0<l> r;

    /* loaded from: classes9.dex */
    public class a extends b0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f58517b;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58517b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                this.f58517b.i0(view, lVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f58518e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58518e = cVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (this.f58518e.r != null) {
                    this.f58518e.r.a(threadCardViewHolder.a(), lVar);
                }
                d.a.s0.e1.e.e.a.b(lVar, view.getContext(), 18, false, d.a.j.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0645a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.r = new a(this);
        this.m = tbPageContext;
    }

    public final o h0(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                o oVar = new o();
                oVar.f64043a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP;
                oVar.f64045c = lVar.l;
                if (lVar.getThreadData() != null) {
                    oVar.f64046d = String.valueOf(lVar.getThreadData().Q());
                    if (lVar.getThreadData().l1() != null) {
                        oVar.m = lVar.getThreadData().l1().video_md5;
                        oVar.p = String.valueOf(lVar.getThreadData().l1().is_vertical);
                    }
                }
                oVar.k = lVar.e();
                oVar.f64048f = lVar.p();
                oVar.l = lVar.c();
                oVar.f64050h = lVar.C();
                oVar.f64047e = TbadkCoreApplication.getCurrentAccount();
                oVar.q = String.valueOf(lVar.o());
                oVar.r = String.valueOf(this.q);
                return oVar;
            }
            return null;
        }
        return (o) invokeL.objValue;
    }

    public final void i0(View view, l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.p) == null || t0Var.p() == null || this.p.p().E() == null) {
            return;
        }
        if (view.getId() == this.p.p().E().getId()) {
            d.a.s0.e1.e.e.a.d(lVar, this.q);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.s0.e1.e.e.a.d(lVar, this.q);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public AutoVideoCardViewHolder<l> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.m.getPageActivity(), false);
            c0 c0Var = new c0(this.m.getPageActivity());
            this.p = c0Var;
            c0Var.x(this.n);
            this.p.u(ImageViewerConfig.FROM_GAME_VIDEO);
            this.p.y("2001");
            bVar.n(this.p);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.n);
            k.p(this.r);
            k.r(18);
            a0(new b(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.I(lVar.position + 1);
            autoVideoCardViewHolder.b().q(i2);
            d.a.s0.e1.e.e.a.c(lVar, this.q);
            autoVideoCardViewHolder.v(h0(lVar));
            autoVideoCardViewHolder.f(lVar);
            autoVideoCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.r);
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.q = i2;
        }
    }

    public void m0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.n = bdUniqueId;
        }
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t0Var = this.p) == null) {
            return;
        }
        t0Var.s();
    }

    public void p0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
