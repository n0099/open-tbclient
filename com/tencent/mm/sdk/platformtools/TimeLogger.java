package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TimeLogger {
    private String bg;
    private String bh;
    private boolean bi;
    ArrayList bj;
    ArrayList bk;

    public TimeLogger(String str, String str2) {
        reset(str, str2);
    }

    public void addSplit(String str) {
        if (this.bi) {
            return;
        }
        this.bj.add(Long.valueOf(SystemClock.elapsedRealtime()));
        this.bk.add(str);
    }

    public void dumpToLog() {
        long longValue;
        if (this.bi) {
            return;
        }
        Log.d(this.bg, this.bh + ": begin");
        int i = 1;
        long longValue2 = ((Long) this.bj.get(0)).longValue();
        while (i < this.bj.size()) {
            long longValue3 = ((Long) this.bj.get(i)).longValue();
            long longValue4 = ((Long) this.bj.get(i - 1)).longValue();
            Log.d(this.bg, this.bh + ":      " + (longValue3 - longValue4) + " ms, " + ((String) this.bk.get(i)));
            i++;
            longValue2 = longValue3;
        }
        Log.d(this.bg, this.bh + ": end, " + (longValue2 - longValue) + " ms");
    }

    public void reset() {
        this.bi = false;
        if (this.bi) {
            return;
        }
        if (this.bj == null) {
            this.bj = new ArrayList();
            this.bk = new ArrayList();
        } else {
            this.bj.clear();
            this.bk.clear();
        }
        addSplit(null);
    }

    public void reset(String str, String str2) {
        this.bg = str;
        this.bh = str2;
        reset();
    }
}
