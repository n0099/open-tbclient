package d.a.l0.a.i1.e.d;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends T> f46581a;

    public a(@NonNull Class<? extends T> cls) {
        this.f46581a = cls;
    }

    @Override // d.a.l0.a.i1.e.d.b
    public T make() throws IllegalAccessException, InstantiationException {
        return this.f46581a.newInstance();
    }
}
