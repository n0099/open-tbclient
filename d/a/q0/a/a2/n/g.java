package d.a.q0.a.a2.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final f<g> s;
    public static final e<g> t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f46726a;

    /* renamed from: b  reason: collision with root package name */
    public String f46727b;

    /* renamed from: c  reason: collision with root package name */
    public String f46728c;

    /* renamed from: d  reason: collision with root package name */
    public String f46729d;

    /* renamed from: e  reason: collision with root package name */
    public int f46730e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46731f;

    /* renamed from: g  reason: collision with root package name */
    public String f46732g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46733h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46734i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;

    /* loaded from: classes8.dex */
    public static class a extends f<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull g gVar, @NonNull d.a.q0.a.b1.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                dVar.writeInt(gVar.f46726a);
                dVar.f(gVar.f46727b);
                dVar.f(gVar.f46728c);
                dVar.f(gVar.f46729d);
                dVar.writeInt(gVar.f46730e);
                dVar.writeBoolean(gVar.f46731f);
                dVar.f(gVar.f46732g);
                dVar.writeBoolean(gVar.f46733h);
                dVar.writeBoolean(gVar.f46734i);
                dVar.f(gVar.j);
                dVar.writeBoolean(gVar.k);
                dVar.writeBoolean(gVar.l);
                dVar.writeBoolean(gVar.m);
                dVar.writeBoolean(gVar.n);
                dVar.writeBoolean(gVar.o);
                dVar.writeBoolean(gVar.p);
                dVar.f(gVar.q);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends e<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.a2.n.e
        /* renamed from: c */
        public g b(@NonNull d.a.q0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                g gVar = new g();
                gVar.f46726a = cVar.readInt();
                gVar.f46727b = cVar.r();
                gVar.f46728c = cVar.r();
                gVar.f46729d = cVar.r();
                gVar.f46730e = cVar.readInt();
                gVar.f46731f = cVar.readBoolean();
                gVar.f46732g = cVar.r();
                gVar.f46733h = cVar.readBoolean();
                gVar.f46734i = cVar.readBoolean();
                gVar.j = cVar.r();
                gVar.k = cVar.readBoolean();
                gVar.l = cVar.readBoolean();
                gVar.m = cVar.readBoolean();
                gVar.n = cVar.readBoolean();
                gVar.o = cVar.readBoolean();
                gVar.p = cVar.readBoolean();
                gVar.q = cVar.r();
                return gVar;
            }
            return (g) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1154674246, "Ld/a/q0/a/a2/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1154674246, "Ld/a/q0/a/a2/n/g;");
                return;
            }
        }
        r = k.f49133a;
        s = new a();
        t = new b();
    }

    public g() {
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
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        this.p = false;
        this.f46726a = -16777216;
        this.f46728c = "#ffffff";
        this.j = "default";
        this.f46730e = -1;
        this.f46731f = false;
    }

    public static g a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            return c(optJSONObject);
        }
        return (g) invokeL.objValue;
    }

    public static g b(String str, @NonNull g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, gVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return gVar;
            }
            try {
                return e(new JSONObject(str), gVar);
            } catch (JSONException e2) {
                if (r) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e2));
                }
                return gVar;
            }
        }
        return (g) invokeLL.objValue;
    }

    public static g c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, jSONObject)) == null) {
            g gVar = new g();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            gVar.f46726a = SwanAppConfigData.s(optString);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            gVar.f46728c = optString2;
            gVar.f46727b = jSONObject.optString("navigationBarTitleText");
            gVar.f46729d = jSONObject.optString("backgroundTextStyle", "black");
            gVar.f46730e = SwanAppConfigData.s(jSONObject.optString("backgroundColor"));
            gVar.f46731f = jSONObject.optBoolean("enablePullDownRefresh");
            gVar.f46732g = jSONObject.optString("onReachBottomDistance");
            gVar.f46733h = jSONObject.optBoolean("enableOpacityNavigationBar");
            gVar.f46734i = jSONObject.optBoolean("enableOpacityNavigationBarText");
            gVar.j = jSONObject.optString("navigationStyle", "default");
            gVar.k = jSONObject.optBoolean("navigationHomeButtonHidden");
            gVar.q = jSONObject.optString("textSizeAdjust");
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public static g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (r) {
                Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
        return (g) invokeV.objValue;
    }

    public static g e(JSONObject jSONObject, @NonNull g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, gVar)) == null) {
            g gVar2 = new g();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            gVar2.f46726a = TextUtils.isEmpty(optString) ? gVar.f46726a : SwanAppConfigData.s(optString);
            gVar2.f46727b = jSONObject.optString("navigationBarTitleText", gVar.f46727b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = gVar.f46728c;
            }
            gVar2.f46728c = optString2;
            gVar2.f46729d = jSONObject.optString("backgroundTextStyle", gVar.f46729d);
            gVar2.f46730e = jSONObject.has("backgroundColor") ? SwanAppConfigData.s(jSONObject.optString("backgroundColor")) : gVar.f46730e;
            gVar2.f46731f = jSONObject.optBoolean("enablePullDownRefresh", gVar.f46731f);
            gVar2.f46732g = jSONObject.optString("onReachBottomDistance", gVar.f46732g);
            gVar2.f46733h = jSONObject.optBoolean("enableOpacityNavigationBar", gVar.f46733h);
            gVar2.f46734i = jSONObject.optBoolean("enableOpacityNavigationBarText", gVar.f46734i);
            gVar2.j = jSONObject.optString("navigationStyle", gVar.j);
            gVar2.k = jSONObject.optBoolean("navigationHomeButtonHidden", gVar.k);
            gVar2.l = jSONObject.optBoolean("disableSwipeBack", false);
            gVar2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            gVar2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            gVar2.o = jSONObject.optBoolean("_hasVideo", false);
            return gVar2;
        }
        return (g) invokeLL.objValue;
    }

    public static boolean f(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return gVar.f46733h || TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM);
        }
        return invokeL.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && !this.p) {
            this.p = true;
        }
    }
}
