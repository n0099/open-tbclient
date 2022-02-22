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
/* loaded from: classes4.dex */
public class e implements bc.a {

    /* renamed from: b  reason: collision with root package name */
    public a f58148b;

    /* renamed from: c  reason: collision with root package name */
    public String f58149c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f58150d = new BroadcastReceiver() { // from class: com.kwad.sdk.utils.e.1
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

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str);
    }

    public e(String str) {
        this.f58149c = str;
    }

    public void a(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this.f58150d);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        this.f58148b = null;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            return;
        }
        this.f58148b = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        context.registerReceiver(this.f58150d, intentFilter);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        Object obj;
        a aVar;
        if (message.what != 242 || (obj = message.obj) == null || !obj.equals(this.f58149c) || (aVar = this.f58148b) == null) {
            return;
        }
        aVar.a(this.f58149c);
    }

    public void a(String str) {
        this.f58149c = str;
    }
}
