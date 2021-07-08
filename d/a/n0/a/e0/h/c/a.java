package d.a.n0.a.e0.h.c;

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
import d.a.n0.a.e0.h.a;
import d.a.n0.a.e0.h.c.c;
import d.a.n0.a.e0.h.d.a;
import d.a.n0.a.h;
import d.a.n0.a.h0.l.e;
import d.a.n0.a.h0.u.g;
import d.a.n0.a.k;
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
/* loaded from: classes7.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f44153e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f44154f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.a.e0.h.d.a f44155g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f44156h;

    /* renamed from: i  reason: collision with root package name */
    public InspectorNativeClient f44157i;
    public d.a.n0.a.l0.a j;
    public a.b k;

    /* renamed from: d.a.n0.a.e0.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0673a implements a.InterfaceC0677a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44158a;

        /* renamed from: d.a.n0.a.e0.h.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0674a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0673a f44159e;

            public RunnableC0674a(C0673a c0673a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0673a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44159e = c0673a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.f44159e.f44158a.f44156h.poll();
                    while (str != null) {
                        this.f44159e.f44158a.f44157i.dispatchProtocolMessage(str);
                        this.f44159e.d(str);
                        str = (String) this.f44159e.f44158a.f44156h.poll();
                    }
                }
            }
        }

        /* renamed from: d.a.n0.a.e0.h.c.a$a$b */
        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0673a f44160e;

            public b(C0673a c0673a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0673a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44160e = c0673a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44160e.f44158a.k.onConnected();
                    this.f44160e.f44158a.k = null;
                    int unused = a.m = 2;
                }
            }
        }

        public C0673a(a aVar) {
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
            this.f44158a = aVar;
        }

        @Override // d.a.n0.a.e0.h.d.a.InterfaceC0677a
        public void a(WebSocketFrame webSocketFrame) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, webSocketFrame) == null) {
                this.f44158a.f44156h.offer(webSocketFrame.g());
                this.f44158a.j.postOnJSThread(new RunnableC0674a(this));
            }
        }

        @Override // d.a.n0.a.e0.h.d.a.InterfaceC0677a
        public void b(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
                d.a.n0.a.e0.d.c("ClientHandler", "V8 inspector exception", iOException);
                this.f44158a.l();
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || this.f44158a.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.a.n0.a.a2.d g2 = d.a.n0.a.a2.d.g();
                    SwanAppActivity x = d.a.n0.a.a2.d.g().x();
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

        @Override // d.a.n0.a.e0.h.d.a.InterfaceC0677a
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                d.a.n0.a.e0.d.g("ClientHandler", "V8 inspector closed");
                this.f44158a.l();
            }
        }

        @Override // d.a.n0.a.e0.h.d.a.InterfaceC0677a
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                d.a.n0.a.e0.d.g("ClientHandler", "V8 inspector opened");
                d.a.n0.a.h0.l.a P = g.N().P();
                if (P instanceof e) {
                    this.f44158a.j = (d.a.n0.a.l0.a) P.g();
                }
                if (this.f44158a.j != null) {
                    if (this.f44158a.f44157i != null) {
                        this.f44158a.f44157i.destroy();
                    }
                    a aVar = this.f44158a;
                    aVar.f44157i = aVar.j.r0(new b(this.f44158a));
                    int unused = a.m = 1;
                    return;
                }
                d.a.n0.a.e0.d.g("ClientHandler", "inner error, V8 mEngine is null");
                this.f44158a.l();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44161a;

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
            this.f44161a = aVar;
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
                    return (String) this.f44161a.f44156h.take();
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
                    this.f44161a.f44155g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1973848667, "Ld/a/n0/a/e0/h/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1973848667, "Ld/a/n0/a/e0/h/c/a;");
                return;
            }
        }
        l = k.f45831a;
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
        this.f44156h = new LinkedBlockingQueue<>();
        this.f44153e = inputStream;
        this.f44154f = outputStream;
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
            LinkedBlockingQueue<String> linkedBlockingQueue = this.f44156h;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.clear();
                this.f44156h = null;
            }
            InspectorNativeClient inspectorNativeClient = this.f44157i;
            if (inspectorNativeClient != null) {
                inspectorNativeClient.destroy();
                this.f44157i = null;
            }
            InputStream inputStream = this.f44153e;
            if (inputStream != null) {
                d.a.n0.t.d.d(inputStream);
                this.f44153e = null;
            }
            OutputStream outputStream = this.f44154f;
            if (outputStream != null) {
                d.a.n0.t.d.d(outputStream);
                this.f44154f = null;
            }
            this.f44155g = null;
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
                    aVar.f44180b = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f44181c = n(stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            aVar.f44182d = stringTokenizer.nextToken();
                        } else {
                            aVar.f44182d = "HTTP/1.1";
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
                                aVar.f44179a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
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
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f44153e));
                    c.a aVar = new c.a();
                    m(bufferedReader, aVar);
                    d.a(aVar).e(this.f44154f);
                    if (aVar.f44183e) {
                        if (m != 0 && m != 3) {
                            d.a.n0.a.z1.b.f.e.f(d.a.n0.a.c1.a.b(), h.aiapps_debug_inspect_doing).F();
                            return;
                        }
                        d.a.n0.a.e0.h.d.a aVar2 = new d.a.n0.a.e0.h.d.a();
                        this.f44155g = aVar2;
                        aVar2.k(new C0673a(this));
                        this.f44155g.h(this.f44153e, this.f44154f);
                    }
                } catch (RuntimeException e2) {
                    if (l) {
                        Log.e("ClientHandler", "Request parse fail", e2);
                    }
                }
            } finally {
                d.a.n0.t.d.d(this.f44153e);
                d.a.n0.t.d.d(this.f44154f);
            }
        }
    }
}
