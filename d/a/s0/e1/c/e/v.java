package d.a.s0.e1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.d;
import d.a.j.l0;
import d.a.j.n0;
import d.a.j.p0;
import d.a.j.q0;
import d.a.j.v0.a;
import d.a.r0.r.q.b2;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class v extends d.a.c.k.e.a<d.a.s0.a0.e0.k, ThreadCardViewHolder<d.a.s0.a0.e0.k>> implements d.a.s0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public b0<d.a.s0.a0.e0.k> q;

    /* loaded from: classes9.dex */
    public class a extends b0<d.a.s0.a0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.s0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) || view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().n1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    d.a.s0.e1.c.c.b(view, kVar, 6);
                    return;
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        if (kVar != null) {
                            statisticItem.param("tid", kVar.l);
                            b2 b2Var = kVar.f57050e;
                            if (b2Var != null && b2Var.p1() != null) {
                                statisticItem.param("pid", kVar.f57050e.p1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        if (kVar != null) {
                            statisticItem2.param("tid", kVar.l);
                            b2 b2Var2 = kVar.f57050e;
                            if (b2Var2 != null && b2Var2.p1() != null) {
                                statisticItem2.param("pid", kVar.f57050e.p1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem2);
                        return;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            if (kVar != null) {
                                statisticItem3.param("tid", kVar.l);
                                b2 b2Var3 = kVar.f57050e;
                                if (b2Var3 != null && b2Var3.p1() != null) {
                                    statisticItem3.param("pid", kVar.f57050e.p1().E());
                                }
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view.getId() == R.id.forum_name_text) {
                            d.a.s0.e1.c.c.b(view, kVar, 7);
                            return;
                        } else if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem4 = new StatisticItem("c13423");
                                statisticItem4.param("obj_locate", 3);
                                if (kVar != null) {
                                    statisticItem4.param("tid", kVar.l);
                                    b2 b2Var4 = kVar.f57050e;
                                    if (b2Var4 != null && b2Var4.p1() != null) {
                                        statisticItem4.param("pid", kVar.f57050e.p1().E());
                                    }
                                }
                                TiebaStatic.log(statisticItem4);
                                return;
                            }
                            d.a.s0.e1.c.c.b(view, kVar, 6);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        if (kVar != null) {
                            statisticItem5.param("tid", kVar.l);
                            b2 b2Var5 = kVar.f57050e;
                            if (b2Var5 != null && b2Var5.p1() != null) {
                                statisticItem5.param("pid", kVar.f57050e.p1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem5);
                        return;
                    }
                } else {
                    d.a.s0.e1.c.c.b(view, kVar, 1);
                    return;
                }
            }
            d.a.s0.e1.c.c.b(view, kVar, 2);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.j.d.b
        public void a(d.a.r0.r.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f58447e;

        public c(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58447e = vVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.s0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.s0.a0.e0.k kVar = (d.a.s0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f58447e.q != null) {
                    this.f58447e.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.r0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C0645a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.p = true;
        this.q = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.s0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<d.a.s0.a0.e0.k> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            d.a.j.d dVar = new d.a.j.d(this.n.getPageActivity());
            dVar.t(this.m);
            dVar.b(128);
            dVar.c(1024);
            dVar.s(new b(this));
            bVar.o(dVar);
            q0 q0Var = new q0(this.n.getPageActivity());
            bVar.n(q0Var);
            q0Var.u(2);
            bVar.h(new p0(this.n.getPageActivity()));
            bVar.h(new d.a.j.k(this.n.getPageActivity()));
            d.a.j.n nVar = new d.a.j.n(this.n.getPageActivity());
            nVar.x(this.p);
            nVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.h(nVar);
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.r0.r.q.f fVar = new d.a.r0.r.q.f();
            fVar.f55932b = 9;
            fVar.f55938h = 9;
            n0Var.v(fVar);
            n0Var.w(9);
            n0Var.A(4);
            n0Var.x(1);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            i2.r(1);
            ThreadCardViewHolder<d.a.s0.a0.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.k(this.m);
            a0(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.a0.e0.k kVar, ThreadCardViewHolder<d.a.s0.a0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f57050e == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            d.a.s0.a0.t.b().a(kVar.d("c12351"));
            threadCardViewHolder.b().setPage(this.o);
            threadCardViewHolder.t(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.l();
            threadCardViewHolder.f(kVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.q);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
