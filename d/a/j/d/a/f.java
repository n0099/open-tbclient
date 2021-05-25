package d.a.j.d.a;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public final b f40176a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40177b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f40178c;

    public f(b bVar) {
        this.f40176a = bVar;
        this.f40177b = bVar.a();
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
