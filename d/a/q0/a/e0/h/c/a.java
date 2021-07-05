package d.a.q0.a.e0.h.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.StringUtils;
import d.a.q0.a.e0.h.a;
import d.a.q0.a.e0.h.c.c;
import d.a.q0.a.e0.h.d.a;
import d.a.q0.a.h;
import d.a.q0.a.h0.l.e;
import d.a.q0.a.h0.u.g;
import d.a.q0.a.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f47455e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f47456f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.a.e0.h.d.a f47457g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f47458h;

    /* renamed from: i  reason: collision with root package name */
    public InspectorNativeClient f47459i;
    public d.a.q0.a.l0.a j;
    public a.b k;

    /* renamed from: d.a.q0.a.e0.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0724a implements a.InterfaceC0728a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47460a;

        /* renamed from: d.a.q0.a.e0.h.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0725a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0724a f47461e;

            public RunnableC0725a(C0724a c0724a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0724a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47461e = c0724a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.f47461e.f47460a.f47458h.poll();
                    while (str != null) {
                        this.f47461e.f47460a.f47459i.dispatchProtocolMessage(str);
                        this.f47461e.d(str);
                        str = (String) this.f47461e.f47460a.f47458h.poll();
                    }
                }
            }
        }

        /* renamed from: d.a.q0.a.e0.h.c.a$a$b */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0724a f47462e;

            public b(C0724a c0724a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0724a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47462e = c0724a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f47462e.f47460a.k.onConnected();
                    this.f47462e.f47460a.k = null;
                    int unused = a.m = 2;
                }
            }
        }

        public C0724a(a aVar) {
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
            this.f47460a = aVar;
        }

        @Override // d.a.q0.a.e0.h.d.a.InterfaceC0728a
        public void a(WebSocketFrame webSocketFrame) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, webSocketFrame) == null) {
                this.f47460a.f47458h.offer(webSocketFrame.g());
                this.f47460a.j.postOnJSThread(new RunnableC0725a(this));
            }
        }

        @Override // d.a.q0.a.e0.h.d.a.InterfaceC0728a
        public void b(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
                d.a.q0.a.e0.d.c("ClientHandler", "V8 inspector exception", iOException);
                this.f47460a.l();
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || this.f47460a.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.a.q0.a.a2.d g2 = d.a.q0.a.a2.d.g();
                    SwanAppActivity x = d.a.q0.a.a2.d.g().x();
                    if (g2.C() && x != null) {
                        x.runOnUiThread(new b(this));
                    }
                }
            } catch (JSONException e2) {
                if (a.l) {
                    Log.e("ClientHandler", "message is not a Json object", e2);
                }
            }
        }

        @Override // d.a.q0.a.e0.h.d.a.InterfaceC0728a
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                d.a.q0.a.e0.d.g("ClientHandler", "V8 inspector closed");
                this.f47460a.l();
            }
        }

        @Override // d.a.q0.a.e0.h.d.a.InterfaceC0728a
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                d.a.q0.a.e0.d.g("ClientHandler", "V8 inspector opened");
                d.a.q0.a.h0.l.a P = g.N().P();
                if (P instanceof e) {
                    this.f47460a.j = (d.a.q0.a.l0.a) P.g();
                }
                if (this.f47460a.j != null) {
                    if (this.f47460a.f47459i != null) {
                        this.f47460a.f47459i.destroy();
                    }
                    a aVar = this.f47460a;
                    aVar.f47459i = aVar.j.r0(new b(this.f47460a));
                    int unused = a.m = 1;
                    return;
                }
                d.a.q0.a.e0.d.g("ClientHandler", "inner error, V8 mEngine is null");
                this.f47460a.l();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47463a;

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
            this.f47463a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (a.l) {
                    Log.d("ClientHandler", "getInspectorMessage");
                }
                try {
                    return (String) this.f47463a.f47458h.take();
                } catch (InterruptedException e2) {
                    if (a.l) {
                        Log.e("ClientHandler", "awaitMessage on Debugger", e2);
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
                    this.f47463a.f47457g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
                } catch (Exception unused) {
                    if (a.l) {
                        Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(457172792, "Ld/a/q0/a/e0/h/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(457172792, "Ld/a/q0/a/e0/h/c/a;");
                return;
            }
        }
        l = k.f49133a;
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47458h = new LinkedBlockingQueue<>();
        this.f47455e = inputStream;
        this.f47456f = outputStream;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            try {
                return URLDecoder.decode(str, StringUtils.UTF8);
            } catch (UnsupportedEncodingException unused) {
                if (l) {
                    Log.d("ClientHandler", "Encoding not supported, ignored");
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedBlockingQueue<String> linkedBlockingQueue = this.f47458h;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.clear();
                this.f47458h = null;
            }
            InspectorNativeClient inspectorNativeClient = this.f47459i;
            if (inspectorNativeClient != null) {
                inspectorNativeClient.destroy();
                this.f47459i = null;
            }
            InputStream inputStream = this.f47455e;
            if (inputStream != null) {
                d.a.q0.t.d.d(inputStream);
                this.f47455e = null;
            }
            OutputStream outputStream = this.f47456f;
            if (outputStream != null) {
                d.a.q0.t.d.d(outputStream);
                this.f47456f = null;
            }
            this.f47457g = null;
            this.j = null;
            m = 3;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void m(BufferedReader bufferedReader, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferedReader, aVar) == null) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.f47482b = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f47483c = n(stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            aVar.f47484d = stringTokenizer.nextToken();
                        } else {
                            aVar.f47484d = "HTTP/1.1";
                            if (l) {
                                Log.d("ClientHandler", "no protocol version specified, Assuming HTTP/1.1.");
                            }
                        }
                        String readLine2 = bufferedReader.readLine();
                        while (readLine2 != null && !readLine2.trim().isEmpty()) {
                            if (l) {
                                Log.d("ClientHandler", "Http header :" + readLine2);
                            }
                            int indexOf = readLine2.indexOf(58);
                            if (indexOf >= 0) {
                                aVar.f47481a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
                            }
                            readLine2 = bufferedReader.readLine();
                        }
                        return;
                    }
                    throw new RuntimeException("BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                throw new RuntimeException("BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            } catch (IOException e2) {
                if (l) {
                    Log.e("ClientHandler", "Decode header exception", e2);
                }
            }
        }
    }

    public void o(a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && m == 0) {
            this.k = bVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f47455e));
                    c.a aVar = new c.a();
                    m(bufferedReader, aVar);
                    d.a(aVar).e(this.f47456f);
                    if (aVar.f47485e) {
                        if (m != 0 && m != 3) {
                            d.a.q0.a.z1.b.f.e.f(d.a.q0.a.c1.a.b(), h.aiapps_debug_inspect_doing).F();
                            return;
                        }
                        d.a.q0.a.e0.h.d.a aVar2 = new d.a.q0.a.e0.h.d.a();
                        this.f47457g = aVar2;
                        aVar2.k(new C0724a(this));
                        this.f47457g.h(this.f47455e, this.f47456f);
                    }
                } catch (RuntimeException e2) {
                    if (l) {
                        Log.e("ClientHandler", "Request parse fail", e2);
                    }
                }
            } finally {
                d.a.q0.t.d.d(this.f47455e);
                d.a.q0.t.d.d(this.f47456f);
            }
        }
    }
}
