package d.a.p0.e3.k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.p0.a0.b0;
import d.a.p0.h3.f0;
/* loaded from: classes8.dex */
public class c extends d.a.p0.a0.b<d.a.p0.e3.f.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TBSpecificationBtn s;
    public String t;
    public String u;
    public d.a.p0.e3.f.b v;
    public LikeModel w;
    public f0 x;
    public boolean y;

    /* loaded from: classes8.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56100a;

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
            this.f56100a = cVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f56100a.y = false;
                if (this.f56100a.w.getErrorCode() == 22) {
                    l.M(this.f56100a.f53777f.getPageActivity(), this.f56100a.f53777f.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f56100a.w.getErrorCode() != 0) {
                        l.M(this.f56100a.f53777f.getPageActivity(), this.f56100a.w.getErrorString());
                    } else {
                        this.f56100a.x(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56101a;

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
            this.f56101a = cVar;
        }

        @Override // d.a.p0.h3.f0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.f56101a.y = false;
            }
        }

        @Override // d.a.p0.h3.f0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f56101a.y = false;
                this.f56101a.x(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext) {
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
        this.y = false;
        this.t = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.u = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View k = k();
        this.m = k;
        this.n = (BarImageView) k.findViewById(R.id.bar_image);
        this.o = (TextView) k.findViewById(R.id.bar_name);
        this.p = (TextView) k.findViewById(R.id.desc);
        this.q = (TextView) k.findViewById(R.id.member_text);
        this.r = (TextView) k.findViewById(R.id.post_text);
        this.s = (TBSpecificationBtn) k.findViewById(R.id.forum_like_button);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_forum_item_layout : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
            this.s.k();
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.v == null) {
            return;
        }
        if (this.m == view) {
            v();
            b0<T> b0Var = this.f53780i;
            if (b0Var != 0) {
                b0Var.a(view, this.v);
            }
        } else if (this.s == view) {
            if (this.f53777f.getPageActivity() instanceof ForumSquareActivity) {
                String h2 = ((ForumSquareActivity) this.f53777f.getPageActivity()).getDelegate().h();
                if (!"推荐".equals(h2)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, h2);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.v.f55940e);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.v.o() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.v.o()) {
                u();
            } else {
                t();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.y) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.f53777f.getPageActivity(), this.f53777f.getString(R.string.neterror));
            return;
        }
        d.a.p0.e3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.e()) || this.v.d() <= 0 || !ViewHelper.checkUpIsLogin(this.f53777f.getPageActivity())) {
            return;
        }
        if (this.w == null) {
            LikeModel likeModel = new LikeModel(this.f53777f);
            this.w = likeModel;
            likeModel.setLoadDataCallBack(new a(this));
        }
        if (k.isForumName(this.v.e())) {
            this.y = true;
            this.w.I();
            this.w.L(this.v.e(), String.valueOf(this.v.d()));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.f53777f.getPageActivity(), this.f53777f.getString(R.string.neterror));
            return;
        }
        d.a.p0.e3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.e()) || this.v.d() <= 0 || !ViewHelper.checkUpIsLogin(this.f53777f.getPageActivity())) {
            return;
        }
        if (this.x == null) {
            f0 f0Var = new f0();
            this.x = f0Var;
            f0Var.b(new b(this));
        }
        this.y = true;
        this.x.c(this.v.e(), this.v.d());
    }

    public final void v() {
        d.a.p0.e3.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bVar = this.v) == null) {
            return;
        }
        String e2 = bVar.e();
        if (k.isForumName(e2)) {
            this.f53777f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f53777f.getPageActivity()).createNormalCfg(e2, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: w */
    public void l(d.a.p0.e3.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null) {
            return;
        }
        this.v = bVar;
        this.n.setShowOval(true);
        this.n.setShowOuterBorder(false);
        this.n.setShowInnerBorder(true);
        this.n.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.n.setStrokeColorResId(R.color.CAM_X0401);
        this.n.M(bVar.c(), 10, false);
        String e2 = bVar.e();
        if (k.isEmpty(e2)) {
            e2 = "";
        }
        this.o.setText(e2);
        this.q.setText(this.t + " " + StringHelper.numberUniformFormatExtra(bVar.h()));
        this.r.setText(this.u + " " + StringHelper.numberUniformFormatExtra((long) bVar.j()));
        y(bVar.getRecomReason());
        x(this.v.o());
        this.m.setOnClickListener(this);
        this.s.setOnClickListener(this);
        m(this.f53777f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (!z) {
                d.a.o0.r.f0.n.b bVar = new d.a.o0.r.f0.n.b();
                bVar.q(R.color.CAM_X0302);
                this.s.setConfig(bVar);
                this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
            } else {
                d.a.o0.r.f0.n.b bVar2 = new d.a.o0.r.f0.n.b();
                bVar2.r(R.color.CAM_X0109);
                this.s.setConfig(bVar2);
                this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
            }
            this.v.q(z);
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (k.isEmpty(str)) {
                if (this.p.getVisibility() != 8) {
                    this.p.setVisibility(8);
                    if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(this.f53777f.getPageActivity(), R.dimen.tbds47);
                        this.o.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.p.getVisibility() != 0) {
                this.p.setVisibility(0);
                if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(this.f53777f.getPageActivity(), R.dimen.tbds24);
                    this.o.requestLayout();
                }
            }
            this.p.setText(str);
        }
    }
}
