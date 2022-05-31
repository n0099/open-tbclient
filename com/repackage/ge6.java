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
import com.repackage.b48;
import com.repackage.le6;
/* loaded from: classes6.dex */
public class ge6 extends nv5<le6> implements he6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public le6 A;
    public int B;
    public me6 C;
    public t48 D;
    public t48 E;
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
    public b48 y;
    public TbPageContext<?> z;

    /* loaded from: classes6.dex */
    public class a implements b48.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge6 a;

        public a(ge6 ge6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge6Var;
        }

        @Override // com.repackage.b48.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.R0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.repackage.b48.t
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

    /* loaded from: classes6.dex */
    public class b implements b48.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge6 a;

        public b(ge6 ge6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge6Var;
        }

        @Override // com.repackage.b48.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                ge6 ge6Var = this.a;
                ge6Var.onClick(ge6Var.i);
            }
        }

        @Override // com.repackage.b48.c0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                ge6 ge6Var = this.a;
                ge6Var.K(ge6Var.M ? "1" : "2");
                ge6 ge6Var2 = this.a;
                ge6Var2.onClick(ge6Var2.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements b48.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge6 a;

        public c(ge6 ge6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge6Var;
        }

        @Override // com.repackage.b48.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    ge6 ge6Var = this.a;
                    b48 b48Var = ge6Var.y;
                    le6 le6Var = ge6Var.A;
                    b48Var.M1(le6Var.n.d, le6Var.b);
                    this.a.l.setVisibility(8);
                    this.a.K("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                ge6 ge6Var2 = this.a;
                ge6Var2.onClick(ge6Var2.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements b48.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge6 a;

        public d(ge6 ge6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge6Var;
        }

        @Override // com.repackage.b48.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        ge6 ge6Var = this.a;
                        ge6Var.k.startAnimation(ge6Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    ge6 ge6Var2 = this.a;
                    ge6Var2.k.startAnimation(ge6Var2.K);
                }
            }
        }

        @Override // com.repackage.b48.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    ge6 ge6Var = this.a;
                    ge6Var.k.startAnimation(ge6Var.J);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe6 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ge6 c;

        public e(ge6 ge6Var, fe6 fe6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var, fe6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ge6Var;
            this.a = fe6Var;
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
        public final /* synthetic */ fe6 a;
        public final /* synthetic */ ge6 b;

        public f(ge6 ge6Var, fe6 fe6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var, fe6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge6Var;
            this.a = fe6Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                le6 le6Var = this.b.A;
                if (le6Var != null && le6Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                fe6 fe6Var = this.a;
                if (fe6Var != null) {
                    fe6Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements b48.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge6 a;

        public g(ge6 ge6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge6Var;
        }

        @Override // com.repackage.b48.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge6(TbPageContext<?> tbPageContext, boolean z) {
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
        this.i = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f0922ea);
        FrameLayout frameLayout = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f0922f6);
        this.j = frameLayout;
        b48 b48Var = new b48(tbPageContext, frameLayout, false);
        this.y = b48Var;
        b48Var.z1("2005");
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092017);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090826);
        this.m = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f0913fa);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0913fc);
        this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0913fb);
        this.p = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f092288);
        this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092298);
        this.r = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902b7);
        this.w = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091f99);
        this.x = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090159);
        this.s = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091f9c);
        this.t = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091fa1);
        this.u = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f091f9b);
        this.v = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f091fa0);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        k.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.B = li.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.B * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.p.setIsRound(true);
        this.C = new me6(this.z, this);
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

    public final void C(le6 le6Var, int i, fe6 fe6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le6Var, i, fe6Var) == null) || le6Var == null || le6Var.n == null) {
            return;
        }
        this.y.T1();
        this.y.j1(true);
        this.y.n1(new a(this));
        this.y.u1(new b(this));
        this.y.p1(new c(this));
        this.y.i1(false);
        t48 t48Var = new t48();
        this.D = t48Var;
        t48Var.c = le6Var.b;
        t48Var.d = le6Var.a;
        t48Var.e = TbadkCoreApplication.getCurrentAccount();
        t48 t48Var2 = new t48();
        this.E = t48Var2;
        t48Var2.c = le6Var.b;
        t48Var2.d = le6Var.a;
        t48Var2.e = TbadkCoreApplication.getCurrentAccount();
        if (this.N) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", le6Var.b);
            statisticItem.param("nid", le6Var.c);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, le6Var.e());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", le6Var.a);
            statisticItem.param("obj_locate", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            t48 t48Var3 = this.D;
            t48Var3.g = "auto_midpage";
            t48Var3.a = "13";
            t48Var3.i = "1";
            t48 t48Var4 = this.E;
            t48Var4.g = "auto_midpage";
            t48Var4.a = "auto_midpage";
            t48Var4.i = "1";
        } else {
            t48 t48Var5 = this.D;
            t48Var5.i = "frs_bavideotab";
            t48Var5.a = "12";
            t48 t48Var6 = this.E;
            t48Var6.i = "frs_bavideotab";
            t48Var6.a = "frs_bavideotab";
        }
        le6.c cVar = le6Var.n;
        if (cVar != null) {
            t48 t48Var7 = this.D;
            String str = cVar.c;
            t48Var7.m = str;
            this.E.m = str;
        }
        this.y.H0().setVideoStatData(this.D);
        this.y.q0();
        this.y.o1(new d(this));
        this.y.v1(new e(this, fe6Var, i));
        this.y.w1(new f(this, fe6Var));
        this.y.D1(le6Var.n.j);
        this.y.H1(le6Var.n.d, le6Var.b);
        this.y.G1(le6Var.l);
        this.y.r1(new g(this));
        this.y.X0();
        this.y.J1();
        if (le6Var.s) {
            onClick(this.j);
            this.I = false;
            this.y.R1(le6Var.n.d, le6Var.b, null, new Object[0]);
        }
        this.I = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: D */
    public void l(le6 le6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, le6Var) == null) {
        }
    }

    public void E(le6 le6Var, int i, fe6 fe6Var) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, le6Var, i, fe6Var) == null) || le6Var == null || le6Var.n == null) {
            return;
        }
        this.A = le6Var;
        this.M = le6Var.s;
        this.k.setVisibility(0);
        this.k.setText(le6Var.l);
        this.l.setVisibility(0);
        this.l.setText(StringHelper.stringForVideoTime(le6Var.n.e * 1000));
        long j = le6Var.n.h;
        if (j == 0) {
            format = this.z.getString(R.string.obfuscated_res_0x7f0f1523);
        } else {
            format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f1522), Q(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.n.setText(format);
        this.m.setVisibility(8);
        C(le6Var, i, fe6Var);
        M(le6Var);
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
            me6 me6Var = this.C;
            if (me6Var != null) {
                me6Var.b();
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
        b48 b48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (b48Var = this.y) == null) {
            return;
        }
        b48Var.v0();
    }

    public final void K(String str) {
        le6 le6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (le6Var = this.A) == null || le6Var.n == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            i48.e(this.A.n.c, "", str, this.E, this.y.H0().getPcdnState());
        }
    }

    public void L(le6 le6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, le6Var) == null) || le6Var == null || le6Var.m == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(le6Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(le6Var.m.a)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        if (le6Var.m.e) {
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            this.r.setCompoundDrawables(null, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f0f98));
            return;
        }
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, li.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), li.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
        this.r.setCompoundDrawables(drawable, null, null, null);
        this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f02a4));
    }

    public void M(le6 le6Var) {
        le6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, le6Var) == null) || le6Var == null || (bVar = le6Var.m) == null) {
            return;
        }
        this.q.setText(TextUtils.isEmpty(bVar.c) ? le6Var.m.b : le6Var.m.c);
        this.p.K(le6Var.m.d, 12, false);
        this.p.setShowV(le6Var.m.f);
        this.p.setIsBigV(le6Var.m.f);
        L(le6Var);
        O(le6Var);
        N(le6Var);
    }

    public void N(le6 le6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, le6Var) == null) || le6Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(le6Var.d));
    }

    public void O(le6 le6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, le6Var) == null) || le6Var == null) {
            return;
        }
        if (le6Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(le6Var.e));
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

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c0 : invokeV.intValue;
    }

    @Override // com.repackage.he6
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.repackage.he6
    public void g() {
        le6 le6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (le6Var = this.A) == null) {
            return;
        }
        boolean z = !le6Var.h;
        le6Var.h = z;
        if (z) {
            le6Var.e++;
        } else {
            le6Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(B());
        }
        O(this.A);
    }

    @Override // com.repackage.he6
    public void h(boolean z) {
        le6 le6Var;
        le6.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (le6Var = this.A) == null || (bVar = le6Var.m) == null) {
            return;
        }
        bVar.e = z;
        L(le6Var);
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.y.R0() : invokeV.booleanValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        le6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, tbPageContext, i) == null) {
            if (this.a != i) {
                tbPageContext.getLayoutMode().k(i == 1);
                tbPageContext.getLayoutMode().j(k());
                SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
                le6 le6Var = this.A;
                if (le6Var != null && (bVar = le6Var.m) != null) {
                    if (bVar.e) {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                        this.r.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, li.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), li.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
                        this.r.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                le6 le6Var2 = this.A;
                if (le6Var2 != null) {
                    if (le6Var2.h) {
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
        le6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (e() != null) {
                view2.setTag(this);
                e().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != k()) {
                    if (view2 == this.o) {
                        le6 le6Var = this.A;
                        if (le6Var == null || le6Var.n == null) {
                            return;
                        }
                        this.m.setVisibility(8);
                        this.y.f1();
                        b48 b48Var = this.y;
                        le6 le6Var2 = this.A;
                        b48Var.M1(le6Var2.n.d, le6Var2.b);
                        K("2");
                        return;
                    } else if (view2 == this.r) {
                        le6 le6Var3 = this.A;
                        if (le6Var3.m.e) {
                            return;
                        }
                        this.C.c(le6Var3);
                        return;
                    } else if (view2 == this.x) {
                        z65 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
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
            le6 le6Var4 = this.A;
            if (le6Var4 == null || (bVar = le6Var4.m) == null || TextUtils.isEmpty(bVar.a)) {
                return;
            }
            if (TbadkCoreApplication.isLogin() && this.A.m.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(jg.g(this.A.m.a, 0L), z, this.A.m.f)));
        }
    }
}
