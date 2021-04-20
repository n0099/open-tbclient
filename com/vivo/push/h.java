package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39759a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39760b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f39760b = localAliasTagsManager;
        this.f39759a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f39760b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f39759a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f39759a);
        }
    }
}
