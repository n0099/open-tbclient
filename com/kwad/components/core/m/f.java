package com.kwad.components.core.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.kwad.sdk.utils.bg;
/* loaded from: classes10.dex */
public final class f implements bg.a {
    public a IV;
    public BroadcastReceiver IW = new BroadcastReceiver() { // from class: com.kwad.components.core.m.f.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            Message obtainMessage = f.this.mHandler.obtainMessage(242);
            obtainMessage.obj = schemeSpecificPart;
            obtainMessage.sendToTarget();
        }
    };
    public Handler mHandler = new bg(this);
    public String targetPackage;

    /* loaded from: classes10.dex */
    public interface a {
        void gW();
    }

    public f(String str) {
        this.targetPackage = str;
    }

    public final void a(Context context, a aVar) {
        if (context == null) {
            return;
        }
        this.IV = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        try {
            context.registerReceiver(this.IW, intentFilter);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        Object obj;
        a aVar;
        if (message.what != 242 || (obj = message.obj) == null || !obj.equals(this.targetPackage) || (aVar = this.IV) == null) {
            return;
        }
        aVar.gW();
    }

    public final void au(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this.IW);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
        this.IV = null;
    }

    public final void aw(String str) {
        this.targetPackage = str;
    }
}
