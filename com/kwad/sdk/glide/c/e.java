package com.kwad.sdk.glide.c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.c.c;
/* loaded from: classes3.dex */
final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    final c.a f6587a;
    boolean b;
    private final Context c;
    private boolean d;
    private final BroadcastReceiver e = new BroadcastReceiver() { // from class: com.kwad.sdk.glide.c.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            boolean z = e.this.b;
            e.this.b = e.this.a(context);
            if (z != e.this.b) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.b);
                }
                e.this.f6587a.a(e.this.b);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(@NonNull Context context, @NonNull c.a aVar) {
        this.c = context.getApplicationContext();
        this.f6587a = aVar;
    }

    private void a() {
        if (this.d) {
            return;
        }
        this.b = a(this.c);
        try {
            this.c.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }

    private void b() {
        if (this.d) {
            this.c.unregisterReceiver(this.e);
            this.d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.kwad.sdk.glide.g.j.a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void c() {
        a();
    }

    @Override // com.kwad.sdk.glide.c.i
    public void d() {
        b();
    }

    @Override // com.kwad.sdk.glide.c.i
    public void e() {
    }
}
