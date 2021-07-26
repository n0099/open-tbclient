package d.a.q0.v.d.f.e.a;

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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.b1.j0;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.g.d.f;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65187a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f65188b;

    /* renamed from: c  reason: collision with root package name */
    public View f65189c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f65190d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65191e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f65192f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f65193g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65194h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65195i;
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

    /* renamed from: d.a.q0.v.d.f.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class animation.Animation$AnimationListenerC1768a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65196a;

        public animation.Animation$AnimationListenerC1768a(a aVar) {
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
            this.f65196a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f65196a.t = false;
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
                this.f65196a.t = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f65197a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f65198b;

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
            this.f65198b = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f65198b.q && !this.f65198b.t) {
                if (StringUtils.isNull(this.f65197a) || !this.f65197a.equals(str)) {
                    a aVar = this.f65198b;
                    aVar.f65190d.startAnimation(aVar.r);
                    this.f65197a = str;
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

    /* loaded from: classes8.dex */
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65199a;

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
            this.f65199a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                a aVar = this.f65199a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(aVar.l(aVar.v.getLoadedHeight(), this.f65199a.v.getLoadedWidth()), this.f65199a.w);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f65199a.f65188b.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.f65199a.v.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65200e;

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
            this.f65200e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f65200e.n == null || this.f65200e.n.h1() == null || this.f65200e.o == null) {
                        return;
                    }
                    this.f65200e.o.a(this.f65200e.l, this.f65200e.m, this.f65200e.n);
                    return;
                }
                l.J(this.f65200e.f65188b.getPageActivity(), this.f65200e.f65188b.getPageActivity().getString(R.string.no_network_guide));
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
        this.f65187a = 3;
        this.q = false;
        this.s = true;
        this.t = false;
        BdUniqueId.gen();
        this.u = 0;
        this.w = 0;
        this.x = new d(this);
        this.f65188b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.f65189c = inflate;
        this.f65190d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f65191e = (TextView) this.f65189c.findViewById(R.id.tvLiveFrom);
        this.f65192f = (TextView) this.f65189c.findViewById(R.id.tvLiveCount);
        this.f65193g = (RelativeLayout) this.f65189c.findViewById(R.id.rlSquareLivePanel);
        this.f65194h = (TextView) this.f65189c.findViewById(R.id.tvUserName);
        this.f65195i = (TextView) this.f65189c.findViewById(R.id.tv_extra);
        this.j = (LinearLayout) this.f65189c.findViewById(R.id.challenge_root);
        this.f65189c.setOnClickListener(this.x);
        this.f65190d.setBorderSurroundContent(true);
        this.f65190d.setDrawBorder(true);
        this.k = (ImageView) this.f65189c.findViewById(R.id.live_redpacket_label);
        this.v = (TbImageView) this.f65189c.findViewById(R.id.live_status_label);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new animation.Animation$AnimationListenerC1768a(this));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65189c : (View) invokeV.objValue;
    }

    public void n(d.a.q0.v.d.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            o(cVar, -1);
        }
    }

    public void o(d.a.q0.v.d.a.c cVar, int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, cVar, i2) == null) {
            if (cVar != null && (b2Var = cVar.f64863h) != null && b2Var.h1() != null) {
                if (this.u != l.k(this.f65189c.getContext())) {
                    this.u = l.k(this.f65189c.getContext());
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65193g.getLayoutParams();
                    int dimensionPixelSize = (this.u - (this.f65189c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    this.f65193g.setLayoutParams(layoutParams);
                }
                m().setVisibility(0);
                this.n = cVar.f64863h;
                this.l = cVar.f64860e;
                this.m = !TextUtils.isEmpty(cVar.f64862g) ? cVar.f64862g : cVar.f64861f;
                Object tag = this.f65190d.getTag();
                if (this.s) {
                    this.q = true;
                    this.s = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.n.h1().cover) && !((String) tag).equals(this.n.h1().cover)) {
                    this.q = true;
                } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.h1().cover) && !this.p.equals(this.n.h1().cover)) {
                    this.q = true;
                } else {
                    this.q = false;
                }
                String str = this.n.h1().cover;
                this.p = str;
                this.f65190d.setTag(str);
                this.f65190d.M(this.n.h1().cover, 10, false);
                this.f65190d.setEvent(new b(this));
                if (!StringUtils.isNull(this.n.L2)) {
                    this.v.setVisibility(0);
                    this.v.M(this.n.L2, 10, false);
                    this.v.setEvent(new c(this));
                } else {
                    this.v.setVisibility(8);
                }
                this.f65192f.setText(this.f65188b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.n.h1().audience_count)));
                if (this.n.H() != null) {
                    String name_show = this.n.H().getName_show();
                    if (j0.d(name_show) > 10) {
                        name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.f65194h.setText(name_show);
                }
                if (!StringUtils.isNull(this.n.W0)) {
                    this.f65195i.setVisibility(0);
                    this.j.setVisibility(8);
                    this.f65195i.setText(this.n.W0);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    float dimensionPixelSize2 = this.f65188b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                    gradientDrawable.setColor(-50901);
                    this.f65195i.setBackgroundDrawable(gradientDrawable);
                } else if (this.n.h1().label != null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    float dimensionPixelSize3 = this.f65188b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                    if (!StringUtils.isNull(this.n.h1().label.f53327b)) {
                        gradientDrawable2.setColor(Color.parseColor(this.n.h1().label.f53327b));
                    }
                    this.f65195i.setBackgroundDrawable(gradientDrawable2);
                    this.f65195i.setText(this.n.h1().label.f53326a);
                    this.f65195i.setVisibility(0);
                    this.j.setVisibility(8);
                } else if (this.n.h1().mChallengeInfoData != null && this.n.h1().mChallengeInfoData.challenge_id > 0) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    float dimensionPixelSize4 = this.f65188b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                    gradientDrawable3.setColor(-50901);
                    this.j.setBackground(gradientDrawable3);
                    this.j.setVisibility(0);
                    this.f65195i.setVisibility(8);
                } else {
                    this.f65195i.setVisibility(8);
                    this.j.setVisibility(8);
                }
                if (this.n.h1().haveRedpkg) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (this.n != null) {
                    if (i2 == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.n.o1());
                        TiebaStaticHelper.addYYParam(param);
                        TiebaStatic.log(param);
                    } else if (i2 == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.n.o1());
                        TiebaStaticHelper.addYYParam(param2);
                        TiebaStatic.log(param2);
                    }
                }
                p(this.f65188b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            m().setVisibility(4);
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.f65187a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f65193g, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f65192f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f65194h, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f65195i, R.color.CAM_X0111, 1, 0);
        SkinManager.getDrawable(this.f65188b.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f65188b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f65188b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
        this.f65192f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f65188b.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f65187a = i2;
    }

    public void q(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.o = fVar;
        }
    }
}
