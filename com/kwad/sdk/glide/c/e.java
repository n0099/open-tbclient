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
/* loaded from: classes6.dex */
public final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c.a f35098a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35099b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f35100c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35101d;

    /* renamed from: e  reason: collision with root package name */
    public final BroadcastReceiver f35102e = new BroadcastReceiver() { // from class: com.kwad.sdk.glide.c.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f35099b;
            eVar.f35099b = eVar.a(context);
            if (z != e.this.f35099b) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f35099b);
                }
                e eVar2 = e.this;
                eVar2.f35098a.a(eVar2.f35099b);
            }
        }
    };

    public e(@NonNull Context context, @NonNull c.a aVar) {
        this.f35100c = context.getApplicationContext();
        this.f35098a = aVar;
    }

    private void a() {
        if (this.f35101d) {
            return;
        }
        this.f35099b = a(this.f35100c);
        try {
            this.f35100c.registerReceiver(this.f35102e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f35101d = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    private void b() {
        if (this.f35101d) {
            this.f35100c.unregisterReceiver(this.f35102e);
            this.f35101d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.kwad.sdk.glide.g.j.a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
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
