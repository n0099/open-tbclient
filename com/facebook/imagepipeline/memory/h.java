package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class h {
    public static r eyG() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(1024, 5);
        sparseIntArray.put(2048, 5);
        sparseIntArray.put(4096, 5);
        sparseIntArray.put(8192, 5);
        sparseIntArray.put(16384, 5);
        sparseIntArray.put(32768, 5);
        sparseIntArray.put(65536, 5);
        sparseIntArray.put(131072, 5);
        sparseIntArray.put(262144, 2);
        sparseIntArray.put(524288, 2);
        sparseIntArray.put(1048576, 2);
        return new r(eyH(), eyA(), sparseIntArray);
    }

    private static int eyH() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 3145728;
        }
        if (min < 33554432) {
            return TbConfig.THREAD_GIF_MIN_USE_MEMORY;
        }
        return 12582912;
    }

    private static int eyA() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return min < 16777216 ? min / 2 : (min / 4) * 3;
    }
}
