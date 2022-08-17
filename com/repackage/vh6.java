package com.repackage;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ai6;
import com.repackage.g88;
/* loaded from: classes7.dex */
public class vh6 extends bz5<ai6> implements wh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ai6 A;
    public int B;
    public bi6 C;
    public y88 D;
    public y88 E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public Animation J;
    public Animation K;
    public ScaleAnimation L;
    public boolean M;
    public boolean N;
    public FrameLayout i;
    public FrameLayout j;
    public TextView k;
    public TextView l;
    public FrameLayout m;
    public TextView n;
    public TextView o;
    public HeadImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public ImageView v;
    public LinearLayout w;
    public LinearLayout x;
    public g88 y;
    public TbPageContext<?> z;

    /* loaded from: classes7.dex */
    public class a implements g88.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh6 a;

        public a(vh6 vh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh6Var;
        }

        @Override // com.repackage.g88.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.R0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.repackage.g88.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.y.R0()) {
                    this.a.l.setVisibility(8);
                }
                if (this.a.I) {
                    this.a.y.T1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g88.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh6 a;

        public b(vh6 vh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh6Var;
        }

        @Override // com.repackage.g88.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                vh6 vh6Var = this.a;
                vh6Var.onClick(vh6Var.i);
            }
        }

        @Override // com.repackage.g88.c0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                vh6 vh6Var = this.a;
                vh6Var.K(vh6Var.M ? "1" : "2");
                vh6 vh6Var2 = this.a;
                vh6Var2.onClick(vh6Var2.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g88.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh6 a;

        public c(vh6 vh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh6Var;
        }

        @Override // com.repackage.g88.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    vh6 vh6Var = this.a;
                    g88 g88Var = vh6Var.y;
                    ai6 ai6Var = vh6Var.A;
                    g88Var.M1(ai6Var.n.d, ai6Var.b);
                    this.a.l.setVisibility(8);
                    this.a.K("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                vh6 vh6Var2 = this.a;
                vh6Var2.onClick(vh6Var2.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements g88.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh6 a;

        public d(vh6 vh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh6Var;
        }

        @Override // com.repackage.g88.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        vh6 vh6Var = this.a;
                        vh6Var.k.startAnimation(vh6Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    vh6 vh6Var2 = this.a;
                    vh6Var2.k.startAnimation(vh6Var2.K);
                }
            }
        }

        @Override // com.repackage.g88.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    vh6 vh6Var = this.a;
                    vh6Var.k.startAnimation(vh6Var.J);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh6 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ vh6 c;

        public e(vh6 vh6Var, uh6 uh6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var, uh6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vh6Var;
            this.a = uh6Var;
            this.b = i;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.H) {
                    this.c.I = true;
                    this.c.G = false;
                }
                if (this.a == null || this.c.H) {
                    return;
                }
                this.a.a(this.b);
                this.c.y.X0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh6 a;
        public final /* synthetic */ vh6 b;

        public f(vh6 vh6Var, uh6 uh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var, uh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vh6Var;
            this.a = uh6Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                ai6 ai6Var = this.b.A;
                if (ai6Var != null && ai6Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                uh6 uh6Var = this.a;
                if (uh6Var != null) {
                    uh6Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements g88.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh6 a;

        public g(vh6 vh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh6Var;
        }

        @Override // com.repackage.g88.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vh6(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
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
        this.G = true;
        this.N = z;
        View h = h();
        this.z = tbPageContext;
        this.i = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f0924a2);
        FrameLayout frameLayout = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f0924ae);
        this.j = frameLayout;
        g88 g88Var = new g88(tbPageContext, frameLayout, false);
        this.y = g88Var;
        g88Var.z1("2005");
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0921ba);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09084a);
        this.m = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f091519);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09151b);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09151a);
        this.p = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f092440);
        this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092450);
        this.r = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0902cc);
        this.w = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f09213e);
        this.x = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f090160);
        this.s = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092141);
        this.t = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092146);
        this.u = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f092140);
        this.v = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f092145);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        h.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.B = qi.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.B * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.p.setIsRound(true);
        this.C = new bi6(this.z, this);
        this.J = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f010034);
        this.K = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f01002b);
    }

    public final Animation A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.L == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.L = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.L;
        }
        return (Animation) invokeV.objValue;
    }

    public final void B(ai6 ai6Var, int i, uh6 uh6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ai6Var, i, uh6Var) == null) || ai6Var == null || ai6Var.n == null) {
            return;
        }
        this.y.T1();
        this.y.j1(true);
        this.y.n1(new a(this));
        this.y.u1(new b(this));
        this.y.p1(new c(this));
        this.y.i1(false);
        y88 y88Var = new y88();
        this.D = y88Var;
        y88Var.c = ai6Var.b;
        y88Var.d = ai6Var.a;
        y88Var.e = TbadkCoreApplication.getCurrentAccount();
        y88 y88Var2 = new y88();
        this.E = y88Var2;
        y88Var2.c = ai6Var.b;
        y88Var2.d = ai6Var.a;
        y88Var2.e = TbadkCoreApplication.getCurrentAccount();
        if (this.N) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", ai6Var.b);
            statisticItem.param("nid", ai6Var.c);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, ai6Var.c());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", ai6Var.a);
            statisticItem.param("obj_locate", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            y88 y88Var3 = this.D;
            y88Var3.g = "auto_midpage";
            y88Var3.a = "13";
            y88Var3.i = "1";
            y88 y88Var4 = this.E;
            y88Var4.g = "auto_midpage";
            y88Var4.a = "auto_midpage";
            y88Var4.i = "1";
        } else {
            y88 y88Var5 = this.D;
            y88Var5.i = "frs_bavideotab";
            y88Var5.a = "12";
            y88 y88Var6 = this.E;
            y88Var6.i = "frs_bavideotab";
            y88Var6.a = "frs_bavideotab";
        }
        ai6.c cVar = ai6Var.n;
        if (cVar != null) {
            y88 y88Var7 = this.D;
            String str = cVar.c;
            y88Var7.m = str;
            this.E.m = str;
        }
        this.y.H0().setVideoStatData(this.D);
        this.y.q0();
        this.y.o1(new d(this));
        this.y.v1(new e(this, uh6Var, i));
        this.y.w1(new f(this, uh6Var));
        this.y.D1(ai6Var.n.j);
        this.y.H1(ai6Var.n.d, ai6Var.b);
        this.y.G1(ai6Var.l);
        this.y.r1(new g(this));
        this.y.X0();
        this.y.J1();
        if (ai6Var.s) {
            onClick(this.j);
            this.I = false;
            this.y.R1(ai6Var.n.d, ai6Var.b, null, new Object[0]);
        }
        this.I = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bz5
    /* renamed from: C */
    public void i(ai6 ai6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ai6Var) == null) {
        }
    }

    public void D(ai6 ai6Var, int i, uh6 uh6Var) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, ai6Var, i, uh6Var) == null) || ai6Var == null || ai6Var.n == null) {
            return;
        }
        this.A = ai6Var;
        this.M = ai6Var.s;
        this.k.setVisibility(0);
        this.k.setText(ai6Var.l);
        this.l.setVisibility(0);
        this.l.setText(StringHelper.stringForVideoTime(ai6Var.n.e * 1000));
        long j = ai6Var.n.h;
        if (j == 0) {
            format = this.z.getString(R.string.obfuscated_res_0x7f0f151e);
        } else {
            format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f151d), Q(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.n.setText(format);
        this.m.setVisibility(8);
        B(ai6Var, i, uh6Var);
        M(ai6Var);
        j(this.z, TbadkCoreApplication.getInst().getSkinType());
    }

    public void E(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) || this.y == null || this.j == null || (tbPageContext = this.z) == null || tbPageContext.getPageActivity() == null || this.z.getPageActivity().getWindow() == null || !(this.z.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.z.getPageActivity().getWindow().getDecorView();
        if (this.G) {
            this.y.g1();
        }
        if (configuration.orientation == 2) {
            this.H = true;
            if (this.j.getParent() != null) {
                if (this.j.getParent() == frameLayout) {
                    frameLayout.removeView(this.j);
                } else {
                    ViewParent parent = this.j.getParent();
                    FrameLayout frameLayout2 = this.i;
                    if (parent == frameLayout2) {
                        frameLayout2.removeView(this.j);
                    }
                }
            }
            if (this.j.getParent() != null) {
                return;
            }
            frameLayout.addView(this.j);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.j.setLayoutParams(layoutParams);
        } else {
            this.H = false;
            if (this.j.getParent() != null) {
                if (this.j.getParent() == frameLayout) {
                    frameLayout.removeView(this.j);
                } else {
                    ViewParent parent2 = this.j.getParent();
                    FrameLayout frameLayout3 = this.i;
                    if (parent2 == frameLayout3) {
                        frameLayout3.removeView(this.j);
                    }
                }
            }
            if (this.j.getParent() != null) {
                return;
            }
            this.i.addView(this.j, 0);
            int i = this.B;
            this.j.setLayoutParams(new FrameLayout.LayoutParams(i, (int) (i * 0.5625f)));
            this.y.q0();
            this.G = true;
        }
        this.y.S0(this.z, configuration);
        this.l.setVisibility(8);
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            J();
            bi6 bi6Var = this.C;
            if (bi6Var != null) {
                bi6Var.b();
            }
        }
    }

    public boolean G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? this.y.b1(i) : invokeI.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && isPlaying()) {
            this.y.T0();
        }
    }

    public void J() {
        g88 g88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (g88Var = this.y) == null) {
            return;
        }
        g88Var.v0();
    }

    public final void K(String str) {
        ai6 ai6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (ai6Var = this.A) == null || ai6Var.n == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            n88.e(this.A.n.c, "", str, this.E, this.y.H0().getPcdnState());
        }
    }

    public void L(ai6 ai6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, ai6Var) == null) || ai6Var == null || ai6Var.m == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(ai6Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(ai6Var.m.a)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        if (ai6Var.m.e) {
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            this.r.setCompoundDrawables(null, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f0fbd));
            return;
        }
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, qi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), qi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
        this.r.setCompoundDrawables(drawable, null, null, null);
        this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f02ab));
    }

    public void M(ai6 ai6Var) {
        ai6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ai6Var) == null) || ai6Var == null || (bVar = ai6Var.m) == null) {
            return;
        }
        this.q.setText(TextUtils.isEmpty(bVar.c) ? ai6Var.m.b : ai6Var.m.c);
        this.p.K(ai6Var.m.d, 12, false);
        this.p.setShowV(ai6Var.m.f);
        this.p.setIsBigV(ai6Var.m.f);
        L(ai6Var);
        O(ai6Var);
        N(ai6Var);
    }

    public void N(ai6 ai6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, ai6Var) == null) || ai6Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(ai6Var.d));
    }

    public void O(ai6 ai6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, ai6Var) == null) || ai6Var == null) {
            return;
        }
        if (ai6Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(ai6Var.e));
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.setVisibility(8);
            this.y.T1();
            TextView textView = this.k;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
    }

    public String Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str : (String) invokeL.objValue;
    }

    @Override // com.repackage.bz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01be : invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.y.R0() : invokeV.booleanValue;
    }

    @Override // com.repackage.bz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        ai6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i) == null) {
            if (this.a != i) {
                tbPageContext.getLayoutMode().l(i == 1);
                tbPageContext.getLayoutMode().k(h());
                SkinManager.setBackgroundColor(h(), R.color.CAM_X0201);
                ai6 ai6Var = this.A;
                if (ai6Var != null && (bVar = ai6Var.m) != null) {
                    if (bVar.e) {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                        this.r.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, qi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), qi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
                        this.r.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                ai6 ai6Var2 = this.A;
                if (ai6Var2 != null) {
                    if (ai6Var2.h) {
                        this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
                    } else {
                        this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
                    }
                }
                SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
                this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
            }
            this.a = i;
        }
    }

    @Override // com.repackage.wh6
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.repackage.wh6
    public void l() {
        ai6 ai6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (ai6Var = this.A) == null) {
            return;
        }
        boolean z = !ai6Var.h;
        ai6Var.h = z;
        if (z) {
            ai6Var.e++;
        } else {
            ai6Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(A());
        }
        O(this.A);
    }

    @Override // com.repackage.wh6
    public void m(boolean z) {
        ai6 ai6Var;
        ai6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (ai6Var = this.A) == null || (bVar = ai6Var.m) == null) {
            return;
        }
        bVar.e = z;
        L(ai6Var);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ai6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (e() != null) {
                view2.setTag(this);
                e().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != h()) {
                    if (view2 == this.o) {
                        ai6 ai6Var = this.A;
                        if (ai6Var == null || ai6Var.n == null) {
                            return;
                        }
                        this.m.setVisibility(8);
                        this.y.f1();
                        g88 g88Var = this.y;
                        ai6 ai6Var2 = this.A;
                        g88Var.M1(ai6Var2.n.d, ai6Var2.b);
                        K("2");
                        return;
                    } else if (view2 == this.r) {
                        ai6 ai6Var3 = this.A;
                        if (ai6Var3.m.e) {
                            return;
                        }
                        this.C.c(ai6Var3);
                        return;
                    } else if (view2 == this.x) {
                        o95 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                        if (currentVisiblePageExtra != null) {
                            this.A.i = currentVisiblePageExtra.a();
                        }
                        this.C.d(this.A);
                        return;
                    } else {
                        return;
                    }
                } else if (this.A == null) {
                    return;
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.c);
                    pbActivityConfig.createNormalCfg(this.A.b, null, null);
                    if (!this.N) {
                        pbActivityConfig.setVideo_source("bavideotab");
                    } else {
                        pbActivityConfig.setVideo_source("auto_midpage");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                }
            }
            boolean z = false;
            ai6 ai6Var4 = this.A;
            if (ai6Var4 == null || (bVar = ai6Var4.m) == null || TextUtils.isEmpty(bVar.a)) {
                return;
            }
            if (TbadkCoreApplication.isLogin() && this.A.m.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(og.g(this.A.m.a, 0L), z, this.A.m.f)));
        }
    }
}
