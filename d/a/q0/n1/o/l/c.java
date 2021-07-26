package d.a.q0.n1.o.l;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.o0;
import d.a.p0.s.s.a;
import d.a.q0.w2.w;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static int s0;
    public static CallStateReceiver t0;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public boolean B;
    public boolean C;
    public boolean D;
    public Animation E;
    public Animation F;
    public p G;
    public int H;
    public GestureDetector I;
    public WindowManager J;
    public View K;
    public View L;
    public TextView M;
    public SeekBar N;
    public ImageView O;
    public ImageView P;
    public AudioManager Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public String V;
    public String W;
    public d.a.q0.n2.j X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61214a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public SwipeBackLayout.c f61215b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.n1.o.l.n f61216c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f61217d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public View f61218e;
    public WeakReference<Context> e0;

    /* renamed from: f  reason: collision with root package name */
    public TbCyberVideoView f61219f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public View f61220g;
    public CyberPlayerManager.OnPreparedListener g0;

    /* renamed from: h  reason: collision with root package name */
    public VideoListMediaControllerView f61221h;
    public Runnable h0;

    /* renamed from: i  reason: collision with root package name */
    public View f61222i;
    public CyberPlayerManager.OnCompletionListener i0;
    public View j;
    public CyberPlayerManager.OnErrorListener j0;
    public FrameLayout k;
    public Runnable k0;
    public FrameLayout.LayoutParams l;
    public TbCyberVideoView.h l0;
    public ImageView m;
    public View.OnClickListener m0;
    public ImageView n;
    public boolean n0;
    public ImageView o;
    public Animation.AnimationListener o0;
    public View p;
    public Animation.AnimationListener p0;
    public int q;
    public Runnable q0;
    public View r;
    public CustomMessageListener r0;
    public boolean s;
    public ImageView t;
    public String u;
    public TbImageView v;
    public CyberPlayerManager.OnPreparedListener w;
    public d.a.q0.n1.o.l.l x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes8.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f61223a;

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
            this.f61223a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f61223a.p == null) {
                return;
            }
            this.f61223a.p.setVisibility(8);
            this.f61223a.D = false;
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

    /* renamed from: d.a.q0.n1.o.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class animation.Animation$AnimationListenerC1568c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f61224a;

        public animation.Animation$AnimationListenerC1568c(c cVar) {
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
            this.f61224a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f61224a.C = false;
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
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61225e;

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
            this.f61225e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61225e.l0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f61226a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c cVar, int i2) {
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
            this.f61226a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.f61226a.o0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61227e;

        public f(c cVar) {
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
            this.f61227e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                boolean onTouchEvent = this.f61227e.I.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    c cVar = this.f61227e;
                    if (cVar.s && cVar.B) {
                        if (this.f61227e.R == 1 && this.f61227e.U != 0) {
                            c cVar2 = this.f61227e;
                            cVar2.R(cVar2.U == 1 ? 1000.0f : -1000.0f, false);
                            this.f61227e.U = 0;
                            this.f61227e.T = 0;
                        }
                        if (!this.f61227e.f61219f.isPlaying() && 8 == this.f61227e.t.getVisibility()) {
                            this.f61227e.t.setVisibility(0);
                        }
                    }
                    this.f61227e.q0();
                }
                return onTouchEvent;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61228e;

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
                    return;
                }
            }
            this.f61228e = cVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            d.a.d.e.m.e.a().removeCallbacks(this.f61228e.h0);
            d.a.d.e.m.e.a().post(this.f61228e.h0);
            d.a.d.e.m.e.a().removeCallbacks(this.f61228e.k0);
            if (this.f61228e.f61219f == null || this.f61228e.f61221h == null) {
                return;
            }
            if (!this.f61228e.d0) {
                c cVar = this.f61228e;
                if (!cVar.s) {
                    cVar.f61219f.setVolume(0.0f, 0.0f);
                    o0.e(this.f61228e.e0, false);
                    this.f61228e.f61221h.o(this.f61228e.H, this.f61228e.f61219f.getDuration());
                    if (this.f61228e.H != 0) {
                        this.f61228e.f61219f.seekTo(this.f61228e.H);
                    }
                    if (this.f61228e.w == null) {
                        this.f61228e.w.onPrepared();
                        return;
                    }
                    return;
                }
            }
            this.f61228e.f61219f.setVolume(1.0f, 1.0f);
            o0.e(this.f61228e.e0, true);
            this.f61228e.f61221h.o(this.f61228e.H, this.f61228e.f61219f.getDuration());
            if (this.f61228e.H != 0) {
            }
            if (this.f61228e.w == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61229e;

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
                    return;
                }
            }
            this.f61229e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f61229e.f61219f.getCurrentPositionSync() > 100) {
                    this.f61229e.B = true;
                    this.f61229e.f61222i.setVisibility(8);
                    this.f61229e.j.setVisibility(8);
                    this.f61229e.f61220g.setVisibility(8);
                    this.f61229e.v.setVisibility(8);
                    this.f61229e.U();
                    if (this.f61229e.p != null) {
                        this.f61229e.p.setVisibility(0);
                    }
                    this.f61229e.f61221h.s();
                    return;
                }
                d.a.d.e.m.e.a().postDelayed(this.f61229e.h0, 20L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61230e;

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
            this.f61230e = cVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61230e.B = false;
                this.f61230e.H = 0;
                c cVar = this.f61230e;
                if (cVar.s) {
                    cVar.q0();
                    this.f61230e.t0();
                    this.f61230e.X();
                } else {
                    cVar.r0();
                }
                if (this.f61230e.x != null) {
                    this.f61230e.x.a(this.f61230e.u);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61231e;

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
            this.f61231e = cVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f61231e.j.setVisibility(0);
                this.f61231e.f61220g.setVisibility(8);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61232e;

        public k(c cVar) {
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
            this.f61232e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61232e.j.setVisibility(0);
                this.f61232e.f61220g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61233e;

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
            this.f61233e = cVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61233e.B = false;
                d.a.d.e.m.e.a().removeCallbacks(this.f61233e.h0);
                d.a.d.e.m.e.a().removeCallbacks(this.f61233e.k0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61234e;

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
            this.f61234e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() != this.f61234e.j.getId()) {
                    if (view.getId() != this.f61234e.t.getId() && view.getId() != this.f61234e.n.getId()) {
                        if (view.getId() != this.f61234e.o.getId()) {
                            if (view.getId() == this.f61234e.y.getId()) {
                                TiebaStatic.log(new StatisticItem("c11713"));
                                this.f61234e.Q0();
                                return;
                            } else if (view.getId() == this.f61234e.f61217d.getId()) {
                                if (this.f61234e.B || this.f61234e.s) {
                                    this.f61234e.X();
                                    return;
                                }
                                return;
                            } else if (view.getId() == this.f61234e.m.getId()) {
                                c cVar = this.f61234e;
                                if (cVar.s) {
                                    return;
                                }
                                if (cVar.d0) {
                                    this.f61234e.f61219f.setVolume(0.0f, 0.0f);
                                    this.f61234e.m.setImageResource(R.drawable.card_icon_sound_close);
                                    o0.e(this.f61234e.e0, false);
                                    this.f61234e.d0 = false;
                                    return;
                                }
                                this.f61234e.f61219f.setVolume(1.0f, 1.0f);
                                this.f61234e.m.setImageResource(R.drawable.card_icon_sound_open);
                                o0.e(this.f61234e.e0, true);
                                this.f61234e.d0 = true;
                                return;
                            } else {
                                return;
                            }
                        }
                        c cVar2 = this.f61234e;
                        if (cVar2.s) {
                            SwipeBackLayout.c cVar3 = cVar2.f61215b;
                            if (cVar3 != null) {
                                cVar3.enableSwipeBack();
                            }
                            TiebaStatic.log(new StatisticItem("c11714"));
                        } else {
                            SwipeBackLayout.c cVar4 = cVar2.f61215b;
                            if (cVar4 != null) {
                                cVar4.disableSwipeBack();
                            }
                            TiebaStatic.log(new StatisticItem("c11710"));
                            w.o().l().b(this.f61234e.V, this.f61234e.W);
                        }
                        this.f61234e.Q0();
                        return;
                    } else if (!d.a.d.e.p.j.z()) {
                        d.a.d.e.p.l.J(this.f61234e.f61214a.getPageActivity(), this.f61234e.f61214a.getString(R.string.neterror));
                        return;
                    } else if (!this.f61234e.f61219f.isPlaying()) {
                        if (this.f61234e.B) {
                            this.f61234e.s0();
                            return;
                        } else {
                            this.f61234e.p0();
                            return;
                        }
                    } else {
                        this.f61234e.o0();
                        return;
                    }
                }
                this.f61234e.p0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61235e;

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
            this.f61235e = cVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f61235e.n0 = true;
                c cVar = this.f61235e;
                cVar.O0(cVar.u);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61236e;

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
            this.f61236e = cVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                c cVar = this.f61236e;
                if (cVar.s && cVar.B) {
                    if (!this.f61236e.f61219f.isPlaying() && this.f61236e.t.getVisibility() == 0 && this.f61236e.R == 1) {
                        this.f61236e.t.setVisibility(8);
                    }
                    if (this.f61236e.R == 0) {
                        this.f61236e.F0();
                        if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                            this.f61236e.R = 1;
                            c cVar2 = this.f61236e;
                            cVar2.T = cVar2.f61219f.getCurrentPositionSync();
                            this.f61236e.R(f2, true);
                        } else {
                            this.f61236e.R = 2;
                            this.f61236e.S(f3);
                        }
                    } else if (this.f61236e.R == 1) {
                        this.f61236e.R(f2, true);
                    } else if (this.f61236e.R == 2) {
                        this.f61236e.S(f3);
                    }
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ o(c cVar, f fVar) {
            this(cVar);
        }
    }

    /* loaded from: classes8.dex */
    public interface p {
        void a();

        void b();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.s = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.H = 0;
        this.R = 0;
        this.T = 0;
        this.U = 0;
        this.a0 = 0;
        this.d0 = false;
        this.e0 = null;
        this.f0 = true;
        this.g0 = new g(this);
        this.h0 = new h(this);
        this.i0 = new i(this);
        this.j0 = new j(this);
        this.k0 = new k(this);
        this.l0 = new l(this);
        this.m0 = new m(this);
        this.n0 = false;
        this.o0 = new b(this);
        this.p0 = new animation.Animation$AnimationListenerC1568c(this);
        this.q0 = new d(this);
        this.r0 = new e(this, 2016503);
        this.f61214a = tbPageContext;
        this.e0 = new WeakReference<>(TbadkCoreApplication.getInst());
        View g0 = g0(tbPageContext);
        this.f61217d = g0;
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(g0);
        }
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f61217d.findViewById(R.id.videoView);
        this.f61219f = tbCyberVideoView;
        tbCyberVideoView.setStageType(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.f61220g = this.f61217d.findViewById(R.id.video_list_layout_loading);
        VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.f61217d.findViewById(R.id.media_controller);
        this.f61221h = videoListMediaControllerView;
        videoListMediaControllerView.setPlayer(this.f61219f);
        this.f61222i = this.f61217d.findViewById(R.id.black_mask);
        View findViewById = this.f61217d.findViewById(R.id.layout_error);
        this.j = findViewById;
        findViewById.setOnClickListener(this.m0);
        this.k = (FrameLayout) this.f61217d.findViewById(R.id.danmu_container);
        ImageView imageView = (ImageView) this.f61217d.findViewById(R.id.img_play_icon);
        this.n = imageView;
        imageView.setOnClickListener(this.m0);
        ImageView imageView2 = (ImageView) this.f61217d.findViewById(R.id.img_sound_control);
        this.m = imageView2;
        imageView2.setOnClickListener(this.m0);
        ImageView imageView3 = (ImageView) this.f61217d.findViewById(R.id.card_img_full_screen);
        this.o = imageView3;
        imageView3.setOnClickListener(this.m0);
        this.p = this.f61217d.findViewById(R.id.card_layout_media_controller);
        this.f61218e = this.f61217d.findViewById(R.id.rl_control);
        this.f61219f.setOnPreparedListener(this.g0);
        this.f61219f.setOnCompletionListener(this.i0);
        this.f61219f.setOnErrorListener(this.j0);
        this.f61219f.setOnSurfaceDestroyedListener(this.l0);
        ImageView imageView4 = (ImageView) this.f61217d.findViewById(R.id.img_play);
        this.t = imageView4;
        imageView4.setOnClickListener(this.m0);
        TbImageView tbImageView = (TbImageView) this.f61217d.findViewById(R.id.video_thumbnail);
        this.v = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.Y = d.a.d.e.p.l.k(this.f61214a.getPageActivity());
        this.Z = d0(this.f61214a.getPageActivity());
        ImageView imageView5 = (ImageView) this.f61217d.findViewById(R.id.img_exit);
        this.y = imageView5;
        imageView5.setOnClickListener(this.m0);
        this.z = (TextView) this.f61217d.findViewById(R.id.video_title);
        View findViewById2 = this.f61217d.findViewById(R.id.layout_title);
        this.A = findViewById2;
        findViewById2.setVisibility(8);
        this.E = AnimationUtils.loadAnimation(this.f61214a.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.F = AnimationUtils.loadAnimation(this.f61214a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.J = (WindowManager) this.f61214a.getPageActivity().getSystemService("window");
        this.I = new GestureDetector(this.f61214a.getPageActivity(), new o(this, null));
        AudioManager audioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.Q = audioManager;
        this.S = audioManager.getStreamMaxVolume(3);
        this.c0 = this.Q.getStreamVolume(3);
        s0 = 100 / this.S;
        this.f61217d.setOnTouchListener(new f(this));
        d.a.q0.n2.j jVar = new d.a.q0.n2.j(this.f61214a.getPageActivity());
        this.X = jVar;
        jVar.j();
        this.a0 = d.a.d.e.p.l.g(this.f61214a.getPageActivity(), R.dimen.ds16);
        if (t0 == null) {
            t0 = new CallStateReceiver();
        }
        t0.register(this.f61214a.getPageActivity());
        this.f61214a.registerListener(this.r0);
    }

    public void A0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.r = view;
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.n.setImageResource(R.drawable.icon_video_midpause);
            this.f61220g.setVisibility(8);
            this.t.setVisibility(0);
        }
    }

    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f0 = z;
        }
    }

    public void D0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.H = i2;
        }
    }

    public void E0(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f61215b = cVar;
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.f61217d.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.f61217d.setSystemUiVisibility(4);
            } else {
                this.f61217d.setSystemUiVisibility(5894);
            }
        }
    }

    public void G0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.v.M(str, 17, false);
        }
    }

    public void H0(d.a.q0.n1.o.l.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nVar) == null) {
            this.f61216c = nVar;
        }
    }

    public void I0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            StringHelper.numberUniformFormat(j2);
        }
    }

    public void J0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.u = str;
        }
    }

    public void K0(int i2) {
        d.a.q0.n1.o.l.n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (nVar = this.f61216c) == null || i2 == nVar.l()) {
            return;
        }
        this.f61216c.w();
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f61217d.setVisibility(0);
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61218e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.f61218e.setLayoutParams(layoutParams);
            this.o.setClickable(true);
            this.o.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.alignWithParent = false;
                layoutParams2.addRule(11, 0);
                layoutParams2.addRule(0, R.id.card_img_full_screen);
                int dimension = (int) (this.f61214a.getResources().getDimension(R.dimen.ds16) + 0.5f);
                this.m.setPadding((int) (this.f61214a.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.f61214a.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.f61214a.getResources().getDimension(R.dimen.ds16) + 0.5f), dimension);
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.f61221h.setVisibility(0);
                this.n.setVisibility(0);
                return;
            }
            this.f61221h.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void O0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f61219f.setVideoPath(str);
            this.f61219f.start();
            this.f61220g.setVisibility(0);
            this.v.setVisibility(0);
            this.t.setVisibility(8);
            this.n.setImageResource(R.drawable.icon_video_midplay);
            this.j.setVisibility(8);
            d.a.d.e.m.e.a().removeCallbacks(this.k0);
            d.a.d.e.m.e.a().postDelayed(this.k0, 60000L);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.R;
            if (i2 == 1) {
                if (this.K == null) {
                    View inflate = LayoutInflater.from(this.f61214a.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                    this.K = inflate;
                    this.M = (TextView) inflate.findViewById(R.id.show_time);
                    this.P = (ImageView) this.K.findViewById(R.id.arrow_icon);
                }
                if (this.K.getParent() == null) {
                    this.J.addView(this.K, Z());
                }
            } else if (i2 == 2) {
                if (this.L == null) {
                    View inflate2 = LayoutInflater.from(this.f61214a.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                    this.L = inflate2;
                    this.O = (ImageView) inflate2.findViewById(R.id.arrow_voice_icon);
                    this.N = (SeekBar) this.L.findViewById(R.id.show_voice_seekbar);
                }
                if (this.L.getParent() == null) {
                    this.J.addView(this.L, Z());
                }
            }
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            d.a.d.e.m.e.a().removeCallbacks(this.h0);
            d.a.d.e.m.e.a().removeCallbacks(this.k0);
            this.f61219f.stopPlayback();
            this.B = false;
            this.H = 0;
            r0();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.r == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61217d.getLayoutParams();
        this.l = layoutParams;
        layoutParams.width = this.r.getWidth();
        this.l.height = this.r.getHeight();
        int[] iArr = new int[2];
        this.r.getLocationOnScreen(iArr);
        FrameLayout.LayoutParams layoutParams2 = this.l;
        layoutParams2.topMargin = iArr[1] - this.q;
        this.f61217d.setLayoutParams(layoutParams2);
    }

    public void Q0() {
        d.a.q0.n2.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (jVar = this.X) == null) {
            return;
        }
        jVar.l();
    }

    public final void R(float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (f2 > 0.0f) {
                    this.T -= 1000;
                    this.U = 1;
                } else {
                    this.T += 1000;
                    this.U = 2;
                }
                int i2 = this.T;
                if (i2 < 0) {
                    this.T = 0;
                } else if (i2 > this.f61219f.getDuration()) {
                    this.T = this.f61219f.getDuration();
                }
            }
            P();
            String m2 = this.f61221h.m(this.T);
            if (f2 > 0.0f) {
                this.P.setImageResource(R.drawable.icon_kuaitui);
            } else {
                this.P.setImageResource(R.drawable.icon_kuaijin);
            }
            if (!StringUtils.isNull(m2)) {
                TextView textView = this.M;
                StringBuilder sb = new StringBuilder();
                sb.append(m2);
                sb.append("/");
                sb.append(this.f61221h.m(this.f61219f.getDuration()));
                textView.setText(sb);
            }
            this.f61221h.setCurrentDuration(this.T, !z);
        }
    }

    public void R0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) {
            this.V = str;
            this.W = str2;
        }
    }

    public final void S(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            if (!this.f61219f.isPlaying()) {
                this.R = 0;
                return;
            }
            P();
            int i6 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i6 > 0 && (i5 = this.b0) < 100) {
                this.b0 = i5 + 1;
            }
            int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i7 < 0 && (i4 = this.b0) > 0) {
                this.b0 = i4 - 1;
            }
            if (this.b0 % s0 == 0) {
                if (i6 > 0 && (i3 = this.c0) < this.S) {
                    this.c0 = i3 + 1;
                }
                if (i7 < 0 && (i2 = this.c0) > 0) {
                    this.c0 = i2 - 1;
                }
            }
            if (this.c0 > 0) {
                this.O.setImageResource(R.drawable.icon_shengyin_open);
            } else {
                this.O.setImageResource(R.drawable.icon_shengyin_close);
            }
            this.Q.setStreamVolume(3, this.c0, 0);
            this.N.setProgress(this.b0);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            U();
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.p == null) {
            return;
        }
        d.a.d.e.m.e.a().removeCallbacks(this.q0);
        this.F.setAnimationListener(null);
        this.E.setAnimationListener(null);
        this.p.clearAnimation();
        this.D = false;
        this.C = false;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            P0();
            d.a.d.e.m.e.a().removeCallbacks(this.q0);
            d.a.d.e.m.e.a().removeCallbacks(this.h0);
            d.a.d.e.m.e.a().removeCallbacks(this.k0);
            this.X.k();
            t0.unregister(this.f61214a.getPageActivity());
        }
    }

    public void W() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (view = this.p) == null || this.C) {
            return;
        }
        if (this.D || view.getVisibility() != 0) {
            U();
            this.p.setVisibility(0);
            this.F.setAnimationListener(this.p0);
            this.p.startAnimation(this.F);
            this.C = true;
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            W();
            d.a.d.e.m.e.a().removeCallbacks(this.q0);
            if (this.f0) {
                d.a.d.e.m.e.a().postDelayed(this.q0, 3000L);
            }
        }
    }

    public final void Y(BaseFragmentActivity baseFragmentActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, baseFragmentActivity, z) == null) || baseFragmentActivity == null || baseFragmentActivity.getWindow() == null) {
            return;
        }
        if (z) {
            WindowManager.LayoutParams attributes = baseFragmentActivity.getWindow().getAttributes();
            attributes.flags |= 1024;
            baseFragmentActivity.getWindow().setAttributes(attributes);
            baseFragmentActivity.getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = baseFragmentActivity.getWindow().getAttributes();
        attributes2.flags &= -1025;
        baseFragmentActivity.getWindow().setAttributes(attributes2);
        baseFragmentActivity.getWindow().clearFlags(512);
        this.f61220g.getVisibility();
    }

    public final WindowManager.LayoutParams Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public View b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public View c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    public int d0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                i2 = displayMetrics.heightPixels;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i2 == 0 ? d.a.d.e.p.l.i(context) : i2;
        }
        return invokeL.intValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? !this.s : invokeV.booleanValue;
    }

    public TbCyberVideoView f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f61219f : (TbCyberVideoView) invokeV.objValue;
    }

    public View g0(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, tbPageContext)) == null) ? LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_float_video_container, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public VideoListMediaControllerView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f61221h : (VideoListMediaControllerView) invokeV.objValue;
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && this.f61219f.getDuration() - i2 <= 3000 && this.s) {
            U();
            View view = this.p;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f61217d.setVisibility(8);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61218e.getLayoutParams();
            if (d.a.q0.n1.o.k.e.c(this.f61214a.getPageActivity())) {
                layoutParams.bottomMargin = (int) (this.f61214a.getResources().getDimension(R.dimen.ds40) + 0.5f);
            } else {
                layoutParams.bottomMargin = (int) (this.f61214a.getResources().getDimension(R.dimen.ds30) + 0.5f);
            }
            this.f61218e.setLayoutParams(layoutParams);
            this.o.setClickable(false);
            this.o.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.alignWithParent = true;
                int dimension = (int) (this.f61214a.getResources().getDimension(R.dimen.ds16) + 0.5f);
                this.m.setPadding((int) (this.f61214a.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.f61214a.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.f61214a.getResources().getDimension(R.dimen.ds38) + 0.5f), dimension);
                layoutParams2.addRule(11);
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public void l0() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (view = this.p) == null || this.D || view.getVisibility() != 0) {
            return;
        }
        U();
        this.p.setVisibility(0);
        this.E.setAnimationListener(this.o0);
        this.p.startAnimation(this.E);
        this.D = true;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f61217d.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void n0(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, baseFragmentActivity, configuration) == null) {
            if (configuration.orientation == 2) {
                this.s = true;
                this.m.setVisibility(8);
                this.f61219f.setVolume(1.0f, 1.0f);
                o0.e(this.e0, true);
                this.f61217d.setLayoutParams(new FrameLayout.LayoutParams(this.Z, this.Y));
                Y(baseFragmentActivity, true);
                this.A.setVisibility(0);
                v0(true);
                this.k.setVisibility(8);
                p pVar = this.G;
                if (pVar != null) {
                    pVar.a();
                }
                X();
                this.o.setImageResource(R.drawable.icon_suoxiao);
                w0(this.a0);
                F0();
                return;
            }
            this.s = false;
            this.m.setVisibility(0);
            if (this.d0) {
                this.f61219f.setVolume(1.0f, 1.0f);
                o0.e(this.e0, true);
            } else {
                this.f61219f.setVolume(0.0f, 0.0f);
                o0.e(this.e0, false);
            }
            FrameLayout.LayoutParams layoutParams = this.l;
            if (layoutParams != null) {
                this.f61217d.setLayoutParams(layoutParams);
            }
            Y(baseFragmentActivity, false);
            this.A.setVisibility(8);
            v0(false);
            this.k.setVisibility(0);
            p pVar2 = this.G;
            if (pVar2 != null) {
                pVar2.b();
            }
            if (!this.B && (view = this.p) != null) {
                view.clearAnimation();
                this.p.setVisibility(4);
            }
            q0();
            this.o.setImageResource(R.drawable.icon_fangda);
            w0(0);
            this.f61217d.setSystemUiVisibility(0);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.f61219f.pause();
            B0();
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (d.a.d.e.p.j.x() && !this.n0) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f61214a.getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new n(this));
                aVar.setNegativeButton(R.string.cancel, new a(this));
                aVar.create(this.f61214a).show();
                return;
            }
            O0(this.u);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.R == 0) {
            return;
        }
        this.R = 0;
        View view = this.K;
        if (view != null && view.getParent() != null) {
            try {
                this.J.removeView(this.K);
            } catch (IllegalArgumentException unused) {
            }
        }
        View view2 = this.L;
        if (view2 == null || view2.getParent() == null) {
            return;
        }
        try {
            this.J.removeView(this.L);
        } catch (IllegalArgumentException unused2) {
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.p == null) {
            return;
        }
        this.f61222i.setVisibility(0);
        this.t.setVisibility(0);
        this.f61220g.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.p.setVisibility(4);
        this.j.setVisibility(8);
        this.f61221h.q();
        this.v.setVisibility(0);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f61219f.start();
            this.n.setImageResource(R.drawable.icon_video_midplay);
            this.v.setVisibility(8);
            this.f61222i.setVisibility(8);
            this.f61220g.setVisibility(8);
            this.f61221h.s();
            this.t.setVisibility(8);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || this.p == null) {
            return;
        }
        this.f61222i.setVisibility(0);
        this.t.setVisibility(0);
        this.f61220g.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.p.setVisibility(0);
        this.j.setVisibility(8);
        this.f61221h.q();
        this.v.setVisibility(0);
    }

    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.q = i2;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            if (z) {
                this.f61217d.setOnClickListener(this.m0);
            } else {
                this.f61217d.setClickable(false);
            }
        }
    }

    public final void w0(int i2) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048627, this, i2) == null) && (videoListMediaControllerView = this.f61221h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61221h.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f61221h.setLayoutParams(layoutParams);
        }
    }

    public void x0(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, pVar) == null) {
            this.G = pVar;
        }
    }

    public void y0(d.a.q0.n1.o.l.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, lVar) == null) {
            this.x = lVar;
        }
    }

    public void z0(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onPreparedListener) == null) {
            this.w = onPreparedListener;
        }
    }
}
