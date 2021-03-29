package d.b.g0.a.b1.e.d;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends T> f43462a;

    public a(@NonNull Class<? extends T> cls) {
        this.f43462a = cls;
    }

    @Override // d.b.g0.a.b1.e.d.b
    public T make() throws IllegalAccessException, InstantiationException {
        return this.f43462a.newInstance();
    }
}
