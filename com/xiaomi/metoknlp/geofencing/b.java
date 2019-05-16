package com.xiaomi.metoknlp.geofencing;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.xiaomi.metoknlp.geofencing.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b implements ServiceConnection {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.v("GeoFencingServiceWrapper", "*** GeoFencingService connected ***");
        this.a.b = c.a.a(iBinder);
        if (this.a.g != null) {
            this.a.g.sendEmptyMessage(3);
            this.a.g.sendEmptyMessageDelayed(2, 60000L);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.v("GeoFencingServiceWrapper", "*** GeoFencingService disconnected ***");
        this.a.b = null;
    }
}
