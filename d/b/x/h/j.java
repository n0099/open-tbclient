package d.b.x.h;
/* loaded from: classes2.dex */
public class j {
    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
