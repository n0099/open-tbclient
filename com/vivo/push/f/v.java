package com.vivo.push.f;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class v implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ InsideNotificationItem a;
    public final /* synthetic */ com.vivo.push.b.q b;
    public final /* synthetic */ u c;

    public v(u uVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar, insideNotificationItem, qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = uVar;
        this.a = insideNotificationItem;
        this.b = qVar;
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
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u uVar = this.c;
            PushMessageCallback pushMessageCallback = ((aa) uVar).b;
            context = uVar.a;
            NotifyArriveCallbackByUser onNotificationMessageArrived = pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.v.a(this.a));
            int a = this.c.a(onNotificationMessageArrived);
            if (a > 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("messageID", String.valueOf(this.b.f()));
                String a2 = com.vivo.push.d.a.a().e().a();
                if (!TextUtils.isEmpty(a2)) {
                    hashMap.put("remoteAppId", a2);
                }
                context9 = this.c.a;
                context10 = this.c.a;
                hashMap.put("clientsdkver", String.valueOf(com.vivo.push.util.ag.c(context9, context10.getPackageName())));
                com.vivo.push.util.f.a(a, hashMap);
                return;
            }
            int b = this.c.b();
            if (b <= 0) {
                context2 = this.c.a;
                InsideNotificationItem insideNotificationItem = this.a;
                long f = this.b.f();
                u uVar2 = this.c;
                PushMessageCallback pushMessageCallback2 = ((aa) uVar2).b;
                context3 = uVar2.a;
                com.vivo.push.util.p pVar = new com.vivo.push.util.p(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3), new w(this), onNotificationMessageArrived);
                boolean isShowBigPicOnMobileNet = this.a.isShowBigPicOnMobileNet();
                String purePicUrl = this.a.getPurePicUrl();
                if (TextUtils.isEmpty(purePicUrl)) {
                    purePicUrl = this.a.getCoverUrl();
                }
                if (!TextUtils.isEmpty(purePicUrl)) {
                    com.vivo.push.util.u.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
                    if (!isShowBigPicOnMobileNet) {
                        context5 = this.c.a;
                        com.vivo.push.util.u.a(context5, "mobile net unshow");
                        context6 = this.c.a;
                        NetworkInfo a3 = com.vivo.push.util.x.a(context6);
                        if (a3 == null || a3.getState() != NetworkInfo.State.CONNECTED) {
                            c = 0;
                        } else {
                            int type = a3.getType();
                            if (type == 1) {
                                c = 2;
                            } else if (type == 0) {
                                c = 1;
                            } else {
                                c = 3;
                            }
                        }
                        if (c == 1) {
                            purePicUrl = null;
                            this.a.clearCoverUrl();
                            this.a.clearPurePicUrl();
                        }
                    } else {
                        context4 = this.c.a;
                        com.vivo.push.util.u.a(context4, "mobile net show");
                    }
                }
                pVar.execute(this.a.getIconUrl(), purePicUrl);
                return;
            }
            StringBuilder sb = new StringBuilder("pkg name : ");
            context7 = this.c.a;
            sb.append(context7.getPackageName());
            sb.append(" notify channel switch is ");
            sb.append(b);
            com.vivo.push.util.u.b("OnNotificationArrivedTask", sb.toString());
            context8 = this.c.a;
            com.vivo.push.util.u.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("messageID", String.valueOf(this.b.f()));
            String a4 = com.vivo.push.d.a.a().e().a();
            if (!TextUtils.isEmpty(a4)) {
                hashMap2.put("remoteAppId", a4);
            }
            com.vivo.push.util.f.a(b, hashMap2);
        }
    }
}
