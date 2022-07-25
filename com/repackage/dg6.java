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
import com.repackage.a68;
import com.repackage.ig6;
/* loaded from: classes5.dex */
public class dg6 extends jx5<ig6> implements eg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ig6 A;
    public int B;
    public jg6 C;
    public s68 D;
    public s68 E;
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
    public a68 y;
    public TbPageContext<?> z;

    /* loaded from: classes5.dex */
    public class a implements a68.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg6 a;

        public a(dg6 dg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg6Var;
        }

        @Override // com.repackage.a68.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.R0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.repackage.a68.t
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

    /* loaded from: classes5.dex */
    public class b implements a68.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg6 a;

        public b(dg6 dg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg6Var;
        }

        @Override // com.repackage.a68.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                dg6 dg6Var = this.a;
                dg6Var.onClick(dg6Var.i);
            }
        }

        @Override // com.repackage.a68.c0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                dg6 dg6Var = this.a;
                dg6Var.J(dg6Var.M ? "1" : "2");
                dg6 dg6Var2 = this.a;
                dg6Var2.onClick(dg6Var2.j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a68.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg6 a;

        public c(dg6 dg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg6Var;
        }

        @Override // com.repackage.a68.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    dg6 dg6Var = this.a;
                    a68 a68Var = dg6Var.y;
                    ig6 ig6Var = dg6Var.A;
                    a68Var.M1(ig6Var.n.d, ig6Var.b);
                    this.a.l.setVisibility(8);
                    this.a.J("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                dg6 dg6Var2 = this.a;
                dg6Var2.onClick(dg6Var2.j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a68.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg6 a;

        public d(dg6 dg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg6Var;
        }

        @Override // com.repackage.a68.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        dg6 dg6Var = this.a;
                        dg6Var.k.startAnimation(dg6Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    dg6 dg6Var2 = this.a;
                    dg6Var2.k.startAnimation(dg6Var2.K);
                }
            }
        }

        @Override // com.repackage.a68.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    dg6 dg6Var = this.a;
                    dg6Var.k.startAnimation(dg6Var.J);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg6 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ dg6 c;

        public e(dg6 dg6Var, cg6 cg6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg6Var, cg6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dg6Var;
            this.a = cg6Var;
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

    /* loaded from: classes5.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg6 a;
        public final /* synthetic */ dg6 b;

        public f(dg6 dg6Var, cg6 cg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg6Var, cg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dg6Var;
            this.a = cg6Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                ig6 ig6Var = this.b.A;
                if (ig6Var != null && ig6Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                cg6 cg6Var = this.a;
                if (cg6Var != null) {
                    cg6Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a68.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg6 a;

        public g(dg6 dg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg6Var;
        }

        @Override // com.repackage.a68.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg6(TbPageContext<?> tbPageContext, boolean z) {
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
        this.i = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f092381);
        FrameLayout frameLayout = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f09238d);
        this.j = frameLayout;
        a68 a68Var = new a68(tbPageContext, frameLayout, false);
        this.y = a68Var;
        a68Var.z1("2005");
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0920be);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090816);
        this.m = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f09146f);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091471);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091470);
        this.p = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f09231f);
        this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09232f);
        this.r = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0902b9);
        this.w = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f092042);
        this.x = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f09015a);
        this.s = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092045);
        this.t = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09204a);
        this.u = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f092044);
        this.v = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f092049);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        h.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.B = pi.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.B * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.p.setIsRound(true);
        this.C = new jg6(this.z, this);
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

    public final void B(ig6 ig6Var, int i, cg6 cg6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ig6Var, i, cg6Var) == null) || ig6Var == null || ig6Var.n == null) {
            return;
        }
        this.y.T1();
        this.y.j1(true);
        this.y.n1(new a(this));
        this.y.u1(new b(this));
        this.y.p1(new c(this));
        this.y.i1(false);
        s68 s68Var = new s68();
        this.D = s68Var;
        s68Var.c = ig6Var.b;
        s68Var.d = ig6Var.a;
        s68Var.e = TbadkCoreApplication.getCurrentAccount();
        s68 s68Var2 = new s68();
        this.E = s68Var2;
        s68Var2.c = ig6Var.b;
        s68Var2.d = ig6Var.a;
        s68Var2.e = TbadkCoreApplication.getCurrentAccount();
        if (this.N) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", ig6Var.b);
            statisticItem.param("nid", ig6Var.c);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, ig6Var.c());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", ig6Var.a);
            statisticItem.param("obj_locate", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            s68 s68Var3 = this.D;
            s68Var3.g = "auto_midpage";
            s68Var3.a = "13";
            s68Var3.i = "1";
            s68 s68Var4 = this.E;
            s68Var4.g = "auto_midpage";
            s68Var4.a = "auto_midpage";
            s68Var4.i = "1";
        } else {
            s68 s68Var5 = this.D;
            s68Var5.i = "frs_bavideotab";
            s68Var5.a = "12";
            s68 s68Var6 = this.E;
            s68Var6.i = "frs_bavideotab";
            s68Var6.a = "frs_bavideotab";
        }
        ig6.c cVar = ig6Var.n;
        if (cVar != null) {
            s68 s68Var7 = this.D;
            String str = cVar.c;
            s68Var7.m = str;
            this.E.m = str;
        }
        this.y.H0().setVideoStatData(this.D);
        this.y.q0();
        this.y.o1(new d(this));
        this.y.v1(new e(this, cg6Var, i));
        this.y.w1(new f(this, cg6Var));
        this.y.D1(ig6Var.n.j);
        this.y.H1(ig6Var.n.d, ig6Var.b);
        this.y.G1(ig6Var.l);
        this.y.r1(new g(this));
        this.y.X0();
        this.y.J1();
        if (ig6Var.s) {
            onClick(this.j);
            this.I = false;
            this.y.R1(ig6Var.n.d, ig6Var.b, null, new Object[0]);
        }
        this.I = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: C */
    public void i(ig6 ig6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ig6Var) == null) {
        }
    }

    public void D(ig6 ig6Var, int i, cg6 cg6Var) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, ig6Var, i, cg6Var) == null) || ig6Var == null || ig6Var.n == null) {
            return;
        }
        this.A = ig6Var;
        this.M = ig6Var.s;
        this.k.setVisibility(0);
        this.k.setText(ig6Var.l);
        this.l.setVisibility(0);
        this.l.setText(StringHelper.stringForVideoTime(ig6Var.n.e * 1000));
        long j = ig6Var.n.h;
        if (j == 0) {
            format = this.z.getString(R.string.obfuscated_res_0x7f0f14d4);
        } else {
            format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f14d3), Q(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.n.setText(format);
        this.m.setVisibility(8);
        B(ig6Var, i, cg6Var);
        M(ig6Var);
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
            I();
            jg6 jg6Var = this.C;
            if (jg6Var != null) {
                jg6Var.b();
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

    public void I() {
        a68 a68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a68Var = this.y) == null) {
            return;
        }
        a68Var.v0();
    }

    public final void J(String str) {
        ig6 ig6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (ig6Var = this.A) == null || ig6Var.n == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            h68.e(this.A.n.c, "", str, this.E, this.y.H0().getPcdnState());
        }
    }

    public void L(ig6 ig6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, ig6Var) == null) || ig6Var == null || ig6Var.m == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(ig6Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(ig6Var.m.a)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        if (ig6Var.m.e) {
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            this.r.setCompoundDrawables(null, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f0f87));
            return;
        }
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, pi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), pi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
        this.r.setCompoundDrawables(drawable, null, null, null);
        this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f02a7));
    }

    public void M(ig6 ig6Var) {
        ig6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ig6Var) == null) || ig6Var == null || (bVar = ig6Var.m) == null) {
            return;
        }
        this.q.setText(TextUtils.isEmpty(bVar.c) ? ig6Var.m.b : ig6Var.m.c);
        this.p.J(ig6Var.m.d, 12, false);
        this.p.setShowV(ig6Var.m.f);
        this.p.setIsBigV(ig6Var.m.f);
        L(ig6Var);
        O(ig6Var);
        N(ig6Var);
    }

    public void N(ig6 ig6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, ig6Var) == null) || ig6Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(ig6Var.d));
    }

    public void O(ig6 ig6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, ig6Var) == null) || ig6Var == null) {
            return;
        }
        if (ig6Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(ig6Var.e));
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

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01bd : invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.y.R0() : invokeV.booleanValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        ig6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i) == null) {
            if (this.a != i) {
                tbPageContext.getLayoutMode().k(i == 1);
                tbPageContext.getLayoutMode().j(h());
                SkinManager.setBackgroundColor(h(), R.color.CAM_X0201);
                ig6 ig6Var = this.A;
                if (ig6Var != null && (bVar = ig6Var.m) != null) {
                    if (bVar.e) {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                        this.r.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, pi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), pi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
                        this.r.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                ig6 ig6Var2 = this.A;
                if (ig6Var2 != null) {
                    if (ig6Var2.h) {
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

    @Override // com.repackage.eg6
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.repackage.eg6
    public void l() {
        ig6 ig6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (ig6Var = this.A) == null) {
            return;
        }
        boolean z = !ig6Var.h;
        ig6Var.h = z;
        if (z) {
            ig6Var.e++;
        } else {
            ig6Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(A());
        }
        O(this.A);
    }

    @Override // com.repackage.eg6
    public void m(boolean z) {
        ig6 ig6Var;
        ig6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (ig6Var = this.A) == null || (bVar = ig6Var.m) == null) {
            return;
        }
        bVar.e = z;
        L(ig6Var);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ig6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (e() != null) {
                view2.setTag(this);
                e().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != h()) {
                    if (view2 == this.o) {
                        ig6 ig6Var = this.A;
                        if (ig6Var == null || ig6Var.n == null) {
                            return;
                        }
                        this.m.setVisibility(8);
                        this.y.f1();
                        a68 a68Var = this.y;
                        ig6 ig6Var2 = this.A;
                        a68Var.M1(ig6Var2.n.d, ig6Var2.b);
                        J("2");
                        return;
                    } else if (view2 == this.r) {
                        ig6 ig6Var3 = this.A;
                        if (ig6Var3.m.e) {
                            return;
                        }
                        this.C.c(ig6Var3);
                        return;
                    } else if (view2 == this.x) {
                        q85 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
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
            ig6 ig6Var4 = this.A;
            if (ig6Var4 == null || (bVar = ig6Var4.m) == null || TextUtils.isEmpty(bVar.a)) {
                return;
            }
            if (TbadkCoreApplication.isLogin() && this.A.m.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(ng.g(this.A.m.a, 0L), z, this.A.m.f)));
        }
    }
}
