package d.b.r.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f65293a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f65294b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public int f65295c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f65296d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f65297e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f65298f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f65299g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f65300h = -1;
    public long i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f65300h + ", methodId :" + this.i + ", connectState :" + this.j + ", isNotify :" + this.f65297e + ", bodySize :" + this.f65293a.length + ", request :" + new String(this.f65293a);
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f65300h + ", methodId :" + this.i + ", errorCode :" + this.f65295c + ", errorMsg :" + this.f65296d + ", intervalMs :" + this.f65299g + ", isNotify :" + this.f65297e + ", bodySize :" + this.f65298f.length + ", response :" + new String(this.f65298f);
    }
}
