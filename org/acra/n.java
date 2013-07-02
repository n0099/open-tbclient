package org.acra;

import android.content.Context;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends Thread {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Looper.prepare();
        context = this.a.b;
        org.acra.util.i.a(context, a.d().B(), 1);
        Looper.loop();
    }
}
