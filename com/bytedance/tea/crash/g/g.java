package com.bytedance.tea.crash.g;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.os.Build;
/* loaded from: classes6.dex */
public class g {
    static final a pyC;

    /* loaded from: classes6.dex */
    private static class a {
        private a() {
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    @TargetApi(16)
    /* loaded from: classes6.dex */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.bytedance.tea.crash.g.g.a
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            pyC = new b();
        } else {
            pyC = new a();
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return pyC.a(memoryInfo);
    }
}
