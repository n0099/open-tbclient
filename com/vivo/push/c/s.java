package com.vivo.push.c;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class s implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ InsideNotificationItem a;
    public final /* synthetic */ com.vivo.push.b.q b;
    public final /* synthetic */ r c;

    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar, insideNotificationItem, qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = rVar;
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
            r rVar = this.c;
            PushMessageCallback pushMessageCallback = ((z) rVar).b;
            context = rVar.a;
            if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.a))) {
                context2 = this.c.a;
                InsideNotificationItem insideNotificationItem = this.a;
                long f = this.b.f();
                r rVar2 = this.c;
                PushMessageCallback pushMessageCallback2 = ((z) rVar2).b;
                context3 = rVar2.a;
                com.vivo.push.util.k kVar = new com.vivo.push.util.k(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3), new t(this));
                boolean isShowBigPicOnMobileNet = this.a.isShowBigPicOnMobileNet();
                String purePicUrl = this.a.getPurePicUrl();
                if (TextUtils.isEmpty(purePicUrl)) {
                    purePicUrl = this.a.getCoverUrl();
                }
                if (!TextUtils.isEmpty(purePicUrl)) {
                    com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
                    if (!isShowBigPicOnMobileNet) {
                        context5 = this.c.a;
                        com.vivo.push.util.p.a(context5, "mobile net unshow");
                        context6 = this.c.a;
                        NetworkInfo a = com.vivo.push.util.r.a(context6);
                        if (a != null && a.getState() == NetworkInfo.State.CONNECTED) {
                            int type = a.getType();
                            c = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                        } else {
                            c = 0;
                        }
                        if (c == 1) {
                            purePicUrl = null;
                            this.a.clearCoverUrl();
                            this.a.clearPurePicUrl();
                        }
                    } else {
                        context4 = this.c.a;
                        com.vivo.push.util.p.a(context4, "mobile net show");
                    }
                }
                kVar.execute(this.a.getIconUrl(), purePicUrl);
                return;
            }
            StringBuilder sb = new StringBuilder("pkg name : ");
            context7 = this.c.a;
            sb.append(context7.getPackageName());
            sb.append(" 应用主动拦截通知");
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb.toString());
            context8 = this.c.a;
            com.vivo.push.util.p.b(context8, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.b.f()));
            context9 = this.c.a;
            context10 = this.c.a;
            String b = com.vivo.push.util.aa.b(context9, context10.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            com.vivo.push.util.e.a(2120L, hashMap);
        }
    }
}
