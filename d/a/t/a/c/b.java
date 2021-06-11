package d.a.t.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f68282a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f68283b = 15000;

    /* renamed from: c  reason: collision with root package name */
    public int f68284c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f68285d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f68286e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f68287f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f68288g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f68289h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f68290i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f68289h + ", methodId :" + this.f68290i + ", connectState :" + this.j + ", isNotify :" + this.f68286e + ", bodySize :" + this.f68282a.length;
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f68289h + ", methodId :" + this.f68290i + ", errorCode :" + this.f68284c + ", errorMsg :" + this.f68285d + ", intervalMs :" + this.f68288g + ", isNotify :" + this.f68286e + ", bodySize :" + this.f68287f.length;
    }
}
