package d.g.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes6.dex */
public final class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f65487a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f65488b;

    public p(l lVar, m mVar) {
        this.f65488b = lVar;
        this.f65487a = mVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if ("com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) && extras != null && extras.containsKey("install.status")) {
            this.f65488b.p();
            int i2 = extras.getInt("install.status");
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                this.f65487a.a(com.google.ar.core.p.ACCEPTED);
            } else if (i2 == 4) {
                this.f65487a.a(com.google.ar.core.p.COMPLETED);
            } else if (i2 != 6) {
            } else {
                this.f65487a.a(com.google.ar.core.p.CANCELLED);
            }
        }
    }
}
