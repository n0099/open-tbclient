package d.b.g0.i.r;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<T> f48873a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final int f48874b;

    public c(int i) {
        this.f48874b = i;
    }

    public synchronized T a() {
        T remove;
        do {
            if (this.f48873a.size() <= 0) {
                return null;
            }
            remove = this.f48873a.remove(this.f48873a.size() - 1);
        } while (remove == null);
        return remove;
    }

    public synchronized void b(T t) {
        if (t != null) {
            if (this.f48873a.size() >= this.f48874b) {
                this.f48873a.remove(this.f48873a.size() - 1);
            }
            this.f48873a.add(t);
        }
    }
}
