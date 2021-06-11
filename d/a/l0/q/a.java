package d.a.l0.q;

import com.baidu.android.ddmlib.tools.perflib.vmtrace.MethodInfo;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public int f51992e;

    /* renamed from: f  reason: collision with root package name */
    public long f51993f;

    /* renamed from: g  reason: collision with root package name */
    public long f51994g;

    /* renamed from: h  reason: collision with root package name */
    public String f51995h;

    /* renamed from: i  reason: collision with root package name */
    public long f51996i;
    public MethodInfo j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return (int) (this.f51996i - aVar.e());
    }

    public long b() {
        long j = this.f51994g - this.f51993f;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public MethodInfo c() {
        return this.j;
    }

    public int d() {
        return this.f51992e;
    }

    public long e() {
        return this.f51996i;
    }

    public String f() {
        return this.f51995h;
    }
}
