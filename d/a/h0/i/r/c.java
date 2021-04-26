package d.a.h0.i.r;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<T> f47101a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final int f47102b;

    public c(int i2) {
        this.f47102b = i2;
    }

    public synchronized T a() {
        T remove;
        do {
            if (this.f47101a.size() <= 0) {
                return null;
            }
            remove = this.f47101a.remove(this.f47101a.size() - 1);
        } while (remove == null);
        return remove;
    }

    public synchronized void b(T t) {
        if (t != null) {
            if (this.f47101a.size() >= this.f47102b) {
                this.f47101a.remove(this.f47101a.size() - 1);
            }
            this.f47101a.add(t);
        }
    }
}
