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
    public class C1869a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68404a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f68405b;

        public C1869a(AtomicBoolean atomicBoolean, Object obj) {
            this.f68404a = atomicBoolean;
            this.f68405b = obj;
        }

        @Override // d.k.a.a.c
        public void a(int i2, Exception exc) {
            a.this.f68403g = i2;
            this.f68404a.set(true);
            synchronized (this.f68405b) {
                this.f68405b.notifyAll();
            }
        }

        @Override // d.k.a.a.c
        public void b(String str, boolean z) {
            a.this.f68400d = str;
            a.this.f68398b = z;
            a.this.f68399c = true;
            a.this.f68403g = 0;
            this.f68404a.set(true);
            synchronized (this.f68405b) {
                this.f68405b.notifyAll();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f68400d = "";
        this.f68398b = false;
        this.f68399c = false;
        this.f68403g = -200;
    }

    @Override // d.a.t0.e.f.c
    public d.a.t0.e.f.c d() {
        o();
        return this;
    }

    public d.a.t0.e.f.c o() {
        Object obj = new Object();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d.k.a.a.d(this.f68397a, new C1869a(atomicBoolean, obj));
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
