package com.bytedance.tea.crash.g;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.os.Build;
/* loaded from: classes4.dex */
public class g {
    static final a pqo;

    /* loaded from: classes4.dex */
    private static class a {
        private a() {
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    @TargetApi(16)
    /* loaded from: classes4.dex */
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
            pqo = new b();
        } else {
            pqo = new a();
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return pqo.a(memoryInfo);
    }
}
