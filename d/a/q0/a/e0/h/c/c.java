package d.a.q0.a.e0.h.c;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e0.h.a;
import d.a.q0.a.k;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes8.dex */
public class c implements a.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47475f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a.b f47476a;

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f47477b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.a.e0.h.c.a f47478c;

    /* renamed from: d  reason: collision with root package name */
    public String f47479d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47480e;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f47481a;

        /* renamed from: b  reason: collision with root package name */
        public String f47482b;

        /* renamed from: c  reason: collision with root package name */
        public String f47483c;

        /* renamed from: d  reason: collision with root package name */
        public String f47484d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f47485e;

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
                    return;
                }
            }
            this.f47481a = new HashMap();
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f47486a;

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
            this.f47486a = aVar;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }

        public abstract Map<String, String> b();

        public abstract String c();

        public final void d(PrintWriter printWriter, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, printWriter, str, str2) == null) {
                printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append(Part.CRLF);
            }
        }

        public void e(OutputStream outputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, outputStream) == null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
                printWriter.append("HTTP/1.1").append(' ').append((CharSequence) c()).append(" \r\n");
                d(printWriter, "Date", simpleDateFormat.format(new Date()));
                printWriter.print("Content-Length: " + a().getBytes().length + Part.CRLF);
                Map<String, String> b2 = b();
                if (b2 != null && b2.size() > 0) {
                    for (Map.Entry<String, String> entry : b().entrySet()) {
                        d(printWriter, entry.getKey(), entry.getValue());
                    }
                }
                printWriter.append(Part.CRLF);
                printWriter.append((CharSequence) a());
                printWriter.flush();
                printWriter.close();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(457172854, "Ld/a/q0/a/e0/h/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(457172854, "Ld/a/q0/a/e0/h/c/c;");
                return;
            }
        }
        f47475f = k.f49133a;
    }

    public c(String str, a.b bVar) {
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
        this.f47479d = str;
        this.f47476a = bVar;
    }

    @Override // d.a.q0.a.e0.h.a.c
    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47480e) {
            return;
        }
        try {
            this.f47477b = new LocalServerSocket(this.f47479d);
            this.f47480e = true;
            int i2 = 0;
            while (this.f47480e) {
                LocalSocket accept = this.f47477b.accept();
                d.a.q0.a.e0.h.c.a aVar = new d.a.q0.a.e0.h.c.a(accept.getInputStream(), accept.getOutputStream());
                this.f47478c = aVar;
                aVar.o(this.f47476a);
                ExecutorUtilsExt.postOnSerial(this.f47478c, "V8InspectorServer");
                if (d.a.q0.a.u1.a.a.G() && (i2 = i2 + 1) > 10) {
                    if (f47475f) {
                        Log.e("V8InspectorServer", "v8 inspector handshake exceeding the maximum limit");
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e2) {
            d.a.q0.a.e0.d.c("V8InspectorServer", "launch local server fail", e2);
        }
    }

    @Override // d.a.q0.a.e0.h.a.c
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f47480e = false;
            LocalServerSocket localServerSocket = this.f47477b;
            if (localServerSocket != null) {
                try {
                    localServerSocket.close();
                } catch (IOException e2) {
                    d.a.q0.a.e0.d.c("V8InspectorServer", "stop local server fail", e2);
                }
                this.f47477b = null;
            }
            d.a.q0.a.e0.h.c.a aVar = this.f47478c;
            if (aVar != null) {
                aVar.l();
                this.f47478c = null;
            }
            this.f47476a = null;
        }
    }
}
