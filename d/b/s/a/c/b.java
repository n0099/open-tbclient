package d.b.s.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f65557a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f65558b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public int f65559c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f65560d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f65561e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f65562f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f65563g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f65564h = -1;
    public long i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f65564h + ", methodId :" + this.i + ", connectState :" + this.j + ", isNotify :" + this.f65561e + ", bodySize :" + this.f65557a.length + ", request :" + new String(this.f65557a);
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f65564h + ", methodId :" + this.i + ", errorCode :" + this.f65559c + ", errorMsg :" + this.f65560d + ", intervalMs :" + this.f65563g + ", isNotify :" + this.f65561e + ", bodySize :" + this.f65562f.length + ", response :" + new String(this.f65562f);
    }
}
