package com.repackage;

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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
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
/* loaded from: classes7.dex */
public class xr5 {
    public static /* synthetic */ Interceptable $ic;
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public View c;
    public TbImageView d;
    public TextView e;
    public RelativeLayout f;
    public TextView g;
    public LinearLayout h;
    public HeadImageView i;
    public int[] j;
    public ThreadData k;
    public iq5 l;
    public ds5 m;
    public String n;
    public boolean o;
    public AlphaAnimation p;
    public boolean q;
    public boolean r;
    public View.OnClickListener s;

    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr5 a;

        public a(xr5 xr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xr5Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.r = false;
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
                this.a.r = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ xr5 b;

        public b(xr5 xr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xr5Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.b.o && !this.b.r) {
                if (StringUtils.isNull(this.a) || !this.a.equals(str)) {
                    xr5 xr5Var = this.b;
                    xr5Var.d.startAnimation(xr5Var.p);
                    this.a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr5 a;

        public c(xr5 xr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xr5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (oi.z()) {
                    if (this.a.l == null || this.a.l.d == null || this.a.m == null) {
                        return;
                    }
                    this.a.m.a(this.a.l);
                    return;
                }
                qi.L(this.a.b.getPageActivity(), this.a.b.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c75));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755161962, "Lcom/repackage/xr5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755161962, "Lcom/repackage/xr5;");
                return;
            }
        }
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        t = dimension;
        u = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
        v = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension};
        w = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, 0.0f, 0.0f};
    }

    public xr5(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = false;
        this.q = true;
        this.r = false;
        BdUniqueId.gen();
        this.s = new c(this);
        this.b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0833, (ViewGroup) null, false);
        this.c = inflate;
        this.d = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090ea3);
        this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0922f2);
        this.f = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c01);
        this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0922ff);
        this.h = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092300);
        HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090fd4);
        this.i = headImageView;
        headImageView.setIsRound(true);
        this.i.setBorderWidth(qi.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.c.setOnClickListener(this.s);
        this.d.setBorderSurroundContent(true);
        this.d.setDrawBorder(true);
        this.d.setBorderWidth(qi.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        int k = ((qi.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k;
        layoutParams.height = k;
        this.f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a(this));
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void i(iq5 iq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iq5Var) == null) {
            j(iq5Var, -1);
        }
    }

    public void j(iq5 iq5Var, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, iq5Var, i) == null) {
            if (iq5Var != null && (threadData = iq5Var.d) != null && threadData.getThreadAlaInfo() != null) {
                h().setVisibility(0);
                this.l = iq5Var;
                this.k = iq5Var.d;
                int i2 = iq5Var.a;
                if (TextUtils.isEmpty(iq5Var.c)) {
                    String str = iq5Var.b;
                } else {
                    String str2 = iq5Var.c;
                }
                Object tag = this.d.getTag();
                if (this.q) {
                    this.o = true;
                    this.q = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.k.getThreadAlaInfo().cover) && !((String) tag).equals(this.k.getThreadAlaInfo().cover)) {
                    this.o = true;
                } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.k.getThreadAlaInfo().cover) && !this.n.equals(this.k.getThreadAlaInfo().cover)) {
                    this.o = true;
                } else {
                    this.o = false;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.j);
                String str3 = this.k.getThreadAlaInfo().cover;
                this.n = str3;
                this.d.setTag(str3);
                if (iq5Var.f) {
                    this.d.setConrers(5);
                    gradientDrawable.setCornerRadii(v);
                    this.d.setPlaceHolder(3);
                } else if (iq5Var.g) {
                    this.d.setConrers(10);
                    gradientDrawable.setCornerRadii(w);
                    this.d.setPlaceHolder(3);
                } else if (iq5Var.h) {
                    this.d.setConrers(15);
                    gradientDrawable.setCornerRadii(u);
                    this.d.setPlaceHolder(3);
                }
                this.d.setRadius((int) t);
                this.d.K(this.k.getThreadAlaInfo().cover, 10, false);
                this.h.setBackgroundDrawable(gradientDrawable);
                this.d.setEvent(new b(this));
                this.e.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0a1a, StringHelper.numberUniformFormatExtraWithRound(this.k.getThreadAlaInfo().audience_count)));
                if (this.k.getAuthor() != null) {
                    String name_show = this.k.getAuthor().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.g.setText(name_show);
                    }
                    this.i.K(this.k.getAuthor().getPortrait(), 12, false);
                }
                k(this.b, TbadkCoreApplication.getInst().getSkinType());
                if (iq5Var.d.getThreadAlaInfo().user_info != null) {
                    StatisticItem.make("c14718").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", iq5Var.getThreadData().getThreadAlaInfo().user_info.ala_id).param("obj_locate", 1).eventStat();
                    return;
                }
                return;
            }
            h().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
        if (i == 1) {
            this.i.setBorderColor(this.b.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.i.setBorderColor(this.b.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.b.getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.e.setCompoundDrawablePadding(this.b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.a = i;
    }

    public void l(ds5 ds5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ds5Var) == null) {
            this.m = ds5Var;
        }
    }
}
