package d.a.x.h.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import d.a.x.c.a.h;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public Context f64208a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f64209b;

    public b(Context context, CountDownLatch countDownLatch) {
        super(Looper.getMainLooper());
        this.f64208a = context;
        this.f64209b = countDownLatch;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        h.a().c();
        try {
            new WebView(this.f64208a);
        } catch (Exception unused) {
        }
        this.f64209b.countDown();
    }
}
