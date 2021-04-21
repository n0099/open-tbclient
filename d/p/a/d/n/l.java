package d.p.a.d.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class l extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<a> f67928a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public l(Looper looper, a aVar) {
        super(looper);
        this.f67928a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f67928a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}
