package d.b.g0.a.u0.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import d.b.g0.a.k;
import d.b.g0.p.d;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes3.dex */
public class c extends HandlerThread {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46625g = k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f46626e;

    /* renamed from: f  reason: collision with root package name */
    public File f46627f;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 100) {
                if (i == 200) {
                    if (c.this.f46626e != null) {
                        c.this.f46626e.countDown();
                    }
                    c.this.quit();
                    return;
                }
                return;
            }
            b bVar = (b) message.obj;
            File file = new File(c.this.f46627f + bVar.f46629a);
            try {
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bVar.f46630b);
                d.a(fileOutputStream);
            } catch (Exception e2) {
                if (c.f46625g) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f46629a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f46630b;
    }

    public c(String str, File file, CountDownLatch countDownLatch) {
        this(str, 0, file, countDownLatch);
    }

    public Handler d() {
        return new a(getLooper());
    }

    public c(String str, int i, File file, CountDownLatch countDownLatch) {
        super(str, i);
        this.f46627f = file;
        this.f46626e = countDownLatch;
    }
}
