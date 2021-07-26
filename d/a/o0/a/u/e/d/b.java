package d.a.o0.a.u.e.d;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h0.g.d;
import d.a.o0.a.j1.a;
import d.a.o0.a.k;
import d.a.o0.a.u.e.d.a;
import d.a.o0.a.v2.n0;
import d.a.o0.a.v2.q;
import d.a.o0.a.v2.q0;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f48005i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f48006a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f48007b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f48008c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.h0.g.d f48009d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f48010e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.a.t0.a f48011f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.a.u.e.d.a f48012g;

    /* renamed from: h  reason: collision with root package name */
    public j f48013h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f48014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f48015f;

        public a(b bVar, ShowFavoriteGuideApi.GuideType guideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48015f = bVar;
            this.f48014e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48015f.k();
                if (this.f48015f.f48013h != null) {
                    this.f48015f.f48013h.e(false);
                }
                ShowFavoriteGuideApi.z(this.f48014e, "flow_close_close", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* renamed from: d.a.o0.a.u.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC0914b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f48016e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f48017f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f48018g;

        /* renamed from: d.a.o0.a.u.e.d.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements a.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0914b f48019a;

            public a(View$OnClickListenerC0914b view$OnClickListenerC0914b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0914b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48019a = view$OnClickListenerC0914b;
            }

            @Override // d.a.o0.a.j1.a.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f48019a.f48018g.f48013h != null) {
                        this.f48019a.f48018g.f48013h.e(false);
                    }
                    d.a.o0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // d.a.o0.a.j1.a.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.f48019a.f48018g.f48013h != null) {
                        this.f48019a.f48018g.f48013h.e(true);
                    }
                    d.a.o0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public View$OnClickListenerC0914b(b bVar, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, guideType, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48018g = bVar;
            this.f48016e = guideType;
            this.f48017f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.o0.a.j1.a.h(this.f48017f, new a(this));
                this.f48018g.k();
                if (this.f48018g.f48007b != null) {
                    this.f48018g.f48007b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.f48016e;
                ShowFavoriteGuideApi.z(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f48020e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.g.g f48021f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.g.f f48022g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48023h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f48024i;
        public final /* synthetic */ b j;

        public c(b bVar, ViewTreeObserver viewTreeObserver, d.a.o0.a.h0.g.g gVar, d.a.o0.a.h0.g.f fVar, String str, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, viewTreeObserver, gVar, fVar, str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
            this.f48020e = viewTreeObserver;
            this.f48021f = gVar;
            this.f48022g = fVar;
            this.f48023h = str;
            this.f48024i = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.a.o0.a.h0.g.f fVar;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f48006a != null || (viewTreeObserver = this.f48020e) == null || !viewTreeObserver.isAlive()) {
                    if (this.j.f48009d != this.f48021f.m() || (!((fVar = this.f48022g) == null || TextUtils.equals(this.f48023h, fVar.g3())) || (!this.f48024i.m0() && n0.F()))) {
                        this.j.k();
                        ViewTreeObserver viewTreeObserver2 = this.f48020e;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.f48020e.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.f48020e.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f48025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f48026f;

        public d(b bVar, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48026f = bVar;
            this.f48025e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48026f.k();
                if (this.f48026f.f48013h != null) {
                    this.f48026f.f48013h.e(d.a.o0.a.j0.b.a.n(this.f48025e.f43885f));
                }
                if (this.f48026f.f48007b != null) {
                    this.f48026f.f48007b.cancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.InterfaceC0913a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f48027a;

        public e(b bVar) {
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
            this.f48027a = bVar;
        }

        @Override // d.a.o0.a.u.e.d.a.InterfaceC0913a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48027a.k();
            }
        }

        @Override // d.a.o0.a.u.e.d.a.InterfaceC0913a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && i2 == 1) {
                this.f48027a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f48028a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f48029b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f48030c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f48031e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48031e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d.a.o0.a.j0.b.a.n(this.f48031e.f48028a.f43885f)) {
                    f fVar = this.f48031e;
                    if (fVar.f48029b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.f48030c.f48013h != null) {
                        this.f48031e.f48030c.f48013h.e(true);
                    }
                    this.f48031e.f48030c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, Handler handler, d.a.o0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, handler, eVar, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48030c = bVar;
            this.f48028a = eVar;
            this.f48029b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                q.g().execute(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends d.a.o0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f48032a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f48033b;

        public g(b bVar, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48033b = bVar;
            this.f48032a = eVar;
        }

        @Override // d.a.o0.a.t0.a, d.a.o0.a.t0.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f48033b.f48006a != null && this.f48033b.f48006a.x()) {
                this.f48033b.k();
            }
        }

        @Override // d.a.o0.a.t0.a, d.a.o0.a.t0.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.o0.a.e0.d.g("FavoriteGuideHelper", "call onActivityDestroyed");
                this.f48033b.k();
                if (this.f48033b.f48008c == null || this.f48033b.f48011f == null) {
                    return;
                }
                this.f48033b.f48008c.unregisterCallback(this.f48033b.f48011f);
            }
        }

        @Override // d.a.o0.a.t0.a, d.a.o0.a.t0.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                d.a.o0.a.e0.d.g("FavoriteGuideHelper", "swanId=" + this.f48032a.f43885f + ", nowId=" + d.a.o0.a.a2.e.V());
                if (TextUtils.equals(this.f48032a.f43885f, d.a.o0.a.a2.e.V())) {
                    return;
                }
                this.f48033b.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f48034a;

        public h(b bVar) {
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
            this.f48034a = bVar;
        }

        @Override // d.a.o0.a.h0.g.d.m
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48034a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48035e;

        public i(b bVar) {
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
            this.f48035e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48035e.f48006a != null) {
                    this.f48035e.f48006a.r();
                    this.f48035e.f48006a = null;
                }
                if (this.f48035e.f48010e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.f48035e.f48010e);
                    this.f48035e.f48010e = null;
                }
                if (this.f48035e.f48008c != null && this.f48035e.f48011f != null) {
                    this.f48035e.f48008c.unregisterCallback(this.f48035e.f48011f);
                }
                if (this.f48035e.f48009d != null) {
                    this.f48035e.f48009d.w2(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void e(boolean z);
    }

    public b() {
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

    public static b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f48005i == null) {
                synchronized (b.class) {
                    if (f48005i == null) {
                        f48005i = new b();
                    }
                }
            }
            return f48005i;
        }
        return (b) invokeV.objValue;
    }

    @AnyThread
    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                q0.b0(new i(this));
            }
        }
    }

    public final void m() {
        d.a.o0.a.p.b.a.i k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f48012g == null && (k = d.a.o0.a.c1.b.k()) != null) {
            d.a.o0.a.u.e.d.a a2 = k.a();
            this.f48012g = a2;
            if (a2 != null) {
                a2.b(new e(this));
            }
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL : invokeL.booleanValue;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull d.a.o0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, eVar, guideType) == null) {
            synchronized (this) {
                this.f48010e = new f(this, null, eVar, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(d.a.o0.a.j0.b.a.d(), false, this.f48010e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.f48008c = swanAppActivity;
                    if (this.f48011f != null) {
                        swanAppActivity.unregisterCallback(this.f48011f);
                    }
                    g gVar = new g(this, eVar);
                    this.f48011f = gVar;
                    this.f48008c.registerCallback(gVar);
                }
                d.a.o0.a.h0.g.g swanAppFragmentManager = this.f48008c.getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return;
                }
                d.a.o0.a.h0.g.d m = swanAppFragmentManager.m();
                this.f48009d = m;
                if (m == null) {
                    return;
                }
                m.w2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull d.a.o0.a.a2.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        d.a.o0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, eVar, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.f48013h = jVar;
            k();
            if (eVar.m0()) {
                m();
                d.a.o0.a.u.e.d.a aVar = this.f48012g;
                if (aVar != null) {
                    aVar.c(0);
                }
            }
            o(activity, eVar, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? d.a.o0.a.g.aiapps_favorite_guide_tips : d.a.o0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(d.a.o0.a.f.favorite_guide_content);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(d.a.o0.a.f.titlebar_right_menu_img);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(d.a.o0.a.f.favorite_guide_container);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                int i2 = guideType.showWidth4px;
                int g2 = n0.g(7.0f);
                int o = n0.o(null);
                int i3 = g2 * 2;
                if (o - i2 < i3) {
                    i2 = o - i3;
                }
                layoutParams.width = i2;
                relativeLayout.setLayoutParams(layoutParams);
                q0.U((ImageView) inflate.findViewById(d.a.o0.a.f.favorite_guide_icon), str2, d.a.o0.a.e.aiapps_default_grey_icon);
                ImageView imageView = (ImageView) inflate.findViewById(d.a.o0.a.f.favorite_guide_close);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(d.a.o0.a.f.favorite_guide_add_btn)).setOnClickListener(new View$OnClickListenerC0914b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.f48006a = popupWindow;
                popupWindow.N(16);
                this.f48006a.Q(activity.getWindow().getDecorView(), 81, 0, (int) n0.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(d.a.o0.a.f.favorite_guide_arrow).setPadding(0, 0, ((n0.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - n0.g(7.0f), 0);
                this.f48006a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.f48008c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f48008c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.f48006a.P(findViewById, 0, -n0.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (k.f46335a) {
                            Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f48008c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
                d.a.o0.a.h0.g.f l = swanAppFragmentManager.l();
                String g3 = l == null ? "" : l.g3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, swanAppFragmentManager, l, g3, eVar));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.f48007b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.f48007b = timer2;
                timer2.schedule(new d(this, eVar), 1000 * j2);
            }
            ShowFavoriteGuideApi.z(guideType, "", "show");
        }
    }
}
