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
import com.repackage.n68;
import com.repackage.ng6;
/* loaded from: classes6.dex */
public class ig6 extends rw5<ng6> implements jg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ng6 A;
    public int B;
    public og6 C;
    public f78 D;
    public f78 E;
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
    public n68 y;
    public TbPageContext<?> z;

    /* loaded from: classes6.dex */
    public class a implements n68.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig6 a;

        public a(ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig6Var;
        }

        @Override // com.repackage.n68.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.R0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.repackage.n68.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.y.R0()) {
                    this.a.l.setVisibility(8);
                }
                if (this.a.I) {
                    this.a.y.Y1();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements n68.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig6 a;

        public b(ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig6Var;
        }

        @Override // com.repackage.n68.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                ig6 ig6Var = this.a;
                ig6Var.onClick(ig6Var.i);
            }
        }

        @Override // com.repackage.n68.c0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                ig6 ig6Var = this.a;
                ig6Var.K(ig6Var.M ? "1" : "2");
                ig6 ig6Var2 = this.a;
                ig6Var2.onClick(ig6Var2.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements n68.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig6 a;

        public c(ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig6Var;
        }

        @Override // com.repackage.n68.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    ig6 ig6Var = this.a;
                    n68 n68Var = ig6Var.y;
                    ng6 ng6Var = ig6Var.A;
                    n68Var.R1(ng6Var.n.d, ng6Var.b);
                    this.a.l.setVisibility(8);
                    this.a.K("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                ig6 ig6Var2 = this.a;
                ig6Var2.onClick(ig6Var2.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements n68.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig6 a;

        public d(ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig6Var;
        }

        @Override // com.repackage.n68.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        ig6 ig6Var = this.a;
                        ig6Var.k.startAnimation(ig6Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    ig6 ig6Var2 = this.a;
                    ig6Var2.k.startAnimation(ig6Var2.K);
                }
            }
        }

        @Override // com.repackage.n68.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    ig6 ig6Var = this.a;
                    ig6Var.k.startAnimation(ig6Var.J);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hg6 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ig6 c;

        public e(ig6 ig6Var, hg6 hg6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var, hg6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ig6Var;
            this.a = hg6Var;
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

    /* loaded from: classes6.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hg6 a;
        public final /* synthetic */ ig6 b;

        public f(ig6 ig6Var, hg6 hg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var, hg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ig6Var;
            this.a = hg6Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                ng6 ng6Var = this.b.A;
                if (ng6Var != null && ng6Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                hg6 hg6Var = this.a;
                if (hg6Var != null) {
                    hg6Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements n68.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig6 a;

        public g(ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig6Var;
        }

        @Override // com.repackage.n68.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig6(TbPageContext<?> tbPageContext, boolean z) {
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
        View k = k();
        this.z = tbPageContext;
        this.i = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f0922ef);
        FrameLayout frameLayout = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f0922fc);
        this.j = frameLayout;
        n68 n68Var = new n68(tbPageContext, frameLayout, false);
        this.y = n68Var;
        n68Var.E1("2005");
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092012);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09084a);
        this.m = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f091422);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091424);
        this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091423);
        this.p = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f09228c);
        this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09229c);
        this.r = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902c3);
        this.w = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091f98);
        this.x = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090166);
        this.s = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091f9b);
        this.t = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091fa0);
        this.u = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f091f9a);
        this.v = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f091f9f);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        k.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.B = oi.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.B * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.p.setIsRound(true);
        this.C = new og6(this.z, this);
        this.J = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f010034);
        this.K = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f01002b);
    }

    public final Animation B() {
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

    public final void C(ng6 ng6Var, int i, hg6 hg6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ng6Var, i, hg6Var) == null) || ng6Var == null || ng6Var.n == null) {
            return;
        }
        this.y.Y1();
        this.y.l1(true);
        this.y.p1(new a(this));
        this.y.x1(new b(this));
        this.y.r1(new c(this));
        this.y.j1(false);
        f78 f78Var = new f78();
        this.D = f78Var;
        f78Var.c = ng6Var.b;
        f78Var.d = ng6Var.a;
        f78Var.e = TbadkCoreApplication.getCurrentAccount();
        f78 f78Var2 = new f78();
        this.E = f78Var2;
        f78Var2.c = ng6Var.b;
        f78Var2.d = ng6Var.a;
        f78Var2.e = TbadkCoreApplication.getCurrentAccount();
        if (this.N) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", ng6Var.b);
            statisticItem.param("nid", ng6Var.c);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, ng6Var.e());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", ng6Var.a);
            statisticItem.param("obj_locate", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            f78 f78Var3 = this.D;
            f78Var3.g = "auto_midpage";
            f78Var3.a = "13";
            f78Var3.i = "1";
            f78 f78Var4 = this.E;
            f78Var4.g = "auto_midpage";
            f78Var4.a = "auto_midpage";
            f78Var4.i = "1";
        } else {
            f78 f78Var5 = this.D;
            f78Var5.i = "frs_bavideotab";
            f78Var5.a = "12";
            f78 f78Var6 = this.E;
            f78Var6.i = "frs_bavideotab";
            f78Var6.a = "frs_bavideotab";
        }
        ng6.c cVar = ng6Var.n;
        if (cVar != null) {
            f78 f78Var7 = this.D;
            String str = cVar.c;
            f78Var7.m = str;
            this.E.m = str;
        }
        this.y.H0().setVideoStatData(this.D);
        this.y.q0();
        this.y.q1(new d(this));
        this.y.z1(new e(this, hg6Var, i));
        this.y.A1(new f(this, hg6Var));
        this.y.I1(ng6Var.n.j);
        this.y.M1(ng6Var.n.d, ng6Var.b);
        this.y.L1(ng6Var.l);
        this.y.u1(new g(this));
        this.y.X0();
        this.y.O1();
        if (ng6Var.s) {
            onClick(this.j);
            this.I = false;
            this.y.W1(ng6Var.n.d, ng6Var.b, null, new Object[0]);
        }
        this.I = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rw5
    /* renamed from: D */
    public void l(ng6 ng6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ng6Var) == null) {
        }
    }

    public void E(ng6 ng6Var, int i, hg6 hg6Var) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, ng6Var, i, hg6Var) == null) || ng6Var == null || ng6Var.n == null) {
            return;
        }
        this.A = ng6Var;
        this.M = ng6Var.s;
        this.k.setVisibility(0);
        this.k.setText(ng6Var.l);
        this.l.setVisibility(0);
        this.l.setText(StringHelper.stringForVideoTime(ng6Var.n.e * 1000));
        long j = ng6Var.n.h;
        if (j == 0) {
            format = this.z.getString(R.string.obfuscated_res_0x7f0f14e2);
        } else {
            format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f14e1), Q(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.n.setText(format);
        this.m.setVisibility(8);
        C(ng6Var, i, hg6Var);
        M(ng6Var);
        m(this.z, TbadkCoreApplication.getInst().getSkinType());
    }

    public void F(Configuration configuration) {
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

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            J();
            og6 og6Var = this.C;
            if (og6Var != null) {
                og6Var.b();
            }
        }
    }

    public boolean H(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? this.y.b1(i) : invokeI.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && isPlaying()) {
            this.y.T0();
        }
    }

    public void J() {
        n68 n68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (n68Var = this.y) == null) {
            return;
        }
        n68Var.v0();
    }

    public final void K(String str) {
        ng6 ng6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (ng6Var = this.A) == null || ng6Var.n == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            u68.e(this.A.n.c, "", str, this.E, this.y.H0().getPcdnState());
        }
    }

    public void L(ng6 ng6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, ng6Var) == null) || ng6Var == null || ng6Var.m == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(ng6Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(ng6Var.m.a)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        if (ng6Var.m.e) {
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            this.r.setCompoundDrawables(null, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f0f6d));
            return;
        }
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, oi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), oi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
        this.r.setCompoundDrawables(drawable, null, null, null);
        this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f029c));
    }

    public void M(ng6 ng6Var) {
        ng6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ng6Var) == null) || ng6Var == null || (bVar = ng6Var.m) == null) {
            return;
        }
        this.q.setText(TextUtils.isEmpty(bVar.c) ? ng6Var.m.b : ng6Var.m.c);
        this.p.K(ng6Var.m.d, 12, false);
        this.p.setShowV(ng6Var.m.f);
        this.p.setIsBigV(ng6Var.m.f);
        L(ng6Var);
        O(ng6Var);
        N(ng6Var);
    }

    public void N(ng6 ng6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, ng6Var) == null) || ng6Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(ng6Var.d));
    }

    public void O(ng6 ng6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, ng6Var) == null) || ng6Var == null) {
            return;
        }
        if (ng6Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(ng6Var.e));
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.setVisibility(8);
            this.y.Y1();
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

    @Override // com.repackage.rw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c9 : invokeV.intValue;
    }

    @Override // com.repackage.jg6
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.repackage.jg6
    public void g() {
        ng6 ng6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (ng6Var = this.A) == null) {
            return;
        }
        boolean z = !ng6Var.h;
        ng6Var.h = z;
        if (z) {
            ng6Var.e++;
        } else {
            ng6Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(B());
        }
        O(this.A);
    }

    @Override // com.repackage.jg6
    public void h(boolean z) {
        ng6 ng6Var;
        ng6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (ng6Var = this.A) == null || (bVar = ng6Var.m) == null) {
            return;
        }
        bVar.e = z;
        L(ng6Var);
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.y.R0() : invokeV.booleanValue;
    }

    @Override // com.repackage.rw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        ng6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, tbPageContext, i) == null) {
            if (this.a != i) {
                tbPageContext.getLayoutMode().k(i == 1);
                tbPageContext.getLayoutMode().j(k());
                SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
                ng6 ng6Var = this.A;
                if (ng6Var != null && (bVar = ng6Var.m) != null) {
                    if (bVar.e) {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                        this.r.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, oi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), oi.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
                        this.r.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                ng6 ng6Var2 = this.A;
                if (ng6Var2 != null) {
                    if (ng6Var2.h) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ng6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (e() != null) {
                view2.setTag(this);
                e().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != k()) {
                    if (view2 == this.o) {
                        ng6 ng6Var = this.A;
                        if (ng6Var == null || ng6Var.n == null) {
                            return;
                        }
                        this.m.setVisibility(8);
                        this.y.f1();
                        n68 n68Var = this.y;
                        ng6 ng6Var2 = this.A;
                        n68Var.R1(ng6Var2.n.d, ng6Var2.b);
                        K("2");
                        return;
                    } else if (view2 == this.r) {
                        ng6 ng6Var3 = this.A;
                        if (ng6Var3.m.e) {
                            return;
                        }
                        this.C.c(ng6Var3);
                        return;
                    } else if (view2 == this.x) {
                        p75 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
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
            ng6 ng6Var4 = this.A;
            if (ng6Var4 == null || (bVar = ng6Var4.m) == null || TextUtils.isEmpty(bVar.a)) {
                return;
            }
            if (TbadkCoreApplication.isLogin() && this.A.m.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(mg.g(this.A.m.a, 0L), z, this.A.m.f)));
        }
    }
}
