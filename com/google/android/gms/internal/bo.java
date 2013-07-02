package com.google.android.gms.internal;

import android.net.LocalSocket;
import com.google.android.gms.games.RealTimeSocket;
/* loaded from: classes.dex */
final class bo implements RealTimeSocket {
    private final LocalSocket a;

    public void a() {
        this.a.close();
    }
}
