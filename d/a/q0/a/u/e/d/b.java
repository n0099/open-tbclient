package d.a.q0.a.u.e.d;

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
import d.a.q0.a.h0.g.d;
import d.a.q0.a.j1.a;
import d.a.q0.a.k;
import d.a.q0.a.u.e.d.a;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q;
import d.a.q0.a.v2.q0;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f50803i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f50804a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f50805b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f50806c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.h0.g.d f50807d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f50808e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.t0.a f50809f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.a.u.e.d.a f50810g;

    /* renamed from: h  reason: collision with root package name */
    public j f50811h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f50812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50813f;

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
            this.f50813f = bVar;
            this.f50812e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50813f.k();
                if (this.f50813f.f50811h != null) {
                    this.f50813f.f50811h.e(false);
                }
                ShowFavoriteGuideApi.z(this.f50812e, "flow_close_close", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* renamed from: d.a.q0.a.u.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC0956b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f50814e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f50815f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f50816g;

        /* renamed from: d.a.q0.a.u.e.d.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements a.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0956b f50817a;

            public a(View$OnClickListenerC0956b view$OnClickListenerC0956b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0956b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50817a = view$OnClickListenerC0956b;
            }

            @Override // d.a.q0.a.j1.a.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f50817a.f50816g.f50811h != null) {
                        this.f50817a.f50816g.f50811h.e(false);
                    }
                    d.a.q0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // d.a.q0.a.j1.a.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.f50817a.f50816g.f50811h != null) {
                        this.f50817a.f50816g.f50811h.e(true);
                    }
                    d.a.q0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public View$OnClickListenerC0956b(b bVar, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
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
            this.f50816g = bVar;
            this.f50814e = guideType;
            this.f50815f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.q0.a.j1.a.h(this.f50815f, new a(this));
                this.f50816g.k();
                if (this.f50816g.f50805b != null) {
                    this.f50816g.f50805b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.f50814e;
                ShowFavoriteGuideApi.z(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f50818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.g.g f50819f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.g.f f50820g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50821h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f50822i;
        public final /* synthetic */ b j;

        public c(b bVar, ViewTreeObserver viewTreeObserver, d.a.q0.a.h0.g.g gVar, d.a.q0.a.h0.g.f fVar, String str, d.a.q0.a.a2.e eVar) {
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
            this.f50818e = viewTreeObserver;
            this.f50819f = gVar;
            this.f50820g = fVar;
            this.f50821h = str;
            this.f50822i = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.a.q0.a.h0.g.f fVar;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f50804a != null || (viewTreeObserver = this.f50818e) == null || !viewTreeObserver.isAlive()) {
                    if (this.j.f50807d != this.f50819f.m() || (!((fVar = this.f50820g) == null || TextUtils.equals(this.f50821h, fVar.g3())) || (!this.f50822i.m0() && n0.F()))) {
                        this.j.k();
                        ViewTreeObserver viewTreeObserver2 = this.f50818e;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.f50818e.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.f50818e.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f50823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50824f;

        public d(b bVar, d.a.q0.a.a2.e eVar) {
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
            this.f50824f = bVar;
            this.f50823e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50824f.k();
                if (this.f50824f.f50811h != null) {
                    this.f50824f.f50811h.e(d.a.q0.a.j0.b.a.n(this.f50823e.f46683f));
                }
                if (this.f50824f.f50805b != null) {
                    this.f50824f.f50805b.cancel();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.InterfaceC0955a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50825a;

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
            this.f50825a = bVar;
        }

        @Override // d.a.q0.a.u.e.d.a.InterfaceC0955a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50825a.k();
            }
        }

        @Override // d.a.q0.a.u.e.d.a.InterfaceC0955a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && i2 == 1) {
                this.f50825a.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f50826a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f50827b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50828c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f50829e;

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
                this.f50829e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d.a.q0.a.j0.b.a.n(this.f50829e.f50826a.f46683f)) {
                    f fVar = this.f50829e;
                    if (fVar.f50827b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.f50828c.f50811h != null) {
                        this.f50829e.f50828c.f50811h.e(true);
                    }
                    this.f50829e.f50828c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, Handler handler, d.a.q0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
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
            this.f50828c = bVar;
            this.f50826a = eVar;
            this.f50827b = guideType;
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

    /* loaded from: classes8.dex */
    public class g extends d.a.q0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f50830a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f50831b;

        public g(b bVar, d.a.q0.a.a2.e eVar) {
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
            this.f50831b = bVar;
            this.f50830a = eVar;
        }

        @Override // d.a.q0.a.t0.a, d.a.q0.a.t0.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f50831b.f50804a != null && this.f50831b.f50804a.x()) {
                this.f50831b.k();
            }
        }

        @Override // d.a.q0.a.t0.a, d.a.q0.a.t0.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.e0.d.g("FavoriteGuideHelper", "call onActivityDestroyed");
                this.f50831b.k();
                if (this.f50831b.f50806c == null || this.f50831b.f50809f == null) {
                    return;
                }
                this.f50831b.f50806c.unregisterCallback(this.f50831b.f50809f);
            }
        }

        @Override // d.a.q0.a.t0.a, d.a.q0.a.t0.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                d.a.q0.a.e0.d.g("FavoriteGuideHelper", "swanId=" + this.f50830a.f46683f + ", nowId=" + d.a.q0.a.a2.e.V());
                if (TextUtils.equals(this.f50830a.f46683f, d.a.q0.a.a2.e.V())) {
                    return;
                }
                this.f50831b.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50832a;

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
            this.f50832a = bVar;
        }

        @Override // d.a.q0.a.h0.g.d.m
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50832a.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50833e;

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
            this.f50833e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f50833e.f50804a != null) {
                    this.f50833e.f50804a.r();
                    this.f50833e.f50804a = null;
                }
                if (this.f50833e.f50808e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.f50833e.f50808e);
                    this.f50833e.f50808e = null;
                }
                if (this.f50833e.f50806c != null && this.f50833e.f50809f != null) {
                    this.f50833e.f50806c.unregisterCallback(this.f50833e.f50809f);
                }
                if (this.f50833e.f50807d != null) {
                    this.f50833e.f50807d.w2(null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if (f50803i == null) {
                synchronized (b.class) {
                    if (f50803i == null) {
                        f50803i = new b();
                    }
                }
            }
            return f50803i;
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
        d.a.q0.a.p.b.a.i k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f50810g == null && (k = d.a.q0.a.c1.b.k()) != null) {
            d.a.q0.a.u.e.d.a a2 = k.a();
            this.f50810g = a2;
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

    public final synchronized void o(@NonNull Activity activity, @NonNull d.a.q0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, eVar, guideType) == null) {
            synchronized (this) {
                this.f50808e = new f(this, null, eVar, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(d.a.q0.a.j0.b.a.d(), false, this.f50808e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.f50806c = swanAppActivity;
                    if (this.f50809f != null) {
                        swanAppActivity.unregisterCallback(this.f50809f);
                    }
                    g gVar = new g(this, eVar);
                    this.f50809f = gVar;
                    this.f50806c.registerCallback(gVar);
                }
                d.a.q0.a.h0.g.g swanAppFragmentManager = this.f50806c.getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return;
                }
                d.a.q0.a.h0.g.d m = swanAppFragmentManager.m();
                this.f50807d = m;
                if (m == null) {
                    return;
                }
                m.w2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull d.a.q0.a.a2.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        d.a.q0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, eVar, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.f50811h = jVar;
            k();
            if (eVar.m0()) {
                m();
                d.a.q0.a.u.e.d.a aVar = this.f50810g;
                if (aVar != null) {
                    aVar.c(0);
                }
            }
            o(activity, eVar, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? d.a.q0.a.g.aiapps_favorite_guide_tips : d.a.q0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(d.a.q0.a.f.favorite_guide_content);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(d.a.q0.a.f.titlebar_right_menu_img);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(d.a.q0.a.f.favorite_guide_container);
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
                q0.U((ImageView) inflate.findViewById(d.a.q0.a.f.favorite_guide_icon), str2, d.a.q0.a.e.aiapps_default_grey_icon);
                ImageView imageView = (ImageView) inflate.findViewById(d.a.q0.a.f.favorite_guide_close);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(d.a.q0.a.f.favorite_guide_add_btn)).setOnClickListener(new View$OnClickListenerC0956b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.f50804a = popupWindow;
                popupWindow.N(16);
                this.f50804a.Q(activity.getWindow().getDecorView(), 81, 0, (int) n0.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(d.a.q0.a.f.favorite_guide_arrow).setPadding(0, 0, ((n0.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - n0.g(7.0f), 0);
                this.f50804a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.f50806c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f50806c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.f50804a.P(findViewById, 0, -n0.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (k.f49133a) {
                            Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f50806c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
                d.a.q0.a.h0.g.f l = swanAppFragmentManager.l();
                String g3 = l == null ? "" : l.g3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, swanAppFragmentManager, l, g3, eVar));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.f50805b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.f50805b = timer2;
                timer2.schedule(new d(this, eVar), 1000 * j2);
            }
            ShowFavoriteGuideApi.z(guideType, "", "show");
        }
    }
}
