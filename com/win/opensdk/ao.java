package com.win.opensdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class ao {
    private static ao qaa;
    public Context pYJ;

    private ao() {
    }

    public static ao eGN() {
        if (qaa == null) {
            synchronized (ao.class) {
                if (qaa == null) {
                    qaa = new ao();
                }
            }
        }
        return qaa;
    }
}
