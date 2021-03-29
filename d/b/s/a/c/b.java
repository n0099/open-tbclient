package d.b.s.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f64599a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f64600b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public int f64601c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f64602d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f64603e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f64604f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f64605g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f64606h = -1;
    public long i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f64606h + ", methodId :" + this.i + ", connectState :" + this.j + ", isNotify :" + this.f64603e + ", bodySize :" + this.f64599a.length + ", request :" + new String(this.f64599a);
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f64606h + ", methodId :" + this.i + ", errorCode :" + this.f64601c + ", errorMsg :" + this.f64602d + ", intervalMs :" + this.f64605g + ", isNotify :" + this.f64603e + ", bodySize :" + this.f64604f.length + ", response :" + new String(this.f64604f);
    }
}
