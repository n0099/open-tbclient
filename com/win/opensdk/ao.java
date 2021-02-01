package com.win.opensdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class ao {
    private static ao qke;
    public Context qiN;

    private ao() {
    }

    public static ao eJd() {
        if (qke == null) {
            synchronized (ao.class) {
                if (qke == null) {
                    qke = new ao();
                }
            }
        }
        return qke;
    }
}
