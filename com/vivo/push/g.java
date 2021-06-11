package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.model.SubscribeAppInfo;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40309a;

    public g(LocalAliasTagsManager localAliasTagsManager) {
        this.f40309a = localAliasTagsManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        boolean z;
        ISubscribeAppTagManager iSubscribeAppTagManager;
        ISubscribeAppTagManager iSubscribeAppTagManager2;
        iSubscribeAppAliasManager = this.f40309a.mSubscribeAppAliasManager;
        SubscribeAppInfo retrySubscribeAppInfo = iSubscribeAppAliasManager.getRetrySubscribeAppInfo();
        boolean z2 = true;
        if (retrySubscribeAppInfo != null) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (retrySubscribeAppInfo.getTargetStatus() == 1) {
                p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, retrySubscribeAppInfo.getName());
            } else if (retrySubscribeAppInfo.getTargetStatus() == 2) {
                p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, retrySubscribeAppInfo.getName());
            }
            z = true;
        } else {
            z = false;
        }
        iSubscribeAppTagManager = this.f40309a.mSubscribeAppTagManager;
        ArrayList<String> retrySubscribeAppInfo2 = iSubscribeAppTagManager.getRetrySubscribeAppInfo();
        if (retrySubscribeAppInfo2 != null && retrySubscribeAppInfo2.size() > 0) {
            if (z) {
                z2 = z;
            } else {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, retrySubscribeAppInfo2);
            z = z2;
        }
        iSubscribeAppTagManager2 = this.f40309a.mSubscribeAppTagManager;
        ArrayList<String> retryUnsubscribeAppInfo = iSubscribeAppTagManager2.getRetryUnsubscribeAppInfo();
        if (retryUnsubscribeAppInfo == null || retryUnsubscribeAppInfo.size() <= 0) {
            return;
        }
        if (!z) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
        }
        p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, retryUnsubscribeAppInfo);
    }
}
