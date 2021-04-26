package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes6.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37457a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f37458b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f37458b = localAliasTagsManager;
        this.f37457a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f37458b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f37457a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f37457a);
        }
    }
}
