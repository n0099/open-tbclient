package com.coloros.mcssdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.mapapi.UIMsg;
import com.baidu.webkit.internal.Statistics;
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
        List<com.coloros.mcssdk.b.c> bSj = a.bSk().bSj();
        if (j == null || j.size() == 0 || bSj == null || bSj.size() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        for (com.coloros.mcssdk.e.c cVar : j) {
            if (cVar != null) {
                for (com.coloros.mcssdk.b.c cVar2 : bSj) {
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
        if (a.bSk().bSl() == null) {
            return;
        }
        switch (bVar.getCommand()) {
            case UIMsg.k_event.MV_MAP_CACHEMANAGE /* 12289 */:
                a.bSk().bSl().onRegister(bVar.getResponseCode(), bVar.getContent());
                if (bVar.getResponseCode() == 0) {
                    a.bSk().yN(bVar.getContent());
                    return;
                }
                return;
            case 12290:
                a.bSk().bSl().onUnRegister(bVar.getResponseCode());
                return;
            case 12291:
            case 12299:
            case 12300:
            case Statistics.kTypeWhiteScreenForAsyncSearch /* 12304 */:
            case 12305:
            case 12307:
            case 12308:
            default:
                return;
            case 12292:
                a.bSk().bSl().onSetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12293:
                a.bSk().bSl().onGetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12294:
                a.bSk().bSl().onUnsetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12295:
                a.bSk().bSl().onSetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12296:
                a.bSk().bSl().onGetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12297:
                a.bSk().bSl().onUnsetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12298:
                a.bSk().bSl().onSetPushTime(bVar.getResponseCode(), bVar.getContent());
                return;
            case 12301:
                a.bSk().bSl().onSetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case Statistics.kTypeWhiteScreen /* 12302 */:
                a.bSk().bSl().onGetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12303:
                a.bSk().bSl().onUnsetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12306:
                a.bSk().bSl().onGetPushStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
            case 12309:
                a.bSk().bSl().onGetNotificationStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
        }
    }

    @Override // com.coloros.mcssdk.d.a
    public void processMessage(Context context, com.coloros.mcssdk.e.d dVar) {
    }
}
