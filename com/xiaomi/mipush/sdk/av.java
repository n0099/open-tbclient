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
/* loaded from: classes4.dex */
public final class av implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f83a;

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
        this.a = context;
        this.f83a = z;
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
            com.xiaomi.channel.commonutils.logger.b.m134a("do sync info");
            ie ieVar = new ie(com.xiaomi.push.service.at.a(), false);
            b m175a = b.m175a(this.a);
            ieVar.c(hp.v.f514a);
            ieVar.b(m175a.m176a());
            ieVar.d(this.a.getPackageName());
            HashMap hashMap = new HashMap();
            ieVar.f655a = hashMap;
            Context context = this.a;
            com.xiaomi.push.n.a(hashMap, "app_version", com.xiaomi.push.g.m402a(context, context.getPackageName()));
            Map<String, String> map2 = ieVar.f655a;
            Context context2 = this.a;
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(context2, context2.getPackageName())));
            com.xiaomi.push.n.a(ieVar.f655a, "push_sdk_vn", "3_8_5");
            com.xiaomi.push.n.a(ieVar.f655a, "push_sdk_vc", Integer.toString(30805));
            com.xiaomi.push.n.a(ieVar.f655a, "token", m175a.b());
            com.xiaomi.push.i.a(this.a, ieVar.f655a);
            if (!com.xiaomi.push.l.d()) {
                String a = bm.a(com.xiaomi.push.i.f(this.a));
                String h2 = com.xiaomi.push.i.h(this.a);
                if (!TextUtils.isEmpty(h2)) {
                    a = a + "," + h2;
                }
                if (!TextUtils.isEmpty(a)) {
                    com.xiaomi.push.n.a(ieVar.f655a, Constants.EXTRA_KEY_IMEI_MD5, a);
                }
            }
            ax.a(this.a).a(ieVar.f655a);
            com.xiaomi.push.n.a(ieVar.f655a, Constants.EXTRA_KEY_REG_ID, m175a.m183c());
            com.xiaomi.push.n.a(ieVar.f655a, Constants.EXTRA_KEY_REG_SECRET, m175a.d());
            com.xiaomi.push.n.a(ieVar.f655a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(",", "-"));
            if (this.f83a) {
                Map<String, String> map3 = ieVar.f655a;
                c2 = au.c(MiPushClient.getAllAlias(this.a));
                com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ALIASES_MD5, c2);
                Map<String, String> map4 = ieVar.f655a;
                c3 = au.c(MiPushClient.getAllTopic(this.a));
                com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_TOPICS_MD5, c3);
                map = ieVar.f655a;
                d4 = au.c(MiPushClient.getAllUserAccount(this.a));
                str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
            } else {
                Map<String, String> map5 = ieVar.f655a;
                d2 = au.d(MiPushClient.getAllAlias(this.a));
                com.xiaomi.push.n.a(map5, Constants.EXTRA_KEY_ALIASES, d2);
                Map<String, String> map6 = ieVar.f655a;
                d3 = au.d(MiPushClient.getAllTopic(this.a));
                com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_TOPICS, d3);
                map = ieVar.f655a;
                d4 = au.d(MiPushClient.getAllUserAccount(this.a));
                str = Constants.EXTRA_KEY_ACCOUNTS;
            }
            com.xiaomi.push.n.a(map, str, d4);
            an.a(this.a).a((an) ieVar, hf.f61211i, false, (hs) null);
        }
    }
}
