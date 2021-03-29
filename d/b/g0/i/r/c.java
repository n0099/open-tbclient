package d.b.g0.i.r;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<T> f48874a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final int f48875b;

    public c(int i) {
        this.f48875b = i;
    }

    public synchronized T a() {
        T remove;
        do {
            if (this.f48874a.size() <= 0) {
                return null;
            }
            remove = this.f48874a.remove(this.f48874a.size() - 1);
        } while (remove == null);
        return remove;
    }

    public synchronized void b(T t) {
        if (t != null) {
            if (this.f48874a.size() >= this.f48875b) {
                this.f48874a.remove(this.f48874a.size() - 1);
            }
            this.f48874a.add(t);
        }
    }
}
