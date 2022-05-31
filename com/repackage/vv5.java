package com.repackage;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AppPosInfo;
/* loaded from: classes7.dex */
public class vv5 extends mv5<yw5> implements bi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public TBLottieAnimationView B;
    public TextView C;
    public TextView D;
    public LinearLayout E;
    public View F;
    public boolean G;
    public int H;
    public View.OnClickListener I;
    public CustomMessageListener J;
    public FrameLayout v;
    public LinearLayout w;
    public CardUserInfoLayout x;
    public TextView y;
    public RelativeLayout z;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv5 a;

        public a(vv5 vv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv5Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.B.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.B.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv5 a;

        public b(vv5 vv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv5Var;
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
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vv5 vv5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv5Var, Integer.valueOf(i)};
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
            this.a = vv5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.a.k) == 0 || ((yw5) t).a == null || ((yw5) t).a.getTid() == null || this.a.y == null || !((String) customResponsedMessage.getData()).equals(((yw5) this.a.k).a.getTid())) {
                return;
            }
            vv5 vv5Var = this.a;
            yv5.l(vv5Var.y, ((yw5) vv5Var.k).a.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vv5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = false;
        this.H = 0;
        this.I = new b(this);
        this.J = new c(this, 2001390);
        this.i = tbPageContext;
        this.j = bdUniqueId;
        O(k());
    }

    public View L() {
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

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.G) {
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

    public void N() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (am4.c().g() && (t = this.k) != 0 && ((yw5) t).getThreadData() != null && ((yw5) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.A.setPlaceHolder(3);
                this.A.K(((yw5) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public final void O(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.v = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911bb);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c9);
            this.w = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f09052d);
            this.x = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.i);
            this.x.setPageUniqueId(this.j);
            this.y = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f3c);
            this.z = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a8e);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e4e);
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
            this.E = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901e4);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901e3);
            this.B = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.B, R.raw.ala_live2);
            this.B.addOnAttachStateChangeListener(new a(this));
            this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09185f);
            this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ed);
            this.F = view2.findViewById(R.id.obfuscated_res_0x7f091860);
            this.q = (ForumEnterLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904fa);
            this.l = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904c9);
            this.m = (ThreadCardBottomOpSegmentWeightLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904ca);
            if (UbsABTestHelper.isShowLikeAnimation()) {
                this.l.setUseDynamicLikeRes();
                this.l.setNeedMatchStrategy(false);
                this.m.setUseDynamicLikeRes();
                this.m.setNeedMatchStrategy(false);
            }
            u(this.l);
            u(this.m);
            this.w.setOnClickListener(this);
            HomeGroupUbsUIHelper.handleImgMask(view2.findViewById(R.id.obfuscated_res_0x7f090e35), R.color.transparent);
        }
    }

    public final void P(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.b;
            urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: Q */
    public void l(yw5 yw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yw5Var) == null) {
            this.k = yw5Var;
            R();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            T t = this.k;
            if (t != 0 && ((yw5) t).getThreadData() != null) {
                this.v.setVisibility(0);
                int k = li.k(this.i.getPageActivity());
                if (k != this.H) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.z.setLayoutParams(layoutParams);
                    this.H = k;
                }
                this.l.setShowFlag(11);
                this.l.resetShareContainer();
                this.x.setVisibility(0);
                this.x.setData(((yw5) this.k).getThreadData());
                this.x.setUserAfterClickListener(this.I);
                if (((yw5) this.k).getThreadData().getThreadAlaInfo() != null) {
                    this.y.setText(((yw5) this.k).getThreadData().getThreadAlaInfo().friendRoomName);
                }
                if (((yw5) this.k).a.getThreadAlaInfo().audience_count > 0) {
                    this.F.setVisibility(0);
                    this.C.setVisibility(0);
                    this.C.setText(String.format(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f01fb), StringHelper.numFormatOverWan(((yw5) this.k).a.getThreadAlaInfo().audience_count)));
                } else {
                    this.F.setVisibility(8);
                    this.C.setVisibility(8);
                }
                this.D.setVisibility(8);
                if (((yw5) this.k).a.getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((yw5) this.k).a.getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.D.setVisibility(0);
                        this.D.setText(str);
                    } else {
                        String latitude = ((yw5) this.k).a.getLatitude();
                        String longtitude = ((yw5) this.k).a.getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = y88.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && li.g(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.D.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0241));
                                this.D.setVisibility(0);
                            }
                        }
                    }
                }
                E(this.v);
                m(this.i, TbadkCoreApplication.getInst().getSkinType());
                if (yv5.k(((yw5) this.k).a.getId())) {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0105, 1);
                }
                N();
                this.B.playAnimation();
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void S(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) || bdUniqueId == null || this.l == null || this.J == null) {
            return;
        }
        o(bdUniqueId);
        y(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.x;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.J.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.J);
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.G = z;
        }
    }

    public void U(int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (threadCommentAndPraiseInfoLayout = this.l) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.R = String.valueOf(i);
    }

    @Override // com.repackage.bi5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.obfuscated_res_0x7f0d0192 : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        x(tbPageContext, i);
        wq4 d = wq4.d(this.w);
        d.n(R.string.J_X06);
        d.i(R.color.CAM_X0205, R.color.CAM_X0206);
        wq4 d2 = wq4.d(this.z);
        d2.l(R.dimen.L_X01);
        d2.k(R.color.CAM_X0401);
        d2.n(R.string.J_X05);
        d2.f(R.color.CAM_X0611);
        float f = li.f(getContext(), R.dimen.tbds31);
        SkinManager.setBackgroundEndColorToAutoColor(this.E, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{f, f, f, f, f, f, f, f});
        SkinManager.setBackgroundColor(this.F, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0101);
        this.x.onChangeSkinType(j(), TbadkCoreApplication.getInst().getSkinType());
        this.A.setPlaceHolder(3);
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            if (view2 == this.w || view2 == this.l.getCommentContainer() || view2 == this.m.getCommentContainer()) {
                P(((yw5) this.k).getThreadData().getThreadAlaInfo().live_id, ((yw5) this.k).getThreadData().getThreadAlaInfo().roomId, this.G ? AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB : AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY);
                yv5.l(this.y, ((yw5) this.k).a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                if (((yw5) this.k).getThreadData() == null || ((yw5) this.k).getThreadData().getThreadAlaInfo() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                statisticItem.param("obj_locate", this.G ? 2 : 1);
                statisticItem.param("obj_param1", ((yw5) this.k).getThreadData().getThreadAlaInfo().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
