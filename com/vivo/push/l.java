package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f4680a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.f4680a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.f4680a != null && this.f4680a.size() > 0) {
            iSubscribeAppAliasManager = this.b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.delAliasSuccess((String) this.f4680a.get(0));
        }
    }
}
