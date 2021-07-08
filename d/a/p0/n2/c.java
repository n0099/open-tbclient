package d.a.p0.n2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.view.SwitchImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.a;
import java.lang.reflect.Method;
import java.util.Date;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static int Z0;
    public static CallStateReceiver a1;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean A0;
    public TbImageView B;
    public boolean B0;
    public CyberPlayerManager.OnPreparedListener C;
    public boolean C0;
    public CyberPlayerManager.OnCompletionListener D;
    public boolean D0;
    public CyberPlayerManager.OnErrorListener E;
    public boolean E0;
    public ImageView F;
    public boolean F0;
    public TextView G;
    public Activity G0;
    public boolean H;
    public k0 H0;
    public boolean I;
    public CyberPlayerManager.OnPreparedListener I0;
    public boolean J;
    public CyberPlayerManager.OnInfoListener J0;
    public boolean K;
    public VideoLoadingProgressView.c K0;
    public View.OnClickListener L;
    public Runnable L0;
    public Animation M;
    public CyberPlayerManager.OnCompletionListener M0;
    public Animation N;
    public CyberPlayerManager.OnErrorListener N0;
    public x O;
    public Runnable O0;
    public int P;
    public CyberPlayerManager.OnSeekCompleteListener P0;
    public GestureDetector Q;
    public Runnable Q0;
    public View R;
    public TbCyberVideoView.h R0;
    public View S;
    public Runnable S0;
    public TextView T;
    public View.OnClickListener T0;
    public SeekBar U;
    public Animation.AnimationListener U0;
    public ImageView V;
    public Runnable V0;
    public ImageView W;
    public CustomMessageListener W0;
    public AudioManager X;
    public VideoControllerView.d X0;
    public y Y;
    public SeekBar.OnSeekBarChangeListener Y0;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public int f60730a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60731b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f60732c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f60733d;
    public long d0;

    /* renamed from: e  reason: collision with root package name */
    public View f60734e;
    public j0 e0;

    /* renamed from: f  reason: collision with root package name */
    public TbCyberVideoView f60735f;
    public d.a.p0.n2.j f0;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.n2.m f60736g;
    public int g0;

    /* renamed from: h  reason: collision with root package name */
    public VideoListMediaControllerView f60737h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f60738i;
    public int i0;
    public View j;
    public boolean j0;
    public View k;
    public d0 k0;
    public FrameLayout l;
    public c0 l0;
    public FrameLayout.LayoutParams m;
    public e0 m0;
    public ImageView n;
    public f0 n0;
    public View o;
    public h0 o0;
    public View p;
    public v p0;
    public View q;
    public i0 q0;
    public View r;
    public g0 r0;
    public boolean s;
    public a0 s0;
    public SwitchImageView t;
    public b0 t0;
    public TextView u;
    public boolean u0;
    public TextView v;
    public boolean v0;
    public TextView w;
    public boolean w0;
    public String x;
    public int x0;
    public int y;
    public TextView y0;
    public String z;
    public boolean z0;

    /* loaded from: classes8.dex */
    public class a implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60739e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60739e = cVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f60739e.v0) {
                d.a.c.e.m.e.a().postDelayed(this.f60739e.Q0, 200L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface a0 {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60740e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60740e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f60740e;
                if (cVar.f60735f == null || !cVar.v0) {
                    d.a.c.e.m.e.a().postDelayed(this.f60740e.L0, 200L);
                    this.f60740e.v0 = false;
                } else if (this.f60740e.P != this.f60740e.f60735f.getCurrentPosition()) {
                    this.f60740e.v0 = false;
                    d.a.c.e.m.e.a().postDelayed(this.f60740e.L0, 20L);
                } else {
                    d.a.c.e.m.e.a().postDelayed(this.f60740e.Q0, 200L);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b0 {
        void onPause();
    }

    /* renamed from: d.a.p0.n2.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1569c implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60741e;

        public C1569c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60741e = cVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60741e.H = false;
                if (this.f60741e.J && !this.f60741e.K) {
                    d.a.c.e.m.e.a().postDelayed(this.f60741e.S0, 300L);
                }
                d.a.c.e.m.e.a().removeCallbacks(this.f60741e.L0);
                d.a.c.e.m.e.a().removeCallbacks(this.f60741e.O0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c0 {
        void a();
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60742e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60742e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60742e.C0 = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d0 {
        void a();
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60743e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60743e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f60743e.H0 != null) {
                    this.f60743e.H0.a();
                }
                if (view.getId() != this.f60743e.k.getId()) {
                    if (view.getId() != this.f60743e.t.getId()) {
                        if (view.getId() == this.f60743e.v.getId()) {
                            if (this.f60743e.l0 != null) {
                                this.f60743e.l0.a();
                                return;
                            }
                            return;
                        } else if (view.getId() == this.f60743e.u.getId()) {
                            if (this.f60743e.m0 != null) {
                                this.f60743e.m0.a(false);
                            }
                            c cVar = this.f60743e;
                            cVar.d2(cVar.x, this.f60743e.z);
                            return;
                        } else if (view.getId() == this.f60743e.n.getId()) {
                            int i2 = this.f60743e.J ? 1 : 2;
                            if (this.f60743e.s) {
                                TiebaStatic.log(new StatisticItem("c11714"));
                                TiebaStatic.log(new StatisticItem("c13262").param("tid", this.f60743e.z).param("fid", this.f60743e.A).param("obj_type", i2).param("obj_source", 2));
                            } else {
                                TiebaStatic.log(new StatisticItem("c11710"));
                                TiebaStatic.log(new StatisticItem("c13262").param("tid", this.f60743e.z).param("fid", this.f60743e.A).param("obj_type", i2).param("obj_source", 1));
                            }
                            if (this.f60743e.r0 != null) {
                                this.f60743e.r0.a();
                            }
                            if (this.f60743e.S0()) {
                                c cVar2 = this.f60743e;
                                if (cVar2.s) {
                                    cVar2.z0();
                                } else {
                                    cVar2.y0();
                                }
                                c cVar3 = this.f60743e;
                                cVar3.o2(cVar3.s);
                                return;
                            }
                            this.f60743e.m2();
                            return;
                        } else if (view.getId() != this.f60743e.F.getId()) {
                            if (this.f60743e.L != null) {
                                this.f60743e.L.onClick(view);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new StatisticItem("c11713"));
                            if (this.f60743e.r0 != null) {
                                this.f60743e.r0.a();
                            }
                            if (this.f60743e.S0()) {
                                this.f60743e.z0();
                                this.f60743e.o2(false);
                                return;
                            }
                            this.f60743e.m2();
                            return;
                        }
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_PLAY_BTN_CLICK));
                    this.f60743e.g1();
                    this.f60743e.p2();
                    if (this.f60743e.x0 != 1) {
                        this.f60743e.X0();
                        this.f60743e.x0();
                    } else {
                        this.f60743e.w0();
                    }
                    if (this.f60743e.p0 != null) {
                        this.f60743e.p0.a(this.f60743e.x0 == 1);
                        return;
                    }
                    return;
                }
                this.f60743e.f60735f.stopPlayback();
                this.f60743e.H = false;
                this.f60743e.h2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface e0 {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f60744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f60745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f60746g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f60747h;

        public f(c cVar, z zVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, zVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60747h = cVar;
            this.f60744e = zVar;
            this.f60745f = str;
            this.f60746g = str2;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f60747h.j1();
                aVar.dismiss();
                this.f60747h.f2(this.f60744e, false, this.f60745f, this.f60746g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f0 {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes8.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g0 {
        void a();

        void b();
    }

    /* loaded from: classes8.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
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

    /* loaded from: classes8.dex */
    public interface h0 {
        boolean a();

        boolean b();
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60748e;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60748e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60748e.N0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface i0 {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60749e;

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60749e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f60749e.n0 != null) {
                    this.f60749e.n0.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = this.f60749e.Q.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (this.f60749e.H) {
                        if (this.f60749e.Z == 1 && this.f60749e.c0 != 0) {
                            c cVar = this.f60749e;
                            cVar.r0(cVar.c0 == 1 ? 1000.0f : -1000.0f, false);
                            this.f60749e.c0 = 0;
                            this.f60749e.b0 = 0;
                        }
                        if (!this.f60749e.f60735f.isPlaying()) {
                            this.f60749e.v.setVisibility(8);
                            this.f60749e.u.setVisibility(8);
                            this.f60749e.w.setVisibility(8);
                        }
                    }
                    this.f60749e.Y0();
                    if (this.f60749e.n0 != null) {
                        this.f60749e.n0.onStop();
                    }
                }
                return onTouchEvent;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface j0 {
        void a();

        void b(int i2);

        void c();

        void onPaused();

        void onPlayEnd();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes8.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f60750a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f60750a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.f60750a.W0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface k0 {
        void a();
    }

    /* loaded from: classes8.dex */
    public class l implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f60751a;

        public l(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60751a = cVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            TbCyberVideoView tbCyberVideoView;
            int duration;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (tbCyberVideoView = this.f60751a.f60735f) == null || (duration = tbCyberVideoView.getDuration()) <= 0 || this.f60751a.f60738i == null) {
                return;
            }
            this.f60751a.f60738i.setProgress((int) ((i2 * this.f60751a.f60734e.getWidth()) / duration));
            if (this.f60751a.e0 != null) {
                this.f60751a.e0.b((this.f60751a.f60735f.getCurrentPosition() * 100) / duration);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60752e;

        public m(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60752e = cVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_SEEK_CLICK));
                this.f60752e.X0();
                this.f60752e.c2(false);
                if (this.f60752e.p0 != null) {
                    this.f60752e.p0.a(false);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.f60752e.K0() != null) {
                    c cVar = this.f60752e;
                    cVar.P1(cVar.K0().getSeekPosition());
                    if (!this.f60752e.D0()) {
                        this.f60752e.h2();
                    } else {
                        this.f60752e.h1();
                        if (this.f60752e.k0 != null) {
                            this.f60752e.k0.a();
                        }
                    }
                }
                this.f60752e.c2(true);
                this.f60752e.u0();
                if (this.f60752e.p0 != null) {
                    this.f60752e.p0.a(true);
                }
                if (this.f60752e.q0 != null) {
                    this.f60752e.q0.onStopTrackingTouch(seekBar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends d.a.o0.m.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60753e;

        public n(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60753e = cVar;
        }

        @Override // d.a.o0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity == this.f60753e.G0) {
                MessageManager.getInstance().unRegisterListener(this.f60753e.W0);
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60754e;

        public o(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60754e = cVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f60754e.f60737h != null && (tbCyberVideoView = this.f60754e.f60735f) != null && tbCyberVideoView.getDuration() > 0) {
                    this.f60754e.f60737h.o(0, this.f60754e.f60735f.getDuration());
                }
                this.f60754e.j2();
                if (this.f60754e.e0 != null) {
                    this.f60754e.e0.onPrepared();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60755e;

        public p(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60755e = cVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (i2 == 3 || i2 == 702 || i2 == 904) {
                    this.f60755e.P0();
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class q implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f60756a;

        public q(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60756a = cVar;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60756a.j2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60757e;

        public r(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60757e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.c.e.m.e.a().removeCallbacks(this.f60757e.L0);
                if (this.f60757e.B.getVisibility() == 8) {
                    return;
                }
                if (this.f60757e.f60735f.getCurrentPosition() > this.f60757e.f60730a) {
                    this.f60757e.P0();
                } else {
                    d.a.c.e.m.e.a().postDelayed(this.f60757e.L0, 20L);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60758e;

        public s(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60758e = cVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f60758e.f60735f) == null) {
                return;
            }
            int duration = tbCyberVideoView.getDuration();
            if (duration - this.f60758e.B0() > 5000) {
                return;
            }
            this.f60758e.H = false;
            this.f60758e.C0 = false;
            this.f60758e.P = 0;
            this.f60758e.Y0();
            this.f60758e.j.setVisibility(0);
            this.f60758e.f60738i.setProgress(this.f60758e.f60738i.getMax());
            this.f60758e.f60730a = 100;
            if (this.f60758e.D != null) {
                this.f60758e.D.onCompletion();
            }
            this.f60758e.x0 = 3;
            if (duration > 150000) {
                this.f60758e.b1(false);
                this.f60758e.c2(true);
            } else {
                this.f60758e.O0();
                this.f60758e.u.setVisibility(0);
            }
            c cVar = this.f60758e;
            if (!cVar.s && duration <= 150000) {
                if (!cVar.z0) {
                    if (this.f60758e.m0 != null) {
                        this.f60758e.m0.a(true);
                    }
                    c cVar2 = this.f60758e;
                    cVar2.e2(cVar2.x, this.f60758e.z, false);
                } else {
                    this.f60758e.x0 = 5;
                    this.f60758e.f60735f.pause();
                    this.f60758e.f60735f.seekTo(0);
                }
            }
            if (this.f60758e.e0 != null) {
                this.f60758e.e0.b(this.f60758e.f60738i.getMax());
                this.f60758e.e0.onPlayEnd();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60759e;

        public t(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60759e = cVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f60759e.k.setVisibility(0);
                this.f60759e.f60736g.b();
                this.f60759e.x0 = 4;
                if (this.f60759e.E != null) {
                    this.f60759e.E.onError(i2, i3, null);
                }
                if (!d.a.c.e.p.j.z()) {
                    this.f60759e.A0 = true;
                }
                if (this.f60759e.e0 != null) {
                    this.f60759e.e0.a();
                }
                this.f60759e.C0 = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60760e;

        public u(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60760e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbCyberVideoView tbCyberVideoView = this.f60760e.f60735f;
                if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
                    this.f60760e.k.setVisibility(0);
                    this.f60760e.f60736g.b();
                    if (this.f60760e.e0 != null) {
                        this.f60760e.e0.a();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface v {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public class w extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60761e;

        public w(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60761e = cVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.f60761e.E0) {
                    if (this.f60761e.o0 == null || !this.f60761e.o0.b()) {
                        this.f60761e.g1();
                        this.f60761e.p2();
                        if (this.f60761e.f60735f.isPlaying()) {
                            this.f60761e.u0();
                        } else {
                            this.f60761e.X0();
                        }
                        if (this.f60761e.p0 != null) {
                            this.f60761e.p0.a(this.f60761e.f60735f.isPlaying());
                        }
                        return super.onDoubleTap(motionEvent);
                    }
                    return true;
                }
                return super.onDoubleTap(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f60761e.n0 != null) {
                    this.f60761e.n0.onStart();
                }
                c cVar = this.f60761e;
                if (cVar.s && cVar.H) {
                    if (this.f60761e.Z == 1) {
                        this.f60761e.O0();
                    }
                    if (this.f60761e.Z != 0) {
                        if (this.f60761e.Z == 1) {
                            this.f60761e.r0(f2, true);
                        } else if (this.f60761e.Z == 2) {
                            this.f60761e.s0(f3);
                        }
                    } else {
                        c cVar2 = this.f60761e;
                        if (cVar2.s) {
                            cVar2.Q1();
                        }
                        if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                            this.f60761e.Z = 1;
                            c cVar3 = this.f60761e;
                            cVar3.b0 = cVar3.f60735f.getCurrentPosition();
                            this.f60761e.r0(f2, true);
                        } else {
                            this.f60761e.Z = 2;
                            this.f60761e.s0(f3);
                        }
                    }
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (!this.f60761e.E0) {
                    if (this.f60761e.H) {
                        if (this.f60761e.o0 != null && this.f60761e.o0.a()) {
                            return true;
                        }
                        this.f60761e.l2();
                        if (this.f60761e.f60735f.isPlaying()) {
                            this.f60761e.u0();
                        } else {
                            this.f60761e.X0();
                        }
                        if (this.f60761e.p0 != null) {
                            this.f60761e.p0.a(this.f60761e.f60735f.isPlaying());
                        }
                    } else {
                        this.f60761e.g1();
                        this.f60761e.p2();
                        if (this.f60761e.x0 != 1) {
                            this.f60761e.X0();
                            this.f60761e.x0();
                        } else {
                            this.f60761e.w0();
                        }
                        if (this.f60761e.p0 != null) {
                            this.f60761e.p0.a(this.f60761e.x0 == 1);
                        }
                    }
                    return super.onSingleTapConfirmed(motionEvent);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ w(c cVar, j jVar) {
            this(cVar);
        }
    }

    /* loaded from: classes8.dex */
    public interface x {
        void a();

        void b();
    }

    /* loaded from: classes8.dex */
    public interface y {
        void a(boolean z);

        void b();
    }

    /* loaded from: classes8.dex */
    public interface z {
        void a(boolean z);
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60730a = 100;
        this.f60731b = false;
        this.s = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.P = 0;
        this.Z = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 60000L;
        this.g0 = 0;
        this.j0 = false;
        this.u0 = true;
        this.v0 = false;
        this.w0 = false;
        this.x0 = -1;
        this.z0 = false;
        this.D0 = true;
        this.F0 = false;
        this.I0 = new o(this);
        this.J0 = new p(this);
        this.K0 = new q(this);
        this.L0 = new r(this);
        this.M0 = new s(this);
        this.N0 = new t(this);
        this.O0 = new u(this);
        this.P0 = new a(this);
        this.Q0 = new b(this);
        this.R0 = new C1569c(this);
        this.S0 = new d(this);
        this.T0 = new e(this);
        this.U0 = new h(this);
        this.V0 = new i(this);
        this.W0 = new k(this, 2016503);
        this.X0 = new l(this);
        this.Y0 = new m(this);
        if (tbPageContext == null) {
            return;
        }
        this.f60732c = tbPageContext;
        this.f60733d = view;
        this.D0 = z2;
        this.r = view;
        this.G0 = tbPageContext.getPageActivity();
        Q0();
    }

    public static String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int L0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static boolean M0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z2 = resources.getBoolean(identifier);
                String F0 = F0();
                if ("1".equals(F0)) {
                    return false;
                }
                if ("0".equals(F0)) {
                    return true;
                }
                return z2;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        return invokeL.booleanValue;
    }

    public final void A0(Activity activity, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, activity, z2) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (z2) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
        attributes2.flags &= -1025;
        activity.getWindow().setAttributes(attributes2);
        activity.getWindow().clearFlags(512);
    }

    public void A1(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a0Var) == null) {
            this.s0 = a0Var;
        }
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f60735f;
            if (tbCyberVideoView == null) {
                return 0;
            }
            return tbCyberVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public void B1(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b0Var) == null) {
            this.t0 = b0Var;
        }
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x0 : invokeV.intValue;
    }

    public void C1(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c0Var) == null) {
            this.l0 = c0Var;
        }
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public void D1(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d0Var) == null) {
            this.k0 = d0Var;
        }
    }

    public View E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60734e : (View) invokeV.objValue;
    }

    public void E1(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, e0Var) == null) {
            this.m0 = e0Var;
        }
    }

    public void F1(f0 f0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, f0Var) == null) {
            this.n0 = f0Var;
        }
    }

    public int G0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                if (context.getResources() != null && context.getResources().getConfiguration() != null && context.getResources().getConfiguration().orientation == 2) {
                    i2 = displayMetrics.widthPixels;
                } else {
                    i2 = displayMetrics.heightPixels;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i2 == 0 ? d.a.c.e.p.l.i(context) : i2;
        }
        return invokeL.intValue;
    }

    public void G1(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, g0Var) == null) {
            this.r0 = g0Var;
        }
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? !this.s : invokeV.booleanValue;
    }

    public void H1(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.L = onClickListener;
        }
    }

    public TbCyberVideoView I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f60735f : (TbCyberVideoView) invokeV.objValue;
    }

    public void I1(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onCompletionListener) == null) {
            this.D = onCompletionListener;
        }
    }

    public View J0(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public void J1(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onErrorListener) == null) {
            this.E = onErrorListener;
        }
    }

    public VideoListMediaControllerView K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f60737h : (VideoListMediaControllerView) invokeV.objValue;
    }

    public void K1(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onPreparedListener) == null) {
            this.C = onPreparedListener;
        }
    }

    public void L1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
        }
    }

    public void M1(boolean z2, boolean z3) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.f0 == null) {
            return;
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility((z2 || !z3) ? 0 : 8);
        }
        if (!z2 && z3 && (videoListMediaControllerView = this.f60737h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60737h.getLayoutParams();
            layoutParams.rightMargin = d.a.c.e.p.l.g(this.G0, R.dimen.tbds52);
            this.f60737h.setLayoutParams(layoutParams);
        }
        this.f0.i(z2);
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.o != null && this.I) {
            c2(false);
            t0();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.f60738i.setVisibility(0);
            this.M.setAnimationListener(this.U0);
            this.o.startAnimation(this.M);
            this.I = false;
            y yVar = this.Y;
            if (yVar != null) {
                yVar.b();
            }
        }
    }

    public void N1(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, i0Var) == null) {
            this.q0 = i0Var;
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.o != null && this.I) {
            this.N.cancel();
            this.M.cancel();
            c2(false);
            t0();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.f60738i.setVisibility(0);
            this.I = false;
            y yVar = this.Y;
            if (yVar != null) {
                yVar.b();
            }
        }
    }

    public void O1(String str) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || (tbCyberVideoView = this.f60735f) == null) {
            return;
        }
        tbCyberVideoView.setStageType(str);
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.B.getVisibility() == 8 && this.H) {
                return;
            }
            this.H = true;
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.f60736g.c();
            this.B.setVisibility(8);
            Z0();
            this.f60737h.s();
            this.f60738i.setVisibility(0);
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.C;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
        }
    }

    public void P1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.P = i2;
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            View J0 = J0(this.G0);
            this.f60734e = J0;
            J0.setOnClickListener(this.T0);
            View view = this.f60733d;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.f60734e);
            }
            this.f60735f = new TbCyberVideoView(this.G0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.f60734e).addView(this.f60735f.getView(), 0);
            this.f60735f.getView().setLayoutParams(layoutParams);
            d.a.p0.n2.m mVar = new d.a.p0.n2.m((ViewGroup) this.f60734e.findViewById(R.id.auto_video_loading_container));
            this.f60736g = mVar;
            mVar.f(this.K0);
            VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.f60734e.findViewById(R.id.media_controller);
            this.f60737h = videoListMediaControllerView;
            videoListMediaControllerView.setPlayer(this.f60735f);
            ProgressBar progressBar = (ProgressBar) this.f60734e.findViewById(R.id.pgrBottomProgress);
            this.f60738i = progressBar;
            progressBar.setMax(d.a.c.e.p.l.k(this.G0));
            this.f60738i.setProgress(0);
            this.f60737h.setOnSeekBarChangeListener(this.Y0);
            this.f60737h.setOnProgressUpdatedListener(this.X0);
            this.j = this.f60734e.findViewById(R.id.black_mask);
            View findViewById = this.f60734e.findViewById(R.id.layout_error);
            this.k = findViewById;
            findViewById.setOnClickListener(this.T0);
            this.y0 = (TextView) this.f60734e.findViewById(R.id.auto_video_error_tips);
            this.l = (FrameLayout) this.f60734e.findViewById(R.id.danmu_container);
            ImageView imageView = (ImageView) this.f60734e.findViewById(R.id.img_full_screen);
            this.n = imageView;
            imageView.setOnClickListener(this.T0);
            this.o = this.f60734e.findViewById(R.id.layout_media_controller);
            this.p = this.f60734e.findViewById(R.id.time_show_controller);
            this.f60735f.setContinuePlayEnable(true);
            this.f60735f.setOnPreparedListener(this.I0);
            this.f60735f.setOnCompletionListener(this.M0);
            this.f60735f.setOnErrorListener(this.N0);
            this.f60735f.setOnSeekCompleteListener(this.P0);
            this.f60735f.setOnInfoListener(this.J0);
            this.f60735f.setOnSurfaceDestroyedListener(this.R0);
            SwitchImageView switchImageView = (SwitchImageView) this.f60734e.findViewById(R.id.img_play_controller);
            this.t = switchImageView;
            switchImageView.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
            this.t.setState(0);
            this.t.setOnClickListener(this.T0);
            TextView textView = (TextView) this.f60734e.findViewById(R.id.txt_replay);
            this.u = textView;
            textView.setOnClickListener(this.T0);
            TextView textView2 = (TextView) this.f60734e.findViewById(R.id.txt_playnext);
            this.v = textView2;
            textView2.setOnClickListener(this.T0);
            this.w = (TextView) this.f60734e.findViewById(R.id.txt_next_video_title);
            TbImageView tbImageView = (TbImageView) this.f60734e.findViewById(R.id.video_thumbnail);
            this.B = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
            d.a.c.e.p.l.k(this.G0);
            G0(this.G0);
            ImageView imageView2 = (ImageView) this.f60734e.findViewById(R.id.img_exit);
            this.F = imageView2;
            imageView2.setOnClickListener(this.T0);
            this.G = (TextView) this.f60734e.findViewById(R.id.video_title);
            View findViewById2 = this.f60734e.findViewById(R.id.layout_title);
            this.q = findViewById2;
            findViewById2.setVisibility(8);
            this.M = AnimationUtils.loadAnimation(this.G0, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
            this.N = AnimationUtils.loadAnimation(this.G0, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
            this.Q = new GestureDetector(this.G0, new w(this, null));
            AudioManager audioManager = (AudioManager) this.G0.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.X = audioManager;
            this.a0 = audioManager.getStreamMaxVolume(3);
            this.i0 = this.X.getStreamVolume(3);
            Z0 = 100 / this.a0;
            this.f60734e.setOnTouchListener(new j(this));
            d.a.p0.n2.j jVar = new d.a.p0.n2.j(this.G0);
            this.f0 = jVar;
            if (this.D0) {
                jVar.j();
            }
            this.g0 = d.a.c.e.p.l.g(this.G0, R.dimen.ds16);
            if (a1 == null) {
                a1 = new CallStateReceiver();
            }
            a1.register(this.G0);
            R1();
            MessageManager.getInstance().registerListener(this.W0);
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new n(this));
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.f60734e.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.f60734e.setSystemUiVisibility(4);
            } else {
                this.f60734e.setSystemUiVisibility(5894);
            }
        }
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.u0) {
                if (!UtilHelper.canUseStyleImmersiveSticky() || TbSingleton.getInstance().isNotchScreen(this.G0) || TbSingleton.getInstance().isCutoutScreen(this.G0)) {
                    return;
                }
                this.f60734e.setSystemUiVisibility(4);
                return;
            }
            this.f60734e.setSystemUiVisibility(0);
        }
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f60735f;
            return tbCyberVideoView != null && tbCyberVideoView.getView().getHeight() >= this.f60735f.getView().getWidth();
        }
        return invokeV.booleanValue;
    }

    public void S1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.B.M(str, 17, false);
        }
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f60735f;
            if (tbCyberVideoView == null) {
                return false;
            }
            return tbCyberVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void T1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.y = i2;
        }
    }

    public void U0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
        }
    }

    public void U1(k0 k0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, k0Var) == null) {
            this.H0 = k0Var;
        }
    }

    public void V0(TbPageContext tbPageContext, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, tbPageContext, configuration) == null) {
            if (!this.j0) {
                if (this.s) {
                    TiebaStatic.log(new StatisticItem("c11712"));
                } else {
                    TiebaStatic.log(new StatisticItem("c11711"));
                }
            } else {
                this.j0 = false;
            }
            if (configuration.orientation == 2) {
                y0();
            } else {
                z0();
            }
            n2();
            if (this.G0 == d.a.c.a.b.f().b()) {
                h1();
            }
            p2();
            w0();
            v vVar = this.p0;
            if (vVar != null) {
                vVar.a(true);
            }
        }
    }

    public void V1(int i2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i2) == null) || (tbImageView = this.B) == null) {
            return;
        }
        tbImageView.setDefaultBgResource(i2);
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f60735f.pause();
            this.x0 = 2;
            d1();
        }
    }

    public void W1(int i2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || (tbImageView = this.B) == null) {
            return;
        }
        tbImageView.setPlaceHolder(i2);
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.V0);
        }
    }

    public void X1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.G.setText(str);
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.Z = 0;
            View view = this.R;
            if (view != null && view.getParent() != null && (this.R.getParent() instanceof ViewGroup)) {
                try {
                    ((ViewGroup) this.R.getParent()).removeView(this.R);
                    this.R = null;
                } catch (IllegalArgumentException unused) {
                }
            }
            View view2 = this.S;
            if (view2 == null || view2.getParent() == null || !(this.S.getParent() instanceof ViewGroup)) {
                return;
            }
            try {
                ((ViewGroup) this.S.getParent()).removeView(this.S);
                this.S = null;
            } catch (IllegalArgumentException unused2) {
            }
        }
    }

    public void Y1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, str, str2) == null) {
            this.x = str;
            this.z = str2;
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.o == null) {
            return;
        }
        this.N.setAnimationListener(null);
        this.M.setAnimationListener(null);
        this.o.clearAnimation();
    }

    public void Z1(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, h0Var) == null) {
            this.o0 = h0Var;
        }
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            b1(true);
        }
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f60734e.setVisibility(0);
        }
    }

    public final void b1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) || this.o == null) {
            return;
        }
        this.j.setVisibility(0);
        this.v.setVisibility(8);
        this.u.setVisibility(8);
        this.w.setVisibility(8);
        this.f60736g.b();
        O0();
        this.f60738i.setVisibility(8);
        this.k.setVisibility(8);
        this.f60737h.q();
        this.B.setVisibility(z2 ? 0 : 8);
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && d.a.c.e.p.j.x()) {
            d.a.p0.v3.f.d().g(this.G0);
        }
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            d.a.c.e.p.l.k(this.f60732c.getPageActivity());
            G0(this.f60732c.getPageActivity());
        }
    }

    public void c2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            p2();
            if (z2) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.f60736g.b();
            this.v.setVisibility(8);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
            p2();
        }
    }

    public void d2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, str2) == null) {
            e2(str, str2, true);
        }
    }

    public final void e1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            if (z2) {
                this.B.setVisibility(0);
                O0();
                this.f60738i.setProgress(0);
            } else {
                this.B.setVisibility(8);
                O0();
            }
            this.f60737h.s();
            this.j.setVisibility(8);
            this.v.setVisibility(8);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public final void e2(String str, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048634, this, str, str2, z2) == null) {
            b2();
            this.C0 = true;
            this.x0 = 0;
            Y1(str, str2);
            this.f60735f.setVideoDuration(this.y);
            this.f60735f.setVideoPath(str, str2);
            d.a.c.e.m.e.a().removeCallbacks(this.O0);
            if (this.d0 > 0) {
                d.a.c.e.m.e.a().postDelayed(this.O0, this.d0);
            }
            j0 j0Var = this.e0;
            if (j0Var != null) {
                j0Var.onStarted();
            }
            this.f60736g.g();
            e1(z2);
        }
    }

    public boolean f1(int i2) {
        InterceptResult invokeI;
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            if (i2 != 4) {
                if ((i2 == 24 || i2 == 25) && (audioManager = this.X) != null && this.a0 > 0 && this.U != null) {
                    int streamVolume = audioManager.getStreamVolume(3);
                    this.i0 = streamVolume;
                    int i3 = (int) ((streamVolume * 100.0d) / this.a0);
                    this.h0 = i3;
                    this.U.setProgress(i3);
                }
                return false;
            } else if (this.s) {
                if (S0()) {
                    o2(false);
                    z0();
                    return true;
                }
                m2();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void f2(z zVar, boolean z2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{zVar, Boolean.valueOf(z2), str, str2}) == null) {
            if (this.w0) {
                g2(str, str2);
            } else {
                d2(str, str2);
            }
            if (zVar != null) {
                zVar.a(z2);
            }
        }
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.f60735f.isPlaying()) {
                W0();
                b0 b0Var = this.t0;
                if (b0Var != null) {
                    b0Var.onPause();
                }
                j0 j0Var = this.e0;
                if (j0Var != null) {
                    j0Var.onPaused();
                }
            } else if (this.H) {
                h1();
                d0 d0Var = this.k0;
                if (d0Var != null) {
                    d0Var.a();
                }
                j0 j0Var2 = this.e0;
                if (j0Var2 != null) {
                    j0Var2.c();
                }
            } else {
                h2();
            }
        }
    }

    public void g2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, str, str2) == null) {
            b2();
            this.C0 = true;
            this.x0 = 0;
            d.a.c.e.m.e.a().removeCallbacks(this.O0);
            if (this.d0 > 0) {
                d.a.c.e.m.e.a().postDelayed(this.O0, this.d0);
            }
            j0 j0Var = this.e0;
            if (j0Var != null) {
                j0Var.onStarted();
            }
            this.f60736g.g();
            e1(true);
        }
    }

    public void h1() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (tbCyberVideoView = this.f60735f) == null || this.f60737h == null) {
            return;
        }
        this.H = true;
        this.x0 = 1;
        tbCyberVideoView.S(null);
        int c2 = d.a.p0.n2.n.d().c(this.x);
        this.P = c2;
        this.v0 = true;
        int i2 = 100;
        if (c2 > 100) {
            int duration = this.f60735f.getDuration();
            int i3 = this.P;
            if (duration > i3) {
                i2 = i3;
            }
        }
        this.f60730a = i2;
        this.f60736g.b();
        e1(false);
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            i2(this.x, this.z, null, new Object[0]);
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            h1();
            this.f60738i.setVisibility(0);
        }
    }

    public void i2(String str, String str2, z zVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048642, this, str, str2, zVar, objArr) == null) {
            b2();
            if (d.a.c.e.p.j.x() && !d.a.p0.v3.f.d().e() && !TbSingleton.getInstance().hasAgreeToPlay()) {
                Date date = new Date(d.a.o0.r.d0.b.j().l("video_list_confirm_play_in_mobile_net", 0L));
                Date date2 = new Date();
                if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                    this.w0 = ((Boolean) objArr[0]).booleanValue();
                }
                if (date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay()) {
                    a0 a0Var = this.s0;
                    if (a0Var != null) {
                        a0Var.a(true);
                        return;
                    }
                    if (!this.f60731b) {
                        this.f60731b = true;
                        d.a.c.e.p.l.L(this.G0, R.string.play_video_mobile_tip2);
                    }
                    f2(zVar, true, str, str2);
                    return;
                }
                a0 a0Var2 = this.s0;
                if (a0Var2 != null) {
                    a0Var2.a(false);
                    return;
                }
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.G0);
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.editor_dialog_yes, new f(this, zVar, str, str2));
                aVar.setNegativeButton(R.string.editor_dialog_no, new g(this));
                aVar.create(this.f60732c).show();
                return;
            }
            f2(zVar, true, str, str2);
            g0 g0Var = this.r0;
            if (g0Var != null) {
                g0Var.b();
            }
        }
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            d.a.o0.r.d0.b.j().w("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
        }
    }

    public final void j2() {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || this.f60735f == null || (videoListMediaControllerView = this.f60737h) == null) {
            return;
        }
        videoListMediaControllerView.s();
        this.P = d.a.p0.n2.n.d().c(this.x);
        if (this.C0) {
            this.f60735f.setVolume(1.0f, 1.0f);
            this.f60735f.start();
            this.C0 = false;
            d.a.c.e.m.e.a().removeCallbacks(this.L0);
            d.a.c.e.m.e.a().postDelayed(this.L0, 20L);
            d.a.c.e.m.e.a().removeCallbacks(this.O0);
            d.a.c.e.m.e.a().removeCallbacks(this.S0);
            if (this.f60735f.N()) {
                this.x0 = 1;
                O0();
            }
            this.P = d.a.p0.n2.n.d().c(this.x);
            this.f60737h.setPlayer(this.f60735f);
            if (this.P != 0) {
                this.v0 = true;
            }
            if (!this.B0) {
                this.f60737h.s();
            }
            if (!this.J && this.f60735f.getDuration() <= 0) {
                K0().setVisibility(4);
            }
        }
        int i2 = 100;
        if (this.P > 100) {
            int duration = this.f60735f.getDuration();
            int i3 = this.P;
            if (duration > i3) {
                i2 = i3;
            }
        }
        this.f60730a = i2;
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || this.f60735f.getDuration() < this.f60735f.getCurrentPosition()) {
            return;
        }
        d.a.p0.n2.n.d().f(this.x, this.f60735f.getCurrentPositionSync());
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.x0 = 5;
            d.a.c.e.m.e.a().removeCallbacks(this.L0);
            d.a.c.e.m.e.a().removeCallbacks(this.O0);
            d.a.c.e.m.e.a().removeCallbacks(this.S0);
            this.f60735f.stopPlayback();
            this.H = false;
            this.C0 = false;
            this.P = 0;
            a1();
        }
    }

    public void l1(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, j0Var) == null) {
            this.e0 = j0Var;
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || this.o == null) {
            return;
        }
        if (this.I) {
            O0();
        } else {
            x0();
        }
    }

    public void m1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.A = str;
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.j0 = true;
            d.a.p0.n2.j jVar = this.f0;
            if (jVar != null) {
                jVar.l();
            }
        }
    }

    public void n1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z2) == null) {
            this.E0 = z2;
        }
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048652, this) == null) || this.f60735f == null) {
            return;
        }
        int k2 = d.a.c.e.p.l.k(this.G0);
        if (this.s) {
            k2 = d.a.c.e.p.l.i(this.G0);
        }
        this.f60738i.setMax(k2);
        int duration = this.f60735f.getDuration();
        if (duration > 0) {
            if (this.u.getVisibility() == 0) {
                ProgressBar progressBar = this.f60738i;
                progressBar.setProgress(progressBar.getMax());
                return;
            }
            this.f60738i.setProgress((int) ((this.f60735f.getCurrentPositionSync() * this.f60738i.getMax()) / duration));
        }
    }

    public void o1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z2) == null) {
            this.u0 = z2;
            R1();
        }
    }

    public void o2(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) && M0(this.G0) && (this.p.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (z2) {
                layoutParams.bottomMargin = L0(this.G0);
                this.p.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.p.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.p.setLayoutParams(layoutParams);
        }
    }

    public final void p0() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            int i2 = this.Z;
            if (i2 == 1) {
                if (this.R == null && (view2 = this.f60734e) != null && (view2 instanceof ViewGroup)) {
                    LayoutInflater.from(this.G0).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.f60734e, true);
                    View findViewById = this.f60734e.findViewById(R.id.lay_jindu);
                    this.R = findViewById;
                    this.T = (TextView) findViewById.findViewById(R.id.show_time);
                    this.W = (ImageView) this.R.findViewById(R.id.arrow_icon);
                }
            } else if (i2 == 2 && this.S == null && (view = this.f60734e) != null && (view instanceof ViewGroup)) {
                LayoutInflater.from(this.G0).inflate(R.layout.float_video_window_voice, (ViewGroup) this.f60734e, true);
                View findViewById2 = this.f60734e.findViewById(R.id.lay_voice);
                this.S = findViewById2;
                this.V = (ImageView) findViewById2.findViewById(R.id.arrow_voice_icon);
                this.U = (SeekBar) this.S.findViewById(R.id.show_voice_seekbar);
            }
        }
    }

    public void p1(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, vVar) == null) {
            this.p0 = vVar;
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (this.x0 == 1) {
                this.t.setState(1);
            } else {
                this.t.setState(0);
            }
        }
    }

    public void q0() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || (view = this.r) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f60734e.getLayoutParams();
        this.m = layoutParams2;
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        layoutParams2.topMargin = 0;
        Activity activity = this.G0;
        if (activity != null && activity.getResources() != null && this.G0.getResources().getConfiguration() != null && this.G0.getResources().getConfiguration().orientation == 2) {
            this.f60734e.setLayoutParams(new FrameLayout.LayoutParams(d.a.c.e.p.l.i(this.G0), d.a.c.e.p.l.k(this.G0)));
        } else {
            this.f60734e.setLayoutParams(this.m);
        }
    }

    public void q1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) {
            this.J = z2;
        }
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            o2(false);
            z0();
        }
    }

    public final void r0(float f2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048661, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                if (f2 > 0.0f) {
                    this.b0 -= 1000;
                    this.c0 = 1;
                } else {
                    this.b0 += 1000;
                    this.c0 = 2;
                }
                int i2 = this.b0;
                if (i2 < 0) {
                    this.b0 = 0;
                } else if (i2 > this.f60735f.getDuration()) {
                    this.b0 = this.f60735f.getDuration();
                }
            }
            p0();
            String m2 = this.f60737h.m(this.b0);
            if (f2 > 0.0f) {
                this.W.setImageResource(R.drawable.icon_kuaitui);
            } else {
                this.W.setImageResource(R.drawable.icon_kuaijin);
            }
            if (!StringUtils.isNull(m2)) {
                TextView textView = this.T;
                StringBuilder sb = new StringBuilder();
                sb.append(m2);
                sb.append("/");
                sb.append(this.f60737h.m(this.f60735f.getDuration()));
                textView.setText(sb);
            }
            this.f60737h.setCurrentDuration(this.b0, !z2);
            O0();
            n2();
        }
    }

    public void r1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) {
            this.K = z2;
        }
    }

    public final void s0(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048663, this, f2) == null) {
            if (!this.H) {
                this.Z = 0;
                return;
            }
            if (Z0 == 0) {
                int streamMaxVolume = this.X.getStreamMaxVolume(3);
                this.a0 = streamMaxVolume;
                int i6 = 100 / streamMaxVolume;
                Z0 = i6;
                if (i6 == 0) {
                    Z0 = 1;
                }
            }
            p0();
            int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i7 > 0 && (i5 = this.h0) < 100) {
                this.h0 = i5 + 1;
            }
            int i8 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i8 < 0 && (i4 = this.h0) > 0) {
                this.h0 = i4 - 1;
            }
            if (this.h0 % Z0 == 0) {
                if (i7 > 0 && (i3 = this.i0) < this.a0) {
                    this.i0 = i3 + 1;
                }
                if (i8 < 0 && (i2 = this.i0) > 0) {
                    this.i0 = i2 - 1;
                }
            }
            if (this.h0 > 0) {
                this.V.setImageResource(R.drawable.icon_shengyin_open);
            } else {
                this.V.setImageResource(R.drawable.icon_shengyin_close);
            }
            this.X.setStreamVolume(3, this.i0, 0);
            this.U.setProgress(this.h0);
        }
    }

    public void s1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z2) == null) {
            this.z0 = z2;
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || this.o == null) {
            return;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.V0);
        this.N.setAnimationListener(null);
        this.M.setAnimationListener(null);
        this.o.clearAnimation();
    }

    public void t1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            this.J = z2;
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.V0);
            d.a.c.e.m.e.a().postDelayed(this.V0, 3000L);
        }
    }

    public final void u1(int i2) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048668, this, i2) == null) && (videoListMediaControllerView = this.f60737h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60737h.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f60737h.setLayoutParams(layoutParams);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            k2();
            d.a.c.e.m.e.a().removeCallbacks(this.V0);
            d.a.c.e.m.e.a().removeCallbacks(this.L0);
            d.a.c.e.m.e.a().removeCallbacks(this.O0);
            d.a.c.e.m.e.a().removeCallbacks(this.Q0);
            d.a.c.e.m.e.a().removeCallbacks(this.S0);
            this.f0.k();
            a1.unregister(this.G0);
        }
    }

    public void v1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            x0();
            u0();
        }
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && d.a.c.e.p.j.z() && this.A0 && !StringUtils.isNull(this.x) && !StringUtils.isNull(this.z)) {
            this.A0 = false;
            this.B0 = true;
            d2(this.x, this.z);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || this.o == null || this.I || this.F0) {
            return;
        }
        c2(true);
        t0();
        this.o.setVisibility(0);
        this.p.setVisibility(0);
        this.f60738i.setVisibility(8);
        this.I = true;
        y yVar = this.Y;
        if (yVar != null) {
            yVar.a(false);
        }
    }

    public void x1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, str) == null) {
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.s = true;
            this.f60734e.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(d.a.o0.z0.g.c().f(this.G0)), Integer.parseInt(d.a.o0.z0.g.c().e(this.G0))));
            A0(this.G0, true);
            this.q.setVisibility(0);
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            this.l.setVisibility(8);
            this.f60736g.b();
            this.B.setVisibility(8);
            this.n.setImageResource(R.drawable.icon_video_narrow_white);
            u1(this.g0);
            Q1();
            x xVar = this.O;
            if (xVar != null) {
                xVar.a();
            }
        }
    }

    public void y1(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, xVar) == null) {
            this.O = xVar;
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            this.s = false;
            FrameLayout.LayoutParams layoutParams = this.m;
            if (layoutParams != null) {
                this.f60734e.setLayoutParams(layoutParams);
            }
            A0(this.G0, false);
            this.q.setVisibility(8);
            this.l.setVisibility(0);
            this.f60736g.b();
            this.B.setVisibility(8);
            this.n.setImageResource(R.drawable.icon_video_enlarge_white);
            VideoListMediaControllerView videoListMediaControllerView = this.f60737h;
            if (videoListMediaControllerView != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f60737h.getLayoutParams();
                layoutParams2.leftMargin = d.a.c.e.p.l.g(this.G0, R.dimen.tbds24);
                layoutParams2.rightMargin = 0;
                this.f60737h.setLayoutParams(layoutParams2);
            }
            this.f60734e.setSystemUiVisibility(0);
            R1();
            x xVar = this.O;
            if (xVar != null) {
                xVar.b();
            }
        }
    }

    public void z1(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, yVar) == null) {
            this.Y = yVar;
        }
    }
}
