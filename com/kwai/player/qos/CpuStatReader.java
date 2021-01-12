package com.kwai.player.qos;

import android.os.SystemClock;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class CpuStatReader {
    private static final String TAG = CpuStatReader.class.getName();
    private long lastGuestNicTime;
    private long lastGuestTime;
    private long lastIdleTime;
    private long lastIowaitTime;
    private long lastIrqTime;
    private long lastNiceTime;
    private long lastSoftirqTime;
    private long lastStealTime;
    private long lastSystemTime;
    private long lastUpdateInterval;
    private long lastUpdateTime;
    private long lastUserTime;
    private long[] stats = new long[10];
    private long[] lastStats = new long[10];
    private boolean lastReadSuccess = false;

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
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean readSystemStat(long[] jArr) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            String readLine = randomAccessFile.readLine();
            randomAccessFile.close();
            return parseSystemStat(readLine, jArr);
        } catch (IOException e) {
            e.printStackTrace();
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
                if (this.lastStats[0] != 0) {
                    this.lastUserTime = this.stats[0] - this.lastStats[0];
                    this.lastNiceTime = this.stats[1] - this.lastStats[1];
                    this.lastSystemTime = this.stats[2] - this.lastStats[2];
                    this.lastIdleTime = this.stats[3] - this.lastStats[3];
                    this.lastIowaitTime = this.stats[4] - this.lastStats[4];
                    this.lastIrqTime = this.stats[5] - this.lastStats[5];
                    this.lastSoftirqTime = this.stats[6] - this.lastStats[6];
                    this.lastStealTime = this.stats[7] - this.lastStats[7];
                    this.lastGuestTime = this.stats[8] - this.lastStats[8];
                    this.lastGuestNicTime = this.stats[9] - this.lastStats[9];
                    this.lastReadSuccess = true;
                    this.lastUpdateInterval = elapsedRealtime - this.lastUpdateTime;
                }
                this.lastUpdateTime = SystemClock.elapsedRealtime();
                System.arraycopy(this.stats, 0, this.lastStats, 0, 10);
            }
        }
    }
}
