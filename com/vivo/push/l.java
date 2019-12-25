package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class l implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.a != null && this.a.size() > 0) {
            iSubscribeAppAliasManager = this.b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.delAliasSuccess((String) this.a.get(0));
        }
    }
}
