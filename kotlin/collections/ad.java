package kotlin.collections;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ad extends ac {
    public static final int Df(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (i / 3) + i;
        }
        return Integer.MAX_VALUE;
    }
}
