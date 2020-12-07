package com.vivo.push.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes11.dex */
final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f4436a;
    final /* synthetic */ com.vivo.push.b.s b;
    final /* synthetic */ r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.s sVar) {
        this.c = rVar;
        this.f4436a = insideNotificationItem;
        this.b = sVar;
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
        context = this.c.f4484a;
        if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f4436a))) {
            context2 = this.c.f4484a;
            InsideNotificationItem insideNotificationItem = this.f4436a;
            long f = this.b.f();
            PushMessageCallback pushMessageCallback2 = this.c.b;
            context3 = this.c.f4484a;
            com.vivo.push.util.l lVar = new com.vivo.push.util.l(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3));
            boolean isShowBigPicOnMobileNet = this.f4436a.isShowBigPicOnMobileNet();
            String purePicUrl = this.f4436a.getPurePicUrl();
            String coverUrl = TextUtils.isEmpty(purePicUrl) ? this.f4436a.getCoverUrl() : purePicUrl;
            if (!TextUtils.isEmpty(coverUrl)) {
                com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=" + isShowBigPicOnMobileNet);
                if (!isShowBigPicOnMobileNet) {
                    context5 = this.c.f4484a;
                    com.vivo.push.util.p.a(context5, "mobile net unshow");
                    context6 = this.c.f4484a;
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
                        this.f4436a.clearCoverUrl();
                        this.f4436a.clearPurePicUrl();
                    }
                } else {
                    context4 = this.c.f4484a;
                    com.vivo.push.util.p.a(context4, "mobile net show");
                }
            }
            lVar.execute(this.f4436a.getIconUrl(), coverUrl);
            return;
        }
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "this notification has Intercept");
    }
}
