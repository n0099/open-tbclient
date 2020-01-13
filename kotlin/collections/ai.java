package kotlin.collections;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ai extends ah {
    public static final int NB(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (i / 3) + i;
        }
        return Integer.MAX_VALUE;
    }
}
