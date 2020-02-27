package com.vivo.push.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes8.dex */
final class r implements Runnable {
    final /* synthetic */ InsideNotificationItem a;
    final /* synthetic */ com.vivo.push.b.q b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar2) {
        this.c = qVar;
        this.a = insideNotificationItem;
        this.b = qVar2;
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
        PushMessageCallback pushMessageCallback = this.c.b;
        context = this.c.a;
        if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.a))) {
            context2 = this.c.a;
            InsideNotificationItem insideNotificationItem = this.a;
            long f = this.b.f();
            PushMessageCallback pushMessageCallback2 = this.c.b;
            context3 = this.c.a;
            com.vivo.push.util.l lVar = new com.vivo.push.util.l(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3));
            boolean isShowBigPicOnMobileNet = this.a.isShowBigPicOnMobileNet();
            String purePicUrl = this.a.getPurePicUrl();
            String coverUrl = TextUtils.isEmpty(purePicUrl) ? this.a.getCoverUrl() : purePicUrl;
            if (!TextUtils.isEmpty(coverUrl)) {
                com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=" + isShowBigPicOnMobileNet);
                if (!isShowBigPicOnMobileNet) {
                    context5 = this.c.a;
                    com.vivo.push.util.p.a(context5, "mobile net unshow");
                    context6 = this.c.a;
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
                    context4 = this.c.a;
                    com.vivo.push.util.p.a(context4, "mobile net show");
                }
            }
            lVar.execute(this.a.getIconUrl(), coverUrl);
            return;
        }
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "this notification has Intercept");
    }
}
