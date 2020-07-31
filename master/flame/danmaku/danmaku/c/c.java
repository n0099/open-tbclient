package master.flame.danmaku.danmaku.c;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public class c {
    public static final long dWB() {
        return SystemClock.elapsedRealtime();
    }

    public static final void gK(long j) {
        SystemClock.sleep(j);
    }
}
