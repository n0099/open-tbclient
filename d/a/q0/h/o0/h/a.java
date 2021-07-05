package d.a.q0.h.o0.h;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.view.webview.GameWebViewManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.p.e.f;
import d.a.q0.a.v2.q0;
import java.util.Locale;
/* loaded from: classes8.dex */
public class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f53560h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f53561e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f53562f;

    /* renamed from: g  reason: collision with root package name */
    public e f53563g;

    /* renamed from: d.a.q0.h.o0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1166a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f53565f;

        public RunnableC1166a(a aVar, String str) {
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
            this.f53565f = aVar;
            this.f53564e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f53565f.f53561e == null) {
                    this.f53565f.G();
                }
                if (!this.f53565f.f53561e.d()) {
                    this.f53565f.f53561e.J();
                }
                this.f53565f.f53561e.loadUrl(this.f53564e);
                this.f53565f.E("open", new d.a.q0.h.o0.h.b(this.f53564e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53566e;

        public b(a aVar) {
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
            this.f53566e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f53566e.f53561e != null && this.f53566e.f53561e.d()) {
                this.f53566e.f53561e.removeFromParent();
                this.f53566e.f53561e.destroy();
                this.f53566e.f53561e = null;
                a aVar = this.f53566e;
                aVar.E(IntentConfig.CLOSE, new d.a.q0.h.o0.h.b(aVar.f53562f));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53567e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f53568f;

        public c(a aVar, String str) {
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
            this.f53568f = aVar;
            this.f53567e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53568f.f53561e == null) {
                return;
            }
            if (TextUtils.equals("1", this.f53567e)) {
                this.f53568f.f53561e.h(true);
            } else {
                this.f53568f.f53561e.h(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53569e;

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
            this.f53569e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53569e.close();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f53570a;

        /* renamed from: b  reason: collision with root package name */
        public String f53571b;

        /* renamed from: c  reason: collision with root package name */
        public long f53572c;

        /* renamed from: d  reason: collision with root package name */
        public long f53573d;

        public /* synthetic */ e(String str, String str2, long j, RunnableC1166a runnableC1166a) {
            this(str, str2, j);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "H5GameInfo{mGameId='" + this.f53570a + "', mGameName='" + this.f53571b + "', mStartLoadingTimestamp=" + this.f53572c + ", mFinishLoadingTimestamp=" + this.f53573d + '}';
            }
            return (String) invokeV.objValue;
        }

        public e(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53570a = str;
            this.f53571b = str2;
            this.f53572c = j;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1439241187, "Ld/a/q0/h/o0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1439241187, "Ld/a/q0/h/o0/h/a;");
                return;
            }
        }
        f53560h = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.q0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static a F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            d.a.q0.a.l0.a n = d.a.q0.h.o.c.m().n();
            if (n == null) {
                return null;
            }
            EventTarget p = n.p();
            if (p instanceof d.a.q0.h.d.b) {
                return ((d.a.q0.h.d.b) p).getWebViewManager();
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final d.a.q0.h.o0.h.c D(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            switch (str2.hashCode()) {
                case 1507424:
                    if (str2.equals("1001")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507425:
                    if (str2.equals("1002")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return null;
                }
                return new d.a.q0.h.o0.h.c(str, str2, "open:host not in white list");
            }
            return new d.a.q0.h.o0.h.c(str, str2, "open:url is invalid");
        }
        return (d.a.q0.h.o0.h.c) invokeLL.objValue;
    }

    public final void E(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (f53560h) {
                Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f53561e == null) {
            GameWebViewManager gameWebViewManager = new GameWebViewManager(d.a.q0.a.c1.a.b());
            this.f53561e = gameWebViewManager;
            gameWebViewManager.j(new d(this));
        }
    }

    public final boolean H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.US);
            return lowerCase.startsWith("http://") || lowerCase.startsWith("https://");
        }
        return invokeL.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f53563g == null) {
                if (f53560h) {
                    Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                    return;
                }
                return;
            }
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q == null) {
                if (f53560h) {
                    Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                    return;
                }
                return;
            }
            this.f53563g.f53573d = System.currentTimeMillis();
            if (f53560h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.f53563g);
            }
            d.a.q0.h.o0.h.d.a(Q, this.f53563g);
            this.f53563g = null;
        }
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q0.b0(new b(this));
        }
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        d.a.q0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (G = d.a.q0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        String C = G.C("gameId");
        String C2 = G.C("gameName");
        if (!TextUtils.isEmpty(C) && !TextUtils.isEmpty(C2)) {
            this.f53563g = new e(C, C2, System.currentTimeMillis(), null);
            if (f53560h) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.f53563g);
            }
            d.a.q0.h.m0.c.a(G, true, null);
            return;
        }
        d.a.q0.h.m0.c.a(G, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            d.a.q0.a.y.b.a G = d.a.q0.a.y.b.a.G(jsObject);
            if (G == null) {
                E("error", D(null, "1001"));
                return;
            }
            String D = G.D("url", null);
            if (!H(D)) {
                E("error", D(D, "1001"));
            } else if (!d.a.q0.a.b2.a.b.h(D)) {
                E("error", D(D, "1002"));
            } else {
                if (f53560h) {
                    Log.i("GameWebViewApi", "open:" + D);
                }
                this.f53562f = D;
                q0.b0(new RunnableC1166a(this, D));
            }
        }
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            d.a.q0.a.y.b.a G = d.a.q0.a.y.b.a.G(jsObject);
            if (G == null) {
                E("error", D(null, "1001"));
            } else {
                q0.b0(new c(this, G.D("setCloseViewVisibility", null)));
            }
        }
    }
}
