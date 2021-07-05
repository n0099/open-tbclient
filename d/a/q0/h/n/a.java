package d.a.q0.h.n;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v0.c;
import d.a.q0.a.v2.f0;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.x;
import d.a.q0.a.v2.x0;
import d.a.q0.a.z1.b.c.a;
import d.a.q0.h.o0.g.f.c;
import d.a.q0.k.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.h0.g.d implements d.a.q0.h.e0.a.b.b, a.InterfaceC1054a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f1;
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixGameSurfaceView C0;
    public View D0;
    public ImageView E0;
    public View F0;
    public ImageView G0;
    public FrameLayout H0;
    public View I0;
    public d.a.q0.h.o0.c J0;
    public d.a.q0.h.o0.c K0;
    public d.a.q0.h.e0.a.b.a L0;
    public d.a.q0.a.z1.b.c.a M0;
    public d.a.q0.h.o0.a N0;
    public TextView O0;
    public boolean P0;
    public m Q0;
    public volatile boolean R0;
    public AudioManager S0;
    public boolean T0;
    public l U0;
    public OrientationEventListener V0;
    public String W0;
    public GameCloseGuidePopView X0;
    public d.a.q0.h.o0.g.f.c Y0;
    public boolean Z0;
    public View a1;
    public boolean b1;
    public long c1;
    public long d1;
    public boolean e1;

    /* renamed from: d.a.q0.h.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1151a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53414e;

        public RunnableC1151a(a aVar) {
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
            this.f53414e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53414e.H0.removeView(this.f53414e.I0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.l0.a f53415a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f53416b;

        /* renamed from: d.a.q0.h.n.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1152a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f53417e;

            public RunnableC1152a(b bVar) {
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
                this.f53417e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int b2;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f0.q(this.f53417e.f53416b.h(), this.f53417e.f53416b.D0) && (b2 = f0.b(this.f53417e.f53416b.h())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f53417e.f53416b.D0.getLayoutParams();
                    layoutParams.rightMargin += b2;
                    this.f53417e.f53416b.D0.setLayoutParams(layoutParams);
                    d.a.q0.h.t.a.e().b(b2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Context context, int i2, d.a.q0.a.l0.a aVar2) {
            super(context, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Integer.valueOf(i2), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53416b = aVar;
            this.f53415a = aVar2;
        }

        @Override // android.view.OrientationEventListener
        @SuppressLint({"SourceLockedOrientationActivity"})
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f53416b.J0.h()) {
                return;
            }
            if (260 >= i2 || i2 >= 280 || this.f53416b.W0.equals("landscape")) {
                if (80 >= i2 || i2 >= 100 || this.f53416b.W0.endsWith("landscapeReverse")) {
                    return;
                }
                this.f53416b.k0.setRequestedOrientation(8);
                this.f53416b.W0 = "landscapeReverse";
                d.a.q0.h.j0.a.a(this.f53415a, this.f53416b.W0);
                if (a.f1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.f53416b.W0);
                }
                this.f53416b.D0.postDelayed(new RunnableC1152a(this), 100L);
                return;
            }
            this.f53416b.k0.setRequestedOrientation(0);
            this.f53416b.W0 = "landscape";
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f53416b.D0.getLayoutParams();
            layoutParams.rightMargin = this.f53416b.z().getDimensionPixelSize(d.a.q0.a.d.aigames_action_bar_right_operation_margin);
            this.f53416b.D0.setLayoutParams(layoutParams);
            d.a.q0.h.t.a.e().b(0);
            d.a.q0.h.j0.a.a(this.f53415a, this.f53416b.W0);
            if (a.f1) {
                Log.d("SwanGameFragment", "onOrientationChanged: " + this.f53416b.W0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53418e;

        public c(a aVar) {
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
            this.f53418e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.h.t.a.i().a(this.f53418e.l0, this.f53418e.q());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53419a;

        public d(a aVar) {
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
            this.f53419a = aVar;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (a.f1) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i2 + ",mIsForeground:" + this.f53419a.R0);
                }
                if (this.f53419a.R0 || this.f53419a.q3()) {
                    d.a.q0.a.v2.f.e(this.f53419a.k0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53420e;

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
            this.f53420e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f53420e.q());
                if (!f0.q(this.f53420e.h(), this.f53420e.D0) || ((SwanAppActivity) this.f53420e.h()).isLandScape()) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f53420e.D0.getLayoutParams();
                layoutParams.topMargin = this.f53420e.D0.getTop() + e2;
                this.f53420e.D0.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53421e;

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
            this.f53421e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53421e.e2();
                d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
                fVar.f49123e = SupportMenuInflater.XML_MENU;
                this.f53421e.y1(fVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53422e;

        public g(a aVar) {
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
            this.f53422e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (a.f1 && d.a.q0.a.u1.a.a.e()) {
                    return;
                }
                d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
                if (i2 != null && TextUtils.equals(d.a.q0.a.a2.e.V(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.f53422e.x3();
                } else if (i2 != null && d.a.q0.a.v0.c.c().h()) {
                    this.f53422e.w3("exitButton");
                } else {
                    d.a.q0.a.v0.b bVar = new d.a.q0.a.v0.b();
                    bVar.h();
                    if (bVar.k()) {
                        d.a.q0.a.v0.c.c().j(this.f53422e.k0, bVar.f(), bVar.e(), bVar, this.f53422e.C1());
                        return;
                    }
                    this.f53422e.w3("exitButton");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53423a;

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
            this.f53423a = aVar;
        }

        @Override // d.a.q0.h.o0.g.f.c.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53423a.t3("pandacontinue");
                this.f53423a.Y0.dismiss();
            }
        }

        @Override // d.a.q0.h.o0.g.f.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f53423a.t3("pandaclose");
                this.f53423a.Y0.dismiss();
            }
        }

        @Override // d.a.q0.h.o0.g.f.c.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f53423a.t3("pandaexit");
                this.f53423a.Y0.dismiss();
                this.f53423a.e3();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53424a;

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
            this.f53424a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53424a.e3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f53424a.e3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f53424a.X0 == null) {
                return;
            }
            this.f53424a.H0.removeView(this.f53424a.X0);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53425a;

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
            this.f53425a = aVar;
        }

        @Override // d.a.q0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53425a.e3();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53426a;

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
            this.f53426a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f53426a.a1 != null) {
                    this.f53426a.H0.removeView(this.f53426a.a1);
                    this.f53426a.a1 = null;
                }
                this.f53426a.e3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53427a;

        /* renamed from: d.a.q0.h.n.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1153a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f53428e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f53429f;

            public RunnableC1153a(l lVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53429f = lVar;
                this.f53428e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53429f.f53427a.r3()) {
                    return;
                }
                int i2 = this.f53428e;
                if (i2 == -2) {
                    if (a.f1) {
                        Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    this.f53429f.f53427a.H2();
                } else if (i2 != -1) {
                } else {
                    if (a.f1) {
                        Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                    }
                    this.f53429f.f53427a.H2();
                }
            }
        }

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
            this.f53427a = aVar;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                q0.b0(new RunnableC1153a(this, i2));
            }
        }

        public /* synthetic */ l(a aVar, c cVar) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<TextView> f53430a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<DuMixGameSurfaceView> f53431b;

        public m(TextView textView, DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53430a = new WeakReference<>(textView);
            this.f53431b = new WeakReference<>(duMixGameSurfaceView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                TextView textView = this.f53430a.get();
                DuMixGameSurfaceView duMixGameSurfaceView = this.f53431b.get();
                if (textView != null) {
                    String valueOf = String.valueOf(duMixGameSurfaceView == null ? 0 : duMixGameSurfaceView.getFPS());
                    textView.setText(valueOf);
                    if (a.f1) {
                        Log.d("SwanGameFragment", "gameFps:" + valueOf);
                    }
                }
                sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035639437, "Ld/a/q0/h/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035639437, "Ld/a/q0/h/n/a;");
                return;
            }
        }
        f1 = d.a.q0.a.k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.L0 = new d.a.q0.h.e0.a.b.a();
        this.N0 = new d.a.q0.h.o0.a();
        this.R0 = true;
        this.W0 = "landscape";
        this.Z0 = false;
        this.e1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.b C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new j(this) : (c.b) invokeV.objValue;
    }

    public static a s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && n0.D(this.k0)) {
            d.a.q0.a.z1.b.f.e.f(d.a.q0.a.c1.a.b(), d.a.q0.f.g.aiapps_game_not_support_split_screen).F();
            this.k0.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup, bundle)) == null) {
            if (f1) {
                Log.d("SwanGameFragment", "onCreateView obj: " + this);
            }
            if (f0.p(h())) {
                f0.s(h());
            }
            View inflate = layoutInflater.inflate(d.a.q0.a.g.ai_games_fragment, viewGroup, false);
            o3(inflate);
            l3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public void C2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (duMixGameSurfaceView = this.C0) == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        this.C0.getV8Engine().F(new JSEvent("sharebtn"));
    }

    public void H2() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.T0) {
            AudioManager audioManager = this.S0;
            if (audioManager != null && (lVar = this.U0) != null) {
                audioManager.abandonAudioFocus(lVar);
                this.S0 = null;
                this.U0 = null;
            }
            this.T0 = false;
            if (f1) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (d.a.f0.a.j()) {
                return d.a.f0.a.j();
            }
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            if (i2 != null && TextUtils.equals(d.a.q0.a.a2.e.V(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return x3();
            }
            if (i2 != null && d.a.q0.a.v0.c.c().h()) {
                return w3(com.alipay.sdk.widget.j.m);
            }
            d.a.q0.a.v0.b bVar = new d.a.q0.a.v0.b();
            bVar.h();
            if (bVar.k()) {
                d.a.q0.a.v0.c.c().j(this.k0, bVar.f(), bVar.e(), bVar, C1());
                return true;
            }
            return w3(com.alipay.sdk.widget.j.m);
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.h.e0.a.b.b
    @NonNull
    public d.a.q0.h.e0.a.b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.L0 : (d.a.q0.h.e0.a.b.a) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Context q = q();
            if (q instanceof Activity) {
                x.a(q, ((Activity) q).getWindow().getDecorView().getWindowToken());
            }
            n3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.p0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(d.a.q0.a.j0.b.a.n(d.a.q0.a.a2.d.g().getAppId()));
            }
            if (d.a.q0.a.a2.e.Q() != null) {
                this.o0.m(d.a.q0.a.a2.e.Q().L().d0());
            }
            this.o0.r(d.a.q0.a.c1.a.H().a(), E1(), this.p0, false);
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Activity activity = this.k0;
            if (activity != null) {
                activity.moveTaskToBack(true);
            }
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            fVar.f49123e = IntentConfig.CLOSE;
            y1(fVar);
            ((SwanAppActivity) this.k0).handleSwanAppExit(1);
            x0.b().e(2);
        }
    }

    public final GameCloseGuidePopView.e f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new k(this) : (GameCloseGuidePopView.e) invokeV.objValue;
    }

    @NonNull
    public d.a.q0.h.o0.a g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.N0 : (d.a.q0.h.o0.a) invokeV.objValue;
    }

    @Override // d.a.q0.a.z1.b.c.a.InterfaceC1054a
    public d.a.q0.a.z1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        d.a.q0.h.o0.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.M0 == null && (cVar = this.K0) != null && cVar.getRootView() != null) {
                this.M0 = new d.a.q0.a.z1.b.c.a(this, this.K0.getRootView(), 0);
            }
            return this.M0;
        }
        return (d.a.q0.a.z1.b.c.a) invokeV.objValue;
    }

    public View h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.D0 : (View) invokeV.objValue;
    }

    public d.a.q0.h.o0.c i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.J0 : (d.a.q0.h.o0.c) invokeV.objValue;
    }

    public n j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.o0 : (n) invokeV.objValue;
    }

    public d.a.q0.h.o0.c k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.K0 : (d.a.q0.h.o0.c) invokeV.objValue;
    }

    public final void l3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (duMixGameSurfaceView = this.C0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            super.m1(z);
            if (f1) {
                Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (l0()) {
                if (z) {
                    resume();
                } else {
                    pause();
                }
            }
        }
    }

    public final void m3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            View findViewById = view.findViewById(d.a.q0.a.f.titlebar_right_menu);
            this.D0 = findViewById;
            findViewById.post(new e(this));
            this.E0 = (ImageView) view.findViewById(d.a.q0.a.f.titlebar_right_menu_img);
            this.F0 = view.findViewById(d.a.q0.a.f.titlebar_right_menu_line);
            this.G0 = (ImageView) view.findViewById(d.a.q0.a.f.titlebar_right_menu_exit);
            this.E0.setImageDrawable(z().getDrawable(d.a.q0.a.e.aiapps_action_bar_single_menu_white_selector));
            this.G0.setImageDrawable(z().getDrawable(d.a.q0.a.e.aiapps_action_bar_exit_white_selector));
            this.F0.setBackgroundResource(d.a.q0.a.c.aiapps_action_bar_menu_line_white);
            this.D0.setBackgroundResource(d.a.q0.a.e.aiapps_action_bar_right_menu_bg_solid);
            this.E0.setOnClickListener(new f(this));
            this.G0.setOnClickListener(new g(this));
        }
    }

    public void n3() {
        FragmentActivity h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (h2 = h()) == null) {
            return;
        }
        if (this.Z0) {
            n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.e(false);
            }
            this.o0 = null;
            this.Z0 = false;
        }
        if (this.p0 == null) {
            this.p0 = new SwanAppMenuHeaderView(q());
        }
        if (this.o0 == null) {
            n nVar2 = new n(h2, this.D0, 0, d.a.q0.a.c1.a.G(), new d.a.q0.a.w2.h.b());
            this.o0 = nVar2;
            nVar2.k(d.a.q0.a.v2.f.c());
            this.L0.b(this.o0);
            d.a.q0.a.p.b.a.k H = d.a.q0.a.g1.f.V().H();
            if (H != null) {
                H.b(this.o0);
            }
            new d.a.q0.a.j1.a(this.o0, this, this.p0).z();
        }
    }

    public void o3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(d.a.q0.a.f.ai_games_layout);
            this.H0 = frameLayout;
            DuMixGameSurfaceView r = d.a.q0.h.o.c.m().r();
            this.C0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.C0, 0, new FrameLayout.LayoutParams(-1, -1));
                if (f1) {
                    Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
                }
            }
            if (f1 && !d.a.q0.a.u1.a.a.n()) {
                View inflate = ((ViewStub) view.findViewById(d.a.q0.a.f.ai_games_fps_text_view_stub)).inflate();
                if (inflate != null) {
                    this.O0 = (TextView) inflate.findViewById(d.a.q0.a.f.ai_games_fps_text);
                }
                y3();
            }
            m3(view);
            this.K0 = new d.a.q0.h.o0.c((FrameLayout) view.findViewById(d.a.q0.a.f.ai_games_na_layout));
            this.J0 = new d.a.q0.h.o0.c(this.H0);
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            A3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onCreate(bundle);
            q.i(new c(this), "SwanGamePageHistory");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (f1) {
                Log.d("SwanGameFragment", "onDestroy() obj: " + this);
                z3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.C0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.C0.p();
            }
            if (this.b1) {
                this.a1 = null;
                d.a.q0.h.t.a.e().release();
            }
            d.a.q0.h.o0.c cVar = this.J0;
            if (cVar != null) {
                cVar.l();
            }
            d.a.q0.h.o0.c cVar2 = this.K0;
            if (cVar2 != null) {
                cVar2.l();
            }
            this.N0.e();
            d.a.q0.a.i1.b.c();
            d.a.q0.h.q.c.b.g(false);
            d.a.q0.h.q.c.b.k();
            super.onDestroy();
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (f1) {
                Log.d("SwanGameFragment", "onPause() obj: " + this);
            }
            super.onPause();
            if (W()) {
                pause();
            }
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (f1) {
                Log.d("SwanGameFragment", "onResume() obj: " + this);
            }
            super.onResume();
            if (W()) {
                resume();
            }
        }
    }

    public boolean p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? !this.R0 : invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.R0 = false;
            H2();
            if (this.I0 == null) {
                this.I0 = new View(this.k0);
            }
            this.H0.removeView(this.I0);
            this.H0.addView(this.I0, new FrameLayout.LayoutParams(-1, -1));
            GameCloseGuidePopView gameCloseGuidePopView = this.X0;
            if (gameCloseGuidePopView != null) {
                this.H0.removeView(gameCloseGuidePopView);
                this.X0 = null;
            }
            d.a.q0.h.o0.c cVar = this.J0;
            if (cVar != null) {
                cVar.k();
            }
            d.a.q0.h.o0.c cVar2 = this.K0;
            if (cVar2 != null) {
                cVar2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.C0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            d.a.q0.a.l0.a v8Engine = this.C0.getV8Engine();
            if (f1) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.s0()) {
                v8Engine.onPause();
                v8Engine.F(new JSEvent("apphide"));
                d.a.q0.h.j0.b.a(v8Engine);
                EventTarget p = v8Engine.p();
                if (p instanceof d.a.q0.h.d.b) {
                    ((d.a.q0.h.d.b) p).hideKeyboard();
                }
            }
            d.a.q0.h.c.j.b.h().l();
            if (this.e1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.d1 = currentTimeMillis;
                d.a.q0.h.j.a.d(this.c1, currentTimeMillis);
            }
            d.a.q0.h.b.d.p().n();
            d.a.q0.a.i1.b.i(false);
            this.C0.r();
            OrientationEventListener orientationEventListener = this.V0;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            n nVar = this.o0;
            if (nVar == null || !nVar.g()) {
                return;
            }
            this.o0.e(false);
        }
    }

    public final boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            d.a.q0.a.h0.g.g J1 = J1();
            return J1 != null && (J1.m() instanceof a);
        }
        return invokeV.booleanValue;
    }

    public final boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            boolean booleanValue = i2 == null ? false : i2.J().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            if (f1) {
                Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public void resume() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            u3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.C0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            d.a.q0.a.l0.a v8Engine = this.C0.getV8Engine();
            if (f1) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.R0 = true;
            this.C0.s();
            d.a.q0.h.c.j.b.h().k();
            d.a.q0.h.j0.b.b(v8Engine);
            Activity activity2 = this.k0;
            if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                v8Engine.F(new d.a.q0.h.w.e(((SwanAppActivity) activity2).getLaunchInfo()));
            }
            v8Engine.onResume();
            if (this.H0 != null && this.I0 != null) {
                q0.Y(new RunnableC1151a(this), 500L);
            }
            Activity activity3 = this.k0;
            if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) activity3).isLandScape();
                if (!this.J0.h()) {
                    this.k0.setRequestedOrientation(isLandScape ? this.W0.equals("landscape") ? 0 : 8 : 1);
                    this.J0.n(isLandScape);
                    this.K0.n(isLandScape);
                }
                d.a.q0.a.v2.f.e(this.k0);
            }
            if (this.V0 == null) {
                this.V0 = new b(this, this.k0, 3, v8Engine);
            }
            if (this.V0.canDetectOrientation() && (activity = this.k0) != null && ((SwanAppActivity) activity).isLandScape()) {
                this.V0.enable();
            } else {
                this.V0.disable();
            }
            this.e1 = false;
            if (d.a.q0.a.a2.e.i() != null && d.a.q0.a.a2.e.i().N() != null) {
                try {
                    this.e1 = new JSONObject(d.a.q0.a.a2.e.i().N().P().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                    this.c1 = System.currentTimeMillis();
                } catch (Exception e2) {
                    if (f1) {
                        e2.printStackTrace();
                    }
                }
            }
            d.a.q0.h.b.d.p().y();
            d.a.q0.a.i1.b.i(true);
            d.a.q0.h.o0.c cVar = this.J0;
            if (cVar != null) {
                cVar.m();
            }
            d.a.q0.h.o0.c cVar2 = this.K0;
            if (cVar2 != null) {
                cVar2.m();
            }
            A3();
        }
    }

    public final void t3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
        fVar.f49123e = str;
        y1(fVar);
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || r3() || this.T0) {
            return;
        }
        if (this.S0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.S0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.U0 == null) {
            this.U0 = new l(this, null);
        }
        this.T0 = this.S0.requestAudioFocus(this.U0, 3, 1) == 1;
        if (f1) {
            Log.d("SwanGameFragment", "   requestAudioFocus");
        }
    }

    public void v3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.Z0 = z;
        }
    }

    public boolean w3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            String a2 = d.a.q0.h.o0.g.f.b.a();
            if (TextUtils.equals(a2, d.a.q0.h.o0.g.f.b.b("date"))) {
                if (TextUtils.equals(str, "exitButton")) {
                    e3();
                    return false;
                }
                return false;
            }
            View a3 = d.a.q0.h.t.a.e().a(this.k0, f3());
            this.a1 = a3;
            if (a3 != null) {
                this.H0.addView(a3);
                this.b1 = true;
                d.a.q0.h.o0.g.f.b.c("date", a2);
                return true;
            }
            if (this.X0 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(q());
                this.X0 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.H0.addView(this.X0);
            d.a.q0.h.o0.g.f.b.c("date", a2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.Y0 == null) {
                d.a.q0.h.o0.g.f.c cVar = new d.a.q0.h.o0.g.f.c(q());
                this.Y0 = cVar;
                cVar.e(new h(this));
            }
            t3("pandadialog");
            this.Y0.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.P0) {
                if (f1) {
                    Log.d("SwanGameFragment", "Fps monitor already started");
                    return;
                }
                return;
            }
            this.P0 = true;
            m mVar = new m(this.O0, this.C0);
            this.Q0 = mVar;
            mVar.sendEmptyMessage(0);
            if (f1) {
                Log.d("SwanGameFragment", "Start fps monitor");
            }
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (!this.P0) {
                if (f1) {
                    Log.d("SwanGameFragment", "fps monitor not started yet");
                    return;
                }
                return;
            }
            this.P0 = false;
            m mVar = this.Q0;
            if (mVar != null) {
                mVar.removeMessages(0);
                this.Q0 = null;
            }
            if (f1) {
                Log.d("SwanGameFragment", "Stop fps monitor");
            }
        }
    }
}
