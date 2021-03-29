package d.b.j.d.a;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public final b f63712a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63713b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f63714c;

    public f(b bVar) {
        this.f63712a = bVar;
        this.f63713b = bVar.a();
    }

    public abstract void a(boolean z, String str, byte[] bArr, byte[] bArr2);

    public abstract void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public abstract void c();

    public abstract void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public abstract void e();

    public void f(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        b(bArr, i, i2, bArr2, i3);
    }

    public abstract void g();

    public void h(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        d(bArr, i, i2, bArr2, i3);
    }
}
