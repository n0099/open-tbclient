package d.a.q0.h2.n;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.CustomFrameLayout;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.g.d;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.l1;
import d.a.q0.n2.c;
import d.a.q0.n2.f;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static VideoControllerView.c U;
    public static c.d0 V;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.y.c A;
    public PbVideoWifiTipLayout B;
    public int C;
    public long D;
    public c.k0 E;
    public c.y F;
    public boolean G;
    public Handler H;
    public PbFullScreenFloatingHuajiAninationView I;
    public PbFullScreenFloatingHuajiAninationView.c J;
    public d.a.d.e.g.c K;
    public Bitmap L;
    public boolean M;
    public boolean N;
    public boolean O;
    public c.h0 P;
    public CustomMessageListener Q;
    public int R;
    public Animation.AnimationListener S;
    public CustomMessageListener T;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f58260a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.h2.k.e.h1.c f58261b;

    /* renamed from: c  reason: collision with root package name */
    public CustomFrameLayout f58262c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f58263d;

    /* renamed from: e  reason: collision with root package name */
    public c.y f58264e;

    /* renamed from: f  reason: collision with root package name */
    public String f58265f;

    /* renamed from: g  reason: collision with root package name */
    public VideoInfo f58266g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.n2.c f58267h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.n2.o f58268i;
    public d.a.q0.h2.n.e j;
    public boolean k;
    public b2 l;
    public b2 m;
    public String n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public float s;
    public boolean t;
    public boolean u;
    public int v;
    public double w;
    public View x;
    public float y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f58269e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f58270f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b2 f58271g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f58272h;

        public a(g gVar, VideoInfo videoInfo, String str, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, videoInfo, str, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58272h = gVar;
            this.f58269e = videoInfo;
            this.f58270f = str;
            this.f58271g = b2Var;
        }

        @Override // d.a.q0.n2.f.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f58272h.D <= 0) {
                    this.f58272h.D = i3;
                }
                McnAdInfo mcnAdInfo = this.f58269e.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a2 = d.a.y.b.b().a(mcnAdInfo.jump_url);
                if (!this.f58272h.z || a2 || this.f58272h.p) {
                    return;
                }
                boolean z = true;
                boolean z2 = this.f58272h.D >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                long j = i3;
                if ((j < mcnAdInfo.ad_start_time.longValue() * 1000 || j >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                    if (this.f58272h.A.c()) {
                        return;
                    }
                    d.a.y.a aVar = new d.a.y.a();
                    aVar.f69126b = mcnAdInfo.card_title;
                    aVar.f69127c = mcnAdInfo.button_title;
                    aVar.f69128d = mcnAdInfo.jump_url;
                    aVar.f69125a = mcnAdInfo.pic_url;
                    aVar.f69130f = this.f58270f;
                    aVar.f69129e = this.f58271g.o1();
                    aVar.f69131g = 4;
                    if (z2) {
                        this.f58272h.A.f(aVar, (ViewGroup) this.f58272h.f58267h.E0());
                    } else {
                        this.f58272h.A.e(aVar, (ViewGroup) this.f58272h.f58267h.E0());
                    }
                } else if (this.f58272h.A.c()) {
                    this.f58272h.A.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58273a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f58274e;

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
                this.f58274e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f58274e.f58273a.C > 0) {
                        g gVar = this.f58274e.f58273a;
                        gVar.M(gVar.C);
                        g gVar2 = this.f58274e.f58273a;
                        gVar2.j0(gVar2.C);
                        this.f58274e.f58273a.C = 0;
                    }
                    this.f58274e.f58273a.G = true;
                }
            }
        }

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58273a = gVar;
        }

        @Override // d.a.q0.n2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58273a.f58263d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.f58273a.G = false;
                g gVar = this.f58273a;
                gVar.C = gVar.P().getHeight();
            }
        }

        @Override // d.a.q0.n2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f58273a.f58263d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.f58273a.H.postDelayed(new a(this), 200L);
                this.f58273a.D = -1L;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58275a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58275a = gVar;
        }

        @Override // d.a.q0.n2.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58275a.f58263d == null || this.f58275a.m == null || StringUtils.isNull(this.f58275a.m.d0())) {
                return;
            }
            this.f58275a.f58263d.v5(this.f58275a.m.d0());
        }
    }

    /* loaded from: classes8.dex */
    public class d implements c.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58276a;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58276a = gVar;
        }

        @Override // d.a.q0.n2.c.e0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f58276a.l == null) {
                return;
            }
            this.f58276a.l0(z ? "1" : "2");
        }
    }

    /* loaded from: classes8.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f58277e;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58277e = gVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f58277e.f58265f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.d.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58278a;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58278a = gVar;
        }

        @Override // d.a.d.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                ImageView imageView = new ImageView(this.f58278a.f58263d.getActivity());
                if (this.f58278a.L == null) {
                    try {
                        this.f58278a.L = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                        imageView.setImageBitmap(this.f58278a.L);
                    } catch (Throwable unused) {
                    }
                }
                return imageView;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.d.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* renamed from: d.a.q0.h2.n.g$g  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1441g implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58279a;

        public C1441g(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58279a = gVar;
        }

        @Override // d.a.d.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58279a.K = null;
                if (this.f58279a.L != null && !this.f58279a.L.isRecycled()) {
                    this.f58279a.L.recycle();
                }
                this.f58279a.L = null;
            }
        }

        @Override // d.a.d.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class i implements c.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.q0.n2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f58280e;

        public j(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58280e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g gVar = this.f58280e;
                gVar.j0(gVar.P().getHeight());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements c.k0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58281a;

        public k(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58281a = gVar;
        }

        @Override // d.a.q0.n2.c.k0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58281a.f58263d == null || this.f58281a.f58263d.y() == null || this.f58281a.f58263d.y().L0() == null) {
                return;
            }
            PostData j = this.f58281a.f58263d.y().L0().j();
            if (j == null && ListUtils.getCount(this.f58281a.f58263d.y().L0().E()) > 1) {
                j = (PostData) ListUtils.getItem(this.f58281a.f58263d.y().L0().E(), 0);
            }
            d.a.q0.h2.m.a.b(this.f58281a.f58263d.y().L0(), j, 1, 1, 4);
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f58282e;

        public l(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58282e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58282e.m0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58283a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58283a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f58283a.f58266g == null) {
                return;
            }
            g gVar = this.f58283a;
            gVar.b0(gVar.f58266g);
            this.f58283a.f58267h.c1();
            this.f58283a.f58267h.q0();
            if (this.f58283a.x == null || this.f58283a.x.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f58283a.x.getLayoutParams();
            layoutParams.height = this.f58283a.v;
            this.f58283a.x.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes8.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58284a;

        public n(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58284a = gVar;
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58284a.N(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements c.h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58285a;

        public o(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58285a = gVar;
        }

        @Override // d.a.q0.n2.c.h0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.q0.n2.c.h0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f58285a.w >= 1.0d) {
                    if (!this.f58285a.f58263d.checkUpIsLogin()) {
                        return true;
                    }
                    this.f58285a.f58263d.h5();
                    if (this.f58285a.f58263d.y() != null && this.f58285a.f58263d.y().L0() != null && this.f58285a.f58263d.y().L0().R() != null) {
                        d.a.q0.h2.h.p R = this.f58285a.f58263d.y().L0().R();
                        if (this.f58285a.I == null) {
                            this.f58285a.I = new PbFullScreenFloatingHuajiAninationView(this.f58285a.f58263d.getActivity());
                            this.f58285a.I.setFloatingHuajiAninationListener(this.f58285a.J);
                        }
                        this.f58285a.I.f(!R.e());
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58286a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58286a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.a.d.e.p.j.z()) {
                if (this.f58286a.f58267h != null) {
                    this.f58286a.f58267h.w1();
                }
                if (!d.a.d.e.p.j.x() || this.f58286a.f58267h == null || !this.f58286a.f58267h.T0() || this.f58286a.f58266g == null || this.f58286a.f58266g.video_length.intValue() <= 0 || this.f58286a.f58266g.video_duration.intValue() <= 0) {
                    return;
                }
                DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
                double intValue = ((this.f58286a.f58266g.video_length.intValue() * (1.0f - ((this.f58286a.f58267h.B0() * 1.0f) / (this.f58286a.f58266g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                if (intValue >= 0.1d) {
                    d.a.d.e.p.l.M(this.f58286a.f58263d.getPageContext().getPageActivity(), String.format(this.f58286a.f58263d.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format(intValue)));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements c.i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58287a;

        public q(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58287a = gVar;
        }

        @Override // d.a.q0.n2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.f58287a.D = -1L;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements c.f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58288a;

        public r(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58288a = gVar;
        }

        @Override // d.a.q0.n2.c.f0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.q0.n2.c.f0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // d.a.q0.n2.c.f0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.f58288a.f58263d.getListView() != null && this.f58288a.f58263d.getListView().getChildCount() > 0 && this.f58288a.f58263d.getListView().getChildAt(0) == this.f58288a.R()) {
                                this.f58288a.f58263d.getListView().setSelectionFromTop(0, this.f58288a.R + ((int) (motionEvent.getY() - this.f58288a.y)));
                            }
                        }
                    }
                    this.f58288a.y = 0.0f;
                    this.f58288a.R = 0;
                } else {
                    this.f58288a.y = motionEvent.getY();
                    if (this.f58288a.f58263d.getListView() != null && this.f58288a.f58263d.getListView().getChildCount() > 0 && this.f58288a.f58263d.getListView().getChildAt(0) == this.f58288a.R()) {
                        g gVar = this.f58288a;
                        gVar.R = gVar.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f58289e;

        public s(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58289e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58289e.M = true;
                this.f58289e.B.setVisibility(8);
                this.f58289e.w0();
                TiebaStatic.log("c12618");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements c.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f58290a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f58291b;

        public t(g gVar, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58291b = gVar;
            this.f58290a = animation;
        }

        @Override // d.a.q0.n2.c.y
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f58291b.a0() && this.f58291b.f58261b != null) {
                this.f58290a.setAnimationListener(null);
                this.f58291b.f58261b.p().clearAnimation();
                this.f58291b.u0();
                if (z) {
                    this.f58290a.setAnimationListener(this.f58291b.S);
                    this.f58291b.f58261b.p().startAnimation(this.f58290a);
                }
            }
        }

        @Override // d.a.q0.n2.c.y
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f58291b.a0()) {
                this.f58291b.S();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58292a;

        public u(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58292a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f58292a.S();
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
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2069587311, "Ld/a/q0/h2/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2069587311, "Ld/a/q0/h2/n/g;");
                return;
            }
        }
        U = new h();
        V = new i();
    }

    public g(PbFragment pbFragment, d.a.q0.h2.k.e.h1.c cVar, VideoInfo videoInfo, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar, videoInfo, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58265f = null;
        this.f58266g = null;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = 0;
        this.s = 0.0f;
        this.t = false;
        this.u = false;
        this.D = -1L;
        this.E = new k(this);
        this.G = true;
        this.J = new n(this);
        this.N = false;
        this.P = new o(this);
        this.Q = new p(this, 2000994);
        this.S = new u(this);
        this.T = new m(this, 2921414);
        this.f58263d = pbFragment;
        this.f58261b = cVar;
        this.s = d.a.d.e.p.l.g(pbFragment.getActivity(), R.dimen.ds240);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.Q);
        this.T.setTag(pbFragment.getUniqueId());
        this.T.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.T);
        this.A = new d.a.y.c(pbFragment.getActivity());
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f58262c.getLayoutParams();
        if ((layoutParams.width == -1 && layoutParams.height == -1) || i2 == 0) {
            return;
        }
        if (i2 > 0) {
            this.O = false;
            if (this.v != P().getHeight()) {
                this.f58262c.setLayoutParams(new RelativeLayout.LayoutParams(d.a.d.e.p.l.k(this.f58263d.getActivity()), Math.min(this.v, P().getHeight() + i2)));
                this.f58267h.q0();
            }
        } else if (d.a.d.e.p.l.k(this.f58263d.getActivity()) * 0.5625d != P().getHeight()) {
            this.f58262c.setLayoutParams(new RelativeLayout.LayoutParams(d.a.d.e.p.l.k(this.f58263d.getActivity()), (int) Math.max(d.a.d.e.p.l.k(this.f58263d.getActivity()) * 0.5625d, P().getHeight() + i2)));
            this.f58267h.q0();
        }
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (pbFragment = this.f58263d) == null) {
            return;
        }
        pbFragment.s4();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.n2.c cVar = this.f58267h;
            if (cVar != null) {
                cVar.v0();
            }
            CustomFrameLayout customFrameLayout = this.f58262c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            d.a.q0.h2.n.e eVar = this.j;
            if (eVar != null) {
                eVar.k();
            }
            MessageManager.getInstance().unRegisterListener(this.Q);
            MessageManager.getInstance().unRegisterListener(this.T);
        }
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58260a : (View) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : invokeV.intValue;
    }

    public View R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.x : (View) invokeV.objValue;
    }

    public void S() {
        d.a.q0.h2.k.e.h1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f58261b) == null) {
            return;
        }
        cVar.r();
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f58263d.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
            if (this.f58264e == null) {
                this.f58264e = new t(this, loadAnimation);
            }
            p0(this.f58264e);
            UtilHelper.getLightStatusBarHeight();
            d.a.d.e.p.l.g(this.f58263d.getActivity(), R.dimen.ds98);
            this.H = new Handler();
        }
    }

    public void U(VideoInfo videoInfo, b2 b2Var, String str) {
        d.a.q0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, b2Var, str) == null) || videoInfo == null || (cVar = this.f58267h) == null || b2Var == null) {
            return;
        }
        this.f58266g = videoInfo;
        this.l = b2Var;
        this.f58265f = videoInfo.video_url;
        cVar.k2();
        d.a.q0.n2.o oVar = new d.a.q0.n2.o();
        this.f58268i = oVar;
        oVar.f61423a = "pb";
        oVar.f61425c = b2Var.o1();
        d.a.q0.n2.o oVar2 = this.f58268i;
        oVar2.f61426d = str;
        oVar2.f61427e = TbadkCoreApplication.getCurrentAccount();
        if (b2Var.J1()) {
            if (!StringUtils.isNull(this.f58263d.o1)) {
                this.f58268i.k = this.f58263d.o1;
            }
            d.a.q0.n2.o oVar3 = this.f58268i;
            oVar3.f61431i = this.f58263d.n1 + "";
        } else {
            this.f58268i.f61431i = this.f58263d.a5();
        }
        l1 W4 = this.f58263d.W4();
        if (W4 != null) {
            W4.d(this.f58268i);
        }
        d.a.q0.n2.o oVar4 = this.f58268i;
        oVar4.m = videoInfo.video_md5;
        d.a.q0.n2.o b2 = oVar4.b();
        b2.f61423a = "6";
        this.D = -1L;
        if (this.f58267h.I0() != null && this.f58267h.I0().getMediaProgressObserver() != null) {
            this.f58267h.I0().getMediaProgressObserver().j(new a(this, videoInfo, str, b2Var));
        }
        this.f58267h.I0().setVideoStatData(b2);
        if (this.f58267h.H0()) {
            this.f58267h.q0();
        }
        this.f58267h.z1(this.F);
        this.n = null;
        this.m = null;
        this.f58267h.x1(null);
        this.f58267h.K0().setOnDragingListener(U);
        this.f58267h.y1(new b(this));
        this.f58267h.C1(new c(this));
        this.f58267h.E1(new d(this));
        this.f58267h.J1(new e(this));
        this.f58267h.S1(videoInfo.thumbnail_url);
        this.f58267h.Y1(this.f58265f, b2Var.o1());
        this.f58267h.m1(str);
        this.f58267h.X1(b2Var.getTitle());
        this.f58267h.D1(V);
        this.f58267h.a1();
        this.f58267h.a2();
    }

    public final void V(VideoInfo videoInfo) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f58263d.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
            this.f58260a = relativeLayout;
            this.f58262c = (CustomFrameLayout) relativeLayout.findViewById(R.id.pb_video_container);
            int b0 = b0(videoInfo);
            int i2 = 0;
            this.z = ((double) this.v) <= (((double) d.a.d.e.p.l.k(this.f58263d.getActivity())) * 0.5625d) + 5.0d;
            int intValue = videoInfo.video_width.intValue();
            d.a.q0.n2.c cVar = new d.a.q0.n2.c(this.f58263d.getPageContext(), this.f58262c, true);
            this.f58267h = cVar;
            cVar.O1("2002");
            this.f58267h.Z1(this.P);
            this.f58267h.t1(false);
            this.f58267h.U1(this.E);
            this.f58267h.V1(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            this.f58267h.N1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.f58263d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f58263d.getBaseFragmentActivity())) {
                this.f58267h.o1(false);
            }
            this.f58267h.F1(new r(this));
            if (intValue > 0) {
                if (this.w >= 1.0d) {
                    this.f58267h.M1(false, true);
                } else {
                    this.f58267h.M1(true, false);
                }
                boolean z = ((float) b0) + this.s > ((float) d.a.d.e.p.l.i(this.f58263d.getActivity()));
                this.t = z;
                if (z) {
                    if (this.j == null) {
                        this.j = new d.a.q0.h2.n.e(this.f58263d.getPageContext(), this.f58262c);
                    }
                    this.f58263d.V4().X0();
                    this.k = true;
                }
            }
            v0();
            this.x = new View(this.f58263d.getContext());
            this.x.setLayoutParams(new AbsListView.LayoutParams(-1, this.v));
            d.a.q0.h2.k.e.h1.c cVar2 = this.f58261b;
            if (cVar2 != null && (navigationBar = cVar2.f57901a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.f58261b.f57901a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.f58261b.f57901a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.f58263d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.f58263d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.f58260a.findViewById(R.id.layout_wifi_tip);
            this.B = pbVideoWifiTipLayout;
            pbVideoWifiTipLayout.setOnPlayClickListener(new s(this));
            d.a.y.c cVar3 = this.A;
            if (cVar3 != null) {
                cVar3.d();
            }
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (P() == null) {
                return false;
            }
            return P().getBottom() > d.a.d.e.p.l.i(P().getContext()) - d.a.d.e.p.l.g(P().getContext(), R.dimen.ds50);
        }
        return invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.j == null) {
            return;
        }
        if (W()) {
            this.f58263d.V4().X0();
        } else if (this.j.f().getVisibility() == 0) {
            this.f58263d.V4().X0();
            this.k = true;
        } else if (this.k) {
            this.f58263d.V4().Z2(false);
            this.k = false;
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.w >= 1.0d : invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? P().getY() >= 0.0f : invokeV.booleanValue;
    }

    public final int b0(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, videoInfo)) == null) {
            if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
                this.f58262c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return d.a.d.e.p.l.k(this.f58263d.getActivity());
            }
            int k2 = d.a.d.e.p.l.k(this.f58263d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.f58263d.getPageContext().getPageActivity());
            int i2 = visibilityRegion.height() <= 0 ? d.a.d.e.p.l.i(this.f58263d.getActivity()) : visibilityRegion.height();
            int i3 = (int) (k2 * 0.5625d);
            int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
            int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
            if (intValue > 0) {
                double d2 = (intValue2 * 1.0d) / intValue;
                this.w = d2;
                if (d2 > 0.5625d) {
                    i3 = Math.min((intValue2 * k2) / intValue, i2);
                }
            }
            this.v = i3;
            this.f58262c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            d.a.q0.h2.k.e.h1.c cVar = this.f58261b;
            if (cVar != null) {
                cVar.w(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.e(i2);
            }
            d.a.q0.h2.n.e eVar = this.j;
            if (eVar != null) {
                eVar.j(i2);
            }
        }
    }

    public void d0(Configuration configuration) {
        CustomFrameLayout customFrameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, configuration) == null) {
            this.p = false;
            if (this.f58267h == null || (customFrameLayout = this.f58262c) == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                d.a.y.c cVar = this.A;
                if (cVar != null && cVar.c()) {
                    this.A.b();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                d.a.d.e.g.c cVar2 = this.K;
                if (cVar2 != null) {
                    cVar2.d();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.p = true;
                this.f58262c.setLayoutParams(layoutParams);
                this.f58263d.V4().X0();
                this.k = true;
            } else {
                b0(this.f58266g);
                u0();
                this.p = false;
                this.f58261b.C(true);
            }
            this.f58267h.V0(this.f58263d.getPageContext(), configuration);
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            d.a.q0.n2.c cVar = this.f58267h;
            if (cVar == null) {
                return false;
            }
            return cVar.f1(i2);
        }
        return invokeI.booleanValue;
    }

    public void f0() {
        d.a.q0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f58267h) == null) {
            return;
        }
        if (cVar.T0()) {
            this.o = true;
            this.f58267h.k2();
        } else if (this.f58267h.C0() == 3) {
            this.o = false;
        } else if (this.f58267h.C0() != 0 && this.f58267h.C0() != 1) {
            this.o = false;
            this.f58267h.k2();
        } else {
            this.o = true;
            this.f58267h.k2();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.g();
        }
    }

    public void g0() {
        d.a.q0.n2.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (cVar = this.f58267h) != null && this.o) {
            cVar.i1();
        }
    }

    public void h0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, absListView, i2) == null) {
            if (absListView != null && absListView.getChildAt(0) != null) {
                View childAt = absListView.getChildAt(0);
                if (childAt == R()) {
                    int bottom = childAt.getBottom() - P().getBottom();
                    M((childAt.getHeight() == 0 || P().getHeight() == 0) ? 0 : 0);
                } else {
                    M((-this.v) + 2);
                }
            }
            if (!W() && this.G) {
                int i3 = this.q;
                if (i3 == 1) {
                    this.N = true;
                    j0(P().getHeight());
                } else if (i3 != 2) {
                    if (i3 == 0) {
                        if (this.N || !"nani_midpage".equals(this.f58263d.a5())) {
                            j0(P().getHeight());
                        }
                    }
                } else {
                    this.N = true;
                    int y = (int) P().getY();
                    if (this.r == y) {
                        j0(P().getHeight());
                    } else {
                        this.r = y;
                        j0(P().getHeight());
                    }
                    if (i2 == 0 && this.u) {
                        this.u = false;
                        this.H.postDelayed(new l(this), 100L);
                    }
                }
            }
        }
    }

    public void i0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048598, this, absListView, i2) == null) || W()) {
            return;
        }
        this.q = i2;
        if (i2 == 0) {
            new Handler().postDelayed(new j(this), 100L);
        }
        Y();
    }

    public final void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            n0(i2);
            Y();
        }
    }

    public void k0(PostData postData, b2 b2Var, d.a.q0.h2.h.p pVar) {
        d.a.q0.h2.n.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048600, this, postData, b2Var, pVar) == null) || (eVar = this.j) == null) {
            return;
        }
        eVar.m(postData, b2Var, pVar);
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.f58266g == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            d.a.q0.n2.h.e(this.f58266g.video_md5, "", str, this.f58268i, this.f58267h.I0().getPcdnState());
        }
    }

    public void m0() {
        d.a.q0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f58267h) == null) {
            return;
        }
        cVar.g1();
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.j == null) {
            return;
        }
        b2 b2Var = this.l;
        if (b2Var != null && b2Var.r2()) {
            this.j.f().setVisibility(8);
            return;
        }
        if (i2 == 0) {
            i2 = this.v;
        }
        float f2 = this.v - i2;
        float f3 = this.s;
        float f4 = f2 > f3 ? 0.0f : 1.0f - (f2 / f3);
        if (this.O) {
            f4 = 0.0f;
        }
        if (f4 == 0.0f) {
            this.j.f().setVisibility(8);
        } else {
            this.j.f().setVisibility(0);
        }
        this.j.n(f4);
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.O = z;
        }
    }

    public void p0(c.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, yVar) == null) {
            this.F = yVar;
        }
    }

    public void q0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, b2Var) == null) {
            this.m = b2Var;
        }
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.n = str;
            d.a.q0.n2.c cVar = this.f58267h;
            if (cVar != null) {
                cVar.x1(str);
            }
        }
    }

    public void s0(View.OnClickListener onClickListener) {
        d.a.q0.h2.n.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) || (eVar = this.j) == null) {
            return;
        }
        eVar.o(onClickListener);
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.u = true;
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.f58261b == null) {
            return;
        }
        this.f58261b.E(this.f58263d.isSimpleForum());
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || d.a.p0.s.d0.b.j().g("show_video_pb_double_tap_tips", false)) {
            return;
        }
        d.a.p0.s.d0.b.j().t("show_video_pb_double_tap_tips", true);
        d.a.d.e.g.d dVar = new d.a.d.e.g.d();
        dVar.d(true);
        dVar.h(false);
        dVar.k(16908290);
        dVar.c(153);
        dVar.i(false);
        dVar.a(new f(this));
        dVar.g(new C1441g(this));
        d.a.d.e.g.c b2 = dVar.b();
        this.K = b2;
        b2.p(this.f58263d.getActivity());
    }

    public void w0() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || this.f58267h == null) {
            return;
        }
        if (d.a.d.e.p.j.x() && !this.M && !d.a.q0.v3.h.d().e()) {
            this.B.setVisibility(0);
            this.B.setData(this.f58266g);
            TiebaStatic.log("c12622");
            return;
        }
        if (StringUtils.isNull(this.f58265f) && (b2Var = this.l) != null && b2Var.m1() != null) {
            TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.o1()));
            this.f58265f = this.l.m1().video_url;
        }
        d.a.q0.n2.c cVar = this.f58267h;
        String str = this.f58265f;
        b2 b2Var2 = this.l;
        cVar.d2(str, b2Var2 == null ? "" : b2Var2.o1());
        l0("2");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    public void x0(String str) {
        d.a.q0.n2.o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || (oVar = this.f58268i) == null) {
            return;
        }
        oVar.f61426d = str;
    }
}
