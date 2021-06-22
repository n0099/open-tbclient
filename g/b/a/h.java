package g.b.a;
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f71697a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f71698b;

    public static void a(h hVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int[] iArr = hVar.f71698b;
            byte[] bArr = hVar.f71697a;
            int i4 = i3 * 4;
            iArr[i3] = ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }
    }

    public static void b(h hVar, byte[] bArr, int[] iArr) {
        hVar.f71697a = bArr;
        hVar.f71698b = iArr;
    }
}
