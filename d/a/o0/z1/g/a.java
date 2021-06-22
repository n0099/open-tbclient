package d.a.o0.z1.g;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f67490a;

    public a(Boolean bool) {
        this.f67490a = new AtomicBoolean(bool.booleanValue());
    }

    public boolean a() {
        return this.f67490a.get();
    }

    public void b(boolean z) {
        this.f67490a.set(z);
    }
}
