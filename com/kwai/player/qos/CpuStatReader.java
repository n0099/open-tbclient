package com.kwai.player.qos;

import android.os.SystemClock;
import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class CpuStatReader {
    public static final String TAG = "com.kwai.player.qos.CpuStatReader";
    public long lastGuestNicTime;
    public long lastGuestTime;
    public long lastIdleTime;
    public long lastIowaitTime;
    public long lastIrqTime;
    public long lastNiceTime;
    public long lastSoftirqTime;
    public long lastStealTime;
    public long lastSystemTime;
    public long lastUpdateInterval;
    public long lastUpdateTime;
    public long lastUserTime;
    public long[] stats = new long[10];
    public long[] lastStats = new long[10];
    public boolean lastReadSuccess = false;

    public CpuStatReader() {
        update();
    }

    private boolean parseSystemStat(String str, long[] jArr) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\s+");
        for (int i = 1; i <= 10; i++) {
            try {
                jArr[i - 1] = Long.parseLong(split[i]);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean readSystemStat(long[] jArr) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", r.f7699a);
            String readLine = randomAccessFile.readLine();
            randomAccessFile.close();
            return parseSystemStat(readLine, jArr);
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public long getLastGuestNicTime() {
        return this.lastGuestNicTime;
    }

    public long getLastGuestTime() {
        return this.lastGuestTime;
    }

    public long getLastIdleTime() {
        return this.lastIdleTime;
    }

    public long getLastIowaitTime() {
        return this.lastIowaitTime;
    }

    public long getLastIrqTime() {
        return this.lastIrqTime;
    }

    public long getLastNiceTime() {
        return this.lastNiceTime;
    }

    public boolean getLastReadSuccess() {
        return this.lastReadSuccess;
    }

    public long getLastSoftirqTime() {
        return this.lastSoftirqTime;
    }

    public long getLastStealTime() {
        return this.lastStealTime;
    }

    public long getLastSystemTime() {
        return this.lastSystemTime;
    }

    public long getLastTotalTime() {
        return this.lastUserTime + this.lastNiceTime + this.lastSystemTime + this.lastIdleTime + this.lastIowaitTime + this.lastIrqTime + this.lastSoftirqTime + this.lastStealTime + this.lastGuestTime + this.lastGuestNicTime;
    }

    public long getLastUpdateInterval() {
        return this.lastUpdateInterval;
    }

    public long getLastUserTime() {
        return this.lastUserTime;
    }

    public void update() {
        boolean z;
        this.lastReadSuccess = false;
        if (readSystemStat(this.stats)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = 0;
            while (true) {
                if (i >= 10) {
                    z = true;
                    break;
                } else if (this.stats[i] < this.lastStats[i]) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                long[] jArr = this.lastStats;
                if (jArr[0] != 0) {
                    long[] jArr2 = this.stats;
                    this.lastUserTime = jArr2[0] - jArr[0];
                    this.lastNiceTime = jArr2[1] - jArr[1];
                    this.lastSystemTime = jArr2[2] - jArr[2];
                    this.lastIdleTime = jArr2[3] - jArr[3];
                    this.lastIowaitTime = jArr2[4] - jArr[4];
                    this.lastIrqTime = jArr2[5] - jArr[5];
                    this.lastSoftirqTime = jArr2[6] - jArr[6];
                    this.lastStealTime = jArr2[7] - jArr[7];
                    this.lastGuestTime = jArr2[8] - jArr[8];
                    this.lastGuestNicTime = jArr2[9] - jArr[9];
                    this.lastReadSuccess = true;
                    this.lastUpdateInterval = elapsedRealtime - this.lastUpdateTime;
                }
                this.lastUpdateTime = SystemClock.elapsedRealtime();
                System.arraycopy(this.stats, 0, this.lastStats, 0, 10);
            }
        }
    }
}
