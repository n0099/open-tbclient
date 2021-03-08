package com.bytedance.tea.crash.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class a extends FileObserver {
    private final int b;
    private volatile boolean c;
    private final c pxX;

    public a(c cVar, String str, int i) {
        super(str, i);
        this.b = 5000;
        this.c = true;
        if (cVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.pxX = cVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.c && i == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.pxX != null) {
            this.c = false;
            this.pxX.k(200, "/data/anr/" + str, 80);
            getClass();
            new C1049a(5000).start();
        }
    }

    /* renamed from: com.bytedance.tea.crash.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private final class C1049a extends Thread {
        private int b;

        C1049a(int i) {
            this.b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.b);
            a.this.c = true;
        }
    }
}
