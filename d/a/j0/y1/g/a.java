package d.a.j0.y1.g;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f62759a;

    public a(Boolean bool) {
        this.f62759a = new AtomicBoolean(bool.booleanValue());
    }

    public boolean a() {
        return this.f62759a.get();
    }

    public void b(boolean z) {
        this.f62759a.set(z);
    }
}
