package d.o.a.e.b.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<a> f67344a;

    /* loaded from: classes7.dex */
    public interface a {
        void a(Message message);
    }

    public g(Looper looper, a aVar) {
        super(looper);
        this.f67344a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f67344a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}
