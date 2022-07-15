package com.kwai.filedownloader.e;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final long b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1272752768, "Lcom/kwai/filedownloader/e/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1272752768, "Lcom/kwai/filedownloader/e/e$a;");
                    return;
                }
            }
            a = new e((byte) 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085 A[Catch: all -> 0x01e0, TryCatch #1 {all -> 0x01e0, blocks: (B:9:0x0037, B:10:0x003e, B:11:0x0042, B:12:0x0046, B:13:0x004a, B:14:0x004e, B:39:0x0081, B:41:0x0085, B:43:0x0089, B:44:0x0091), top: B:104:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091 A[Catch: all -> 0x01e0, TRY_LEAVE, TryCatch #1 {all -> 0x01e0, blocks: (B:9:0x0037, B:10:0x003e, B:11:0x0042, B:12:0x0046, B:13:0x004a, B:14:0x004e, B:39:0x0081, B:41:0x0085, B:43:0x0089, B:44:0x0091), top: B:104:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e() {
        InputStream inputStream;
        InputStream inputStream2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object obj;
        int i;
        Object obj2;
        long j;
        Object obj3;
        long j2;
        int i2;
        ?? r6;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (c.a() == null) {
            throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        Properties properties = new Properties();
        try {
            inputStream2 = c.a().getAssets().open("filedownloader.properties");
            if (inputStream2 != null) {
                try {
                    try {
                        properties.load(inputStream2);
                        str = properties.getProperty("http.lenient");
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.kwad.sdk.crash.utils.b.a(inputStream);
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    if (e instanceof FileNotFoundException) {
                    }
                    com.kwad.sdk.crash.utils.b.a(inputStream2);
                    str6 = str;
                    str7 = str5;
                    str8 = null;
                    if (str6 == null) {
                    }
                    this.d = true;
                    if (str2 != null) {
                    }
                    if (str3 != null) {
                    }
                    this.b = j2;
                    if (str4 != null) {
                    }
                    if (str7 == null) {
                    }
                    if (str8 == null) {
                    }
                    if (d.a) {
                    }
                }
                try {
                    str2 = properties.getProperty("download.min-progress-step");
                } catch (IOException e2) {
                    e = e2;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    if (e instanceof FileNotFoundException) {
                    }
                    com.kwad.sdk.crash.utils.b.a(inputStream2);
                    str6 = str;
                    str7 = str5;
                    str8 = null;
                    if (str6 == null) {
                    }
                    this.d = true;
                    if (str2 != null) {
                    }
                    if (str3 != null) {
                    }
                    this.b = j2;
                    if (str4 != null) {
                    }
                    if (str7 == null) {
                    }
                    if (str8 == null) {
                    }
                    if (d.a) {
                    }
                }
                try {
                    str3 = properties.getProperty("download.min-progress-time");
                    try {
                        str4 = properties.getProperty("download.max-network-thread-count");
                    } catch (IOException e3) {
                        e = e3;
                        str4 = null;
                        str5 = null;
                        if (e instanceof FileNotFoundException) {
                            e.printStackTrace();
                        } else if (d.a) {
                            d.c(e.class, "not found filedownloader.properties", new Object[0]);
                        }
                        com.kwad.sdk.crash.utils.b.a(inputStream2);
                        str6 = str;
                        str7 = str5;
                        str8 = null;
                        if (str6 == null) {
                        }
                        this.d = true;
                        if (str2 != null) {
                        }
                        if (str3 != null) {
                        }
                        this.b = j2;
                        if (str4 != null) {
                        }
                        if (str7 == null) {
                        }
                        if (str8 == null) {
                        }
                        if (d.a) {
                        }
                    }
                    try {
                        str5 = properties.getProperty("file.non-pre-allocation");
                    } catch (IOException e4) {
                        e = e4;
                        str5 = null;
                        if (e instanceof FileNotFoundException) {
                        }
                        com.kwad.sdk.crash.utils.b.a(inputStream2);
                        str6 = str;
                        str7 = str5;
                        str8 = null;
                        if (str6 == null) {
                        }
                        this.d = true;
                        if (str2 != null) {
                        }
                        if (str3 != null) {
                        }
                        this.b = j2;
                        if (str4 != null) {
                        }
                        if (str7 == null) {
                        }
                        if (str8 == null) {
                        }
                        if (d.a) {
                        }
                    }
                    try {
                        str8 = properties.getProperty("broadcast.completed");
                        str6 = str;
                    } catch (IOException e5) {
                        e = e5;
                        if (e instanceof FileNotFoundException) {
                        }
                        com.kwad.sdk.crash.utils.b.a(inputStream2);
                        str6 = str;
                        str7 = str5;
                        str8 = null;
                        if (str6 == null) {
                        }
                        this.d = true;
                        if (str2 != null) {
                        }
                        if (str3 != null) {
                        }
                        this.b = j2;
                        if (str4 != null) {
                        }
                        if (str7 == null) {
                        }
                        if (str8 == null) {
                        }
                        if (d.a) {
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    if (e instanceof FileNotFoundException) {
                    }
                    com.kwad.sdk.crash.utils.b.a(inputStream2);
                    str6 = str;
                    str7 = str5;
                    str8 = null;
                    if (str6 == null) {
                    }
                    this.d = true;
                    if (str2 != null) {
                    }
                    if (str3 != null) {
                    }
                    this.b = j2;
                    if (str4 != null) {
                    }
                    if (str7 == null) {
                    }
                    if (str8 == null) {
                    }
                    if (d.a) {
                    }
                }
            } else {
                str8 = null;
                str6 = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            com.kwad.sdk.crash.utils.b.a(inputStream2);
            str7 = str5;
        } catch (IOException e7) {
            e = e7;
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        if (str6 == null) {
            obj = "download.max-network-thread-count";
            i = 0;
            this.c = false;
        } else if (!str6.equals("true") && !str6.equals("false")) {
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", "http.lenient", "true", "false"));
        } else {
            obj = "download.max-network-thread-count";
            i = 0;
            this.c = str6.equals("true");
        }
        this.d = true;
        if (str2 != null) {
            this.a = Math.max(i, Integer.valueOf(str2).intValue());
        } else {
            this.a = 65536;
        }
        if (str3 != null) {
            obj2 = "download.min-progress-time";
            j = currentTimeMillis;
            obj3 = "http.lenient";
            j2 = Math.max(0L, Long.valueOf(str3).longValue());
        } else {
            obj2 = "download.min-progress-time";
            j = currentTimeMillis;
            obj3 = "http.lenient";
            j2 = 2000;
        }
        this.b = j2;
        if (str4 != null) {
            this.e = a(Integer.valueOf(str4).intValue());
            i2 = 3;
        } else {
            i2 = 3;
            this.e = 3;
        }
        if (str7 == null) {
            r6 = 0;
            this.f = false;
        } else if (!str7.equals("true") && !str7.equals("false")) {
            Object[] objArr = new Object[i2];
            objArr[0] = "file.non-pre-allocation";
            objArr[1] = "true";
            objArr[2] = "false";
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", objArr));
        } else {
            r6 = 0;
            this.f = str7.equals("true");
        }
        if (str8 == null) {
            this.g = r6;
        } else if (!str8.equals("true") && !str8.equals("false")) {
            Object[] objArr2 = new Object[3];
            objArr2[r6] = "broadcast.completed";
            objArr2[1] = "true";
            objArr2[2] = "false";
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", objArr2));
        } else {
            this.g = str8.equals("true");
        }
        if (d.a) {
            Object[] objArr3 = new Object[11];
            objArr3[r6] = Long.valueOf(System.currentTimeMillis() - j);
            objArr3[1] = obj3;
            objArr3[2] = Boolean.valueOf(this.c);
            objArr3[3] = "process.non-separate";
            objArr3[4] = Boolean.valueOf(this.d);
            objArr3[5] = "download.min-progress-step";
            objArr3[6] = Integer.valueOf(this.a);
            objArr3[7] = obj2;
            objArr3[8] = Long.valueOf(this.b);
            objArr3[9] = obj;
            objArr3[10] = Integer.valueOf(this.e);
            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr3);
        }
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i > 12) {
                d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
                return 12;
            } else if (i <= 0) {
                d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
                return 1;
            } else {
                return i;
            }
        }
        return invokeI.intValue;
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (e) invokeV.objValue;
    }
}
