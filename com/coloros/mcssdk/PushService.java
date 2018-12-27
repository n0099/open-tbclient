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
        List<com.coloros.mcssdk.b.c> bTa = a.bTb().bTa();
        if (j == null || j.size() == 0 || bTa == null || bTa.size() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        for (com.coloros.mcssdk.e.c cVar : j) {
            if (cVar != null) {
                for (com.coloros.mcssdk.b.c cVar2 : bTa) {
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
        if (a.bTb().bTc() == null) {
            return;
        }
        switch (bVar.getCommand()) {
            case UIMsg.k_event.MV_MAP_CACHEMANAGE /* 12289 */:
                a.bTb().bTc().onRegister(bVar.getResponseCode(), bVar.getContent());
                if (bVar.getResponseCode() == 0) {
                    a.bTb().yQ(bVar.getContent());
                    return;
                }
                return;
            case 12290:
                a.bTb().bTc().onUnRegister(bVar.getResponseCode());
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
                a.bTb().bTc().onSetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12293:
                a.bTb().bTc().onGetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12294:
                a.bTb().bTc().onUnsetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12295:
                a.bTb().bTc().onSetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12296:
                a.bTb().bTc().onGetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12297:
                a.bTb().bTc().onUnsetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12298:
                a.bTb().bTc().onSetPushTime(bVar.getResponseCode(), bVar.getContent());
                return;
            case 12301:
                a.bTb().bTc().onSetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case Statistics.kTypeWhiteScreen /* 12302 */:
                a.bTb().bTc().onGetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12303:
                a.bTb().bTc().onUnsetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.r(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12306:
                a.bTb().bTc().onGetPushStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
            case 12309:
                a.bTb().bTc().onGetNotificationStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
        }
    }

    @Override // com.coloros.mcssdk.d.a
    public void processMessage(Context context, com.coloros.mcssdk.e.d dVar) {
    }
}
