package d.a.s0.u0.g1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad.FrsAdCommentScrollView;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.s0.h3.i;
import d.a.s0.u0.n2.h;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66028a;

    /* renamed from: b  reason: collision with root package name */
    public i f66029b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f66030c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f66031d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66032e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f66033f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66034g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f66035h;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f66036e;

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
            this.f66036e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f66036e.f66029b == null || StringUtils.isNull(this.f66036e.f66029b.l())) {
                return;
            }
            h.b((TbPageContext) j.a(this.f66036e.f66028a), this.f66036e.f66029b.f(), this.f66036e.f66029b.l());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f66036e.f66029b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f66036e.f66029b.k() != 1) {
                if (this.f66036e.f66029b.k() == 2) {
                    i2 = 7;
                } else if (this.f66036e.f66029b.k() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f66036e.f66029b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f66036e.f66030c != null) {
                statisticItem.param("fid", this.f66036e.f66030c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f66036e.f66030c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f66036e.f66030c.getSecond_class());
            }
            if (this.f66036e.f66029b.k() == 1) {
                statisticItem.param("tid", this.f66036e.f66029b.h());
                statisticItem.param("thread_type", this.f66036e.f66029b.i());
            }
            TiebaStatic.log(statisticItem);
            d.a.s0.u0.l2.a.a(this.f66036e.f66029b.g());
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66028a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f66030c = forumData;
        this.f66029b = iVar;
        this.f66032e.setText(iVar.j());
        if (iVar.k() == 3) {
            this.f66034g.setText(this.f66028a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f66029b.e())));
        } else if (iVar.k() == 1) {
            this.f66034g.setText(this.f66028a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f66029b.e())));
        } else if (iVar.k() == 2) {
            this.f66034g.setText(this.f66028a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f66029b.e())));
        }
        this.f66033f.M(this.f66029b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f66035h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.f66029b.a());
        }
        d.a.s0.u0.l2.a.b(this.f66029b.g());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66031d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f66028a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
            this.f66031d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.f66028a.getResources().getDimension(R.dimen.tbds20));
            this.f66032e = (TextView) this.f66031d.findViewById(R.id.frs_top_ad_title);
            this.f66034g = (TextView) this.f66031d.findViewById(R.id.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f66031d.findViewById(R.id.frs_top_ad_img);
            this.f66033f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f66035h = (FrsAdCommentScrollView) this.f66031d.findViewById(R.id.ad_comment_scroll_view);
            this.f66031d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f66033f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f66035h) == null) {
            return;
        }
        frsAdCommentScrollView.o();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f66035h) == null) {
            return;
        }
        frsAdCommentScrollView.p(z);
    }
}
