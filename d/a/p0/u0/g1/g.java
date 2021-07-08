package d.a.p0.u0.g1;

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
import d.a.p0.h3.i;
import d.a.p0.u0.n2.h;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f62809a;

    /* renamed from: b  reason: collision with root package name */
    public i f62810b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f62811c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f62812d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62813e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f62814f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62815g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f62816h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f62817e;

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
            this.f62817e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f62817e.f62810b == null || StringUtils.isNull(this.f62817e.f62810b.l())) {
                return;
            }
            h.b((TbPageContext) j.a(this.f62817e.f62809a), this.f62817e.f62810b.f(), this.f62817e.f62810b.l());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f62817e.f62810b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f62817e.f62810b.k() != 1) {
                if (this.f62817e.f62810b.k() == 2) {
                    i2 = 7;
                } else if (this.f62817e.f62810b.k() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f62817e.f62810b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f62817e.f62811c != null) {
                statisticItem.param("fid", this.f62817e.f62811c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f62817e.f62811c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f62817e.f62811c.getSecond_class());
            }
            if (this.f62817e.f62810b.k() == 1) {
                statisticItem.param("tid", this.f62817e.f62810b.h());
                statisticItem.param("thread_type", this.f62817e.f62810b.i());
            }
            TiebaStatic.log(statisticItem);
            d.a.p0.u0.l2.a.a(this.f62817e.f62810b.g());
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
        this.f62809a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f62811c = forumData;
        this.f62810b = iVar;
        this.f62813e.setText(iVar.j());
        if (iVar.k() == 3) {
            this.f62815g.setText(this.f62809a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f62810b.e())));
        } else if (iVar.k() == 1) {
            this.f62815g.setText(this.f62809a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f62810b.e())));
        } else if (iVar.k() == 2) {
            this.f62815g.setText(this.f62809a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f62810b.e())));
        }
        this.f62814f.M(this.f62810b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f62816h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.f62810b.a());
        }
        d.a.p0.u0.l2.a.b(this.f62810b.g());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62812d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f62809a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
            this.f62812d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.f62809a.getResources().getDimension(R.dimen.tbds20));
            this.f62813e = (TextView) this.f62812d.findViewById(R.id.frs_top_ad_title);
            this.f62815g = (TextView) this.f62812d.findViewById(R.id.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f62812d.findViewById(R.id.frs_top_ad_img);
            this.f62814f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f62816h = (FrsAdCommentScrollView) this.f62812d.findViewById(R.id.ad_comment_scroll_view);
            this.f62812d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f62814f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f62816h) == null) {
            return;
        }
        frsAdCommentScrollView.o();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f62816h) == null) {
            return;
        }
        frsAdCommentScrollView.p(z);
    }
}
