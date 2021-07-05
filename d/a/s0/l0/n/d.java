package d.a.s0.l0.n;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.r0.r.q.o1;
import d.a.r0.r.q.p1;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f63163a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f63164b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f63165c;

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f63166d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.m.f f63167e;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f63168e;

        public a(d dVar) {
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
            this.f63168e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.s0.l0.b.a(this.f63168e.f63163a, null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f63169a;

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
            this.f63169a = dVar;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.s0.l0.b.a(this.f63169a.f63163a, null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.r0.m.f<o1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f63170e;

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
            this.f63170e = dVar;
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
                    d.a.s0.l0.b.a(this.f63170e.f63163a, null);
                    return;
                }
                String j2 = o1Var.j();
                if (k.isForumName(j2)) {
                    this.f63170e.f63163a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63170e.f63163a.getPageActivity()).createNormalCfg(j2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                }
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
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
        this.f63165c = new a(this);
        this.f63166d = new b(this);
        this.f63167e = new c(this);
        this.f63163a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f63164b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f63164b.setSquareEntranceAtStart(true);
        this.f63164b.setTabName(null);
        this.f63164b.setFrom(0);
        this.f63164b.setOnClickRightArrowListener(this.f63165c);
        this.f63164b.setOnRullOkCallbackr(this.f63166d);
        this.f63164b.setOnItemCoverListener(this.f63167e);
    }

    public void b(p1 p1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p1Var) == null) {
            this.f63164b.a(p1Var);
        }
    }

    public RecommendForumLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63164b : (RecommendForumLayout) invokeV.objValue;
    }
}
