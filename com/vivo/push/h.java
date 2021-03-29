package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39470a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39471b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f39471b = localAliasTagsManager;
        this.f39470a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f39471b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f39470a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f39470a);
        }
    }
}
