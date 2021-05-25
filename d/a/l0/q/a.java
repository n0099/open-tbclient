package d.a.l0.q;

import com.baidu.android.ddmlib.tools.perflib.vmtrace.MethodInfo;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public int f48318e;

    /* renamed from: f  reason: collision with root package name */
    public long f48319f;

    /* renamed from: g  reason: collision with root package name */
    public long f48320g;

    /* renamed from: h  reason: collision with root package name */
    public String f48321h;

    /* renamed from: i  reason: collision with root package name */
    public long f48322i;
    public MethodInfo j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return (int) (this.f48322i - aVar.e());
    }

    public long b() {
        long j = this.f48320g - this.f48319f;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public MethodInfo c() {
        return this.j;
    }

    public int d() {
        return this.f48318e;
    }

    public long e() {
        return this.f48322i;
    }

    public String f() {
        return this.f48321h;
    }
}
