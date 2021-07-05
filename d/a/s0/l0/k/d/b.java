package d.a.s0.l0.k.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class b extends d.a.s0.a0.b<d.a.s0.l0.k.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public RecommendForumItemView n;
    public RecommendForumItemView o;
    public int p;
    public LikeModel q;

    /* loaded from: classes9.dex */
    public class a implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62971a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62971a = bVar;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(d.a.s0.l0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                b bVar2 = this.f62971a;
                bVar2.z(bVar, bVar2.n);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(d.a.s0.l0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f62971a.y(bVar);
            }
        }
    }

    /* renamed from: d.a.s0.l0.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1569b implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62972a;

        public C1569b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62972a = bVar;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(d.a.s0.l0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                b bVar2 = this.f62972a;
                bVar2.z(bVar, bVar2.o);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(d.a.s0.l0.k.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f62972a.y(bVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendForumItemView f62973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f62974b;

        public c(b bVar, RecommendForumItemView recommendForumItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, recommendForumItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62974b = bVar;
            this.f62973a = recommendForumItemView;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f62974b.q.getErrorCode() == 22) {
                    l.M(this.f62974b.m.getPageActivity(), this.f62974b.m.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f62974b.q.getErrorCode() != 0) {
                        l.M(this.f62974b.m.getPageActivity(), this.f62974b.q.getErrorString());
                        return;
                    }
                    if (this.f62973a == this.f62974b.n) {
                        this.f62974b.n.e(true);
                    } else {
                        this.f62974b.o.e(true);
                    }
                    l.M(this.f62974b.m.getPageActivity(), this.f62974b.m.getString(R.string.attention_success));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.m = tbPageContext;
        B();
        this.n.setForumItemClickListener(new a(this));
        this.o.setForumItemClickListener(new C1569b(this));
    }

    public final void A(d.a.s0.l0.k.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) || bVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13375");
        statisticItem.param("obj_type", String.valueOf(bVar.f62955h));
        statisticItem.param("fid", bVar.f62949b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", str);
        TiebaStatic.log(statisticItem);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View l = l();
            this.n = (RecommendForumItemView) l.findViewById(R.id.reommend_forum_one);
            this.o = (RecommendForumItemView) l.findViewById(R.id.reommend_forum_two);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: F */
    public void m(d.a.s0.l0.k.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        n(this.m, this.p);
        if (cVar.f62957e != null) {
            this.n.setVisibility(0);
            this.n.c(cVar.f62957e);
        } else {
            this.n.setVisibility(4);
        }
        if (cVar.f62958f != null) {
            this.o.setVisibility(0);
            this.o.c(cVar.f62958f);
            return;
        }
        this.o.setVisibility(4);
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.recommend_forum_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            this.p = i2;
            this.n.d();
            this.o.d();
            SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
        }
    }

    public final void y(d.a.s0.l0.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.m.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.m.getPageActivity()).createNormalCfg(bVar.f62950c, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
            A(bVar, "2");
        }
    }

    public final void z(d.a.s0.l0.k.c.b bVar, RecommendForumItemView recommendForumItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, recommendForumItemView) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f57032f.getPageActivity(), this.f57032f.getString(R.string.neterror));
            } else if (bVar == null || StringUtils.isNull(bVar.f62950c) || bVar.f62949b <= 0) {
            } else {
                if (!ViewHelper.checkUpIsLogin(b())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.q == null) {
                    this.q = new LikeModel(this.m);
                }
                this.q.setLoadDataCallBack(new c(this, recommendForumItemView));
                if (k.isForumName(bVar.f62950c)) {
                    this.q.L(bVar.f62950c, String.valueOf(bVar.f62949b));
                }
                A(bVar, "1");
            }
        }
    }
}
