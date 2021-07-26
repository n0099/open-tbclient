package d.a.q0.a0;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes7.dex */
public class k extends d.a.q0.a0.a<d.a.q0.a0.e0.j> implements d.a.q0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int O;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public TbImageView B;
    public TBLottieAnimationView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public View G;
    public LinearLayout H;
    public TextView I;
    public ImageView J;
    public boolean K;
    public int L;
    public View.OnClickListener M;
    public CustomMessageListener N;
    public FrameLayout w;
    public LinearLayout x;
    public CardUserInfoLayout y;
    public TextView z;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f54386e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54386e = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54386e.C.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f54386e.C.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f54387e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54387e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54387e.h() == null) {
                return;
            }
            this.f54387e.h().a(view, this.f54387e.o);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f54388a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54388a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.f54388a.o) == 0 || ((d.a.q0.a0.e0.j) t).f54338e == null || ((d.a.q0.a0.e0.j) t).f54338e.o1() == null || this.f54388a.z == null || !((String) customResponsedMessage.getData()).equals(((d.a.q0.a0.e0.j) this.f54388a.o).f54338e.o1())) {
                return;
            }
            k kVar = this.f54388a;
            TextView textView = kVar.z;
            String d0 = ((d.a.q0.a0.e0.j) kVar.o).f54338e.d0();
            int i2 = R.color.CAM_X0109;
            m.l(textView, d0, i2, i2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(165461477, "Ld/a/q0/a0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(165461477, "Ld/a/q0/a0/k;");
                return;
            }
        }
        O = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.K = false;
        this.L = 0;
        this.M = new b(this);
        this.N = new c(this, 2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        N(k());
    }

    public View K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CardUserInfoLayout cardUserInfoLayout = this.y;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getAvatar();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.K) {
                CardUserInfoLayout cardUserInfoLayout = this.y;
                if (cardUserInfoLayout != null) {
                    return cardUserInfoLayout.getUserName();
                }
                return null;
            }
            return this.z;
        }
        return (View) invokeV.objValue;
    }

    public void M() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d.a.p0.s.k.c().g() && (t = this.o) != 0 && ((d.a.q0.a0.e0.j) t).getThreadData() != null && ((d.a.q0.a0.e0.j) this.o).getThreadData().h1() != null) {
                this.B.setPlaceHolder(3);
                this.B.M(((d.a.q0.a0.e0.j) this.o).getThreadData().h1().cover, 10, false);
                this.A.setVisibility(0);
                return;
            }
            this.A.setVisibility(8);
        }
    }

    public final void N(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.w = (FrameLayout) view.findViewById(R.id.layout_root);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
            this.x = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
            this.y = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.m);
            this.y.setPageUniqueId(this.n);
            this.z = (TextView) view.findViewById(R.id.text_title);
            this.A = (RelativeLayout) view.findViewById(R.id.frame_video);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image_video);
            this.B = tbImageView;
            tbImageView.setDrawCorner(true);
            this.B.setPlaceHolder(3);
            this.B.setDefaultResource(0);
            this.B.setRadiusById(R.string.J_X05);
            this.B.setConrers(15);
            this.B.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.B.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.B.setBorderSurroundContent(true);
            this.B.setDrawBorder(true);
            this.F = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
            this.C = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.C, R.raw.ala_live2);
            this.C.addOnAttachStateChangeListener(new a(this));
            this.D = (TextView) view.findViewById(R.id.play_count);
            this.E = (TextView) view.findViewById(R.id.ala_live_recom_reason);
            this.G = view.findViewById(R.id.play_count_line);
            this.u = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
            this.p = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
            this.q = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
            t(this.p);
            t(this.q);
            this.x.setOnClickListener(this);
            this.H = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
            this.I = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
            this.J = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
            this.H.setOnClickListener(this);
            d.a.p0.b.g.b.h(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f54320f;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void P(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (h() != null) {
                h().a(view, this.o);
            }
            T t = this.o;
            if (t == 0 || ((d.a.q0.a0.e0.j) t).getThreadData() == null || ((d.a.q0.a0.e0.j) this.o).getThreadData().h1() == null) {
                return;
            }
            AlaInfoData h1 = ((d.a.q0.a0.e0.j) this.o).getThreadData().h1();
            m.a(((d.a.q0.a0.e0.j) this.o).f54338e.d0());
            m.l(this.z, ((d.a.q0.a0.e0.j) this.o).f54338e.d0(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (h1.isLegalYYLiveData()) {
                if (((d.a.q0.a0.e0.j) this.o).getThreadData().W1) {
                    str = YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                } else {
                    str = ((d.a.q0.a0.e0.j) this.o).getThreadData().X1 ? YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD : YYLiveUtil.SOURCE_NOT_DEFINE;
                }
                String str2 = str;
                TbPageContext<?> tbPageContext = this.m;
                YyExtData yyExtData = h1.mYyExtData;
                String str3 = yyExtData.mSid;
                String str4 = yyExtData.mSsid;
                String str5 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + h1.roomId, str2);
                R(((d.a.q0.a0.e0.j) this.o).getThreadData().o1(), String.valueOf(((d.a.q0.a0.e0.j) this.o).getThreadData().R()), String.valueOf(h1.roomId), String.valueOf(h1.live_id), h1.mYyExtData.mSid);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: Q */
    public void l(d.a.q0.a0.e0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jVar) == null) {
            this.o = jVar;
            S();
        }
    }

    public final void R(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, str4, str5) == null) {
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T t = this.o;
            if (t != 0 && ((d.a.q0.a0.e0.j) t).getThreadData() != null) {
                this.w.setVisibility(0);
                int k = d.a.d.e.p.l.k(this.m.getPageActivity());
                if (k != this.L) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.A.setLayoutParams(layoutParams);
                    this.L = k;
                }
                if (((d.a.q0.a0.e0.j) this.o).getThreadData().h1() != null && ((d.a.q0.a0.e0.j) this.o).getThreadData().h1().isChushou) {
                    this.p.setShowFlag(10);
                    this.p.hideShareContainer();
                } else {
                    this.p.setShowFlag(11);
                    this.p.resetShareContainer();
                }
                this.y.setVisibility(0);
                this.y.setData(((d.a.q0.a0.e0.j) this.o).getThreadData());
                this.y.setUserAfterClickListener(this.M);
                ((d.a.q0.a0.e0.j) this.o).getThreadData().O2();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((d.a.q0.a0.e0.j) this.o).getThreadData().c1());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setText(spannableStringBuilder);
                    this.z.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.z);
                }
                if (((d.a.q0.a0.e0.j) this.o).f54338e.h1().audience_count > 0) {
                    this.G.setVisibility(0);
                    this.D.setVisibility(0);
                    this.D.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((d.a.q0.a0.e0.j) this.o).f54338e.h1().audience_count)));
                } else {
                    this.G.setVisibility(8);
                    this.D.setVisibility(8);
                }
                this.E.setVisibility(8);
                if (((d.a.q0.a0.e0.j) this.o).f54338e.h1().openRecomReason == 1) {
                    String str = ((d.a.q0.a0.e0.j) this.o).f54338e.h1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.E.setVisibility(0);
                        this.E.setText(str);
                    } else {
                        String s0 = ((d.a.q0.a0.e0.j) this.o).f54338e.s0();
                        String y0 = ((d.a.q0.a0.e0.j) this.o).f54338e.y0();
                        if (UtilHelper.isDecimal(s0) && UtilHelper.isDecimal(y0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = d.a.q0.w2.g0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && d.a.d.e.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(s0), Double.parseDouble(y0)) <= 50.0d) {
                                this.E.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.E.setVisibility(0);
                            }
                        }
                    }
                }
                if (((d.a.q0.a0.e0.j) this.o).f54338e.h1() != null && !StringUtils.isNull(((d.a.q0.a0.e0.j) this.o).f54338e.h1().forumUserLiveMsg)) {
                    this.H.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((d.a.q0.a0.e0.j) this.o).f54338e.h1().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                    this.I.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                } else {
                    this.H.setVisibility(8);
                }
                A(this.w);
                m(this.m, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((d.a.q0.a0.e0.j) this.o).f54338e.d0())) {
                    SkinManager.setViewTextColor(this.z, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.z, R.color.CAM_X0105, 1);
                }
                M();
                this.C.playAnimation();
                return;
            }
            this.w.setVisibility(8);
        }
    }

    public void T(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.N == null) {
            return;
        }
        o(bdUniqueId);
        w(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.N.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.N);
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.K = z;
        }
    }

    public void V(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (threadCommentAndPraiseInfoLayout = this.p) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.S = String.valueOf(i2);
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i2) == null) || this.f54319e == i2) {
            return;
        }
        v(tbPageContext, i2);
        d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.x);
        d2.n(R.string.J_X06);
        d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
        d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(this.A);
        d3.l(R.dimen.L_X01);
        d3.k(R.color.CAM_X0401);
        d3.n(R.string.J_X05);
        d3.f(R.color.CAM_X0611);
        float g2 = d.a.d.e.p.l.g(b(), R.dimen.tbds31);
        SkinManager.setBackgroundEndColorToAutoColor(this.F, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
        SkinManager.setBackgroundColor(this.G, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.D, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.E, R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(d.a.d.e.p.l.g(b(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(O).into(this.H);
        SkinManager.setViewTextColor(this.I, R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.J, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.y.onChangeSkinType(j(), TbadkCoreApplication.getInst().getSkinType());
        this.B.setPlaceHolder(3);
        this.f54319e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view == this.x || view == this.p.getCommentContainer() || view == this.q.getCommentContainer() || view == this.H) {
                if (((d.a.q0.a0.e0.j) this.o).getThreadData().h1() != null && ((d.a.q0.a0.e0.j) this.o).getThreadData().h1().isChushou) {
                    O(((d.a.q0.a0.e0.j) this.o).getThreadData().h1().thirdRoomId, ((d.a.q0.a0.e0.j) this.o).getThreadData().h1().thirdLiveType);
                } else {
                    P(view);
                }
            }
        }
    }

    @Override // d.a.q0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }
}
