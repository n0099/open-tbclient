package d.a.q0.e1.f.a.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import d.a.d.k.e.w;
import d.a.k.l0;
import d.a.k.n0;
import d.a.k.v0.a;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.q0.a0.b0;
/* loaded from: classes8.dex */
public class k extends d.a.q0.e1.f.a.d.a<a2, ThreadCardViewHolder<b2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b0<a2> q;

    /* loaded from: classes8.dex */
    public class a extends b0<a2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f55925b;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55925b = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, a2Var) == null) || a2Var == null) {
                return;
            }
            this.f55925b.e0(view, a2Var.w);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f55926e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55926e = kVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = (a2) nVar;
                b2 b2Var = a2Var.w;
                b2Var.objType = 1;
                if (this.f55926e.q != null) {
                    this.f55926e.q.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) b2Var, view.getContext(), 0, false, d.a.k.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55927a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f55928b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55929c;

        public c(k kVar, ViewGroup viewGroup, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, viewGroup, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55927a = viewGroup;
            this.f55928b = view;
            this.f55929c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.k.e.a((s) this.f55927a, this.f55928b, this.f55929c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext, b2.g3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.p0.s.q.f fVar = new d.a.p0.s.q.f();
            fVar.f53311b = 1;
            fVar.f53317h = 1;
            n0Var.v(fVar);
            n0Var.w(1);
            n0Var.B("personalize_page");
            n0Var.A(1);
            n0Var.x(2);
            n0Var.b(32);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.o);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.f42345i);
            a0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.e1.f.a.d.a, d.a.d.k.e.a
    /* renamed from: m0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, threadCardViewHolder})) == null) {
            if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (b2Var = a2Var.w) == null) {
                return null;
            }
            b2Var.P1 = F(i2) + 1;
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b().e() instanceof n0) {
                ((n0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i2));
            }
            threadCardViewHolder.f(a2Var);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.q);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
