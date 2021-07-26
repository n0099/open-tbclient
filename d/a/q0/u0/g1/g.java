package d.a.q0.u0.g1;

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
import d.a.d.a.j;
import d.a.q0.h3.i;
import d.a.q0.u0.n2.h;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f63452a;

    /* renamed from: b  reason: collision with root package name */
    public i f63453b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f63454c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f63455d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63456e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f63457f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63458g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f63459h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f63460e;

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
            this.f63460e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f63460e.f63453b == null || StringUtils.isNull(this.f63460e.f63453b.l())) {
                return;
            }
            h.b((TbPageContext) j.a(this.f63460e.f63452a), this.f63460e.f63453b.f(), this.f63460e.f63453b.l());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", this.f63460e.f63453b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (this.f63460e.f63453b.k() != 1) {
                if (this.f63460e.f63453b.k() == 2) {
                    i2 = 7;
                } else if (this.f63460e.f63453b.k() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", this.f63460e.f63453b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (this.f63460e.f63454c != null) {
                statisticItem.param("fid", this.f63460e.f63454c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f63460e.f63454c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f63460e.f63454c.getSecond_class());
            }
            if (this.f63460e.f63453b.k() == 1) {
                statisticItem.param("tid", this.f63460e.f63453b.h());
                statisticItem.param("thread_type", this.f63460e.f63453b.i());
            }
            TiebaStatic.log(statisticItem);
            d.a.q0.u0.l2.a.a(this.f63460e.f63453b.g());
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
        this.f63452a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, forumData, iVar) == null) || iVar == null) {
            return;
        }
        this.f63454c = forumData;
        this.f63453b = iVar;
        this.f63456e.setText(iVar.j());
        if (iVar.k() == 3) {
            this.f63458g.setText(this.f63452a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f63453b.e())));
        } else if (iVar.k() == 1) {
            this.f63458g.setText(this.f63452a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f63453b.e())));
        } else if (iVar.k() == 2) {
            this.f63458g.setText(this.f63452a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f63453b.e())));
        }
        this.f63457f.M(this.f63453b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f63459h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.f63453b.a());
        }
        d.a.q0.u0.l2.a.b(this.f63453b.g());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63455d : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f63452a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
            this.f63455d = roundAdapterLinearLayout;
            roundAdapterLinearLayout.setRadius(this.f63452a.getResources().getDimension(R.dimen.tbds20));
            this.f63456e = (TextView) this.f63455d.findViewById(R.id.frs_top_ad_title);
            this.f63458g = (TextView) this.f63455d.findViewById(R.id.frs_top_person_num);
            TbImageView tbImageView = (TbImageView) this.f63455d.findViewById(R.id.frs_top_ad_img);
            this.f63457f = tbImageView;
            tbImageView.setDefaultBgResource(R.color.white_alpha100);
            this.f63459h = (FrsAdCommentScrollView) this.f63455d.findViewById(R.id.ad_comment_scroll_view);
            this.f63455d.setOnClickListener(new a(this));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f63457f.invalidate();
        }
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frsAdCommentScrollView = this.f63459h) == null) {
            return;
        }
        frsAdCommentScrollView.o();
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (frsAdCommentScrollView = this.f63459h) == null) {
            return;
        }
        frsAdCommentScrollView.p(z);
    }
}
