package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.model.SubscribeAppInfo;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d implements Runnable {
    final /* synthetic */ LocalAliasTagsManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LocalAliasTagsManager localAliasTagsManager) {
        this.a = localAliasTagsManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        ISubscribeAppTagManager iSubscribeAppTagManager;
        ISubscribeAppTagManager iSubscribeAppTagManager2;
        boolean z = true;
        boolean z2 = false;
        iSubscribeAppAliasManager = this.a.mSubscribeAppAliasManager;
        SubscribeAppInfo retrySubscribeAppInfo = iSubscribeAppAliasManager.getRetrySubscribeAppInfo();
        if (retrySubscribeAppInfo != null) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (retrySubscribeAppInfo.getTargetStatus() == 1) {
                m.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, retrySubscribeAppInfo.getName());
                z2 = true;
            } else {
                if (retrySubscribeAppInfo.getTargetStatus() == 2) {
                    m.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, retrySubscribeAppInfo.getName());
                }
                z2 = true;
            }
        }
        iSubscribeAppTagManager = this.a.mSubscribeAppTagManager;
        ArrayList<String> retrySubscribeAppInfo2 = iSubscribeAppTagManager.getRetrySubscribeAppInfo();
        if (retrySubscribeAppInfo2 != null && retrySubscribeAppInfo2.size() > 0) {
            if (z2) {
                z = z2;
            } else {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            m.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, retrySubscribeAppInfo2);
            z2 = z;
        }
        iSubscribeAppTagManager2 = this.a.mSubscribeAppTagManager;
        ArrayList<String> retryUnsubscribeAppInfo = iSubscribeAppTagManager2.getRetryUnsubscribeAppInfo();
        if (retryUnsubscribeAppInfo != null && retryUnsubscribeAppInfo.size() > 0) {
            if (!z2) {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
            m.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, retryUnsubscribeAppInfo);
        }
    }
}
