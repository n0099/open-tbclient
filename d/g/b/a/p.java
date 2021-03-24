package d.g.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes6.dex */
public final class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f66079a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f66080b;

    public p(l lVar, m mVar) {
        this.f66080b = lVar;
        this.f66079a = mVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if ("com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) && extras != null && extras.containsKey("install.status")) {
            this.f66080b.p();
            int i = extras.getInt("install.status");
            if (i == 1 || i == 2 || i == 3) {
                this.f66079a.a(com.google.ar.core.p.ACCEPTED);
            } else if (i == 4) {
                this.f66079a.a(com.google.ar.core.p.COMPLETED);
            } else if (i != 6) {
            } else {
                this.f66079a.a(com.google.ar.core.p.CANCELLED);
            }
        }
    }
}
