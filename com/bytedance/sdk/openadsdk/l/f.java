package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ViewTreeObserver.OnGlobalLayoutListener E;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f68325a;

    /* renamed from: b  reason: collision with root package name */
    public String f68326b;

    /* renamed from: c  reason: collision with root package name */
    public long f68327c;

    /* renamed from: d  reason: collision with root package name */
    public long f68328d;

    /* renamed from: e  reason: collision with root package name */
    public long f68329e;

    /* renamed from: f  reason: collision with root package name */
    public long f68330f;

    /* renamed from: g  reason: collision with root package name */
    public long f68331g;

    /* renamed from: h  reason: collision with root package name */
    public int f68332h;

    /* renamed from: i  reason: collision with root package name */
    public int f68333i;

    /* renamed from: j  reason: collision with root package name */
    public a f68334j;
    public Context k;
    public WeakReference<View> l;
    public d m;
    public com.bytedance.sdk.openadsdk.l.a n;
    public b o;
    public int p;
    public int q;
    public JSONObject r;
    public String s;
    public String t;
    public String u;
    public Map<String, String> v;
    public JSONObject w;
    public String x;
    public JSONObject y;
    public String z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f68338a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f68339b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ a[] f68340c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-349265776, "Lcom/bytedance/sdk/openadsdk/l/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-349265776, "Lcom/bytedance/sdk/openadsdk/l/f$a;");
                    return;
                }
            }
            f68338a = new a("MAIN", 0);
            a aVar = new a("RIFLE", 1);
            f68339b = aVar;
            f68340c = new a[]{f68338a, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f68340c.clone() : (a[]) invokeV.objValue;
        }
    }

    public f(Context context, WebView webView, b bVar, com.bytedance.sdk.openadsdk.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, webView, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68325a = new Handler(Looper.getMainLooper());
        this.f68326b = null;
        this.f68327c = 0L;
        this.f68328d = -1L;
        this.f68329e = -1L;
        this.f68330f = -1L;
        this.f68331g = -1L;
        this.f68332h = 0;
        this.f68333i = 0;
        this.p = 0;
        this.q = 0;
        this.r = new JSONObject();
        this.v = new HashMap();
        this.D = false;
        this.E = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.bytedance.sdk.openadsdk.l.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f68335a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f68335a = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        View view = (View) this.f68335a.l.get();
                        if (view == null) {
                            return;
                        }
                        this.f68335a.b(view);
                    } catch (Throwable th) {
                        e.a("PlayablePlugin", "onSizeChanged error", th);
                    }
                }
            }
        };
        this.f68334j = a.f68338a;
        g.a(webView);
        a(webView);
        a(context, bVar, aVar);
    }

    public static /* synthetic */ int b(f fVar) {
        int i2 = fVar.f68332h;
        fVar.f68332h = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(f fVar) {
        int i2 = fVar.f68333i;
        fVar.f68333i = i2 + 1;
        return i2;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public Set<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.m.a() : (Set) invokeV.objValue;
    }

    public c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.n.a() : (c) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.l.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.n : (com.bytedance.sdk.openadsdk.l.a) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.r : (JSONObject) invokeV.objValue;
    }

    public JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.w : (JSONObject) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.n.b();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x002f -> B:28:0x002f). Please submit an issue!!! */
    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.D) {
            return;
        }
        this.D = true;
        try {
            View view = this.l.get();
            if (view != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this.E);
                } else {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this.E);
                }
            }
        } catch (Throwable unused) {
        }
        try {
            this.m.b();
        } catch (Throwable unused2) {
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_all_times", this.f68332h);
            jSONObject.put("playable_hit_times", this.f68333i);
            d("PL_sdk_preload_times", jSONObject);
        } catch (Throwable unused3) {
        }
        try {
            if (this.f68328d != -1) {
                long currentTimeMillis = System.currentTimeMillis() - this.f68328d;
                e.a("PlayablePlugin", "playable show time +" + currentTimeMillis);
                this.f68327c = this.f68327c + currentTimeMillis;
                this.f68328d = -1L;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playable_user_play_duration", this.f68327c);
            d("PL_sdk_user_play_duration", jSONObject2);
        } catch (Throwable unused4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, view) == null) || view == null) {
            return;
        }
        try {
            if (this.p == view.getWidth() && this.q == view.getHeight()) {
                return;
            }
            this.p = view.getWidth();
            this.q = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.p);
            jSONObject.put("height", this.q);
            a("resize", jSONObject);
            this.r = jSONObject;
        } catch (Throwable th) {
            e.a("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.y : (JSONObject) invokeV.objValue;
    }

    public f d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.u = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            this.z = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (str != null) {
                try {
                    int indexOf = str.indexOf("?");
                    if (indexOf != -1) {
                        str = str.substring(0, indexOf);
                    }
                } catch (Throwable unused) {
                }
            }
            this.x = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                this.f68330f = System.currentTimeMillis();
                jSONObject.put("playable_full_url", str);
                jSONObject.put("playable_page_show_duration", this.f68329e != -1 ? this.f68330f - this.f68329e : 0L);
            } catch (Throwable th) {
                e.a("PlayablePlugin", "reportUrlLoadStart error", th);
            }
            d("PL_sdk_html_load_start", jSONObject);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                this.f68331g = System.currentTimeMillis();
                jSONObject.put("playable_full_url", str);
                jSONObject.put("playable_html_load_start_duration", this.f68330f != -1 ? this.f68331g - this.f68330f : 0L);
            } catch (Throwable th) {
                e.a("PlayablePlugin", "reportUrlLoadFinish error", th);
            }
            d("PL_sdk_html_load_finish", jSONObject);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f68325a.post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.l.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f68336a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68336a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        f.b(this.f68336a);
                    }
                }
            });
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f68325a.post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.l.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f68337a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68337a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        f.c(this.f68337a);
                    }
                }
            });
        }
    }

    private void a(Context context, b bVar, com.bytedance.sdk.openadsdk.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, context, bVar, aVar) == null) {
            this.f68326b = UUID.randomUUID().toString();
            this.k = context;
            this.m = new d(this);
            this.n = aVar;
            this.o = bVar;
        }
    }

    private void d(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, str, jSONObject) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.B);
            jSONObject.put("playable_session_id", this.f68326b);
            jSONObject.put("playable_url", this.x);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", "embeded_ad");
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", AppLog.UMENG_CATEGORY);
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put(TiebaStatic.Params.REFER, "playable");
            jSONObject2.put("value", this.w.opt(IAdRequestParam.CELL_ID));
            jSONObject2.put("log_extra", this.w.opt("log_extra"));
            if (this.n != null) {
                e.a("PlayablePlugin", "reportEvent by ActionProxy");
                this.n.a("playable_track", jSONObject2);
                this.n.c(jSONObject);
                return;
            }
            e.a("PlayablePlugin", "reportEvent error no impl");
        } catch (Throwable th) {
            e.a("PlayablePlugin", "reportEvent error", th);
        }
    }

    public f c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_style", str);
                this.y = jSONObject;
            } catch (Throwable th) {
                e.a("PlayablePlugin", "setPlayableStyle error", th);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.C = z;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("send_click", this.C);
                a("change_playable_click", jSONObject);
            } catch (Throwable th) {
                e.a("PlayablePlugin", "setPlayableClick error", th);
            }
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || view == null) {
            return;
        }
        try {
            this.l = new WeakReference<>(view);
            b(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.E);
        } catch (Throwable th) {
            e.a("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.v : (Map) invokeV.objValue;
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (Context) invokeV.objValue;
    }

    public f b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.t = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public JSONObject c(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, jSONObject)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (e.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("PlayablePlugin JSB-REQ [");
                sb.append(str);
                sb.append("] ");
                sb.append(jSONObject != null ? jSONObject.toString() : "");
                e.a("PlayablePlugin", sb.toString());
            }
            JSONObject a2 = this.m.a(str, jSONObject);
            if (e.a()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("PlayablePlugin JSB-RSP [");
                sb2.append(str);
                sb2.append("] time:");
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                sb2.append(" ");
                sb2.append(a2 != null ? a2.toString() : "");
                e.a("PlayablePlugin", sb2.toString());
            }
            return a2;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public f a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            this.v.put(str, str2);
            return this;
        }
        return (f) invokeLL.objValue;
    }

    public f b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (this.B == z) {
                return this;
            }
            this.B = z;
            d(z ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", null);
            if (this.f68329e == -1 && this.B) {
                this.f68329e = System.currentTimeMillis();
                d("PL_sdk_page_show", null);
            }
            if (this.B) {
                this.f68328d = System.currentTimeMillis();
            } else if (this.f68328d != -1) {
                long currentTimeMillis = System.currentTimeMillis() - this.f68328d;
                e.a("PlayablePlugin", "playable show time +" + currentTimeMillis);
                this.f68327c = this.f68327c + currentTimeMillis;
                this.f68328d = -1L;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("viewStatus", this.B);
                a("viewableChange", jSONObject);
            } catch (Throwable th) {
                e.a("PlayablePlugin", "setViewable error", th);
            }
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.s = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.A = z;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("endcard_mute", this.A);
                a("volumeChange", jSONObject);
            } catch (Throwable th) {
                e.a("PlayablePlugin", "setIsMute error", th);
            }
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject) == null) {
            if (e.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("CALL JS [");
                sb.append(str);
                sb.append("] ");
                sb.append(jSONObject != null ? jSONObject.toString() : "");
                e.a("PlayablePlugin", sb.toString());
            }
            b bVar = this.o;
            if (bVar != null) {
                bVar.a(str, jSONObject);
            }
        }
    }

    public f a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            this.w = jSONObject;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("description", str);
                jSONObject.put("failingUrl", str2);
            } catch (Throwable th) {
                e.a("PlayablePlugin", "onWebReceivedError error", th);
            }
            d("PL_sdk_html_load_error", jSONObject);
        }
    }

    public void b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, jSONObject) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d(str, jSONObject);
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("failingUrl", str);
            } catch (Throwable th) {
                e.a("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            d("PL_sdk_html_load_error", jSONObject);
        }
    }

    public static f a(Context context, WebView webView, b bVar, com.bytedance.sdk.openadsdk.l.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, webView, bVar, aVar)) == null) {
            if (webView == null || bVar == null || aVar == null) {
                return null;
            }
            return new f(context, webView, bVar, aVar);
        }
        return (f) invokeLLLL.objValue;
    }
}
