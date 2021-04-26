package d.a.h0.a.y0.e.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.h0.a.i2.q0;
/* loaded from: classes2.dex */
public abstract class b<ValueT> {

    /* renamed from: a  reason: collision with root package name */
    public final ValueT f45256a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f45257e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45258f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f45259g;

        public a(c cVar, String str, Object obj) {
            this.f45257e = cVar;
            this.f45258f = str;
            this.f45259g = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.a.h0.a.y0.e.f.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            b.this.e(this.f45257e.z(), this.f45258f, this.f45259g);
        }
    }

    public b() {
        this(null);
    }

    public ValueT a(c cVar, String str) {
        return b(cVar, str, this.f45256a);
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
        this.f45256a = valuet;
    }
}
