package com.vivo.push.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class r implements Runnable {
    final /* synthetic */ InsideNotificationItem a;
    final /* synthetic */ com.vivo.push.b.q b;
    final /* synthetic */ boolean c;
    final /* synthetic */ q d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar2, boolean z) {
        this.d = qVar;
        this.a = insideNotificationItem;
        this.b = qVar2;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c;
        PushMessageCallback pushMessageCallback = this.d.c;
        context = this.d.a;
        if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.n.a(this.a))) {
            context2 = this.d.a;
            InsideNotificationItem insideNotificationItem = this.a;
            long f = this.b.f();
            PushMessageCallback pushMessageCallback2 = this.d.c;
            context3 = this.d.a;
            com.vivo.push.util.i iVar = new com.vivo.push.util.i(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3));
            String purePicUrl = this.a.getPurePicUrl();
            String coverUrl = TextUtils.isEmpty(purePicUrl) ? this.a.getCoverUrl() : purePicUrl;
            if (!TextUtils.isEmpty(coverUrl)) {
                com.vivo.push.util.m.c("OnNotificationArrivedTask", "showCode=" + this.c);
                if (!this.c) {
                    context5 = this.d.a;
                    com.vivo.push.util.m.a(context5, "mobile net unshow");
                    context6 = this.d.a;
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context6.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        c = 0;
                    } else if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                        c = 0;
                    } else {
                        int type = activeNetworkInfo.getType();
                        if (type == 1) {
                            c = 2;
                        } else {
                            c = type == 0 ? (char) 1 : (char) 3;
                        }
                    }
                    if (c == 1) {
                        coverUrl = null;
                        this.a.clearCoverUrl();
                        this.a.clearPurePicUrl();
                    }
                } else {
                    context4 = this.d.a;
                    com.vivo.push.util.m.a(context4, "mobile net show");
                }
            }
            iVar.execute(this.a.getIconUrl(), coverUrl);
            return;
        }
        com.vivo.push.util.m.d("OnNotificationArrivedTask", "this notification has Intercept");
    }
}
