package com.kwad.components.core.webview.jshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class o implements com.kwad.sdk.core.webview.c.a {
    public BroadcastReceiver VQ = new BroadcastReceiver() { // from class: com.kwad.components.core.webview.jshandler.o.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("data");
            if (!TextUtils.isEmpty(stringExtra)) {
                a aVar = new a();
                aVar.message = stringExtra;
                o.this.nr.a(aVar);
            }
        }
    };
    public com.kwad.sdk.core.webview.c.c nr;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String message;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "onMessage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        LocalBroadcastManager.getInstance(ServiceProvider.getContext()).unregisterReceiver(this.VQ);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nr = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ksad_webView_local_broadcast");
        LocalBroadcastManager.getInstance(ServiceProvider.getContext()).registerReceiver(this.VQ, intentFilter);
        cVar.a(null);
    }
}
