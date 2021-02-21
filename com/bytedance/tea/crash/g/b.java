package com.bytedance.tea.crash.g;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Debug;
/* loaded from: classes6.dex */
public class b {
    static final a pwy;

    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    private static class C1035b extends a {
        private C1035b() {
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
            pwy = new C1035b();
        } else {
            pwy = new a();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return pwy.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return pwy.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return pwy.c(memoryInfo);
    }
}
