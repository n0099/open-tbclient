package kotlin.collections;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class ai extends ah {
    public static final int NK(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (i / 3) + i;
        }
        return Integer.MAX_VALUE;
    }
}
