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
        List<com.coloros.mcssdk.b.c> bPv = a.bPw().bPv();
        if (j == null || j.size() == 0 || bPv == null || bPv.size() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        for (com.coloros.mcssdk.e.c cVar : j) {
            if (cVar != null) {
                for (com.coloros.mcssdk.b.c cVar2 : bPv) {
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
        if (a.bPw().bPx() == null) {
            return;
        }
        switch (bVar.kI()) {
            case 12289:
                a.bPw().bPx().onRegister(bVar.getResponseCode(), bVar.getContent());
                if (bVar.getResponseCode() == 0) {
                    a.bPw().vk(bVar.getContent());
                    return;
                }
                return;
            case 12290:
                a.bPw().bPx().onUnRegister(bVar.getResponseCode());
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
                a.bPw().bPx().onSetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12293:
                a.bPw().bPx().onGetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12294:
                a.bPw().bPx().onUnsetAliases(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "alias", "aliasId", "aliasName"));
                return;
            case 12295:
                a.bPw().bPx().onSetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12296:
                a.bPw().bPx().onGetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12297:
                a.bPw().bPx().onUnsetTags(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "tagId", "tagName"));
                return;
            case 12298:
                a.bPw().bPx().onSetPushTime(bVar.getResponseCode(), bVar.getContent());
                return;
            case 12301:
                a.bPw().bPx().onSetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12302:
                a.bPw().bPx().onGetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12303:
                a.bPw().bPx().onUnsetUserAccounts(bVar.getResponseCode(), com.coloros.mcssdk.e.b.q(bVar.getContent(), "tags", "accountId", "accountName"));
                return;
            case 12306:
                a.bPw().bPx().onGetPushStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
            case 12309:
                a.bPw().bPx().onGetNotificationStatus(bVar.getResponseCode(), d.a(bVar.getContent()));
                return;
        }
    }

    @Override // com.coloros.mcssdk.d.a
    public void processMessage(Context context, com.coloros.mcssdk.e.d dVar) {
    }
}
