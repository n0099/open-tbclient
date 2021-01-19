package com.bytedance.tea.crash.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class a extends FileObserver {

    /* renamed from: b  reason: collision with root package name */
    private final int f7610b;
    private volatile boolean c;
    private final c plf;

    public a(c cVar, String str, int i) {
        super(str, i);
        this.f7610b = 5000;
        this.c = true;
        if (cVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.plf = cVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.c && i == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.plf != null) {
            this.c = false;
            this.plf.a(200, "/data/anr/" + str, 80);
            getClass();
            new C1028a(5000).start();
        }
    }

    /* renamed from: com.bytedance.tea.crash.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private final class C1028a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private int f7611b;

        C1028a(int i) {
            this.f7611b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f7611b);
            a.this.c = true;
        }
    }
}
