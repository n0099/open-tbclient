package com.kwai.filedownloader.f;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f37302a;

    /* renamed from: b  reason: collision with root package name */
    public final long f37303b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f37304c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f37305d;

    /* renamed from: e  reason: collision with root package name */
    public final int f37306e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37307f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37308g;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f37309a = new e();
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0087 A[Catch: all -> 0x01df, TryCatch #11 {all -> 0x01df, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:42:0x0083, B:44:0x0087, B:46:0x008b, B:47:0x0093), top: B:122:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093 A[Catch: all -> 0x01df, TRY_LEAVE, TryCatch #11 {all -> 0x01df, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:42:0x0083, B:44:0x0087, B:46:0x008b, B:47:0x0093), top: B:122:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0188  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [boolean] */
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
        int i;
        Object obj2;
        long j;
        Object obj3;
        long j2;
        int i2;
        ?? r4;
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
                        try {
                            str2 = properties.getProperty("download.min-progress-step");
                        } catch (IOException e2) {
                            e = e2;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            if (e instanceof FileNotFoundException) {
                                e.printStackTrace();
                            } else if (d.f37301a) {
                                d.c(e.class, "not found filedownloader.properties", new Object[0]);
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            str6 = str;
                            str7 = str5;
                            str8 = null;
                            if (str6 == null) {
                            }
                            this.f37305d = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            this.f37303b = j2;
                            if (str4 != null) {
                            }
                            if (str7 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (d.f37301a) {
                            }
                        }
                        try {
                            str3 = properties.getProperty("download.min-progress-time");
                        } catch (IOException e4) {
                            e = e4;
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
                            this.f37305d = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            this.f37303b = j2;
                            if (str4 != null) {
                            }
                            if (str7 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (d.f37301a) {
                            }
                        }
                        try {
                            str4 = properties.getProperty("download.max-network-thread-count");
                        } catch (IOException e5) {
                            e = e5;
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
                            this.f37305d = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            this.f37303b = j2;
                            if (str4 != null) {
                            }
                            if (str7 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (d.f37301a) {
                            }
                        }
                        try {
                            str5 = properties.getProperty("file.non-pre-allocation");
                        } catch (IOException e6) {
                            e = e6;
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
                            this.f37305d = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            this.f37303b = j2;
                            if (str4 != null) {
                            }
                            if (str7 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (d.f37301a) {
                            }
                        }
                        try {
                            str6 = str;
                            str8 = properties.getProperty("broadcast.completed");
                        } catch (IOException e7) {
                            e = e7;
                            if (e instanceof FileNotFoundException) {
                            }
                            if (inputStream2 != null) {
                            }
                            str6 = str;
                            str7 = str5;
                            str8 = null;
                            if (str6 == null) {
                            }
                            this.f37305d = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            this.f37303b = j2;
                            if (str4 != null) {
                            }
                            if (str7 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (d.f37301a) {
                            }
                        }
                    } catch (IOException e8) {
                        e = e8;
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
                        this.f37305d = true;
                        if (str2 != null) {
                        }
                        if (str3 != null) {
                        }
                        this.f37303b = j2;
                        if (str4 != null) {
                        }
                        if (str7 == null) {
                        }
                        if (str8 == null) {
                        }
                        if (d.f37301a) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th;
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
            i = 0;
            this.f37304c = false;
        } else if (!str6.equals("true") && !str6.equals("false")) {
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", "http.lenient", "true", "false"));
        } else {
            obj = "download.max-network-thread-count";
            i = 0;
            this.f37304c = str6.equals("true");
        }
        this.f37305d = true;
        if (str2 != null) {
            this.f37302a = Math.max(i, Integer.valueOf(str2).intValue());
        } else {
            this.f37302a = 65536;
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
        this.f37303b = j2;
        if (str4 != null) {
            this.f37306e = a(Integer.valueOf(str4).intValue());
            i2 = 3;
        } else {
            i2 = 3;
            this.f37306e = 3;
        }
        if (str7 == null) {
            r4 = 0;
            this.f37307f = false;
        } else if (!str7.equals("true") && !str7.equals("false")) {
            Object[] objArr = new Object[i2];
            objArr[0] = "file.non-pre-allocation";
            objArr[1] = "true";
            objArr[2] = "false";
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", objArr));
        } else {
            r4 = 0;
            this.f37307f = str7.equals("true");
        }
        if (str8 == null) {
            this.f37308g = r4;
        } else if (!str8.equals("true") && !str8.equals("false")) {
            Object[] objArr2 = new Object[3];
            objArr2[r4] = "broadcast.completed";
            objArr2[1] = "true";
            objArr2[2] = "false";
            throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", objArr2));
        } else {
            this.f37308g = str8.equals("true");
        }
        if (d.f37301a) {
            Object[] objArr3 = new Object[11];
            objArr3[r4] = Long.valueOf(System.currentTimeMillis() - j);
            objArr3[1] = obj3;
            objArr3[2] = Boolean.valueOf(this.f37304c);
            objArr3[3] = "process.non-separate";
            objArr3[4] = Boolean.valueOf(this.f37305d);
            objArr3[5] = "download.min-progress-step";
            objArr3[6] = Integer.valueOf(this.f37302a);
            objArr3[7] = obj2;
            objArr3[8] = Long.valueOf(this.f37303b);
            objArr3[9] = obj;
            objArr3[10] = Integer.valueOf(this.f37306e);
            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr3);
        }
    }

    public static int a(int i) {
        if (i > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        } else if (i < 1) {
            d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
            return 1;
        } else {
            return i;
        }
    }

    public static e a() {
        return a.f37309a;
    }
}
