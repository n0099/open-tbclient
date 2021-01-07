package com.win.opensdk;

import android.content.Context;
/* loaded from: classes4.dex */
public class ao {
    private static ao qeA;
    public Context qdj;

    private ao() {
    }

    public static ao eKD() {
        if (qeA == null) {
            synchronized (ao.class) {
                if (qeA == null) {
                    qeA = new ao();
                }
            }
        }
        return qeA;
    }
}
