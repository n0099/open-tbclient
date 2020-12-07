package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f4452a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.f4452a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.f4452a != null && this.f4452a.size() > 0) {
            iSubscribeAppAliasManager = this.b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.delAliasSuccess((String) this.f4452a.get(0));
        }
    }
}
