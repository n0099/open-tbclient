package com.win.opensdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class ao {
    private static ao qkE;
    public Context qjn;

    private ao() {
    }

    public static ao eJl() {
        if (qkE == null) {
            synchronized (ao.class) {
                if (qkE == null) {
                    qkE = new ao();
                }
            }
        }
        return qkE;
    }
}
