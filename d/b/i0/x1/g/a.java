package d.b.i0.x1.g;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f62377a;

    public a(Boolean bool) {
        this.f62377a = new AtomicBoolean(bool.booleanValue());
    }

    public boolean a() {
        return this.f62377a.get();
    }

    public void b(boolean z) {
        this.f62377a.set(z);
    }
}
