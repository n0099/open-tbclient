package d.a.t.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f64564a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f64565b = 15000;

    /* renamed from: c  reason: collision with root package name */
    public int f64566c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f64567d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f64568e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f64569f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f64570g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f64571h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f64572i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f64571h + ", methodId :" + this.f64572i + ", connectState :" + this.j + ", isNotify :" + this.f64568e + ", bodySize :" + this.f64564a.length;
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f64571h + ", methodId :" + this.f64572i + ", errorCode :" + this.f64566c + ", errorMsg :" + this.f64567d + ", intervalMs :" + this.f64570g + ", isNotify :" + this.f64568e + ", bodySize :" + this.f64569f.length;
    }
}
