package d.b.g0.k;

import android.annotation.TargetApi;
@TargetApi(9)
/* loaded from: classes2.dex */
public abstract class c implements a<c> {

    /* renamed from: e  reason: collision with root package name */
    public int f43693e;

    public c() {
        this(5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return cVar.f43693e - this.f43693e;
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public void run() {
        b();
    }

    public c(int i) {
        this.f43693e = i;
    }
}
