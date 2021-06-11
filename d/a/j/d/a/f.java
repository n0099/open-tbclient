package d.a.j.d.a;
/* loaded from: classes2.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public final b f43857a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43858b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f43859c;

    public f(b bVar) {
        this.f43857a = bVar;
        this.f43858b = bVar.a();
    }

    public abstract void a(boolean z, String str, byte[] bArr, byte[] bArr2);

    public abstract void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4);

    public abstract void c();

    public abstract void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4);

    public abstract void e();

    public void f(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        b(bArr, i2, i3, bArr2, i4);
    }

    public abstract void g();

    public void h(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        d(bArr, i2, i3, bArr2, i4);
    }
}
