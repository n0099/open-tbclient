package d.b.h0.a.b1.e.d;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends T> f44183a;

    public a(@NonNull Class<? extends T> cls) {
        this.f44183a = cls;
    }

    @Override // d.b.h0.a.b1.e.d.b
    public T make() throws IllegalAccessException, InstantiationException {
        return this.f44183a.newInstance();
    }
}
