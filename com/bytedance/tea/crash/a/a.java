package com.bytedance.tea.crash.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class a extends FileObserver {

    /* renamed from: b  reason: collision with root package name */
    private final int f7910b;
    private volatile boolean c;
    private final c ppK;

    public a(c cVar, String str, int i) {
        super(str, i);
        this.f7910b = 5000;
        this.c = true;
        if (cVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.ppK = cVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.c && i == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.ppK != null) {
            this.c = false;
            this.ppK.a(200, "/data/anr/" + str, 80);
            getClass();
            new C1045a(5000).start();
        }
    }

    /* renamed from: com.bytedance.tea.crash.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private final class C1045a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private int f7911b;

        C1045a(int i) {
            this.f7911b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f7911b);
            a.this.c = true;
        }
    }
}
