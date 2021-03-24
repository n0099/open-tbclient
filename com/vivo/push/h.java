package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39469a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39470b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f39470b = localAliasTagsManager;
        this.f39469a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f39470b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f39469a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f39469a);
        }
    }
}
