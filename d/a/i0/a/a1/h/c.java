package d.a.i0.a.a1.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
import d.a.i0.t.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class c extends HandlerThread {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f40548h = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f40549e;

    /* renamed from: f  reason: collision with root package name */
    public File f40550f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f40551g;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 100) {
                if (i2 == 200) {
                    if (c.this.f40549e != null) {
                        c.this.f40549e.countDown();
                    }
                    c.this.quit();
                    return;
                }
                return;
            }
            C0552c c0552c = (C0552c) message.obj;
            File file = new File(c.this.f40550f, c0552c.f40554a);
            d.k(file.getParentFile());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(c0552c.f40555b);
                fileOutputStream.close();
            } catch (Exception e2) {
                if (c.this.f40551g != null) {
                    c.this.f40551g.incrementAndGet();
                }
                d.a.i0.a.e0.d.i("FileOutputThread", "write file fail - " + file.getAbsolutePath(), e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 100) {
                if (i2 == 200) {
                    if (c.this.f40549e != null) {
                        c.this.f40549e.countDown();
                    }
                    c.this.quit();
                    return;
                }
                return;
            }
            C0552c c0552c = (C0552c) message.obj;
            File file = new File(c.this.f40550f, c0552c.f40554a);
            try {
                if (d.a.i0.a.a1.c.a()) {
                    c.this.i(c0552c, file);
                } else {
                    c.this.h(c0552c, file);
                }
            } catch (Exception e2) {
                if (c.this.f40551g != null) {
                    c.this.f40551g.incrementAndGet();
                }
                d.a.i0.a.e0.d.i("FileOutputThread", "write file fail - " + file.getAbsolutePath(), e2);
            }
        }
    }

    /* renamed from: d.a.i0.a.a1.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0552c {

        /* renamed from: a  reason: collision with root package name */
        public String f40554a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f40555b;
    }

    public c(String str, File file, CountDownLatch countDownLatch, AtomicInteger atomicInteger) {
        this(str, 0, file, countDownLatch, atomicInteger);
    }

    public Handler d() {
        return new b(getLooper());
    }

    public Handler e() {
        return new a(getLooper());
    }

    public boolean f(byte[] bArr, String str) throws IOException {
        boolean z = false;
        if (bArr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        File g2 = g(str);
        boolean z2 = g2 != null;
        if (!z2) {
            g2 = new File(this.f40550f, str);
        }
        if (!g2.exists()) {
            g2.getParentFile().mkdirs();
            if (!g2.createNewFile()) {
                d.a.i0.a.e0.d.h("FileOutputThread", " unzip error caused by create file error.");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(g2);
        fileOutputStream.write(bArr);
        d.d(fileOutputStream);
        if (z2) {
            File file = new File(this.f40550f, str);
            long currentTimeMillis = f40548h ? System.currentTimeMillis() : 0L;
            if (file.exists()) {
                if (file.length() == g2.length()) {
                    if (f40548h) {
                        Log.w("FileOutputThread", "target file already exist, no need to rename - " + file.getAbsolutePath());
                    }
                    d.K(g2);
                    return true;
                }
                if (f40548h) {
                    Log.w("FileOutputThread", "target file already exist, but size not same - " + file.getAbsolutePath());
                }
                d.K(file);
            }
            z = (g2.renameTo(file) || file.exists()) ? true : true;
            if (f40548h) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("FileOutputThread", "delete and rename file cost - " + (currentTimeMillis2 - currentTimeMillis));
            }
            if (!z) {
                d.K(g2);
                d.a.i0.a.e0.d.h("FileOutputThread", " rename to target fail - " + file.getAbsolutePath());
            }
            return z;
        }
        return true;
    }

    public File g(String str) {
        String str2 = str + "_" + System.nanoTime();
        String str3 = str2;
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(this.f40550f, str3);
            if (!file.exists()) {
                return file;
            }
            str3 = str2 + "_" + i2;
        }
        return null;
    }

    public void h(@NonNull C0552c c0552c, @NonNull File file) throws IOException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (!file.createNewFile()) {
                d.a.i0.a.e0.d.h("FileOutputThread", " unzip error caused by create file error.");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(c0552c.f40555b);
        d.d(fileOutputStream);
    }

    public void i(@NonNull C0552c c0552c, @NonNull File file) throws IOException {
        if (f(c0552c.f40555b, c0552c.f40554a)) {
            return;
        }
        AtomicInteger atomicInteger = this.f40551g;
        if (atomicInteger != null) {
            atomicInteger.incrementAndGet();
        }
        d.a.i0.a.e0.d.h("FileOutputThread", "write file fail - " + file.getAbsolutePath());
    }

    public c(String str, int i2, File file, CountDownLatch countDownLatch, AtomicInteger atomicInteger) {
        super(str, i2);
        this.f40550f = file;
        this.f40549e = countDownLatch;
        this.f40551g = atomicInteger;
    }
}
