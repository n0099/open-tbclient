package com.coloros.mcssdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.coloros.mcssdk.c.d;
import java.util.List;
/* loaded from: classes3.dex */
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
        List<com.coloros.mcssdk.b.c> bKU = a.bKV().bKU();
        if (j == null || j.size() == 0 || bKU == null || bKU.size() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        for (com.coloros.mcssdk.e.c cVar : j) {
            if (cVar != null) {
                for (com.coloros.mcssdk.b.c cVar2 : bKU) {
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
        if (a.bKV().bKW() == null) {
            return;
        }
        switch (bVar.fB()) {
            case 12289:
                a.bKV().bKW().onRegister(bVar.getResponseCode(), bVar.getContent());
                if (bVar.getResponseCode() == 0) {
                    a.bKV().wo(bVar.getContent());
                    return;
                }
                return;
            case 12290:
                a.bKV().bKW().onUnRegister(bVar.getResponseCode());
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
                a.bKV().bKW().onSetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12293:
                a.bKV().bKW().onGetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12294:
                a.bKV().bKW().onUnsetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12295:
                a.bKV().bKW().onSetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12296:
                a.bKV().bKW().onGetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12297:
                a.bKV().bKW().onUnsetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12298:
                a.bKV().bKW().onSetPushTime(bVar.getResponseCode(), bVar.getContent());
                return;
            case 12301:
                a.bKV().bKW().onSetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12302:
                a.bKV().bKW().onGetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12303:
                a.bKV().bKW().onUnsetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12306:
                a.bKV().bKW().onGetPushStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
            case 12309:
                a.bKV().bKW().onGetNotificationStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
        }
    }

    @Override // com.coloros.mcssdk.d.a
    public void processMessage(Context context, com.coloros.mcssdk.e.d dVar) {
    }
}
