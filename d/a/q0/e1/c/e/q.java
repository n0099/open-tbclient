package d.a.q0.e1.c.e;

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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.a;
import d.a.k.d;
import d.a.k.g0;
import d.a.k.l0;
import d.a.k.n0;
import d.a.k.p0;
import d.a.k.s0;
import d.a.k.v0.a;
import d.a.p0.s.q.b2;
import d.a.q0.a0.b0;
/* loaded from: classes8.dex */
public class q extends d.a.d.k.e.a<d.a.q0.a0.e0.k, ThreadCardViewHolder<d.a.q0.a0.e0.k>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.d.k.e.s p;
    public b0<d.a.q0.a0.e0.k> q;

    /* loaded from: classes8.dex */
    public class a extends b0<d.a.q0.a0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
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
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) || view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().o1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    d.a.q0.e1.c.c.b(view, kVar, 6);
                    return;
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        if (kVar != null) {
                            statisticItem.param("tid", kVar.l);
                            b2 b2Var = kVar.f54338e;
                            if (b2Var != null && b2Var.q1() != null) {
                                statisticItem.param("pid", kVar.f54338e.q1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        if (kVar != null) {
                            statisticItem2.param("tid", kVar.l);
                            b2 b2Var2 = kVar.f54338e;
                            if (b2Var2 != null && b2Var2.q1() != null) {
                                statisticItem2.param("pid", kVar.f54338e.q1().E());
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
                                b2 b2Var3 = kVar.f54338e;
                                if (b2Var3 != null && b2Var3.q1() != null) {
                                    statisticItem3.param("pid", kVar.f54338e.q1().E());
                                }
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view.getId() == R.id.forum_name_text) {
                            d.a.q0.e1.c.c.b(view, kVar, 7);
                            return;
                        } else if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem4 = new StatisticItem("c13423");
                                statisticItem4.param("obj_locate", 3);
                                if (kVar != null) {
                                    statisticItem4.param("tid", kVar.l);
                                    b2 b2Var4 = kVar.f54338e;
                                    if (b2Var4 != null && b2Var4.q1() != null) {
                                        statisticItem4.param("pid", kVar.f54338e.q1().E());
                                    }
                                }
                                TiebaStatic.log(statisticItem4);
                                return;
                            }
                            d.a.q0.e1.c.c.b(view, kVar, 6);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        if (kVar != null) {
                            statisticItem5.param("tid", kVar.l);
                            b2 b2Var5 = kVar.f54338e;
                            if (b2Var5 != null && b2Var5.q1() != null) {
                                statisticItem5.param("pid", kVar.f54338e.q1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem5);
                        return;
                    }
                } else {
                    d.a.q0.e1.c.c.b(view, kVar, 1);
                    return;
                }
            }
            d.a.q0.e1.c.c.b(view, kVar, 2);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.k.d.b
        public void a(d.a.p0.s.q.a aVar, View view) {
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

    /* loaded from: classes8.dex */
    public class c implements a.InterfaceC0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f55718a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f55719b;

        public c(q qVar, g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55719b = qVar;
            this.f55718a = g0Var;
        }

        @Override // d.a.k.a.InterfaceC0618a
        public void a(d.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().u1 == null) {
                return;
            }
            d.a.p0.b1.t.e(1, this.f55719b.f42341e, aVar.getThreadData(), 0, null, "from_nani_video", "concern_page", null, "concern_tab", "");
            d.a.q0.e1.c.c.b(this.f55718a.g(), aVar, 6);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.InterfaceC0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f55720a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f55721b;

        public d(q qVar, s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55721b = qVar;
            this.f55720a = s0Var;
        }

        @Override // d.a.k.a.InterfaceC0618a
        public void a(d.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().u1 == null) {
                return;
            }
            d.a.p0.b1.t.e(1, this.f55721b.f42341e, aVar.getThreadData(), 0, null, "from_nani_video", "concern_page", null, "concern_tab", "");
            d.a.q0.e1.c.c.b(this.f55720a.g(), aVar, 6);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.k.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f55722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f55723b;

        public e(q qVar, s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55723b = qVar;
            this.f55722a = s0Var;
        }

        @Override // d.a.k.w0.a
        public void a(d.a.p0.s.q.a aVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().u1 == null) {
                return;
            }
            if (aVar.getThreadData().u1.r != null) {
                z = aVar.getThreadData().u1.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            d.a.p0.b1.t.d(1, z, this.f55723b.f42341e, aVar.getThreadData(), 0, null, "from_nani_video", "concern_page", null, "concern_tab", "");
            d.a.q0.e1.c.c.b(this.f55722a.g(), aVar, 6);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f55724e;

        public f(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55724e = qVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.q0.a0.e0.k kVar = (d.a.q0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f55724e.q != null) {
                    this.f55724e.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) kVar, view.getContext(), 1, false, d.a.k.e.a((d.a.d.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f55726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55727c;

        public g(q qVar, ViewGroup viewGroup, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, viewGroup, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55725a = viewGroup;
            this.f55726b = view;
            this.f55727c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.k.e.a((d.a.d.k.e.s) this.f55725a, this.f55726b, this.f55727c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            d.a.k.d dVar = new d.a.k.d(this.n.getPageActivity());
            dVar.t(this.m);
            dVar.b(128);
            dVar.c(1024);
            dVar.s(new b(this));
            bVar.o(dVar);
            g0 g0Var = new g0(this.n);
            g0Var.n(Boolean.FALSE);
            g0Var.v(ImageViewerConfig.FROM_CONCERN);
            bVar.l().g(d.a.d.e.p.l.g(this.f42341e, R.dimen.tbds28));
            bVar.n(g0Var);
            g0 g0Var2 = new g0(this.n);
            g0Var2.n(Boolean.TRUE);
            g0Var2.v(ImageViewerConfig.FROM_CONCERN);
            g0Var2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            g0Var2.w(new c(this, g0Var2));
            bVar.h(g0Var2);
            s0 s0Var = new s0(this.n.getPageActivity());
            s0Var.n(Boolean.TRUE);
            s0Var.v(ImageViewerConfig.FROM_CONCERN);
            s0Var.w(new d(this, s0Var));
            s0Var.x(new e(this, s0Var));
            bVar.h(s0Var);
            bVar.h(new p0(this.n.getPageActivity()));
            bVar.h(new d.a.k.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.p0.s.q.f fVar = new d.a.p0.s.q.f();
            fVar.f53311b = 9;
            fVar.f53317h = 9;
            n0Var.v(fVar);
            n0Var.w(9);
            n0Var.A(4);
            n0Var.x(1);
            n0Var.b(32);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.m);
            a0(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f54338e == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b().e() instanceof n0) {
                ((n0) threadCardViewHolder.b().e()).z(new g(this, viewGroup, view, i2));
            }
            d.a.q0.a0.t.b().a(kVar.d("c12351"));
            threadCardViewHolder.b().setPage(this.o);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.k();
            threadCardViewHolder.f(kVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.q);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(d.a.d.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
