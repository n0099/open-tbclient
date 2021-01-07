package org.brotli.dec;
/* loaded from: classes5.dex */
final class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int TO(int i) {
        if (i >= 12) {
            return (i - 12) + 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int TP(int i) {
        if (i <= 9) {
            return (i - 1) + 1;
        }
        return 0;
    }
}
