package d.a.q0.e1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.l0;
import d.a.k.v0.a;
/* loaded from: classes8.dex */
public class g extends d.a.d.k.e.a<d.a.q0.a0.e0.k, ThreadCardViewHolder<d.a.q0.a0.e0.k>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.q0.e1.h.k.e o;
    public String p;
    public boolean q;
    public d.a.d.k.e.s r;
    public d.a.q0.a0.b0<d.a.q0.a0.e0.k> s;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a0.b0<d.a.q0.a0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f56111b;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56111b = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                d.a.q0.a0.t.b().d(true);
                d.a.q0.o.d.c().h("page_recommend", "show_");
                if (view == null || this.f56111b.o == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().o1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !d.a.q0.e1.h.f.b(d.a.d.e.m.b.f(kVar.getThreadData().o1(), 0L))) {
                    d.a.q0.e1.h.f.a(d.a.d.e.m.b.f(kVar.getThreadData().o1(), 0L));
                    this.f56111b.o.e(d.a.d.e.m.b.f(kVar.getThreadData().o1(), 0L), kVar.C(), kVar.p(), kVar.o(), kVar.c(), d.a.d.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.getThreadData().J());
                }
                this.f56111b.l0(view, kVar);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f56112e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56112e = gVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.q0.a0.e0.k kVar = (d.a.q0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f56112e.s != null) {
                    this.f56112e.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = true;
        this.s = new a(this);
        this.n = tbPageContext;
        i0();
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.a0.e0.k.W = "c10705";
            d.a.q0.a0.e0.k.X = "c10730";
            d.a.q0.a0.e0.k.Y = "c10731";
            d.a.q0.a0.e0.k.Z = "c10704";
            d.a.q0.a0.e0.k.a0 = "c10755";
            d.a.q0.a0.e0.k.b0 = "c10710";
            d.a.q0.a0.e0.k.c0 = "c10736";
            d.a.q0.a0.e0.k.i0 = "c10737";
            d.a.q0.a0.e0.k.j0 = "c10711";
            d.a.q0.a0.e0.k.k0 = "c10758";
            d.a.q0.a0.e0.k.l0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            d.a.k.z zVar = new d.a.k.z(this.n.getPageActivity());
            zVar.r("index");
            zVar.s(this.q);
            bVar.n(zVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.r);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.m);
            a0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.k kVar, ThreadCardViewHolder<d.a.q0.a0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f54338e == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            kVar.f54338e.P1 = kVar.o();
            threadCardViewHolder.b().q(i2);
            threadCardViewHolder.b().setPage(this.p);
            threadCardViewHolder.f(kVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.s);
            d.a.q0.a0.t.b().a(kVar.z());
            d.a.q0.o.d.c().a(kVar.z());
            d.a.q0.e1.h.m.a.f(kVar.f54338e, this.m, kVar.o());
            d.a.q0.e1.h.m.a.e(kVar.f54338e, kVar.o());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(View view, d.a.q0.a0.e0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, kVar) == null) {
            int id = view.getId();
            int i2 = 3;
            if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(kVar.S());
                    d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.S());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(kVar.S());
                    d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.S());
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(kVar.h());
                    d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.h());
                    i2 = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        d.a.q0.e1.h.m.a.b(kVar.f54338e, kVar.o(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(kVar.P());
                            d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.P());
                            d.a.q0.e1.h.m.a.b(kVar.f54338e, kVar.o(), 2);
                        } else {
                            i2 = 0;
                        }
                    } else {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    }
                    i2 = 5;
                }
                i2 = 2;
            } else {
                TiebaStatic.log(kVar.y());
                d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.y());
                d.a.q0.e1.h.m.a.b(kVar.f54338e, kVar.o(), 1);
                i2 = 1;
            }
            if (i2 != 0) {
                d.a.q0.e1.h.m.a.c(kVar.f54338e, this.m, kVar.o(), i2);
            }
        }
    }

    public void m0(d.a.q0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public void n0(d.a.d.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            this.r = sVar;
        }
    }
}
