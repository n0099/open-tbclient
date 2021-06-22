package d.a.t.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f68364a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f68365b = 15000;

    /* renamed from: c  reason: collision with root package name */
    public int f68366c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f68367d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f68368e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f68369f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f68370g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f68371h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f68372i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f68371h + ", methodId :" + this.f68372i + ", connectState :" + this.j + ", isNotify :" + this.f68368e + ", bodySize :" + this.f68364a.length;
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f68371h + ", methodId :" + this.f68372i + ", errorCode :" + this.f68366c + ", errorMsg :" + this.f68367d + ", intervalMs :" + this.f68370g + ", isNotify :" + this.f68368e + ", bodySize :" + this.f68369f.length;
    }
}
