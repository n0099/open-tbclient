package d.a.n0.z1.g;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f63647a;

    public a(Boolean bool) {
        this.f63647a = new AtomicBoolean(bool.booleanValue());
    }

    public boolean a() {
        return this.f63647a.get();
    }

    public void b(boolean z) {
        this.f63647a.set(z);
    }
}
