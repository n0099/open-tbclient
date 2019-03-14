package com.coloros.mcssdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.mapapi.UIMsg;
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
        List<com.coloros.mcssdk.e.c> k = com.coloros.mcssdk.a.c.k(getApplicationContext(), intent);
        List<com.coloros.mcssdk.b.c> csT = a.csU().csT();
        if (k == null || k.size() == 0 || csT == null || csT.size() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        for (com.coloros.mcssdk.e.c cVar : k) {
            if (cVar != null) {
                for (com.coloros.mcssdk.b.c cVar2 : csT) {
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
        if (a.csU().csV() == null) {
            return;
        }
        switch (bVar.getCommand()) {
            case UIMsg.k_event.MV_MAP_CACHEMANAGE /* 12289 */:
                a.csU().csV().onRegister(bVar.getResponseCode(), bVar.getContent());
                if (bVar.getResponseCode() == 0) {
                    a.csU().Fj(bVar.getContent());
                    return;
                }
                return;
            case 12290:
                a.csU().csV().onUnRegister(bVar.getResponseCode());
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
                a.csU().csV().onSetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12293:
                a.csU().csV().onGetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12294:
                a.csU().csV().onUnsetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12295:
                a.csU().csV().onSetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12296:
                a.csU().csV().onGetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12297:
                a.csU().csV().onUnsetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12298:
                a.csU().csV().onSetPushTime(bVar.getResponseCode(), bVar.getContent());
                return;
            case 12301:
                a.csU().csV().onSetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12302:
                a.csU().csV().onGetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12303:
                a.csU().csV().onUnsetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.v(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12306:
                a.csU().csV().onGetPushStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
            case 12309:
                a.csU().csV().onGetNotificationStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
        }
    }

    @Override // com.coloros.mcssdk.d.a
    public void processMessage(Context context, com.coloros.mcssdk.e.d dVar) {
    }
}
