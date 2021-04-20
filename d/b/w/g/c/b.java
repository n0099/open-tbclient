package d.b.w.g.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import d.b.w.c.a.h;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public Context f65589a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f65590b;

    public b(Context context, CountDownLatch countDownLatch) {
        super(Looper.getMainLooper());
        this.f65589a = context;
        this.f65590b = countDownLatch;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        h.a().c();
        try {
            new WebView(this.f65589a);
        } catch (Exception unused) {
        }
        this.f65590b.countDown();
    }
}
