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
/* loaded from: classes7.dex */
public final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c.a f35777a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35778b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f35779c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35780d;

    /* renamed from: e  reason: collision with root package name */
    public final BroadcastReceiver f35781e = new BroadcastReceiver() { // from class: com.kwad.sdk.glide.c.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f35778b;
            eVar.f35778b = eVar.a(context);
            if (z != e.this.f35778b) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f35778b);
                }
                e eVar2 = e.this;
                eVar2.f35777a.a(eVar2.f35778b);
            }
        }
    };

    public e(@NonNull Context context, @NonNull c.a aVar) {
        this.f35779c = context.getApplicationContext();
        this.f35777a = aVar;
    }

    private void a() {
        if (this.f35780d) {
            return;
        }
        this.f35778b = a(this.f35779c);
        try {
            this.f35779c.registerReceiver(this.f35781e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f35780d = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    private void b() {
        if (this.f35780d) {
            this.f35779c.unregisterReceiver(this.f35781e);
            this.f35780d = false;
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
