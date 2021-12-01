package com.kwad.v8.debug;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.JavaVoidCallback;
import com.kwad.v8.Releasable;
import com.kwad.v8.V8;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class V8DebugServer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    public static final String HEADER_EMBEDDING_HOST = "Embedding-Host: ";
    public static final String HEADER_PROTOCOL_VERSION = "Protocol-Version: ";
    public static final String HEADER_TYPE = "Type: ";
    public static final String HEADER_V8_VERSION = "V8-Version: ";
    public static final String J2V8_VERSION = "4.0.0";
    public static final String MAKE_BREAK_EVENT = "__j2v8_MakeBreakEvent";
    public static final String MAKE_COMPILE_EVENT = "__j2v8_MakeCompileEvent";
    public static final int PROTOCOL_BUFFER_SIZE = 4096;
    public static final Charset PROTOCOL_CHARSET;
    public static final byte[] PROTOCOL_CONTENT_LENGTH_BYTES;
    public static final String PROTOCOL_CONTENT_LENGTH_HEADER = "Content-Length:";
    public static final String PROTOCOL_EOL = "\r\n";
    public static final byte[] PROTOCOL_EOL_BYTES;
    public static final String PROTOCOL_VERSION = "1";
    public static final String SET_LISTENER = "setListener";
    public static final String V8_DEBUG_OBJECT = "Debug";
    public static final String V8_VERSION = "4.10.253";
    public transient /* synthetic */ FieldHolder $fh;
    public Socket client;
    public Object clientLock;
    public V8Object debugObject;
    public List<String> requests;
    public V8Object runningStateDcp;
    public V8 runtime;
    public ServerSocket server;
    public V8Object stoppedStateDcp;
    public boolean traceCommunication;
    public boolean waitForConnection;

    /* renamed from: com.kwad.v8.debug.V8DebugServer$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class ClientLoop implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int from;
        public final /* synthetic */ V8DebugServer this$0;

        public ClientLoop(V8DebugServer v8DebugServer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8DebugServer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = v8DebugServer;
        }

        public /* synthetic */ ClientLoop(V8DebugServer v8DebugServer, AnonymousClass1 anonymousClass1) {
            this(v8DebugServer);
        }

        private int indexOf(byte[] bArr, byte[] bArr2, int i2, int i3) {
            InterceptResult invokeLLII;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, this, bArr, bArr2, i2, i3)) == null) {
                int length = bArr.length;
                while (i2 < i3) {
                    while (i4 <= length) {
                        if (i4 == length) {
                            return i2;
                        }
                        int i5 = i2 + i4;
                        i4 = (i5 < i3 && bArr2[i5] == bArr[i4]) ? i4 + 1 : 0;
                        i2++;
                    }
                    i2++;
                }
                return -1;
            }
            return invokeLLII.intValue;
        }

        private byte[] join(byte[] bArr, byte[] bArr2, int i2, int i3) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, this, bArr, bArr2, i2, i3)) == null) {
                byte[] bArr3 = new byte[bArr.length + i3];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                System.arraycopy(bArr2, i2, bArr3, bArr.length, i3);
                return bArr3;
            }
            return (byte[]) invokeLLII.objValue;
        }

        private void processClientRequests() {
            InputStream inputStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) {
                return;
            }
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[4096];
            synchronized (this.this$0.clientLock) {
                inputStream = this.this$0.client.getInputStream();
            }
            byte[] bArr3 = bArr;
            int i2 = 0;
            boolean z = false;
            int i3 = -1;
            while (true) {
                int read = inputStream.read(bArr2, i2, 4096 - i2);
                if (read <= 0) {
                    return;
                }
                int i4 = read + i2;
                this.from = 0;
                do {
                    if (i3 < 0) {
                        i3 = readContentLength(bArr2, i4);
                        if (i3 < 0) {
                            break;
                        }
                    }
                    if (!z && !(z = skipToolInfo(bArr2, i4))) {
                        break;
                    }
                    int min = Math.min(i3 - bArr3.length, i4 - this.from);
                    bArr3 = join(bArr3, bArr2, this.from, min);
                    this.from += min;
                    if (bArr3.length == i3) {
                        String str = new String(bArr3, V8DebugServer.PROTOCOL_CHARSET);
                        synchronized (this.this$0.requests) {
                            this.this$0.requests.add(str);
                        }
                        bArr3 = bArr;
                        z = false;
                        i3 = -1;
                    }
                } while (this.from < i4);
                int i5 = this.from;
                if (i5 < i4) {
                    System.arraycopy(bArr2, i5, bArr2, 0, i4 - i5);
                    i2 = i4 - this.from;
                } else {
                    i2 = 0;
                }
            }
        }

        private int readContentLength(byte[] bArr, int i2) {
            InterceptResult invokeLI;
            int length;
            int indexOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, this, bArr, i2)) == null) {
                int indexOf2 = indexOf(V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES, bArr, this.from, i2);
                if (indexOf2 >= 0 && (indexOf = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, (length = indexOf2 + V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES.length), i2)) >= 0) {
                    String str = new String(bArr, length, indexOf - length, V8DebugServer.PROTOCOL_CHARSET);
                    try {
                        int parseInt = Integer.parseInt(str.trim());
                        this.from = indexOf + V8DebugServer.PROTOCOL_EOL_BYTES.length;
                        return parseInt;
                    } catch (Exception unused) {
                        throw new IOException("Invalid content length header: '" + str + "' in message" + new String(bArr, V8DebugServer.PROTOCOL_CHARSET));
                    }
                }
                return -1;
            }
            return invokeLI.intValue;
        }

        private boolean skipToolInfo(byte[] bArr, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, this, bArr, i2)) == null) {
                int indexOf = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, this.from, i2);
                if (indexOf < 0) {
                    return false;
                }
                this.from = indexOf + V8DebugServer.PROTOCOL_EOL_BYTES.length;
                return true;
            }
            return invokeLI.booleanValue;
        }

        private void startHandshake() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65543, this) == null) {
                this.this$0.sendMessage(V8DebugServer.HEADER_V8_VERSION + V8DebugServer.V8_VERSION + "\r\n" + V8DebugServer.HEADER_PROTOCOL_VERSION + "1\r\n" + V8DebugServer.HEADER_EMBEDDING_HOST + "j2v8 " + V8DebugServer.J2V8_VERSION + "\r\n" + V8DebugServer.HEADER_TYPE + "connect\r\n", "");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                try {
                    Socket accept = this.this$0.server.accept();
                    accept.setTcpNoDelay(true);
                    synchronized (this.this$0.clientLock) {
                        this.this$0.client = accept;
                        this.this$0.waitForConnection = false;
                        this.this$0.clientLock.notifyAll();
                    }
                    startHandshake();
                    processClientRequests();
                } catch (Exception e2) {
                    synchronized (this.this$0.clientLock) {
                        if (this.this$0.client != null) {
                            try {
                                this.this$0.client.close();
                            } catch (IOException unused) {
                            }
                            this.this$0.client = null;
                        }
                        this.this$0.logError(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class EventHandler implements JavaVoidCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ V8DebugServer this$0;

        public EventHandler(V8DebugServer v8DebugServer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8DebugServer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = v8DebugServer;
        }

        public /* synthetic */ EventHandler(V8DebugServer v8DebugServer, AnonymousClass1 anonymousClass1) {
            this(v8DebugServer);
        }

        private void safeRelease(Releasable releasable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, this, releasable) == null) || releasable == null) {
                return;
            }
            releasable.release();
        }

        @Override // com.kwad.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            Releasable releasable;
            int integer;
            V8Object object;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, v8Object, v8Array) == null) || v8Array == null || v8Array.isUndefined()) {
                return;
            }
            V8Object v8Object2 = null;
            try {
                integer = v8Array.getInteger(0);
                object = v8Array.getObject(1);
            } catch (Exception e2) {
                e = e2;
                releasable = null;
            } catch (Throwable th) {
                th = th;
                releasable = null;
            }
            try {
                V8Object object2 = v8Array.getObject(2);
                if (this.this$0.traceCommunication) {
                    String str = "unknown";
                    switch (integer) {
                        case 1:
                            str = "Break";
                            break;
                        case 2:
                            str = "Exception";
                            break;
                        case 3:
                            str = "NewFunction";
                            break;
                        case 4:
                            str = "BeforeCompile";
                            break;
                        case 5:
                            str = "AfterCompile";
                            break;
                        case 6:
                            str = "CompileError";
                            break;
                        case 7:
                            str = "PromiseEvent";
                            break;
                        case 8:
                            str = "AsyncTaskEvent";
                            break;
                    }
                    System.out.println("V8 has emmitted an event of type " + str);
                }
                if (!this.this$0.isConnected()) {
                    safeRelease(object);
                    safeRelease(object2);
                    return;
                }
                if (integer == 1) {
                    this.this$0.enterBreakLoop(object, object2);
                } else if (integer == 5 || integer == 6) {
                    this.this$0.sendCompileEvent(object2);
                }
                safeRelease(object);
                safeRelease(object2);
            } catch (Exception e3) {
                e = e3;
                releasable = null;
                v8Object2 = object;
                try {
                    this.this$0.logError(e);
                    safeRelease(v8Object2);
                    safeRelease(releasable);
                } catch (Throwable th2) {
                    th = th2;
                    safeRelease(v8Object2);
                    safeRelease(releasable);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                releasable = null;
                v8Object2 = object;
                safeRelease(v8Object2);
                safeRelease(releasable);
                throw th;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1903840630, "Lcom/kwad/v8/debug/V8DebugServer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1903840630, "Lcom/kwad/v8/debug/V8DebugServer;");
                return;
            }
        }
        Charset forName = Charset.forName("UTF-8");
        PROTOCOL_CHARSET = forName;
        PROTOCOL_EOL_BYTES = "\r\n".getBytes(forName);
        PROTOCOL_CONTENT_LENGTH_BYTES = PROTOCOL_CONTENT_LENGTH_HEADER.getBytes(PROTOCOL_CHARSET);
    }

    public V8DebugServer(V8 v8, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.clientLock = new Object();
        this.traceCommunication = false;
        this.requests = new LinkedList();
        this.runtime = v8;
        this.waitForConnection = z;
        V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
        if (object == null) {
            System.err.println("Cannot initialize debugger server - global debug object not found.");
            return;
        }
        try {
            this.debugObject = object.getObject("Debug");
            object.close();
            v8.executeVoidScript("(function() {\n " + DEBUG_OBJECT_NAME + ".Debug. " + MAKE_BREAK_EVENT + " = function (break_id,breakpoints_hit) {\n  return new " + DEBUG_OBJECT_NAME + ".BreakEvent(break_id,breakpoints_hit);\n }\n " + DEBUG_OBJECT_NAME + ".Debug. " + MAKE_COMPILE_EVENT + " = function(script,type) {\n  var scripts = " + DEBUG_OBJECT_NAME + ".Debug.scripts()\n  for (var i in scripts) {\n   if (scripts[i].id == script.id()) {\n     return new " + DEBUG_OBJECT_NAME + ".CompileEvent(scripts[i], type);\n   }\n  }\n  return {toJSONProtocol: function() {return ''}}\n }\n})()");
            try {
                this.server = new ServerSocket(i2);
            } catch (Exception e2) {
                logError(e2);
            }
        } catch (Throwable th) {
            object.close();
            throw th;
        }
    }

    public static void configureV8ForDebugging() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            try {
                V8.setFlags("-expose-debug-as=" + DEBUG_OBJECT_NAME);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterBreakLoop(V8Object v8Object, V8Object v8Object2) {
        V8Object v8Object3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65553, this, v8Object, v8Object2) != null) {
            return;
        }
        try {
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push(false);
            this.stoppedStateDcp = v8Object.executeObjectFunction("debugCommandProcessor", v8Array);
            v8Array.close();
            int integer = v8Object.getInteger("break_id");
            V8Array array = v8Object2.getArray("break_points_hit_");
            V8Array v8Array2 = new V8Array(this.runtime);
            try {
                v8Array2.push(integer);
                v8Array2.push((V8Value) array);
                v8Object3 = this.debugObject.executeObjectFunction(MAKE_BREAK_EVENT, v8Array2);
                try {
                    String executeStringFunction = v8Object3.executeStringFunction("toJSONProtocol", null);
                    if (this.traceCommunication) {
                        System.out.println("Sending event (Break):\n" + executeStringFunction);
                    }
                    sendJson(executeStringFunction);
                    v8Array2.close();
                    array.close();
                    if (v8Object3 != null) {
                        v8Object3.close();
                    }
                    while (isConnected() && !this.stoppedStateDcp.executeBooleanFunction("isRunning", null)) {
                        try {
                            processRequests(10L);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    v8Array2.close();
                    array.close();
                    if (v8Object3 != null) {
                        v8Object3.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v8Object3 = null;
            }
        } finally {
            this.stoppedStateDcp.close();
            this.stoppedStateDcp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnected() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            synchronized (this.clientLock) {
                z = (this.server == null || this.client == null || !this.client.isConnected()) ? false : true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void processRequest(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            if (this.traceCommunication) {
                PrintStream printStream = System.out;
                printStream.println("Got message: \n" + str.substring(0, Math.min(str.length(), 1000)));
            }
            V8Array v8Array = new V8Array(this.runtime);
            v8Array.push(str);
            V8Object v8Object = this.stoppedStateDcp;
            if (v8Object == null) {
                v8Object = this.runningStateDcp;
            }
            String obj = v8Object.executeFunction("processDebugJSONRequest", v8Array).toString();
            if (this.stoppedStateDcp == null && obj.contains("\"running\":false")) {
                obj = obj.replace("\"running\":false", "\"running\":true").replace("\"success\":true", "\"success\":false").replace("{\"", "{\"message\":\"Client requested suspension is not supported on J2V8.\",\"");
                v8Object.add("running_", true);
            }
            if (this.traceCommunication) {
                PrintStream printStream2 = System.out;
                printStream2.println("Returning response: \n" + obj.substring(0, Math.min(obj.length(), 1000)));
            }
            sendJson(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCompileEvent(V8Object v8Object) {
        Throwable th;
        V8Object v8Object2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65556, this, v8Object) != null) || !isConnected()) {
            return;
        }
        int integer = v8Object.getInteger("type_");
        V8Object object = v8Object.getObject("script_");
        V8Array v8Array = new V8Array(this.runtime);
        try {
            v8Array.push((V8Value) object);
            v8Array.push(integer);
            v8Object2 = this.debugObject.executeObjectFunction(MAKE_COMPILE_EVENT, v8Array);
            try {
                String executeStringFunction = v8Object2.executeStringFunction("toJSONProtocol", null);
                if (this.traceCommunication) {
                    System.out.println("Sending event (CompileEvent):\n" + executeStringFunction.substring(0, Math.min(executeStringFunction.length(), 1000)));
                }
                if (executeStringFunction.length() > 0) {
                    sendJson(executeStringFunction);
                }
                v8Array.close();
                object.close();
                if (v8Object2 != null) {
                    v8Object2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                v8Array.close();
                object.close();
                if (v8Object2 != null) {
                    v8Object2.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            v8Object2 = null;
        }
    }

    private void sendJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, str) == null) {
            sendMessage("", str.replace("\\/", "/"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, this, str, str2) == null) {
            synchronized (this.clientLock) {
                if (!isConnected()) {
                    throw new IOException("There is no connected client.");
                }
                byte[] bytes = str2.getBytes(PROTOCOL_CHARSET);
                this.client.getOutputStream().write((str + PROTOCOL_CONTENT_LENGTH_HEADER + Integer.toString(bytes.length) + "\r\n\r\n").getBytes(PROTOCOL_CHARSET));
                if (bytes.length > 0) {
                    this.client.getOutputStream().write(bytes);
                }
            }
        }
    }

    private void setupEventHandler() {
        V8Array v8Array;
        Throwable th;
        V8Function v8Function;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.debugObject.registerJavaMethod(new EventHandler(this, null), "__j2v8_debug_handler");
            try {
                v8Function = (V8Function) this.debugObject.getObject("__j2v8_debug_handler");
                try {
                    v8Array = new V8Array(this.runtime);
                } catch (Throwable th2) {
                    v8Array = null;
                    th = th2;
                }
            } catch (Throwable th3) {
                v8Array = null;
                th = th3;
                v8Function = null;
            }
            try {
                v8Array.push((V8Value) v8Function);
                this.debugObject.executeFunction("setListener", v8Array);
                if (v8Function != null && !v8Function.isReleased()) {
                    v8Function.close();
                }
                if (v8Array.isReleased()) {
                    return;
                }
                v8Array.close();
            } catch (Throwable th4) {
                th = th4;
                if (v8Function != null && !v8Function.isReleased()) {
                    v8Function.close();
                }
                if (v8Array != null && !v8Array.isReleased()) {
                    v8Array.close();
                }
                throw th;
            }
        }
    }

    public int getPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ServerSocket serverSocket = this.server;
            if (serverSocket == null || !serverSocket.isBound()) {
                return -1;
            }
            return this.server.getLocalPort();
        }
        return invokeV.intValue;
    }

    public void logError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            th.printStackTrace();
        }
    }

    public void processRequests(long j2) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || this.server == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            synchronized (this.requests) {
                strArr = (String[]) this.requests.toArray(new String[this.requests.size()]);
                this.requests.clear();
            }
            for (String str : strArr) {
                try {
                    processRequest(str);
                } catch (Exception e2) {
                    logError(e2);
                }
            }
            if (strArr.length <= 0) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 > 0) {
                    Thread.sleep(10L);
                }
                if (i2 <= 0 || currentTimeMillis + j2 <= System.currentTimeMillis()) {
                    return;
                }
            }
        }
    }

    public void setTraceCommunication(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.traceCommunication = z;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.server == null) {
            return;
        }
        boolean z = this.waitForConnection;
        Thread thread = new Thread(new ClientLoop(this, null), "J2V8 Debugger Server");
        thread.setDaemon(true);
        thread.start();
        setupEventHandler();
        V8 v8 = this.runtime;
        this.runningStateDcp = v8.executeObjectScript("(function() {return new " + DEBUG_OBJECT_NAME + ".DebugCommandProcessor(null, true)})()");
        if (z) {
            synchronized (this.clientLock) {
                while (this.waitForConnection) {
                    try {
                        this.clientLock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            try {
                processRequests(100L);
            } catch (InterruptedException unused2) {
            }
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.server.close();
                synchronized (this.clientLock) {
                    if (this.client != null) {
                        this.client.close();
                        this.client = null;
                    }
                }
            } catch (IOException e2) {
                logError(e2);
            }
            V8Object v8Object = this.runningStateDcp;
            if (v8Object != null) {
                v8Object.close();
                this.runningStateDcp = null;
            }
            V8Object v8Object2 = this.debugObject;
            if (v8Object2 != null) {
                v8Object2.close();
                this.debugObject = null;
            }
            V8Object v8Object3 = this.stoppedStateDcp;
            if (v8Object3 != null) {
                v8Object3.close();
                this.stoppedStateDcp = null;
            }
        }
    }
}
