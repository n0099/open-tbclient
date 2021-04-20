package d.b.g0.i.r;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<T> f49266a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final int f49267b;

    public c(int i) {
        this.f49267b = i;
    }

    public synchronized T a() {
        T remove;
        do {
            if (this.f49266a.size() <= 0) {
                return null;
            }
            remove = this.f49266a.remove(this.f49266a.size() - 1);
        } while (remove == null);
        return remove;
    }

    public synchronized void b(T t) {
        if (t != null) {
            if (this.f49266a.size() >= this.f49267b) {
                this.f49266a.remove(this.f49266a.size() - 1);
            }
            this.f49266a.add(t);
        }
    }
}
