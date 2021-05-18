package d.a.i0.q;

import com.baidu.android.ddmlib.tools.perflib.vmtrace.MethodInfo;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public int f48142e;

    /* renamed from: f  reason: collision with root package name */
    public long f48143f;

    /* renamed from: g  reason: collision with root package name */
    public long f48144g;

    /* renamed from: h  reason: collision with root package name */
    public String f48145h;

    /* renamed from: i  reason: collision with root package name */
    public long f48146i;
    public MethodInfo j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return (int) (this.f48146i - aVar.e());
    }

    public long b() {
        long j = this.f48144g - this.f48143f;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public MethodInfo c() {
        return this.j;
    }

    public int d() {
        return this.f48142e;
    }

    public long e() {
        return this.f48146i;
    }

    public String f() {
        return this.f48145h;
    }
}
