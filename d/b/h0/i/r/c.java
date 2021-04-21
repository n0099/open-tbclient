package d.b.h0.i.r;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<T> f49595a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final int f49596b;

    public c(int i) {
        this.f49596b = i;
    }

    public synchronized T a() {
        T remove;
        do {
            if (this.f49595a.size() <= 0) {
                return null;
            }
            remove = this.f49595a.remove(this.f49595a.size() - 1);
        } while (remove == null);
        return remove;
    }

    public synchronized void b(T t) {
        if (t != null) {
            if (this.f49595a.size() >= this.f49596b) {
                this.f49595a.remove(this.f49595a.size() - 1);
            }
            this.f49595a.add(t);
        }
    }
}
