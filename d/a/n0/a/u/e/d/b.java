package d.a.n0.a.u.e.d;

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
import d.a.n0.a.h0.g.d;
import d.a.n0.a.j1.a;
import d.a.n0.a.k;
import d.a.n0.a.u.e.d.a;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.q;
import d.a.n0.a.v2.q0;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f47501i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f47502a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f47503b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppActivity f47504c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.a.h0.g.d f47505d;

    /* renamed from: e  reason: collision with root package name */
    public ContentObserver f47506e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.a.t0.a f47507f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.a.u.e.d.a f47508g;

    /* renamed from: h  reason: collision with root package name */
    public j f47509h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f47510e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f47511f;

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
            this.f47511f = bVar;
            this.f47510e = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47511f.k();
                if (this.f47511f.f47509h != null) {
                    this.f47511f.f47509h.e(false);
                }
                ShowFavoriteGuideApi.z(this.f47510e, "flow_close_close", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* renamed from: d.a.n0.a.u.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC0905b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f47512e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47513f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f47514g;

        /* renamed from: d.a.n0.a.u.e.d.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements a.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0905b f47515a;

            public a(View$OnClickListenerC0905b view$OnClickListenerC0905b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0905b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47515a = view$OnClickListenerC0905b;
            }

            @Override // d.a.n0.a.j1.a.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f47515a.f47514g.f47509h != null) {
                        this.f47515a.f47514g.f47509h.e(false);
                    }
                    d.a.n0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // d.a.n0.a.j1.a.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.f47515a.f47514g.f47509h != null) {
                        this.f47515a.f47514g.f47509h.e(true);
                    }
                    d.a.n0.a.e0.d.g("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public View$OnClickListenerC0905b(b bVar, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
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
            this.f47514g = bVar;
            this.f47512e = guideType;
            this.f47513f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.n0.a.j1.a.h(this.f47513f, new a(this));
                this.f47514g.k();
                if (this.f47514g.f47503b != null) {
                    this.f47514g.f47503b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.f47512e;
                ShowFavoriteGuideApi.z(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f47516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.g f47517f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.f f47518g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47519h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f47520i;
        public final /* synthetic */ b j;

        public c(b bVar, ViewTreeObserver viewTreeObserver, d.a.n0.a.h0.g.g gVar, d.a.n0.a.h0.g.f fVar, String str, d.a.n0.a.a2.e eVar) {
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
            this.f47516e = viewTreeObserver;
            this.f47517f = gVar;
            this.f47518g = fVar;
            this.f47519h = str;
            this.f47520i = eVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.a.n0.a.h0.g.f fVar;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f47502a != null || (viewTreeObserver = this.f47516e) == null || !viewTreeObserver.isAlive()) {
                    if (this.j.f47505d != this.f47517f.m() || (!((fVar = this.f47518g) == null || TextUtils.equals(this.f47519h, fVar.g3())) || (!this.f47520i.m0() && n0.F()))) {
                        this.j.k();
                        ViewTreeObserver viewTreeObserver2 = this.f47516e;
                        if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                            return;
                        }
                        this.f47516e.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                }
                this.f47516e.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f47521e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f47522f;

        public d(b bVar, d.a.n0.a.a2.e eVar) {
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
            this.f47522f = bVar;
            this.f47521e = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47522f.k();
                if (this.f47522f.f47509h != null) {
                    this.f47522f.f47509h.e(d.a.n0.a.j0.b.a.n(this.f47521e.f43381f));
                }
                if (this.f47522f.f47503b != null) {
                    this.f47522f.f47503b.cancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.InterfaceC0904a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47523a;

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
            this.f47523a = bVar;
        }

        @Override // d.a.n0.a.u.e.d.a.InterfaceC0904a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47523a.k();
            }
        }

        @Override // d.a.n0.a.u.e.d.a.InterfaceC0904a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && i2 == 1) {
                this.f47523a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f47524a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType f47525b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f47526c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f47527e;

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
                this.f47527e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d.a.n0.a.j0.b.a.n(this.f47527e.f47524a.f43381f)) {
                    f fVar = this.f47527e;
                    if (fVar.f47525b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.f47526c.f47509h != null) {
                        this.f47527e.f47526c.f47509h.e(true);
                    }
                    this.f47527e.f47526c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, Handler handler, d.a.n0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
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
            this.f47526c = bVar;
            this.f47524a = eVar;
            this.f47525b = guideType;
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
    public class g extends d.a.n0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f47528a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f47529b;

        public g(b bVar, d.a.n0.a.a2.e eVar) {
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
            this.f47529b = bVar;
            this.f47528a = eVar;
        }

        @Override // d.a.n0.a.t0.a, d.a.n0.a.t0.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f47529b.f47502a != null && this.f47529b.f47502a.x()) {
                this.f47529b.k();
            }
        }

        @Override // d.a.n0.a.t0.a, d.a.n0.a.t0.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.e0.d.g("FavoriteGuideHelper", "call onActivityDestroyed");
                this.f47529b.k();
                if (this.f47529b.f47504c == null || this.f47529b.f47507f == null) {
                    return;
                }
                this.f47529b.f47504c.unregisterCallback(this.f47529b.f47507f);
            }
        }

        @Override // d.a.n0.a.t0.a, d.a.n0.a.t0.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                d.a.n0.a.e0.d.g("FavoriteGuideHelper", "swanId=" + this.f47528a.f43381f + ", nowId=" + d.a.n0.a.a2.e.V());
                if (TextUtils.equals(this.f47528a.f43381f, d.a.n0.a.a2.e.V())) {
                    return;
                }
                this.f47529b.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47530a;

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
            this.f47530a = bVar;
        }

        @Override // d.a.n0.a.h0.g.d.m
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47530a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f47531e;

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
            this.f47531e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47531e.f47502a != null) {
                    this.f47531e.f47502a.r();
                    this.f47531e.f47502a = null;
                }
                if (this.f47531e.f47506e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.f47531e.f47506e);
                    this.f47531e.f47506e = null;
                }
                if (this.f47531e.f47504c != null && this.f47531e.f47507f != null) {
                    this.f47531e.f47504c.unregisterCallback(this.f47531e.f47507f);
                }
                if (this.f47531e.f47505d != null) {
                    this.f47531e.f47505d.w2(null);
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
            if (f47501i == null) {
                synchronized (b.class) {
                    if (f47501i == null) {
                        f47501i = new b();
                    }
                }
            }
            return f47501i;
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
        d.a.n0.a.p.b.a.i k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f47508g == null && (k = d.a.n0.a.c1.b.k()) != null) {
            d.a.n0.a.u.e.d.a a2 = k.a();
            this.f47508g = a2;
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

    public final synchronized void o(@NonNull Activity activity, @NonNull d.a.n0.a.a2.e eVar, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, eVar, guideType) == null) {
            synchronized (this) {
                this.f47506e = new f(this, null, eVar, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(d.a.n0.a.j0.b.a.d(), false, this.f47506e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.f47504c = swanAppActivity;
                    if (this.f47507f != null) {
                        swanAppActivity.unregisterCallback(this.f47507f);
                    }
                    g gVar = new g(this, eVar);
                    this.f47507f = gVar;
                    this.f47504c.registerCallback(gVar);
                }
                d.a.n0.a.h0.g.g swanAppFragmentManager = this.f47504c.getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return;
                }
                d.a.n0.a.h0.g.d m = swanAppFragmentManager.m();
                this.f47505d = m;
                if (m == null) {
                    return;
                }
                m.w2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull d.a.n0.a.a2.e eVar, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        SwanAppActivity swanAppActivity;
        d.a.n0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, eVar, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.f47509h = jVar;
            k();
            if (eVar.m0()) {
                m();
                d.a.n0.a.u.e.d.a aVar = this.f47508g;
                if (aVar != null) {
                    aVar.c(0);
                }
            }
            o(activity, eVar, guideType);
            View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? d.a.n0.a.g.aiapps_favorite_guide_tips : d.a.n0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(d.a.n0.a.f.favorite_guide_content);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(d.a.n0.a.f.titlebar_right_menu_img);
            if (guideType != ShowFavoriteGuideApi.GuideType.TIPS) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(d.a.n0.a.f.favorite_guide_container);
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
                q0.U((ImageView) inflate.findViewById(d.a.n0.a.f.favorite_guide_icon), str2, d.a.n0.a.e.aiapps_default_grey_icon);
                ImageView imageView = (ImageView) inflate.findViewById(d.a.n0.a.f.favorite_guide_close);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(d.a.n0.a.f.favorite_guide_add_btn)).setOnClickListener(new View$OnClickListenerC0905b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.f47502a = popupWindow;
                popupWindow.N(16);
                this.f47502a.Q(activity.getWindow().getDecorView(), 81, 0, (int) n0.h(50.0f));
            } else if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(d.a.n0.a.f.favorite_guide_arrow).setPadding(0, 0, ((n0.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - n0.g(7.0f), 0);
                this.f47502a = new PopupWindow(inflate, -2, -2);
                SwanAppActivity swanAppActivity2 = this.f47504c;
                if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.f47504c.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.f47502a.P(findViewById, 0, -n0.g(3.0f));
                    } catch (WindowManager.BadTokenException e2) {
                        if (k.f45831a) {
                            Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.f47504c) != null && (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) != null && findViewById != null) {
                d.a.n0.a.h0.g.f l = swanAppFragmentManager.l();
                String g3 = l == null ? "" : l.g3();
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, swanAppFragmentManager, l, g3, eVar));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.f47503b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.f47503b = timer2;
                timer2.schedule(new d(this, eVar), 1000 * j2);
            }
            ShowFavoriteGuideApi.z(guideType, "", "show");
        }
    }
}
