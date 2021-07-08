package d.a.p0.u0.h1;

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
import d.a.c.e.p.l;
import d.a.p0.n2.c;
import d.a.p0.n2.o;
import d.a.p0.u0.h1.g;
/* loaded from: classes8.dex */
public class b extends d.a.p0.a0.b<d.a.p0.u0.h1.g> implements d.a.p0.u0.h1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public d.a.p0.n2.c C;
    public TbPageContext<?> D;
    public d.a.p0.u0.h1.g E;
    public int F;
    public h G;
    public o H;
    public o I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public Animation N;
    public Animation O;
    public ScaleAnimation P;
    public boolean Q;
    public boolean R;
    public FrameLayout m;
    public FrameLayout n;
    public TextView o;
    public TextView p;
    public FrameLayout q;
    public TextView r;
    public TextView s;
    public HeadImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public ImageView y;
    public ImageView z;

    /* loaded from: classes8.dex */
    public class a implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62831a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62831a = bVar;
        }

        @Override // d.a.p0.n2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f62831a.C.T0()) {
                this.f62831a.p.setVisibility(8);
            }
        }

        @Override // d.a.p0.n2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f62831a.C.T0()) {
                    this.f62831a.p.setVisibility(8);
                }
                if (this.f62831a.M) {
                    this.f62831a.C.k2();
                }
            }
        }
    }

    /* renamed from: d.a.p0.u0.h1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1675b implements c.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62832a;

        public C1675b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62832a = bVar;
        }

        @Override // d.a.p0.n2.c.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62832a.p.setVisibility(8);
                b bVar = this.f62832a;
                bVar.onClick(bVar.m);
            }
        }

        @Override // d.a.p0.n2.c.g0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f62832a.M = false;
                this.f62832a.p.setVisibility(8);
                b bVar = this.f62832a;
                bVar.L(bVar.Q ? "1" : "2");
                b bVar2 = this.f62832a;
                bVar2.onClick(bVar2.n);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62833a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62833a = bVar;
        }

        @Override // d.a.p0.n2.c.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f62833a.D.showToast(this.f62833a.r.getText().toString());
                    b bVar = this.f62833a;
                    d.a.p0.n2.c cVar = bVar.C;
                    d.a.p0.u0.h1.g gVar = bVar.E;
                    cVar.d2(gVar.z.f62876d, gVar.f62849f);
                    this.f62833a.p.setVisibility(8);
                    this.f62833a.L("2");
                } else {
                    this.f62833a.q.setVisibility(0);
                }
                b bVar2 = this.f62833a;
                bVar2.onClick(bVar2.n);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements c.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62834a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62834a = bVar;
        }

        @Override // d.a.p0.n2.c.y
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.f62834a.C.T0()) {
                    this.f62834a.o.setVisibility(0);
                } else if (z) {
                    if (this.f62834a.o.getVisibility() == 0) {
                        this.f62834a.o.setVisibility(8);
                        b bVar = this.f62834a;
                        bVar.o.startAnimation(bVar.N);
                    }
                } else if (this.f62834a.o.getVisibility() == 8) {
                    this.f62834a.o.setVisibility(0);
                    b bVar2 = this.f62834a;
                    bVar2.o.startAnimation(bVar2.O);
                }
            }
        }

        @Override // d.a.p0.n2.c.y
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.f62834a.C.T0()) {
                    this.f62834a.o.setVisibility(0);
                } else if (this.f62834a.o.getVisibility() == 0) {
                    this.f62834a.o.setVisibility(8);
                    b bVar = this.f62834a;
                    bVar.o.startAnimation(bVar.N);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u0.h1.a f62835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f62836f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f62837g;

        public e(b bVar, d.a.p0.u0.h1.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62837g = bVar;
            this.f62835e = aVar;
            this.f62836f = i2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f62837g.L) {
                    this.f62837g.M = true;
                    this.f62837g.K = false;
                }
                if (this.f62835e == null || this.f62837g.L) {
                    return;
                }
                this.f62835e.a(this.f62836f);
                this.f62837g.C.a1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u0.h1.a f62838e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62839f;

        public f(b bVar, d.a.p0.u0.h1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62839f = bVar;
            this.f62838e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                d.a.p0.u0.h1.g gVar = this.f62839f.E;
                if (gVar != null && gVar.z != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f62839f.E.z.f62876d);
                }
                d.a.p0.u0.h1.a aVar = this.f62838e;
                if (aVar != null) {
                    aVar.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements c.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62840a;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62840a = bVar;
        }

        @Override // d.a.p0.n2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62840a.p.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K = true;
        this.R = z;
        View k = k();
        this.D = tbPageContext;
        this.m = (FrameLayout) k.findViewById(R.id.video_agg_container);
        FrameLayout frameLayout = (FrameLayout) k.findViewById(R.id.video_container);
        this.n = frameLayout;
        d.a.p0.n2.c cVar = new d.a.p0.n2.c(tbPageContext, frameLayout, false);
        this.C = cVar;
        cVar.O1("2005");
        this.o = (TextView) k.findViewById(R.id.title);
        this.p = (TextView) k.findViewById(R.id.duration);
        this.q = (FrameLayout) k.findViewById(R.id.mobile_network_container);
        this.r = (TextView) k.findViewById(R.id.mobile_network_text);
        this.s = (TextView) k.findViewById(R.id.mobile_network_play);
        this.t = (HeadImageView) k.findViewById(R.id.user_icon);
        this.u = (TextView) k.findViewById(R.id.user_name);
        this.v = (TextView) k.findViewById(R.id.attention);
        this.A = (LinearLayout) k.findViewById(R.id.thread_info_commont_container);
        this.B = (LinearLayout) k.findViewById(R.id.agree_view_container);
        this.w = (TextView) k.findViewById(R.id.thread_info_commont_num);
        this.x = (TextView) k.findViewById(R.id.thread_info_praise_num);
        this.y = (ImageView) k.findViewById(R.id.thread_info_commont_img);
        this.z = (ImageView) k.findViewById(R.id.thread_info_praise_img);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        k.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.F = l.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = (int) (this.F * 0.5625f);
        this.m.setLayoutParams(layoutParams);
        this.t.setIsRound(true);
        this.G = new h(this.D, this);
        this.N = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.O = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    public final Animation A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.P == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.P = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.P;
        }
        return (Animation) invokeV.objValue;
    }

    public final void B(d.a.p0.u0.h1.g gVar, int i2, d.a.p0.u0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.C.k2();
        this.C.s1(true);
        this.C.v1(false);
        this.C.y1(new a(this));
        this.C.G1(new C1675b(this));
        this.C.A1(new c(this));
        this.C.o1(false);
        o oVar = new o();
        this.H = oVar;
        oVar.f60811c = gVar.f62849f;
        oVar.f60812d = gVar.f62848e;
        oVar.f60813e = TbadkCoreApplication.getCurrentAccount();
        o oVar2 = new o();
        this.I = oVar2;
        oVar2.f60811c = gVar.f62849f;
        oVar2.f60812d = gVar.f62848e;
        oVar2.f60813e = TbadkCoreApplication.getCurrentAccount();
        if (this.R) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar.f62849f);
            statisticItem.param("nid", gVar.f62850g);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.h());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", gVar.f62848e);
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            o oVar3 = this.H;
            oVar3.f60815g = "auto_midpage";
            oVar3.f60809a = "13";
            oVar3.f60817i = "1";
            o oVar4 = this.I;
            oVar4.f60815g = "auto_midpage";
            oVar4.f60809a = "auto_midpage";
            oVar4.f60817i = "1";
        } else {
            o oVar5 = this.H;
            oVar5.f60817i = "frs_bavideotab";
            oVar5.f60809a = "12";
            o oVar6 = this.I;
            oVar6.f60817i = "frs_bavideotab";
            oVar6.f60809a = "frs_bavideotab";
        }
        g.c cVar = gVar.z;
        if (cVar != null) {
            o oVar7 = this.H;
            String str = cVar.f62875c;
            oVar7.m = str;
            this.I.m = str;
        }
        this.C.I0().setVideoStatData(this.H);
        this.C.q0();
        this.C.z1(new d(this));
        this.C.I1(new e(this, aVar, i2));
        this.C.J1(new f(this, aVar));
        this.C.S1(gVar.z.j);
        this.C.Y1(gVar.z.f62876d, gVar.f62849f);
        this.C.X1(gVar.x);
        this.C.D1(new g(this));
        this.C.a1();
        this.C.a2();
        if (gVar.F) {
            onClick(this.n);
            this.M = false;
            this.C.i2(gVar.z.f62876d, gVar.f62849f, null, new Object[0]);
        }
        this.M = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: F */
    public void l(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
        }
    }

    public void G(d.a.p0.u0.h1.g gVar, int i2, d.a.p0.u0.h1.a aVar) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.E = gVar;
        this.Q = gVar.F;
        this.o.setVisibility(0);
        this.o.setText(gVar.x);
        this.p.setVisibility(0);
        this.p.setText(StringHelper.stringForVideoTime(gVar.z.f62877e * 1000));
        long j = gVar.z.f62880h;
        if (j == 0) {
            format = this.D.getString(R.string.video_mobile_play_tips);
        } else {
            format = String.format(this.D.getString(R.string.video_mobile_network_tips), R(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.r.setText(format);
        this.q.setVisibility(8);
        B(gVar, i2, aVar);
        N(gVar);
        m(this.D, TbadkCoreApplication.getInst().getSkinType());
    }

    public void H(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) || this.C == null || this.n == null || (tbPageContext = this.D) == null || tbPageContext.getPageActivity() == null || this.D.getPageActivity().getWindow() == null || !(this.D.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.D.getPageActivity().getWindow().getDecorView();
        if (this.K) {
            this.C.k1();
        }
        if (configuration.orientation == 2) {
            this.L = true;
            if (this.n.getParent() != null) {
                if (this.n.getParent() == frameLayout) {
                    frameLayout.removeView(this.n);
                } else {
                    ViewParent parent = this.n.getParent();
                    FrameLayout frameLayout2 = this.m;
                    if (parent == frameLayout2) {
                        frameLayout2.removeView(this.n);
                    }
                }
            }
            if (this.n.getParent() != null) {
                return;
            }
            frameLayout.addView(this.n);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.n.setLayoutParams(layoutParams);
        } else {
            this.L = false;
            if (this.n.getParent() != null) {
                if (this.n.getParent() == frameLayout) {
                    frameLayout.removeView(this.n);
                } else {
                    ViewParent parent2 = this.n.getParent();
                    FrameLayout frameLayout3 = this.m;
                    if (parent2 == frameLayout3) {
                        frameLayout3.removeView(this.n);
                    }
                }
            }
            if (this.n.getParent() != null) {
                return;
            }
            this.m.addView(this.n, 0);
            int i2 = this.F;
            this.n.setLayoutParams(new FrameLayout.LayoutParams(i2, (int) (i2 * 0.5625f)));
            this.C.q0();
            this.K = true;
        }
        this.C.V0(this.D, configuration);
        this.p.setVisibility(8);
    }

    public boolean I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.C.f1(i2) : invokeI.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && isPlaying()) {
            this.C.W0();
        }
    }

    public void K() {
        d.a.p0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.C) == null) {
            return;
        }
        cVar.v0();
    }

    public final void L(String str) {
        d.a.p0.u0.h1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (gVar = this.E) == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            d.a.p0.n2.h.e(this.E.z.f62875c, "", str, this.I, this.C.I0().getPcdnState());
        }
    }

    public void M(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || gVar == null || gVar.y == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.y.f62859a) && TbadkCoreApplication.getCurrentAccount().equals(gVar.y.f62859a)) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        if (gVar.y.f62863e) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
            this.v.setCompoundDrawables(null, null, null, null);
            this.v.setText(this.D.getString(R.string.relate_forum_is_followed));
            return;
        }
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, l.g(this.f53778g, R.dimen.ds20), l.g(this.f53778g, R.dimen.ds20));
        this.v.setCompoundDrawables(drawable, null, null, null);
        this.v.setText(this.D.getString(R.string.attention));
    }

    public void N(d.a.p0.u0.h1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.u.setText(TextUtils.isEmpty(bVar.f62861c) ? gVar.y.f62860b : gVar.y.f62861c);
        this.t.M(gVar.y.f62862d, 12, false);
        this.t.setShowV(gVar.y.f62864f);
        this.t.setIsBigV(gVar.y.f62864f);
        M(gVar);
        P(gVar);
        O(gVar);
    }

    public void O(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) || gVar == null) {
            return;
        }
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106);
        this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.w.setText(StringHelper.numFormatOverWan(gVar.k));
    }

    public void P(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.p) {
            this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0301);
        } else {
            this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0106);
        }
        this.x.setText(StringHelper.numFormatOverWan(gVar.m));
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.q.setVisibility(8);
            this.C.k2();
            TextView textView = this.o;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.p;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
    }

    public String R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str : (String) invokeL.objValue;
    }

    @Override // d.a.p0.u0.h1.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.D.showToast(str);
        }
    }

    @Override // d.a.p0.u0.h1.c
    public void d() {
        d.a.p0.u0.h1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (gVar = this.E) == null) {
            return;
        }
        boolean z = !gVar.p;
        gVar.p = z;
        if (z) {
            gVar.m++;
        } else {
            gVar.m--;
        }
        ImageView imageView = this.z;
        if (imageView != null) {
            imageView.startAnimation(A());
        }
        P(this.E);
    }

    @Override // d.a.p0.u0.h1.c
    public void e(boolean z) {
        d.a.p0.u0.h1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (gVar = this.E) == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f62863e = z;
        M(gVar);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? R.layout.card_video_aggregation_layout : invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.C.T0() : invokeV.booleanValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, tbPageContext, i2) == null) {
            if (this.f53776e != i2) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(k());
                SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
                d.a.p0.u0.h1.g gVar = this.E;
                if (gVar != null && (bVar = gVar.y) != null) {
                    if (bVar.f62863e) {
                        SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
                        this.v.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, l.g(this.f53778g, R.dimen.ds20), l.g(this.f53778g, R.dimen.ds20));
                        this.v.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                d.a.p0.u0.h1.g gVar2 = this.E;
                if (gVar2 != null) {
                    if (gVar2.p) {
                        this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
                        SkinManager.setViewTextColor(this.x, R.color.CAM_X0301);
                    } else {
                        this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
                        SkinManager.setViewTextColor(this.x, R.color.CAM_X0106);
                    }
                }
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0106);
                this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
            }
            this.f53776e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
            if (h() != null) {
                view.setTag(this);
                h().a(view, this.E);
            }
            if (view != this.t && view != this.u) {
                if (view != this.A && view != this.o && view != k()) {
                    if (view == this.s) {
                        d.a.p0.u0.h1.g gVar = this.E;
                        if (gVar == null || gVar.z == null) {
                            return;
                        }
                        this.q.setVisibility(8);
                        this.C.j1();
                        d.a.p0.n2.c cVar = this.C;
                        d.a.p0.u0.h1.g gVar2 = this.E;
                        cVar.d2(gVar2.z.f62876d, gVar2.f62849f);
                        L("2");
                        return;
                    } else if (view == this.v) {
                        d.a.p0.u0.h1.g gVar3 = this.E;
                        if (gVar3.y.f62863e) {
                            return;
                        }
                        this.G.c(gVar3);
                        return;
                    } else if (view == this.B) {
                        d.a.o0.i0.c k = TbPageExtraHelper.k(b());
                        if (k != null) {
                            this.E.u = k.a();
                        }
                        this.G.d(this.E);
                        return;
                    } else {
                        return;
                    }
                } else if (this.E == null) {
                    return;
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f53778g);
                    pbActivityConfig.createNormalCfg(this.E.f62849f, null, null);
                    if (!this.R) {
                        pbActivityConfig.setVideo_source("bavideotab");
                    } else {
                        pbActivityConfig.setVideo_source("auto_midpage");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                }
            }
            boolean z = false;
            d.a.p0.u0.h1.g gVar4 = this.E;
            if (gVar4 == null || (bVar = gVar4.y) == null || TextUtils.isEmpty(bVar.f62859a)) {
                return;
            }
            if (TbadkCoreApplication.isLogin() && this.E.y.f62859a.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.D.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(this.E.y.f62859a, 0L), z, this.E.y.f62864f)));
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            K();
            h hVar = this.G;
            if (hVar != null) {
                hVar.b();
            }
        }
    }
}
