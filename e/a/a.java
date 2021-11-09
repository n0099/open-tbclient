package e.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.multidex.MultiDexExtractor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dxm.sasdk.DbAdapter;
import dxm.sasdk.DxmSdkSensorsDataAPI;
import dxm.sasdk.exceptions.ConnectErrorException;
import dxm.sasdk.exceptions.DebugModeException;
import dxm.sasdk.exceptions.InvalidDataException;
import dxm.sasdk.exceptions.ResponseErrorException;
import dxm.sasdk.util.SensorsDataUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<Context, a> f71652d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final C2041a f71653a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f71654b;

    /* renamed from: c  reason: collision with root package name */
    public final DbAdapter f71655c;

    /* renamed from: e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2041a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Object f71656a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f71657b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f71658c;

        /* renamed from: e.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class HandlerC2042a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C2041a f71659a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC2042a(C2041a c2041a, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2041a, looper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71659a = c2041a;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    try {
                        if (message.what == 3) {
                            this.f71659a.f71658c.e();
                        } else {
                            k.b("SA.AnalyticsMessages", "Unexpected message received by SensorsData worker: " + message);
                        }
                    } catch (RuntimeException e2) {
                        k.c("SA.AnalyticsMessages", "Worker threw an unhandled exception", e2);
                    }
                }
            }
        }

        public C2041a(a aVar) {
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
            this.f71658c = aVar;
            this.f71656a = new Object();
            HandlerThread handlerThread = new HandlerThread("com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.f71657b = new HandlerC2042a(this, handlerThread.getLooper());
        }

        public void a(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                synchronized (this.f71656a) {
                    if (this.f71657b == null) {
                        k.b("SA.AnalyticsMessages", "Dead worker dropping a message: " + message.what);
                    } else {
                        this.f71657b.sendMessage(message);
                    }
                }
            }
        }

        public void b(Message message, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message, j) == null) {
                synchronized (this.f71656a) {
                    if (this.f71657b == null) {
                        k.b("SA.AnalyticsMessages", "Dead worker dropping a message: " + message.what);
                    } else if (!this.f71657b.hasMessages(message.what)) {
                        this.f71657b.sendMessageDelayed(message, j);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1668690718, "Le/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1668690718, "Le/a/a;");
                return;
            }
        }
        f71652d = new HashMap();
    }

    public a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71654b = context;
        this.f71655c = new DbAdapter(this.f71654b, str);
        this.f71653a = new C2041a(this);
    }

    public static a d(Context context, String str) {
        InterceptResult invokeLL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            synchronized (f71652d) {
                Context applicationContext = context.getApplicationContext();
                if (!f71652d.containsKey(applicationContext)) {
                    aVar = new a(applicationContext, str);
                    f71652d.put(applicationContext, aVar);
                } else {
                    aVar = f71652d.get(applicationContext);
                }
            }
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public static byte[] f(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public final String a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.getBytes().length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return new String(e.a.q.a.a(byteArray));
        }
        return (String) invokeL.objValue;
    }

    public void b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
            try {
                synchronized (this.f71655c) {
                    int c2 = this.f71655c.c(jSONObject, DbAdapter.Table.EVENTS);
                    if (c2 < 0) {
                        String str2 = "Failed to enqueue the event: " + jSONObject;
                        if (!DxmSdkSensorsDataAPI.I(this.f71654b).y()) {
                            k.b("SA.AnalyticsMessages", str2);
                        } else {
                            throw new DebugModeException(str2);
                        }
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 3;
                    if (!DxmSdkSensorsDataAPI.I(this.f71654b).y() && c2 != -2) {
                        if (!str.equals("track_signup") && c2 <= DxmSdkSensorsDataAPI.I(this.f71654b).s()) {
                            this.f71653a.b(obtain, DxmSdkSensorsDataAPI.I(this.f71654b).t());
                        }
                        this.f71653a.a(obtain);
                    }
                    this.f71653a.a(obtain);
                }
            } catch (Exception e2) {
                k.b("SA.AnalyticsMessages", "enqueueEventMessage error:" + e2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.f71653a.a(obtain);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:219:0x03c2 */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v10, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v17, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v18, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v2, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v20, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v21, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v22, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v23, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v24, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v25, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v27, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v28, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v29, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v3, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v35, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v36, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v37, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v38, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v39, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v40, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v41, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v42, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v43, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v45, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v46, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v5, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v6, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v8, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v9, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0351, code lost:
        if (r6 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03ba, code lost:
        if (r6 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x03bc, code lost:
        r6.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x03bf, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c0, code lost:
        if (r6 != null) goto L73;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0310 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0379 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0424 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0402 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0409 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0345 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x033e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0454 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x02d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x034c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0462 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x02df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x045b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x02d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x02e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x02e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        String[] e2;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        boolean z;
        String str;
        BufferedOutputStream bufferedOutputStream3;
        String str2;
        int d2;
        BufferedOutputStream bufferedOutputStream4;
        String str3;
        BufferedOutputStream bufferedOutputStream5;
        String str4;
        OutputStream outputStream2;
        InputStream inputStream4;
        InputStream inputStream5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (!TextUtils.isEmpty(DxmSdkSensorsDataAPI.I(this.f71654b).w()) && SensorsDataUtils.f(this.f71654b)) {
                if (!DxmSdkSensorsDataAPI.I(this.f71654b).B(SensorsDataUtils.i(this.f71654b))) {
                    return;
                }
                int i2 = 100;
                while (i2 > 0) {
                    synchronized (this.f71655c) {
                        if (DxmSdkSensorsDataAPI.I(this.f71654b).y()) {
                            e2 = this.f71655c.e(DbAdapter.Table.EVENTS, 1);
                        } else {
                            e2 = this.f71655c.e(DbAdapter.Table.EVENTS, 50);
                        }
                    }
                    if (e2 == null) {
                        return;
                    }
                    i2 = 0;
                    String str5 = e2[0];
                    String str6 = e2[1];
                    try {
                        try {
                            String a2 = a(str6);
                            try {
                                httpURLConnection = (HttpURLConnection) new URL(DxmSdkSensorsDataAPI.I(this.f71654b).w()).openConnection();
                                try {
                                    try {
                                        String e4 = SensorsDataUtils.e(this.f71654b);
                                        if (TextUtils.isEmpty(e4)) {
                                            e4 = "SensorsAnalytics Android SDK";
                                        }
                                        httpURLConnection.addRequestProperty("User-Agent", e4);
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                    if (DxmSdkSensorsDataAPI.I(this.f71654b).y()) {
                                        try {
                                            if (!DxmSdkSensorsDataAPI.I(this.f71654b).z()) {
                                                httpURLConnection.addRequestProperty("Dry-Run", "true");
                                            }
                                        } catch (ConnectErrorException e6) {
                                            e = e6;
                                            inputStream3 = null;
                                            outputStream = null;
                                            bufferedOutputStream5 = outputStream;
                                            str4 = "Connection error: " + e.getMessage();
                                            boolean y = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                            if (!TextUtils.isEmpty(str4)) {
                                            }
                                            if (bufferedOutputStream5 != 0) {
                                            }
                                            if (outputStream != null) {
                                            }
                                            if (inputStream3 != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                        } catch (InvalidDataException e7) {
                                            e = e7;
                                            inputStream2 = null;
                                            outputStream = null;
                                            bufferedOutputStream4 = outputStream;
                                            str3 = "Invalid data: " + e.getMessage();
                                            boolean y2 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                            if (!TextUtils.isEmpty(str3)) {
                                            }
                                            d2 = this.f71655c.d(str5, DbAdapter.Table.EVENTS);
                                            k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                                            if (bufferedOutputStream4 != 0) {
                                            }
                                            if (outputStream != null) {
                                            }
                                            if (inputStream2 != null) {
                                            }
                                        } catch (ResponseErrorException e8) {
                                            e = e8;
                                            inputStream = null;
                                            outputStream = null;
                                            bufferedOutputStream = outputStream;
                                            try {
                                                str2 = "ResponseErrorException: " + e.getMessage();
                                                boolean y3 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(str2)) {
                                                }
                                                d2 = this.f71655c.d(str5, DbAdapter.Table.EVENTS);
                                                k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                                                if (bufferedOutputStream != 0) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                z = true;
                                                bufferedOutputStream3 = bufferedOutputStream;
                                                boolean y4 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(null) && (y4 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                    k.b("SA.AnalyticsMessages", null);
                                                }
                                                if (z) {
                                                    k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(this.f71655c.d(str5, DbAdapter.Table.EVENTS))));
                                                }
                                                if (bufferedOutputStream3 != 0) {
                                                    try {
                                                        bufferedOutputStream3.close();
                                                    } catch (IOException unused) {
                                                    }
                                                }
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (IOException unused2) {
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused3) {
                                                    }
                                                }
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                throw th;
                                            }
                                        } catch (IOException e9) {
                                            e = e9;
                                            outputStream2 = null;
                                            inputStream4 = null;
                                            inputStream5 = inputStream4;
                                            try {
                                                throw new ConnectErrorException(e);
                                                break;
                                            } catch (ConnectErrorException e10) {
                                                e = e10;
                                                InputStream inputStream6 = inputStream4;
                                                outputStream = outputStream2;
                                                inputStream3 = inputStream6;
                                                bufferedOutputStream5 = inputStream5;
                                                str4 = "Connection error: " + e.getMessage();
                                                boolean y5 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(str4) && (y5 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                    k.b("SA.AnalyticsMessages", str4);
                                                }
                                                if (bufferedOutputStream5 != 0) {
                                                    try {
                                                        bufferedOutputStream5.close();
                                                    } catch (IOException unused4) {
                                                    }
                                                }
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (IOException unused5) {
                                                    }
                                                }
                                                if (inputStream3 != null) {
                                                    try {
                                                        inputStream3.close();
                                                    } catch (IOException unused6) {
                                                    }
                                                }
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                            } catch (InvalidDataException e11) {
                                                e = e11;
                                                InputStream inputStream7 = inputStream4;
                                                outputStream = outputStream2;
                                                inputStream2 = inputStream7;
                                                bufferedOutputStream4 = inputStream5;
                                                str3 = "Invalid data: " + e.getMessage();
                                                boolean y22 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(str3) && (y22 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                    k.b("SA.AnalyticsMessages", str3);
                                                }
                                                d2 = this.f71655c.d(str5, DbAdapter.Table.EVENTS);
                                                k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                                                if (bufferedOutputStream4 != 0) {
                                                    try {
                                                        bufferedOutputStream4.close();
                                                    } catch (IOException unused7) {
                                                    }
                                                }
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (IOException unused8) {
                                                    }
                                                }
                                                if (inputStream2 != null) {
                                                    try {
                                                        inputStream2.close();
                                                    } catch (IOException unused9) {
                                                    }
                                                }
                                            } catch (ResponseErrorException e12) {
                                                e = e12;
                                                InputStream inputStream8 = inputStream4;
                                                outputStream = outputStream2;
                                                inputStream = inputStream8;
                                                bufferedOutputStream = inputStream5;
                                                str2 = "ResponseErrorException: " + e.getMessage();
                                                boolean y32 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(str2) && (y32 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                    k.b("SA.AnalyticsMessages", str2);
                                                }
                                                d2 = this.f71655c.d(str5, DbAdapter.Table.EVENTS);
                                                k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                                                if (bufferedOutputStream != 0) {
                                                    try {
                                                        bufferedOutputStream.close();
                                                    } catch (IOException unused10) {
                                                    }
                                                }
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (IOException unused11) {
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused12) {
                                                    }
                                                }
                                            } catch (Exception e13) {
                                                e = e13;
                                                InputStream inputStream9 = inputStream4;
                                                outputStream = outputStream2;
                                                inputStream = inputStream9;
                                                bufferedOutputStream2 = inputStream5;
                                                try {
                                                    str = "Exception: " + e.getMessage();
                                                    boolean y6 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                    if (!TextUtils.isEmpty(str) && (y6 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                        k.b("SA.AnalyticsMessages", str);
                                                    }
                                                    if (bufferedOutputStream2 != 0) {
                                                        try {
                                                            bufferedOutputStream2.close();
                                                        } catch (IOException unused13) {
                                                        }
                                                    }
                                                    if (outputStream != null) {
                                                        try {
                                                            outputStream.close();
                                                        } catch (IOException unused14) {
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (IOException unused15) {
                                                        }
                                                    }
                                                    if (httpURLConnection != null) {
                                                        httpURLConnection.disconnect();
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    z = false;
                                                    bufferedOutputStream3 = bufferedOutputStream2;
                                                    boolean y42 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        k.b("SA.AnalyticsMessages", null);
                                                    }
                                                    if (z) {
                                                    }
                                                    if (bufferedOutputStream3 != 0) {
                                                    }
                                                    if (outputStream != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                z = true;
                                                InputStream inputStream10 = inputStream4;
                                                outputStream = outputStream2;
                                                inputStream = inputStream10;
                                                bufferedOutputStream3 = inputStream5;
                                                boolean y422 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(null)) {
                                                }
                                                if (z) {
                                                }
                                                if (bufferedOutputStream3 != 0) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e14) {
                                            e = e14;
                                            inputStream = null;
                                            outputStream = null;
                                            bufferedOutputStream2 = outputStream;
                                            str = "Exception: " + e.getMessage();
                                            boolean y62 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                            if (!TextUtils.isEmpty(str)) {
                                            }
                                            if (bufferedOutputStream2 != 0) {
                                            }
                                            if (outputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                        }
                                    }
                                    Uri.Builder builder = new Uri.Builder();
                                    builder.appendQueryParameter("data_list", a2);
                                    builder.appendQueryParameter(AsyncHttpClient.ENCODING_GZIP, "1");
                                    if (!TextUtils.isEmpty(a2)) {
                                        builder.appendQueryParameter(MultiDexExtractor.KEY_CRC, String.valueOf(a2.hashCode()));
                                    }
                                    String encodedQuery = builder.build().getEncodedQuery();
                                    httpURLConnection.setFixedLengthStreamingMode(encodedQuery.getBytes().length);
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setRequestMethod("POST");
                                    outputStream = httpURLConnection.getOutputStream();
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                                        try {
                                            bufferedOutputStream.write(encodedQuery.getBytes("UTF-8"));
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream.close();
                                            outputStream.close();
                                            int responseCode = httpURLConnection.getResponseCode();
                                            try {
                                                inputStream4 = httpURLConnection.getInputStream();
                                            } catch (FileNotFoundException unused16) {
                                                inputStream4 = httpURLConnection.getErrorStream();
                                            }
                                            try {
                                                byte[] f2 = f(inputStream4);
                                                inputStream4.close();
                                                String str7 = new String(f2, "UTF-8");
                                                if (responseCode == 200) {
                                                    k.b("SA.AnalyticsMessages", String.format("valid message: \n%s", e.a.q.b.b(str6)));
                                                } else {
                                                    k.b("SA.AnalyticsMessages", String.format("invalid message: \n%s", e.a.q.b.b(str6)));
                                                    k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "ret_code: %d", Integer.valueOf(responseCode)));
                                                    k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "ret_content: %s", str7));
                                                }
                                                if (responseCode >= 200 && responseCode < 300) {
                                                    boolean y7 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                    if (!TextUtils.isEmpty(null) && (y7 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                        k.b("SA.AnalyticsMessages", null);
                                                    }
                                                    d2 = this.f71655c.d(str5, DbAdapter.Table.EVENTS);
                                                    k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                                                } else {
                                                    throw new ResponseErrorException(String.format("flush failure with response '%s'", str7));
                                                    break;
                                                }
                                            } catch (ConnectErrorException e15) {
                                                e = e15;
                                                bufferedOutputStream5 = 0;
                                                inputStream3 = inputStream4;
                                                outputStream = null;
                                                str4 = "Connection error: " + e.getMessage();
                                                boolean y52 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(str4)) {
                                                    k.b("SA.AnalyticsMessages", str4);
                                                }
                                                if (bufferedOutputStream5 != 0) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream3 != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                            } catch (InvalidDataException e16) {
                                                e = e16;
                                                bufferedOutputStream4 = 0;
                                                inputStream2 = inputStream4;
                                                outputStream = null;
                                                str3 = "Invalid data: " + e.getMessage();
                                                boolean y222 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(str3)) {
                                                    k.b("SA.AnalyticsMessages", str3);
                                                }
                                                d2 = this.f71655c.d(str5, DbAdapter.Table.EVENTS);
                                                k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                                                if (bufferedOutputStream4 != 0) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream2 != null) {
                                                }
                                            } catch (ResponseErrorException e17) {
                                                e = e17;
                                                bufferedOutputStream = 0;
                                                inputStream = inputStream4;
                                                outputStream = null;
                                                str2 = "ResponseErrorException: " + e.getMessage();
                                                boolean y322 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(str2)) {
                                                    k.b("SA.AnalyticsMessages", str2);
                                                }
                                                d2 = this.f71655c.d(str5, DbAdapter.Table.EVENTS);
                                                k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                                                if (bufferedOutputStream != 0) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                            } catch (IOException e18) {
                                                e = e18;
                                                outputStream2 = null;
                                                inputStream5 = null;
                                                throw new ConnectErrorException(e);
                                                break;
                                                break;
                                            } catch (Exception e19) {
                                                e = e19;
                                                bufferedOutputStream2 = 0;
                                                inputStream = inputStream4;
                                                outputStream = null;
                                                str = "Exception: " + e.getMessage();
                                                boolean y622 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(str)) {
                                                    k.b("SA.AnalyticsMessages", str);
                                                }
                                                if (bufferedOutputStream2 != 0) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                bufferedOutputStream3 = 0;
                                                inputStream = inputStream4;
                                                z = true;
                                                outputStream = null;
                                                boolean y4222 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                                if (!TextUtils.isEmpty(null)) {
                                                }
                                                if (z) {
                                                }
                                                if (bufferedOutputStream3 != 0) {
                                                }
                                                if (outputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (ConnectErrorException e20) {
                                            e = e20;
                                            inputStream3 = null;
                                            bufferedOutputStream5 = bufferedOutputStream;
                                        } catch (InvalidDataException e21) {
                                            e = e21;
                                            inputStream2 = null;
                                            bufferedOutputStream4 = bufferedOutputStream;
                                        } catch (ResponseErrorException e22) {
                                            e = e22;
                                            inputStream = null;
                                            bufferedOutputStream = bufferedOutputStream;
                                        } catch (IOException e23) {
                                            e = e23;
                                            outputStream2 = outputStream;
                                            inputStream4 = null;
                                            inputStream5 = bufferedOutputStream;
                                        } catch (Exception e24) {
                                            e = e24;
                                            inputStream = null;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            inputStream = null;
                                            z = true;
                                            bufferedOutputStream3 = bufferedOutputStream;
                                            boolean y42222 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                            if (!TextUtils.isEmpty(null)) {
                                            }
                                            if (z) {
                                            }
                                            if (bufferedOutputStream3 != 0) {
                                            }
                                            if (outputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (ConnectErrorException e25) {
                                        e = e25;
                                        inputStream3 = null;
                                        bufferedOutputStream5 = 0;
                                    } catch (InvalidDataException e26) {
                                        e = e26;
                                        inputStream2 = null;
                                        bufferedOutputStream4 = 0;
                                    } catch (ResponseErrorException e27) {
                                        e = e27;
                                        inputStream = null;
                                        bufferedOutputStream = 0;
                                    } catch (IOException e28) {
                                        e = e28;
                                        inputStream5 = null;
                                        outputStream2 = outputStream;
                                        inputStream4 = null;
                                    } catch (Exception e29) {
                                        e = e29;
                                        inputStream = null;
                                        bufferedOutputStream2 = 0;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        inputStream = null;
                                        bufferedOutputStream = 0;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    inputStream = null;
                                    outputStream = null;
                                    bufferedOutputStream = outputStream;
                                    z = true;
                                    bufferedOutputStream3 = bufferedOutputStream;
                                    boolean y422222 = DxmSdkSensorsDataAPI.I(this.f71654b).y();
                                    if (!TextUtils.isEmpty(null)) {
                                    }
                                    if (z) {
                                    }
                                    if (bufferedOutputStream3 != 0) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    throw th;
                                }
                            } catch (IOException e30) {
                                e = e30;
                                outputStream2 = null;
                                httpURLConnection = null;
                                inputStream4 = null;
                            }
                        } catch (IOException e31) {
                            throw new InvalidDataException(e31);
                            break;
                        }
                    } catch (ConnectErrorException e32) {
                        e = e32;
                        inputStream3 = null;
                        httpURLConnection = null;
                        outputStream = null;
                    } catch (InvalidDataException e33) {
                        e = e33;
                        inputStream2 = null;
                        httpURLConnection = null;
                        outputStream = null;
                    } catch (ResponseErrorException e34) {
                        e = e34;
                        inputStream = null;
                        httpURLConnection = null;
                        outputStream = null;
                    } catch (Exception e35) {
                        e = e35;
                        inputStream = null;
                        httpURLConnection = null;
                        outputStream = null;
                    } catch (Throwable th8) {
                        th = th8;
                        inputStream = null;
                        httpURLConnection = null;
                        outputStream = null;
                    }
                }
            }
        }
    }
}
