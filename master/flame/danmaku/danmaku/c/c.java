package master.flame.danmaku.danmaku.c;

import android.os.SystemClock;
/* loaded from: classes4.dex */
public class c {
    public static final long dLy() {
        return SystemClock.elapsedRealtime();
    }

    public static final void hr(long j) {
        SystemClock.sleep(j);
    }
}
