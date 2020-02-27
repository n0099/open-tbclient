package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.b = localAliasTagsManager;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.a);
        }
    }
}
