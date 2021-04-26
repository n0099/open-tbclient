package okhttp3.internal.http2;

import java.util.Arrays;
/* loaded from: classes7.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    public int set;
    public final int[] values = new int[10];

    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    public int get(int i2) {
        return this.values[i2];
    }

    public boolean getEnablePush(boolean z) {
        return ((this.set & 4) != 0 ? this.values[2] : z ? 1 : 0) == 1;
    }

    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public int getMaxConcurrentStreams(int i2) {
        return (this.set & 16) != 0 ? this.values[4] : i2;
    }

    public int getMaxFrameSize(int i2) {
        return (this.set & 32) != 0 ? this.values[5] : i2;
    }

    public int getMaxHeaderListSize(int i2) {
        return (this.set & 64) != 0 ? this.values[6] : i2;
    }

    public boolean isSet(int i2) {
        return ((1 << i2) & this.set) != 0;
    }

    public void merge(Settings settings) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (settings.isSet(i2)) {
                set(i2, settings.get(i2));
            }
        }
    }

    public Settings set(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.values;
            if (i2 < iArr.length) {
                this.set = (1 << i2) | this.set;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    public int size() {
        return Integer.bitCount(this.set);
    }
}
