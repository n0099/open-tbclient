package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40413a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40414b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f40414b = localAliasTagsManager;
        this.f40413a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f40414b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f40413a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f40413a);
        }
    }
}
