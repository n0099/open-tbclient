package d.b.o0.e.g;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import d.b.o0.e.f.d;
import d.k.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: d.b.o0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1737a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f64218a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f64219b;

        public C1737a(AtomicBoolean atomicBoolean, Object obj) {
            this.f64218a = atomicBoolean;
            this.f64219b = obj;
        }

        @Override // d.k.a.a.c
        public void a(String str, boolean z) {
            a.this.f64214d = str;
            a.this.f64212b = z;
            a.this.f64213c = true;
            a.this.f64217g = 0;
            this.f64218a.set(true);
            synchronized (this.f64219b) {
                this.f64219b.notifyAll();
            }
        }

        @Override // d.k.a.a.c
        public void b(int i, Exception exc) {
            a.this.f64217g = i;
            this.f64218a.set(true);
            synchronized (this.f64219b) {
                this.f64219b.notifyAll();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f64214d = "";
        this.f64212b = false;
        this.f64213c = false;
        this.f64217g = -200;
    }

    @Override // d.b.o0.e.f.c
    public d.b.o0.e.f.c d() {
        o();
        return this;
    }

    public d.b.o0.e.f.c o() {
        Object obj = new Object();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d.k.a.a.d(this.f64211a, new C1737a(atomicBoolean, obj));
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
