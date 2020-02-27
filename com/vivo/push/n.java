package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.a != null && this.a.size() > 0) {
            iSubscribeAppAliasManager = this.b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.setAliasSuccess((String) this.a.get(0));
        }
    }
}
