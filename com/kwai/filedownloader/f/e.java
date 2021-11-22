package com.kwai.filedownloader.f;

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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f67887a;

    /* renamed from: b  reason: collision with root package name */
    public final long f67888b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f67889c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67890d;

    /* renamed from: e  reason: collision with root package name */
    public final int f67891e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f67892f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f67893g;

    /* renamed from: com.kwai.filedownloader.f.e$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f67894a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1244123617, "Lcom/kwai/filedownloader/f/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1244123617, "Lcom/kwai/filedownloader/f/e$a;");
                    return;
                }
            }
            f67894a = new e(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0091 A[Catch: all -> 0x01f5, TryCatch #3 {all -> 0x01f5, blocks: (B:9:0x0037, B:10:0x003e, B:11:0x0042, B:12:0x0046, B:13:0x004a, B:14:0x004e, B:44:0x008d, B:46:0x0091, B:48:0x0095, B:49:0x009d), top: B:122:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d A[Catch: all -> 0x01f5, TRY_LEAVE, TryCatch #3 {all -> 0x01f5, blocks: (B:9:0x0037, B:10:0x003e, B:11:0x0042, B:12:0x0046, B:13:0x004a, B:14:0x004e, B:44:0x008d, B:46:0x0091, B:48:0x0095, B:49:0x009d), top: B:122:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0196  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e() {
        Throwable th;
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
        int i2;
        Object obj2;
        long j;
        Object obj3;
        long j2;
        int i3;
        ?? r6;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    if (e instanceof FileNotFoundException) {
                    }
                    if (inputStream2 != null) {
                    }
                    str6 = str;
                    str7 = str5;
                    str8 = null;
                    if (str6 == null) {
                    }
                    this.f67890d = true;
                    if (str2 != null) {
                    }
                    if (str3 != null) {
                    }
                    this.f67888b = j2;
                    if (str4 != null) {
                    }
                    if (str7 == null) {
                    }
                    if (str8 == null) {
                    }
                    if (d.f67886a) {
                    }
                }
                try {
                    str2 = properties.getProperty("download.min-progress-step");
                } catch (IOException e4) {
                    e = e4;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    if (e instanceof FileNotFoundException) {
                    }
                    if (inputStream2 != null) {
                    }
                    str6 = str;
                    str7 = str5;
                    str8 = null;
                    if (str6 == null) {
                    }
                    this.f67890d = true;
                    if (str2 != null) {
                    }
                    if (str3 != null) {
                    }
                    this.f67888b = j2;
                    if (str4 != null) {
                    }
                    if (str7 == null) {
                    }
                    if (str8 == null) {
                    }
                    if (d.f67886a) {
                    }
                }
                try {
                    str3 = properties.getProperty("download.min-progress-time");
                } catch (IOException e5) {
                    e = e5;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    if (e instanceof FileNotFoundException) {
                    }
                    if (inputStream2 != null) {
                    }
                    str6 = str;
                    str7 = str5;
                    str8 = null;
                    if (str6 == null) {
                    }
                    this.f67890d = true;
                    if (str2 != null) {
                    }
                    if (str3 != null) {
                    }
                    this.f67888b = j2;
                    if (str4 != null) {
                    }
                    if (str7 == null) {
                    }
                    if (str8 == null) {
                    }
                    if (d.f67886a) {
                    }
                }
                try {
                    str4 = properties.getProperty("download.max-network-thread-count");
                    try {
                        str5 = properties.getProperty("file.non-pre-allocation");
                    } catch (IOException e6) {
                        e = e6;
                        str5 = null;
                        if (e instanceof FileNotFoundException) {
                            e.printStackTrace();
                        } else if (d.f67886a) {
                            d.c(e.class, "not found filedownloader.properties", new Object[0]);
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        str6 = str;
                        str7 = str5;
                        str8 = null;
                        if (str6 == null) {
                        }
                        this.f67890d = true;
                        if (str2 != null) {
                        }
                        if (str3 != null) {
                        }
                        this.f67888b = j2;
                        if (str4 != null) {
                        }
                        if (str7 == null) {
                        }
                        if (str8 == null) {
                        }
                        if (d.f67886a) {
                        }
                    }
                    try {
                        str6 = str;
                        str8 = properties.getProperty("broadcast.completed");
                    } catch (IOException e8) {
                        e = e8;
                        if (e instanceof FileNotFoundException) {
                        }
                        if (inputStream2 != null) {
                        }
                        str6 = str;
                        str7 = str5;
                        str8 = null;
                        if (str6 == null) {
                        }
                        this.f67890d = true;
                        if (str2 != null) {
                        }
                        if (str3 != null) {
                        }
                        this.f67888b = j2;
                        if (str4 != null) {
                        }
                        if (str7 == null) {
                        }
                        if (str8 == null) {
                        }
                        if (d.f67886a) {
                        }
                    }
                } catch (IOException e9) {
                    e = e9;
                    str4 = null;
                    str5 = null;
                    if (e instanceof FileNotFoundException) {
                    }
                    if (inputStream2 != null) {
                    }
                    str6 = str;
                    str7 = str5;
                    str8 = null;
                    if (str6 == null) {
                    }
                    this.f67890d = true;
                    if (str2 != null) {
                    }
                    if (str3 != null) {
                    }
                    this.f67888b = j2;
                    if (str4 != null) {
                    }
                    if (str7 == null) {
                    }
                    if (str8 == null) {
                    }
                    if (d.f67886a) {
                    }
                }
            } else {
                str6 = null;
                str8 = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            str7 = str5;
        } catch (IOException e11) {
            e = e11;
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        if (str6 == null) {
            obj = "download.max-network-thread-count";
            i2 = 0;
            this.f67889c = false;
        } else if (!str6.equals("true") && !str6.equals("false")) {
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", "http.lenient", "true", "false"));
        } else {
            obj = "download.max-network-thread-count";
            i2 = 0;
            this.f67889c = str6.equals("true");
        }
        this.f67890d = true;
        if (str2 != null) {
            this.f67887a = Math.max(i2, Integer.valueOf(str2).intValue());
        } else {
            this.f67887a = 65536;
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
        this.f67888b = j2;
        if (str4 != null) {
            this.f67891e = a(Integer.valueOf(str4).intValue());
            i3 = 3;
        } else {
            i3 = 3;
            this.f67891e = 3;
        }
        if (str7 == null) {
            r6 = 0;
            this.f67892f = false;
        } else if (!str7.equals("true") && !str7.equals("false")) {
            Object[] objArr = new Object[i3];
            objArr[0] = "file.non-pre-allocation";
            objArr[1] = "true";
            objArr[2] = "false";
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", objArr));
        } else {
            r6 = 0;
            this.f67892f = str7.equals("true");
        }
        if (str8 == null) {
            this.f67893g = r6;
        } else if (!str8.equals("true") && !str8.equals("false")) {
            Object[] objArr2 = new Object[3];
            objArr2[r6] = "broadcast.completed";
            objArr2[1] = "true";
            objArr2[2] = "false";
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", objArr2));
        } else {
            this.f67893g = str8.equals("true");
        }
        if (d.f67886a) {
            Object[] objArr3 = new Object[11];
            objArr3[r6] = Long.valueOf(System.currentTimeMillis() - j);
            objArr3[1] = obj3;
            objArr3[2] = Boolean.valueOf(this.f67889c);
            objArr3[3] = "process.non-separate";
            objArr3[4] = Boolean.valueOf(this.f67890d);
            objArr3[5] = "download.min-progress-step";
            objArr3[6] = Integer.valueOf(this.f67887a);
            objArr3[7] = obj2;
            objArr3[8] = Long.valueOf(this.f67888b);
            objArr3[9] = obj;
            objArr3[10] = Integer.valueOf(this.f67891e);
            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr3);
        }
    }

    public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 > 12) {
                d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 12, 12);
                return 12;
            } else if (i2 < 1) {
                d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 1, 1);
                return 1;
            } else {
                return i2;
            }
        }
        return invokeI.intValue;
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f67894a : (e) invokeV.objValue;
    }
}
