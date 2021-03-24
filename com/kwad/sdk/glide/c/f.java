package com.kwad.sdk.glide.c;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwad.sdk.glide.c.c;
/* loaded from: classes6.dex */
public class f implements d {
    @Override // com.kwad.sdk.glide.c.d
    @NonNull
    public c a(@NonNull Context context, @NonNull c.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new e(context, aVar) : new j();
    }
}
