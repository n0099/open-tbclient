package d.a.q0.v.d.c.f.d;

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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65009a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f65010b;

    /* renamed from: c  reason: collision with root package name */
    public View f65011c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f65012d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65013e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f65014f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f65015g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f65016h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f65017i;
    public int[] j;
    public b2 k;
    public d.a.q0.v.d.a.c l;
    public i m;
    public String n;
    public boolean o;
    public AlphaAnimation p;
    public boolean q;
    public boolean r;
    public View.OnClickListener s;

    /* loaded from: classes8.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65018a;

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
            this.f65018a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f65018a.r = false;
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
                this.f65018a.r = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f65019a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f65020b;

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
            this.f65020b = cVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f65020b.o && !this.f65020b.r) {
                if (StringUtils.isNull(this.f65019a) || !this.f65019a.equals(str)) {
                    c cVar = this.f65020b;
                    cVar.f65012d.startAnimation(cVar.p);
                    this.f65019a = str;
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

    /* renamed from: d.a.q0.v.d.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1759c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f65021e;

        public View$OnClickListenerC1759c(c cVar) {
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
            this.f65021e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f65021e.l == null || this.f65021e.l.f64863h == null || this.f65021e.m == null) {
                        return;
                    }
                    this.f65021e.m.a(this.f65021e.l);
                    return;
                }
                l.J(this.f65021e.f65010b.getPageActivity(), this.f65021e.f65010b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(324059463, "Ld/a/q0/v/d/c/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(324059463, "Ld/a/q0/v/d/c/f/d/c;");
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
        this.f65009a = 3;
        this.j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = false;
        this.q = true;
        this.r = false;
        BdUniqueId.gen();
        this.s = new View$OnClickListenerC1759c(this);
        this.f65010b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f65011c = inflate;
        this.f65012d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f65013e = (TextView) this.f65011c.findViewById(R.id.tvLiveCount);
        this.f65014f = (RelativeLayout) this.f65011c.findViewById(R.id.rlSquareLivePanel);
        this.f65015g = (TextView) this.f65011c.findViewById(R.id.tvUserName);
        this.f65016h = (LinearLayout) this.f65011c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f65011c.findViewById(R.id.ivUserAvatar);
        this.f65017i = headImageView;
        headImageView.setIsRound(true);
        this.f65017i.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f65011c.setOnClickListener(this.s);
        this.f65012d.setBorderSurroundContent(true);
        this.f65012d.setDrawBorder(true);
        this.f65012d.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65014f.getLayoutParams();
        int k = ((l.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k;
        layoutParams.height = k;
        this.f65014f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a(this));
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65011c : (View) invokeV.objValue;
    }

    public void i(d.a.q0.v.d.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            j(cVar, -1);
        }
    }

    public void j(d.a.q0.v.d.a.c cVar, int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i2) == null) {
            if (cVar != null && (b2Var = cVar.f64863h) != null && b2Var.h1() != null) {
                h().setVisibility(0);
                this.l = cVar;
                this.k = cVar.f64863h;
                int i3 = cVar.f64860e;
                if (TextUtils.isEmpty(cVar.f64862g)) {
                    String str = cVar.f64861f;
                } else {
                    String str2 = cVar.f64862g;
                }
                Object tag = this.f65012d.getTag();
                if (this.q) {
                    this.o = true;
                    this.q = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.k.h1().cover) && !((String) tag).equals(this.k.h1().cover)) {
                    this.o = true;
                } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.k.h1().cover) && !this.n.equals(this.k.h1().cover)) {
                    this.o = true;
                } else {
                    this.o = false;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.j);
                String str3 = this.k.h1().cover;
                this.n = str3;
                this.f65012d.setTag(str3);
                if (cVar.j) {
                    this.f65012d.setConrers(5);
                    gradientDrawable.setCornerRadii(v);
                    this.f65012d.setPlaceHolder(3);
                } else if (cVar.k) {
                    this.f65012d.setConrers(10);
                    gradientDrawable.setCornerRadii(w);
                    this.f65012d.setPlaceHolder(3);
                } else if (cVar.l) {
                    this.f65012d.setConrers(15);
                    gradientDrawable.setCornerRadii(u);
                    this.f65012d.setPlaceHolder(3);
                }
                this.f65012d.setRadius((int) t);
                this.f65012d.M(this.k.h1().cover, 10, false);
                this.f65016h.setBackgroundDrawable(gradientDrawable);
                this.f65012d.setEvent(new b(this));
                this.f65013e.setText(this.f65010b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.k.h1().audience_count)));
                if (this.k.H() != null) {
                    String name_show = this.k.H().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.f65015g.setText(name_show);
                    }
                    this.f65017i.M(this.k.H().getPortrait(), 12, false);
                }
                k(this.f65010b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            h().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f65009a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f65013e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f65015g, R.color.CAM_X0101);
        if (i2 == 1) {
            this.f65017i.setBorderColor(this.f65010b.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f65017i.setBorderColor(this.f65010b.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f65010b.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f65010b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f65010b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f65013e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f65013e.setCompoundDrawablePadding(this.f65010b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.f65009a = i2;
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.m = iVar;
        }
    }
}
