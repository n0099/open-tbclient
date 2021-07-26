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
/* loaded from: classes6.dex */
public class f implements AbstractPushManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f40077a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f89a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f90a;

    /* renamed from: a  reason: collision with other field name */
    public Map<e, AbstractPushManager> f91a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f92a;

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
        this.f92a = false;
        this.f91a = new HashMap();
        this.f89a = context.getApplicationContext();
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f40077a == null) {
                synchronized (f.class) {
                    if (f40077a == null) {
                        f40077a = new f(context);
                    }
                }
            }
            return f40077a;
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
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (pushConfiguration = this.f90a) == null) {
            return;
        }
        if (pushConfiguration.getOpenHmsPush()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ASSEMBLE_PUSH : ");
            sb.append(" HW user switch : " + this.f90a.getOpenHmsPush() + " HW online switch : " + i.m133a(this.f89a, e.f40073a) + " HW isSupport : " + af.f40038a.equals(n.a(this.f89a)));
            com.xiaomi.channel.commonutils.logger.b.m70a(sb.toString());
        }
        if (this.f90a.getOpenHmsPush() && i.m133a(this.f89a, e.f40073a) && af.f40038a.equals(n.a(this.f89a))) {
            if (!m129a(e.f40073a)) {
                e eVar = e.f40073a;
                a(eVar, aj.a(this.f89a, eVar));
            }
            com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
        } else if (m129a(e.f40073a) && (a2 = a(e.f40073a)) != null) {
            m128a(e.f40073a);
            a2.unregister();
        }
        if (this.f90a.getOpenFCMPush()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ASSEMBLE_PUSH : ");
            sb2.append(" FCM user switch : " + this.f90a.getOpenFCMPush() + " FCM online switch : " + i.m133a(this.f89a, e.f40074b) + " FCM isSupport : " + n.m136a(this.f89a));
            com.xiaomi.channel.commonutils.logger.b.m70a(sb2.toString());
        }
        if (this.f90a.getOpenFCMPush() && i.m133a(this.f89a, e.f40074b) && n.m136a(this.f89a)) {
            if (!m129a(e.f40074b)) {
                e eVar2 = e.f40074b;
                a(eVar2, aj.a(this.f89a, eVar2));
            }
            com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
        } else if (m129a(e.f40074b) && (a3 = a(e.f40074b)) != null) {
            m128a(e.f40074b);
            a3.unregister();
        }
        if (this.f90a.getOpenCOSPush()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ASSEMBLE_PUSH : ");
            sb3.append(" COS user switch : " + this.f90a.getOpenCOSPush() + " COS online switch : " + i.m133a(this.f89a, e.f40075c) + " COS isSupport : " + n.b(this.f89a));
            com.xiaomi.channel.commonutils.logger.b.m70a(sb3.toString());
        }
        if (this.f90a.getOpenCOSPush() && i.m133a(this.f89a, e.f40075c) && n.b(this.f89a)) {
            e eVar3 = e.f40075c;
            a(eVar3, aj.a(this.f89a, eVar3));
        } else if (m129a(e.f40075c) && (a4 = a(e.f40075c)) != null) {
            m128a(e.f40075c);
            a4.unregister();
        }
        if (this.f90a.getOpenFTOSPush() && i.m133a(this.f89a, e.f40076d) && n.c(this.f89a)) {
            e eVar4 = e.f40076d;
            a(eVar4, aj.a(this.f89a, eVar4));
        } else if (!m129a(e.f40076d) || (a5 = a(e.f40076d)) == null) {
        } else {
            m128a(e.f40076d);
            a5.unregister();
        }
    }

    public AbstractPushManager a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? this.f91a.get(eVar) : (AbstractPushManager) invokeL.objValue;
    }

    public void a(PushConfiguration pushConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pushConfiguration) == null) {
            this.f90a = pushConfiguration;
            this.f92a = com.xiaomi.push.service.aq.a(this.f89a).a(hk.ao.a(), true);
            if (this.f90a.getOpenHmsPush() || this.f90a.getOpenFCMPush() || this.f90a.getOpenCOSPush()) {
                com.xiaomi.push.service.aq.a(this.f89a).a(new g(this, 101, "assemblePush"));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m128a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f91a.remove(eVar);
        }
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, eVar, abstractPushManager) == null) || abstractPushManager == null) {
            return;
        }
        if (this.f91a.containsKey(eVar)) {
            this.f91a.remove(eVar);
        }
        this.f91a.put(eVar, abstractPushManager);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m129a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) ? this.f91a.containsKey(eVar) : invokeL.booleanValue;
    }

    public boolean b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            int i2 = h.f40079a[eVar.ordinal()];
            boolean z = false;
            if (i2 == 1) {
                PushConfiguration pushConfiguration = this.f90a;
                if (pushConfiguration != null) {
                    return pushConfiguration.getOpenHmsPush();
                }
                return false;
            } else if (i2 == 2) {
                PushConfiguration pushConfiguration2 = this.f90a;
                if (pushConfiguration2 != null) {
                    return pushConfiguration2.getOpenFCMPush();
                }
                return false;
            } else {
                if (i2 == 3) {
                    PushConfiguration pushConfiguration3 = this.f90a;
                    if (pushConfiguration3 != null) {
                        z = pushConfiguration3.getOpenCOSPush();
                    }
                } else if (i2 != 4) {
                    return false;
                }
                PushConfiguration pushConfiguration4 = this.f90a;
                return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m70a("ASSEMBLE_PUSH : assemble push register");
            if (this.f91a.size() <= 0) {
                a();
            }
            if (this.f91a.size() > 0) {
                for (AbstractPushManager abstractPushManager : this.f91a.values()) {
                    if (abstractPushManager != null) {
                        abstractPushManager.register();
                    }
                }
                i.m130a(this.f89a);
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m70a("ASSEMBLE_PUSH : assemble push unregister");
            for (AbstractPushManager abstractPushManager : this.f91a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.unregister();
                }
            }
            this.f91a.clear();
        }
    }
}
