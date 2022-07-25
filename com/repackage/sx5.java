package com.repackage;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.TbLiveContainer;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
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
public class sx5 extends ix5<uy5> implements bk5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int Y;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public TextView B;
    public TBLottieAnimationView C;
    public TextView D;
    public LinearLayout E;
    public View F;
    public FrameLayout G;
    public TBLottieAnimationView H;
    public View I;
    public TextView J;
    public TextView K;
    public LinearLayout L;
    public TextView M;
    public ImageView N;
    public TbLiveContainer O;
    public ViewGroup P;
    public ImageView Q;
    public TextView R;
    public TextView S;
    public TbImageView T;
    public boolean U;
    public int V;
    public View.OnClickListener W;
    public CustomMessageListener X;
    public FrameLayout v;
    public LinearLayout w;
    public CardUserInfoLayout x;
    public TextView y;
    public RelativeLayout z;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx5 a;

        public a(sx5 sx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx5Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.H.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx5 a;

        public b(sx5 sx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx5Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.C.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.C.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx5 a;

        public c(sx5 sx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e() == null) {
                return;
            }
            this.a.e().a(view2, this.a.k);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(sx5 sx5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.a.k) == 0 || ((uy5) t).a == null || ((uy5) t).a.getTid() == null || this.a.y == null || !((String) customResponsedMessage.getData()).equals(((uy5) this.a.k).a.getTid())) {
                return;
            }
            sx5 sx5Var = this.a;
            ux5.l(sx5Var.y, ((uy5) sx5Var.k).a.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755305151, "Lcom/repackage/sx5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755305151, "Lcom/repackage/sx5;");
                return;
            }
        }
        Y = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sx5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.U = false;
        this.V = 0;
        this.W = new c(this);
        this.X = new d(this, 2001390);
        this.i = tbPageContext;
        this.j = bdUniqueId;
        R(h());
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CardUserInfoLayout cardUserInfoLayout = this.x;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getAvatar();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public TbLiveContainer N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.O : (TbLiveContainer) invokeV.objValue;
    }

    public View O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.U) {
                CardUserInfoLayout cardUserInfoLayout = this.x;
                if (cardUserInfoLayout != null) {
                    return cardUserInfoLayout.getUserName();
                }
                return null;
            }
            return this.y;
        }
        return (View) invokeV.objValue;
    }

    public void P() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (an4.c().g() && (t = this.k) != 0 && ((uy5) t).getThreadData() != null && ((uy5) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.A.setPlaceHolder(3);
                this.A.J(((uy5) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T t = this.k;
            if (t != 0 && ((uy5) t).getThreadData() != null && ((uy5) this.k).getThreadData().getThreadAlaInfo() != null && ((uy5) this.k).getThreadData().getThreadAlaInfo().mYyExtData != null) {
                String str = ((uy5) this.k).getThreadData().getThreadAlaInfo().mYyExtData.mRankShow;
                if (TextUtils.isEmpty(str)) {
                    this.P.setVisibility(8);
                    return;
                } else if (!S()) {
                    this.P.setVisibility(8);
                    return;
                } else if (!UbsABTestHelper.isHotRankShowABTest()) {
                    this.P.setVisibility(8);
                    return;
                } else {
                    try {
                        String substring = str.substring(0, 3);
                        String substring2 = str.substring(3);
                        this.R.setText(substring);
                        this.S.setText(substring2);
                        this.P.setVisibility(0);
                        return;
                    } catch (Exception e) {
                        this.P.setVisibility(8);
                        e.printStackTrace();
                        return;
                    }
                }
            }
            this.P.setVisibility(8);
        }
    }

    public final void R(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.v = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09122d);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b8);
            this.w = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f09050f);
            this.x = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.i);
            this.x.setPageUniqueId(this.j);
            this.y = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fe5);
            this.z = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a7e);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e46);
            this.A = tbImageView;
            tbImageView.setDrawCorner(true);
            this.A.setPlaceHolder(3);
            this.A.setDefaultResource(0);
            this.A.setRadiusById(R.string.J_X05);
            this.A.setConrers(15);
            this.A.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.A.setBorderSurroundContent(true);
            this.A.setDrawBorder(true);
            this.G = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901e5);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901e6);
            this.H = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.H, R.raw.obfuscated_res_0x7f110021);
            this.H.addOnAttachStateChangeListener(new a(this));
            this.I = view2.findViewById(R.id.obfuscated_res_0x7f0901e7);
            this.J = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ef);
            this.K = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918db);
            this.E = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901e4);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901e3);
            this.C = tBLottieAnimationView2;
            tBLottieAnimationView2.loop(true);
            SkinManager.setLottieAnimation(this.C, R.raw.ala_live2);
            this.C.addOnAttachStateChangeListener(new b(this));
            this.P = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0901ea);
            this.Q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901e9);
            this.R = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ec);
            this.S = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901eb);
            this.T = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0912ee);
            this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918d9);
            this.F = view2.findViewById(R.id.obfuscated_res_0x7f0918da);
            this.B = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ed);
            this.q = (ForumEnterLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904dc);
            this.l = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904ab);
            this.m = (ThreadCardBottomOpSegmentWeightLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904ac);
            this.l.setUseDynamicLikeRes();
            this.l.setNeedMatchStrategy(false);
            this.m.setUseDynamicLikeRes();
            this.m.setNeedMatchStrategy(false);
            t(this.l);
            t(this.m);
            this.w.setOnClickListener(this);
            this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a18);
            this.M = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09223b);
            this.N = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e34);
            this.O = (TbLiveContainer) view2.findViewById(R.id.obfuscated_res_0x7f091f8a);
            this.L.setOnClickListener(this);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f0904aa);
            HomeGroupUbsUIHelper.handleImgMask(view2.findViewById(R.id.obfuscated_res_0x7f090e2d), R.color.transparent);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.k;
            if (t == 0 || ((uy5) t).getThreadData() == null) {
                return false;
            }
            return ((uy5) this.k).getThreadData().isFromHomPage;
        }
        return invokeV.booleanValue;
    }

    public final void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.b;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void U(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.k);
            }
            T t = this.k;
            if (t == 0 || ((uy5) t).getThreadData() == null || ((uy5) this.k).getThreadData().getThreadAlaInfo() == null) {
                return;
            }
            AlaInfoData threadAlaInfo = ((uy5) this.k).getThreadData().getThreadAlaInfo();
            ux5.a(((uy5) this.k).a.getId());
            ux5.l(this.y, ((uy5) this.k).a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (threadAlaInfo.isLegalYYLiveData()) {
                if (((uy5) this.k).getThreadData().isFromHomPage) {
                    str = YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                } else {
                    str = ((uy5) this.k).getThreadData().isFromConcern ? YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD : YYLiveUtil.SOURCE_NOT_DEFINE;
                }
                String str2 = str;
                TbPageContext<?> tbPageContext = this.i;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str3 = yyExtData.mSid;
                String str4 = yyExtData.mSsid;
                String str5 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, str2);
                W(((uy5) this.k).getThreadData().getTid(), String.valueOf(((uy5) this.k).getThreadData().getFid()), String.valueOf(threadAlaInfo.roomId), String.valueOf(threadAlaInfo.live_id), threadAlaInfo.mYyExtData.mSid);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: V */
    public void i(uy5 uy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uy5Var) == null) {
            this.k = uy5Var;
            if (S()) {
                y(true);
            }
            X();
        }
    }

    public final void W(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, str, str2, str3, str4, str5) == null) {
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            T t = this.k;
            if (t != 0 && ((uy5) t).getThreadData() != null) {
                this.v.setVisibility(0);
                int k = pi.k(this.i.getPageActivity());
                if (k != this.V) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.z.setLayoutParams(layoutParams);
                    this.V = k;
                }
                if (((uy5) this.k).getThreadData().getThreadAlaInfo() != null && ((uy5) this.k).getThreadData().getThreadAlaInfo().isChushou) {
                    this.l.setShowFlag(10);
                    this.l.hideShareContainer();
                } else {
                    this.l.setShowFlag(11);
                    this.l.resetShareContainer();
                }
                this.x.setVisibility(0);
                this.x.setData(((uy5) this.k).getThreadData());
                this.x.setUserAfterClickListener(this.W);
                ((uy5) this.k).getThreadData().parser_title();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((uy5) this.k).getThreadData().getSpan_str());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setText(spannableStringBuilder);
                    this.y.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.y, ((uy5) this.k).getThreadData());
                }
                if (S()) {
                    this.G.setVisibility(0);
                    this.E.setVisibility(8);
                    ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).addRule(1, R.id.obfuscated_res_0x7f0901e5);
                    ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).addRule(6, R.id.obfuscated_res_0x7f0901e5);
                    if (((uy5) this.k).a.getThreadAlaInfo().audience_count > 0) {
                        this.K.setVisibility(0);
                        this.K.setText(String.format(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f01fe), StringHelper.numFormatOverWan(((uy5) this.k).a.getThreadAlaInfo().audience_count)));
                    } else {
                        this.K.setVisibility(8);
                    }
                } else {
                    this.G.setVisibility(8);
                    this.E.setVisibility(0);
                    ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).addRule(1, R.id.obfuscated_res_0x7f0901e4);
                    ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).addRule(6, R.id.obfuscated_res_0x7f0901e4);
                    if (((uy5) this.k).a.getThreadAlaInfo().audience_count > 0) {
                        this.F.setVisibility(0);
                        this.D.setVisibility(0);
                        this.D.setText(String.format(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f01fd), StringHelper.numFormatOverWan(((uy5) this.k).a.getThreadAlaInfo().audience_count)));
                    } else {
                        this.F.setVisibility(8);
                        this.D.setVisibility(8);
                    }
                }
                this.P.setVisibility(8);
                this.B.setVisibility(8);
                if (((uy5) this.k).a.getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((uy5) this.k).a.getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.B.setVisibility(0);
                        this.B.setText(str);
                    } else {
                        String latitude = ((uy5) this.k).a.getLatitude();
                        String longtitude = ((uy5) this.k).a.getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = ab8.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && pi.g(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.B.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0243));
                                this.B.setVisibility(0);
                            }
                        }
                    }
                }
                if (((uy5) this.k).a.getThreadAlaInfo() != null && !StringUtils.isNull(((uy5) this.k).a.getThreadAlaInfo().forumUserLiveMsg)) {
                    this.L.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((uy5) this.k).a.getThreadAlaInfo().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                    this.M.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f021a));
                } else {
                    this.L.setVisibility(8);
                }
                z(true);
                D(this.v);
                j(this.i, TbadkCoreApplication.getInst().getSkinType());
                if (ux5.k(((uy5) this.k).a.getId())) {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0105, 1);
                }
                P();
                if (S()) {
                    this.H.playAnimation();
                } else {
                    this.C.playAnimation();
                }
                this.O.b(((uy5) this.k).a);
                this.O.setStaticsLocationPage("1");
                a0();
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void Y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || bdUniqueId == null || this.l == null || this.X == null) {
            return;
        }
        o(bdUniqueId);
        x(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.x;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.U = z;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            T t = this.k;
            if (t != 0 && ((uy5) t).getThreadData() != null && ((uy5) this.k).getThreadData().getThreadAlaInfo() != null && ((uy5) this.k).getThreadData().getThreadAlaInfo().mYyExtData != null) {
                if (!S()) {
                    this.T.setVisibility(8);
                    return;
                } else if (!UbsABTestHelper.isLiveCardGameShow()) {
                    this.T.setVisibility(8);
                    return;
                } else {
                    String str = ((uy5) this.k).getThreadData().getThreadAlaInfo().mYyExtData.mIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        this.T.setVisibility(8);
                        return;
                    }
                    this.T.setVisibility(0);
                    this.T.setPlaceHolder(0);
                    this.T.J(str, 10, false);
                    return;
                }
            }
            this.T.setVisibility(8);
        }
    }

    @Override // com.repackage.bk5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
        }
    }

    public void b0(int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || (threadCommentAndPraiseInfoLayout = this.l) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.R = String.valueOf(i);
    }

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? R.layout.obfuscated_res_0x7f0d018f : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        w(tbPageContext, i);
        vr4 d2 = vr4.d(this.w);
        d2.n(R.string.J_X06);
        d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
        float f = pi.f(getContext(), R.dimen.tbds31);
        float[] fArr = {f, f, f, f, f, f, f, f};
        SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(pi.f(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(Y).into(this.L);
        SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.N, R.drawable.obfuscated_res_0x7f08065a, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.x.onChangeSkinType(g(), TbadkCoreApplication.getInst().getSkinType());
        this.O.d(i);
        this.A.setPlaceHolder(3);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0310).into(this.I);
        vr4 d3 = vr4.d(this.G);
        d3.n(R.string.J_X01);
        d3.f(R.color.CAM_X0605);
        vr4 d4 = vr4.d(this.J);
        d4.v(R.color.CAM_X0101);
        d4.z(R.dimen.T_X09);
        vr4 d5 = vr4.d(this.K);
        d5.z(R.dimen.T_X09);
        d5.v(R.color.CAM_X0101);
        SkinManager.setBackgroundEndColorToAutoColor(this.E, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, fArr);
        SkinManager.setBackgroundColor(this.F, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0101);
        vr4 d6 = vr4.d(this.P);
        d6.n(R.string.J_X01);
        d6.f(R.color.CAM_X0605);
        this.Q.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0807aa, WebPManager.ResourceStateType.NORMAL_DISABLE));
        vr4.d(this.R).v(R.color.CAM_X0314);
        vr4.d(this.S).v(R.color.CAM_X0101);
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            if (view2 == this.w || view2 == this.l.getCommentContainer() || view2 == this.m.getCommentContainer() || view2 == this.L) {
                if (((uy5) this.k).getThreadData().getThreadAlaInfo() != null && ((uy5) this.k).getThreadData().getThreadAlaInfo().isChushou) {
                    T(((uy5) this.k).getThreadData().getThreadAlaInfo().thirdRoomId, ((uy5) this.k).getThreadData().getThreadAlaInfo().thirdLiveType);
                } else {
                    U(view2);
                }
            }
        }
    }
}
