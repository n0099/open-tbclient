package d.a.s0.v.d.f.e.a;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.z0.j0;
import d.a.s0.v.d.g.d.f;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67760a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f67761b;

    /* renamed from: c  reason: collision with root package name */
    public View f67762c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f67763d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67764e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f67765f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f67766g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f67767h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f67768i;
    public LinearLayout j;
    public ImageView k;
    public int l;
    public String m;
    public b2 n;
    public f o;
    public String p;
    public boolean q;
    public AlphaAnimation r;
    public boolean s;
    public boolean t;
    public int u;
    public TbImageView v;
    public int w;
    public View.OnClickListener x;

    /* renamed from: d.a.s0.v.d.f.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class animation.Animation$AnimationListenerC1807a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67769a;

        public animation.Animation$AnimationListenerC1807a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67769a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f67769a.t = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.f67769a.t = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f67770a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f67771b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67771b = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f67771b.q && !this.f67771b.t) {
                if (StringUtils.isNull(this.f67770a) || !this.f67770a.equals(str)) {
                    a aVar = this.f67771b;
                    aVar.f67763d.startAnimation(aVar.r);
                    this.f67770a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67772a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67772a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                a aVar = this.f67772a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(aVar.l(aVar.v.getLoadedHeight(), this.f67772a.v.getLoadedWidth()), this.f67772a.w);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f67772a.f67761b.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.f67772a.v.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67773e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67773e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f67773e.n == null || this.f67773e.n.g1() == null || this.f67773e.o == null) {
                        return;
                    }
                    this.f67773e.o.a(this.f67773e.l, this.f67773e.m, this.f67773e.n);
                    return;
                }
                l.J(this.f67773e.f67761b.getPageActivity(), this.f67773e.f67761b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67760a = 3;
        this.q = false;
        this.s = true;
        this.t = false;
        BdUniqueId.gen();
        this.u = 0;
        this.w = 0;
        this.x = new d(this);
        this.f67761b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.f67762c = inflate;
        this.f67763d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f67764e = (TextView) this.f67762c.findViewById(R.id.tvLiveFrom);
        this.f67765f = (TextView) this.f67762c.findViewById(R.id.tvLiveCount);
        this.f67766g = (RelativeLayout) this.f67762c.findViewById(R.id.rlSquareLivePanel);
        this.f67767h = (TextView) this.f67762c.findViewById(R.id.tvUserName);
        this.f67768i = (TextView) this.f67762c.findViewById(R.id.tv_extra);
        this.j = (LinearLayout) this.f67762c.findViewById(R.id.challenge_root);
        this.f67762c.setOnClickListener(this.x);
        this.f67763d.setBorderSurroundContent(true);
        this.f67763d.setDrawBorder(true);
        this.k = (ImageView) this.f67762c.findViewById(R.id.live_redpacket_label);
        this.v = (TbImageView) this.f67762c.findViewById(R.id.live_status_label);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new animation.Animation$AnimationListenerC1807a(this));
        this.w = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    }

    public final int l(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? (int) (this.w * (i3 / i2)) : invokeII.intValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67762c : (View) invokeV.objValue;
    }

    public void n(d.a.s0.v.d.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            o(cVar, -1);
        }
    }

    public void o(d.a.s0.v.d.a.c cVar, int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, cVar, i2) == null) {
            if (cVar != null && (b2Var = cVar.f67436h) != null && b2Var.g1() != null) {
                if (this.u != l.k(this.f67762c.getContext())) {
                    this.u = l.k(this.f67762c.getContext());
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f67766g.getLayoutParams();
                    int dimensionPixelSize = (this.u - (this.f67762c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    this.f67766g.setLayoutParams(layoutParams);
                }
                m().setVisibility(0);
                this.n = cVar.f67436h;
                this.l = cVar.f67433e;
                this.m = !TextUtils.isEmpty(cVar.f67435g) ? cVar.f67435g : cVar.f67434f;
                Object tag = this.f67763d.getTag();
                if (this.s) {
                    this.q = true;
                    this.s = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.n.g1().cover) && !((String) tag).equals(this.n.g1().cover)) {
                    this.q = true;
                } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.g1().cover) && !this.p.equals(this.n.g1().cover)) {
                    this.q = true;
                } else {
                    this.q = false;
                }
                String str = this.n.g1().cover;
                this.p = str;
                this.f67763d.setTag(str);
                this.f67763d.M(this.n.g1().cover, 10, false);
                this.f67763d.setEvent(new b(this));
                if (!StringUtils.isNull(this.n.L2)) {
                    this.v.setVisibility(0);
                    this.v.M(this.n.L2, 10, false);
                    this.v.setEvent(new c(this));
                } else {
                    this.v.setVisibility(8);
                }
                this.f67765f.setText(this.f67761b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.n.g1().audience_count)));
                if (this.n.H() != null) {
                    String name_show = this.n.H().getName_show();
                    if (j0.d(name_show) > 10) {
                        name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.f67767h.setText(name_show);
                }
                if (!StringUtils.isNull(this.n.W0)) {
                    this.f67768i.setVisibility(0);
                    this.j.setVisibility(8);
                    this.f67768i.setText(this.n.W0);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    float dimensionPixelSize2 = this.f67761b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                    gradientDrawable.setColor(-50901);
                    this.f67768i.setBackgroundDrawable(gradientDrawable);
                } else if (this.n.g1().label != null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    float dimensionPixelSize3 = this.f67761b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                    if (!StringUtils.isNull(this.n.g1().label.f55948b)) {
                        gradientDrawable2.setColor(Color.parseColor(this.n.g1().label.f55948b));
                    }
                    this.f67768i.setBackgroundDrawable(gradientDrawable2);
                    this.f67768i.setText(this.n.g1().label.f55947a);
                    this.f67768i.setVisibility(0);
                    this.j.setVisibility(8);
                } else if (this.n.g1().mChallengeInfoData != null && this.n.g1().mChallengeInfoData.challenge_id > 0) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    float dimensionPixelSize4 = this.f67761b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                    gradientDrawable3.setColor(-50901);
                    this.j.setBackground(gradientDrawable3);
                    this.j.setVisibility(0);
                    this.f67768i.setVisibility(8);
                } else {
                    this.f67768i.setVisibility(8);
                    this.j.setVisibility(8);
                }
                if (this.n.g1().haveRedpkg) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (this.n != null) {
                    if (i2 == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.n.n1());
                        TiebaStaticHelper.addYYParam(param);
                        TiebaStatic.log(param);
                    } else if (i2 == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.n.n1());
                        TiebaStaticHelper.addYYParam(param2);
                        TiebaStatic.log(param2);
                    }
                }
                p(this.f67761b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            m().setVisibility(4);
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.f67760a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f67766g, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f67765f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f67767h, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f67768i, R.color.CAM_X0111, 1, 0);
        SkinManager.getDrawable(this.f67761b.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f67761b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f67761b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
        this.f67765f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f67761b.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f67760a = i2;
    }

    public void q(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.o = fVar;
        }
    }
}
