package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4444a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.b = localAliasTagsManager;
        this.f4444a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f4444a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f4444a);
        }
    }
}
