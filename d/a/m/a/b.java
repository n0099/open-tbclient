package d.a.m.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.baidu.crabsdk.sender.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
@TargetApi(16)
/* loaded from: classes.dex */
public final class b implements Choreographer.FrameCallback {
    public static final b j = new b();

    /* renamed from: e  reason: collision with root package name */
    public boolean f63295e = false;

    /* renamed from: f  reason: collision with root package name */
    public long f63296f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f63297g = 41666666;

    /* renamed from: h  reason: collision with root package name */
    public long f63298h = 16666665;

    /* renamed from: i  reason: collision with root package name */
    public int f63299i = 0;

    public static /* synthetic */ void a(b bVar) {
        Context context;
        Map<String, Object> d2 = com.baidu.crabsdk.a.a.b().d();
        if (d2 == null) {
            com.baidu.crabsdk.c.a.d("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.c("^^ -BlockCanaryCore- ^^" + d2.toString());
        context = com.baidu.crabsdk.a.c.f4801d;
        byte[] bArr = null;
        Map<String, Object> c2 = com.baidu.crabsdk.sender.g.c(context, null, true);
        c2.putAll(d2);
        com.baidu.crabsdk.sender.g.h(c2);
        String h2 = com.baidu.crabsdk.sender.i.h(c2);
        String h3 = com.baidu.crabsdk.c.d.h(com.baidu.crabsdk.a.f4782d, UUID.randomUUID().toString());
        String j2 = com.baidu.crabsdk.c.d.j(h2, h3);
        try {
            h3 = com.baidu.crabsdk.c.e.a(h3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.crabsdk.sender.h.l();
        if (com.baidu.crabsdk.sender.h.a()) {
            com.baidu.crabsdk.c.a.b("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.i()) {
                com.baidu.crabsdk.c.a.b("CrashSwitch.canBlockUploadToday() == false");
                com.baidu.crabsdk.a.b.c().e();
                bVar.d();
                return;
            }
            if (j2 != null) {
                try {
                    if (j2.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(j2.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = j2.getBytes("UTF-8");
                        }
                    }
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    return;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            k.c(bArr, h3);
        }
    }

    public final void b() {
        this.f63296f = 0L;
        this.f63299i = 0;
    }

    public final void c() {
        if (this.f63295e) {
            return;
        }
        this.f63295e = true;
        b();
        try {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                new Handler(Looper.getMainLooper()).post(new d(this));
                return;
            }
            try {
                Choreographer.getInstance().postFrameCallback(j);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            com.baidu.crabsdk.c.a.a("postFrameCallback error!!", e3);
        }
    }

    public final void d() {
        this.f63295e = false;
        b();
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new e(this));
            return;
        }
        try {
            Choreographer.getInstance().removeFrameCallback(j);
            com.baidu.crabsdk.c.a.b("stop FrameMonitor !!");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        ExecutorService executorService;
        try {
            if (this.f63296f != 0) {
                long j3 = j2 - this.f63296f;
                if (j3 > this.f63297g) {
                    this.f63299i = (int) (this.f63299i + (j3 / this.f63298h));
                } else if (this.f63299i > 0) {
                    if (this.f63299i > 30) {
                        com.baidu.crabsdk.c.a.c("^^ block skip frames = " + this.f63299i + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.f63299i * this.f63298h) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.f63299i * this.f63298h) >= com.baidu.crabsdk.a.a.f4788g) {
                            executorService = com.baidu.crabsdk.a.c.f4802e;
                            executorService.execute(new c(this));
                        }
                        this.f63299i = 1;
                    }
                    this.f63299i--;
                }
            }
            this.f63296f = j2;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.d("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
