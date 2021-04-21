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
    public final /* synthetic */ InsideNotificationItem f39825a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.s f39826b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f39827c;

    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.s sVar) {
        this.f39827c = rVar;
        this.f39825a = insideNotificationItem;
        this.f39826b = sVar;
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
        r rVar = this.f39827c;
        PushMessageCallback pushMessageCallback = ((ab) rVar).f39793b;
        context = rVar.f39973a;
        if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f39825a))) {
            context2 = this.f39827c.f39973a;
            InsideNotificationItem insideNotificationItem = this.f39825a;
            long f2 = this.f39826b.f();
            r rVar2 = this.f39827c;
            PushMessageCallback pushMessageCallback2 = ((ab) rVar2).f39793b;
            context3 = rVar2.f39973a;
            com.vivo.push.util.l lVar = new com.vivo.push.util.l(context2, insideNotificationItem, f2, pushMessageCallback2.isAllowNet(context3));
            boolean isShowBigPicOnMobileNet = this.f39825a.isShowBigPicOnMobileNet();
            String purePicUrl = this.f39825a.getPurePicUrl();
            if (TextUtils.isEmpty(purePicUrl)) {
                purePicUrl = this.f39825a.getCoverUrl();
            }
            if (!TextUtils.isEmpty(purePicUrl)) {
                com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=" + isShowBigPicOnMobileNet);
                if (!isShowBigPicOnMobileNet) {
                    context5 = this.f39827c.f39973a;
                    com.vivo.push.util.p.a(context5, "mobile net unshow");
                    context6 = this.f39827c.f39973a;
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context6.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        int type = activeNetworkInfo.getType();
                        c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                    } else {
                        c2 = 0;
                    }
                    if (c2 == 1) {
                        purePicUrl = null;
                        this.f39825a.clearCoverUrl();
                        this.f39825a.clearPurePicUrl();
                    }
                } else {
                    context4 = this.f39827c.f39973a;
                    com.vivo.push.util.p.a(context4, "mobile net show");
                }
            }
            lVar.execute(this.f39825a.getIconUrl(), purePicUrl);
            return;
        }
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "this notification has Intercept");
    }
}
