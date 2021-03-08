package com.kwai.filedownloader.f;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f7213a;
    public final long b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f7214a = new e();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private e() {
        String str;
        if (c.a() == null) {
            throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            try {
                inputStream = c.a().getAssets().open("filedownloader.properties");
                if (inputStream != null) {
                    properties.load(inputStream);
                    str2 = properties.getProperty("http.lenient");
                    str3 = properties.getProperty("download.min-progress-step");
                    str4 = properties.getProperty("download.min-progress-time");
                    str5 = properties.getProperty("download.max-network-thread-count");
                    str6 = properties.getProperty("file.non-pre-allocation");
                    str = properties.getProperty("broadcast.completed");
                } else {
                    str = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                if (!(e2 instanceof FileNotFoundException)) {
                    e2.printStackTrace();
                } else if (d.f7212a) {
                    d.c(e.class, "not found filedownloader.properties", new Object[0]);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = null;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        str = null;
                    }
                } else {
                    str = null;
                }
            }
            if (str2 == null) {
                this.c = false;
            } else if (!str2.equals("true") && !str2.equals("false")) {
                throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", "http.lenient", "true", "false"));
            } else {
                this.c = str2.equals("true");
            }
            if ("true" == 0) {
                this.d = false;
            } else if (!"true".equals("true") && !"true".equals("false")) {
                throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", "process.non-separate", "true", "false"));
            } else {
                this.d = "true".equals("true");
            }
            if (str3 != null) {
                this.f7213a = Math.max(0, Integer.valueOf(str3).intValue());
            } else {
                this.f7213a = 65536;
            }
            if (str4 != null) {
                this.b = Math.max(0L, Long.valueOf(str4).longValue());
            } else {
                this.b = 2000L;
            }
            if (str5 != null) {
                this.e = a(Integer.valueOf(str5).intValue());
            } else {
                this.e = 3;
            }
            if (str6 == null) {
                this.f = false;
            } else if (!str6.equals("true") && !str6.equals("false")) {
                throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", "file.non-pre-allocation", "true", "false"));
            } else {
                this.f = str6.equals("true");
            }
            if (str == null) {
                this.g = false;
            } else if (!str.equals("true") && !str.equals("false")) {
                throw new IllegalStateException(f.a("the value of '%s' must be '%s' or '%s'", "broadcast.completed", "true", "false"));
            } else {
                this.g = str.equals("true");
            }
            if (d.f7212a) {
                d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "http.lenient", Boolean.valueOf(this.c), "process.non-separate", Boolean.valueOf(this.d), "download.min-progress-step", Integer.valueOf(this.f7213a), "download.min-progress-time", Long.valueOf(this.b), "download.max-network-thread-count", Integer.valueOf(this.e));
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
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
        return a.f7214a;
    }
}
