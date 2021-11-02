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
/* loaded from: classes2.dex */
public class f implements AbstractPushManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f70626a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f94a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f95a;

    /* renamed from: a  reason: collision with other field name */
    public Map<e, AbstractPushManager> f96a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f97a;

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
        this.f97a = false;
        this.f96a = new HashMap();
        this.f94a = context.getApplicationContext();
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f70626a == null) {
                synchronized (f.class) {
                    if (f70626a == null) {
                        f70626a = new f(context);
                    }
                }
            }
            return f70626a;
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
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (pushConfiguration = this.f95a) == null) {
            return;
        }
        if (pushConfiguration.getOpenHmsPush()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ASSEMBLE_PUSH : ");
            sb.append(" HW user switch : " + this.f95a.getOpenHmsPush() + " HW online switch : " + i.m136a(this.f94a, e.f70622a) + " HW isSupport : " + af.f70587a.equals(n.a(this.f94a)));
            com.xiaomi.channel.commonutils.logger.b.m73a(sb.toString());
        }
        if (this.f95a.getOpenHmsPush() && i.m136a(this.f94a, e.f70622a) && af.f70587a.equals(n.a(this.f94a))) {
            if (!m132a(e.f70622a)) {
                e eVar = e.f70622a;
                a(eVar, aj.a(this.f94a, eVar));
            }
            com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
        } else if (m132a(e.f70622a) && (a2 = a(e.f70622a)) != null) {
            m131a(e.f70622a);
            a2.unregister();
        }
        if (this.f95a.getOpenFCMPush()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ASSEMBLE_PUSH : ");
            sb2.append(" FCM user switch : " + this.f95a.getOpenFCMPush() + " FCM online switch : " + i.m136a(this.f94a, e.f70623b) + " FCM isSupport : " + n.m139a(this.f94a));
            com.xiaomi.channel.commonutils.logger.b.m73a(sb2.toString());
        }
        if (this.f95a.getOpenFCMPush() && i.m136a(this.f94a, e.f70623b) && n.m139a(this.f94a)) {
            if (!m132a(e.f70623b)) {
                e eVar2 = e.f70623b;
                a(eVar2, aj.a(this.f94a, eVar2));
            }
            com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
        } else if (m132a(e.f70623b) && (a3 = a(e.f70623b)) != null) {
            m131a(e.f70623b);
            a3.unregister();
        }
        if (this.f95a.getOpenCOSPush()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ASSEMBLE_PUSH : ");
            sb3.append(" COS user switch : " + this.f95a.getOpenCOSPush() + " COS online switch : " + i.m136a(this.f94a, e.f70624c) + " COS isSupport : " + n.b(this.f94a));
            com.xiaomi.channel.commonutils.logger.b.m73a(sb3.toString());
        }
        if (this.f95a.getOpenCOSPush() && i.m136a(this.f94a, e.f70624c) && n.b(this.f94a)) {
            e eVar3 = e.f70624c;
            a(eVar3, aj.a(this.f94a, eVar3));
        } else if (m132a(e.f70624c) && (a4 = a(e.f70624c)) != null) {
            m131a(e.f70624c);
            a4.unregister();
        }
        if (this.f95a.getOpenFTOSPush() && i.m136a(this.f94a, e.f70625d) && n.c(this.f94a)) {
            e eVar4 = e.f70625d;
            a(eVar4, aj.a(this.f94a, eVar4));
        } else if (!m132a(e.f70625d) || (a5 = a(e.f70625d)) == null) {
        } else {
            m131a(e.f70625d);
            a5.unregister();
        }
    }

    public AbstractPushManager a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? this.f96a.get(eVar) : (AbstractPushManager) invokeL.objValue;
    }

    public void a(PushConfiguration pushConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pushConfiguration) == null) {
            this.f95a = pushConfiguration;
            this.f97a = com.xiaomi.push.service.aq.a(this.f94a).a(hk.ao.a(), true);
            if (this.f95a.getOpenHmsPush() || this.f95a.getOpenFCMPush() || this.f95a.getOpenCOSPush()) {
                com.xiaomi.push.service.aq.a(this.f94a).a(new g(this, 101, "assemblePush"));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m131a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f96a.remove(eVar);
        }
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, eVar, abstractPushManager) == null) || abstractPushManager == null) {
            return;
        }
        if (this.f96a.containsKey(eVar)) {
            this.f96a.remove(eVar);
        }
        this.f96a.put(eVar, abstractPushManager);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m132a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) ? this.f96a.containsKey(eVar) : invokeL.booleanValue;
    }

    public boolean b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            int i2 = h.f70628a[eVar.ordinal()];
            boolean z = false;
            if (i2 == 1) {
                PushConfiguration pushConfiguration = this.f95a;
                if (pushConfiguration != null) {
                    return pushConfiguration.getOpenHmsPush();
                }
                return false;
            } else if (i2 == 2) {
                PushConfiguration pushConfiguration2 = this.f95a;
                if (pushConfiguration2 != null) {
                    return pushConfiguration2.getOpenFCMPush();
                }
                return false;
            } else {
                if (i2 == 3) {
                    PushConfiguration pushConfiguration3 = this.f95a;
                    if (pushConfiguration3 != null) {
                        z = pushConfiguration3.getOpenCOSPush();
                    }
                } else if (i2 != 4) {
                    return false;
                }
                PushConfiguration pushConfiguration4 = this.f95a;
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
            if (this.f96a.size() <= 0) {
                a();
            }
            if (this.f96a.size() > 0) {
                for (AbstractPushManager abstractPushManager : this.f96a.values()) {
                    if (abstractPushManager != null) {
                        abstractPushManager.register();
                    }
                }
                i.m133a(this.f94a);
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : assemble push unregister");
            for (AbstractPushManager abstractPushManager : this.f96a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.unregister();
                }
            }
            this.f96a.clear();
        }
    }
}
