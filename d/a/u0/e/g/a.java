package d.a.u0.e.g;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import d.a.u0.e.f.d;
import d.k.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: d.a.u0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1872a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68508a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f68509b;

        public C1872a(AtomicBoolean atomicBoolean, Object obj) {
            this.f68508a = atomicBoolean;
            this.f68509b = obj;
        }

        @Override // d.k.a.a.c
        public void a(int i2, Exception exc) {
            a.this.f68507g = i2;
            this.f68508a.set(true);
            synchronized (this.f68509b) {
                this.f68509b.notifyAll();
            }
        }

        @Override // d.k.a.a.c
        public void b(String str, boolean z) {
            a.this.f68504d = str;
            a.this.f68502b = z;
            a.this.f68503c = true;
            a.this.f68507g = 0;
            this.f68508a.set(true);
            synchronized (this.f68509b) {
                this.f68509b.notifyAll();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f68504d = "";
        this.f68502b = false;
        this.f68503c = false;
        this.f68507g = -200;
    }

    @Override // d.a.u0.e.f.c
    public d.a.u0.e.f.c d() {
        o();
        return this;
    }

    public d.a.u0.e.f.c o() {
        Object obj = new Object();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d.k.a.a.d(this.f68501a, new C1872a(atomicBoolean, obj));
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
