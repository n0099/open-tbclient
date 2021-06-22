package com.vivo.push.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InsideNotificationItem f40384a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.s f40385b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f40386c;

    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.s sVar) {
        this.f40386c = rVar;
        this.f40384a = insideNotificationItem;
        this.f40385b = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c2;
        r rVar = this.f40386c;
        PushMessageCallback pushMessageCallback = ((ab) rVar).f40352b;
        context = rVar.f40534a;
        if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f40384a))) {
            context2 = this.f40386c.f40534a;
            InsideNotificationItem insideNotificationItem = this.f40384a;
            long f2 = this.f40385b.f();
            r rVar2 = this.f40386c;
            PushMessageCallback pushMessageCallback2 = ((ab) rVar2).f40352b;
            context3 = rVar2.f40534a;
            com.vivo.push.util.l lVar = new com.vivo.push.util.l(context2, insideNotificationItem, f2, pushMessageCallback2.isAllowNet(context3));
            boolean isShowBigPicOnMobileNet = this.f40384a.isShowBigPicOnMobileNet();
            String purePicUrl = this.f40384a.getPurePicUrl();
            if (TextUtils.isEmpty(purePicUrl)) {
                purePicUrl = this.f40384a.getCoverUrl();
            }
            if (!TextUtils.isEmpty(purePicUrl)) {
                com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=" + isShowBigPicOnMobileNet);
                if (!isShowBigPicOnMobileNet) {
                    context5 = this.f40386c.f40534a;
                    com.vivo.push.util.p.a(context5, "mobile net unshow");
                    context6 = this.f40386c.f40534a;
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context6.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        int type = activeNetworkInfo.getType();
                        c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                    } else {
                        c2 = 0;
                    }
                    if (c2 == 1) {
                        purePicUrl = null;
                        this.f40384a.clearCoverUrl();
                        this.f40384a.clearPurePicUrl();
                    }
                } else {
                    context4 = this.f40386c.f40534a;
                    com.vivo.push.util.p.a(context4, "mobile net show");
                }
            }
            lVar.execute(this.f40384a.getIconUrl(), purePicUrl);
            return;
        }
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "this notification has Intercept");
    }
}
