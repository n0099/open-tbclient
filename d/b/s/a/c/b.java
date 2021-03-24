package d.b.s.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f64598a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f64599b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public int f64600c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f64601d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f64602e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f64603f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f64604g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f64605h = -1;
    public long i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f64605h + ", methodId :" + this.i + ", connectState :" + this.j + ", isNotify :" + this.f64602e + ", bodySize :" + this.f64598a.length + ", request :" + new String(this.f64598a);
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f64605h + ", methodId :" + this.i + ", errorCode :" + this.f64600c + ", errorMsg :" + this.f64601d + ", intervalMs :" + this.f64604g + ", isNotify :" + this.f64602e + ", bodySize :" + this.f64603f.length + ", response :" + new String(this.f64603f);
    }
}
