package d.a.h0.a.u0.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import d.a.h0.a.k;
import d.a.h0.p.d;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class c extends HandlerThread {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44760g = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f44761e;

    /* renamed from: f  reason: collision with root package name */
    public File f44762f;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 100) {
                if (i2 == 200) {
                    if (c.this.f44761e != null) {
                        c.this.f44761e.countDown();
                    }
                    c.this.quit();
                    return;
                }
                return;
            }
            b bVar = (b) message.obj;
            File file = new File(c.this.f44762f + bVar.f44764a);
            try {
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bVar.f44765b);
                d.a(fileOutputStream);
            } catch (Exception e2) {
                if (c.f44760g) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f44764a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f44765b;
    }

    public c(String str, File file, CountDownLatch countDownLatch) {
        this(str, 0, file, countDownLatch);
    }

    public Handler d() {
        return new a(getLooper());
    }

    public c(String str, int i2, File file, CountDownLatch countDownLatch) {
        super(str, i2);
        this.f44762f = file;
        this.f44761e = countDownLatch;
    }
}
