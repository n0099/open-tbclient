package d.a.z.h.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import d.a.z.c.a.h;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public Context f68783a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f68784b;

    public b(Context context, CountDownLatch countDownLatch) {
        super(Looper.getMainLooper());
        this.f68783a = context;
        this.f68784b = countDownLatch;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        h.a().c();
        try {
            new WebView(this.f68783a);
        } catch (Exception unused) {
        }
        this.f68784b.countDown();
    }
}
