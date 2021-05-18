package d.a.s.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f64566a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f64567b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public int f64568c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f64569d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f64570e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f64571f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f64572g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f64573h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f64574i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f64573h + ", methodId :" + this.f64574i + ", connectState :" + this.j + ", isNotify :" + this.f64570e + ", bodySize :" + this.f64566a.length + ", request :" + new String(this.f64566a);
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f64573h + ", methodId :" + this.f64574i + ", errorCode :" + this.f64568c + ", errorMsg :" + this.f64569d + ", intervalMs :" + this.f64572g + ", isNotify :" + this.f64570e + ", bodySize :" + this.f64571f.length + ", response :" + new String(this.f64571f);
    }
}
