package d.a.p0.e.g;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import d.a.p0.e.f.d;
import d.k.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: d.a.p0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1708a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f63510a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f63511b;

        public C1708a(AtomicBoolean atomicBoolean, Object obj) {
            this.f63510a = atomicBoolean;
            this.f63511b = obj;
        }

        @Override // d.k.a.a.c
        public void a(int i2, Exception exc) {
            a.this.f63509g = i2;
            this.f63510a.set(true);
            synchronized (this.f63511b) {
                this.f63511b.notifyAll();
            }
        }

        @Override // d.k.a.a.c
        public void b(String str, boolean z) {
            a.this.f63506d = str;
            a.this.f63504b = z;
            a.this.f63505c = true;
            a.this.f63509g = 0;
            this.f63510a.set(true);
            synchronized (this.f63511b) {
                this.f63511b.notifyAll();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f63506d = "";
        this.f63504b = false;
        this.f63505c = false;
        this.f63509g = -200;
    }

    @Override // d.a.p0.e.f.c
    public d.a.p0.e.f.c d() {
        o();
        return this;
    }

    public d.a.p0.e.f.c o() {
        Object obj = new Object();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d.k.a.a.d(this.f63503a, new C1708a(atomicBoolean, obj));
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
