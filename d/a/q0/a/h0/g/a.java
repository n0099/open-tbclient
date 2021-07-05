package d.a.q0.a.h0.g;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.h0.e.c;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.r1.j;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.r0;
import d.a.q0.a.y1.a;
import d.a.q0.a.y1.b;
import d.a.q0.a.z1.b.b.h;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.h0.g.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean N0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView C0;
    public BdBaseImageView D0;
    public TextView E0;
    public d.a.q0.a.w2.a F0;
    public long[] G0;
    public String H0;
    public String I0;
    public String J0;
    public Button K0;
    public RecyclerView L0;
    public SwanAppWebPopWindow M0;

    /* renamed from: d.a.q0.a.h0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0766a implements d.a.q0.d.i.a<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.k2.g.g f47910a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47911b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f47912c;

        /* renamed from: d.a.q0.a.h0.g.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterface$OnClickListenerC0767a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0767a(C0766a c0766a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0766a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    SwanAppActivity x = d.a.q0.a.a2.d.g().x();
                    if (x != null && Build.VERSION.SDK_INT >= 21) {
                        x.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public C0766a(a aVar, d.a.q0.a.k2.g.g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47912c = aVar;
            this.f47910a = gVar;
            this.f47911b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.d.i.a
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f47910a.putInt(this.f47911b, 1);
                } else {
                    this.f47910a.putInt(this.f47911b, 0);
                }
                h.a aVar = new h.a(this.f47912c.k0);
                aVar.U(d.a.q0.a.h.swan_offline_perf_tool_tip);
                aVar.v(d.a.q0.a.h.swan_offline_perf_tool_message);
                aVar.n(new d.a.q0.a.w2.h.a());
                aVar.O(d.a.q0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0767a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.k2.g.g f47913e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47914f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.d.i.a f47915g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f47916h;

        /* renamed from: d.a.q0.a.h0.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0768a implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f47917a;

            public C0768a(b bVar) {
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
                this.f47917a = bVar;
            }

            @Override // d.a.q0.a.h0.e.c.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.f47917a.f47915g.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.f47917a.f47916h.k0;
                    if (activity == null || activity.isDestroyed()) {
                        return;
                    }
                    d.a.q0.a.h0.e.c.b(this.f47917a.f47916h.k0, d.a.q0.a.h.swan_offline_perf_tool_tip, str);
                }
            }
        }

        public b(a aVar, d.a.q0.a.k2.g.g gVar, String str, d.a.q0.d.i.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar, str, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47916h = aVar;
            this.f47913e = gVar;
            this.f47914f = str;
            this.f47915g = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f47913e.getInt(this.f47914f, -1);
                if (i2 == 1) {
                    this.f47915g.run(Boolean.FALSE);
                } else if (i2 == 0) {
                    this.f47915g.run(Boolean.TRUE);
                } else {
                    d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
                    if (Q == null) {
                        return;
                    }
                    d.a.q0.a.h0.e.c.a(Q, this.f47916h.k0, new C0768a(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f47918e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f47919f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f47920g;

        public c(a aVar, View.OnLongClickListener onLongClickListener, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onLongClickListener, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47920g = aVar;
            this.f47918e = onLongClickListener;
            this.f47919f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.n2.l.b.a.d().g();
                this.f47918e.onLongClick(this.f47919f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f47921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f47922f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f47923g;

        public d(a aVar, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47923g = aVar;
            this.f47921e = runnable;
            this.f47922f = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.postDelayed(this.f47921e, this.f47922f);
                    return false;
                } else if (action == 1 || action == 3) {
                    view.removeCallbacks(this.f47921e);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements b.InterfaceC1041b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppRelatedSwanListAdapter f47924a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47925b;

        /* renamed from: d.a.q0.a.h0.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0769a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.y1.a f47926e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f47927f;

            public RunnableC0769a(e eVar, d.a.q0.a.y1.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47927f = eVar;
                this.f47926e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f47927f.f47925b.L0.setVisibility(0);
                    this.f47927f.f47924a.e(this.f47926e);
                }
            }
        }

        public e(a aVar, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppRelatedSwanListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47925b = aVar;
            this.f47924a = swanAppRelatedSwanListAdapter;
        }

        @Override // d.a.q0.a.y1.b.InterfaceC1041b
        public void a(d.a.q0.a.y1.a aVar) {
            List<a.C1040a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || (list = aVar.f51827a) == null || list.size() <= 0) {
                return;
            }
            q0.b0(new RunnableC0769a(this, aVar));
            SwanAppRelatedSwanListAdapter.d("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes8.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47928a;

        /* renamed from: d.a.q0.a.h0.g.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0770a implements d.a.q0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f47929e;

            public C0770a(f fVar) {
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
                this.f47929e = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        d.a.q0.a.e0.a.d(this.f47929e.f47928a.q());
                    } else {
                        d.a.q0.a.c1.b.h().a(this.f47929e.f47928a.k0, null);
                    }
                }
            }
        }

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
            this.f47928a = aVar;
        }

        @Override // d.a.q0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    d.a.q0.a.h0.e.c.c(this.f47928a.k0, str);
                } else if (d.a.q0.a.e0.a.a()) {
                    d.a.q0.a.e0.a.d(this.f47928a.q());
                } else {
                    d.a.q0.a.c1.b.h().f(new C0770a(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.q0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47930a;

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
            this.f47930a = aVar;
        }

        @Override // d.a.q0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.z1.b.f.e f2 = d.a.q0.a.z1.b.f.e.f(this.f47930a.q(), d.a.q0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // d.a.q0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.z1.b.f.e f2 = d.a.q0.a.z1.b.f.e.f(this.f47930a.q(), d.a.q0.a.h.aiapps_cancel_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // d.a.q0.a.q0.b.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d.a.q0.a.z1.b.f.e f2 = d.a.q0.a.z1.b.f.e.f(this.f47930a.q(), d.a.q0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.a.q0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47931a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47932b;

        public h(a aVar, String str) {
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
            this.f47932b = aVar;
            this.f47931a = str;
        }

        @Override // d.a.q0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.z1.b.f.e f2 = d.a.q0.a.z1.b.f.e.f(this.f47932b.q(), d.a.q0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // d.a.q0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.z1.b.f.e f2 = d.a.q0.a.z1.b.f.e.f(this.f47932b.q(), d.a.q0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // d.a.q0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d.a.q0.a.j0.b.a.t();
                if (d.a.q0.a.j1.a.k(this.f47932b.h())) {
                    d.a.q0.a.j1.a.p("aboutconcern", this.f47931a);
                    return;
                }
                Context q = this.f47932b.q();
                d.a.q0.a.z1.b.f.e g2 = d.a.q0.a.z1.b.f.e.g(q, d.a.q0.a.c1.a.e0().f(q));
                g2.l(2);
                g2.p(2);
                g2.F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47933e;

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
            this.f47933e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47933e.k3();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public FullScreenFloatView f47934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47935f;

        /* renamed from: d.a.q0.a.h0.g.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0771a implements d.a.q0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f47936e;

            public C0771a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47936e = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (bool.booleanValue()) {
                        d.a.q0.a.e0.a.c(this.f47936e.f47935f.q(), true);
                    } else {
                        d.a.q0.a.c1.b.h().a(this.f47936e.f47935f.k0, null);
                    }
                }
            }
        }

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
            this.f47935f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47935f.k0 == null) {
                return;
            }
            if (a.N0) {
                if (d.a.q0.a.h0.o.e.a.k(null)) {
                    d.a.q0.a.e0.a.d(this.f47935f.q());
                    return;
                }
                if (this.f47934e == null) {
                    this.f47934e = d.a.q0.a.g1.f.V().n(this.f47935f.k0);
                }
                if (this.f47935f.U1()) {
                    if (d.a.q0.a.e0.a.a()) {
                        d.a.q0.a.e0.a.c(this.f47935f.q(), false);
                        return;
                    } else {
                        d.a.q0.a.c1.b.h().f(new C0771a(this));
                        return;
                    }
                }
                this.f47934e.setVisibility(this.f47934e.getVisibility() == 0 ? 8 : 0);
            } else if (this.f47935f.U1()) {
                this.f47935f.l3();
            } else {
                d.a.q0.a.e0.a.d(this.f47935f.q());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SwanAppPropertyWindow f47937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47938f;

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
            this.f47938f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47937e == null) {
                    this.f47937e = d.a.q0.a.g1.f.V().L(this.f47938f.k0);
                }
                this.f47937e.setVisibility(this.f47937e.getVisibility() == 0 ? 8 : 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47939e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f47940f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f47941g;

        /* renamed from: d.a.q0.a.h0.g.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterface$OnClickListenerC0772a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0772a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        public l(a aVar, d.a.q0.a.f1.e.b bVar, d.a.q0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47941g = aVar;
            this.f47939e = bVar;
            this.f47940f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47941g.k0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(d.a.q0.a.h0.u.g.N().h0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.f47939e.u1()) ? "" : this.f47939e.u1());
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(d.a.q0.a.v.a.c(this.f47940f.f46683f));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.f47939e.g1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.f47939e.g1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            h.a aVar = new h.a(this.f47941g.k0);
            aVar.V(this.f47941g.k0.getResources().getString(d.a.q0.a.h.aiapps_show_ext_info_title));
            aVar.x(sb.toString());
            aVar.n(new d.a.q0.a.w2.h.a());
            aVar.m(false);
            aVar.O(d.a.q0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0772a(this));
            aVar.X();
        }
    }

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47942e;

        /* renamed from: d.a.q0.a.h0.g.a$m$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterface$OnClickListenerC0773a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0773a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        public m(a aVar) {
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
            this.f47942e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47942e.k0 == null) {
                return;
            }
            String e2 = d.a.q0.a.m2.a.c().e(1);
            String string = this.f47942e.k0.getResources().getString(d.a.q0.a.h.ai_games_debug_game_core_version);
            h.a aVar = new h.a(this.f47942e.k0);
            aVar.V(string);
            aVar.x(e2);
            aVar.n(new d.a.q0.a.w2.h.a());
            aVar.m(false);
            aVar.O(d.a.q0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0773a(this));
            aVar.X();
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47943e;

        /* renamed from: d.a.q0.a.h0.g.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0774a extends j.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ n f47944a;

            /* renamed from: d.a.q0.a.h0.g.a$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0775a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f47945e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0774a f47946f;

                public RunnableC0775a(C0774a c0774a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0774a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f47946f = c0774a;
                    this.f47945e = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        h.a aVar = new h.a(this.f47946f.f47944a.f47943e.k0);
                        aVar.U(d.a.q0.a.h.aiapps_debug_report_performance);
                        aVar.x(this.f47945e);
                        aVar.n(new d.a.q0.a.w2.h.a());
                        aVar.m(false);
                        aVar.O(d.a.q0.a.h.aiapps_confirm, null);
                        aVar.X();
                    }
                }
            }

            public C0774a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47944a = nVar;
            }

            @Override // d.a.q0.a.r1.j.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f47944a.f47943e.k0.runOnUiThread(new RunnableC0775a(this, str));
                }
            }
        }

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
            this.f47943e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47943e.k0 == null) {
                return;
            }
            d.a.q0.a.r1.j.e().g(new C0774a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.q0.a.e0.h.a f47947e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47948f;

        /* renamed from: d.a.q0.a.h0.g.a$o$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterface$OnClickListenerC0776a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f47949e;

            public DialogInterface$OnClickListenerC0776a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47949e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    d.a.q0.a.e0.h.a.g(1);
                    this.f47949e.f47947e = new d.a.q0.a.e0.h.a(d.a.q0.a.c1.a.b());
                    this.f47949e.f47947e.h();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f47950e;

            public b(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47950e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f47950e.b();
                    d.a.q0.a.e0.h.a.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f47951e;

            public c(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47951e = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.f47951e.b();
                    d.a.q0.a.e0.h.a.g(0);
                }
            }
        }

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
            this.f47948f = aVar;
        }

        public final void b() {
            d.a.q0.a.e0.h.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f47947e) == null) {
                return;
            }
            aVar.i();
            this.f47947e = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                h.a aVar = new h.a(this.f47948f.k0);
                aVar.U(d.a.q0.a.h.aiapps_debug_start_inspect);
                aVar.v(d.a.q0.a.h.aiapps_debug_inspect_message);
                aVar.n(new d.a.q0.a.w2.h.a());
                aVar.m(true);
                if (d.a.q0.a.e0.h.a.e() == 0) {
                    aVar.O(d.a.q0.a.h.aiapps_debug_inspect_normal, new DialogInterface$OnClickListenerC0776a(this));
                }
                if (d.a.q0.a.e0.h.a.e() != 2) {
                    aVar.H(d.a.q0.a.h.aiapps_debug_inspect_enhance, new b(this));
                }
                if (d.a.q0.a.e0.h.a.e() != 0) {
                    aVar.B(d.a.q0.a.h.swanapp_close, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47952e;

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
            this.f47952e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47952e.P2();
                this.f47952e.W2(PrefetchEvent.STATE_CLICK, "baozhang");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47953e;

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
            this.f47953e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f47953e.S2();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705417200, "Ld/a/q0/a/h0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705417200, "Ld/a/q0/a/h0/g/a;");
                return;
            }
        }
        N0 = d.a.q0.a.k.f49133a;
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
        this.G0 = new long[5];
    }

    public static a d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(d.a.q0.a.g.aiapps_about_fragment, viewGroup, false);
            Q1(inflate);
            a3(inflate);
            if (P1()) {
                inflate = S1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public void C2() {
        d.a.q0.a.h0.g.g W;
        d.a.q0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (W = d.a.q0.a.g1.f.V().W()) == null || (fVar = (d.a.q0.a.h0.g.f) W.n(d.a.q0.a.h0.g.f.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fVar.g3());
        d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.b("sharebtn", hashMap));
        W2(PrefetchEvent.STATE_CLICK, "aboutshare");
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final String O2(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str2.startsWith(File.separator)) {
                str2 = str2.substring(1);
            }
            return str + File.separator + str2;
        }
        return (String) invokeLL.objValue;
    }

    public final void P2() {
        SwanAppActivity activity;
        d.a.q0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (activity = d.a.q0.a.g1.f.V().getActivity()) == null || (Q = d.a.q0.a.a2.e.Q()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.M0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + Q.D());
            this.M0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.B0(d.a.q0.a.h.swan_app_baidu_guarantee_title);
            swanAppWebPopWindow2.x0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.y0();
            swanAppWebPopWindow2.w0();
            swanAppWebPopWindow2.D0();
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            R1(view);
            if (!U1()) {
                z2(false);
            }
            r2(true);
            l2(-1);
            t2(-16777216);
            n2(null);
            p2(true);
        }
    }

    public final void Q2() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (activity = d.a.q0.a.g1.f.V().getActivity()) == null || d.a.q0.a.a2.e.Q() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.M0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.J0);
            this.M0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.C0(J(d.a.q0.a.h.swan_app_service_agreement));
            swanAppWebPopWindow2.z0(activity.getResources().getDimensionPixelSize(d.a.q0.a.d.swan_half_screen_evalute_height));
            swanAppWebPopWindow2.x0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.w0();
            swanAppWebPopWindow2.D0();
            W2(PrefetchEvent.STATE_CLICK, "servicenote");
        }
    }

    public final void R2() {
        d.a.q0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (Q = d.a.q0.a.a2.e.Q()) == null) {
            return;
        }
        b.a L = Q.L();
        String J = L.J();
        String F = L.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = q0.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new d.a.q0.a.c2.e());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.k0, unitedSchemeEntity);
            if (N0) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        } else if (N0) {
            Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.k0 == null) {
            return;
        }
        String str = d.a.q0.a.a2.d.g().r().L().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            r0.b(this.k0).c("");
            d.a.q0.a.z1.b.f.e.f(this.k0, d.a.q0.a.h.swanapp_web_url_copy_fail).F();
            return;
        }
        String O2 = O2(str, d.a.q0.a.l1.b.e(q0.n()));
        int i2 = d.a.q0.a.h.swanapp_web_url_copy_success;
        if (O2.length() > PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            i2 = d.a.q0.a.h.swanapp_web_url_param_to_long;
        } else {
            str = O2;
        }
        r0.b(this.k0).c(str);
        d.a.q0.a.z1.b.f.e.f(this.k0, i2).F();
    }

    public final void T2() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && W() && (swanAppWebPopWindow = this.M0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void U2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (d.a.q0.a.u1.a.a.G()) {
                if (N0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                d.a.q0.a.z1.b.f.e.f(q(), d.a.q0.a.h.aiapps_debug_forbid_favor).F();
                return;
            }
            String h2 = q0.n().h();
            SwanFavorDataManager.h().b(str, new h(this, h2));
            d.a.q0.a.j1.a.p("aboutconcern", h2);
        }
    }

    public final void V2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            d.a.q0.a.n0.l.c l2 = d.a.q0.a.n0.l.c.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            W2(PrefetchEvent.STATE_CLICK, "aboutmove");
        }
    }

    public final void W2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            if (!TextUtils.isEmpty(str)) {
                fVar.f49120b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.f49123e = str2;
            }
            y1(fVar);
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X2(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            String b2 = d.a.q0.a.h0.g.b.b();
            d.a.q0.a.k2.g.g a2 = d.a.q0.a.h0.g.b.a();
            Button button = (Button) view.findViewById(d.a.q0.a.f.btn_ues_offline_perftool);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(d.a.q0.a.h.swan_offline_perf_tool_disable);
            } else {
                button.setText(d.a.q0.a.h.swan_offline_perf_tool_enable);
            }
            button.setOnClickListener(new b(this, a2, b2, new C0766a(this, a2, b2)));
        }
    }

    public final void Y2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            n0.I(this.D0, this.E0, String.valueOf(i2));
        }
    }

    @Override // d.a.q0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z2() {
        FragmentActivity h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (h2 = h()) != null && this.o0 == null) {
            d.a.q0.k.n nVar = new d.a.q0.k.n(h2, this.n0, 13, d.a.q0.a.c1.a.G(), new d.a.q0.a.w2.h.b());
            this.o0 = nVar;
            nVar.n(q0.O());
            new d.a.q0.a.j1.a(this.o0, this).z();
        }
    }

    public final void a3(View view) {
        d.a.q0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (Q = d.a.q0.a.a2.e.Q()) == null || Q.L() == null) {
            return;
        }
        b.a L = Q.L();
        this.C0 = (SwanAppRoundedImageView) view.findViewById(d.a.q0.a.f.aiapps_icon);
        TextView textView = (TextView) view.findViewById(d.a.q0.a.f.aiapps_title);
        textView.setText(L.K());
        if (L.G() == 0) {
            d.a.q0.a.w2.f.a(textView, new i(this));
        }
        d.a.q0.a.r1.k.f.j().n().h(textView);
        TextView textView2 = (TextView) view.findViewById(d.a.q0.a.f.aiapps_description);
        textView2.setText(L.c1());
        Button button = (Button) view.findViewById(d.a.q0.a.f.share_friends);
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(d.a.q0.a.f.add_favor);
        this.K0 = button2;
        button2.setOnClickListener(this);
        m3();
        d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
        if (W == null) {
            return;
        }
        if (W.n(d.a.q0.a.c1.b.c().a()) != null) {
            button.setVisibility(8);
            this.K0.setVisibility(8);
        }
        d.a.q0.q.d.b().a(textView2);
        ((TextView) view.findViewById(d.a.q0.a.f.service_category_value)).setText(L.q1());
        ((TextView) view.findViewById(d.a.q0.a.f.subject_info_value)).setText(L.r1());
        String D = d.a.q0.a.c1.a.n().D();
        this.J0 = D;
        if (!TextUtils.isEmpty(D)) {
            View findViewById = view.findViewById(d.a.q0.a.f.agreement_layout);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.L0 = (RecyclerView) view.findViewById(d.a.q0.a.f.related_swan_app_list);
        PMSAppInfo f0 = L.f0();
        if (c3(f0)) {
            h3(view, f0.brandsInfo);
        }
        this.E0 = (TextView) view.findViewById(d.a.q0.a.f.aiapps_label_tv);
        this.D0 = (BdBaseImageView) view.findViewById(d.a.q0.a.f.aiapps_label_bg);
        this.C0.setImageBitmap(q0.i(L, "SwanAppAboutFragment", false));
        this.C0.setOnClickListener(this);
        SwanAppBearInfo i1 = L.i1();
        if (i1 != null && i1.isValid()) {
            this.F0 = new d.a.q0.a.w2.a(this.k0, view, i1, d.a.q0.a.f.bear_layout);
        }
        Y2(L.t1());
        ((Button) view.findViewById(d.a.q0.a.f.open_app_button)).setVisibility(8);
        if (N0 || d.a.q0.a.g1.f.V().O()) {
            View inflate = ((ViewStub) view.findViewById(d.a.q0.a.f.ai_app_console)).inflate();
            if (U1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(L.l0() ? d.a.q0.a.h.aiapps_close_debug_mode : d.a.q0.a.h.aiapps_open_debug_mode);
            }
            inflate.setOnClickListener(new j(this));
            if (!U1()) {
                ((ViewStub) view.findViewById(d.a.q0.a.f.ai_app_property)).inflate().setOnClickListener(new k(this));
            }
            if (U1()) {
                ((ViewStub) view.findViewById(d.a.q0.a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new l(this, L, Q));
            }
            if (U1()) {
                View inflate2 = ((ViewStub) view.findViewById(d.a.q0.a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(d.a.q0.a.h.ai_games_debug_game_core_version);
                    button3.setOnClickListener(new m(this));
                }
            }
            if (d.a.q0.a.r1.j.e().f()) {
                View inflate3 = ((ViewStub) view.findViewById(d.a.q0.a.f.ai_app_report_performance)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(d.a.q0.a.h.aiapps_debug_report_performance);
                    button4.setOnClickListener(new n(this));
                }
            }
            View inflate4 = ((ViewStub) view.findViewById(d.a.q0.a.f.ai_app_start_inspector)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(d.a.q0.a.h.aiapps_debug_start_inspect);
            }
            inflate4.setOnClickListener(new o(this));
            if (!U1()) {
                X2(view);
            }
        }
        if (b3(f0)) {
            ImageView imageView = (ImageView) view.findViewById(d.a.q0.a.f.apply_guarantee);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p(this));
        }
        if (U1()) {
            return;
        }
        f3(this.C0, 2000L, new q(this));
    }

    public final boolean b3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, pMSAppInfo)) == null) {
            return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeL.booleanValue;
    }

    public final boolean c3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, pMSAppInfo)) == null) ? (d.a.q0.a.a2.d.g().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // d.a.q0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && U1()) {
            Z2();
            this.o0.p(d.a.q0.a.c1.a.H().a());
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            String D = d.a.q0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D)) {
                return;
            }
            if (d.a.q0.a.j0.b.a.n(D)) {
                V2(D);
            } else {
                U2(D);
            }
            m3();
        }
    }

    public final void f3(View view, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{view, Long.valueOf(j2), onLongClickListener}) == null) || view == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view.setOnTouchListener(new d(this, new c(this, onLongClickListener, view), j2));
    }

    public final void g3() {
        d.a.q0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (Q = d.a.q0.a.a2.e.Q()) == null) {
            return;
        }
        long[] jArr = this.G0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.G0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.G0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.G0 = new long[5];
            if (Q.m0()) {
                i3();
            } else {
                k3();
            }
        }
    }

    public final void h3(View view, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, view, str) == null) {
            if (N0) {
                Log.i("SwanAppAboutFragment", str + "");
            }
            if (TextUtils.isEmpty(str) || view == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.H0 = jSONObject.optString("scheme");
                this.I0 = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.H0) && !TextUtils.isEmpty(this.I0) && (length = this.I0.length()) >= 20) {
                    if (length > 100) {
                        this.I0 = this.I0.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(d.a.q0.a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(d.a.q0.a.f.brands_introduction_details)).setText(this.I0);
                    SwanAppRelatedSwanListAdapter.d("brand", null, "show");
                    j3();
                }
            } catch (JSONException e2) {
                if (N0) {
                    Log.i("SwanAppAboutFragment", e2.getMessage());
                }
            }
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            String b2 = d.a.q0.a.v2.p.b(this.k0);
            d.a.q0.a.z1.b.f.e.g(AppRuntime.getAppContext(), b2).E();
            d.a.q0.a.e0.d.h("SwanAppAboutFragment", "showExtraInfo\n" + b2);
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(q());
            linearLayoutManager.setOrientation(1);
            this.L0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(q());
            this.L0.setAdapter(swanAppRelatedSwanListAdapter);
            d.a.q0.a.y1.b.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (N0) {
                Log.d("SwanAppAboutFragment", "startAboutFragment");
            }
            d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
            if (W == null) {
                d.a.q0.a.z1.b.f.e.f(q(), d.a.q0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = W.i("navigateTo");
            i2.n(d.a.q0.a.h0.g.g.f48010g, d.a.q0.a.h0.g.g.f48012i);
            i2.k("running_info", null).a();
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || d.a.q0.a.a2.e.Q() == null) {
            return;
        }
        d.a.q0.a.h0.e.c.a(d.a.q0.a.a2.e.Q(), this.k0, new f(this));
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (d.a.q0.a.j0.b.a.n(d.a.q0.a.a2.d.g().getAppId())) {
                this.K0.setText(d.a.q0.a.h.swanapp_favored);
                this.K0.setTextColor(z().getColorStateList(d.a.q0.a.c.swan_app_about_attentation_text_selector));
                this.K0.setBackgroundResource(d.a.q0.a.e.swan_app_about_cancel_attention_selector);
                return;
            }
            this.K0.setText(d.a.q0.a.h.swanapp_add_favor);
            this.K0.setTextColor(-1);
            this.K0.setBackgroundResource(d.a.q0.a.e.swan_app_about_attention_selector);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view) == null) {
            int id = view.getId();
            if (id == d.a.q0.a.f.aiapps_icon) {
                g3();
            } else if (id == d.a.q0.a.f.open_app_button) {
                R2();
            } else if (id == d.a.q0.a.f.brands_introduction_ll) {
                SchemeRouter.invoke(q(), this.H0);
                W2(PrefetchEvent.STATE_CLICK, "brand");
            } else if (id == d.a.q0.a.f.agreement_layout) {
                Q2();
            } else if (id == d.a.q0.a.f.share_friends) {
                C2();
            } else if (id == d.a.q0.a.f.add_favor) {
                e3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            T2();
        }
    }

    @Override // d.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            d.a.q0.a.w2.a aVar = this.F0;
            if (aVar != null) {
                aVar.c();
            }
            x2(1);
            d.a.q0.k.n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.x(d.a.q0.a.c1.a.H().a());
            }
            if (this.K0 != null) {
                m3();
            }
        }
    }
}
