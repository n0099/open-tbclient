package okhttp3.internal.http2;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class Settings {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Settings set(int i, int i2) {
        if (i >= 0 && i < this.values.length) {
            this.set = (1 << i) | this.set;
            this.values[i] = i2;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int get(int i) {
        return this.values[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return Integer.bitCount(this.set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHeaderTableSize() {
        if ((2 & this.set) != 0) {
            return this.values[1];
        }
        return -1;
    }

    boolean getEnablePush(boolean z) {
        return ((4 & this.set) != 0 ? this.values[2] : z ? 1 : 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxConcurrentStreams(int i) {
        return (16 & this.set) != 0 ? this.values[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxFrameSize(int i) {
        return (32 & this.set) != 0 ? this.values[5] : i;
    }

    int getMaxHeaderListSize(int i) {
        return (64 & this.set) != 0 ? this.values[6] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getInitialWindowSize() {
        if ((128 & this.set) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void merge(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.isSet(i)) {
                set(i, settings.get(i));
            }
        }
    }
}
