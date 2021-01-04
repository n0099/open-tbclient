package com.vivo.push.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f13920a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.s f13921b;
    final /* synthetic */ r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.s sVar) {
        this.c = rVar;
        this.f13920a = insideNotificationItem;
        this.f13921b = sVar;
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
        PushMessageCallback pushMessageCallback = this.c.f13901b;
        context = this.c.f14008a;
        if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f13920a))) {
            context2 = this.c.f14008a;
            InsideNotificationItem insideNotificationItem = this.f13920a;
            long f = this.f13921b.f();
            PushMessageCallback pushMessageCallback2 = this.c.f13901b;
            context3 = this.c.f14008a;
            com.vivo.push.util.l lVar = new com.vivo.push.util.l(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3));
            boolean isShowBigPicOnMobileNet = this.f13920a.isShowBigPicOnMobileNet();
            String purePicUrl = this.f13920a.getPurePicUrl();
            String coverUrl = TextUtils.isEmpty(purePicUrl) ? this.f13920a.getCoverUrl() : purePicUrl;
            if (!TextUtils.isEmpty(coverUrl)) {
                com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=" + isShowBigPicOnMobileNet);
                if (!isShowBigPicOnMobileNet) {
                    context5 = this.c.f14008a;
                    com.vivo.push.util.p.a(context5, "mobile net unshow");
                    context6 = this.c.f14008a;
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
                        this.f13920a.clearCoverUrl();
                        this.f13920a.clearPurePicUrl();
                    }
                } else {
                    context4 = this.c.f14008a;
                    com.vivo.push.util.p.a(context4, "mobile net show");
                }
            }
            lVar.execute(this.f13920a.getIconUrl(), coverUrl);
            return;
        }
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "this notification has Intercept");
    }
}
