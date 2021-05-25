package e.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.multidex.MultiDexExtractor;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
/* loaded from: classes7.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<Context, a> f68236d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final C1911a f68237a = new C1911a();

    /* renamed from: b  reason: collision with root package name */
    public final Context f68238b;

    /* renamed from: c  reason: collision with root package name */
    public final DbAdapter f68239c;

    /* renamed from: e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1911a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f68240a = new Object();

        /* renamed from: b  reason: collision with root package name */
        public Handler f68241b;

        /* renamed from: e.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class HandlerC1912a extends Handler {
            public HandlerC1912a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    if (message.what == 3) {
                        a.this.e();
                    } else {
                        k.b("SA.AnalyticsMessages", "Unexpected message received by SensorsData worker: " + message);
                    }
                } catch (RuntimeException e2) {
                    k.c("SA.AnalyticsMessages", "Worker threw an unhandled exception", e2);
                }
            }
        }

        public C1911a() {
            HandlerThread handlerThread = new HandlerThread("com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.f68241b = new HandlerC1912a(handlerThread.getLooper());
        }

        public void a(Message message) {
            synchronized (this.f68240a) {
                if (this.f68241b == null) {
                    k.b("SA.AnalyticsMessages", "Dead worker dropping a message: " + message.what);
                } else {
                    this.f68241b.sendMessage(message);
                }
            }
        }

        public void b(Message message, long j) {
            synchronized (this.f68240a) {
                if (this.f68241b == null) {
                    k.b("SA.AnalyticsMessages", "Dead worker dropping a message: " + message.what);
                } else if (!this.f68241b.hasMessages(message.what)) {
                    this.f68241b.sendMessageDelayed(message, j);
                }
            }
        }
    }

    public a(Context context, String str) {
        this.f68238b = context;
        this.f68239c = new DbAdapter(this.f68238b, str);
    }

    public static a d(Context context, String str) {
        a aVar;
        synchronized (f68236d) {
            Context applicationContext = context.getApplicationContext();
            if (!f68236d.containsKey(applicationContext)) {
                aVar = new a(applicationContext, str);
                f68236d.put(applicationContext, aVar);
            } else {
                aVar = f68236d.get(applicationContext);
            }
        }
        return aVar;
    }

    public static byte[] f(InputStream inputStream) throws IOException {
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
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.getBytes().length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return new String(e.a.q.a.a(byteArray));
    }

    public void b(String str, JSONObject jSONObject) {
        try {
            synchronized (this.f68239c) {
                int c2 = this.f68239c.c(jSONObject, DbAdapter.Table.EVENTS);
                if (c2 < 0) {
                    String str2 = "Failed to enqueue the event: " + jSONObject;
                    if (!DxmSdkSensorsDataAPI.I(this.f68238b).y()) {
                        k.b("SA.AnalyticsMessages", str2);
                    } else {
                        throw new DebugModeException(str2);
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = 3;
                if (!DxmSdkSensorsDataAPI.I(this.f68238b).y() && c2 != -2) {
                    if (!str.equals("track_signup") && c2 <= DxmSdkSensorsDataAPI.I(this.f68238b).s()) {
                        this.f68237a.b(obtain, DxmSdkSensorsDataAPI.I(this.f68238b).t());
                    }
                    this.f68237a.a(obtain);
                }
                this.f68237a.a(obtain);
            }
        } catch (Exception e2) {
            k.b("SA.AnalyticsMessages", "enqueueEventMessage error:" + e2);
        }
    }

    public void c() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.f68237a.a(obtain);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:217:0x03be */
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
    /* JADX WARN: Code restructure failed: missing block: B:192:0x034d, code lost:
        if (r6 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03b6, code lost:
        if (r6 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x03b8, code lost:
        r6.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03bb, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01bc, code lost:
        if (r6 != null) goto L69;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x030c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0375 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0420 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0405 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0341 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x033a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x02d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0450 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x02cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0348 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x045e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x02db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0457 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x02e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x02e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0033 A[SYNTHETIC] */
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
        String encodedQuery;
        try {
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (!TextUtils.isEmpty(DxmSdkSensorsDataAPI.I(this.f68238b).w()) && SensorsDataUtils.f(this.f68238b)) {
            if (!DxmSdkSensorsDataAPI.I(this.f68238b).B(SensorsDataUtils.i(this.f68238b))) {
                return;
            }
            int i2 = 100;
            while (i2 > 0) {
                synchronized (this.f68239c) {
                    if (DxmSdkSensorsDataAPI.I(this.f68238b).y()) {
                        e2 = this.f68239c.e(DbAdapter.Table.EVENTS, 1);
                    } else {
                        e2 = this.f68239c.e(DbAdapter.Table.EVENTS, 50);
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
                            httpURLConnection = (HttpURLConnection) new URL(DxmSdkSensorsDataAPI.I(this.f68238b).w()).openConnection();
                            try {
                                try {
                                    String e4 = SensorsDataUtils.e(this.f68238b);
                                    if (TextUtils.isEmpty(e4)) {
                                        e4 = "SensorsAnalytics Android SDK";
                                    }
                                    httpURLConnection.addRequestProperty("User-Agent", e4);
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                                if (DxmSdkSensorsDataAPI.I(this.f68238b).y()) {
                                    try {
                                        if (!DxmSdkSensorsDataAPI.I(this.f68238b).z()) {
                                            httpURLConnection.addRequestProperty("Dry-Run", "true");
                                        }
                                    } catch (ConnectErrorException e6) {
                                        e = e6;
                                        inputStream3 = null;
                                        outputStream = null;
                                        bufferedOutputStream5 = outputStream;
                                        str4 = "Connection error: " + e.getMessage();
                                        boolean y = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                                    } catch (InvalidDataException e7) {
                                        e = e7;
                                        inputStream2 = null;
                                        outputStream = null;
                                        bufferedOutputStream4 = outputStream;
                                        str3 = "Invalid data: " + e.getMessage();
                                        boolean y2 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
                                        if (!TextUtils.isEmpty(str3)) {
                                            k.b("SA.AnalyticsMessages", str3);
                                        }
                                        d2 = this.f68239c.d(str5, DbAdapter.Table.EVENTS);
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
                                            boolean y3 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
                                            if (!TextUtils.isEmpty(str2)) {
                                                k.b("SA.AnalyticsMessages", str2);
                                            }
                                            d2 = this.f68239c.d(str5, DbAdapter.Table.EVENTS);
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
                                            boolean y4 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
                                            if (!TextUtils.isEmpty(null) && (y4 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                k.b("SA.AnalyticsMessages", null);
                                            }
                                            if (z) {
                                                k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(this.f68239c.d(str5, DbAdapter.Table.EVENTS))));
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
                                            boolean y5 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                                            boolean y22 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
                                            if (!TextUtils.isEmpty(str3) && (y22 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                k.b("SA.AnalyticsMessages", str3);
                                            }
                                            d2 = this.f68239c.d(str5, DbAdapter.Table.EVENTS);
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
                                            boolean y32 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
                                            if (!TextUtils.isEmpty(str2) && (y32 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                                k.b("SA.AnalyticsMessages", str2);
                                            }
                                            d2 = this.f68239c.d(str5, DbAdapter.Table.EVENTS);
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
                                                boolean y6 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                                                boolean y42 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                                            boolean y422 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                                        boolean y62 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                                    }
                                }
                                Uri.Builder builder = new Uri.Builder();
                                builder.appendQueryParameter("data_list", a2);
                                builder.appendQueryParameter(AsyncHttpClient.ENCODING_GZIP, "1");
                                if (!TextUtils.isEmpty(a2)) {
                                    builder.appendQueryParameter(MultiDexExtractor.KEY_CRC, String.valueOf(a2.hashCode()));
                                }
                                encodedQuery = builder.build().getEncodedQuery();
                                httpURLConnection.setFixedLengthStreamingMode(encodedQuery.getBytes().length);
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setRequestMethod("POST");
                                outputStream = httpURLConnection.getOutputStream();
                                try {
                                    bufferedOutputStream = new BufferedOutputStream(outputStream);
                                } catch (ConnectErrorException e15) {
                                    e = e15;
                                    inputStream3 = null;
                                    bufferedOutputStream5 = 0;
                                } catch (InvalidDataException e16) {
                                    e = e16;
                                    inputStream2 = null;
                                    bufferedOutputStream4 = 0;
                                } catch (ResponseErrorException e17) {
                                    e = e17;
                                    inputStream = null;
                                    bufferedOutputStream = 0;
                                } catch (IOException e18) {
                                    e = e18;
                                    inputStream5 = null;
                                    outputStream2 = outputStream;
                                    inputStream4 = null;
                                } catch (Exception e19) {
                                    e = e19;
                                    inputStream = null;
                                    bufferedOutputStream2 = 0;
                                } catch (Throwable th4) {
                                    th = th4;
                                    inputStream = null;
                                    bufferedOutputStream = 0;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                inputStream = null;
                                outputStream = null;
                                bufferedOutputStream = outputStream;
                                z = true;
                                bufferedOutputStream3 = bufferedOutputStream;
                                boolean y4222 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                        } catch (IOException e20) {
                            e = e20;
                            outputStream2 = null;
                            httpURLConnection = null;
                            inputStream4 = null;
                        }
                    } catch (IOException e21) {
                        throw new InvalidDataException(e21);
                        break;
                    }
                } catch (ConnectErrorException e22) {
                    e = e22;
                    inputStream3 = null;
                    httpURLConnection = null;
                    outputStream = null;
                } catch (InvalidDataException e23) {
                    e = e23;
                    inputStream2 = null;
                    httpURLConnection = null;
                    outputStream = null;
                } catch (ResponseErrorException e24) {
                    e = e24;
                    inputStream = null;
                    httpURLConnection = null;
                    outputStream = null;
                } catch (Exception e25) {
                    e = e25;
                    inputStream = null;
                    httpURLConnection = null;
                    outputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                    httpURLConnection = null;
                    outputStream = null;
                }
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
                            boolean y7 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
                            if (!TextUtils.isEmpty(null) && (y7 || DxmSdkSensorsDataAPI.r.booleanValue())) {
                                k.b("SA.AnalyticsMessages", null);
                            }
                            d2 = this.f68239c.d(str5, DbAdapter.Table.EVENTS);
                            k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                        } else {
                            throw new ResponseErrorException(String.format("flush failure with response '%s'", str7));
                            break;
                        }
                    } catch (ConnectErrorException e26) {
                        e = e26;
                        bufferedOutputStream5 = 0;
                        inputStream3 = inputStream4;
                        outputStream = null;
                        str4 = "Connection error: " + e.getMessage();
                        boolean y52 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                    } catch (InvalidDataException e27) {
                        e = e27;
                        bufferedOutputStream4 = 0;
                        inputStream2 = inputStream4;
                        outputStream = null;
                        str3 = "Invalid data: " + e.getMessage();
                        boolean y222 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        d2 = this.f68239c.d(str5, DbAdapter.Table.EVENTS);
                        k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                        if (bufferedOutputStream4 != 0) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream2 != null) {
                        }
                    } catch (ResponseErrorException e28) {
                        e = e28;
                        bufferedOutputStream = 0;
                        inputStream = inputStream4;
                        outputStream = null;
                        str2 = "ResponseErrorException: " + e.getMessage();
                        boolean y322 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        d2 = this.f68239c.d(str5, DbAdapter.Table.EVENTS);
                        k.b("SA.AnalyticsMessages", String.format(Locale.CHINA, "Events flushed. [left = %d]", Integer.valueOf(d2)));
                        if (bufferedOutputStream != 0) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (IOException e29) {
                        e = e29;
                        outputStream2 = null;
                        inputStream5 = null;
                        throw new ConnectErrorException(e);
                        break;
                        break;
                    } catch (Exception e30) {
                        e = e30;
                        bufferedOutputStream2 = 0;
                        inputStream = inputStream4;
                        outputStream = null;
                        str = "Exception: " + e.getMessage();
                        boolean y622 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedOutputStream3 = 0;
                        inputStream = inputStream4;
                        z = true;
                        outputStream = null;
                        boolean y42222 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
                } catch (ConnectErrorException e31) {
                    e = e31;
                    inputStream3 = null;
                    bufferedOutputStream5 = bufferedOutputStream;
                } catch (InvalidDataException e32) {
                    e = e32;
                    inputStream2 = null;
                    bufferedOutputStream4 = bufferedOutputStream;
                } catch (ResponseErrorException e33) {
                    e = e33;
                    inputStream = null;
                    bufferedOutputStream = bufferedOutputStream;
                } catch (IOException e34) {
                    e = e34;
                    outputStream2 = outputStream;
                    inputStream4 = null;
                    inputStream5 = bufferedOutputStream;
                } catch (Exception e35) {
                    e = e35;
                    inputStream = null;
                    bufferedOutputStream2 = bufferedOutputStream;
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = null;
                    z = true;
                    bufferedOutputStream3 = bufferedOutputStream;
                    boolean y422222 = DxmSdkSensorsDataAPI.I(this.f68238b).y();
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
            }
        }
    }
}
