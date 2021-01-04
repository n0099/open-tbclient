package com.bytedance.tea.crash.g;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Debug;
/* loaded from: classes4.dex */
public class b {
    static final a pqn;

    /* loaded from: classes4.dex */
    private static class a {
        private a() {
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    @TargetApi(19)
    /* renamed from: com.bytedance.tea.crash.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C1008b extends a {
        private C1008b() {
            super();
        }

        @Override // com.bytedance.tea.crash.g.b.a
        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.bytedance.tea.crash.g.b.a
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.bytedance.tea.crash.g.b.a
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            pqn = new C1008b();
        } else {
            pqn = new a();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return pqn.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return pqn.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return pqn.c(memoryInfo);
    }
}
