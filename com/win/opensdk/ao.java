package com.win.opensdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class ao {
    private static ao pZZ;
    public Context pYI;

    private ao() {
    }

    public static ao eGN() {
        if (pZZ == null) {
            synchronized (ao.class) {
                if (pZZ == null) {
                    pZZ = new ao();
                }
            }
        }
        return pZZ;
    }
}
