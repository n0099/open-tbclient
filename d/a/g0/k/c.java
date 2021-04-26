package d.a.g0.k;

import android.annotation.TargetApi;
@TargetApi(9)
/* loaded from: classes2.dex */
public abstract class c implements a<c> {

    /* renamed from: e  reason: collision with root package name */
    public int f40950e;

    public c() {
        this(5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return cVar.f40950e - this.f40950e;
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public void run() {
        b();
    }

    public c(int i2) {
        this.f40950e = i2;
    }
}
