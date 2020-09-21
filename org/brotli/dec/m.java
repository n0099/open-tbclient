package org.brotli.dec;
/* loaded from: classes15.dex */
final class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int OR(int i) {
        if (i >= 12) {
            return (i - 12) + 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int OS(int i) {
        if (i <= 9) {
            return (i - 1) + 1;
        }
        return 0;
    }
}
