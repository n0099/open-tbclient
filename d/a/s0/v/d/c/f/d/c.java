package d.a.s0.v.d.c.f.d;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67582a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f67583b;

    /* renamed from: c  reason: collision with root package name */
    public View f67584c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f67585d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67586e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f67587f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f67588g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f67589h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f67590i;
    public int[] j;
    public b2 k;
    public d.a.s0.v.d.a.c l;
    public i m;
    public String n;
    public boolean o;
    public AlphaAnimation p;
    public boolean q;
    public boolean r;
    public View.OnClickListener s;

    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67591a;

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
            this.f67591a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f67591a.r = false;
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
                this.f67591a.r = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f67592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f67593b;

        public b(c cVar) {
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
            this.f67593b = cVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f67593b.o && !this.f67593b.r) {
                if (StringUtils.isNull(this.f67592a) || !this.f67592a.equals(str)) {
                    c cVar = this.f67593b;
                    cVar.f67585d.startAnimation(cVar.p);
                    this.f67592a = str;
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

    /* renamed from: d.a.s0.v.d.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1798c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67594e;

        public View$OnClickListenerC1798c(c cVar) {
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
            this.f67594e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f67594e.l == null || this.f67594e.l.f67436h == null || this.f67594e.m == null) {
                        return;
                    }
                    this.f67594e.m.a(this.f67594e.l);
                    return;
                }
                l.J(this.f67594e.f67583b.getPageActivity(), this.f67594e.f67583b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-955804215, "Ld/a/s0/v/d/c/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-955804215, "Ld/a/s0/v/d/c/f/d/c;");
                return;
            }
        }
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        t = dimension;
        u = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
        v = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension};
        w = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, 0.0f, 0.0f};
    }

    public c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67582a = 3;
        this.j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = false;
        this.q = true;
        this.r = false;
        BdUniqueId.gen();
        this.s = new View$OnClickListenerC1798c(this);
        this.f67583b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f67584c = inflate;
        this.f67585d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f67586e = (TextView) this.f67584c.findViewById(R.id.tvLiveCount);
        this.f67587f = (RelativeLayout) this.f67584c.findViewById(R.id.rlSquareLivePanel);
        this.f67588g = (TextView) this.f67584c.findViewById(R.id.tvUserName);
        this.f67589h = (LinearLayout) this.f67584c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f67584c.findViewById(R.id.ivUserAvatar);
        this.f67590i = headImageView;
        headImageView.setIsRound(true);
        this.f67590i.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f67584c.setOnClickListener(this.s);
        this.f67585d.setBorderSurroundContent(true);
        this.f67585d.setDrawBorder(true);
        this.f67585d.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f67587f.getLayoutParams();
        int k = ((l.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k;
        layoutParams.height = k;
        this.f67587f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a(this));
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67584c : (View) invokeV.objValue;
    }

    public void i(d.a.s0.v.d.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            j(cVar, -1);
        }
    }

    public void j(d.a.s0.v.d.a.c cVar, int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i2) == null) {
            if (cVar != null && (b2Var = cVar.f67436h) != null && b2Var.g1() != null) {
                h().setVisibility(0);
                this.l = cVar;
                this.k = cVar.f67436h;
                int i3 = cVar.f67433e;
                if (TextUtils.isEmpty(cVar.f67435g)) {
                    String str = cVar.f67434f;
                } else {
                    String str2 = cVar.f67435g;
                }
                Object tag = this.f67585d.getTag();
                if (this.q) {
                    this.o = true;
                    this.q = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.k.g1().cover) && !((String) tag).equals(this.k.g1().cover)) {
                    this.o = true;
                } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.k.g1().cover) && !this.n.equals(this.k.g1().cover)) {
                    this.o = true;
                } else {
                    this.o = false;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.j);
                String str3 = this.k.g1().cover;
                this.n = str3;
                this.f67585d.setTag(str3);
                if (cVar.j) {
                    this.f67585d.setConrers(5);
                    gradientDrawable.setCornerRadii(v);
                    this.f67585d.setPlaceHolder(3);
                } else if (cVar.k) {
                    this.f67585d.setConrers(10);
                    gradientDrawable.setCornerRadii(w);
                    this.f67585d.setPlaceHolder(3);
                } else if (cVar.l) {
                    this.f67585d.setConrers(15);
                    gradientDrawable.setCornerRadii(u);
                    this.f67585d.setPlaceHolder(3);
                }
                this.f67585d.setRadius((int) t);
                this.f67585d.M(this.k.g1().cover, 10, false);
                this.f67589h.setBackgroundDrawable(gradientDrawable);
                this.f67585d.setEvent(new b(this));
                this.f67586e.setText(this.f67583b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.k.g1().audience_count)));
                if (this.k.H() != null) {
                    String name_show = this.k.H().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.f67588g.setText(name_show);
                    }
                    this.f67590i.M(this.k.H().getPortrait(), 12, false);
                }
                k(this.f67583b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            h().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f67582a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f67586e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f67588g, R.color.CAM_X0101);
        if (i2 == 1) {
            this.f67590i.setBorderColor(this.f67583b.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f67590i.setBorderColor(this.f67583b.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f67583b.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f67583b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f67583b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f67586e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f67586e.setCompoundDrawablePadding(this.f67583b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.f67582a = i2;
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.m = iVar;
        }
    }
}
