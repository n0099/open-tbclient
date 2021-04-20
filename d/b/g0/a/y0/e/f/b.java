package d.b.g0.a.y0.e.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.q0;
/* loaded from: classes2.dex */
public abstract class b<ValueT> {

    /* renamed from: a  reason: collision with root package name */
    public final ValueT f47492a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47493e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47494f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f47495g;

        public a(c cVar, String str, Object obj) {
            this.f47493e = cVar;
            this.f47494f = str;
            this.f47495g = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.b.g0.a.y0.e.f.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            b.this.e(this.f47493e.z(), this.f47494f, this.f47495g);
        }
    }

    public b() {
        this(null);
    }

    public ValueT a(c cVar, String str) {
        return b(cVar, str, this.f47492a);
    }

    public ValueT b(c cVar, String str, ValueT valuet) {
        return c(cVar.z(), str, valuet);
    }

    public abstract ValueT c(Bundle bundle, String str, ValueT valuet);

    public void d(@NonNull c cVar, String str, ValueT valuet) {
        q0 B = cVar.B();
        if (B.a()) {
            e(cVar.z(), str, valuet);
            B.b();
            return;
        }
        B.e(new a(cVar, str, valuet));
    }

    public abstract void e(Bundle bundle, String str, ValueT valuet);

    public b(ValueT valuet) {
        this.f47492a = valuet;
    }
}
