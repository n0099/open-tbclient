package d.a.n0.z1.g;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f67365a;

    public a(Boolean bool) {
        this.f67365a = new AtomicBoolean(bool.booleanValue());
    }

    public boolean a() {
        return this.f67365a.get();
    }

    public void b(boolean z) {
        this.f67365a.set(z);
    }
}
