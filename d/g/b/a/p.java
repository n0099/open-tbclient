package d.g.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes6.dex */
public final class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f70051a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f70052b;

    public p(l lVar, m mVar) {
        this.f70052b = lVar;
        this.f70051a = mVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if ("com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) && extras != null && extras.containsKey("install.status")) {
            this.f70052b.p();
            int i2 = extras.getInt("install.status");
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                this.f70051a.a(com.google.ar.core.p.ACCEPTED);
            } else if (i2 == 4) {
                this.f70051a.a(com.google.ar.core.p.COMPLETED);
            } else if (i2 != 6) {
            } else {
                this.f70051a.a(com.google.ar.core.p.CANCELLED);
            }
        }
    }
}
