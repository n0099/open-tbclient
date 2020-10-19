package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class e implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f4765a;

    /* renamed from: a  reason: collision with other field name */
    private Context f73a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f74a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f76a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f75a = new HashMap();

    private e(Context context) {
        this.f73a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (f4765a == null) {
            synchronized (e.class) {
                if (f4765a == null) {
                    f4765a = new e(context);
                }
            }
        }
        return f4765a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        if (this.f74a != null) {
            if (this.f74a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m55a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f74a.getOpenHmsPush() + " HW online switch : " + h.m116a(this.f73a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f73a))));
            }
            if (this.f74a.getOpenHmsPush() && h.m116a(this.f73a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f73a))) {
                if (!m112a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f73a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m112a(d.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m111a(d.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f74a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m55a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f74a.getOpenFCMPush() + " FCM online switch : " + h.m116a(this.f73a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m119a(this.f73a)));
            }
            if (this.f74a.getOpenFCMPush() && h.m116a(this.f73a, d.ASSEMBLE_PUSH_FCM) && m.m119a(this.f73a)) {
                if (!m112a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f73a, d.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m112a(d.ASSEMBLE_PUSH_FCM) && (a3 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m111a(d.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f74a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m55a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f74a.getOpenCOSPush() + " COS online switch : " + h.m116a(this.f73a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f73a)));
            }
            if (this.f74a.getOpenCOSPush() && h.m116a(this.f73a, d.ASSEMBLE_PUSH_COS) && m.b(this.f73a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f73a, d.ASSEMBLE_PUSH_COS));
            } else if (m112a(d.ASSEMBLE_PUSH_COS) && (a4 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m111a(d.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f74a.getOpenFTOSPush() && h.m116a(this.f73a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f73a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f73a, d.ASSEMBLE_PUSH_FTOS));
            } else if (!m112a(d.ASSEMBLE_PUSH_FTOS) || (a5 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m111a(d.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f75a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f74a = pushConfiguration;
        this.f76a = com.xiaomi.push.service.ak.a(this.f73a).a(hr.AggregatePushSwitch.a(), true);
        if (this.f74a.getOpenHmsPush() || this.f74a.getOpenFCMPush() || this.f74a.getOpenCOSPush()) {
            com.xiaomi.push.service.ak.a(this.f73a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m111a(d dVar) {
        this.f75a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f75a.containsKey(dVar)) {
                this.f75a.remove(dVar);
            }
            this.f75a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m112a(d dVar) {
        return this.f75a.containsKey(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(d dVar) {
        boolean z = false;
        switch (g.f4767a[dVar.ordinal()]) {
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
        com.xiaomi.channel.commonutils.logger.b.m55a("ASSEMBLE_PUSH : assemble push register");
        if (this.f75a.size() <= 0) {
            a();
        }
        if (this.f75a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f75a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m113a(this.f73a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m55a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f75a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f75a.clear();
    }
}
