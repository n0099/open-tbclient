package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ax;
import com.xiaomi.push.bm;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class av implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f42777a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f78a;

    public av(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42777a = context;
        this.f78a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d2;
        String d3;
        Map<String, String> map;
        String d4;
        String str;
        String c2;
        String c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m70a("do sync info");
            ie ieVar = new ie(com.xiaomi.push.service.at.a(), false);
            b m111a = b.m111a(this.f42777a);
            ieVar.c(hp.v.f509a);
            ieVar.b(m111a.m112a());
            ieVar.d(this.f42777a.getPackageName());
            HashMap hashMap = new HashMap();
            ieVar.f650a = hashMap;
            Context context = this.f42777a;
            com.xiaomi.push.n.a(hashMap, "app_version", com.xiaomi.push.g.m338a(context, context.getPackageName()));
            Map<String, String> map2 = ieVar.f650a;
            Context context2 = this.f42777a;
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(context2, context2.getPackageName())));
            com.xiaomi.push.n.a(ieVar.f650a, "push_sdk_vn", "3_8_5");
            com.xiaomi.push.n.a(ieVar.f650a, "push_sdk_vc", Integer.toString(30805));
            com.xiaomi.push.n.a(ieVar.f650a, "token", m111a.b());
            com.xiaomi.push.i.a(this.f42777a, ieVar.f650a);
            if (!com.xiaomi.push.l.d()) {
                String a2 = bm.a(com.xiaomi.push.i.f(this.f42777a));
                String h2 = com.xiaomi.push.i.h(this.f42777a);
                if (!TextUtils.isEmpty(h2)) {
                    a2 = a2 + "," + h2;
                }
                if (!TextUtils.isEmpty(a2)) {
                    com.xiaomi.push.n.a(ieVar.f650a, Constants.EXTRA_KEY_IMEI_MD5, a2);
                }
            }
            ax.a(this.f42777a).a(ieVar.f650a);
            com.xiaomi.push.n.a(ieVar.f650a, Constants.EXTRA_KEY_REG_ID, m111a.m119c());
            com.xiaomi.push.n.a(ieVar.f650a, Constants.EXTRA_KEY_REG_SECRET, m111a.d());
            com.xiaomi.push.n.a(ieVar.f650a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f42777a).replace(",", "-"));
            if (this.f78a) {
                Map<String, String> map3 = ieVar.f650a;
                c2 = au.c(MiPushClient.getAllAlias(this.f42777a));
                com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ALIASES_MD5, c2);
                Map<String, String> map4 = ieVar.f650a;
                c3 = au.c(MiPushClient.getAllTopic(this.f42777a));
                com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_TOPICS_MD5, c3);
                map = ieVar.f650a;
                d4 = au.c(MiPushClient.getAllUserAccount(this.f42777a));
                str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
            } else {
                Map<String, String> map5 = ieVar.f650a;
                d2 = au.d(MiPushClient.getAllAlias(this.f42777a));
                com.xiaomi.push.n.a(map5, Constants.EXTRA_KEY_ALIASES, d2);
                Map<String, String> map6 = ieVar.f650a;
                d3 = au.d(MiPushClient.getAllTopic(this.f42777a));
                com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_TOPICS, d3);
                map = ieVar.f650a;
                d4 = au.d(MiPushClient.getAllUserAccount(this.f42777a));
                str = Constants.EXTRA_KEY_ACCOUNTS;
            }
            com.xiaomi.push.n.a(map, str, d4);
            an.a(this.f42777a).a((an) ieVar, hf.f43244i, false, (hs) null);
        }
    }
}
