package d.a.p0.e1.c.e;

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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
import d.a.j.a;
import d.a.j.d;
import d.a.j.g0;
import d.a.j.l0;
import d.a.j.n0;
import d.a.j.p0;
import d.a.j.s0;
import d.a.j.v0.a;
import d.a.o0.r.q.b2;
import d.a.p0.a0.b0;
/* loaded from: classes7.dex */
public class q extends d.a.c.k.e.a<d.a.p0.a0.e0.k, ThreadCardViewHolder<d.a.p0.a0.e0.k>> implements d.a.p0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.k.e.s p;
    public b0<d.a.p0.a0.e0.k> q;

    /* loaded from: classes7.dex */
    public class a extends b0<d.a.p0.a0.e0.k> {
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
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.p0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) || view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().n1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    d.a.p0.e1.c.c.b(view, kVar, 6);
                    return;
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        if (kVar != null) {
                            statisticItem.param("tid", kVar.l);
                            b2 b2Var = kVar.f53795e;
                            if (b2Var != null && b2Var.p1() != null) {
                                statisticItem.param("pid", kVar.f53795e.p1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        if (kVar != null) {
                            statisticItem2.param("tid", kVar.l);
                            b2 b2Var2 = kVar.f53795e;
                            if (b2Var2 != null && b2Var2.p1() != null) {
                                statisticItem2.param("pid", kVar.f53795e.p1().E());
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
                                b2 b2Var3 = kVar.f53795e;
                                if (b2Var3 != null && b2Var3.p1() != null) {
                                    statisticItem3.param("pid", kVar.f53795e.p1().E());
                                }
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view.getId() == R.id.forum_name_text) {
                            d.a.p0.e1.c.c.b(view, kVar, 7);
                            return;
                        } else if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem4 = new StatisticItem("c13423");
                                statisticItem4.param("obj_locate", 3);
                                if (kVar != null) {
                                    statisticItem4.param("tid", kVar.l);
                                    b2 b2Var4 = kVar.f53795e;
                                    if (b2Var4 != null && b2Var4.p1() != null) {
                                        statisticItem4.param("pid", kVar.f53795e.p1().E());
                                    }
                                }
                                TiebaStatic.log(statisticItem4);
                                return;
                            }
                            d.a.p0.e1.c.c.b(view, kVar, 6);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        if (kVar != null) {
                            statisticItem5.param("tid", kVar.l);
                            b2 b2Var5 = kVar.f53795e;
                            if (b2Var5 != null && b2Var5.p1() != null) {
                                statisticItem5.param("pid", kVar.f53795e.p1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem5);
                        return;
                    }
                } else {
                    d.a.p0.e1.c.c.b(view, kVar, 1);
                    return;
                }
            }
            d.a.p0.e1.c.c.b(view, kVar, 2);
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // d.a.j.d.b
        public void a(d.a.o0.r.q.a aVar, View view) {
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

    /* loaded from: classes7.dex */
    public class c implements a.InterfaceC0609a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f55174a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f55175b;

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
            this.f55175b = qVar;
            this.f55174a = g0Var;
        }

        @Override // d.a.j.a.InterfaceC0609a
        public void a(d.a.o0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().u1 == null) {
                return;
            }
            d.a.o0.z0.t.e(1, this.f55175b.f41837e, aVar.getThreadData(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.p0.e1.c.c.b(this.f55174a.g(), aVar, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.InterfaceC0609a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f55176a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f55177b;

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
            this.f55177b = qVar;
            this.f55176a = s0Var;
        }

        @Override // d.a.j.a.InterfaceC0609a
        public void a(d.a.o0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().u1 == null) {
                return;
            }
            d.a.o0.z0.t.e(1, this.f55177b.f41837e, aVar.getThreadData(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.p0.e1.c.c.b(this.f55176a.g(), aVar, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.j.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f55178a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f55179b;

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
            this.f55179b = qVar;
            this.f55178a = s0Var;
        }

        @Override // d.a.j.w0.a
        public void a(d.a.o0.r.q.a aVar) {
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
            d.a.o0.z0.t.d(1, z, this.f55179b.f41837e, aVar.getThreadData(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.p0.e1.c.c.b(this.f55178a.g(), aVar, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f55180e;

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
            this.f55180e = qVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.p0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.p0.a0.e0.k kVar = (d.a.p0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f55180e.q != null) {
                    this.f55180e.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) kVar, view.getContext(), 1, false, d.a.j.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0611a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f55182b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55183c;

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
            this.f55181a = viewGroup;
            this.f55182b = view;
            this.f55183c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.j.e.a((d.a.c.k.e.s) this.f55181a, this.f55182b, this.f55183c));
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

    @Override // d.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
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
            g0 g0Var = new g0(this.n);
            g0Var.n(Boolean.FALSE);
            g0Var.v(ImageViewerConfig.FROM_CONCERN);
            bVar.l().g(d.a.c.e.p.l.g(this.f41837e, R.dimen.tbds28));
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
            bVar.h(new d.a.j.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.o0.r.q.f fVar = new d.a.o0.r.q.f();
            fVar.f52647b = 9;
            fVar.f52653h = 9;
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
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.a0.e0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f53795e == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b().e() instanceof n0) {
                ((n0) threadCardViewHolder.b().e()).z(new g(this, viewGroup, view, i2));
            }
            d.a.p0.a0.t.b().a(kVar.d("c12351"));
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

    public void l0(d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
