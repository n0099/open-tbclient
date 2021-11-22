package com.vivo.push.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes2.dex */
public final class s implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InsideNotificationItem f71197a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.s f71198b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f71199c;

    public s(r rVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar, insideNotificationItem, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71199c = rVar;
        this.f71197a = insideNotificationItem;
        this.f71198b = sVar;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r rVar = this.f71199c;
            PushMessageCallback pushMessageCallback = ((ab) rVar).f71165b;
            context = rVar.f71347a;
            if (!pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.f71197a))) {
                context2 = this.f71199c.f71347a;
                InsideNotificationItem insideNotificationItem = this.f71197a;
                long f2 = this.f71198b.f();
                r rVar2 = this.f71199c;
                PushMessageCallback pushMessageCallback2 = ((ab) rVar2).f71165b;
                context3 = rVar2.f71347a;
                com.vivo.push.util.l lVar = new com.vivo.push.util.l(context2, insideNotificationItem, f2, pushMessageCallback2.isAllowNet(context3));
                boolean isShowBigPicOnMobileNet = this.f71197a.isShowBigPicOnMobileNet();
                String purePicUrl = this.f71197a.getPurePicUrl();
                if (TextUtils.isEmpty(purePicUrl)) {
                    purePicUrl = this.f71197a.getCoverUrl();
                }
                if (!TextUtils.isEmpty(purePicUrl)) {
                    com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=" + isShowBigPicOnMobileNet);
                    if (!isShowBigPicOnMobileNet) {
                        context5 = this.f71199c.f71347a;
                        com.vivo.push.util.p.a(context5, "mobile net unshow");
                        context6 = this.f71199c.f71347a;
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context6.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                            int type = activeNetworkInfo.getType();
                            c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                        } else {
                            c2 = 0;
                        }
                        if (c2 == 1) {
                            purePicUrl = null;
                            this.f71197a.clearCoverUrl();
                            this.f71197a.clearPurePicUrl();
                        }
                    } else {
                        context4 = this.f71199c.f71347a;
                        com.vivo.push.util.p.a(context4, "mobile net show");
                    }
                }
                lVar.execute(this.f71197a.getIconUrl(), purePicUrl);
                return;
            }
            com.vivo.push.util.p.d("OnNotificationArrivedTask", "this notification has Intercept");
        }
    }
}
