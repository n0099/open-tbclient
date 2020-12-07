package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4448a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.b = localAliasTagsManager;
        this.f4448a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f4448a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f4448a);
        }
    }
}
