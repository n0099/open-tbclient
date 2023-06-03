package org.chromium.base.memory;

import android.os.Debug;
import java.io.IOException;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
/* loaded from: classes2.dex */
public final class JavaHeapDumpGenerator {
    public static final String TAG = "JavaHprofGenerator";

    @CalledByNative
    public static boolean generateHprof(String str) {
        try {
            Debug.dumpHprofData(str);
            return true;
        } catch (IOException e) {
            Log.i(TAG, "Error writing to file " + str + ". Error: " + e.getMessage(), new Object[0]);
            return false;
        }
    }
}
