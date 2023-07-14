package com.yy.transvod.p2p;

import android.util.Log;
import com.baidu.tieba.iwb;
import com.yy.transvod.player.log.TLog;
/* loaded from: classes10.dex */
public class P2pManager {
    public static native void nativeClassInit();

    private native boolean nativeIsInited();

    private native void nativeSetAppId(long j, String str);

    private native void nativeSetParameter(long j, String str);

    private native void nativeSetShareStatsEnable(boolean z);

    private native void nativeSetup();

    private native void nativeUpdateAccountInfo(long j, AccountInfo accountInfo);

    static {
        if (iwb.b()) {
            try {
                Log.i("P2pManager", "loadLibrary: transvod_p2p");
                nativeClassInit();
                AccountInfo.nativeClassInit();
            } catch (UnsatisfiedLinkError e) {
                TLog.d("P2pManager", "LoadLibrary failed, UnsatisfiedLinkError " + e.getMessage());
            }
        }
    }

    public P2pManager() {
        nativeSetup();
        TLog.h("P2pManager", "P2pManager begin");
    }
}
