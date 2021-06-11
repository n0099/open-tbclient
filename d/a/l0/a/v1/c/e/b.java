package d.a.l0.a.v1.c.e;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.a2.d;
import d.a.l0.a.k;
import d.a.l0.a.v1.c.a;
import d.a.l0.a.v1.c.c;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes3.dex */
public class b implements a.c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48991b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final Deque<Message> f48992a = new ArrayDeque();

    @Override // d.a.l0.a.v1.c.a.c
    public void a() {
        a E = a.E();
        while (E.k() && !this.f48992a.isEmpty()) {
            Message peek = this.f48992a.peek();
            if (peek == null || e(peek)) {
                this.f48992a.poll();
            }
        }
    }

    @Override // d.a.l0.a.v1.c.a.c
    public void b(@NonNull c cVar) {
        Message h2 = cVar.h();
        h2.arg1 = SwanAppProcessInfo.current().index;
        if (d.g().C()) {
            Object obj = h2.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                if (!bundle.containsKey("ai_apps_id")) {
                    bundle.putString("ai_apps_id", d.g().getAppId());
                }
            }
        }
        if (e(h2) || !cVar.n()) {
            return;
        }
        this.f48992a.offer(h2);
        a.E().Q();
    }

    @Override // d.a.l0.a.v1.c.a.c
    public void c(String str) {
    }

    @Override // d.a.l0.a.v1.c.a.c
    public void d(String str) {
    }

    public final boolean e(Message message) {
        a E = a.E();
        if (message == null || !E.k()) {
            return false;
        }
        try {
            E.G().send(message);
            return true;
        } catch (RemoteException e2) {
            E.I();
            if (f48991b) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
