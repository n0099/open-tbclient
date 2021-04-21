package d.b.h0.a.u0.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import d.b.h0.a.k;
import d.b.h0.p.d;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class c extends HandlerThread {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47347g = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f47348e;

    /* renamed from: f  reason: collision with root package name */
    public File f47349f;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 100) {
                if (i == 200) {
                    if (c.this.f47348e != null) {
                        c.this.f47348e.countDown();
                    }
                    c.this.quit();
                    return;
                }
                return;
            }
            b bVar = (b) message.obj;
            File file = new File(c.this.f47349f + bVar.f47351a);
            try {
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bVar.f47352b);
                d.a(fileOutputStream);
            } catch (Exception e2) {
                if (c.f47347g) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f47351a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f47352b;
    }

    public c(String str, File file, CountDownLatch countDownLatch) {
        this(str, 0, file, countDownLatch);
    }

    public Handler d() {
        return new a(getLooper());
    }

    public c(String str, int i, File file, CountDownLatch countDownLatch) {
        super(str, i);
        this.f47349f = file;
        this.f47348e = countDownLatch;
    }
}
