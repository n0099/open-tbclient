package d.a.m0.e.s;

import d.a.m0.a.a2.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c<ContenT> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c<ContenT>.a> f50404a = new HashMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final String f50405e;

        /* renamed from: f  reason: collision with root package name */
        public final ContenT f50406f;

        public a(String str, ContenT content) {
            this.f50405e = str;
            this.f50406f = content;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d(this.f50405e);
        }
    }

    public synchronized ContenT a(String str, ContenT content, long j) {
        d(str);
        if (content == null) {
            return null;
        }
        c<ContenT>.a aVar = new a(str, content);
        this.f50404a.put(str, aVar);
        if (j > 0) {
            d.i().postDelayed(aVar, j);
        }
        return content;
    }

    public synchronized void b() {
        for (c<ContenT>.a aVar : this.f50404a.values()) {
            if (aVar != null) {
                d.i().removeCallbacks(aVar);
            }
        }
        this.f50404a.clear();
    }

    public ContenT c(String str) {
        c<ContenT>.a aVar = this.f50404a.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.f50406f;
    }

    public synchronized ContenT d(String str) {
        c<ContenT>.a remove = this.f50404a.remove(str);
        if (remove != null) {
            d.i().removeCallbacks(remove);
            return remove.f50406f;
        }
        return null;
    }
}
