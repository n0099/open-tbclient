package d.a.q0.e.g;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import d.a.q0.e.f.d;
import d.k.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: d.a.q0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1796a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f64507a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f64508b;

        public C1796a(AtomicBoolean atomicBoolean, Object obj) {
            this.f64507a = atomicBoolean;
            this.f64508b = obj;
        }

        @Override // d.k.a.a.c
        public void a(int i2, Exception exc) {
            a.this.f64506g = i2;
            this.f64507a.set(true);
            synchronized (this.f64508b) {
                this.f64508b.notifyAll();
            }
        }

        @Override // d.k.a.a.c
        public void b(String str, boolean z) {
            a.this.f64503d = str;
            a.this.f64501b = z;
            a.this.f64502c = true;
            a.this.f64506g = 0;
            this.f64507a.set(true);
            synchronized (this.f64508b) {
                this.f64508b.notifyAll();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f64503d = "";
        this.f64501b = false;
        this.f64502c = false;
        this.f64506g = -200;
    }

    @Override // d.a.q0.e.f.c
    public d.a.q0.e.f.c d() {
        o();
        return this;
    }

    public d.a.q0.e.f.c o() {
        Object obj = new Object();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d.k.a.a.d(this.f64500a, new C1796a(atomicBoolean, obj));
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
