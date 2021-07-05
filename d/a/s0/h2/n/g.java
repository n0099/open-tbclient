package d.a.s0.h2.n;

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
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.g.d;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.l1;
import d.a.s0.n2.c;
import d.a.s0.n2.f;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static VideoControllerView.c U;
    public static c.d0 V;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.a0.c A;
    public PbVideoWifiTipLayout B;
    public int C;
    public long D;
    public c.k0 E;
    public c.y F;
    public boolean G;
    public Handler H;
    public PbFullScreenFloatingHuajiAninationView I;
    public PbFullScreenFloatingHuajiAninationView.c J;
    public d.a.c.e.g.c K;
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
    public RelativeLayout f60932a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.h2.k.e.g1.c f60933b;

    /* renamed from: c  reason: collision with root package name */
    public CustomFrameLayout f60934c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f60935d;

    /* renamed from: e  reason: collision with root package name */
    public c.y f60936e;

    /* renamed from: f  reason: collision with root package name */
    public String f60937f;

    /* renamed from: g  reason: collision with root package name */
    public VideoInfo f60938g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.n2.c f60939h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.n2.o f60940i;
    public d.a.s0.h2.n.e j;
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

    /* loaded from: classes9.dex */
    public class a implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f60941a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f60942b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b2 f60943c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f60944d;

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
            this.f60944d = gVar;
            this.f60941a = videoInfo;
            this.f60942b = str;
            this.f60943c = b2Var;
        }

        @Override // d.a.s0.n2.f.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f60944d.D <= 0) {
                    this.f60944d.D = i3;
                }
                McnAdInfo mcnAdInfo = this.f60941a.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a2 = d.a.a0.b.b().a(mcnAdInfo.jump_url);
                if (!this.f60944d.z || a2 || this.f60944d.p) {
                    return;
                }
                boolean z = true;
                boolean z2 = this.f60944d.D >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                long j = i3;
                if ((j < mcnAdInfo.ad_start_time.longValue() * 1000 || j >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                    if (this.f60944d.A.c()) {
                        return;
                    }
                    d.a.a0.a aVar = new d.a.a0.a();
                    aVar.f43761b = mcnAdInfo.card_title;
                    aVar.f43762c = mcnAdInfo.button_title;
                    aVar.f43763d = mcnAdInfo.jump_url;
                    aVar.f43760a = mcnAdInfo.pic_url;
                    aVar.f43765f = this.f60942b;
                    aVar.f43764e = this.f60943c.n1();
                    aVar.f43766g = 4;
                    if (z2) {
                        this.f60944d.A.f(aVar, (ViewGroup) this.f60944d.f60939h.E0());
                    } else {
                        this.f60944d.A.e(aVar, (ViewGroup) this.f60944d.f60939h.E0());
                    }
                } else if (this.f60944d.A.c()) {
                    this.f60944d.A.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60945a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f60946e;

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
                this.f60946e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f60946e.f60945a.C > 0) {
                        g gVar = this.f60946e.f60945a;
                        gVar.M(gVar.C);
                        g gVar2 = this.f60946e.f60945a;
                        gVar2.j0(gVar2.C);
                        this.f60946e.f60945a.C = 0;
                    }
                    this.f60946e.f60945a.G = true;
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
            this.f60945a = gVar;
        }

        @Override // d.a.s0.n2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60945a.f60935d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.f60945a.G = false;
                g gVar = this.f60945a;
                gVar.C = gVar.P().getHeight();
            }
        }

        @Override // d.a.s0.n2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f60945a.f60935d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.f60945a.H.postDelayed(new a(this), 200L);
                this.f60945a.D = -1L;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60947a;

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
            this.f60947a = gVar;
        }

        @Override // d.a.s0.n2.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60947a.f60935d == null || this.f60947a.m == null || StringUtils.isNull(this.f60947a.m.c0())) {
                return;
            }
            this.f60947a.f60935d.o5(this.f60947a.m.c0());
        }
    }

    /* loaded from: classes9.dex */
    public class d implements c.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60948a;

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
            this.f60948a = gVar;
        }

        @Override // d.a.s0.n2.c.e0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f60948a.l == null) {
                return;
            }
            this.f60948a.l0(z ? "1" : "2");
        }
    }

    /* loaded from: classes9.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f60949e;

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
            this.f60949e = gVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f60949e.f60937f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f implements d.a.c.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60950a;

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
            this.f60950a = gVar;
        }

        @Override // d.a.c.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                ImageView imageView = new ImageView(this.f60950a.f60935d.getActivity());
                if (this.f60950a.L == null) {
                    try {
                        this.f60950a.L = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                        imageView.setImageBitmap(this.f60950a.L);
                    } catch (Throwable unused) {
                    }
                }
                return imageView;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* renamed from: d.a.s0.h2.n.g$g  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1478g implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60951a;

        public C1478g(g gVar) {
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
            this.f60951a = gVar;
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60951a.K = null;
                if (this.f60951a.L != null && !this.f60951a.L.isRecycled()) {
                    this.f60951a.L.recycle();
                }
                this.f60951a.L = null;
            }
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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

        @Override // d.a.s0.n2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f60952e;

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
            this.f60952e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g gVar = this.f60952e;
                gVar.j0(gVar.P().getHeight());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements c.k0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60953a;

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
            this.f60953a = gVar;
        }

        @Override // d.a.s0.n2.c.k0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60953a.f60935d == null || this.f60953a.f60935d.y() == null || this.f60953a.f60935d.y().D0() == null) {
                return;
            }
            PostData j = this.f60953a.f60935d.y().D0().j();
            if (j == null && ListUtils.getCount(this.f60953a.f60935d.y().D0().E()) > 1) {
                j = (PostData) ListUtils.getItem(this.f60953a.f60935d.y().D0().E(), 0);
            }
            d.a.s0.h2.m.a.b(this.f60953a.f60935d.y().D0(), j, 1, 1, 4);
        }
    }

    /* loaded from: classes9.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f60954e;

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
            this.f60954e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60954e.m0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60955a;

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
            this.f60955a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f60955a.f60938g == null) {
                return;
            }
            g gVar = this.f60955a;
            gVar.b0(gVar.f60938g);
            this.f60955a.f60939h.c1();
            this.f60955a.f60939h.q0();
            if (this.f60955a.x == null || this.f60955a.x.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f60955a.x.getLayoutParams();
            layoutParams.height = this.f60955a.v;
            this.f60955a.x.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes9.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60956a;

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
            this.f60956a = gVar;
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60956a.N(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements c.h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60957a;

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
            this.f60957a = gVar;
        }

        @Override // d.a.s0.n2.c.h0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.s0.n2.c.h0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f60957a.w >= 1.0d) {
                    if (!this.f60957a.f60935d.checkUpIsLogin()) {
                        return true;
                    }
                    this.f60957a.f60935d.a5();
                    if (this.f60957a.f60935d.y() != null && this.f60957a.f60935d.y().D0() != null && this.f60957a.f60935d.y().D0().R() != null) {
                        d.a.s0.h2.h.p R = this.f60957a.f60935d.y().D0().R();
                        if (this.f60957a.I == null) {
                            this.f60957a.I = new PbFullScreenFloatingHuajiAninationView(this.f60957a.f60935d.getActivity());
                            this.f60957a.I.setFloatingHuajiAninationListener(this.f60957a.J);
                        }
                        this.f60957a.I.f(!R.e());
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60958a;

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
            this.f60958a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.a.c.e.p.j.z()) {
                if (this.f60958a.f60939h != null) {
                    this.f60958a.f60939h.w1();
                }
                if (!d.a.c.e.p.j.x() || this.f60958a.f60939h == null || !this.f60958a.f60939h.T0() || this.f60958a.f60938g == null || this.f60958a.f60938g.video_length.intValue() <= 0 || this.f60958a.f60938g.video_duration.intValue() <= 0) {
                    return;
                }
                DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
                double intValue = ((this.f60958a.f60938g.video_length.intValue() * (1.0f - ((this.f60958a.f60939h.B0() * 1.0f) / (this.f60958a.f60938g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                if (intValue >= 0.1d) {
                    d.a.c.e.p.l.M(this.f60958a.f60935d.getPageContext().getPageActivity(), String.format(this.f60958a.f60935d.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format(intValue)));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements c.i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60959a;

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
            this.f60959a = gVar;
        }

        @Override // d.a.s0.n2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.f60959a.D = -1L;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements c.f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60960a;

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
            this.f60960a = gVar;
        }

        @Override // d.a.s0.n2.c.f0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.s0.n2.c.f0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // d.a.s0.n2.c.f0
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
                            if (this.f60960a.f60935d.getListView() != null && this.f60960a.f60935d.getListView().getChildCount() > 0 && this.f60960a.f60935d.getListView().getChildAt(0) == this.f60960a.R()) {
                                this.f60960a.f60935d.getListView().setSelectionFromTop(0, this.f60960a.R + ((int) (motionEvent.getY() - this.f60960a.y)));
                            }
                        }
                    }
                    this.f60960a.y = 0.0f;
                    this.f60960a.R = 0;
                } else {
                    this.f60960a.y = motionEvent.getY();
                    if (this.f60960a.f60935d.getListView() != null && this.f60960a.f60935d.getListView().getChildCount() > 0 && this.f60960a.f60935d.getListView().getChildAt(0) == this.f60960a.R()) {
                        g gVar = this.f60960a;
                        gVar.R = gVar.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f60961e;

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
            this.f60961e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60961e.M = true;
                this.f60961e.B.setVisibility(8);
                this.f60961e.w0();
                TiebaStatic.log("c12618");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t implements c.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f60962a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f60963b;

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
            this.f60963b = gVar;
            this.f60962a = animation;
        }

        @Override // d.a.s0.n2.c.y
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f60963b.a0() && this.f60963b.f60933b != null) {
                this.f60962a.setAnimationListener(null);
                this.f60963b.f60933b.i().clearAnimation();
                this.f60963b.u0();
                if (z) {
                    this.f60962a.setAnimationListener(this.f60963b.S);
                    this.f60963b.f60933b.i().startAnimation(this.f60962a);
                }
            }
        }

        @Override // d.a.s0.n2.c.y
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f60963b.a0()) {
                this.f60963b.S();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f60964a;

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
            this.f60964a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f60964a.S();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1676560301, "Ld/a/s0/h2/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1676560301, "Ld/a/s0/h2/n/g;");
                return;
            }
        }
        U = new h();
        V = new i();
    }

    public g(PbFragment pbFragment, d.a.s0.h2.k.e.g1.c cVar, VideoInfo videoInfo, long j2) {
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
        this.f60937f = null;
        this.f60938g = null;
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
        this.f60935d = pbFragment;
        this.f60933b = cVar;
        this.s = d.a.c.e.p.l.g(pbFragment.getActivity(), R.dimen.ds240);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.Q);
        this.T.setTag(pbFragment.getUniqueId());
        this.T.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.T);
        this.A = new d.a.a0.c(pbFragment.getActivity());
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60934c.getLayoutParams();
        if ((layoutParams.width == -1 && layoutParams.height == -1) || i2 == 0) {
            return;
        }
        if (i2 > 0) {
            this.O = false;
            if (this.v != P().getHeight()) {
                this.f60934c.setLayoutParams(new RelativeLayout.LayoutParams(d.a.c.e.p.l.k(this.f60935d.getActivity()), Math.min(this.v, P().getHeight() + i2)));
                this.f60939h.q0();
            }
        } else if (d.a.c.e.p.l.k(this.f60935d.getActivity()) * 0.5625d != P().getHeight()) {
            this.f60934c.setLayoutParams(new RelativeLayout.LayoutParams(d.a.c.e.p.l.k(this.f60935d.getActivity()), (int) Math.max(d.a.c.e.p.l.k(this.f60935d.getActivity()) * 0.5625d, P().getHeight() + i2)));
            this.f60939h.q0();
        }
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (pbFragment = this.f60935d) == null) {
            return;
        }
        pbFragment.m4();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.s0.n2.c cVar = this.f60939h;
            if (cVar != null) {
                cVar.v0();
            }
            CustomFrameLayout customFrameLayout = this.f60934c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            d.a.s0.h2.n.e eVar = this.j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60932a : (View) invokeV.objValue;
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
        d.a.s0.h2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f60933b) == null) {
            return;
        }
        cVar.k();
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f60935d.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
            if (this.f60936e == null) {
                this.f60936e = new t(this, loadAnimation);
            }
            p0(this.f60936e);
            UtilHelper.getLightStatusBarHeight();
            d.a.c.e.p.l.g(this.f60935d.getActivity(), R.dimen.ds98);
            this.H = new Handler();
        }
    }

    public void U(VideoInfo videoInfo, b2 b2Var, String str) {
        d.a.s0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, b2Var, str) == null) || videoInfo == null || (cVar = this.f60939h) == null || b2Var == null) {
            return;
        }
        this.f60938g = videoInfo;
        this.l = b2Var;
        this.f60937f = videoInfo.video_url;
        cVar.k2();
        d.a.s0.n2.o oVar = new d.a.s0.n2.o();
        this.f60940i = oVar;
        oVar.f64043a = "pb";
        oVar.f64045c = b2Var.n1();
        d.a.s0.n2.o oVar2 = this.f60940i;
        oVar2.f64046d = str;
        oVar2.f64047e = TbadkCoreApplication.getCurrentAccount();
        if (b2Var.I1()) {
            if (!StringUtils.isNull(this.f60935d.o1)) {
                this.f60940i.k = this.f60935d.o1;
            }
            d.a.s0.n2.o oVar3 = this.f60940i;
            oVar3.f64051i = this.f60935d.n1 + "";
        } else {
            this.f60940i.f64051i = this.f60935d.T4();
        }
        l1 Q4 = this.f60935d.Q4();
        if (Q4 != null) {
            Q4.d(this.f60940i);
        }
        d.a.s0.n2.o oVar4 = this.f60940i;
        oVar4.m = videoInfo.video_md5;
        d.a.s0.n2.o b2 = oVar4.b();
        b2.f64043a = "6";
        this.D = -1L;
        if (this.f60939h.I0() != null && this.f60939h.I0().getMediaProgressObserver() != null) {
            this.f60939h.I0().getMediaProgressObserver().j(new a(this, videoInfo, str, b2Var));
        }
        this.f60939h.I0().setVideoStatData(b2);
        if (this.f60939h.H0()) {
            this.f60939h.q0();
        }
        this.f60939h.z1(this.F);
        this.n = null;
        this.m = null;
        this.f60939h.x1(null);
        this.f60939h.K0().setOnDragingListener(U);
        this.f60939h.y1(new b(this));
        this.f60939h.C1(new c(this));
        this.f60939h.E1(new d(this));
        this.f60939h.J1(new e(this));
        this.f60939h.S1(videoInfo.thumbnail_url);
        this.f60939h.Y1(this.f60937f, b2Var.n1());
        this.f60939h.m1(str);
        this.f60939h.X1(b2Var.getTitle());
        this.f60939h.D1(V);
        this.f60939h.a1();
        this.f60939h.a2();
    }

    public final void V(VideoInfo videoInfo) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f60935d.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
            this.f60932a = relativeLayout;
            this.f60934c = (CustomFrameLayout) relativeLayout.findViewById(R.id.pb_video_container);
            int b0 = b0(videoInfo);
            int i2 = 0;
            this.z = ((double) this.v) <= (((double) d.a.c.e.p.l.k(this.f60935d.getActivity())) * 0.5625d) + 5.0d;
            int intValue = videoInfo.video_width.intValue();
            d.a.s0.n2.c cVar = new d.a.s0.n2.c(this.f60935d.getPageContext(), this.f60934c, true);
            this.f60939h = cVar;
            cVar.O1("2002");
            this.f60939h.Z1(this.P);
            this.f60939h.t1(false);
            this.f60939h.U1(this.E);
            this.f60939h.V1(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            this.f60939h.N1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.f60935d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f60935d.getBaseFragmentActivity())) {
                this.f60939h.o1(false);
            }
            this.f60939h.F1(new r(this));
            if (intValue > 0) {
                if (this.w >= 1.0d) {
                    this.f60939h.M1(false, true);
                } else {
                    this.f60939h.M1(true, false);
                }
                boolean z = ((float) b0) + this.s > ((float) d.a.c.e.p.l.i(this.f60935d.getActivity()));
                this.t = z;
                if (z) {
                    if (this.j == null) {
                        this.j = new d.a.s0.h2.n.e(this.f60935d.getPageContext(), this.f60934c);
                    }
                    this.f60935d.P4().X0();
                    this.k = true;
                }
            }
            v0();
            this.x = new View(this.f60935d.getContext());
            this.x.setLayoutParams(new AbsListView.LayoutParams(-1, this.v));
            d.a.s0.h2.k.e.g1.c cVar2 = this.f60933b;
            if (cVar2 != null && (navigationBar = cVar2.f60557a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.f60933b.f60557a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.f60933b.f60557a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.f60935d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.f60935d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.f60932a.findViewById(R.id.layout_wifi_tip);
            this.B = pbVideoWifiTipLayout;
            pbVideoWifiTipLayout.setOnPlayClickListener(new s(this));
            d.a.a0.c cVar3 = this.A;
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
            return P().getBottom() > d.a.c.e.p.l.i(P().getContext()) - d.a.c.e.p.l.g(P().getContext(), R.dimen.ds50);
        }
        return invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.j == null) {
            return;
        }
        if (W()) {
            this.f60935d.P4().X0();
        } else if (this.j.f().getVisibility() == 0) {
            this.f60935d.P4().X0();
            this.k = true;
        } else if (this.k) {
            this.f60935d.P4().Y2(false);
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
                this.f60934c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return d.a.c.e.p.l.k(this.f60935d.getActivity());
            }
            int k2 = d.a.c.e.p.l.k(this.f60935d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.f60935d.getPageContext().getPageActivity());
            int i2 = visibilityRegion.height() <= 0 ? d.a.c.e.p.l.i(this.f60935d.getActivity()) : visibilityRegion.height();
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
            this.f60934c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            d.a.s0.h2.k.e.g1.c cVar = this.f60933b;
            if (cVar != null) {
                cVar.n(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.e(i2);
            }
            d.a.s0.h2.n.e eVar = this.j;
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
            if (this.f60939h == null || (customFrameLayout = this.f60934c) == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                d.a.a0.c cVar = this.A;
                if (cVar != null && cVar.c()) {
                    this.A.b();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                d.a.c.e.g.c cVar2 = this.K;
                if (cVar2 != null) {
                    cVar2.d();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.p = true;
                this.f60934c.setLayoutParams(layoutParams);
                this.f60935d.P4().X0();
                this.k = true;
            } else {
                b0(this.f60938g);
                u0();
                this.p = false;
                this.f60933b.t(true);
            }
            this.f60939h.V0(this.f60935d.getPageContext(), configuration);
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            d.a.s0.n2.c cVar = this.f60939h;
            if (cVar == null) {
                return false;
            }
            return cVar.f1(i2);
        }
        return invokeI.booleanValue;
    }

    public void f0() {
        d.a.s0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f60939h) == null) {
            return;
        }
        if (cVar.T0()) {
            this.o = true;
            this.f60939h.k2();
        } else if (this.f60939h.C0() == 3) {
            this.o = false;
        } else if (this.f60939h.C0() != 0 && this.f60939h.C0() != 1) {
            this.o = false;
            this.f60939h.k2();
        } else {
            this.o = true;
            this.f60939h.k2();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.g();
        }
    }

    public void g0() {
        d.a.s0.n2.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (cVar = this.f60939h) != null && this.o) {
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
                        if (this.N || !VideoPlayActivity.FROM_VIDEO_PLAY.equals(this.f60935d.T4())) {
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

    public void k0(PostData postData, b2 b2Var, d.a.s0.h2.h.p pVar) {
        d.a.s0.h2.n.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048600, this, postData, b2Var, pVar) == null) || (eVar = this.j) == null) {
            return;
        }
        eVar.m(postData, b2Var, pVar);
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.f60938g == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            d.a.s0.n2.h.e(this.f60938g.video_md5, "", str, this.f60940i, this.f60939h.I0().getPcdnState());
        }
    }

    public void m0() {
        d.a.s0.n2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f60939h) == null) {
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
        if (b2Var != null && b2Var.p2()) {
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
            d.a.s0.n2.c cVar = this.f60939h;
            if (cVar != null) {
                cVar.x1(str);
            }
        }
    }

    public void s0(View.OnClickListener onClickListener) {
        d.a.s0.h2.n.e eVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.f60933b == null) {
            return;
        }
        this.f60933b.v(this.f60935d.isSimpleForum());
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || d.a.r0.r.d0.b.j().g("show_video_pb_double_tap_tips", false)) {
            return;
        }
        d.a.r0.r.d0.b.j().t("show_video_pb_double_tap_tips", true);
        d.a.c.e.g.d dVar = new d.a.c.e.g.d();
        dVar.d(true);
        dVar.h(false);
        dVar.k(16908290);
        dVar.c(153);
        dVar.i(false);
        dVar.a(new f(this));
        dVar.g(new C1478g(this));
        d.a.c.e.g.c b2 = dVar.b();
        this.K = b2;
        b2.q(this.f60935d.getActivity());
    }

    public void w0() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || this.f60939h == null) {
            return;
        }
        if (d.a.c.e.p.j.x() && !this.M && !d.a.s0.v3.f.d().e()) {
            this.B.setVisibility(0);
            this.B.setData(this.f60938g);
            TiebaStatic.log("c12622");
            return;
        }
        if (StringUtils.isNull(this.f60937f) && (b2Var = this.l) != null && b2Var.l1() != null) {
            TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.n1()));
            this.f60937f = this.l.l1().video_url;
        }
        d.a.s0.n2.c cVar = this.f60939h;
        String str = this.f60937f;
        b2 b2Var2 = this.l;
        cVar.d2(str, b2Var2 == null ? "" : b2Var2.n1());
        l0("2");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    public void x0(String str) {
        d.a.s0.n2.o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || (oVar = this.f60940i) == null) {
            return;
        }
        oVar.f64046d = str;
    }
}
