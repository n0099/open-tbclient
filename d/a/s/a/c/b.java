package d.a.s.a.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f63879a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public long f63880b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public int f63881c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f63882d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f63883e = false;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f63884f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public long f63885g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public long f63886h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f63887i = -1;
    public int j = -1;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public long n = -1;
    public boolean o = false;

    public String toString() {
        if (this.m) {
            return "Request correlationId :" + this.n + ", serviceId :" + this.f63886h + ", methodId :" + this.f63887i + ", connectState :" + this.j + ", isNotify :" + this.f63883e + ", bodySize :" + this.f63879a.length + ", request :" + new String(this.f63879a);
        }
        return "Response correlationId " + this.n + ", serviceId :" + this.f63886h + ", methodId :" + this.f63887i + ", errorCode :" + this.f63881c + ", errorMsg :" + this.f63882d + ", intervalMs :" + this.f63885g + ", isNotify :" + this.f63883e + ", bodySize :" + this.f63884f.length + ", response :" + new String(this.f63884f);
    }
}
