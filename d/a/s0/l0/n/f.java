package d.a.s0.l0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.q.o1;
import d.a.s0.h3.f0;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f63177a;

    /* renamed from: b  reason: collision with root package name */
    public View f63178b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f63179c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63180d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63181e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63182f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63183g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f63184h;

    /* renamed from: i  reason: collision with root package name */
    public String f63185i;
    public String j;
    public o1 k;
    public LikeModel l;
    public f0 m;
    public boolean n;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63186e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63186e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f63186e.j();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63187e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63187e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c13644");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.f63187e.k.h());
                statisticItem.param("obj_locate", 1);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.f63187e.k.q() ? 2 : 1);
                TiebaStatic.log(statisticItem);
                if (this.f63187e.k.q()) {
                    this.f63187e.i();
                } else {
                    this.f63187e.h();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f63188a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63188a = fVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f63188a.l.getErrorCode() == 22) {
                    l.M(this.f63188a.f63177a.getPageActivity(), this.f63188a.f63177a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f63188a.l.getErrorCode() != 0) {
                        l.M(this.f63188a.f63177a.getPageActivity(), this.f63188a.l.getErrorString());
                        return;
                    }
                    this.f63188a.n(true);
                    l.M(this.f63188a.f63177a.getPageActivity(), this.f63188a.f63177a.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f63189a;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63189a = fVar;
        }

        @Override // d.a.s0.h3.f0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // d.a.s0.h3.f0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f63189a.n(false);
                l.M(this.f63189a.f63177a.getPageActivity(), this.f63189a.f63177a.getString(R.string.un_attention_success));
            }
        }
    }

    public f(TbPageContext<?> tbPageContext) {
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
        this.f63177a = tbPageContext;
        this.f63185i = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.j = TbadkCoreApplication.getInst().getString(R.string.thread_str);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.f63178b = inflate;
        this.f63179c = (BarImageView) inflate.findViewById(R.id.bar_image);
        this.f63180d = (TextView) this.f63178b.findViewById(R.id.bar_name);
        this.f63181e = (TextView) this.f63178b.findViewById(R.id.desc);
        this.f63182f = (TextView) this.f63178b.findViewById(R.id.follow_text);
        this.f63183g = (TextView) this.f63178b.findViewById(R.id.tiezi_text);
        this.f63184h = (TBSpecificationBtn) this.f63178b.findViewById(R.id.forum_like_button);
        this.f63178b.setOnClickListener(new a(this));
        this.f63184h.setOnClickListener(new b(this));
    }

    public void g(o1 o1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, o1Var) == null) || o1Var == null) {
            return;
        }
        this.k = o1Var;
        this.f63179c.setShowOval(true);
        this.f63179c.setShowOuterBorder(false);
        this.f63179c.setShowInnerBorder(true);
        this.f63179c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f63179c.setStrokeColorResId(R.color.CAM_X0401);
        this.f63179c.M(o1Var.e(), 10, false);
        String j = o1Var.j();
        if (k.isEmpty(j)) {
            j = "";
        }
        this.f63180d.setText(j);
        this.f63182f.setText(this.f63185i + " " + StringHelper.numFormatOverWanWithoutDecimals(o1Var.o()));
        this.f63183g.setText(this.j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) o1Var.p()));
        String recomReason = o1Var.getRecomReason();
        if (k.isEmpty(recomReason)) {
            if (this.f63181e.getVisibility() != 8) {
                this.f63181e.setVisibility(8);
                if (this.f63180d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f63180d.getLayoutParams()).topMargin = l.g(this.f63177a.getPageActivity(), R.dimen.tbds47);
                    this.f63180d.requestLayout();
                }
            }
        } else {
            if (this.f63181e.getVisibility() != 0) {
                this.f63181e.setVisibility(0);
                if (this.f63180d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f63180d.getLayoutParams()).topMargin = l.g(this.f63177a.getPageActivity(), R.dimen.tbds24);
                    this.f63180d.requestLayout();
                }
            }
            this.f63181e.setText(recomReason);
        }
        n(this.k.q());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f63177a.getPageActivity(), this.f63177a.getString(R.string.neterror));
                return;
            }
            o1 o1Var = this.k;
            if (o1Var == null || StringUtils.isNull(o1Var.j()) || this.k.h() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.f63177a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.l == null) {
                this.l = new LikeModel(this.f63177a);
            }
            this.l.setLoadDataCallBack(new c(this));
            if (k.isForumName(this.k.j())) {
                this.l.I();
                this.l.L(this.k.j(), String.valueOf(this.k.h()));
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!l.D()) {
                UtilHelper.showToast(this.f63177a.getPageActivity(), this.f63177a.getString(R.string.neterror));
                return;
            }
            o1 o1Var = this.k;
            if (o1Var == null || StringUtils.isNull(o1Var.j()) || this.k.h() <= 0) {
                return;
            }
            if (!ViewHelper.checkUpIsLogin(this.f63177a.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.m == null) {
                this.m = new f0();
            }
            this.m.b(new d(this));
            this.m.c(this.k.j(), this.k.h());
        }
    }

    public final void j() {
        o1 o1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (o1Var = this.k) == null) {
            return;
        }
        String j = o1Var.j();
        if (k.isForumName(j)) {
            this.f63177a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63177a.getPageActivity()).createNormalCfg(j, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            StatisticItem statisticItem = new StatisticItem("c13643");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.k.h());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", this.n ? 4 : 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63178b : (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f63180d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f63182f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f63183g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f63181e, R.color.CAM_X0109);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
                bVar.q(R.color.CAM_X0302);
                this.f63184h.setConfig(bVar);
                this.f63184h.setText(this.f63185i);
            } else {
                d.a.r0.r.f0.m.b bVar2 = new d.a.r0.r.f0.m.b();
                bVar2.r(R.color.CAM_X0109);
                this.f63184h.setConfig(bVar2);
                this.f63184h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            }
            this.k.w(z);
        }
    }
}
