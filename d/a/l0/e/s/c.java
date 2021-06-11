package d.a.l0.e.s;

import d.a.l0.a.a2.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c<ContenT> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c<ContenT>.a> f50296a = new HashMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final String f50297e;

        /* renamed from: f  reason: collision with root package name */
        public final ContenT f50298f;

        public a(String str, ContenT content) {
            this.f50297e = str;
            this.f50298f = content;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d(this.f50297e);
        }
    }

    public synchronized ContenT a(String str, ContenT content, long j) {
        d(str);
        if (content == null) {
            return null;
        }
        c<ContenT>.a aVar = new a(str, content);
        this.f50296a.put(str, aVar);
        if (j > 0) {
            d.i().postDelayed(aVar, j);
        }
        return content;
    }

    public synchronized void b() {
        for (c<ContenT>.a aVar : this.f50296a.values()) {
            if (aVar != null) {
                d.i().removeCallbacks(aVar);
            }
        }
        this.f50296a.clear();
    }

    public ContenT c(String str) {
        c<ContenT>.a aVar = this.f50296a.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.f50298f;
    }

    public synchronized ContenT d(String str) {
        c<ContenT>.a remove = this.f50296a.remove(str);
        if (remove != null) {
            d.i().removeCallbacks(remove);
            return remove.f50298f;
        }
        return null;
    }
}
