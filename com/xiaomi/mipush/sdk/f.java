package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class f implements AbstractPushManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f102a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f103a;

    /* renamed from: a  reason: collision with other field name */
    public Map<e, AbstractPushManager> f104a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f105a;

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
        this.f105a = false;
        this.f104a = new HashMap();
        this.f102a = context.getApplicationContext();
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
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (pushConfiguration = this.f103a) == null) {
            return;
        }
        if (pushConfiguration.getOpenHmsPush()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ASSEMBLE_PUSH : ");
            sb.append(" HW user switch : " + this.f103a.getOpenHmsPush() + " HW online switch : " + i.m169a(this.f102a, e.a) + " HW isSupport : " + ag.a.equals(n.a(this.f102a)));
            com.xiaomi.channel.commonutils.logger.b.m103a(sb.toString());
        }
        if (this.f103a.getOpenHmsPush() && i.m169a(this.f102a, e.a) && ag.a.equals(n.a(this.f102a))) {
            if (!m163a(e.a)) {
                e eVar = e.a;
                a(eVar, ak.a(this.f102a, eVar));
            }
            com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
        } else if (m163a(e.a) && (a2 = a(e.a)) != null) {
            m162a(e.a);
            a2.unregister();
        }
        if (this.f103a.getOpenFCMPush()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ASSEMBLE_PUSH : ");
            sb2.append(" FCM user switch : " + this.f103a.getOpenFCMPush() + " FCM online switch : " + i.m169a(this.f102a, e.b) + " FCM isSupport : " + n.m173a(this.f102a));
            com.xiaomi.channel.commonutils.logger.b.m103a(sb2.toString());
        }
        if (this.f103a.getOpenFCMPush() && i.m169a(this.f102a, e.b) && n.m173a(this.f102a)) {
            if (!m163a(e.b)) {
                e eVar2 = e.b;
                a(eVar2, ak.a(this.f102a, eVar2));
            }
            com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
        } else if (m163a(e.b) && (a3 = a(e.b)) != null) {
            m162a(e.b);
            a3.unregister();
        }
        if (this.f103a.getOpenCOSPush()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ASSEMBLE_PUSH : ");
            sb3.append(" COS user switch : " + this.f103a.getOpenCOSPush() + " COS online switch : " + i.m169a(this.f102a, e.c) + " COS isSupport : " + n.b(this.f102a));
            com.xiaomi.channel.commonutils.logger.b.m103a(sb3.toString());
        }
        if (this.f103a.getOpenCOSPush() && i.m169a(this.f102a, e.c) && n.b(this.f102a)) {
            e eVar3 = e.c;
            a(eVar3, ak.a(this.f102a, eVar3));
        } else if (m163a(e.c) && (a4 = a(e.c)) != null) {
            m162a(e.c);
            a4.unregister();
        }
        if (this.f103a.getOpenFTOSPush() && i.m169a(this.f102a, e.d) && n.c(this.f102a)) {
            e eVar4 = e.d;
            a(eVar4, ak.a(this.f102a, eVar4));
        } else if (!m163a(e.d) || (a5 = a(e.d)) == null) {
        } else {
            m162a(e.d);
            a5.unregister();
        }
    }

    public AbstractPushManager a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? this.f104a.get(eVar) : (AbstractPushManager) invokeL.objValue;
    }

    public void a(PushConfiguration pushConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pushConfiguration) == null) {
            this.f103a = pushConfiguration;
            this.f105a = ba.a(this.f102a).a(ho.ao.a(), true);
            if (this.f103a.getOpenHmsPush() || this.f103a.getOpenFCMPush() || this.f103a.getOpenCOSPush() || this.f103a.getOpenFTOSPush()) {
                ba.a(this.f102a).a(new g(this, 101, "assemblePush"));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m162a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f104a.remove(eVar);
        }
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, eVar, abstractPushManager) == null) || abstractPushManager == null) {
            return;
        }
        if (this.f104a.containsKey(eVar)) {
            this.f104a.remove(eVar);
        }
        this.f104a.put(eVar, abstractPushManager);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m163a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) ? this.f104a.containsKey(eVar) : invokeL.booleanValue;
    }

    public boolean b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            int i = h.a[eVar.ordinal()];
            boolean z = false;
            if (i == 1) {
                PushConfiguration pushConfiguration = this.f103a;
                if (pushConfiguration != null) {
                    return pushConfiguration.getOpenHmsPush();
                }
                return false;
            } else if (i == 2) {
                PushConfiguration pushConfiguration2 = this.f103a;
                if (pushConfiguration2 != null) {
                    return pushConfiguration2.getOpenFCMPush();
                }
                return false;
            } else {
                if (i == 3) {
                    PushConfiguration pushConfiguration3 = this.f103a;
                    if (pushConfiguration3 != null) {
                        z = pushConfiguration3.getOpenCOSPush();
                    }
                } else if (i != 4) {
                    return false;
                }
                PushConfiguration pushConfiguration4 = this.f103a;
                return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m103a("ASSEMBLE_PUSH : assemble push register");
            if (this.f104a.size() <= 0) {
                a();
            }
            if (this.f104a.size() > 0) {
                for (AbstractPushManager abstractPushManager : this.f104a.values()) {
                    if (abstractPushManager != null) {
                        abstractPushManager.register();
                    }
                }
                i.m165a(this.f102a);
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m103a("ASSEMBLE_PUSH : assemble push unregister");
            for (AbstractPushManager abstractPushManager : this.f104a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.unregister();
                }
            }
            this.f104a.clear();
        }
    }
}
