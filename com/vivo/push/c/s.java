package com.vivo.push.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f13623a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.s f13624b;
    final /* synthetic */ r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.s sVar) {
        this.c = rVar;
        this.f13623a = insideNotificationItem;
        this.f13624b = sVar;
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
        PushMessageCallback pushMessageCallback = this.c.f13604b;
        context = this.c.f13711a;
        if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f13623a))) {
            context2 = this.c.f13711a;
            InsideNotificationItem insideNotificationItem = this.f13623a;
            long f = this.f13624b.f();
            PushMessageCallback pushMessageCallback2 = this.c.f13604b;
            context3 = this.c.f13711a;
            com.vivo.push.util.l lVar = new com.vivo.push.util.l(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3));
            boolean isShowBigPicOnMobileNet = this.f13623a.isShowBigPicOnMobileNet();
            String purePicUrl = this.f13623a.getPurePicUrl();
            String coverUrl = TextUtils.isEmpty(purePicUrl) ? this.f13623a.getCoverUrl() : purePicUrl;
            if (!TextUtils.isEmpty(coverUrl)) {
                com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=" + isShowBigPicOnMobileNet);
                if (!isShowBigPicOnMobileNet) {
                    context5 = this.c.f13711a;
                    com.vivo.push.util.p.a(context5, "mobile net unshow");
                    context6 = this.c.f13711a;
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
                        this.f13623a.clearCoverUrl();
                        this.f13623a.clearPurePicUrl();
                    }
                } else {
                    context4 = this.c.f13711a;
                    com.vivo.push.util.p.a(context4, "mobile net show");
                }
            }
            lVar.execute(this.f13623a.getIconUrl(), coverUrl);
            return;
        }
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "this notification has Intercept");
    }
}
