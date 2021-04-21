package g.b.a;
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f68750a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f68751b;

    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int[] iArr = hVar.f68751b;
            byte[] bArr = hVar.f68750a;
            int i3 = i2 * 4;
            iArr[i2] = ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }
    }

    public static void b(h hVar, byte[] bArr, int[] iArr) {
        hVar.f68750a = bArr;
        hVar.f68751b = iArr;
    }
}
