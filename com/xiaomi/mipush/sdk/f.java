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
/* loaded from: classes8.dex */
public class f implements AbstractPushManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f70a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f71a;

    /* renamed from: a  reason: collision with other field name */
    public Map<e, AbstractPushManager> f72a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f73a;

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73a = false;
        this.f72a = new HashMap();
        this.f70a = context.getApplicationContext();
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (f.class) {
                    if (a == null) {
                        a = new f(context);
                    }
                }
            }
            return a;
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
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (pushConfiguration = this.f71a) == null) {
            return;
        }
        if (pushConfiguration.getOpenHmsPush()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ASSEMBLE_PUSH : ");
            sb.append(" HW user switch : " + this.f71a.getOpenHmsPush() + " HW online switch : " + i.m171a(this.f70a, e.a) + " HW isSupport : " + af.a.equals(n.a(this.f70a)));
            com.xiaomi.channel.commonutils.logger.b.m108a(sb.toString());
        }
        if (this.f71a.getOpenHmsPush() && i.m171a(this.f70a, e.a) && af.a.equals(n.a(this.f70a))) {
            if (!m167a(e.a)) {
                e eVar = e.a;
                a(eVar, aj.a(this.f70a, eVar));
            }
            com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
        } else if (m167a(e.a) && (a2 = a(e.a)) != null) {
            m166a(e.a);
            a2.unregister();
        }
        if (this.f71a.getOpenFCMPush()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ASSEMBLE_PUSH : ");
            sb2.append(" FCM user switch : " + this.f71a.getOpenFCMPush() + " FCM online switch : " + i.m171a(this.f70a, e.b) + " FCM isSupport : " + n.m174a(this.f70a));
            com.xiaomi.channel.commonutils.logger.b.m108a(sb2.toString());
        }
        if (this.f71a.getOpenFCMPush() && i.m171a(this.f70a, e.b) && n.m174a(this.f70a)) {
            if (!m167a(e.b)) {
                e eVar2 = e.b;
                a(eVar2, aj.a(this.f70a, eVar2));
            }
            com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
        } else if (m167a(e.b) && (a3 = a(e.b)) != null) {
            m166a(e.b);
            a3.unregister();
        }
        if (this.f71a.getOpenCOSPush()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ASSEMBLE_PUSH : ");
            sb3.append(" COS user switch : " + this.f71a.getOpenCOSPush() + " COS online switch : " + i.m171a(this.f70a, e.c) + " COS isSupport : " + n.b(this.f70a));
            com.xiaomi.channel.commonutils.logger.b.m108a(sb3.toString());
        }
        if (this.f71a.getOpenCOSPush() && i.m171a(this.f70a, e.c) && n.b(this.f70a)) {
            e eVar3 = e.c;
            a(eVar3, aj.a(this.f70a, eVar3));
        } else if (m167a(e.c) && (a4 = a(e.c)) != null) {
            m166a(e.c);
            a4.unregister();
        }
        if (this.f71a.getOpenFTOSPush() && i.m171a(this.f70a, e.d) && n.c(this.f70a)) {
            e eVar4 = e.d;
            a(eVar4, aj.a(this.f70a, eVar4));
        } else if (!m167a(e.d) || (a5 = a(e.d)) == null) {
        } else {
            m166a(e.d);
            a5.unregister();
        }
    }

    public AbstractPushManager a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? this.f72a.get(eVar) : (AbstractPushManager) invokeL.objValue;
    }

    public void a(PushConfiguration pushConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pushConfiguration) == null) {
            this.f71a = pushConfiguration;
            this.f73a = com.xiaomi.push.service.aq.a(this.f70a).a(hk.ao.a(), true);
            if (this.f71a.getOpenHmsPush() || this.f71a.getOpenFCMPush() || this.f71a.getOpenCOSPush()) {
                com.xiaomi.push.service.aq.a(this.f70a).a(new g(this, 101, "assemblePush"));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m166a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f72a.remove(eVar);
        }
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, eVar, abstractPushManager) == null) || abstractPushManager == null) {
            return;
        }
        if (this.f72a.containsKey(eVar)) {
            this.f72a.remove(eVar);
        }
        this.f72a.put(eVar, abstractPushManager);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m167a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) ? this.f72a.containsKey(eVar) : invokeL.booleanValue;
    }

    public boolean b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            int i = h.a[eVar.ordinal()];
            boolean z = false;
            if (i == 1) {
                PushConfiguration pushConfiguration = this.f71a;
                if (pushConfiguration != null) {
                    return pushConfiguration.getOpenHmsPush();
                }
                return false;
            } else if (i == 2) {
                PushConfiguration pushConfiguration2 = this.f71a;
                if (pushConfiguration2 != null) {
                    return pushConfiguration2.getOpenFCMPush();
                }
                return false;
            } else {
                if (i == 3) {
                    PushConfiguration pushConfiguration3 = this.f71a;
                    if (pushConfiguration3 != null) {
                        z = pushConfiguration3.getOpenCOSPush();
                    }
                } else if (i != 4) {
                    return false;
                }
                PushConfiguration pushConfiguration4 = this.f71a;
                return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m108a("ASSEMBLE_PUSH : assemble push register");
            if (this.f72a.size() <= 0) {
                a();
            }
            if (this.f72a.size() > 0) {
                for (AbstractPushManager abstractPushManager : this.f72a.values()) {
                    if (abstractPushManager != null) {
                        abstractPushManager.register();
                    }
                }
                i.m168a(this.f70a);
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m108a("ASSEMBLE_PUSH : assemble push unregister");
            for (AbstractPushManager abstractPushManager : this.f72a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.unregister();
                }
            }
            this.f72a.clear();
        }
    }
}
