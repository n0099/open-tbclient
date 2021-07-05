package d.a.s0.v.i.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.f;
import d.a.r0.z0.j0;
import d.a.s0.a0.m;
import d.a.s0.a0.z;
/* loaded from: classes9.dex */
public class c extends d.a.s0.a0.a<b2> implements z, d.a.s0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public HeadImageView B;
    public TextView C;
    public AlaVideoContainer D;
    public RelativeLayout E;
    public LinearLayout F;
    public ThreadSourceShareAndPraiseLayout G;
    public View H;
    public String I;
    public String J;
    public View K;
    public final View.OnClickListener L;
    public LinearLayout w;
    public RelativeLayout x;
    public CardUserInfoLayout y;
    public TextView z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f68023e;

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
            this.f68023e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f68023e.i() == null) {
                return;
            }
            this.f68023e.i().a(view, this.f68023e.o);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.L = new a(this);
        p(bdUniqueId);
        this.m = tbPageContext;
        View l = l();
        RelativeLayout relativeLayout = (RelativeLayout) l.findViewById(R.id.layout_root);
        this.x = relativeLayout;
        relativeLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) l.findViewById(R.id.video_card_content_layout);
        this.w = linearLayout;
        linearLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) l.findViewById(R.id.ala_share_container);
        this.E = relativeLayout2;
        this.F = (LinearLayout) relativeLayout2.findViewById(R.id.challenge_root);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) l.findViewById(R.id.card_ala_video_user_info_layout);
        this.y = cardUserInfoLayout;
        cardUserInfoLayout.setShowFlag(6141);
        HeadImageView headImageView = (HeadImageView) l.findViewById(R.id.ala_share_live_user_pendant_header);
        this.B = headImageView;
        headImageView.setIsRound(true);
        this.B.setDrawBorder(false);
        this.B.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.B.setAutoChangeStyle(false);
        this.C = (TextView) l.findViewById(R.id.ala_share_live_username_text);
        this.z = (TextView) l.findViewById(R.id.text_title);
        this.A = (TextView) l.findViewById(R.id.ala_live_room_title);
        AlaVideoContainer alaVideoContainer = (AlaVideoContainer) l.findViewById(R.id.ala_video_container);
        this.D = alaVideoContainer;
        alaVideoContainer.setOnVideoClickListener(this);
        View findViewById = l.findViewById(R.id.thread_multi_del_mask_view);
        this.K = findViewById;
        findViewById.setClickable(true);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) l.findViewById(R.id.text_bottom);
        this.p = threadCommentAndPraiseInfoLayout;
        u(threadCommentAndPraiseInfoLayout);
        this.p.setSelectVisible(false);
        this.p.setIsBarViewVisible(false);
        this.p.setCommentNumEnable(true);
        this.p.setLiveShareEnable(false);
        this.p.setFrom(2);
        this.p.getCommentContainer().setOnClickListener(this);
        this.p.hideDisagree();
        this.p.setShareReportFrom(1);
        f fVar = new f();
        fVar.f55932b = 2;
        fVar.f55938h = 2;
        this.p.setAgreeStatisticData(fVar);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) l.findViewById(R.id.card_bottom_op_weight_layout);
        this.q = threadCommentAndPraiseInfoLayout2;
        u(threadCommentAndPraiseInfoLayout2);
        this.q.setFrom(2);
        this.q.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) l.findViewById(R.id.text_bottom_2);
        this.G = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12588f.setOnClickListener(this);
        this.G.f12588f.getCommentContainer().setOnClickListener(this);
        this.G.setFrom(2);
        this.G.setShareReportFrom(1);
        this.G.setSourceFromForPb(3);
        this.G.setStType("frs_page");
        this.G.setHideBarName(true);
        this.H = l.findViewById(R.id.divider_below_reply_number_layout);
        this.D.setLigvingLogLayoutVisible(8);
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
            if (this.z.getVisibility() == 0) {
                layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            } else {
                layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            }
            this.E.setLayoutParams(layoutParams);
        }
    }

    public ThreadCommentAndPraiseInfoLayout M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : (ThreadCommentAndPraiseInfoLayout) invokeV.objValue;
    }

    public int N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? d.a.s0.o.d.c().b(this.J, i2) : invokeI.intValue;
    }

    public ThreadCommentAndPraiseInfoLayout O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.G;
            if (threadSourceShareAndPraiseLayout != null) {
                return threadSourceShareAndPraiseLayout.f12588f;
            }
            return null;
        }
        return (ThreadCommentAndPraiseInfoLayout) invokeV.objValue;
    }

    public void P(TbPageContext<?> tbPageContext) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null || (t = this.o) == 0 || ((b2) t).g1() == null) {
            return;
        }
        if (!j.z()) {
            l.L(tbPageContext.getPageActivity(), R.string.no_network_guide);
            return;
        }
        AlaInfoData g1 = ((b2) this.o).g1();
        if (g1.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext2 = this.m;
            YyExtData yyExtData = g1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext2, str, str2, str3, "" + g1.roomId, YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + TbSingleton.getInstance().getFrsCurTabType());
        }
    }

    public final void Q(TbPageContext<?> tbPageContext) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) || (t = this.o) == 0 || ((b2) t).g1() == null || ((b2) this.o).g1().share_info == null) {
            return;
        }
        if (((b2) this.o).g1().share_info.record_tid <= 0) {
            P(this.f57032f);
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((b2) this.o).g1().share_info.record_tid), null, "frs_page");
        createNormalCfg.setVideo_source(((b2) this.o).N1() ? "floor5" : "frs");
        createNormalCfg.setFromSmartFrs(((b2) this.o).k2());
        createNormalCfg.setSmartFrsPosition(((b2) this.o).a1());
        createNormalCfg.setStartFrom(3);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: R */
    public void m(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b2Var) == null) {
            this.o = b2Var;
            S();
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            T t = this.o;
            int i2 = 8;
            if (t != 0 && ((b2) t).H() != null) {
                this.x.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
                layoutParams.bottomMargin = 0;
                this.y.setData((b2) this.o);
                this.y.setUserAfterClickListener(this.L);
                this.D.getController().d((b2) this.o, this.I, "", false);
                this.D.getController().c();
                if (((b2) this.o).g1() != null && ((b2) this.o).g1().share_info != null && !StringUtils.isNull(((b2) this.o).g1().share_info.content)) {
                    this.z.setVisibility(0);
                    this.z.setText(((b2) this.o).g1().share_info.content);
                } else {
                    this.z.setVisibility(8);
                }
                if (((b2) this.o).g1() != null && ((b2) this.o).g1().user_info != null) {
                    String str = ((b2) this.o).g1().user_info.user_name;
                    if (j0.d(str) > 14) {
                        str = j0.m(str, 14) + StringHelper.STRING_MORE;
                    }
                    this.C.setText(str + ":");
                    if (TextUtils.isEmpty(((b2) this.o).g1().user_info.portrait)) {
                        this.B.setPlaceHolder(1);
                    } else {
                        this.B.N(((b2) this.o).g1().user_info.portrait, 10, false, false);
                    }
                }
                String title = ((b2) this.o).getTitle();
                if (!StringUtils.isNull(title)) {
                    this.A.setText(title);
                    this.A.setVisibility(0);
                } else {
                    this.A.setVisibility(8);
                }
                U(N(1));
                if (((b2) this.o).g1().mChallengeInfoData != null && ((b2) this.o).g1().mChallengeInfoData.challenge_id > 0) {
                    this.F.setVisibility(0);
                } else {
                    this.F.setVisibility(8);
                }
                this.K.setVisibility((d.a.s0.u0.b.e().g() || d.a.s0.u0.a.h().j()) ? 0 : 0);
                B(this.x);
                n(k(), TbadkCoreApplication.getInst().getSkinType());
                L();
                return;
            }
            this.x.setVisibility(8);
        }
    }

    public void T(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        p(bdUniqueId);
        x(bdUniqueId);
    }

    public void U(int i2) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (t = this.o) == 0) {
            return;
        }
        if (i2 == 1) {
            this.p.setVisibility(8);
            this.G.g((b2) this.o);
            return;
        }
        this.p.setData((b2) t);
        this.G.setVisibility(8);
    }

    @Override // d.a.s0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.I = str;
        }
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.frs_ala_share_live_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i2) == null) {
            if (this.f57031e != i2) {
                w(tbPageContext, i2);
                d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.x);
                d2.n(R.string.J_X06);
                d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.E, R.color.CAM_X0204);
                AlaVideoContainer alaVideoContainer = this.D;
                if (alaVideoContainer != null) {
                    alaVideoContainer.o(i2);
                }
                this.y.onChangeSkinType(k(), TbadkCoreApplication.getInst().getSkinType());
                this.p.onChangeSkinType();
                this.f57031e = i2;
                HeadImageView headImageView = this.B;
                if (headImageView != null) {
                    headImageView.setPlaceHolder(1);
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.G;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.G.f();
                }
            }
            T t = this.o;
            if (t != 0 && m.k(((b2) t).c0())) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0201);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || d.a.s0.u0.b.e().g() || d.a.s0.u0.a.h().j()) {
            return;
        }
        int i2 = 1;
        if (view != this.x && view != this.p.getCommentContainer() && this.w != view && view != this.G.f12588f.getCommentContainer() && view != this.q.getCommentContainer()) {
            if (view.getId() == R.id.video_container) {
                if (i() != null) {
                    i().a(view, this.o);
                }
                TiebaStatic.log(new StatisticItem("c12323"));
                if (((b2) this.o).g1().live_status == 1) {
                    P(this.f57032f);
                    return;
                } else {
                    Q(this.f57032f);
                    return;
                }
            }
            return;
        }
        T t = this.o;
        if (t != 0) {
            m.a(((b2) t).c0());
        }
        if (i() != null) {
            i().a(this.x, this.o);
        }
        TiebaStatic.log(new StatisticItem("c12323"));
        if (((b2) this.o).g1().live_status == 1) {
            P(this.f57032f);
            i2 = 5;
        } else {
            Q(this.f57032f);
        }
        if (view == this.p.getCommentContainer() || view == this.G.f12588f.getCommentContainer()) {
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 2);
            statisticItem.param("tid", ((b2) this.o).n1());
            statisticItem.param("obj_type", i2);
            statisticItem.param("nid", ((b2) this.o).A0());
            d.a.r0.i0.c f2 = TbPageExtraHelper.f(view);
            if (f2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.a.s0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    @Override // d.a.s0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.J = str;
        }
    }
}
