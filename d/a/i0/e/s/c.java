package d.a.i0.e.s;

import d.a.i0.a.a2.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c<ContenT> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c<ContenT>.a> f46446a = new HashMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final String f46447e;

        /* renamed from: f  reason: collision with root package name */
        public final ContenT f46448f;

        public a(String str, ContenT content) {
            this.f46447e = str;
            this.f46448f = content;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d(this.f46447e);
        }
    }

    public synchronized ContenT a(String str, ContenT content, long j) {
        d(str);
        if (content == null) {
            return null;
        }
        c<ContenT>.a aVar = new a(str, content);
        this.f46446a.put(str, aVar);
        if (j > 0) {
            d.i().postDelayed(aVar, j);
        }
        return content;
    }

    public synchronized void b() {
        for (c<ContenT>.a aVar : this.f46446a.values()) {
            if (aVar != null) {
                d.i().removeCallbacks(aVar);
            }
        }
        this.f46446a.clear();
    }

    public ContenT c(String str) {
        c<ContenT>.a aVar = this.f46446a.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.f46448f;
    }

    public synchronized ContenT d(String str) {
        c<ContenT>.a remove = this.f46446a.remove(str);
        if (remove != null) {
            d.i().removeCallbacks(remove);
            return remove.f46448f;
        }
        return null;
    }
}
