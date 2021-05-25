package d.a.l0.k.r;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<T> f47964a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final int f47965b;

    public c(int i2) {
        this.f47965b = i2;
    }

    public synchronized T a() {
        T remove;
        do {
            if (this.f47964a.size() <= 0) {
                return null;
            }
            remove = this.f47964a.remove(this.f47964a.size() - 1);
        } while (remove == null);
        return remove;
    }

    public synchronized void b(T t) {
        if (t != null) {
            if (this.f47964a.size() >= this.f47965b) {
                this.f47964a.remove(this.f47964a.size() - 1);
            }
            this.f47964a.add(t);
        }
    }
}
