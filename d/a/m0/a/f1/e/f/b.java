package d.a.m0.a.f1.e.f;

import android.os.Bundle;
/* loaded from: classes3.dex */
public abstract class b<ValueT> {

    /* renamed from: a  reason: collision with root package name */
    public final ValueT f45634a;

    public b() {
        this(null);
    }

    public ValueT a(c cVar, String str) {
        return b(cVar, str, this.f45634a);
    }

    public ValueT b(c cVar, String str, ValueT valuet) {
        return c(cVar.B(), str, valuet);
    }

    public abstract ValueT c(Bundle bundle, String str, ValueT valuet);

    public void d(c cVar, String str, ValueT valuet) {
        e(cVar.B(), str, valuet);
    }

    public abstract void e(Bundle bundle, String str, ValueT valuet);

    public b(ValueT valuet) {
        this.f45634a = valuet;
    }
}
