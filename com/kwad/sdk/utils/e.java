package com.kwad.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.kwad.sdk.utils.bc;
/* loaded from: classes3.dex */
public class e implements bc.a {

    /* renamed from: b  reason: collision with root package name */
    public a f60222b;

    /* renamed from: c  reason: collision with root package name */
    public String f60223c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f60224d = new BroadcastReceiver() { // from class: com.kwad.sdk.utils.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            Message obtainMessage = e.this.a.obtainMessage(242);
            obtainMessage.obj = schemeSpecificPart;
            obtainMessage.sendToTarget();
        }
    };
    public Handler a = new bc(this);

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str);
    }

    public e(String str) {
        this.f60223c = str;
    }

    public void a(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this.f60224d);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        this.f60222b = null;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            return;
        }
        this.f60222b = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        context.registerReceiver(this.f60224d, intentFilter);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        Object obj;
        a aVar;
        if (message.what != 242 || (obj = message.obj) == null || !obj.equals(this.f60223c) || (aVar = this.f60222b) == null) {
            return;
        }
        aVar.a(this.f60223c);
    }

    public void a(String str) {
        this.f60223c = str;
    }
}
