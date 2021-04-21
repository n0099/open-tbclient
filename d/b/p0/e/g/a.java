package d.b.p0.e.g;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import d.b.p0.e.f.d;
import d.l.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: d.b.p0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1770a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f65196a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f65197b;

        public C1770a(AtomicBoolean atomicBoolean, Object obj) {
            this.f65196a = atomicBoolean;
            this.f65197b = obj;
        }

        @Override // d.l.a.a.c
        public void a(String str, boolean z) {
            a.this.f65192d = str;
            a.this.f65190b = z;
            a.this.f65191c = true;
            a.this.f65195g = 0;
            this.f65196a.set(true);
            synchronized (this.f65197b) {
                this.f65197b.notifyAll();
            }
        }

        @Override // d.l.a.a.c
        public void b(int i, Exception exc) {
            a.this.f65195g = i;
            this.f65196a.set(true);
            synchronized (this.f65197b) {
                this.f65197b.notifyAll();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f65192d = "";
        this.f65190b = false;
        this.f65191c = false;
        this.f65195g = -200;
    }

    @Override // d.b.p0.e.f.c
    public d.b.p0.e.f.c d() {
        o();
        return this;
    }

    public d.b.p0.e.f.c o() {
        Object obj = new Object();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d.l.a.a.d(this.f65189a, new C1770a(atomicBoolean, obj));
        synchronized (obj) {
            if (!atomicBoolean.get()) {
                try {
                    obj.wait(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
                } catch (InterruptedException unused) {
                }
            }
        }
        return this;
    }
}
