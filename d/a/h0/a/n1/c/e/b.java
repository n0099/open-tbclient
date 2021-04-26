package d.a.h0.a.n1.c.e;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.h0.a.k;
import d.a.h0.a.n1.c.a;
import d.a.h0.a.n1.c.c;
import d.a.h0.a.r1.d;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes3.dex */
public class b implements a.c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43446b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public final Deque<Message> f43447a = new ArrayDeque();

    @Override // d.a.h0.a.n1.c.a.c
    public void a() {
        a C = a.C();
        while (C.A() && !this.f43447a.isEmpty()) {
            Message peek = this.f43447a.peek();
            if (peek == null || e(peek)) {
                this.f43447a.poll();
            }
        }
    }

    @Override // d.a.h0.a.n1.c.a.c
    public void b(@NonNull c cVar) {
        Message h2 = cVar.h();
        h2.arg1 = SwanAppProcessInfo.current().index;
        if (d.e().z()) {
            Object obj = h2.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                if (!bundle.containsKey("ai_apps_id")) {
                    bundle.putString("ai_apps_id", d.e().getAppId());
                }
            }
        }
        if (e(h2) || !cVar.n()) {
            return;
        }
        this.f43447a.offer(h2);
        a.C().O();
    }

    @Override // d.a.h0.a.n1.c.a.c
    public void c(String str) {
    }

    @Override // d.a.h0.a.n1.c.a.c
    public void d(String str) {
    }

    public final boolean e(Message message) {
        a C = a.C();
        if (message == null || !C.A()) {
            return false;
        }
        try {
            C.E().send(message);
            return true;
        } catch (RemoteException e2) {
            C.G();
            if (f43446b) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
