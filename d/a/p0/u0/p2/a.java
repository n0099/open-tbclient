package d.a.p0.u0.p2;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.m.d;
import d.a.p0.n2.c;
import d.a.p0.n2.f;
import d.a.p0.u0.h1.g;
import java.text.MessageFormat;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a extends d.a.p0.a0.b<d.a.p0.u0.h1.g> implements d.a.p0.u0.h1.c, d.a.p0.n1.o.l.j, d.a.p0.n1.o.l.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public TextView B;
    public TbPageContext<?> C;
    public d.a.p0.u0.h1.g D;
    public int E;
    public d.a.p0.u0.h1.h F;
    public d.a.p0.n2.o G;
    public d.a.p0.n2.o H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public String Q;
    public String R;
    public View S;
    public View T;
    public d.a.p0.u0.p2.c U;
    public Animation V;
    public Animation W;
    public d.a.p0.u0.p2.j.a X;
    public d.a.p0.n1.o.l.f Y;
    public s Z;
    public VideoNetworkStateTipView a0;
    public d.a.d.m.d b0;
    public d.a.p0.u0.p2.b c0;
    public d.a.x.c i0;
    public d.a.p0.n1.o.l.g j0;
    public boolean k0;
    public boolean l0;
    public FrameLayout m;
    public boolean m0;
    public FrameLayout n;
    public long n0;
    public ExpandableTextView o;
    public int o0;
    public View p;
    public Animation.AnimationListener p0;
    public HeadImageView q;
    public Animation.AnimationListener q0;
    public TextView r;
    public Runnable r0;
    public AgreeView s;
    public Runnable s0;
    public TextView t;
    public ImageView u;
    public View v;
    public TextView w;
    public ImageView x;
    public View y;
    public d.a.p0.n2.c z;

    /* renamed from: d.a.p0.u0.p2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1715a implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u0.h1.g f63564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f63565f;

        public C1715a(a aVar, d.a.p0.u0.h1.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63565f = aVar;
            this.f63564e = gVar;
        }

        @Override // d.a.p0.n2.f.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f63565f.n0 <= 0) {
                    this.f63565f.n0 = i3;
                }
                a aVar = this.f63565f;
                g.a aVar2 = aVar.D.z.o;
                boolean z = true;
                if (aVar2 == null) {
                    if (i3 >= i2) {
                        d.a.d.m.d dVar = aVar.b0;
                        boolean z2 = this.f63565f.K;
                        d.a.p0.n2.c cVar = this.f63565f.z;
                        dVar.I(z2, cVar != null && cVar.S0(), "VIDEO_LIST");
                    } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                        aVar.b0.K(this.f63565f.X(this.f63564e));
                    }
                }
                if (aVar2 == null || this.f63565f.K || this.f63565f.z.S0() || d.a.x.b.b().a(aVar2.f62856d)) {
                    return;
                }
                boolean z3 = this.f63565f.n0 >= (aVar2.f62853a * 1000) + 1000;
                long j = i3;
                if ((j < aVar2.f62853a * 1000 || j >= aVar2.f62854b * 1000) ? false : false) {
                    if (this.f63565f.i0.c()) {
                        return;
                    }
                    d.a.x.a aVar3 = new d.a.x.a();
                    aVar3.f68448b = aVar2.f62857e;
                    aVar3.f68449c = aVar2.f62858f;
                    aVar3.f68450d = aVar2.f62856d;
                    aVar3.f68447a = aVar2.f62855c;
                    d.a.p0.u0.h1.g gVar = this.f63565f.D;
                    aVar3.f68452f = gVar != null ? gVar.f62848e : null;
                    d.a.p0.u0.h1.g gVar2 = this.f63565f.D;
                    aVar3.f68451e = gVar2 != null ? gVar2.f62849f : null;
                    aVar3.f68453g = 3;
                    if (z3) {
                        this.f63565f.i0.f(aVar3, (ViewGroup) this.f63565f.z.E0());
                    } else {
                        this.f63565f.i0.e(aVar3, (ViewGroup) this.f63565f.z.E0());
                    }
                } else if (this.f63565f.i0.c()) {
                    this.f63565f.i0.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u0.h1.a f63566e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f63567f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f63568g;

        public b(a aVar, d.a.p0.u0.h1.a aVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63568g = aVar;
            this.f63566e = aVar2;
            this.f63567f = i2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.d.m.d dVar = this.f63568g.b0;
                boolean z = this.f63568g.K;
                d.a.p0.n2.c cVar = this.f63568g.z;
                if (dVar.I(z, cVar != null && cVar.S0(), "VIDEO_LIST")) {
                    return;
                }
                if (this.f63568g.K) {
                    this.f63568g.L = true;
                    this.f63568g.M = true;
                    this.f63568g.J = false;
                }
                if (this.f63566e == null || this.f63568g.K) {
                    return;
                }
                this.f63566e.a(this.f63567f);
                this.f63568g.z.a1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u0.h1.a f63569e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f63570f;

        public c(a aVar, d.a.p0.u0.h1.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63570f = aVar;
            this.f63569e = aVar2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                d.a.p0.u0.h1.g gVar = this.f63570f.D;
                if (gVar != null && gVar.z != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f63570f.D.z.f62876d);
                }
                d.a.p0.u0.h1.a aVar = this.f63569e;
                if (aVar != null) {
                    aVar.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.InterfaceC0569d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u0.h1.a f63571a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f63572b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f63573c;

        public d(a aVar, d.a.p0.u0.h1.a aVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63573c = aVar;
            this.f63571a = aVar2;
            this.f63572b = i2;
        }

        @Override // d.a.d.m.d.InterfaceC0569d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f63573c.K) {
                    this.f63573c.L = true;
                    this.f63573c.M = true;
                    this.f63573c.J = false;
                }
                if (this.f63571a == null || this.f63573c.K) {
                    return;
                }
                this.f63571a.a(this.f63572b);
                this.f63573c.z.a1();
            }
        }

        @Override // d.a.d.m.d.InterfaceC0569d
        public void b() {
            d.a.p0.n2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f63573c.z) == null) {
                return;
            }
            cVar.f1(4);
        }

        @Override // d.a.d.m.d.InterfaceC0569d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f63573c.M = false;
            }
        }

        @Override // d.a.d.m.d.InterfaceC0569d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63573c.S() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63574a;

        public e(a aVar) {
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
            this.f63574a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f63574a.S == null) {
                return;
            }
            this.f63574a.S.setVisibility(8);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f63574a.S == null) {
                return;
            }
            this.f63574a.S.setVisibility(0);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63575a;

        public f(a aVar) {
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
            this.f63575a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f63575a.S == null) {
                return;
            }
            this.f63575a.S.setVisibility(0);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f63575a.S == null) {
                return;
            }
            this.f63575a.S.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.u0.h1.g f63576e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f63577f;

        public g(a aVar, d.a.p0.u0.h1.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63577f = aVar;
            this.f63576e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f63576e.d().hasAgree && this.f63576e.d().agreeType == 2) {
                this.f63577f.Z.g(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63578e;

        public h(a aVar) {
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
            this.f63578e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63578e.A.getVisibility() == 0) {
                this.f63578e.A.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63579e;

        public i(a aVar) {
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
            this.f63579e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.p0.n2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f63579e.z) == null) {
                return;
            }
            cVar.k2();
        }
    }

    /* loaded from: classes8.dex */
    public class j implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63580e;

        public j(a aVar) {
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
            this.f63580e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            a aVar;
            d.a.p0.u0.p2.j.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar2 = (aVar = this.f63580e).X) == null) {
                return;
            }
            g.c cVar = aVar.D.z;
            if (cVar.f62877e > 8) {
                aVar2.a(aVar.I, cVar.f62876d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements c.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63581a;

        public k(a aVar) {
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
            this.f63581a = aVar;
        }

        @Override // d.a.p0.n2.c.v
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f63581a.Z == null) {
                return;
            }
            if (z) {
                this.f63581a.Z.g(0);
            } else {
                this.f63581a.Z.g(1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements c.i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63582a;

        public l(a aVar) {
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
            this.f63582a = aVar;
        }

        @Override // d.a.p0.n2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.f63582a.n0 = -1L;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f63584f;

        public m(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63584f = aVar;
            this.f63583e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f63583e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(this.f63584f.j().getPageActivity()), new String[]{this.f63583e}, true);
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63585e;

        public n(a aVar) {
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
            this.f63585e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_FLOW_PLAY_CLICK));
                this.f63585e.a0.setHasAgreeToPlay(true);
                this.f63585e.z.n1(false);
                this.f63585e.a0.g();
                if (this.f63585e.b0.r()) {
                    this.f63585e.b0.E();
                    return;
                }
                a aVar = this.f63585e;
                d.a.p0.u0.h1.g gVar = aVar.D;
                if (gVar == null || (cVar = gVar.z) == null) {
                    return;
                }
                aVar.z.d2(cVar.f62876d, gVar.f62849f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63586a;

        public o(a aVar) {
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
            this.f63586a = aVar;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f63586a.D.H = z;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63587a;

        public p(a aVar) {
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
            this.f63587a = aVar;
        }

        @Override // d.a.p0.n2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63587a.T();
                if (this.f63587a.b0 != null) {
                    this.f63587a.b0.x();
                }
            }
        }

        @Override // d.a.p0.n2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f63587a.U();
                this.f63587a.z.T0();
                if (this.f63587a.L || (this.f63587a.b0 != null && this.f63587a.b0.r())) {
                    d.a.c.e.m.e.a().removeCallbacks(this.f63587a.s0);
                    d.a.c.e.m.e.a().post(this.f63587a.s0);
                }
                if (this.f63587a.b0 != null) {
                    this.f63587a.b0.y();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements c.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63588a;

        public q(a aVar) {
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
            this.f63588a = aVar;
        }

        @Override // d.a.p0.n2.c.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f63588a;
                aVar.onClick(aVar.m);
            }
        }

        @Override // d.a.p0.n2.c.g0
        public void b() {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.p0.u0.h1.g gVar = this.f63588a.D;
                if (gVar != null && (cVar = gVar.z) != null && d.a.c.e.m.b.d(cVar.f62879g, 0) > d.a.c.e.m.b.d(this.f63588a.D.z.f62878f, 0)) {
                    this.f63588a.z.M1(false, false);
                } else {
                    this.f63588a.z.M1(true, false);
                }
                this.f63588a.L = false;
                a aVar = this.f63588a;
                aVar.l0(aVar.N ? "1" : "2");
                a aVar2 = this.f63588a;
                aVar2.onClick(aVar2.n);
                if (this.f63588a.Y != null) {
                    this.f63588a.Y.h(this.f63588a);
                }
                if (this.f63588a.j0 != null) {
                    this.f63588a.j0.b(this.f63588a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements c.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63589a;

        public r(a aVar) {
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
            this.f63589a = aVar;
        }

        @Override // d.a.p0.n2.c.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                a aVar = this.f63589a;
                d.a.p0.n2.c cVar = aVar.z;
                d.a.p0.u0.h1.g gVar = aVar.D;
                cVar.d2(gVar.z.f62876d, gVar.f62849f);
                this.f63589a.l0("2");
                a aVar2 = this.f63589a;
                aVar2.onClick(aVar2.n);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, d.a.p0.u0.p2.b bVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), str, str2, bVar};
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
        this.J = true;
        this.O = false;
        this.P = false;
        this.k0 = false;
        this.l0 = false;
        this.m0 = false;
        this.n0 = -1L;
        this.o0 = 0;
        this.p0 = new e(this);
        this.q0 = new f(this);
        this.r0 = new h(this);
        this.s0 = new i(this);
        this.Q = str;
        this.R = str2;
        this.c0 = bVar;
        View k2 = k();
        this.C = tbPageContext;
        this.m = (FrameLayout) k2.findViewById(R.id.video_agg_container);
        this.p = k2.findViewById(R.id.card_container);
        FrameLayout frameLayout = (FrameLayout) k2.findViewById(R.id.video_container);
        this.n = frameLayout;
        d.a.p0.n2.c cVar = new d.a.p0.n2.c(tbPageContext, frameLayout, false);
        this.z = cVar;
        cVar.O1("2005");
        this.z.q1(z);
        this.z.K1(new j(this));
        this.z.p1(new k(this));
        this.z.N1(new l(this));
        this.o = (ExpandableTextView) k2.findViewById(R.id.title);
        this.q = (HeadImageView) k2.findViewById(R.id.user_icon);
        this.r = (TextView) k2.findViewById(R.id.user_name);
        this.s = (AgreeView) k2.findViewById(R.id.agree_view);
        d.a.o0.r.q.f fVar = new d.a.o0.r.q.f();
        fVar.f52648c = 2;
        fVar.f52653h = 6;
        this.s.setStatisticData(fVar);
        this.s.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.t = (TextView) k2.findViewById(R.id.thread_info_commont_num);
        this.u = (ImageView) k2.findViewById(R.id.thread_info_commont_img);
        this.v = k2.findViewById(R.id.thread_info_commont_container);
        this.w = (TextView) k2.findViewById(R.id.thread_info_share_num);
        this.x = (ImageView) k2.findViewById(R.id.share_num_img);
        this.y = k2.findViewById(R.id.share_num_container);
        this.A = (FrameLayout) k2.findViewById(R.id.download_nani_guide_container);
        this.B = (TextView) k2.findViewById(R.id.download_nani_guide_txt);
        this.A.setVisibility(8);
        String p2 = d.a.o0.r.d0.b.j().p("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(p2)) {
            this.B.setText(p2);
        }
        this.B.setOnClickListener(new m(this, d.a.o0.r.d0.b.j().p("nani_key_download_link_url", null)));
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) k2.findViewById(R.id.network_state_tip);
        this.a0 = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new n(this));
        this.S = k2.findViewById(R.id.video_agg_container_foreground);
        this.T = k2.findViewById(R.id.title_and_comment_container_foreground);
        this.S.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.p.setOnClickListener(this);
        int k3 = d.a.c.e.p.l.k(tbPageContext.getPageActivity());
        this.E = k3;
        this.o0 = k3;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = (int) (this.E * 0.5625f);
        this.m.setLayoutParams(layoutParams);
        this.q.setIsRound(true);
        this.q.setPlaceHolder(1);
        this.F = new d.a.p0.u0.h1.h(this.C, this);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.V = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.V.setAnimationListener(this.q0);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.W = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.W.setAnimationListener(this.p0);
        this.Z = new s(this, null);
        this.b0 = new d.a.d.m.d(b(), this.n);
        this.i0 = new d.a.x.c(this.f53778g);
    }

    public final void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            d.a.p0.u0.p2.j.a aVar = this.X;
            boolean z2 = this.I == (aVar == null ? -1 : aVar.b());
            this.O = z2;
            if (z2 && z && isPlaying() && this.N && !this.P) {
                this.A.setVisibility(0);
                this.P = true;
                this.A.postDelayed(this.r0, 5000L);
                d.a.p0.u0.p2.j.a aVar2 = this.X;
                if (aVar2 != null) {
                    aVar2.c(System.currentTimeMillis());
                    return;
                }
                return;
            }
            this.A.setVisibility(8);
            Runnable runnable = this.r0;
            if (runnable != null) {
                this.A.removeCallbacks(runnable);
            }
        }
    }

    public final void B0() {
        d.a.p0.u0.h1.g gVar;
        String str;
        String str2;
        String format;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.D) == null || this.f53778g == null) {
            return;
        }
        String valueOf = String.valueOf(gVar.f62848e);
        d.a.p0.u0.h1.g gVar2 = this.D;
        String str3 = gVar2.x;
        BaijiahaoData baijiahaoData = gVar2.A;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.D.A.oriUgcType + "&dvid=" + this.D.A.oriUgcVid + "&nid=" + this.D.A.oriUgcNid;
        } else {
            str = gVar2.f62849f;
            str2 = "?share=9105&fr=share";
        }
        String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str5 = this.D.z.j;
        Uri parse = str5 == null ? null : Uri.parse(str5);
        String str6 = this.D.x;
        String string = this.f53778g.getResources().getString(R.string.share_content_tpl);
        String string2 = this.f53778g.getResources().getString(R.string.default_share_content_tpl);
        d.a.p0.u0.h1.g gVar3 = this.D;
        if (gVar3.A != null && (bVar = gVar3.y) != null) {
            format = MessageFormat.format(string2, bVar.f62861c, this.f53778g.getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str3, str6);
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        d.a.p0.u0.h1.g gVar4 = this.D;
        if (gVar4.A != null) {
            shareItem.D = format;
            shareItem.R = -1L;
        } else {
            shareItem.D = str6;
            shareItem.R = gVar4.j;
        }
        shareItem.t = str4;
        shareItem.q = str;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = "";
        shareItem.K = str;
        shareItem.f12843f = true;
        shareItem.E = 11;
        if (this.D.h() == 1) {
            shareItem.M = 2;
        } else if (this.D.h() == 2) {
            shareItem.M = 8;
        } else if (this.D.h() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.D.A != null) {
            shareItem.f0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.f12249c = str5;
        originalThreadInfo.f12247a = 3;
        originalThreadInfo.f12248b = str3;
        originalThreadInfo.f12252f = str;
        originalThreadInfo.p = this.D.A;
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", 12);
        statisticItem.param("nid", this.D.f62850g);
        BaijiahaoData baijiahaoData2 = this.D.A;
        if (baijiahaoData2 != null && !d.a.c.e.p.k.isEmpty(baijiahaoData2.oriUgcVid)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.D.A.oriUgcVid);
        }
        if (this.D.h() == 1) {
            statisticItem.param("card_type", 2);
        } else if (this.D.h() == 2) {
            statisticItem.param("card_type", 8);
        } else if (this.D.h() == 3) {
            statisticItem.param("card_type", 6);
        }
        statisticItem.param("recom_source", this.D.q);
        statisticItem.param("ab_tag", this.D.t);
        statisticItem.param("weight", this.D.r);
        statisticItem.param("extra", this.D.s);
        statisticItem.param(TiebaStatic.Params.OBJ_PAGE, "a023");
        TbPageContext<?> tbPageContext = this.C;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && d.a.o0.j0.c.j(this.C.getPageActivity()) != null && d.a.o0.j0.c.j(this.C.getPageActivity()).b() != null && !TextUtils.isEmpty(d.a.o0.j0.c.j(this.C.getPageActivity()).b().locatePage) && "a002".equals(d.a.o0.j0.c.j(this.C.getPageActivity()).b().locatePage)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
        }
        TiebaStatic.log(statisticItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f53778g, shareItem, true, true);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
        d.a.p0.e0.f.b().k(shareDialogConfig);
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b0.L();
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.P = false;
            this.z.k2();
            ExpandableTextView expandableTextView = this.o;
            if (expandableTextView != null) {
                expandableTextView.setVisibility(0);
            }
            s sVar = this.Z;
            if (sVar != null) {
                sVar.g(2);
            }
            A0(false);
            this.O = true;
            d.a.d.m.d dVar = this.b0;
            if (dVar == null || !dVar.r()) {
                return;
            }
            this.b0.L();
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.z != null && this.n != null && (tbPageContext = this.C) != null && tbPageContext.getPageActivity() != null && this.C.getPageActivity().getWindow() != null && (this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
                FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
                if (this.n.getParent() != null) {
                    if (this.n.getParent() == frameLayout) {
                        if (this.k0) {
                            this.k0 = false;
                            return true;
                        } else if (!this.l0) {
                            this.l0 = true;
                            return true;
                        }
                    } else if (this.n.getParent() == this.m) {
                        if (this.l0) {
                            this.l0 = false;
                            this.m0 = true;
                            return true;
                        } else if (!this.k0 && this.m0) {
                            this.k0 = true;
                            this.m0 = false;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        this.K = true;
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
        d.a.x.c cVar = this.i0;
        if (cVar != null && cVar.c()) {
            this.i0.a();
        }
        d.a.o0.z0.e.m().n(true);
    }

    public final void U() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        this.K = false;
        if (this.n.getParent() != null) {
            if (this.n.getParent() == frameLayout) {
                W();
                frameLayout.removeView(this.n);
            } else if (this.n.getParent() == this.m) {
                W();
                this.m.removeView(this.n);
            }
        }
        if (this.n.getParent() != null) {
            return;
        }
        this.m.addView(this.n, 0);
        p0();
        this.z.q0();
        this.n0 = -1L;
        d.a.o0.z0.e.m().n(false);
    }

    public final void W() {
        d.a.d.m.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (dVar = this.b0) != null && dVar.r()) {
            this.b0.F(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.d.m.a X(d.a.p0.u0.h1.g gVar) {
        InterceptResult invokeL;
        int i2;
        g.c cVar;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            d.a.p0.u0.p2.b bVar = this.c0;
            d.a.d.m.e.b c2 = bVar != null ? bVar.c(gVar.e()) : null;
            if (c2 == null) {
                return null;
            }
            int c3 = c2.c();
            int b2 = c2.b();
            int a2 = c2.a();
            int i5 = -1;
            if (a2 != -1) {
                int i6 = c3 != -1 ? (a2 - c3) - 1 : -1;
                if (b2 != -1) {
                    i5 = i6;
                    i2 = (b2 - a2) - 1;
                    cVar = gVar.z;
                    if (cVar == null) {
                        i3 = d.a.c.e.m.b.d(cVar.f62878f, 0);
                        i4 = d.a.c.e.m.b.d(gVar.z.f62879g, 0);
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", gVar.f62849f);
                    hashMap.put("video_title", gVar.x);
                    hashMap.put("forum_id", gVar.f62848e);
                    hashMap.put("forum_name", "");
                    hashMap.put("up_distance", String.valueOf(i5));
                    hashMap.put("down_distance", String.valueOf(i2));
                    d.a.d.m.a h2 = d.a.d.m.c.h(3, 0, "1546857125210", a2 + 1, i3, i4);
                    h2.a(hashMap);
                    return h2;
                }
                i5 = i6;
            }
            i2 = -1;
            cVar = gVar.z;
            if (cVar == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", gVar.f62849f);
            hashMap2.put("video_title", gVar.x);
            hashMap2.put("forum_id", gVar.f62848e);
            hashMap2.put("forum_name", "");
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            d.a.d.m.a h22 = d.a.d.m.c.h(3, 0, "1546857125210", a2 + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (d.a.d.m.a) invokeL.objValue;
    }

    public final void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
            CustomMessage customMessage = new CustomMessage(2921317);
            if (z) {
                customMessage.setExtra("high");
            } else {
                customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
            }
            customResponsedMessage.setmOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void Z(d.a.p0.u0.h1.g gVar, int i2, d.a.p0.u0.h1.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{gVar, Integer.valueOf(i2), aVar, Boolean.valueOf(z)}) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.z.k2();
        this.z.s1(true);
        this.z.v1(true);
        this.z.t1(true);
        this.z.M1(false, false);
        this.z.L1(i2);
        this.z.y1(new p(this));
        this.z.G1(new q(this));
        this.z.A1(new r(this));
        this.z.o1(false);
        d.a.x.c cVar = this.i0;
        if (cVar != null) {
            cVar.d();
        }
        this.n0 = -1L;
        if (this.z.I0() != null && this.z.I0().getMediaProgressObserver() != null) {
            this.z.I0().getMediaProgressObserver().j(new C1715a(this, gVar));
        }
        d.a.p0.n2.o oVar = new d.a.p0.n2.o();
        this.G = oVar;
        oVar.f60811c = gVar.f62849f;
        oVar.t = gVar.f62850g;
        oVar.f60812d = gVar.f62848e;
        oVar.f60813e = TbadkCoreApplication.getCurrentAccount();
        d.a.p0.n2.o oVar2 = this.G;
        oVar2.f60809a = "13";
        oVar2.f60814f = gVar.q;
        oVar2.f60815g = gVar.r;
        oVar2.f60817i = this.Q;
        oVar2.l = gVar.t;
        oVar2.k = this.R;
        oVar2.o = gVar.s;
        oVar2.p = "0";
        oVar2.j = gVar.h();
        d.a.p0.n2.o oVar3 = new d.a.p0.n2.o();
        this.H = oVar3;
        oVar3.f60811c = gVar.f62849f;
        oVar3.f60812d = gVar.f62848e;
        oVar3.f60813e = TbadkCoreApplication.getCurrentAccount();
        d.a.p0.n2.o oVar4 = this.H;
        oVar4.f60815g = "auto_midpage";
        oVar4.f60809a = "auto_midpage";
        oVar4.f60817i = this.Q;
        oVar4.f60814f = gVar.q;
        oVar4.p = "0";
        g.c cVar2 = gVar.z;
        if (cVar2 != null) {
            d.a.p0.n2.o oVar5 = this.G;
            String str = cVar2.f62875c;
            oVar5.m = str;
            oVar4.m = str;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", gVar.f62849f);
        statisticItem.param("nid", gVar.f62850g);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", i2);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("fid", gVar.f62848e);
        statisticItem.param("obj_param1", d.a.c.e.p.k.isEmpty(gVar.r) ? "0" : gVar.r);
        statisticItem.param("extra", d.a.c.e.p.k.isEmpty(gVar.s) ? "0" : gVar.s);
        statisticItem.param("obj_id", this.R);
        statisticItem.param("ab_tag", d.a.c.e.p.k.isEmpty(gVar.t) ? "0" : gVar.t);
        statisticItem.param("obj_type", this.Q);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.h());
        statisticItem.param("obj_source", d.a.c.e.p.k.isEmpty(gVar.q) ? "0" : gVar.q);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 0);
        BaijiahaoData baijiahaoData = gVar.A;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, gVar.A.oriUgcVid);
        }
        TiebaStatic.log(statisticItem);
        this.z.I0().setVideoStatData(this.G);
        this.z.q0();
        this.z.I1(new b(this, aVar, i2));
        this.z.J1(new c(this, aVar));
        if (!z || !gVar.F) {
            this.b0.B();
        }
        this.b0.G(new d(this, aVar, i2));
        this.z.S1(gVar.z.j);
        this.z.T1(gVar.z.f62877e);
        this.z.Y1(gVar.z.f62876d, gVar.f62849f);
        this.z.m1(gVar.f62848e);
        this.z.a1();
        this.z.a2();
        A0(false);
        if (gVar.F) {
            onClick(this.n);
            if (this.a0.d()) {
                this.z.c2(false);
                this.a0.f();
                this.z.n1(true);
                this.z.U0(gVar.z.f62876d, gVar.f62849f);
                if (this.b0.r()) {
                    this.b0.L();
                    this.b0.J();
                }
            } else {
                this.z.n1(false);
                this.z.c2(false);
                this.a0.b();
                d.a.d.m.d dVar = this.b0;
                if (dVar == null || (dVar != null && !dVar.r())) {
                    this.z.i2(gVar.z.f62876d, gVar.f62849f, null, new Object[0]);
                }
            }
            if (i2 == 0 && gVar.G) {
                this.S.setVisibility(8);
                this.Z.g(3);
            } else {
                if (this.S.getVisibility() == 0) {
                    this.S.startAnimation(this.W);
                }
                this.Z.g(0);
            }
            gVar.G = false;
        } else {
            this.S.setVisibility(0);
            this.a0.b();
            this.z.c2(true);
            this.Z.g(3);
            this.z.U0(gVar.z.f62876d, gVar.f62849f);
        }
        this.L = false;
        this.M = false;
        if (z || !this.b0.r()) {
            return;
        }
        stopPlay();
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            s sVar = this.Z;
            if (sVar != null) {
                return sVar.f() == 2 || this.Z.f() == 3;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                int parseInt = Integer.parseInt(this.D.z.f62878f);
                return parseInt <= 0 || ((float) Integer.parseInt(this.D.z.f62879g)) / ((float) parseInt) < 1.0f;
            } catch (NumberFormatException unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.u0.h1.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.C.showToast(str);
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.b0.r() : invokeV.booleanValue;
    }

    @Override // d.a.p0.u0.h1.c
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.D == null) {
            return;
        }
        this.s.t();
    }

    public void d0(d.a.p0.u0.h1.g gVar, int i2, d.a.p0.u0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, gVar, i2, aVar) == null) {
            this.D = gVar;
            this.N = gVar.F;
            Z(gVar, i2, aVar, false);
        }
    }

    @Override // d.a.p0.u0.h1.c
    public void e(boolean z) {
        d.a.p0.u0.h1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (gVar = this.D) == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f62863e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: f0 */
    public void l(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
        }
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? R.layout.card_video_middle_page_layout : invokeV.intValue;
    }

    public void g0(d.a.p0.u0.h1.g gVar, int i2, d.a.p0.u0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048596, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        boolean z = this.D == gVar;
        this.D = gVar;
        this.N = gVar.F;
        this.P = false;
        A0(false);
        this.o.setVisibility(0);
        this.o.setTextSize(d.a.c.e.p.l.g(b(), R.dimen.tbfontsize40));
        this.o.setTextColor(R.color.CAM_X0101);
        this.o.setLineSpacingExtra(d.a.c.e.p.l.g(b(), R.dimen.tbds14));
        g.c cVar = gVar.z;
        if (cVar != null && !StringUtils.isNull(cVar.n)) {
            this.o.setTextMaxLine(2);
            this.o.setExpandable(false);
            d.a.p0.u0.p2.k.a.a(this.f53778g, this.o.getContentView(), gVar.x, gVar.z.n, gVar.e());
        } else {
            this.o.setTextMaxLine(Integer.MAX_VALUE);
            this.o.setExpandable(true);
            this.o.setOnStatusChangedListener(new o(this));
            this.o.setData(gVar.x, gVar.H, gVar.E);
        }
        int k2 = d.a.c.e.p.l.k(this.f53778g);
        this.E = k2;
        if (k2 != this.o0) {
            this.z.c1();
            this.o0 = this.E;
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.n.setLayoutParams(layoutParams);
        }
        m0();
        Z(gVar, i2, aVar, z);
        z0(gVar);
        m(this.C, TbadkCoreApplication.getInst().getSkinType());
    }

    public void h0(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, configuration) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        if (this.J) {
            this.z.k1();
        }
        if (configuration.orientation == 2) {
            configuration.orientation = 2;
            T();
        } else {
            configuration.orientation = 1;
            U();
            this.J = true;
        }
        this.z.V0(this.C, configuration);
    }

    public boolean i0(int i2) {
        InterceptResult invokeI;
        d.a.d.m.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (i2 == 4 && (dVar = this.b0) != null && ((dVar.r() || this.M) && this.z != null)) {
                this.b0.D(i2);
                if (this.K) {
                    if (this.b0.a()) {
                        this.z.q2();
                        return true;
                    }
                    this.z.m2();
                    return true;
                }
            }
            return this.z.f1(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // d.a.p0.n1.o.l.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.z.T0() : invokeV.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && isPlaying()) {
            this.z.W0();
        }
    }

    public void k0() {
        d.a.p0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (cVar = this.z) == null) {
            return;
        }
        cVar.v0();
    }

    public final void l0(String str) {
        d.a.p0.u0.h1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || (gVar = this.D) == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            d.a.p0.n2.h.e(this.D.z.f62875c, "", str, this.H, this.z.I0().getPcdnState());
        }
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, tbPageContext, i2) == null) {
            this.s.u(i2);
            this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            WebPManager.setPureDrawable(this.x, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.o.w();
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (!b0()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = (int) (this.E * 0.875f);
                this.m.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.height = (int) (this.E * 0.5625f);
            this.m.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        d.a.p0.u0.p2.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            if (h() != null) {
                view.setTag(this);
                h().a(view, this.D);
            }
            boolean z = true;
            if (view != this.q && view != this.r) {
                if (view == this.v) {
                    if (this.D == null) {
                        return;
                    }
                    this.Z.g(0);
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f53778g);
                    pbActivityConfig.createNormalCfg(this.D.f62849f, null, null);
                    pbActivityConfig.setVideo_source("auto_midpage");
                    pbActivityConfig.setBjhData(this.D.A);
                    pbActivityConfig.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                } else if (view != this.o && view != this.p) {
                    if (view == this.y) {
                        this.Z.g(0);
                        B0();
                        return;
                    }
                    View view2 = this.S;
                    if (view == view2 && view2.getVisibility() == 0 && (cVar = this.U) != null) {
                        cVar.t0(this.I);
                        return;
                    }
                    return;
                } else if (this.D == null) {
                    return;
                } else {
                    if (this.Z.f() != 2 && this.Z.f() != 3) {
                        z = false;
                    }
                    this.Z.g(0);
                    if (z) {
                        return;
                    }
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.f53778g);
                    pbActivityConfig2.createNormalCfg(this.D.f62849f, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    pbActivityConfig2.setBjhData(this.D.A);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                    return;
                }
            }
            d.a.p0.u0.h1.g gVar = this.D;
            if (gVar == null || (bVar = gVar.y) == null || TextUtils.isEmpty(bVar.f62859a)) {
                return;
            }
            this.Z.g(0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.C.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(this.D.y.f62859a, 0L), (TbadkCoreApplication.isLogin() && this.D.y.f62859a.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false, this.D.y.f62864f)));
        }
    }

    @Override // d.a.p0.n1.o.l.j
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            k0();
            d.a.p0.u0.h1.h hVar = this.F;
            if (hVar != null) {
                hVar.b();
            }
            View view = this.S;
            if (view != null) {
                view.clearAnimation();
            }
            this.b0.w();
        }
    }

    public final void p0() {
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (!b0()) {
                f2 = 0.875f;
                i2 = this.E;
            } else {
                f2 = 0.5625f;
                i2 = this.E;
            }
            int i3 = (int) (i2 * f2);
            if (i3 <= 0) {
                return;
            }
            this.n.setLayoutParams(new FrameLayout.LayoutParams(this.E, i3));
        }
    }

    @Override // d.a.p0.n1.o.l.j
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            j0();
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.b0.E();
        }
    }

    public void s0(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, gVar) == null) || gVar == null) {
            return;
        }
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.k;
        if (j2 > 0) {
            this.t.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.t.setText(this.f53778g.getString(R.string.reply));
        }
    }

    @Override // d.a.p0.n1.o.l.h
    public void setAutoPlayCallBack(d.a.p0.u0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, aVar) == null) {
        }
    }

    @Override // d.a.p0.n1.o.l.h
    public void setCurrentPlayCallBack(d.a.p0.n1.o.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    @Override // d.a.p0.n1.o.l.h
    public void setOnVideoContainerForegroundClickListener(d.a.p0.u0.p2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, cVar) == null) {
            this.U = cVar;
        }
    }

    @Override // d.a.p0.n1.o.l.j
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            D0();
        }
    }

    public void t0(boolean z) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048616, this, z) == null) || (frameLayout = this.m) == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 4);
    }

    public void v0(d.a.p0.n1.o.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, gVar) == null) {
            this.j0 = gVar;
        }
    }

    public void w0(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.d() != null) {
            gVar.d().isInThread = true;
            gVar.d().nid = gVar.f62850g;
            if (this.D.h() == 1) {
                gVar.d().cardType = 2;
            } else if (this.D.h() == 2) {
                gVar.d().cardType = 8;
            } else if (this.D.h() == 3) {
                gVar.d().cardType = 6;
            }
            gVar.d().baijiahaoData = gVar.A;
            gVar.d().recomSource = gVar.q;
            gVar.d().recomWeight = gVar.r;
            gVar.d().recomAbTag = gVar.t;
            gVar.d().recomExtra = gVar.s;
        }
        this.s.setAgreeAlone(true);
        this.s.setIsFromMiddlePage(true);
        this.s.setData(gVar.d());
        this.s.setAfterClickListener(new g(this, gVar));
    }

    public void x0(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, gVar) == null) || gVar == null) {
            return;
        }
        this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.x, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.l;
        if (j2 > 0) {
            this.w.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.w.setText(this.f53778g.getString(R.string.share));
        }
    }

    public final void y0(d.a.p0.u0.h1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, gVar) == null) || (bVar = gVar.y) == null) {
            return;
        }
        g.b.a aVar = bVar.f62866h;
        if (aVar != null && !TextUtils.isEmpty(aVar.f62868b)) {
            this.q.M(gVar.y.f62866h.f62868b, 12, false);
        } else if (!StringUtils.isNull(gVar.y.f62862d) && gVar.y.f62862d.startsWith("http")) {
            this.q.M(gVar.y.f62862d, 10, false);
        } else {
            this.q.M(gVar.y.f62862d, 12, false);
        }
        g.b.a aVar2 = gVar.y.f62866h;
        if (aVar2 != null && aVar2.f62871e.intValue() > 0) {
            this.q.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.y.f62866h.f62871e.intValue(), 1));
            this.q.setShowV(true);
            this.q.setGodIconWidth(R.dimen.tbds31);
            return;
        }
        this.q.setBjhAuthIconRes(0);
        g.b bVar2 = gVar.y;
        boolean z = bVar2.f62865g;
        if (z) {
            this.q.setShowV(z);
            this.q.setIsBigV(gVar.y.f62865g);
        } else {
            boolean z2 = bVar2.f62864f;
            if (z2) {
                this.q.setShowV(z2);
                this.q.setIsBigV(gVar.y.f62864f);
            } else {
                this.q.setShowV(z2);
                this.q.setIsBigV(gVar.y.f62864f);
            }
        }
        this.q.setGodIconWidth(R.dimen.tbds31);
    }

    public void z0(d.a.p0.u0.h1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, gVar) == null) || gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.r.setText(TextUtils.isEmpty(bVar.f62861c) ? gVar.y.f62860b : gVar.y.f62861c);
        y0(gVar);
        w0(gVar);
        s0(gVar);
        x0(gVar);
    }

    /* loaded from: classes8.dex */
    public class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f63590a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f63591b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f63592c;

        /* renamed from: d.a.p0.u0.p2.a$s$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1716a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s f63593e;

            public RunnableC1716a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63593e = sVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.c.e.m.e.a().removeCallbacks(this.f63593e.f63591b);
                    this.f63593e.g(2);
                }
            }
        }

        public s(a aVar) {
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
            this.f63592c = aVar;
            this.f63590a = -1;
            this.f63591b = new RunnableC1716a(this);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.c.e.m.e.a().removeCallbacks(this.f63591b);
                d.a.c.e.m.e.a().postDelayed(this.f63591b, 3000L);
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int i3 = this.f63590a;
                if (i2 == i3) {
                    return i3;
                }
                this.f63592c.T.setVisibility(8);
                this.f63592c.Y(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = this.f63590a;
                if (i2 == i3) {
                    return i3;
                }
                this.f63592c.T.setVisibility(0);
                this.f63592c.Y(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = this.f63590a;
                if (i2 == i3) {
                    return i3;
                }
                this.f63592c.T.setVisibility(0);
                if (i3 != 3 || this.f63592c.D.F) {
                    this.f63592c.Y(false);
                    return i2;
                }
                return i2;
            }
            return invokeI.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63590a : invokeV.intValue;
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                if (i2 == 0) {
                    this.f63590a = c(i2);
                    b();
                } else if (i2 == 1) {
                    this.f63590a = c(i2);
                    d.a.c.e.m.e.a().removeCallbacks(this.f63591b);
                } else if (i2 == 2) {
                    this.f63590a = e(i2);
                } else if (i2 != 3) {
                    this.f63590a = e(i2);
                } else {
                    this.f63590a = d(i2);
                    b();
                }
            }
        }

        public /* synthetic */ s(a aVar, j jVar) {
            this(aVar);
        }
    }
}
