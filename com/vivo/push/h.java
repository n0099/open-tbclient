package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40310a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40311b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f40311b = localAliasTagsManager;
        this.f40310a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f40311b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f40310a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f40310a);
        }
    }
}
