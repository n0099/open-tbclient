package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ba;
import com.xiaomi.push.bp;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class aw implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f91a;

    public aw(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f91a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        Map<String, String> map;
        String d3;
        String str;
        String c;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m99a("do sync info");
            ii iiVar = new ii(bd.a(), false);
            b m141a = b.m141a(this.a);
            iiVar.c(ht.v.f529a);
            iiVar.b(m141a.m142a());
            iiVar.d(this.a.getPackageName());
            HashMap hashMap = new HashMap();
            iiVar.f668a = hashMap;
            Context context = this.a;
            com.xiaomi.push.n.a(hashMap, "app_version", com.xiaomi.push.h.m394a(context, context.getPackageName()));
            Map<String, String> map2 = iiVar.f668a;
            Context context2 = this.a;
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.h.a(context2, context2.getPackageName())));
            com.xiaomi.push.n.a(iiVar.f668a, "push_sdk_vn", "4_9_0");
            com.xiaomi.push.n.a(iiVar.f668a, "push_sdk_vc", Integer.toString(40090));
            com.xiaomi.push.n.a(iiVar.f668a, "token", m141a.b());
            if (!com.xiaomi.push.m.m576d()) {
                String a = bp.a(com.xiaomi.push.j.d(this.a));
                String f = com.xiaomi.push.j.f(this.a);
                if (!TextUtils.isEmpty(f)) {
                    a = a + "," + f;
                }
                if (!TextUtils.isEmpty(a)) {
                    com.xiaomi.push.n.a(iiVar.f668a, Constants.EXTRA_KEY_IMEI_MD5, a);
                }
            }
            ba.a(this.a).a(iiVar.f668a);
            com.xiaomi.push.n.a(iiVar.f668a, Constants.EXTRA_KEY_REG_ID, m141a.m149c());
            com.xiaomi.push.n.a(iiVar.f668a, Constants.EXTRA_KEY_REG_SECRET, m141a.d());
            com.xiaomi.push.n.a(iiVar.f668a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(",", "-"));
            if (this.f91a) {
                Map<String, String> map3 = iiVar.f668a;
                c = av.c(MiPushClient.getAllAlias(this.a));
                com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ALIASES_MD5, c);
                Map<String, String> map4 = iiVar.f668a;
                c2 = av.c(MiPushClient.getAllTopic(this.a));
                com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_TOPICS_MD5, c2);
                map = iiVar.f668a;
                d3 = av.c(MiPushClient.getAllUserAccount(this.a));
                str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
            } else {
                Map<String, String> map5 = iiVar.f668a;
                d = av.d(MiPushClient.getAllAlias(this.a));
                com.xiaomi.push.n.a(map5, Constants.EXTRA_KEY_ALIASES, d);
                Map<String, String> map6 = iiVar.f668a;
                d2 = av.d(MiPushClient.getAllTopic(this.a));
                com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_TOPICS, d2);
                map = iiVar.f668a;
                d3 = av.d(MiPushClient.getAllUserAccount(this.a));
                str = Constants.EXTRA_KEY_ACCOUNTS;
            }
            com.xiaomi.push.n.a(map, str, d3);
            ao.a(this.a).a((ao) iiVar, hj.i, false, (hw) null);
        }
    }
}
