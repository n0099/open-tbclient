package d.a.t0.e.g;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import d.a.t0.e.f.d;
import d.k.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: d.a.t0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1811a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f64686a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f64687b;

        public C1811a(AtomicBoolean atomicBoolean, Object obj) {
            this.f64686a = atomicBoolean;
            this.f64687b = obj;
        }

        @Override // d.k.a.a.c
        public void a(int i2, Exception exc) {
            a.this.f64685g = i2;
            this.f64686a.set(true);
            synchronized (this.f64687b) {
                this.f64687b.notifyAll();
            }
        }

        @Override // d.k.a.a.c
        public void b(String str, boolean z) {
            a.this.f64682d = str;
            a.this.f64680b = z;
            a.this.f64681c = true;
            a.this.f64685g = 0;
            this.f64686a.set(true);
            synchronized (this.f64687b) {
                this.f64687b.notifyAll();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f64682d = "";
        this.f64680b = false;
        this.f64681c = false;
        this.f64685g = -200;
    }

    @Override // d.a.t0.e.f.c
    public d.a.t0.e.f.c d() {
        o();
        return this;
    }

    public d.a.t0.e.f.c o() {
        Object obj = new Object();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d.k.a.a.d(this.f64679a, new C1811a(atomicBoolean, obj));
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
