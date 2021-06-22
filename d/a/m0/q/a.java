package d.a.m0.q;

import com.baidu.android.ddmlib.tools.perflib.vmtrace.MethodInfo;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public int f52100e;

    /* renamed from: f  reason: collision with root package name */
    public long f52101f;

    /* renamed from: g  reason: collision with root package name */
    public long f52102g;

    /* renamed from: h  reason: collision with root package name */
    public String f52103h;

    /* renamed from: i  reason: collision with root package name */
    public long f52104i;
    public MethodInfo j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return (int) (this.f52104i - aVar.e());
    }

    public long b() {
        long j = this.f52102g - this.f52101f;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public MethodInfo c() {
        return this.j;
    }

    public int d() {
        return this.f52100e;
    }

    public long e() {
        return this.f52104i;
    }

    public String f() {
        return this.f52103h;
    }
}
