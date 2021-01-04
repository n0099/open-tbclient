package com.win.opensdk;

import android.content.Context;
/* loaded from: classes4.dex */
public class ao {
    private static ao qcS;
    public Context qbB;

    private ao() {
    }

    public static ao eJZ() {
        if (qcS == null) {
            synchronized (ao.class) {
                if (qcS == null) {
                    qcS = new ao();
                }
            }
        }
        return qcS;
    }
}
