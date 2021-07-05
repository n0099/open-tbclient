package d.a.s0.b2.d.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.s;
import d.a.j.e0;
import d.a.j.l0;
import d.a.r0.r.q.o1;
import d.a.r0.r.q.p1;
/* loaded from: classes9.dex */
public class m extends d.a.s0.b2.d.c.a<p1, ThreadCardViewHolder<p1>> implements d.a.s0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public s p;
    public String q;
    public String r;
    public View.OnClickListener s;
    public PullLeftRefreshLayout.f t;
    public d.a.r0.m.f u;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f57835e;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57835e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57835e.o.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.f57835e.o.getPageActivity(), this.f57835e.r)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f57836a;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57836a = mVar;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57836a.o.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.f57836a.o.getPageActivity(), this.f57836a.r)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.r0.m.f<o1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f57837e;

        public c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57837e = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.f
        /* renamed from: b */
        public void c(View view, o1 o1Var, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, o1Var, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.f
        /* renamed from: d */
        public void a(View view, o1 o1Var, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, o1Var, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (o1Var == null) {
                    this.f57837e.o.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.f57837e.o.getPageActivity(), this.f57837e.r)));
                    return;
                }
                String j2 = o1Var.j();
                if (d.a.c.e.p.k.isForumName(j2)) {
                    this.f57837e.o.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57837e.o.getPageActivity()).createNormalCfg(j2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    d.a.s0.b2.c.a("c13739", o1Var, i2 + 1);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.s = new a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.o = tbPageContext;
    }

    @Override // d.a.s0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.q = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            e0 e0Var = new e0(this.o, this.n);
            e0Var.u(false);
            e0Var.p(false);
            e0Var.t(false);
            e0Var.s(this.t);
            e0Var.q(this.s);
            e0Var.r(this.u);
            bVar.n(e0Var);
            bVar.l().c(0);
            bVar.l().f(0);
            bVar.l().e(0);
            bVar.l().g(0);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p));
            threadCardViewHolder.k(this.n);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, p1 p1Var, ThreadCardViewHolder<p1> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, p1Var, threadCardViewHolder})) == null) {
            if (p1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b() instanceof d.a.s0.o.e) {
                threadCardViewHolder.b().setPage(this.q);
            }
            threadCardViewHolder.f(p1Var);
            threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
