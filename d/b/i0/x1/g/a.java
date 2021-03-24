package d.b.i0.x1.g;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f62376a;

    public a(Boolean bool) {
        this.f62376a = new AtomicBoolean(bool.booleanValue());
    }

    public boolean a() {
        return this.f62376a.get();
    }

    public void b(boolean z) {
        this.f62376a.set(z);
    }
}
