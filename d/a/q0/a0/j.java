package d.a.q0.a0;

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
public class j extends d.a.q0.a0.a<d.a.q0.a0.e0.j> implements d.a.q0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public TbImageView B;
    public TBLottieAnimationView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public View G;
    public boolean H;
    public int I;
    public View.OnClickListener J;
    public CustomMessageListener K;
    public FrameLayout w;
    public LinearLayout x;
    public CardUserInfoLayout y;
    public TextView z;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f54383e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54383e = jVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54383e.C.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f54383e.C.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f54384e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54384e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54384e.h() == null) {
                return;
            }
            this.f54384e.h().a(view, this.f54384e.o);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f54385a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f54385a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.f54385a.o) == 0 || ((d.a.q0.a0.e0.j) t).f54338e == null || ((d.a.q0.a0.e0.j) t).f54338e.o1() == null || this.f54385a.z == null || !((String) customResponsedMessage.getData()).equals(((d.a.q0.a0.e0.j) this.f54385a.o).f54338e.o1())) {
                return;
            }
            j jVar = this.f54385a;
            TextView textView = jVar.z;
            String d0 = ((d.a.q0.a0.e0.j) jVar.o).f54338e.d0();
            int i2 = R.color.CAM_X0109;
            m.l(textView, d0, i2, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.H = false;
        this.I = 0;
        this.J = new b(this);
        this.K = new c(this, 2001390);
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
            if (this.H) {
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
            d.a.p0.b.g.b.h(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final void O(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f54320f;
            urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: P */
    public void l(d.a.q0.a0.e0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.o = jVar;
            Q();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            T t = this.o;
            if (t != 0 && ((d.a.q0.a0.e0.j) t).getThreadData() != null) {
                this.w.setVisibility(0);
                int k = d.a.d.e.p.l.k(this.m.getPageActivity());
                if (k != this.I) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.A.setLayoutParams(layoutParams);
                    this.I = k;
                }
                this.p.setShowFlag(11);
                this.p.resetShareContainer();
                this.y.setVisibility(0);
                this.y.setData(((d.a.q0.a0.e0.j) this.o).getThreadData());
                this.y.setUserAfterClickListener(this.J);
                if (((d.a.q0.a0.e0.j) this.o).getThreadData().h1() != null) {
                    this.z.setText(((d.a.q0.a0.e0.j) this.o).getThreadData().h1().friendRoomName);
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

    public void R(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.K == null) {
            return;
        }
        o(bdUniqueId);
        w(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.K.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.K);
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.H = z;
        }
    }

    public void T(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (threadCommentAndPraiseInfoLayout = this.p) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.S = String.valueOf(i2);
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i2) == null) || this.f54319e == i2) {
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
        this.y.onChangeSkinType(j(), TbadkCoreApplication.getInst().getSkinType());
        this.B.setPlaceHolder(3);
        this.f54319e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.x || view == this.p.getCommentContainer() || view == this.q.getCommentContainer()) {
                O(((d.a.q0.a0.e0.j) this.o).getThreadData().h1().live_id, ((d.a.q0.a0.e0.j) this.o).getThreadData().h1().roomId, this.H ? AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB : AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY);
                m.l(this.z, ((d.a.q0.a0.e0.j) this.o).f54338e.d0(), R.color.CAM_X0105, R.color.CAM_X0109);
                if (((d.a.q0.a0.e0.j) this.o).getThreadData() == null || ((d.a.q0.a0.e0.j) this.o).getThreadData().h1() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                statisticItem.param("obj_locate", this.H ? 2 : 1);
                statisticItem.param("obj_param1", ((d.a.q0.a0.e0.j) this.o).getThreadData().h1().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    @Override // d.a.q0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }
}
