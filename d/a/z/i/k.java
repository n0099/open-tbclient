package d.a.z.i;
/* loaded from: classes2.dex */
public class k {
    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
