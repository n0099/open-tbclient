package d.a.m0.k.r;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<T> f51746a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final int f51747b;

    public c(int i2) {
        this.f51747b = i2;
    }

    public synchronized T a() {
        T remove;
        do {
            if (this.f51746a.size() <= 0) {
                return null;
            }
            remove = this.f51746a.remove(this.f51746a.size() - 1);
        } while (remove == null);
        return remove;
    }

    public synchronized void b(T t) {
        if (t != null) {
            if (this.f51746a.size() >= this.f51747b) {
                this.f51746a.remove(this.f51746a.size() - 1);
            }
            this.f51746a.add(t);
        }
    }
}
