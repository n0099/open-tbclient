package d.b.j0.y1.g;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f64483a;

    public a(Boolean bool) {
        this.f64483a = new AtomicBoolean(bool.booleanValue());
    }

    public boolean a() {
        return this.f64483a.get();
    }

    public void b(boolean z) {
        this.f64483a.set(z);
    }
}
