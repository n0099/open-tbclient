package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class g implements AbstractPushManager {
    private static volatile g a;

    /* renamed from: a  reason: collision with other field name */
    private Context f73a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f74a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f76a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<f, AbstractPushManager> f75a = new HashMap();

    private g(Context context) {
        this.f73a = context.getApplicationContext();
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
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        if (this.f74a != null) {
            if (this.f74a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m33a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f74a.getOpenHmsPush() + " HW online switch : " + j.m92a(this.f73a, f.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ap.HUAWEI.equals(o.a(this.f73a))));
            }
            if (this.f74a.getOpenHmsPush() && j.m92a(this.f73a, f.ASSEMBLE_PUSH_HUAWEI) && ap.HUAWEI.equals(o.a(this.f73a))) {
                if (!m88a(f.ASSEMBLE_PUSH_HUAWEI)) {
                    a(f.ASSEMBLE_PUSH_HUAWEI, at.a(this.f73a, f.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m88a(f.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(f.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m87a(f.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f74a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m33a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f74a.getOpenFCMPush() + " FCM online switch : " + j.m92a(this.f73a, f.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + o.m95a(this.f73a)));
            }
            if (this.f74a.getOpenFCMPush() && j.m92a(this.f73a, f.ASSEMBLE_PUSH_FCM) && o.m95a(this.f73a)) {
                if (!m88a(f.ASSEMBLE_PUSH_FCM)) {
                    a(f.ASSEMBLE_PUSH_FCM, at.a(this.f73a, f.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m88a(f.ASSEMBLE_PUSH_FCM) && (a3 = a(f.ASSEMBLE_PUSH_FCM)) != null) {
                m87a(f.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f74a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m33a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f74a.getOpenCOSPush() + " COS online switch : " + j.m92a(this.f73a, f.ASSEMBLE_PUSH_COS) + " COS isSupport : " + o.b(this.f73a)));
            }
            if (this.f74a.getOpenCOSPush() && j.m92a(this.f73a, f.ASSEMBLE_PUSH_COS) && o.b(this.f73a)) {
                a(f.ASSEMBLE_PUSH_COS, at.a(this.f73a, f.ASSEMBLE_PUSH_COS));
            } else if (m88a(f.ASSEMBLE_PUSH_COS) && (a4 = a(f.ASSEMBLE_PUSH_COS)) != null) {
                m87a(f.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f74a.getOpenFTOSPush() && j.m92a(this.f73a, f.ASSEMBLE_PUSH_FTOS) && o.c(this.f73a)) {
                a(f.ASSEMBLE_PUSH_FTOS, at.a(this.f73a, f.ASSEMBLE_PUSH_FTOS));
            } else if (!m88a(f.ASSEMBLE_PUSH_FTOS) || (a5 = a(f.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m87a(f.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(f fVar) {
        return this.f75a.get(fVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f74a = pushConfiguration;
        this.f76a = com.xiaomi.push.service.ag.a(this.f73a).a(hl.AggregatePushSwitch.a(), true);
        if (this.f74a.getOpenHmsPush() || this.f74a.getOpenFCMPush() || this.f74a.getOpenCOSPush()) {
            com.xiaomi.push.service.ag.a(this.f73a).a(new h(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m87a(f fVar) {
        this.f75a.remove(fVar);
    }

    public void a(f fVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f75a.containsKey(fVar)) {
                this.f75a.remove(fVar);
            }
            this.f75a.put(fVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m88a(f fVar) {
        return this.f75a.containsKey(fVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(f fVar) {
        boolean z = false;
        switch (i.a[fVar.ordinal()]) {
            case 1:
                if (this.f74a != null) {
                    return this.f74a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f74a != null) {
                    return this.f74a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f74a != null) {
                    z = this.f74a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f74a != null ? this.f74a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m33a("ASSEMBLE_PUSH : assemble push register");
        if (this.f75a.size() <= 0) {
            a();
        }
        if (this.f75a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f75a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            j.m89a(this.f73a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m33a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f75a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f75a.clear();
    }
}
