package d.a.p0.v.i.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.r.k;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.f;
import d.a.p0.a0.m;
import d.a.p0.a0.z;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes8.dex */
public class e extends d.a.p0.a0.a<b2> implements z, d.a.p0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public RelativeLayout B;
    public TextView C;
    public TbImageView D;
    public RelativeLayout E;
    public TbImageView F;
    public TBLottieAnimationView G;
    public TextView H;
    public TextView I;
    public LinearLayout J;
    public View K;
    public FrameLayout L;
    public LinearLayout M;
    public TextView N;
    public ImageView O;
    public String P;
    public boolean Q;
    public String R;
    public View S;
    public boolean T;
    public int U;
    public d.a.p0.v.i.d.a V;
    public final View.OnClickListener W;
    public CardUserInfoLayout w;
    public ThreadSourceShareAndPraiseLayout x;
    public View y;
    public LinearLayout z;

    /* loaded from: classes8.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f64809e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64809e = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64809e.G.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f64809e.G.cancelAnimation();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f64810e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64810e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64810e.h() == null) {
                return;
            }
            this.f64810e.h().a(view, this.f64810e.o);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.Q = false;
        this.U = 0;
        this.W = new b(this);
        o(bdUniqueId);
        this.m = tbPageContext;
        View k = k();
        RelativeLayout relativeLayout = (RelativeLayout) k.findViewById(R.id.layout_root);
        this.B = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.z = (LinearLayout) k.findViewById(R.id.video_card_content_layout);
        this.B.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) k.findViewById(R.id.video_card_stage_view);
        this.D = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.D.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) k.findViewById(R.id.card_ala_video_user_info_layout);
        this.w = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.W);
        this.C = (TextView) k.findViewById(R.id.text_title);
        this.E = (RelativeLayout) k.findViewById(R.id.frame_video);
        TbImageView tbImageView2 = (TbImageView) k.findViewById(R.id.image_video);
        this.F = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.F.setPlaceHolder(3);
        this.F.setDefaultResource(0);
        this.F.setRadiusById(R.string.J_X05);
        this.F.setConrers(15);
        this.F.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.F.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.F.setBorderSurroundContent(true);
        this.F.setDrawBorder(true);
        this.J = (LinearLayout) k.findViewById(R.id.ala_live_lottie_bg);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) k.findViewById(R.id.ala_live_lottie);
        this.G = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.G, R.raw.ala_live2);
        this.G.addOnAttachStateChangeListener(new a(this));
        this.H = (TextView) k.findViewById(R.id.play_count);
        this.I = (TextView) k.findViewById(R.id.ala_live_recom_reason);
        this.K = k.findViewById(R.id.play_count_line);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.text_bottom);
        this.p = threadCommentAndPraiseInfoLayout;
        t(threadCommentAndPraiseInfoLayout);
        this.p.setSelectVisible(false);
        this.p.setIsBarViewVisible(false);
        this.p.setCommentNumEnable(true);
        this.p.setLiveShareEnable(false);
        this.p.setFrom(2);
        this.p.getCommentContainer().setOnClickListener(this);
        this.p.hideDisagree();
        f fVar = new f();
        fVar.f52647b = 2;
        fVar.f52653h = 2;
        this.p.setAgreeStatisticData(fVar);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.card_bottom_op_weight_layout);
        this.q = threadCommentAndPraiseInfoLayout2;
        t(threadCommentAndPraiseInfoLayout2);
        this.q.setFrom(2);
        this.q.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) k.findViewById(R.id.text_bottom_2);
        this.x = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12605f.setOnClickListener(this);
        this.x.f12605f.getCommentContainer().setOnClickListener(this);
        this.x.setFrom(2);
        this.x.setShareReportFrom(1);
        this.x.setSourceFromForPb(3);
        this.x.setStType("frs_page");
        this.x.setHideBarName(true);
        this.y = k.findViewById(R.id.divider_below_reply_number_layout);
        this.A = (ThreadSkinView) k.findViewById(R.id.frs_thread_skin);
        View findViewById = k.findViewById(R.id.thread_multi_del_mask_view);
        this.S = findViewById;
        findViewById.setClickable(true);
        d.a.p0.v.i.d.a aVar = new d.a.p0.v.i.d.a(tbPageContext, this.w.getSuffixContainer());
        this.V = aVar;
        aVar.d(i());
        this.L = (FrameLayout) k.findViewById(R.id.text_bottom_layout);
        this.M = (LinearLayout) k.findViewById(R.id.forum_friends_now_looking);
        this.N = (TextView) k.findViewById(R.id.tv_forum_friends_now_looking);
        this.O = (ImageView) k.findViewById(R.id.image_forum_friends_now_looking);
    }

    public final void L(b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, b2Var, str) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", b2Var.c0()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", b2Var.g1().live_id).param("obj_type", 2));
            if (b2Var.g1() != null && b2Var.g1().user_info != null && b2Var.g1().user_info.is_official == 2) {
                TiebaStatic.log(new StatisticItem("c12801").param("tid", b2Var.c0()));
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (b2Var.W().equals(this.P)) {
                    TiebaStatic.log(new StatisticItem("c11843").param("uid", currentAccount).param("fid", b2Var.Q()));
                } else {
                    TiebaStatic.log(new StatisticItem("c11845").param("uid", currentAccount).param("fid", b2Var.Q()));
                }
            }
        }
    }

    public final void M(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12125").param("tid", b2Var.c0()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", b2Var.g1().live_id).param("obj_type", 2));
        if (b2Var.g1() == null || b2Var.g1().user_info == null || b2Var.g1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12800").param("tid", b2Var.c0()));
    }

    public int N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? d.a.p0.o.d.c().b(this.R, i2) : invokeI.intValue;
    }

    public void O() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (k.c().g() && (t = this.o) != 0) {
                b2 b2Var = (b2) t;
                b2Var.getThreadData();
                if (b2Var != null) {
                    b2 b2Var2 = (b2) this.o;
                    b2Var2.getThreadData();
                    if (b2Var2.g1() != null) {
                        this.F.setPlaceHolder(3);
                        TbImageView tbImageView = this.F;
                        b2 b2Var3 = (b2) this.o;
                        b2Var3.getThreadData();
                        tbImageView.M(b2Var3.g1().cover, 10, false);
                        this.E.setVisibility(0);
                        return;
                    }
                }
            }
            this.E.setVisibility(8);
        }
    }

    public void P(Context context, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, context, b2Var) == null) || context == null || b2Var == null || b2Var.g1() == null) {
            return;
        }
        if (!j.z()) {
            l.L(context, R.string.no_network_guide);
            return;
        }
        String str = this.T ? AlaLiveRoomActivityConfig.FREM_TYPE_LIVE_FRS_STAGE_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
        if (b2Var.X() != null) {
            str = b2Var.X();
        }
        int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
        if (frsCurTabType == 14) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + b2Var.Q();
        } else if (frsCurTabType == 13) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + b2Var.Q();
        }
        L(b2Var, str);
        AlaInfoData g1 = b2Var.g1();
        if (g1.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext = this.m;
            YyExtData yyExtData = g1.mYyExtData;
            String str2 = yyExtData.mSid;
            String str3 = yyExtData.mSsid;
            String str4 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str2, str3, str4, "" + g1.roomId, YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + frsCurTabType);
            R(((b2) this.o).n1(), String.valueOf(((b2) this.o).Q()), String.valueOf(g1.roomId), String.valueOf(g1.live_id), g1.mYyExtData.mSid);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: Q */
    public void l(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b2Var) == null) {
            this.o = b2Var;
            S();
        }
    }

    public final void R(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, str, str2, str3, str4, str5) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", str);
                jSONObject.put("fid", str2);
                if (TextUtils.equals("0", str3)) {
                    str3 = null;
                }
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, str3);
                if (TextUtils.equals("0", str4)) {
                    str4 = null;
                }
                jSONObject.put("liveId", str4);
                jSONObject.put("sid", str5);
                jSONObject.put("roomInfo", "roomInfo");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            T t = this.o;
            int i2 = 8;
            if (t != 0 && ((b2) t).H() != null) {
                this.B.setVisibility(0);
                int k = l.k(this.m.getPageActivity());
                if (k != this.U) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                    int k2 = l.k(b()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = k2;
                    layoutParams.height = (k2 * 9) / 16;
                    this.E.setLayoutParams(layoutParams);
                    this.U = k;
                }
                SparseArray<String> sparseArray = null;
                if (((b2) this.o).g1() != null && ((b2) this.o).g1().user_info != null && ((b2) this.o).g1().user_info.is_official == 2) {
                    this.T = true;
                    sparseArray = ((b2) this.o).g1().dislikeInfo;
                    this.D.setVisibility(0);
                    int[] p = l.p(b());
                    ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
                    layoutParams2.width = p[0];
                    layoutParams2.height = (p[0] * 156) / 1080;
                    this.D.setLayoutParams(layoutParams2);
                    if (!TextUtils.isEmpty(((b2) this.o).g1().liveStagePicUrl)) {
                        this.D.M(((b2) this.o).g1().liveStagePicUrl, 10, false);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                    marginLayoutParams.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds24);
                    this.w.setLayoutParams(marginLayoutParams);
                } else {
                    this.T = false;
                    this.D.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                    marginLayoutParams2.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds44);
                    this.w.setLayoutParams(marginLayoutParams2);
                }
                if (this.T && sparseArray != null && sparseArray.size() > 0) {
                    this.V.b((b2) this.o, "ala_frs_demo_hell_live_feed_back_type");
                } else if (this.V.a() != null) {
                    this.V.a().setVisibility(8);
                }
                ((b2) this.o).J2(false, true);
                this.w.setData((b2) this.o);
                SpannableStringBuilder b1 = ((b2) this.o).b1();
                if (b1 != null && !StringUtils.isNull(b1.toString())) {
                    this.C.setText(((b2) this.o).b1());
                    this.C.setVisibility(0);
                } else {
                    this.C.setVisibility(8);
                }
                if (((b2) this.o).g1().audience_count > 0) {
                    this.K.setVisibility(0);
                    this.H.setVisibility(0);
                    this.H.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((b2) this.o).g1().audience_count)));
                } else {
                    this.K.setVisibility(8);
                    this.H.setVisibility(8);
                }
                this.I.setVisibility(8);
                if (((b2) this.o).g1().openRecomReason == 1) {
                    String str = ((b2) this.o).g1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.I.setVisibility(0);
                        this.I.setText(str);
                    } else {
                        String r0 = ((b2) this.o).r0();
                        String x0 = ((b2) this.o).x0();
                        if (UtilHelper.isDecimal(r0) && UtilHelper.isDecimal(x0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = d.a.p0.w2.g0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(r0), Double.parseDouble(x0)) <= 50.0d) {
                                this.I.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.I.setVisibility(0);
                            }
                        }
                    }
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.L.getLayoutParams();
                if (((b2) this.o).g1() != null && !StringUtils.isNull(((b2) this.o).g1().forumUserLiveMsg)) {
                    this.M.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((b2) this.o).g1().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                    this.N.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                    layoutParams3.addRule(3, R.id.forum_friends_now_looking);
                } else {
                    this.M.setVisibility(8);
                    layoutParams3.addRule(3, R.id.video_card_content_layout);
                }
                this.L.setLayoutParams(layoutParams3);
                W(N(1));
                M((b2) this.o);
                this.S.setVisibility((d.a.p0.u0.b.e().g() || d.a.p0.u0.a.h().j()) ? 0 : 0);
                m(this.m, TbadkCoreApplication.getInst().getSkinType());
                O();
                this.G.playAnimation();
                A(this.B);
                return;
            }
            this.B.setVisibility(8);
        }
    }

    public void T(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.w;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        o(bdUniqueId);
        w(bdUniqueId);
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.Q = z;
        }
    }

    public void W(int i2) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (t = this.o) == 0) {
            return;
        }
        if (i2 == 1) {
            this.p.setVisibility(8);
            this.x.g((b2) this.o);
            return;
        }
        this.y.setVisibility(this.p.setData((b2) t) ? 8 : 0);
        this.x.setVisibility(8);
    }

    @Override // d.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.P = str;
        }
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.frs_ala_video_layout_new : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    @SuppressLint({"ResourceAsColor"})
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i2) == null) {
            if (this.f53776e != i2) {
                v(tbPageContext, i2);
                d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.B);
                d2.n(R.string.J_X06);
                d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
                d.a.o0.r.u.c d3 = d.a.o0.r.u.c.d(this.E);
                d3.l(R.dimen.L_X01);
                d3.k(R.color.CAM_X0401);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0611);
                float g2 = l.g(b(), R.dimen.tbds31);
                SkinManager.setBackgroundEndColorToAutoColor(this.J, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
                SkinManager.setBackgroundColor(this.K, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.I, R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(l.g(b(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.M);
                SkinManager.setViewTextColor(this.N, R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.O, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.w.onChangeSkinType(j(), TbadkCoreApplication.getInst().getSkinType());
                this.F.setPlaceHolder(3);
                this.p.onChangeSkinType();
                this.f53776e = i2;
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.x;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.x.f();
                }
            }
            T t = this.o;
            if (t != 0 && m.k(((b2) t).c0())) {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0201);
            this.V.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view) == null) || d.a.p0.u0.b.e().g() || d.a.p0.u0.a.h().j()) {
            return;
        }
        if (view != this.B && view != this.p.getCommentContainer() && view != this.z && view != this.x.f12605f.getCommentContainer() && view != this.q.getCommentContainer() && view != this.M) {
            if (view.getId() == R.id.video_container) {
                if (h() != null) {
                    h().a(view, this.o);
                }
                P(b(), (b2) this.o);
                return;
            }
            return;
        }
        T t = this.o;
        if (t != 0) {
            m.a(((b2) t).c0());
        }
        if (h() != null) {
            h().a(this.B, this.o);
        }
        P(b(), (b2) this.o);
        if (this.o != 0) {
            if (view == this.p.getCommentContainer() || view == this.x.f12605f.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", ((b2) this.o).n1());
                statisticItem.param("nid", ((b2) this.o).A0());
                d.a.o0.i0.c f2 = TbPageExtraHelper.f(view);
                if (f2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    @Override // d.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
        }
    }

    @Override // d.a.p0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.R = str;
        }
    }
}
