package com.xiaomi.mipush.sdk;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class g implements AbstractPushManager {
    private static volatile g a;
    private Context b;
    private PushConfiguration c;
    private Map<f, AbstractPushManager> d = new HashMap();

    private g(Context context) {
        this.b = context;
    }

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    private void a() {
        AbstractPushManager c;
        AbstractPushManager c2;
        AbstractPushManager c3;
        if (this.c != null) {
            if (this.c.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.c.getOpenHmsPush() + " HW online switch : " + i.b(this.b, f.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + aq.HUAWEI.equals(n.a(this.b))));
            }
            if (this.c.getOpenHmsPush() && i.b(this.b, f.ASSEMBLE_PUSH_HUAWEI) && aq.HUAWEI.equals(n.a(this.b))) {
                if (!b(f.ASSEMBLE_PUSH_HUAWEI)) {
                    a(f.ASSEMBLE_PUSH_HUAWEI, au.a(this.b, f.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (b(f.ASSEMBLE_PUSH_HUAWEI) && (c = c(f.ASSEMBLE_PUSH_HUAWEI)) != null) {
                a(f.ASSEMBLE_PUSH_HUAWEI);
                c.unregister();
            }
            if (this.c.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.c.getOpenFCMPush() + " FCM online switch : " + i.b(this.b, f.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + n.b(this.b)));
            }
            if (this.c.getOpenFCMPush() && i.b(this.b, f.ASSEMBLE_PUSH_FCM) && n.b(this.b)) {
                if (!b(f.ASSEMBLE_PUSH_FCM)) {
                    a(f.ASSEMBLE_PUSH_FCM, au.a(this.b, f.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (b(f.ASSEMBLE_PUSH_FCM) && (c2 = c(f.ASSEMBLE_PUSH_FCM)) != null) {
                a(f.ASSEMBLE_PUSH_FCM);
                c2.unregister();
            }
            if (this.c.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.c.getOpenCOSPush() + " COS online switch : " + i.b(this.b, f.ASSEMBLE_PUSH_COS) + " COS isSupport : " + n.c(this.b)));
            }
            if (this.c.getOpenCOSPush() && i.b(this.b, f.ASSEMBLE_PUSH_COS) && n.c(this.b)) {
                a(f.ASSEMBLE_PUSH_COS, au.a(this.b, f.ASSEMBLE_PUSH_COS));
            } else if (!b(f.ASSEMBLE_PUSH_COS) || (c3 = c(f.ASSEMBLE_PUSH_COS)) == null) {
            } else {
                a(f.ASSEMBLE_PUSH_COS);
                c3.unregister();
            }
        }
    }

    public void a(PushConfiguration pushConfiguration) {
        this.c = pushConfiguration;
    }

    public void a(f fVar) {
        this.d.remove(fVar);
    }

    public void a(f fVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.d.containsKey(fVar)) {
                this.d.remove(fVar);
            }
            this.d.put(fVar, abstractPushManager);
        }
    }

    public boolean b(f fVar) {
        return this.d.containsKey(fVar);
    }

    public AbstractPushManager c(f fVar) {
        return this.d.get(fVar);
    }

    public boolean d(f fVar) {
        switch (h.a[fVar.ordinal()]) {
            case 1:
                if (this.c != null) {
                    return this.c.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.c != null) {
                    return this.c.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.c != null) {
                    return this.c.getOpenCOSPush();
                }
                return false;
            default:
                return false;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : assemble push register");
        if (this.d.size() <= 0) {
            a();
        }
        if (this.d.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.d.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.d.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.d.clear();
    }
}
