package d.a.k0.y1.g;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f63483a;

    public a(Boolean bool) {
        this.f63483a = new AtomicBoolean(bool.booleanValue());
    }

    public boolean a() {
        return this.f63483a.get();
    }

    public void b(boolean z) {
        this.f63483a.set(z);
    }
}
