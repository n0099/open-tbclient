package com.bytedance.sdk.openadsdk.m;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f31396a;

    /* renamed from: b  reason: collision with root package name */
    public Context f31397b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<View> f31398c;

    /* renamed from: d  reason: collision with root package name */
    public d f31399d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.m.a f31400e;

    /* renamed from: f  reason: collision with root package name */
    public b f31401f;

    /* renamed from: g  reason: collision with root package name */
    public int f31402g;

    /* renamed from: h  reason: collision with root package name */
    public int f31403h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f31404i;
    public String j;
    public String k;
    public String l;
    public Map<String, String> m;
    public JSONObject n;
    public JSONObject o;
    public String p;
    public boolean q;
    public boolean r;
    public boolean s;
    public ViewTreeObserver.OnGlobalLayoutListener t;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f31406a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f31407b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ a[] f31408c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-320636625, "Lcom/bytedance/sdk/openadsdk/m/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-320636625, "Lcom/bytedance/sdk/openadsdk/m/f$a;");
                    return;
                }
            }
            f31406a = new a("MAIN", 0);
            a aVar = new a("RIFLE", 1);
            f31407b = aVar;
            f31408c = new a[]{f31406a, aVar};
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f31408c.clone() : (a[]) invokeV.objValue;
        }
    }

    public f(Context context, WebView webView, b bVar, com.bytedance.sdk.openadsdk.m.a aVar) {
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
        this.f31402g = 0;
        this.f31403h = 0;
        this.f31404i = new JSONObject();
        this.m = new HashMap();
        this.t = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.bytedance.sdk.openadsdk.m.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f31405a;

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
                this.f31405a = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        View view = (View) this.f31405a.f31398c.get();
                        if (view == null) {
                            return;
                        }
                        this.f31405a.b(view);
                    } catch (Throwable th) {
                        e.a("PlayablePlugin", "onSizeChanged error", th);
                    }
                }
            }
        };
        this.f31396a = a.f31406a;
        g.a(webView);
        a(webView);
        a(context, bVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, view) == null) || view == null) {
            return;
        }
        try {
            if (this.f31402g == view.getWidth() && this.f31403h == view.getHeight()) {
                return;
            }
            this.f31402g = view.getWidth();
            this.f31403h = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.f31402g);
            jSONObject.put("height", this.f31403h);
            a("resize", jSONObject);
            this.f31404i = jSONObject;
        } catch (Throwable th) {
            e.a("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (JSONObject) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public Set<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f31399d.a() : (Set) invokeV.objValue;
    }

    public c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f31400e.a() : (c) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.m.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f31400e : (com.bytedance.sdk.openadsdk.m.a) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f31404i : (JSONObject) invokeV.objValue;
    }

    public JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (JSONObject) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f31400e.b();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            try {
                View view = this.f31398c.get();
                if (view != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.t);
                    } else {
                        view.getViewTreeObserver().removeGlobalOnLayoutListener(this.t);
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                this.f31399d.b();
            } catch (Throwable unused2) {
            }
        }
    }

    public f c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_style", str);
                this.o = jSONObject;
            } catch (Throwable th) {
                e.a("PlayablePlugin", "setPlayableStyle error", th);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    private void a(Context context, b bVar, com.bytedance.sdk.openadsdk.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, context, bVar, aVar) == null) {
            this.f31397b = context;
            this.f31399d = new d(this);
            this.f31400e = aVar;
            this.f31401f = bVar;
        }
    }

    public f c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.s = z;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("send_click", this.s);
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || view == null) {
            return;
        }
        try {
            this.f31398c = new WeakReference<>(view);
            b(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.t);
        } catch (Throwable th) {
            e.a("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (Map) invokeV.objValue;
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31397b : (Context) invokeV.objValue;
    }

    public f b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            this.m.put(str, str2);
            return this;
        }
        return (f) invokeLL.objValue;
    }

    public f b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.r = z;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("viewStatus", this.r);
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
            this.j = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.q = z;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("endcard_mute", this.q);
                a("volumeChange", jSONObject);
            } catch (Throwable th) {
                e.a("PlayablePlugin", "setIsMute error", th);
            }
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public JSONObject b(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, jSONObject)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (e.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("PlayablePlugin JSB-REQ [");
                sb.append(str);
                sb.append("] ");
                sb.append(jSONObject != null ? jSONObject.toString() : "");
                e.a("PlayablePlugin", sb.toString());
            }
            JSONObject a2 = this.f31399d.a(str, jSONObject);
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

    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, jSONObject) == null) {
            if (e.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("CALL JS [");
                sb.append(str);
                sb.append("] ");
                sb.append(jSONObject != null ? jSONObject.toString() : "");
                e.a("PlayablePlugin", sb.toString());
            }
            b bVar = this.f31401f;
            if (bVar != null) {
                bVar.a(str, jSONObject);
            }
        }
    }

    public static f a(Context context, WebView webView, b bVar, com.bytedance.sdk.openadsdk.m.a aVar) {
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
