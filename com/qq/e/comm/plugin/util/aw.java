package com.qq.e.comm.plugin.util;

import android.os.SystemClock;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public final class aw {

    /* renamed from: a  reason: collision with root package name */
    private final int f12865a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12866b;
    private int c;
    private int d;
    private long e = -1;
    private final String f;

    public aw(int i, int i2, String str) {
        this.f12865a = i;
        this.f12866b = i2;
        this.f = str;
        this.c = this.f12865a;
        this.d = this.f12865a;
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        if (this.e == -1) {
            this.e = SystemClock.elapsedRealtime();
            return false;
        }
        int integer = GDTADManager.getInstance().getSM().getInteger(this.f, this.f12865a);
        if (integer != this.c) {
            if (integer < this.f12866b) {
                integer = this.f12866b;
            }
            GDTLogger.d("throttling new value:" + integer + " old:" + this.c);
            this.e = SystemClock.elapsedRealtime();
            this.c = integer;
            this.d = this.c;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.e;
        this.e = elapsedRealtime;
        double d = (elapsedRealtime - j) * (this.c / 60000.0d);
        GDTLogger.d("throttling old:" + this.d + " increase:" + d);
        this.d = (int) (d + this.d);
        if (this.d > this.c) {
            this.d = this.c;
        }
        if (this.d < 1) {
            return true;
        }
        this.d--;
        return false;
    }
}
