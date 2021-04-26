package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.util.Properties;
/* loaded from: classes5.dex */
public class ah implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f30985a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b  reason: collision with root package name */
    public String f30986b;

    public ah() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    public static ah a() {
        return new ah();
    }

    private void b() {
        File externalFilesDir;
        Context a2 = com.bytedance.sdk.openadsdk.core.p.a();
        if (a2 == null) {
            return;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = a2.getExternalFilesDir("TTCache")) != null) {
                externalFilesDir.mkdirs();
                this.f30986b = externalFilesDir.getPath();
            }
            if (TextUtils.isEmpty(this.f30986b)) {
                File file = new File(a2.getFilesDir(), "TTCache");
                file.mkdirs();
                this.f30986b = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    private void c() {
        try {
            Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (a2 != null) {
                a2.invoke(null, com.bytedance.sdk.openadsdk.core.p.a());
            }
        } catch (Throwable unused) {
        }
        try {
            Method a3 = ai.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (a3 != null) {
                a3.invoke(null, com.bytedance.sdk.openadsdk.core.p.a());
            }
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.h.f.a();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b();
        } catch (Throwable unused4) {
        }
        try {
            String h2 = d.b.c.b.a.h(com.bytedance.sdk.openadsdk.core.p.a());
            if (!TextUtils.isEmpty(h2)) {
                File file = new File(h2);
                if (file.exists()) {
                    l.c(file);
                }
            }
        } catch (Throwable unused5) {
        }
        try {
            com.bytedance.sdk.openadsdk.downloadnew.a.g.e();
        } catch (Throwable unused6) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2 != null) {
                z = stringWriter2.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (z) {
            a(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f30985a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IF, IF, IF, NOP, INVOKE, IF, NOP] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00cc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0103 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0113 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Thread thread, Throwable th) {
        FileOutputStream fileOutputStream;
        int i2;
        boolean z;
        FileInputStream fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.f30986b)) {
                b();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        if (TextUtils.isEmpty(this.f30986b)) {
            return;
        }
        File file = new File(this.f30986b, "tt_crash_count.properties");
        boolean z2 = true;
        if (file.exists() && file.isFile() && file.canRead()) {
            ?? properties = new Properties();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                properties.load(fileInputStream2);
                String property = properties.getProperty("crash_count", "0");
                String property2 = properties.getProperty("crash_last_time", "0");
                int intValue = Integer.valueOf(property).intValue();
                long longValue = Long.valueOf(property2).longValue();
                int i3 = 0;
                if (System.currentTimeMillis() - longValue < 300000) {
                    i2 = intValue + 1;
                    z = false;
                } else {
                    i2 = 1;
                    z = true;
                }
                if (i2 < 3) {
                    z2 = false;
                }
                if (!z2) {
                    i3 = i2;
                }
                u.f("TTCrashHandler", "==" + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + z2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + z);
                if (z2) {
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                } else {
                    properties.setProperty("crash_count", String.valueOf(i3));
                    if (z) {
                        properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        properties.store(fileOutputStream, "tt_crash_info");
                        fileInputStream = fileOutputStream;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        u.c("TTCrashHandler", "crash count error", th);
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                        fileOutputStream.close();
                    }
                }
                if (z2) {
                    c();
                }
                fileOutputStream = fileInputStream;
                fileInputStream = fileInputStream2;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = fileInputStream;
            }
        } else {
            Properties properties2 = new Properties();
            properties2.setProperty("crash_count", String.valueOf(1));
            properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
            fileOutputStream = new FileOutputStream(file);
            try {
                properties2.store(fileOutputStream, "tt_crash_info");
                u.f("TTCrashHandler", "==first");
                fileOutputStream = fileOutputStream;
            } catch (Throwable th5) {
                th = th5;
                try {
                    u.c("TTCrashHandler", "crash count error", th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (fileOutputStream == null) {
                        return;
                    }
                    fileOutputStream.close();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
        }
        if (fileOutputStream == null) {
            return;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused5) {
        }
    }
}
