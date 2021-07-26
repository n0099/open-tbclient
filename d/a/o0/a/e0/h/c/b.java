package d.a.o0.a.e0.h.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e0.h.a;
import d.a.o0.a.h0.l.e;
import d.a.o0.a.h0.u.g;
import d.a.o0.a.k;
import g.b.i.h;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements a.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44666g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a.b f44667a;

    /* renamed from: b  reason: collision with root package name */
    public g.b.e.a f44668b;

    /* renamed from: c  reason: collision with root package name */
    public InspectorNativeClient f44669c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.l0.a f44670d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedBlockingQueue<String> f44671e;

    /* renamed from: f  reason: collision with root package name */
    public String f44672f;

    /* loaded from: classes7.dex */
    public class a extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f44673a;

        public a(b bVar) {
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
            this.f44673a = bVar;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (b.f44666g) {
                    Log.d("V8InspectorClient", "getInspectorMessage");
                }
                try {
                    return (String) this.f44673a.f44671e.take();
                } catch (InterruptedException e2) {
                    if (b.f44666g) {
                        Log.e("V8InspectorClient", "awaitMessage on Debugger", e2);
                        return "";
                    }
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    if (this.f44673a.f44668b != null) {
                        this.f44673a.f44668b.send(str);
                    }
                } catch (Exception unused) {
                    if (b.f44666g) {
                        Log.d("V8InspectorClient", "V8 send message fail, try to check if websocket has opened");
                    }
                }
            }
        }
    }

    /* renamed from: d.a.o0.a.e0.h.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0684b extends g.b.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f44674e;

        /* renamed from: d.a.o0.a.e0.h.c.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0684b f44675e;

            public a(C0684b c0684b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0684b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44675e = c0684b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.f44675e.f44674e.f44671e.poll();
                    while (str != null) {
                        this.f44675e.f44674e.f44669c.dispatchProtocolMessage(str);
                        this.f44675e.c(str);
                        this.f44675e.d(str);
                        str = (String) this.f44675e.f44674e.f44671e.poll();
                    }
                }
            }
        }

        /* renamed from: d.a.o0.a.e0.h.c.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0685b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0684b f44676e;

            public RunnableC0685b(C0684b c0684b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0684b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44676e = c0684b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44676e.f44674e.f44667a.onConnected();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0684b(b bVar, URI uri) {
            super(uri);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((URI) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44674e = bVar;
        }

        public final void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || this.f44674e.f44667a == null) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.a.o0.a.a2.d g2 = d.a.o0.a.a2.d.g();
                    SwanAppActivity x = g2.x();
                    if (g2.C() && x != null) {
                        x.runOnUiThread(new RunnableC0685b(this));
                    }
                }
            } catch (JSONException e2) {
                if (b.f44666g) {
                    Log.e("V8InspectorClient", "message is not a Json object", e2);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
            if (r2 == 1) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
            d.a.o0.a.e0.d.b("V8InspectorClient", "Undefined command");
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
            d.a.o0.a.e0.d.g("V8InspectorClient", "v8 inspector close");
            d.a.o0.a.e0.f.f.d.d();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("command");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -934641255) {
                    if (hashCode == 94756344 && optString.equals(IntentConfig.CLOSE)) {
                        c2 = 1;
                    }
                } else if (optString.equals("reload")) {
                    c2 = 0;
                }
                d.a.o0.a.e0.d.g("V8InspectorClient", "v8 inspector reload");
                String optString2 = jSONObject.optString("value");
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(Uri.parse(optString2).getHost(), "swanAPI")) {
                    SchemeRouter.invoke(AppRuntime.getAppContext(), optString2);
                }
            } catch (JSONException e2) {
                if (b.f44666g) {
                    Log.e("V8InspectorClient", "message is not a json object", e2);
                }
            }
        }

        @Override // g.b.e.a
        public void onClose(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                d.a.o0.a.e0.d.g("V8InspectorClient", "V8 inspector closed");
            }
        }

        @Override // g.b.e.a
        public void onError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                d.a.o0.a.e0.d.c("V8InspectorClient", "V8 inspector error", exc);
            }
        }

        @Override // g.b.e.a
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f44674e.f44671e.offer(str);
                this.f44674e.f44670d.postOnJSThread(new a(this));
            }
        }

        @Override // g.b.e.a
        public void onOpen(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
                d.a.o0.a.e0.d.g("V8InspectorClient", "V8 inspector opened");
                d.a.o0.a.h0.l.a P = g.N().P();
                if (P instanceof e) {
                    this.f44674e.f44670d = (d.a.o0.a.l0.a) P.g();
                }
                if (this.f44674e.f44670d == null) {
                    d.a.o0.a.e0.d.g("V8InspectorClient", "inner error, V8 mEngine is null");
                    close();
                    return;
                }
                b bVar = this.f44674e;
                bVar.f44669c = bVar.f44670d.r0(new a(this.f44674e));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1468290073, "Ld/a/o0/a/e0/h/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1468290073, "Ld/a/o0/a/e0/h/c/b;");
                return;
            }
        }
        f44666g = k.f46335a;
    }

    public b(String str, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44671e = new LinkedBlockingQueue<>();
        this.f44672f = str;
        this.f44667a = bVar;
    }

    @Override // d.a.o0.a.e0.h.a.c
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                C0684b c0684b = new C0684b(this, new URI(this.f44672f));
                this.f44668b = c0684b;
                c0684b.connect();
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.o0.a.e0.h.a.c
    public void stop() {
        g.b.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f44668b) == null) {
            return;
        }
        aVar.close();
        this.f44668b = null;
    }
}
