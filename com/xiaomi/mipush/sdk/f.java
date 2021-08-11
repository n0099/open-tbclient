package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hk;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class f implements AbstractPushManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f76928a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f93a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f94a;

    /* renamed from: a  reason: collision with other field name */
    public Map<e, AbstractPushManager> f95a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f96a;

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f96a = false;
        this.f95a = new HashMap();
        this.f93a = context.getApplicationContext();
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f76928a == null) {
                synchronized (f.class) {
                    if (f76928a == null) {
                        f76928a = new f(context);
                    }
                }
            }
            return f76928a;
        }
        return (f) invokeL.objValue;
    }

    private void a() {
        PushConfiguration pushConfiguration;
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (pushConfiguration = this.f94a) == null) {
            return;
        }
        if (pushConfiguration.getOpenHmsPush()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ASSEMBLE_PUSH : ");
            sb.append(" HW user switch : " + this.f94a.getOpenHmsPush() + " HW online switch : " + i.m136a(this.f93a, e.f76924a) + " HW isSupport : " + af.f76889a.equals(n.a(this.f93a)));
            com.xiaomi.channel.commonutils.logger.b.m73a(sb.toString());
        }
        if (this.f94a.getOpenHmsPush() && i.m136a(this.f93a, e.f76924a) && af.f76889a.equals(n.a(this.f93a))) {
            if (!m132a(e.f76924a)) {
                e eVar = e.f76924a;
                a(eVar, aj.a(this.f93a, eVar));
            }
            com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
        } else if (m132a(e.f76924a) && (a2 = a(e.f76924a)) != null) {
            m131a(e.f76924a);
            a2.unregister();
        }
        if (this.f94a.getOpenFCMPush()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ASSEMBLE_PUSH : ");
            sb2.append(" FCM user switch : " + this.f94a.getOpenFCMPush() + " FCM online switch : " + i.m136a(this.f93a, e.f76925b) + " FCM isSupport : " + n.m139a(this.f93a));
            com.xiaomi.channel.commonutils.logger.b.m73a(sb2.toString());
        }
        if (this.f94a.getOpenFCMPush() && i.m136a(this.f93a, e.f76925b) && n.m139a(this.f93a)) {
            if (!m132a(e.f76925b)) {
                e eVar2 = e.f76925b;
                a(eVar2, aj.a(this.f93a, eVar2));
            }
            com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
        } else if (m132a(e.f76925b) && (a3 = a(e.f76925b)) != null) {
            m131a(e.f76925b);
            a3.unregister();
        }
        if (this.f94a.getOpenCOSPush()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ASSEMBLE_PUSH : ");
            sb3.append(" COS user switch : " + this.f94a.getOpenCOSPush() + " COS online switch : " + i.m136a(this.f93a, e.f76926c) + " COS isSupport : " + n.b(this.f93a));
            com.xiaomi.channel.commonutils.logger.b.m73a(sb3.toString());
        }
        if (this.f94a.getOpenCOSPush() && i.m136a(this.f93a, e.f76926c) && n.b(this.f93a)) {
            e eVar3 = e.f76926c;
            a(eVar3, aj.a(this.f93a, eVar3));
        } else if (m132a(e.f76926c) && (a4 = a(e.f76926c)) != null) {
            m131a(e.f76926c);
            a4.unregister();
        }
        if (this.f94a.getOpenFTOSPush() && i.m136a(this.f93a, e.f76927d) && n.c(this.f93a)) {
            e eVar4 = e.f76927d;
            a(eVar4, aj.a(this.f93a, eVar4));
        } else if (!m132a(e.f76927d) || (a5 = a(e.f76927d)) == null) {
        } else {
            m131a(e.f76927d);
            a5.unregister();
        }
    }

    public AbstractPushManager a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? this.f95a.get(eVar) : (AbstractPushManager) invokeL.objValue;
    }

    public void a(PushConfiguration pushConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pushConfiguration) == null) {
            this.f94a = pushConfiguration;
            this.f96a = com.xiaomi.push.service.aq.a(this.f93a).a(hk.ao.a(), true);
            if (this.f94a.getOpenHmsPush() || this.f94a.getOpenFCMPush() || this.f94a.getOpenCOSPush()) {
                com.xiaomi.push.service.aq.a(this.f93a).a(new g(this, 101, "assemblePush"));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m131a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f95a.remove(eVar);
        }
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, eVar, abstractPushManager) == null) || abstractPushManager == null) {
            return;
        }
        if (this.f95a.containsKey(eVar)) {
            this.f95a.remove(eVar);
        }
        this.f95a.put(eVar, abstractPushManager);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m132a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) ? this.f95a.containsKey(eVar) : invokeL.booleanValue;
    }

    public boolean b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            int i2 = h.f76930a[eVar.ordinal()];
            boolean z = false;
            if (i2 == 1) {
                PushConfiguration pushConfiguration = this.f94a;
                if (pushConfiguration != null) {
                    return pushConfiguration.getOpenHmsPush();
                }
                return false;
            } else if (i2 == 2) {
                PushConfiguration pushConfiguration2 = this.f94a;
                if (pushConfiguration2 != null) {
                    return pushConfiguration2.getOpenFCMPush();
                }
                return false;
            } else {
                if (i2 == 3) {
                    PushConfiguration pushConfiguration3 = this.f94a;
                    if (pushConfiguration3 != null) {
                        z = pushConfiguration3.getOpenCOSPush();
                    }
                } else if (i2 != 4) {
                    return false;
                }
                PushConfiguration pushConfiguration4 = this.f94a;
                return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : assemble push register");
            if (this.f95a.size() <= 0) {
                a();
            }
            if (this.f95a.size() > 0) {
                for (AbstractPushManager abstractPushManager : this.f95a.values()) {
                    if (abstractPushManager != null) {
                        abstractPushManager.register();
                    }
                }
                i.m133a(this.f93a);
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : assemble push unregister");
            for (AbstractPushManager abstractPushManager : this.f95a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.unregister();
                }
            }
            this.f95a.clear();
        }
    }
}
