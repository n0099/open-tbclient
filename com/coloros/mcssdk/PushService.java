package com.coloros.mcssdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.coloros.mcssdk.c.d;
import java.util.List;
/* loaded from: classes2.dex */
public class PushService extends Service implements com.coloros.mcssdk.d.a {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        List<com.coloros.mcssdk.e.c> j = com.coloros.mcssdk.a.c.j(getApplicationContext(), intent);
        List<com.coloros.mcssdk.b.c> bJR = a.bJS().bJR();
        if (j == null || j.size() == 0 || bJR == null || bJR.size() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        for (com.coloros.mcssdk.e.c cVar : j) {
            if (cVar != null) {
                for (com.coloros.mcssdk.b.c cVar2 : bJR) {
                    if (cVar2 != null) {
                        try {
                            cVar2.a(getApplicationContext(), cVar, this);
                        } catch (Exception e) {
                            com.coloros.mcssdk.c.c.b("process Exception:" + e.getMessage());
                        }
                    }
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.coloros.mcssdk.d.a
    public void processMessage(Context context, com.coloros.mcssdk.e.a aVar) {
    }

    @Override // com.coloros.mcssdk.d.a
    public void processMessage(Context context, com.coloros.mcssdk.e.b bVar) {
        if (a.bJS().bJT() == null) {
            return;
        }
        switch (bVar.kI()) {
            case 12289:
                a.bJS().bJT().onRegister(bVar.getResponseCode(), bVar.getContent());
                if (bVar.getResponseCode() == 0) {
                    a.bJS().uS(bVar.getContent());
                    return;
                }
                return;
            case 12290:
                a.bJS().bJT().onUnRegister(bVar.getResponseCode());
                return;
            case 12291:
            case 12299:
            case 12300:
            case 12304:
            case 12305:
            case 12307:
            case 12308:
            default:
                return;
            case 12292:
                a.bJS().bJT().onSetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12293:
                a.bJS().bJT().onGetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12294:
                a.bJS().bJT().onUnsetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12295:
                a.bJS().bJT().onSetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12296:
                a.bJS().bJT().onGetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12297:
                a.bJS().bJT().onUnsetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12298:
                a.bJS().bJT().onSetPushTime(bVar.getResponseCode(), bVar.getContent());
                return;
            case 12301:
                a.bJS().bJT().onSetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12302:
                a.bJS().bJT().onGetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12303:
                a.bJS().bJT().onUnsetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12306:
                a.bJS().bJT().onGetPushStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
            case 12309:
                a.bJS().bJT().onGetNotificationStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
        }
    }

    @Override // com.coloros.mcssdk.d.a
    public void processMessage(Context context, com.coloros.mcssdk.e.d dVar) {
    }
}
