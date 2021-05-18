package d.b.c.b.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<a> f65789a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public h(Looper looper, a aVar) {
        super(looper);
        this.f65789a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f65789a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}
