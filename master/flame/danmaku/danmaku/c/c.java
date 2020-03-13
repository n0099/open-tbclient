package master.flame.danmaku.danmaku.c;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class c {
    public static final long dMQ() {
        return SystemClock.elapsedRealtime();
    }

    public static final void hp(long j) {
        SystemClock.sleep(j);
    }
}
