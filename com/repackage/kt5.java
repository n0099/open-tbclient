package com.repackage;

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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public View c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public RelativeLayout g;
    public TextView h;
    public TextView i;
    public LinearLayout j;
    public ImageView k;
    public int l;
    public String m;
    public ThreadData n;
    public du5 o;
    public String p;
    public boolean q;
    public AlphaAnimation r;
    public boolean s;
    public boolean t;
    public int u;
    public TbImageView v;
    public int w;
    public long x;
    public String y;
    public View.OnClickListener z;

    /* loaded from: classes6.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt5 a;

        public a(kt5 kt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kt5Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.t = false;
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
                this.a.t = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ kt5 b;

        public b(kt5 kt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kt5Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.b.q && !this.b.t) {
                if (StringUtils.isNull(this.a) || !this.a.equals(str)) {
                    kt5 kt5Var = this.b;
                    kt5Var.d.startAnimation(kt5Var.r);
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

    /* loaded from: classes6.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt5 a;

        public c(kt5 kt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kt5Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                kt5 kt5Var = this.a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(kt5Var.l(kt5Var.v.getLoadedHeight(), this.a.v.getLoadedWidth()), this.a.w);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.a.b.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.a.v.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt5 a;

        public d(kt5 kt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kt5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (oi.z()) {
                    if (this.a.n == null || this.a.n.getThreadAlaInfo() == null || this.a.o == null) {
                        return;
                    }
                    this.a.o.a(this.a.l, this.a.m, this.a.n);
                    return;
                }
                qi.K(this.a.b.getPageActivity(), this.a.b.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c76));
            }
        }
    }

    public kt5(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.q = false;
        this.s = true;
        this.t = false;
        BdUniqueId.gen();
        this.u = 0;
        this.w = 0;
        this.x = 0L;
        this.y = "";
        this.z = new d(this);
        this.b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0107, (ViewGroup) null, false);
        this.c = inflate;
        this.d = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090ea3);
        this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0922f3);
        this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0922f2);
        this.g = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c01);
        this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0922ff);
        this.i = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092334);
        this.j = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0905d8);
        this.c.setOnClickListener(this.z);
        this.d.setBorderSurroundContent(true);
        this.d.setDrawBorder(true);
        this.k = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09136f);
        this.v = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091393);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new a(this));
        this.w = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    }

    public final int l(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) ? (int) (this.w * (i2 / i)) : invokeII.intValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void n(iq5 iq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iq5Var) == null) {
            o(iq5Var, -1, this.x, this.y);
        }
    }

    public void o(iq5 iq5Var, int i, long j, String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{iq5Var, Integer.valueOf(i), Long.valueOf(j), str}) == null) {
            if (iq5Var != null && (threadData = iq5Var.d) != null && threadData.getThreadAlaInfo() != null) {
                if (this.u != qi.k(this.c.getContext())) {
                    this.u = qi.k(this.c.getContext());
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
                    int dimensionPixelSize = (this.u - (this.c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    this.g.setLayoutParams(layoutParams);
                }
                m().setVisibility(0);
                this.n = iq5Var.d;
                this.l = iq5Var.a;
                this.y = str;
                this.x = j;
                this.m = !TextUtils.isEmpty(iq5Var.c) ? iq5Var.c : iq5Var.b;
                Object tag = this.d.getTag();
                if (this.s) {
                    this.q = true;
                    this.s = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.n.getThreadAlaInfo().cover) && !((String) tag).equals(this.n.getThreadAlaInfo().cover)) {
                    this.q = true;
                } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.getThreadAlaInfo().cover) && !this.p.equals(this.n.getThreadAlaInfo().cover)) {
                    this.q = true;
                } else {
                    this.q = false;
                }
                String str2 = this.n.getThreadAlaInfo().cover;
                this.p = str2;
                this.d.setTag(str2);
                this.d.K(this.n.getThreadAlaInfo().cover, 10, false);
                this.d.setEvent(new b(this));
                if (!StringUtils.isNull(this.n.modeUrl)) {
                    this.v.setVisibility(0);
                    this.v.K(this.n.modeUrl, 10, false);
                    this.v.setEvent(new c(this));
                } else {
                    this.v.setVisibility(8);
                }
                this.f.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11db, StringHelper.numberUniformFormatExtra(this.n.getThreadAlaInfo().audience_count)));
                if (this.n.getAuthor() != null) {
                    String name_show = this.n.getAuthor().getName_show();
                    if (if5.d(name_show) > 10) {
                        name_show = if5.n(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.h.setText(name_show);
                }
                int i2 = 5;
                if (!StringUtils.isNull(this.n.mRecomExtra)) {
                    this.i.setVisibility(0);
                    this.j.setVisibility(8);
                    this.i.setText(this.n.mRecomExtra);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    float dimensionPixelSize2 = this.b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                    gradientDrawable.setColor(-50901);
                    this.i.setBackgroundDrawable(gradientDrawable);
                } else if (this.n.getThreadAlaInfo().label != null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    float dimensionPixelSize3 = this.b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                    if (!StringUtils.isNull(this.n.getThreadAlaInfo().label.b)) {
                        gradientDrawable2.setColor(Color.parseColor(this.n.getThreadAlaInfo().label.b));
                    }
                    this.i.setBackgroundDrawable(gradientDrawable2);
                    this.i.setText(this.n.getThreadAlaInfo().label.a);
                    this.i.setVisibility(0);
                    this.j.setVisibility(8);
                } else if (this.n.getThreadAlaInfo().mChallengeInfoData != null && this.n.getThreadAlaInfo().mChallengeInfoData.challenge_id > 0) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    float dimensionPixelSize4 = this.b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                    gradientDrawable3.setColor(-50901);
                    this.j.setBackground(gradientDrawable3);
                    this.j.setVisibility(0);
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                }
                if (this.n.getThreadAlaInfo().haveRedpkg) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (this.n != null) {
                    String str3 = TiebaStatic.YYValues.YY_LIVE;
                    if (i == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.n.getTid());
                        param.param("fid", this.x);
                        param.param("fname", this.y);
                        if (this.n.getThreadAlaInfo() == null || !this.n.getThreadAlaInfo().isLegalYYLiveData()) {
                            str3 = "";
                        } else {
                            i2 = YYLiveUtil.calculateLiveType(this.n.getThreadAlaInfo());
                            TiebaStaticHelper.addYYParam(param, this.n.getThreadAlaInfo().mYyExtData);
                        }
                        param.param("obj_param1", i2);
                        param.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param);
                    } else if (i == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.n.getTid());
                        param2.param("fid", this.x);
                        param2.param("fname", this.y);
                        int calculateLiveType = YYLiveUtil.calculateLiveType(this.n.getThreadAlaInfo());
                        if (this.n.getThreadAlaInfo() == null || !this.n.getThreadAlaInfo().isLegalYYLiveData()) {
                            str3 = "";
                        } else {
                            TiebaStaticHelper.addYYParam(param2, this.n.getThreadAlaInfo().mYyExtData);
                        }
                        param2.param("obj_param1", calculateLiveType);
                        param2.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param2);
                    }
                }
                p(this.b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            m().setVisibility(4);
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.g, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0111, 1, 0);
        SkinManager.getDrawable(this.b.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
        this.f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.b.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        this.a = i;
    }

    public void q(du5 du5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, du5Var) == null) {
            this.o = du5Var;
        }
    }
}
